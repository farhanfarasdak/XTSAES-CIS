import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class HeaderPanel extends JPanel {
	private JLabel title;

	public HeaderPanel(){
		initTitle();
    setLayout(new GridLayout(1,1));
    setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    setLocation(10,10);
    setSize(675,80);
    setBackground(Color.PINK);
    add(title);
	}

	private void initTitle(){
		title = new JLabel("XTS-AES");
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setSize(680,40);
    title.setFont(new Font("Times New Roman",0,25));
    title.setForeground(Color.white);
    title.setHorizontalTextPosition(SwingConstants.CENTER);
    title.setVerticalTextPosition(SwingConstants.CENTER);
	}
}