import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class BodyPanel extends JPanel {
  private JLabel source, key, target, sourceFile, keyFile, targetFile;
  private JButton sourceButton, keyButton, targetButton;

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

    target = new JLabel("Target       :");
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
  }

  public void initButton() {
    sourceButton = new JButton("Source");
    sourceButton.setSize(150,20);
    sourceButton.setLocation(400,70);
    //sourceButton.addActionListener(this);
    add(sourceButton);
    
    keyButton = new JButton("Key");
    keyButton.setSize(150,20);
    keyButton.setLocation(400,120);
    //keyButton.addActionListener(this);
    add(keyButton);

    targetButton = new JButton("Target");
    targetButton.setSize(150,20);
    targetButton.setLocation(400,170);
    //targetButton.addActionListener(this);
    add(targetButton);
  }
}