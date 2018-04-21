import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class BodyPanel extends JPanel implements ActionListener {
  private JLabel source, key, target, sourceFile, keyFile, targetFile, status;
  private JButton sourceButton, keyButton, targetButton, encryptButton, decryptButton;
  private String sourceFileName, keyFileName, targetFileName;

  public BodyPanel() {
    setLayout(null);
    setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    initLabel();
    initButton();
    setLocation(20,105);
    setSize(675,300);
  }

  public void initLabel() {
    source = new JLabel("Source         :");
    source.setHorizontalAlignment(SwingConstants.LEFT);
    source.setSize(220,20);
    source.setFont(new Font("Calibri",0,20));
    source.setHorizontalTextPosition(SwingConstants.CENTER);
    source.setVerticalTextPosition(SwingConstants.CENTER);
    source.setLocation(30,70);
    add(source);

    key = new JLabel("Key              :");
    key.setHorizontalAlignment(SwingConstants.LEFT);
    key.setSize(220,20);
    key.setFont(new Font("Calibri",0,20));
    key.setHorizontalTextPosition(SwingConstants.CENTER);
    key.setVerticalTextPosition(SwingConstants.CENTER);
    key.setLocation(30,120);
    add(key);

    target = new JLabel("Target         :");
    target.setHorizontalAlignment(SwingConstants.LEFT);
    target.setSize(220,20);
    target.setFont(new Font("Calibri",0,20));
    target.setHorizontalTextPosition(SwingConstants.CENTER);
    target.setVerticalTextPosition(SwingConstants.CENTER);
    target.setLocation(30,170);            
    add(target);

    sourceFile = new JLabel("");
    //sourceFile.setSize(source.getPreferredSize());
    sourceFile.setLocation(160,70);
    sourceFile.setSize(300,20);
    add(sourceFile);

    keyFile = new JLabel("");
    //sourceFile.setSize(source.getPreferredSize());
    keyFile.setLocation(160,120);
    keyFile.setSize(300,20);
    add(keyFile);

    targetFile = new JLabel("");
    //targetFile.setSize(source.getPreferredSize());
    targetFile.setLocation(160,170);
    targetFile.setSize(300,20);
    add(targetFile);

    status = new JLabel("");
    status.setLocation(270,260);
    status.setSize(220,20);
    add(status);
  }

  public void initButton() {
    sourceButton = new JButton("Source");
    sourceButton.setSize(120,20);
    sourceButton.setLocation(500,70);
    sourceButton.addActionListener(this);
    add(sourceButton);
    
    keyButton = new JButton("Key");
    keyButton.setSize(120,20);
    keyButton.setLocation(500,120);
    keyButton.addActionListener(this);
    add(keyButton);

    targetButton = new JButton("Target");
    targetButton.setSize(120,20);
    targetButton.setLocation(500,170);
    targetButton.addActionListener(this);
    add(targetButton);

    encryptButton = new JButton("Enkripsi");
    encryptButton.setSize(100,20);
    encryptButton.setLocation(350,230);
    encryptButton.addActionListener(this);
    add(encryptButton);

    decryptButton = new JButton("Dekripsi");
    decryptButton.setSize(100,20);
    decryptButton.setLocation(190,230);
    decryptButton.addActionListener(this);
    add(decryptButton);
  }

  public void actionPerformed(ActionEvent action) {
    if ( action.getSource() == sourceButton ) {
      OpenFile openFile = new OpenFile();
      sourceFileName = openFile.filePath;
      sourceFile.setText(sourceFileName);
    }
    else if ( action.getSource() == keyButton ) {
      OpenFile openFile = new OpenFile();
      keyFileName = openFile.filePath;
      keyFile.setText(keyFileName);
    }
    else if ( action.getSource() == targetButton ) {
      OpenFile openFile = new OpenFile();
      targetFileName = openFile.filePath;
      targetFile.setText(targetFileName);
    } 
    else if ( action.getSource() == encryptButton) {
      XTSAES encryption = new XTSAES(sourceFileName, keyFileName, targetFileName);
      try {
        String statusStr = encryption.setUpEncryption(sourceFileName, keyFileName, targetFileName);
        status.setText(statusStr);
      } catch (Exception ex) {
        Logger.getLogger(BodyPanel.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else if ( action.getSource() == decryptButton) {
      XTSAES decryption = new XTSAES(sourceFileName, keyFileName, targetFileName);
      try {
        String statusStr = decryption.setUpDecryption(sourceFileName, keyFileName, targetFileName);
        status.setText(statusStr);
      } catch (Exception ex) {
        Logger.getLogger(BodyPanel.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}