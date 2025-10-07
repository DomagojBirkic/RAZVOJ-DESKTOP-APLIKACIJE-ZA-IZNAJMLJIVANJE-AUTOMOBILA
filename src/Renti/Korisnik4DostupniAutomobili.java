package Renti;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Korisnik4DostupniAutomobili {

    JFrame frame;
    private JTable table;
    private JComboBox comboBox;
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    private String korisnikEmail; 
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Korisnik4DostupniAutomobili window = new Korisnik4DostupniAutomobili();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public Korisnik4DostupniAutomobili() {
        initialize();

        if (Korisnik1Registracija.EmailSave() != null) {
            this.korisnikEmail = Korisnik1Registracija.EmailSave();
        }

        if (Korisnik2Prijava.EmailSave() != null) {
            this.korisnikEmail = Korisnik2Prijava.EmailSave();
        }

        TablicaAutomobiliSQL();
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
        scrollPane.setBounds(25, 49, 751, 258);
        frame.getContentPane().add(scrollPane);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "1 Dan", "2 Dana", "3 Dana", "4 Dana", "5 Dana", "6 Dana", "7 Dana" }));
        comboBox.setBounds(527, 326, 120, 27);
        frame.getContentPane().add(comboBox);

        lblNewLabel = new JLabel("Rezerviraj auto na : ");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(375, 330, 140, 16);
        frame.getContentPane().add(lblNewLabel);

        btnNewButton = new JButton("Rezerviraj");
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(659, 325, 117, 29);
        frame.getContentPane().add(btnNewButton);
        
        btnNewButton_1 = new JButton("Natrag");
        btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

                frame.dispose();
                Korisnik3MainMenu korMainWindow = new Korisnik3MainMenu();
                korMainWindow.frame.setVisible(true);
            
        	}
        });
        btnNewButton_1.setForeground(Color.RED);
        btnNewButton_1.setBounds(6, 8, 117, 29);
        frame.getContentPane().add(btnNewButton_1);
        
        lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(Korisnik4DostupniAutomobili.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(654, 460, 140, 106);
        frame.getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Dostupni automobili");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(297, 8, 233, 29);
        frame.getContentPane().add(lblNewLabel_2);
        btnNewButton.addActionListener(e -> rezervirajAutomobil());
    }

    
    private void TablicaAutomobiliSQL() {
        try {
            String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
            String user = "dbirkic";
            String sifra = "11";

            Connection veza = DriverManager.getConnection(url, user, sifra);
            Statement naredba = veza.createStatement();
            ResultSet rezultat = naredba.executeQuery("SELECT * FROM Automobili");

            DefaultTableModel model = new DefaultTableModel();
            // Dodavanje naziva stupaca (bez id)
            model.addColumn("Marka");
            model.addColumn("Model");
            model.addColumn("Godina");
            model.addColumn("Motor");
            model.addColumn("Mjenjac");
            model.addColumn("Kilometraza");
            model.addColumn("Snaga");
            model.addColumn("Cijena");

            while (rezultat.next()) {
                Object[] row = new Object[8];
                row[0] = rezultat.getString("Marka");
                row[1] = rezultat.getString("Model");
                row[2] = rezultat.getInt("Godina");
                row[3] = rezultat.getString("Motor");
                row[4] = rezultat.getString("Mjenjac");
                row[5] = rezultat.getInt("Kilometraza");
                row[6] = rezultat.getInt("Snaga");
                row[7] = rezultat.getBigDecimal("Cijena");
                model.addRow(row);
            }

            table.setModel(model);
            veza.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   // funkcija za rezerviranje
    private void rezervirajAutomobil() {
        int odabraniRedak = table.getSelectedRow();
        if (odabraniRedak == -1) {
            javax.swing.JOptionPane.showMessageDialog(frame, "Molimo odaberite automobil za rezervaciju!");
            return;
        }

        try {
            String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
            String user = "dbirkic";
            String sifra = "11";

            Connection veza = DriverManager.getConnection(url, user, sifra);
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Dohvati podatke odabranog automobila
            String marka = model.getValueAt(odabraniRedak, 0).toString();
            String naziv = model.getValueAt(odabraniRedak, 1).toString();
            int godina = Integer.parseInt(model.getValueAt(odabraniRedak, 2).toString());
            java.math.BigDecimal cijena = new java.math.BigDecimal(model.getValueAt(odabraniRedak, 7).toString());

            // Trajanje rezervacije
            String trajanje = comboBox.getSelectedItem().toString();
            int brojDana = Integer.parseInt(trajanje.split(" ")[0]);

            java.sql.Date datumRezervacije = new java.sql.Date(System.currentTimeMillis());
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(datumRezervacije);
            cal.add(java.util.Calendar.DAY_OF_MONTH, brojDana);
            java.sql.Date datumPovratka = new java.sql.Date(cal.getTimeInMillis());

            String email = this.korisnikEmail;

            // Ubacivanje u tablicu RezerviraniAutomobili
            String insertSql = "INSERT INTO RezerviraniAutomobili "
                    + "(Naziv, Marka, Godina, Cijena, Datum_Rezervacije, Datum_Povratka, Email) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement naredba = veza.prepareStatement(insertSql);
            naredba.setString(1, naziv);
            naredba.setString(2, marka);
            naredba.setInt(3, godina);
            naredba.setBigDecimal(4, cijena);
            naredba.setDate(5, datumRezervacije);
            naredba.setDate(6, datumPovratka);
            naredba.setString(7, email);

            int rowsInserted = naredba.executeUpdate();
            if (rowsInserted > 0) {
                // obriši iz tablice automobili
                String brisanje = "DELETE FROM Automobili WHERE Marka = ? AND Model = ? AND Godina = ?";
                java.sql.PreparedStatement delStmt = veza.prepareStatement(brisanje);
                delStmt.setString(1, marka);
                delStmt.setString(2, naziv);
                delStmt.setInt(3, godina);
                delStmt.executeUpdate();

                javax.swing.JOptionPane.showMessageDialog(frame, "Automobil je uspješno rezerviran!");
                TablicaAutomobiliSQL();
            }

            veza.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(frame, "Došlo je do pogreške prilikom rezervacije!");
        }
    }
}