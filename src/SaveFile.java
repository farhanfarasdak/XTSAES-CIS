	import java.io.*;
	import javax.swing.JFileChooser;
	import javax.swing.JOptionPane;

public class SaveFile{
	JFileChooser fileChooser;
	File file;
	String filePath;
	public SaveFile() {
		fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		if ( result == JFileChooser.APPROVE_OPTION ){
			file = fileChooser.getSelectedFile();
			filePath = file.getPath();
		}
		else if ( result == JFileChooser.CANCEL_OPTION ){
			return;
		}
	}
} 