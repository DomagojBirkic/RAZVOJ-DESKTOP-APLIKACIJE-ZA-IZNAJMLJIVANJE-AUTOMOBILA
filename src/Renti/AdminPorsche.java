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

public class AdminPorsche {

    JFrame frame;
    private JTextField PorscheKMTF;
    private JTextField PorscheCijenaTF;
    private JTextField PorscheSnagaTF;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminPorsche window = new AdminPorsche();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminPorsche() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Porsche");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(278, 100, 120, 25);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel PorscheModel = new JLabel("Model :");
        PorscheModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheModel.setForeground(Color.WHITE);
        PorscheModel.setBounds(257, 176, 61, 16);
        frame.getContentPane().add(PorscheModel);
        
        JLabel PorscheMotor = new JLabel("Motor : ");
        PorscheMotor.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheMotor.setForeground(Color.WHITE);
        PorscheMotor.setBounds(257, 215, 61, 16);
        frame.getContentPane().add(PorscheMotor);
        
        JLabel PorscheMjenjac = new JLabel("Mjenjač :");
        PorscheMjenjac.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheMjenjac.setForeground(Color.WHITE);
        PorscheMjenjac.setBounds(257, 292, 61, 16);
        frame.getContentPane().add(PorscheMjenjac);
        
        JLabel PorscheKM = new JLabel("Kilometraža : ");
        PorscheKM.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheKM.setForeground(Color.WHITE);
        PorscheKM.setBounds(223, 333, 95, 16);
        frame.getContentPane().add(PorscheKM);
        
        JLabel PorscheCijena = new JLabel("Cijena po danu : ");
        PorscheCijena.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheCijena.setForeground(Color.WHITE);
        PorscheCijena.setBounds(198, 371, 120, 16);
        frame.getContentPane().add(PorscheCijena);
        
        JLabel PorscheSnaga = new JLabel("Snaga (KS) : ");
        PorscheSnaga.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheSnaga.setForeground(Color.WHITE);
        PorscheSnaga.setBounds(223, 255, 95, 16);
        frame.getContentPane().add(PorscheSnaga);
        
        JLabel PorscheGodina = new JLabel("Godina proizvodnje :");
        PorscheGodina.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheGodina.setForeground(Color.WHITE);
        PorscheGodina.setBounds(159, 141, 159, 16);
        frame.getContentPane().add(PorscheGodina);
        
        JComboBox PorscheGodinaCB = new JComboBox();
        PorscheGodinaCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheGodinaCB.setForeground(Color.RED);
        PorscheGodinaCB.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
        PorscheGodinaCB.setBounds(330, 137, 130, 27);
        frame.getContentPane().add(PorscheGodinaCB);
        
        JComboBox PorscheMotorCB = new JComboBox();
        PorscheMotorCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheMotorCB.setForeground(Color.RED);
        PorscheMotorCB.setModel(new DefaultComboBoxModel(new String[] {"Benzin", "Diesel", "Električni"}));
        PorscheMotorCB.setBounds(330, 211, 130, 27);
        frame.getContentPane().add(PorscheMotorCB);
        
        JComboBox PorscheMjenjacCB = new JComboBox();
        PorscheMjenjacCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheMjenjacCB.setForeground(Color.RED);
        PorscheMjenjacCB.setModel(new DefaultComboBoxModel(new String[] {"Automatski", "Manualni"}));
        PorscheMjenjacCB.setBounds(330, 288, 130, 27);
        frame.getContentPane().add(PorscheMjenjacCB);
        
        PorscheKMTF = new JTextField();
        PorscheKMTF.setBounds(330, 328, 130, 26);
        frame.getContentPane().add(PorscheKMTF);
        PorscheKMTF.setColumns(10);
        
        PorscheCijenaTF = new JTextField();
        PorscheCijenaTF.setBounds(330, 366, 130, 26);
        frame.getContentPane().add(PorscheCijenaTF);
        PorscheCijenaTF.setColumns(10);
        
        PorscheSnagaTF = new JTextField();
        PorscheSnagaTF.setBounds(330, 250, 130, 26);
        frame.getContentPane().add(PorscheSnagaTF);
        PorscheSnagaTF.setColumns(10);
        
        JButton BackButtonPorsche = new JButton("Natrag");
        BackButtonPorsche.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        BackButtonPorsche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Admin4Dodavanje DodavanjeWindow = new Admin4Dodavanje();
                DodavanjeWindow.frame.setVisible(true);
            }
        });
        BackButtonPorsche.setForeground(Color.RED);
        BackButtonPorsche.setBounds(6, 16, 117, 29);
        frame.getContentPane().add(BackButtonPorsche);
        
        JComboBox PorscheModelCB = new JComboBox();
        PorscheModelCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        PorscheModelCB.setForeground(Color.RED);
        PorscheModelCB.setModel(new DefaultComboBoxModel(new String[] {"911", "Cayenne", "Panamera", "Macan", "Taycan"}));
        PorscheModelCB.setBounds(330, 172, 130, 27);
        frame.getContentPane().add(PorscheModelCB);
        
        JButton btnUnesi = new JButton("Unesi");
        btnUnesi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnUnesi.setForeground(Color.RED);
        btnUnesi.setBounds(330, 404, 130, 54);
        frame.getContentPane().add(btnUnesi);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(AdminPorsche.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(620, 458, 147, 97);
        frame.getContentPane().add(lblNewLabel_1);
        // Unos podataka u tablicu Automobili na bazi
        btnUnesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                    String user = "dbirkic";
                    String sifra = "11";

                    Connection veza = DriverManager.getConnection(url, user, sifra);

                    String marka = "Porsche";
                    String model = (String) PorscheModelCB.getSelectedItem();
                    String godina = (String) PorscheGodinaCB.getSelectedItem();
                    String motor = (String) PorscheMotorCB.getSelectedItem();
                    String mjenjac = (String) PorscheMjenjacCB.getSelectedItem();
                    String kilometraza = PorscheKMTF.getText();
                    String cijena = PorscheCijenaTF.getText();
                    String snaga = PorscheSnagaTF.getText();

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

