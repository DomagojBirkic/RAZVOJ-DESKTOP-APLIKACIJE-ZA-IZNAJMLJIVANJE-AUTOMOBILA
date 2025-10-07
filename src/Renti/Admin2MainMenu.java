package Renti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Admin2MainMenu {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin2MainMenu window = new Admin2MainMenu();
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
	public Admin2MainMenu() {
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
		
		JButton btnNewButton = new JButton("Pregled automobila");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				// Otvara se pregled automobila
				Admin3PregledAutomobila AutoWindowPregled = new Admin3PregledAutomobila();
				AutoWindowPregled.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			
			
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(111, 89, 195, 81);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dodavanje");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Otvara se prozor za dodavanje autombila
				Admin4Dodavanje DodavanjeWindow = new Admin4Dodavanje();
				DodavanjeWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(111, 191, 195, 81);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Pregled korisnika");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				// Otvara se prozor za pregled svih korisnika
				Admin6PregledKorisnika PregledKorWindow = new Admin6PregledKorisnika();
				PregledKorWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			
			
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(431, 89, 195, 81);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Uređivanje");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				// Otvara se prozor za uređivanje auta
				Admin5UredivanjeiBrisanje BrisanjeWindow = new Admin5UredivanjeiBrisanje();
				BrisanjeWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			
			
			}
		});
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setBounds(111, 284, 195, 81);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Glavni Izbornik Administratora");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(199, 0, 548, 71);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Admin2MainMenu.class.getResource("/Slike/RentiLogo.png")));
		lblNewLabel_1.setBounds(681, 442, 113, 124);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Pregled rezervacija");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Otvara se prozor za pregled rezervacija
				Admin7PregledRezervacija RezervacijeWindow = new Admin7PregledRezervacija();
				RezervacijeWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBounds(429, 191, 197, 81);
		frame.getContentPane().add(btnNewButton_3);
	}
}
