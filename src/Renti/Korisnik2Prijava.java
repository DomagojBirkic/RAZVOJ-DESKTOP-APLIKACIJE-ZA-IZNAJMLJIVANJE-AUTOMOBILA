package Renti;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Korisnik2Prijava {

    JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    
    private static String emailKorisnika;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Korisnik2Prijava window = new Korisnik2Prijava();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Korisnik2Prijava() {
        initialize();
    }

    private void initialize() {
     
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        emailField = new JTextField();
        emailField.setBounds(297, 180, 180, 26);
        frame.getContentPane().add(emailField);
        emailField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(297, 291, 180, 26);
        frame.getContentPane().add(passwordField);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setBounds(209, 185, 61, 16);
        frame.getContentPane().add(lblEmail);

        JLabel lblLozinka = new JLabel("Lozinka :");
        lblLozinka.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblLozinka.setForeground(Color.WHITE);
        lblLozinka.setBounds(209, 291, 61, 16);
        frame.getContentPane().add(lblLozinka);

        JButton btnPrijava = new JButton("Prijava");
        btnPrijava.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnPrijava.setForeground(Color.RED);
        btnPrijava.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Uzimanje vrijednosti iz polja koja korisnis unosi preko GUI-a
                String email = emailField.getText().trim();
                String lozinka = new String(passwordField.getPassword()).trim();
                // Provjera da su sva polja ispunjena
                if (email.isEmpty() || lozinka.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Molim unesite email i lozinku!", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                	// Spajanje na bazu
                    String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                    String user = "dbirkic";
                    String sifra = "11";

                    Connection veza = DriverManager.getConnection(url, user, sifra);
                    // Ovdje je prikazan SQL upit za provjeru korisnika, gdje se gleda dal taj korisnik postoji
                    String sql = "SELECT * FROM Korisnici WHERE Email = ? AND Lozinka = SHA2(?, 256)";
                    PreparedStatement naredba = veza.prepareStatement(sql);
                    naredba.setString(1, email);
                    naredba.setString(2, lozinka);
                    ResultSet rezultat = naredba.executeQuery();
                    // Ako korisnik postoji, uspješna prijava
                    if (rezultat.next()) {
                        String ime = rezultat.getString("Ime");
                        JOptionPane.showMessageDialog(frame, "Prijava uspješna!");
                        emailKorisnika = email; 
                        Korisnik3MainMenu mainMenu = new Korisnik3MainMenu(ime);
                        mainMenu.frame.setVisible(true);
                        frame.dispose();
                    } else {
                    	// Ako je upisana kriva lozinka ili mail, program baca poruku o grešci
                        JOptionPane.showMessageDialog(frame, "Pogrešan email ili lozinka!", "Greška", JOptionPane.ERROR_MESSAGE);
                    }

                    veza.close();
                } catch (Exception ex) {
                	// Ako se korisniku prekine internetska veza prikazat će se ova poruka
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Greška pri spajanju na bazu!", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnPrijava.setBounds(297, 351, 180, 43);
        frame.getContentPane().add(btnPrijava);

        lblNewLabel = new JLabel("Rentigo");
        lblNewLabel.setBounds(358, 250, 61, 16);
        frame.getContentPane().add(lblNewLabel);

        btnNewButton = new JButton("Natrag");
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton.setForeground(Color.RED);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                A1PocetnaStranica PocetnaWindow = new A1PocetnaStranica();
                PocetnaWindow.frame.setVisible(true);
                frame.dispose();
            }
        });
        btnNewButton.setBounds(6, 6, 117, 29);
        frame.getContentPane().add(btnNewButton);
        
        lblNewLabel_1 = new JLabel("Prijava");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(277, 125, 200, 43);
        frame.getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(Korisnik2Prijava.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_2.setBounds(667, 434, 127, 132);
        frame.getContentPane().add(lblNewLabel_2);
    }
    public static String EmailSave() {
        return emailKorisnika;
    }
}
