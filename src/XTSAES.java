import java.io.*;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;


public class XTSAES {
    private String SOURCE_FILE;
    private String KEY_FILE;
    private String TARGET_FILE;
    private static byte[] nonce = Util.hex2byte("12345678901234567890123456789012");

    public XTSAES (String sourceFile, String keyFile, String targetFile){
        this.SOURCE_FILE = sourceFile;
        this.KEY_FILE = keyFile;
        this.TARGET_FILE = targetFile;
    }

    public String setUpEncryption (String plaintextFile, String keyFile, String ciphertextFile) throws Exception{
        String keyStr;
        
        
        BufferedReader br = new BufferedReader(new FileReader(keyFile));
        keyStr = br.readLine();
        br.close();

        System.out.println("key\t= " + keyStr);
        byte[] byteKey = Util.hex2byte(keyStr);
        SecretKey key = new SecretKeySpec(byteKey, "AES");

        RandomAccessFile docPlaintext = new RandomAccessFile(plaintextFile, "r");
        byte[] plaintext = new byte[(int) docPlaintext.length()];
        docPlaintext.read(plaintext);
        
        RandomAccessFile docCiphertext = new RandomAccessFile(ciphertextFile, "rw");

        encrypt(plaintext, docCiphertext, key);

        docPlaintext.close();
        docCiphertext.close();

        System.out.println("Ecryption Done!");

        return "Encryption Done!";
    }

    public String setUpDecryption (String ciphertextFile, String keyFile, String plaintextFile) throws Exception{
        String keyStr;
        
        
        BufferedReader br = new BufferedReader(new FileReader(keyFile));
        keyStr = br.readLine();
        br.close();

        System.out.println("key\t= " + keyStr);
        byte[] byteKey = Util.hex2byte(keyStr);
        SecretKey key = new SecretKeySpec(byteKey, "AES");

        RandomAccessFile docCiphertext = new RandomAccessFile(ciphertextFile, "r");
        byte[] ciphertext = new byte[(int) docCiphertext.length()];
        docCiphertext.read(ciphertext);
        
        RandomAccessFile docPlaintext = new RandomAccessFile(plaintextFile, "rw");

        decrypt(ciphertext, docPlaintext, key);

        docPlaintext.close();
        docCiphertext.close();

        System.out.println("Decryption Done!");
        
        return "Decryption Done!";
    }

    public void encrypt(byte[] plaintext, RandomAccessFile docCiphertext, SecretKey key) throws Exception {
        byte[] ciphertext = null;

        System.out.println("Ecrypt..");

        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(nonce);
            final Cipher cipher = Cipher.getInstance("AES/CTS/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            ciphertext = cipher.doFinal(plaintext);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Write ciphertext..");

        
        docCiphertext.write(ciphertext);

    }

    public void decrypt(byte[] ciphertext, RandomAccessFile docPlaintext, SecretKey key) throws Exception {
        byte[] plaintext = null;

        System.out.println("Decrypt..");

        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(nonce);
            final Cipher cipher = Cipher.getInstance("AES/CTS/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            ciphertext = cipher.doFinal(ciphertext);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Write plaintext..");

        
        docPlaintext.write(ciphertext);

    }

    /*public byte[] decrypt(byte[] text) throws Exception {
        SecretKey aesKey = new SecretKeySpec(key, "AES");
        final Cipher cipher = Cipher.getInstance("AES/CTS/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(key));
        return cipher.doFinal(text);
    }*/
}