package org.eclipse.wb.swing;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField txtEnterYourName;
	private JTextField txtEnterNomineeName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Registration() {
		dbconnection dbcon = new dbconnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistrationForm.setBounds(10, 11, 215, 30);
		contentPane.add(lblRegistrationForm);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 69, 80, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nominee :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 114, 80, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 150, 80, 25);
		contentPane.add(lblNewLabel_2);
		
		txtEnterYourName = new JTextField();
		txtEnterYourName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterYourName.setBounds(148, 66, 300, 25);
		contentPane.add(txtEnterYourName);
		txtEnterYourName.setColumns(10);
		
		txtEnterNomineeName = new JTextField();
		txtEnterNomineeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterNomineeName.setBounds(148, 111, 300, 25);
		contentPane.add(txtEnterNomineeName);
		txtEnterNomineeName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 201, 80, 25);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(148, 205, 300, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(147, 154, 150, 25);
		contentPane.add(comboBox);
		comboBox.addItem("Debit");
		comboBox.addItem("Credit");
		comboBox.addItem("Savings");
		comboBox.setSelectedIndex(0);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data =" ";
				if(comboBox.getSelectedIndex()!= -1){
				data = (String) comboBox.getItemAt(comboBox.getSelectedIndex());}
				String name = txtEnterYourName.getText();
				String nominee = txtEnterNomineeName.getText();
				String add = textField.getText();
				dbcon.insert(name, nominee, add,data);
				//JOptionPane.showMessageDialog(null, "Registration successfull");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(52, 320, 150, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(301, 323, 150, 25);
		contentPane.add(btnNewButton_1);
		
		
	}
}
