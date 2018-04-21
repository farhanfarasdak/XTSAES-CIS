import java.awt.Color;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	private HeaderPanel header = new HeaderPanel();
	private BodyPanel body = new BodyPanel();
	
	public MainFrame() {
        super( "Kriptografi dan Keamanan Jaringan - XTS AES" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLayout(null);
        setSize( 700, 520 );
        setBackground(Color.blue);
        setVisible( true );
        setBounds(0,0,720,450);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().add(header);
        getContentPane().add(body);
        setVisible(true);		
    }
}