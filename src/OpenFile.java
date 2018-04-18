	import java.io.*;
	import javax.swing.JFileChooser;
	import javax.swing.JOptionPane;

public class OpenFile{
	JFileChooser files;
	File file;
	String filePath;
	public OpenFile() {
		files = new JFileChooser();
		int result = files.showOpenDialog(null);
		if ( result == JFileChooser.APPROVE_OPTION ){
			file = files.getSelectedFile();
			filePath = file.getPath();
		}
		else if ( result == JFileChooser.CANCEL_OPTION ){
			return;
		}
	}
} 