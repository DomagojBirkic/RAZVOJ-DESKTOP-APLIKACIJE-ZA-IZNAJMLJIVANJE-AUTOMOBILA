package Renti;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Admin5UredivanjeiBrisanje {

    JFrame frame;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin5UredivanjeiBrisanje window = new Admin5UredivanjeiBrisanje();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Admin5UredivanjeiBrisanje() {
        initialize();
        TablicaAutomobiliSQL(); // Učitavanje podataka odmah
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(39, 69, 727, 271);
        frame.getContentPane().add(scrollPane);

        JButton btnObrisi = new JButton("Obriši");
        btnObrisi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnObrisi.setForeground(Color.RED);
        btnObrisi.setBounds(646, 343, 120, 30);
        frame.getContentPane().add(btnObrisi);
        
        JButton btnSpremi = new JButton("Spremi promjene");
        btnSpremi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnSpremi.setForeground(Color.RED);
        btnSpremi.setBounds(470, 344, 164, 29);
        frame.getContentPane().add(btnSpremi);
        
        JButton btnNewButton = new JButton("Natrag");
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

				// Otvara se main menu administratora
				Admin2MainMenu AdminMenuWindow = new Admin2MainMenu();
				AdminMenuWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
        	}
        });
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(6, 6, 117, 29);
        frame.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Automobili");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(337, 19, 141, 30);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(Admin5UredivanjeiBrisanje.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(659, 433, 153, 139);
        frame.getContentPane().add(lblNewLabel_1);

        
        btnObrisi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// dohvaćanje redka koji je klikniut u tablici
                int odabraniRedak = table.getSelectedRow();
                // Ako je neki redak odabran dohaćamo marku i model istog
                if (odabraniRedak != -1) {
                    String marka = table.getValueAt(odabraniRedak, 0).toString();
                    String model = table.getValueAt(odabraniRedak, 1).toString();

                    try {
                    	// Spajanje na bazu
                        String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                        String user = "dbirkic";
                        String sifra = "11";
                        // Upit za brisanje automobila 
                        Connection veza = DriverManager.getConnection(url, user, sifra);
                        String sql = "DELETE FROM Automobili WHERE Marka = ? AND Model = ?";
                        PreparedStatement naredba = veza.prepareStatement(sql);
                        naredba.setString(1, marka);
                        naredba.setString(2, model);
                        // izvršavanje upita
                        int izbrisaniRedak = naredba.executeUpdate();
                        // provjera je li auto iizbrisan
                        if (izbrisaniRedak > 0) {
                            TablicaAutomobiliSQL();
                            JOptionPane.showMessageDialog(frame, "Automobil je uspješno obrisan!");
                        }
                        // zatvaranje veze s basom
                        veza.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        // greška prilikom brisanja
                        JOptionPane.showMessageDialog(frame, "Greška pri brisanju automobila!", "Greška", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                	// Ako se ne odabere niti jedan automobil
                    JOptionPane.showMessageDialog(frame, "Odaberite automobil koji želite obrisati!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

       // Uređivanje
        btnSpremi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Dohvaćanje redka koji je odabran u tablici
                int odabraniRedak = table.getSelectedRow();
                // Ako je neki redak odabran
                if (odabraniRedak != -1) {
                	// Dohvaćamo sve podatke o označenom redku
                    String marka = table.getValueAt(odabraniRedak, 0).toString();
                    String model = table.getValueAt(odabraniRedak, 1).toString();
                    String godina = table.getValueAt(odabraniRedak, 2).toString();
                    String motor = table.getValueAt(odabraniRedak, 3).toString();
                    String mjenjac = table.getValueAt(odabraniRedak, 4).toString();
                    String kilometraza = table.getValueAt(odabraniRedak, 5).toString();
                    String cijena = table.getValueAt(odabraniRedak, 6).toString();
                    String snaga = table.getValueAt(odabraniRedak, 7).toString();

                    try {
                    	// Spajanje na bazu
                        String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                        String username = "dbirkic";
                        String password = "11";
                        // Upit za ažuriranje podataka
                        Connection veza = DriverManager.getConnection(url, username, password);
                        String sql = "UPDATE Automobili SET Godina=?, Motor=?, Mjenjac=?, Kilometraza=?, Cijena=?, Snaga=? WHERE Marka=? AND Model=?";
                        PreparedStatement naredba = veza.prepareStatement(sql);
                       // Postavljanje niovih vrijednosti u upit
                        naredba.setString(1, godina);
                        naredba.setString(2, motor);
                        naredba.setString(3, mjenjac);
                        naredba.setString(4, kilometraza);
                        naredba.setString(5, cijena);
                        naredba.setString(6, snaga);
                        naredba.setString(7, marka);
                        naredba.setString(8, model);
                        // Izvršavanje upita
                        naredba.executeUpdate();
                        // Osvježavanje tablice i obavijest korisniku
                        TablicaAutomobiliSQL(); 
                        JOptionPane.showMessageDialog(frame, "Promjene su uspješno spremljene!");
                        // Zatvaranje veze
                        veza.close();
                    } catch (Exception ex) {
                    	// Ako dođe do greške prilikom spremanja
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Greška pri spremanju promjena!", "Greška", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                	// Ako niti jedan redak nije odabran
                    JOptionPane.showMessageDialog(frame, "Odaberite automobil koji želite urediti!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void TablicaAutomobiliSQL() {
        try {
            String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
            String user = "dbirkic";
            String sifra = "11";

            Connection veza = DriverManager.getConnection(url, user, sifra);
            Statement naredba = veza.createStatement();
            String sql = "SELECT Marka, Model, Godina, Motor, Mjenjac, Kilometraza, Cijena, Snaga FROM Automobili";
            ResultSet rezultat = naredba.executeQuery(sql);

            DefaultTableModel model = new DefaultTableModel(
                new String[]{"Marka","Model","Godina","Motor","Mjenjac","Kilometraza","Cijena","Snaga"}, 0);

            while(rezultat.next()) {
                model.addRow(new Object[]{
                    rezultat.getString("Marka"),
                    rezultat.getString("Model"),
                    rezultat.getString("Godina"),
                    rezultat.getString("Motor"),
                    rezultat.getString("Mjenjac"),
                    rezultat.getString("Kilometraza"),
                    rezultat.getString("Cijena"),
                    rezultat.getString("Snaga")
                });
            }

            table.setModel(model);
            veza.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
