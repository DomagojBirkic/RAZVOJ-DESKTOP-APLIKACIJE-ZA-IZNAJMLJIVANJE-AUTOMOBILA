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

public class AdminCUPRA {

    JFrame frame;
    private JTextField CupraKMTF;
    private JTextField CupraCijenaTF;
    private JTextField CupraSnagaTF;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminCUPRA window = new AdminCUPRA();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminCUPRA() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("CUPRA");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(272, 107, 120, 25);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel CupraModel = new JLabel("Model :");
        CupraModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraModel.setForeground(Color.WHITE);
        CupraModel.setBounds(257, 187, 61, 16);
        frame.getContentPane().add(CupraModel);
        
        JLabel CupraMotor = new JLabel("Motor : ");
        CupraMotor.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraMotor.setForeground(Color.WHITE);
        CupraMotor.setBounds(257, 226, 61, 16);
        frame.getContentPane().add(CupraMotor);
        
        JLabel CupraMjenjac = new JLabel("Mjenjač :");
        CupraMjenjac.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraMjenjac.setForeground(Color.WHITE);
        CupraMjenjac.setBounds(257, 293, 61, 16);
        frame.getContentPane().add(CupraMjenjac);
        
        JLabel CupraKM = new JLabel("Kilometraža : ");
        CupraKM.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraKM.setForeground(Color.WHITE);
        CupraKM.setBounds(223, 333, 95, 16);
        frame.getContentPane().add(CupraKM);
        
        JLabel CupraCijena = new JLabel("Cijena po danu : ");
        CupraCijena.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraCijena.setForeground(Color.WHITE);
        CupraCijena.setBounds(198, 371, 120, 16);
        frame.getContentPane().add(CupraCijena);
        
        JLabel CupraSnaga = new JLabel("Snaga (KS) : ");
        CupraSnaga.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraSnaga.setForeground(Color.WHITE);
        CupraSnaga.setBounds(223, 256, 95, 16);
        frame.getContentPane().add(CupraSnaga);
        
        JLabel CupraGodina = new JLabel("Godina proizvodnje :");
        CupraGodina.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraGodina.setForeground(Color.WHITE);
        CupraGodina.setBounds(170, 148, 148, 16);
        frame.getContentPane().add(CupraGodina);
        
        JComboBox CupraGodinaCB = new JComboBox();
        CupraGodinaCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraGodinaCB.setForeground(Color.RED);
        CupraGodinaCB.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
        CupraGodinaCB.setBounds(330, 144, 136, 27);
        frame.getContentPane().add(CupraGodinaCB);
        
        JComboBox CupraMotorCB = new JComboBox();
        CupraMotorCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraMotorCB.setForeground(Color.RED);
        CupraMotorCB.setModel(new DefaultComboBoxModel(new String[] {"Benzin", "Diesel", "Električni"}));
        CupraMotorCB.setBounds(330, 222, 136, 27);
        frame.getContentPane().add(CupraMotorCB);
        
        JComboBox CupraMjenjacCB = new JComboBox();
        CupraMjenjacCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraMjenjacCB.setForeground(Color.RED);
        CupraMjenjacCB.setModel(new DefaultComboBoxModel(new String[] {"Automatski", "Manualni"}));
        CupraMjenjacCB.setBounds(330, 289, 136, 27);
        frame.getContentPane().add(CupraMjenjacCB);
        
        CupraKMTF = new JTextField();
        CupraKMTF.setBounds(330, 328, 130, 26);
        frame.getContentPane().add(CupraKMTF);
        CupraKMTF.setColumns(10);
        
        CupraCijenaTF = new JTextField();
        CupraCijenaTF.setBounds(330, 366, 130, 26);
        frame.getContentPane().add(CupraCijenaTF);
        CupraCijenaTF.setColumns(10);
        
        CupraSnagaTF = new JTextField();
        CupraSnagaTF.setBounds(330, 251, 130, 26);
        frame.getContentPane().add(CupraSnagaTF);
        CupraSnagaTF.setColumns(10);
        // Back button
        JButton BackButtonCupra = new JButton("Natrag");
        BackButtonCupra.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        BackButtonCupra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Admin4Dodavanje DodavanjeWindow = new Admin4Dodavanje();
                DodavanjeWindow.frame.setVisible(true);
            }
        });
        BackButtonCupra.setForeground(Color.RED);
        BackButtonCupra.setBounds(6, 16, 117, 29);
        frame.getContentPane().add(BackButtonCupra);
        
        JComboBox CupraModelCB = new JComboBox();
        CupraModelCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        CupraModelCB.setForeground(Color.RED);
        CupraModelCB.setModel(new DefaultComboBoxModel(new String[] {"Formentor", "Leon", "Ateca", "Born", "Tavascan"}));
        CupraModelCB.setBounds(330, 183, 136, 27);
        frame.getContentPane().add(CupraModelCB);
        
        JButton btnUnesi = new JButton("Unesi");
        btnUnesi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnUnesi.setForeground(Color.RED);
        btnUnesi.setBounds(330, 404, 130, 54);
        frame.getContentPane().add(btnUnesi);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(AdminCUPRA.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(656, 468, 120, 98);
        frame.getContentPane().add(lblNewLabel_1);
        //   Unos podataka u tablicu Automobili na bazi
        btnUnesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                    String user = "dbirkic";
                    String sifra = "11";

                    Connection veza = DriverManager.getConnection(url, user, sifra);

                    String marka = "CUPRA";
                    String model = (String) CupraModelCB.getSelectedItem();
                    String godina = (String) CupraGodinaCB.getSelectedItem();
                    String motor = (String) CupraMotorCB.getSelectedItem();
                    String mjenjac = (String) CupraMjenjacCB.getSelectedItem();
                    String kilometraza = CupraKMTF.getText();
                    String cijena = CupraCijenaTF.getText();
                    String snaga = CupraSnagaTF.getText();

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

