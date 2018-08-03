import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.Registration;

public class Welcome {

	private JFrame frame;
	private JTextField txtAnOnlineBanking;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 634, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Batang", Font.BOLD, 14));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Registration reg = new Registration();
				reg.setVisible(true);
			}
		});
		btnNewButton.setBounds(34, 195, 150, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("Batang", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(227, 195, 150, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Administration");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("Batang", Font.BOLD, 14));
		btnNewButton_2.setBounds(420, 195, 150, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		txtAnOnlineBanking = new JTextField();
		txtAnOnlineBanking.setForeground(Color.WHITE);
		txtAnOnlineBanking.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnOnlineBanking.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		txtAnOnlineBanking.setText("Welcome to Bank BD");
		txtAnOnlineBanking.setBackground(new Color(0, 0, 128));
		txtAnOnlineBanking.setBounds(155, 85, 308, 58);
		frame.getContentPane().add(txtAnOnlineBanking);
		txtAnOnlineBanking.setColumns(10);
		
		
	}
}
