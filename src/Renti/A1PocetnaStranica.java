 package Renti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;




import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class A1PocetnaStranica {

	static JFrame frame;
	private JTextArea txtrNatpis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A1PocetnaStranica window = new A1PocetnaStranica();
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
	public A1PocetnaStranica() {
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
		
		txtrNatpis = new JTextArea();
		txtrNatpis.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		txtrNatpis.setForeground(Color.WHITE);
		txtrNatpis.setBackground(Color.BLACK);
		txtrNatpis.setWrapStyleWord(true);
		txtrNatpis.setLineWrap(true);
		txtrNatpis.setText("Ovdje smo da vam smanjimo stres pri putovanju.\nPronađite idealan automobil za svaku priliku, brzo i jednostavno.\nUživajte u vožnji, a mi ćemo se pobrinuti za ostalo!");
		txtrNatpis.setBounds(339, 211, 420, 229);
		frame.getContentPane().add(txtrNatpis);
		
		JButton btnNewButton = new JButton("Prijava administratora");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Otvara se prijava administratora
				Admin1Prijava AdminPrijavaWindow = new Admin1Prijava();
				AdminPrijavaWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			}
		});
		btnNewButton.setBounds(19, 344, 206, 61);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registracija");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Otvara se prijava korisnika
				Korisnik1Registracija KorisnikPrijavaWindow = new Korisnik1Registracija();
				KorisnikPrijavaWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(19, 201, 206, 58);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Prijava");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Otvara se prijava korisnika
				Korisnik2Prijava KorisnikLoginWindow = new Korisnik2Prijava();
				KorisnikLoginWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			
			}
		});
		btnNewButton_2.setBounds(19, 271, 206, 61);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Imaghe");
		ImageIcon originalIcon = new ImageIcon(A1PocetnaStranica.class.getResource("/Slike/RentiLogo.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(scaledImage));
		lblNewLabel_1.setBounds(660, 430, 172, 136);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(A1PocetnaStranica.class.getResource("/Slike/Natpis Renti.png")));
		lblNewLabel.setBounds(69, -21, 698, 237);
		frame.getContentPane().add(lblNewLabel);
	}
}
