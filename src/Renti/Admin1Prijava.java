package Renti;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Admin1Prijava {

	JFrame frame;
	private JPasswordField AdminPassword;
	private final String password = "12345678"; 
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin1Prijava window = new Admin1Prijava();
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
	public Admin1Prijava() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		AdminPassword = new JPasswordField();
		AdminPassword.setBounds(309, 213, 144, 26);
		frame.getContentPane().add(AdminPassword);
		
		JButton btnNewButton = new JButton("Prijavi Se");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                String provjeraPasa = new String(AdminPassword.getPassword());  
                
                if (provjeraPasa.equals(password)) {
                    // Ako se upise tocna sifra otvori se Main menu od Administratora
                	JOptionPane.showMessageDialog(null, "Uspješna prijava!", "Renti", JOptionPane.INFORMATION_MESSAGE);
                    Admin2MainMenu AdminMainMenuWindow = new Admin2MainMenu();
                    AdminMainMenuWindow.frame.setVisible(true); 
                    frame.dispose();
                } else {
                    // Ako se upise netocna sifra prikaz ispisa
                	JOptionPane.showMessageDialog(null, "Pogrešna lozinka!", "Renti", JOptionPane.INFORMATION_MESSAGE);
      
                }
            
			}
		});
		btnNewButton.setBounds(280, 254, 195, 69);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Prijava administratora");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(249, 92, 365, 35);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Admin1Prijava.class.getResource("/Slike/RentiLogo.png")));
		lblNewLabel_1.setBounds(655, 479, 161, 87);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Lozinka : ");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(220, 218, 77, 16);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
