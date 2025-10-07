package Renti;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Korisnik5MojeRezervacije {

    JFrame frame;
    private JTable table;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Korisnik5MojeRezervacije window = new Korisnik5MojeRezervacije();
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
    public Korisnik5MojeRezervacije() {
        initialize();
        TablicaRezerviraniAutomobili();
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

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(31, 85, 739, 311);
        frame.getContentPane().add(scrollPane);
        
        btnNewButton = new JButton("Natrag");
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {


                frame.dispose();
                Korisnik3MainMenu korMainWindow = new Korisnik3MainMenu();
                korMainWindow.frame.setVisible(true);
            
        	
        	}
        });
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(6, 22, 117, 29);
        frame.getContentPane().add(btnNewButton);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(Korisnik5MojeRezervacije.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel.setBounds(648, 458, 131, 97);
        frame.getContentPane().add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("Aktivne rezervacije");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(267, 27, 291, 48);
        frame.getContentPane().add(lblNewLabel_1);
    }

    private void TablicaRezerviraniAutomobili() {
        try {
            String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
            String user = "dbirkic";
            String sifra = "11";

            Connection veza = DriverManager.getConnection(url, user, sifra);

            // Dohvati email prijavljenih korisnika iz obje klase
            String email1 = Korisnik1Registracija.EmailSave();
            String email2 = Korisnik2Prijava.EmailSave();

            Statement naredba = veza.createStatement();
            String sql = "SELECT Naziv, Marka, Godina, Cijena, Datum_Rezervacije, Datum_Povratka, Email " +
                         "FROM RezerviraniAutomobili " +
                         "WHERE Email = '" + email1 + "' OR Email = '" + email2 + "'";

            ResultSet rezultat = naredba.executeQuery(sql);

            // Kreiraj model za tablicu
            DefaultTableModel model = new DefaultTableModel(
                new String[]{"Naziv","Marka","Godina","Cijena","Datum_Rezervacije","Datum_Povratka","Email"}, 0);

            while(rezultat.next()) {
                String naziv = rezultat.getString("Naziv");
                String marka = rezultat.getString("Marka");
                String godina = rezultat.getString("Godina");
                String cijena = rezultat.getString("Cijena");
                String datum_rezervacije = rezultat.getString("Datum_Rezervacije");
                String datum_povratka = rezultat.getString("Datum_Povratka");
                String email = rezultat.getString("Email");

                model.addRow(new Object[]{naziv, marka, godina, cijena, datum_rezervacije, datum_povratka, email});
            }

            table.setModel(model);
            veza.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}