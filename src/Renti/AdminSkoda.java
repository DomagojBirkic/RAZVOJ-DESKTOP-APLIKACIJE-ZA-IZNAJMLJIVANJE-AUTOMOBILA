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
import javax.swing.ImageIcon;

public class AdminSkoda {

    JFrame frame;
    private JTextField SkodaKMTF;
    private JTextField SkodaCijenaTF;
    private JTextField SkodaSnagaTF;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminSkoda window = new AdminSkoda();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminSkoda() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Škoda");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(292, 127, 120, 25);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel SkodaModel = new JLabel("Model :");
        SkodaModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaModel.setForeground(Color.WHITE);
        SkodaModel.setBounds(273, 189, 61, 16);
        frame.getContentPane().add(SkodaModel);
        
        JLabel SkodaMotor = new JLabel("Motor : ");
        SkodaMotor.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaMotor.setForeground(Color.WHITE);
        SkodaMotor.setBounds(273, 217, 61, 16);
        frame.getContentPane().add(SkodaMotor);
        
        JLabel SkodaMjenjac = new JLabel("Mjenjač :");
        SkodaMjenjac.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaMjenjac.setForeground(Color.WHITE);
        SkodaMjenjac.setBounds(252, 293, 61, 16);
        frame.getContentPane().add(SkodaMjenjac);
        
        JLabel SkodaKM = new JLabel("Kilometraža : ");
        SkodaKM.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaKM.setForeground(Color.WHITE);
        SkodaKM.setBounds(230, 333, 95, 16);
        frame.getContentPane().add(SkodaKM);
        
        JLabel SkodaCijena = new JLabel("Cijena po danu : ");
        SkodaCijena.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaCijena.setForeground(Color.WHITE);
        SkodaCijena.setBounds(214, 371, 120, 16);
        frame.getContentPane().add(SkodaCijena);
        
        JLabel SkodaSnaga = new JLabel("Snaga (KS) : ");
        SkodaSnaga.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaSnaga.setForeground(Color.WHITE);
        SkodaSnaga.setBounds(230, 256, 88, 16);
        frame.getContentPane().add(SkodaSnaga);
        
        JLabel SkodaGodina = new JLabel("Godina proizvodnje :");
        SkodaGodina.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaGodina.setForeground(Color.WHITE);
        SkodaGodina.setBounds(189, 162, 145, 16);
        frame.getContentPane().add(SkodaGodina);
        
        JComboBox SkodaGodinaCB = new JComboBox();
        SkodaGodinaCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaGodinaCB.setForeground(Color.RED);
        SkodaGodinaCB.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
        SkodaGodinaCB.setBounds(330, 158, 130, 27);
        frame.getContentPane().add(SkodaGodinaCB);
        
        JComboBox SkodaMotorCB = new JComboBox();
        SkodaMotorCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaMotorCB.setForeground(Color.RED);
        SkodaMotorCB.setModel(new DefaultComboBoxModel(new String[] {"Benzin", "Diesel", "Električni"}));
        SkodaMotorCB.setBounds(330, 217, 130, 27);
        frame.getContentPane().add(SkodaMotorCB);
        
        JComboBox SkodaMjenjacCB = new JComboBox();
        SkodaMjenjacCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaMjenjacCB.setForeground(Color.RED);
        SkodaMjenjacCB.setModel(new DefaultComboBoxModel(new String[] {"Automatski", "Manualni"}));
        SkodaMjenjacCB.setBounds(330, 289, 130, 27);
        frame.getContentPane().add(SkodaMjenjacCB);
        
        SkodaKMTF = new JTextField();
        SkodaKMTF.setBounds(330, 328, 130, 26);
        frame.getContentPane().add(SkodaKMTF);
        SkodaKMTF.setColumns(10);
        
        SkodaCijenaTF = new JTextField();
        SkodaCijenaTF.setBounds(330, 366, 130, 26);
        frame.getContentPane().add(SkodaCijenaTF);
        SkodaCijenaTF.setColumns(10);
        
        SkodaSnagaTF = new JTextField();
        SkodaSnagaTF.setBounds(330, 251, 130, 26);
        frame.getContentPane().add(SkodaSnagaTF);
        SkodaSnagaTF.setColumns(10);
        
        JButton BackButtonSkoda = new JButton("Natrag");
        BackButtonSkoda.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        BackButtonSkoda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Admin4Dodavanje DodavanjeWindow = new Admin4Dodavanje();
                DodavanjeWindow.frame.setVisible(true);
            }
        });
        BackButtonSkoda.setForeground(Color.RED);
        BackButtonSkoda.setBounds(6, 16, 117, 29);
        frame.getContentPane().add(BackButtonSkoda);
        
        JComboBox SkodaModelCB = new JComboBox();
        SkodaModelCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SkodaModelCB.setForeground(Color.RED);
        SkodaModelCB.setModel(new DefaultComboBoxModel(new String[] {"Fabia", "Octavia", "Kamiq", "Karoq", "Enyaq"}));
        SkodaModelCB.setBounds(330, 186, 130, 27);
        frame.getContentPane().add(SkodaModelCB);
        
        JButton btnUnesi = new JButton("Unesi");
        btnUnesi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnUnesi.setForeground(Color.RED);
        btnUnesi.setBounds(330, 404, 130, 54);
        frame.getContentPane().add(btnUnesi);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(AdminSkoda.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(649, 454, 145, 112);
        frame.getContentPane().add(lblNewLabel_1);
        // Unos podataka u tablicu Automobili na bazi
        btnUnesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                    String user = "dbirkic";
                    String sifra = "11";

                    Connection veza = DriverManager.getConnection(url, user, sifra);

                    String marka = "Skoda";
                    String model = (String) SkodaModelCB.getSelectedItem();
                    String godina = (String) SkodaGodinaCB.getSelectedItem();
                    String motor = (String) SkodaMotorCB.getSelectedItem();
                    String mjenjac = (String) SkodaMjenjacCB.getSelectedItem();
                    String kilometraza = SkodaKMTF.getText();
                    String cijena = SkodaCijenaTF.getText();
                    String snaga = SkodaSnagaTF.getText();

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

