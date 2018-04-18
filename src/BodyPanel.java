import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class BodyPanel extends JPanel implements ActionListener {
  private JLabel source, key, target, sourceFile, keyFile, targetFile;
  private JButton sourceButton, keyButton, targetButton, encryptButton, decryptButton;
  private String sourceFileName, keyFileName, targetFileName;

  public BodyPanel() {
    setLayout(null);
    setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    initLabel();
    initButton();
    setLocation(10,100);
    setSize(675,300);
  }

  public void initLabel() {
    source = new JLabel("Source         :");
    source.setHorizontalAlignment(SwingConstants.LEFT);
    source.setSize(220,20);
    source.setFont(new Font("Times New Roman",0,20));
    source.setHorizontalTextPosition(SwingConstants.CENTER);
    source.setVerticalTextPosition(SwingConstants.CENTER);
    source.setLocation(10,70);
    add(source);

    key = new JLabel("Key             :");
    key.setHorizontalAlignment(SwingConstants.LEFT);
    key.setSize(220,20);
    key.setFont(new Font("Times New Roman",0,20));
    key.setHorizontalTextPosition(SwingConstants.CENTER);
    key.setVerticalTextPosition(SwingConstants.CENTER);
    key.setLocation(10,120);
    add(key);

    target = new JLabel("Target         :");
    target.setHorizontalAlignment(SwingConstants.LEFT);
    target.setSize(220,20);
    target.setFont(new Font("Times New Roman",0,20));
    target.setHorizontalTextPosition(SwingConstants.CENTER);
    target.setVerticalTextPosition(SwingConstants.CENTER);
    target.setLocation(10,170);            
    add(target);

    sourceFile = new JLabel("yee");
    //sourceFile.setSize(source.getPreferredSize());
    sourceFile.setLocation(130,70);
    sourceFile.setSize(220,20);
    add(sourceFile);

    targetFile = new JLabel("yeetarget");
    //targetFile.setSize(source.getPreferredSize());
    targetFile.setLocation(130,170);
    targetFile.setSize(220,20);
    add(targetFile);
  }

  public void initButton() {
    sourceButton = new JButton("Source");
    sourceButton.setSize(150,20);
    sourceButton.setLocation(400,70);
    sourceButton.addActionListener(this);
    add(sourceButton);
    
    keyButton = new JButton("Key");
    keyButton.setSize(150,20);
    keyButton.setLocation(400,120);
    //keyButton.addActionListener(this);
    add(keyButton);

    targetButton = new JButton("Target");
    targetButton.setSize(150,20);
    targetButton.setLocation(400,170);
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
      //farhanCodeHere
      OpenFile openFile = new OpenFile();
      sourceFileName = openFile.filePath;
      sourceFile.setText(sourceFileName);
    }
    else if ( action.getSource() == keyButton ) {
      //irmaCodeHere
    }
    else if ( action.getSource() == targetButton ) {
      SaveFile saveFile = new SaveFile();
      targetFile.setText(saveFile.filePath);
    } 
    else if ( action.getSource() == encryptButton) {

    }
    else if ( action.getSource() == decryptButton) {

    }
  }
}