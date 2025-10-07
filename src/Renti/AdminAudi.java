package Renti;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AdminAudi {

    JFrame frame;
    private JTextField AudiKMTF;
    private JTextField AudiCijenaTF;
    private JTextField AudiSnagaTF;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminAudi window = new AdminAudi();
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
    public AdminAudi() {
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
        
        JLabel lblNewLabel = new JLabel("Audi");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(308, 92, 120, 25);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel AudiModel = new JLabel("Model :");
        AudiModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiModel.setForeground(Color.WHITE);
        AudiModel.setBounds(257, 176, 61, 16);
        frame.getContentPane().add(AudiModel);
        
        JLabel AudiMotor = new JLabel("Motor : ");
        AudiMotor.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiMotor.setForeground(Color.WHITE);
        AudiMotor.setBounds(257, 216, 61, 16);
        frame.getContentPane().add(AudiMotor);
        
        JLabel AudiMjenjac = new JLabel("Mjenjač :");
        AudiMjenjac.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiMjenjac.setForeground(Color.WHITE);
        AudiMjenjac.setBounds(243, 293, 61, 16);
        frame.getContentPane().add(AudiMjenjac);
        
        JLabel AudiKM = new JLabel("Kilometraža : ");
        AudiKM.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiKM.setForeground(Color.WHITE);
        AudiKM.setBounds(223, 333, 95, 16);
        frame.getContentPane().add(AudiKM);
        
        JLabel AudiCijena = new JLabel("Cijena po danu : ");
        AudiCijena.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiCijena.setForeground(Color.WHITE);
        AudiCijena.setBounds(208, 371, 120, 16);
        frame.getContentPane().add(AudiCijena);
        
        JLabel AudiSnaga = new JLabel("Snaga (KS) : ");
        AudiSnaga.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiSnaga.setForeground(Color.WHITE);
        AudiSnaga.setBounds(223, 256, 86, 16);
        frame.getContentPane().add(AudiSnaga);
        
        JLabel AudiGodina = new JLabel("Godina proizvodnje :");
        AudiGodina.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiGodina.setForeground(Color.WHITE);
        AudiGodina.setBounds(175, 141, 143, 16);
        frame.getContentPane().add(AudiGodina);
        
        JComboBox AudiGodinaCB = new JComboBox();
        AudiGodinaCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiGodinaCB.setForeground(Color.RED);
        AudiGodinaCB.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
        AudiGodinaCB.setBounds(330, 137, 130, 27);
        frame.getContentPane().add(AudiGodinaCB);
        
        JComboBox AudiMotorCB = new JComboBox();
        AudiMotorCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiMotorCB.setForeground(Color.RED);
        AudiMotorCB.setModel(new DefaultComboBoxModel(new String[] {"Benzin", "Diezel", "Elektični"}));
        AudiMotorCB.setBounds(330, 212, 130, 27);
        frame.getContentPane().add(AudiMotorCB);
        
        JComboBox AudiMjenjacCB = new JComboBox();
        AudiMjenjacCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiMjenjacCB.setForeground(Color.RED);
        AudiMjenjacCB.setModel(new DefaultComboBoxModel(new String[] {"Automatski", "Manualni"}));
        AudiMjenjacCB.setBounds(330, 289, 130, 27);
        frame.getContentPane().add(AudiMjenjacCB);
        
        AudiKMTF = new JTextField();
        AudiKMTF.setBounds(330, 328, 130, 26);
        frame.getContentPane().add(AudiKMTF);
        AudiKMTF.setColumns(10);
        
        AudiCijenaTF = new JTextField();
        AudiCijenaTF.setBounds(330, 366, 130, 26);
        frame.getContentPane().add(AudiCijenaTF);
        AudiCijenaTF.setColumns(10);
        
        AudiSnagaTF = new JTextField();
        AudiSnagaTF.setBounds(330, 251, 130, 26);
        frame.getContentPane().add(AudiSnagaTF);
        AudiSnagaTF.setColumns(10);
        // Gumb za natrag
        JButton BackButtonAudi = new JButton("Natrag");
        BackButtonAudi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        BackButtonAudi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Admin4Dodavanje DodavanjeWindow = new Admin4Dodavanje();
                DodavanjeWindow.frame.setVisible(true);
            }
        });
        BackButtonAudi.setForeground(Color.RED);
        BackButtonAudi.setBounds(6, 16, 117, 29);
        frame.getContentPane().add(BackButtonAudi);
        
        JComboBox AudiModelCB = new JComboBox();
        AudiModelCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        AudiModelCB.setForeground(Color.RED);
        AudiModelCB.setModel(new DefaultComboBoxModel(new String[] {"A3", "A4", "Q3", "Q5", "A6"}));
        AudiModelCB.setBounds(330, 172, 130, 27);
        frame.getContentPane().add(AudiModelCB);
        
        JButton btnUnesi = new JButton("Unesi");
        btnUnesi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnUnesi.setForeground(Color.RED);
        btnUnesi.setBounds(330, 404, 130, 54);
        frame.getContentPane().add(btnUnesi);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(AdminAudi.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(636, 457, 143, 109);
        frame.getContentPane().add(lblNewLabel_1);

       // Unos podataka u tablicu Automobili na bazi
        btnUnesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                    String user = "dbirkic";
                    String sifra = "11";

                    Connection veza = DriverManager.getConnection(url, user, sifra);

                    String marka = "Audi";
                    String model = (String) AudiModelCB.getSelectedItem();
                    String godina = (String) AudiGodinaCB.getSelectedItem();
                    String motor = (String) AudiMotorCB.getSelectedItem();
                    String mjenjac = (String) AudiMjenjacCB.getSelectedItem();
                    String kilometraza = AudiKMTF.getText();
                    String cijena = AudiCijenaTF.getText();
                    String snaga = AudiSnagaTF.getText();

                    String sql = "INSERT INTO Automobili (Marka, Model, Godina, Motor, Mjenjac, Kilometraza, Cijena, Snaga) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement naredba = veza.prepareStatement(sql);

                    naredba.setString(1, marka);
                    naredba.setString(2, model);
                    naredba.setString(3, godina);
                    naredba.setString(4, motor);
                    naredba.setString(5, mjenjac);
                    naredba.setString(6, kilometraza);
                    naredba.setString(7, cijena);
                    naredba.setString(8, snaga);

                    int uneseniRedak = naredba.executeUpdate();
                    if (uneseniRedak > 0) {
                        JOptionPane.showMessageDialog(null, "Automobil uspješno unesen!", "Renti", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Greška pri unosu!", "Renti", JOptionPane.INFORMATION_MESSAGE);
                    }

                    veza.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Greška: " + ex.getMessage(), "Renti", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

