package Renti;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class Korisnik1Registracija {

    JFrame frame;
    private JTextField FieldIme;
    private JTextField FieldPrezime;
    private JTextField FieldEmail;
    private JPasswordField FieldLozinka;
    private JTextField FieldTelefon;
    private JTextField FieldGrad;
    private JTextField FieldAdresa;
    // Static stringovi da se moze prikazati ime i email prijavljenih korisnika u kasnijim prozorima
    private static String imeKorisnika;
    private static String prezimeKorisnika;
    private static String emailKorisnika;
    private static String telefonKorisnika;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Korisnik1Registracija window = new Korisnik1Registracija();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Korisnik1Registracija() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Registracija korisnika");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblTitle.setBounds(271, 121, 250, 25);
        frame.getContentPane().add(lblTitle);

        JLabel lblIme = new JLabel("Ime:");
        lblIme.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblIme.setForeground(Color.WHITE);
        lblIme.setBounds(189, 160, 80, 16);
        frame.getContentPane().add(lblIme);

        JLabel lblPrezime = new JLabel("Prezime:");
        lblPrezime.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblPrezime.setForeground(Color.WHITE);
        lblPrezime.setBounds(164, 195, 80, 16);
        frame.getContentPane().add(lblPrezime);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setBounds(175, 230, 80, 16);
        frame.getContentPane().add(lblEmail);

        JLabel lblLozinka = new JLabel("Lozinka:");
        lblLozinka.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblLozinka.setForeground(Color.WHITE);
        lblLozinka.setBounds(164, 268, 80, 16);
        frame.getContentPane().add(lblLozinka);

        JLabel lblTelefon = new JLabel("Telefon:");
        lblTelefon.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblTelefon.setForeground(Color.WHITE);
        lblTelefon.setBounds(164, 306, 80, 16);
        frame.getContentPane().add(lblTelefon);

        JLabel lblGrad = new JLabel("Grad:");
        lblGrad.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblGrad.setForeground(Color.WHITE);
        lblGrad.setBounds(183, 344, 61, 16);
        frame.getContentPane().add(lblGrad);

        JLabel lblAdresa = new JLabel("Adresa:");
        lblAdresa.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblAdresa.setForeground(Color.WHITE);
        lblAdresa.setBounds(183, 382, 61, 16);
        frame.getContentPane().add(lblAdresa);

        FieldIme = new JTextField();
        FieldIme.setBounds(256, 155, 200, 26);
        frame.getContentPane().add(FieldIme);
        FieldIme.setColumns(10);

        FieldPrezime = new JTextField();
        FieldPrezime.setBounds(256, 190, 200, 26);
        frame.getContentPane().add(FieldPrezime);
        FieldPrezime.setColumns(10);

        FieldEmail = new JTextField();
        FieldEmail.setBounds(256, 225, 200, 26);
        frame.getContentPane().add(FieldEmail);
        FieldEmail.setColumns(10);

        FieldLozinka = new JPasswordField();
        FieldLozinka.setBounds(256, 263, 200, 26);
        frame.getContentPane().add(FieldLozinka);

        FieldTelefon = new JTextField();
        FieldTelefon.setBounds(256, 301, 200, 26);
        frame.getContentPane().add(FieldTelefon);
        FieldTelefon.setColumns(10);

        FieldGrad = new JTextField();
        FieldGrad.setBounds(256, 339, 200, 26);
        frame.getContentPane().add(FieldGrad);
        FieldGrad.setColumns(10);

        FieldAdresa = new JTextField();
        FieldAdresa.setBounds(256, 377, 200, 26);
        frame.getContentPane().add(FieldAdresa);
        FieldAdresa.setColumns(10);

        JLabel lblNapomena = new JLabel("Napomena: Usluge se trenutno pružaju isključivo korisnicima u Rijeci");
        lblNapomena.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        lblNapomena.setForeground(Color.WHITE);
        lblNapomena.setBounds(6, 519, 450, 47);
        frame.getContentPane().add(lblNapomena);

        JButton btnPrijavi = new JButton("Registriraj se");
        btnPrijavi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnPrijavi.setBackground(Color.RED);
        btnPrijavi.setForeground(Color.RED);
        btnPrijavi.setBounds(256, 415, 200, 29);
        frame.getContentPane().add(btnPrijavi);

        btnPrijavi.addActionListener(e -> {
            try {
                String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                String user = "dbirkic";
                String sifra = "11";

                Connection veza = DriverManager.getConnection(url, user, sifra);

                String ime = FieldIme.getText().trim();
                String prezime = FieldPrezime.getText().trim();
                String email = FieldEmail.getText().trim();
                String lozinka = new String(FieldLozinka.getPassword()).trim();
                String telefon = FieldTelefon.getText().trim();
                String grad = FieldGrad.getText().trim();
                String adresa = FieldAdresa.getText().trim();

                if (ime.isEmpty() || prezime.isEmpty() || email.isEmpty() || lozinka.isEmpty()
                        || grad.isEmpty() || adresa.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Molimo popunite sva obavezna polja!", "Greška",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Ako se upise bilo koji grad osim Rijeka ili rijeka program baca gresku
                if (!grad.equalsIgnoreCase("Rijeka")) {
                    JOptionPane.showMessageDialog(null,
                            "Usluge se trenutno pružaju samo korisnicima koji se nalaze u gradu Rijeka.", "Greška",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Provjera postoji li korisnik
                String checkSql = "SELECT * FROM Korisnici WHERE Email = ?";
                PreparedStatement provjera = veza.prepareStatement(checkSql);
                provjera.setString(1, email);
                ResultSet rezultat = provjera.executeQuery();

                if (rezultat.next()) {
                    // Ako postoji, samo dohvatimo podatke
                    imeKorisnika = rezultat.getString("Ime");
                    prezimeKorisnika = rezultat.getString("Prezime");
                    emailKorisnika = rezultat.getString("Email");
                    telefonKorisnika = rezultat.getString("Telefon");

                    JOptionPane.showMessageDialog(null, "Dobrodošli natrag, " + imeKorisnika + "!",
                            "Prijava uspješna", JOptionPane.INFORMATION_MESSAGE);

                    Korisnik3MainMenu KorisnikMain = new Korisnik3MainMenu();
                    KorisnikMain.frame.setVisible(true);
                    frame.dispose();
                } else {
                    // Ako korisnik s tim mailom ne postoji, unosi se u bazu
                    String insertSql = "INSERT INTO Korisnici (Ime, Prezime, Email, Lozinka, Telefon, Grad, Adresa) VALUES (?, ?, ?, SHA2(?, 256), ?, ?, ?)";
                    PreparedStatement naredba = veza.prepareStatement(insertSql);
                    // Postavljanje vrijednosti za SQL upit
                    naredba.setString(1, ime);
                    naredba.setString(2, prezime);
                    naredba.setString(3, email);
                    naredba.setString(4, lozinka);
                    naredba.setString(5, telefon);
                    naredba.setString(6, grad);
                    naredba.setString(7, adresa);
                    // izvršavanje upita
                    int uneseniRedak = naredba.executeUpdate();
                    // Provjera dal je redak unesen
                    if (uneseniRedak > 0) {
                        JOptionPane.showMessageDialog(null, "Registracija uspješna! Dobrodošli, " + ime + "!",
                                "Uspjeh", JOptionPane.INFORMATION_MESSAGE);
                        // Spremanje podataka za daljnje korištenje u aplikacije
                        imeKorisnika = ime;
                        prezimeKorisnika = prezime;
                        emailKorisnika = email;
                        telefonKorisnika = telefon;
                        // Ovdje se otvara glavni izbornik korisnika i zatvara se trenutni window
                        Korisnik3MainMenu KorisnikMain = new Korisnik3MainMenu();
                        KorisnikMain.frame.setVisible(true);
                        frame.dispose();
                    } else {
                    	// Registracija neuspješna, program baca grešku
                        JOptionPane.showMessageDialog(null, "Došlo je do pogreške prilikom registracije!", "Greška",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                veza.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Greška u povezivanju s bazom!", "Greška",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnNatrag = new JButton("Natrag");
        btnNatrag.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNatrag.setBackground(Color.RED);
        btnNatrag.setForeground(Color.RED);
        btnNatrag.setBounds(0, 6, 117, 29);
        frame.getContentPane().add(btnNatrag);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Korisnik1Registracija.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel.setBounds(651, 449, 130, 117);
        frame.getContentPane().add(lblNewLabel);
        btnNatrag.addActionListener(e -> {
            frame.dispose();
            A1PocetnaStranica Pocetnawindow = new A1PocetnaStranica();
            try {
                A1PocetnaStranica.frame.setVisible(true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    // static string za hvatanje emaila iz drugih klasa
    public static String EmailSave() {
        return emailKorisnika;
    }
}

