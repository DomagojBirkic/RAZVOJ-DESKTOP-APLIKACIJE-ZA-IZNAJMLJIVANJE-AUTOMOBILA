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

public class AdminVW {

    JFrame frame;
    private JTextField VWKMTF;
    private JTextField VWCijenaTF;
    private JTextField VWSnagaTF;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminVW window = new AdminVW();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminVW() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Volkswagen");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(270, 123, 150, 25);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel VWModel = new JLabel("Model :");
        VWModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWModel.setForeground(Color.WHITE);
        VWModel.setBounds(270, 192, 61, 16);
        frame.getContentPane().add(VWModel);
        
        JLabel VWMotor = new JLabel("Motor : ");
        VWMotor.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWMotor.setForeground(Color.WHITE);
        VWMotor.setBounds(270, 225, 61, 16);
        frame.getContentPane().add(VWMotor);
        
        JLabel VWMjenjac = new JLabel("Mjenjač :");
        VWMjenjac.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWMjenjac.setForeground(Color.WHITE);
        VWMjenjac.setBounds(257, 293, 61, 16);
        frame.getContentPane().add(VWMjenjac);
        
        JLabel VWKM = new JLabel("Kilometraža : ");
        VWKM.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWKM.setForeground(Color.WHITE);
        VWKM.setBounds(236, 333, 95, 16);
        frame.getContentPane().add(VWKM);
        
        JLabel VWCijena = new JLabel("Cijena po danu : ");
        VWCijena.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWCijena.setForeground(Color.WHITE);
        VWCijena.setBounds(211, 371, 120, 16);
        frame.getContentPane().add(VWCijena);
        
        JLabel VWSnaga = new JLabel("Snaga (KS) : ");
        VWSnaga.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWSnaga.setForeground(Color.WHITE);
        VWSnaga.setBounds(236, 253, 82, 16);
        frame.getContentPane().add(VWSnaga);
        
        JLabel VWGodina = new JLabel("Godina proizvodnje :");
        VWGodina.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWGodina.setForeground(Color.WHITE);
        VWGodina.setBounds(168, 164, 150, 16);
        frame.getContentPane().add(VWGodina);
        
        JComboBox VWGodinaCB = new JComboBox();
        VWGodinaCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWGodinaCB.setForeground(Color.RED);
        VWGodinaCB.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
        VWGodinaCB.setBounds(330, 160, 130, 27);
        frame.getContentPane().add(VWGodinaCB);
        
        JComboBox VWMotorCB = new JComboBox();
        VWMotorCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWMotorCB.setForeground(Color.RED);
        VWMotorCB.setModel(new DefaultComboBoxModel(new String[] {"Benzin", "Diesel", "Električni"}));
        VWMotorCB.setBounds(330, 221, 130, 27);
        frame.getContentPane().add(VWMotorCB);
        
        JComboBox VWMjenjacCB = new JComboBox();
        VWMjenjacCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWMjenjacCB.setForeground(Color.RED);
        VWMjenjacCB.setModel(new DefaultComboBoxModel(new String[] {"Automatski", "Manualni"}));
        VWMjenjacCB.setBounds(330, 289, 130, 27);
        frame.getContentPane().add(VWMjenjacCB);
        
        VWKMTF = new JTextField();
        VWKMTF.setBounds(330, 328, 130, 26);
        frame.getContentPane().add(VWKMTF);
        VWKMTF.setColumns(10);
        
        VWCijenaTF = new JTextField();
        VWCijenaTF.setBounds(330, 366, 130, 26);
        frame.getContentPane().add(VWCijenaTF);
        VWCijenaTF.setColumns(10);
        
        VWSnagaTF = new JTextField();
        VWSnagaTF.setBounds(330, 251, 130, 26);
        frame.getContentPane().add(VWSnagaTF);
        VWSnagaTF.setColumns(10);
        
        JButton BackButtonVW = new JButton("Natrag");
        BackButtonVW.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        BackButtonVW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Admin4Dodavanje DodavanjeWindow = new Admin4Dodavanje();
                DodavanjeWindow.frame.setVisible(true);
            }
        });
        BackButtonVW.setForeground(Color.RED);
        BackButtonVW.setBounds(6, 16, 117, 29);
        frame.getContentPane().add(BackButtonVW);
        
        JComboBox VWModelCB = new JComboBox();
        VWModelCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        VWModelCB.setForeground(Color.RED);
        VWModelCB.setModel(new DefaultComboBoxModel(new String[] {"Golf", "Passat", "T-Roc", "Tiguan", "Arteon"}));
        VWModelCB.setBounds(330, 190, 130, 27);
        frame.getContentPane().add(VWModelCB);
        
        JButton btnUnesi = new JButton("Unesi");
        btnUnesi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnUnesi.setForeground(Color.RED);
        btnUnesi.setBounds(330, 404, 130, 54);
        frame.getContentPane().add(btnUnesi);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(AdminVW.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(652, 455, 142, 111);
        frame.getContentPane().add(lblNewLabel_1);
        // Unos podataka u tablicu Automobili na bazi
        btnUnesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                    String user = "dbirkic";
                    String sifra = "11";

                    Connection veza = DriverManager.getConnection(url, user, sifra);

                    String marka = "Volkswagen";
                    String model = (String) VWModelCB.getSelectedItem();
                    String godina = (String) VWGodinaCB.getSelectedItem();
                    String motor = (String) VWMotorCB.getSelectedItem();
                    String mjenjac = (String) VWMjenjacCB.getSelectedItem();
                    String kilometraza = VWKMTF.getText();
                    String cijena = VWCijenaTF.getText();
                    String snaga = VWSnagaTF.getText();

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

                    int unesniRedak = naredba.executeUpdate();
                    if (unesniRedak > 0) {
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
