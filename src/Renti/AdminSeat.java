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

public class AdminSeat {

    JFrame frame;
    private JTextField SeatKMTF;
    private JTextField SeatCijenaTF;
    private JTextField SeatSnagaTF;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminSeat window = new AdminSeat();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminSeat() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Seat");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setBounds(286, 132, 120, 25);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel SeatModel = new JLabel("Model :");
        SeatModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatModel.setForeground(Color.WHITE);
        SeatModel.setBounds(257, 197, 61, 16);
        frame.getContentPane().add(SeatModel);
        
        JLabel SeatMotor = new JLabel("Motor : ");
        SeatMotor.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatMotor.setForeground(Color.WHITE);
        SeatMotor.setBounds(267, 225, 61, 16);
        frame.getContentPane().add(SeatMotor);
        
        JLabel SeatMjenjac = new JLabel("Mjenjač :");
        SeatMjenjac.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatMjenjac.setForeground(Color.WHITE);
        SeatMjenjac.setBounds(257, 293, 61, 16);
        frame.getContentPane().add(SeatMjenjac);
        
        JLabel SeatKM = new JLabel("Kilometraža : ");
        SeatKM.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatKM.setForeground(Color.WHITE);
        SeatKM.setBounds(230, 333, 95, 16);
        frame.getContentPane().add(SeatKM);
        
        JLabel SeatCijena = new JLabel("Cijena po danu : ");
        SeatCijena.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatCijena.setForeground(Color.WHITE);
        SeatCijena.setBounds(208, 371, 120, 16);
        frame.getContentPane().add(SeatCijena);
        
        JLabel SeatSnaga = new JLabel("Snaga (KS) : ");
        SeatSnaga.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatSnaga.setForeground(Color.WHITE);
        SeatSnaga.setBounds(230, 256, 88, 16);
        frame.getContentPane().add(SeatSnaga);
        
        JLabel SeatGodina = new JLabel("Godina proizvodnje :");
        SeatGodina.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatGodina.setForeground(Color.WHITE);
        SeatGodina.setBounds(166, 169, 152, 16);
        frame.getContentPane().add(SeatGodina);
        
        JComboBox SeatGodinaCB = new JComboBox();
        SeatGodinaCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatGodinaCB.setForeground(Color.RED);
        SeatGodinaCB.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025"}));
        SeatGodinaCB.setBounds(330, 165, 130, 27);
        frame.getContentPane().add(SeatGodinaCB);
        
        JComboBox SeatMotorCB = new JComboBox();
        SeatMotorCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatMotorCB.setForeground(Color.RED);
        SeatMotorCB.setModel(new DefaultComboBoxModel(new String[] {"Benzin", "Diesel", "Električni"}));
        SeatMotorCB.setBounds(330, 221, 130, 27);
        frame.getContentPane().add(SeatMotorCB);
        
        JComboBox SeatMjenjacCB = new JComboBox();
        SeatMjenjacCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatMjenjacCB.setForeground(Color.RED);
        SeatMjenjacCB.setModel(new DefaultComboBoxModel(new String[] {"Automatski", "Manualni"}));
        SeatMjenjacCB.setBounds(330, 289, 130, 27);
        frame.getContentPane().add(SeatMjenjacCB);
        
        SeatKMTF = new JTextField();
        SeatKMTF.setBounds(330, 328, 130, 26);
        frame.getContentPane().add(SeatKMTF);
        SeatKMTF.setColumns(10);
        
        SeatCijenaTF = new JTextField();
        SeatCijenaTF.setBounds(330, 366, 130, 26);
        frame.getContentPane().add(SeatCijenaTF);
        SeatCijenaTF.setColumns(10);
        
        SeatSnagaTF = new JTextField();
        SeatSnagaTF.setBounds(330, 251, 130, 26);
        frame.getContentPane().add(SeatSnagaTF);
        SeatSnagaTF.setColumns(10);
        
        JButton BackButtonSeat = new JButton("Natrag");
        BackButtonSeat.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        BackButtonSeat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Admin4Dodavanje DodavanjeWindow = new Admin4Dodavanje();
                DodavanjeWindow.frame.setVisible(true);
            }
        });
        BackButtonSeat.setForeground(Color.RED);
        BackButtonSeat.setBounds(6, 16, 117, 29);
        frame.getContentPane().add(BackButtonSeat);
        
        JComboBox SeatModelCB = new JComboBox();
        SeatModelCB.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        SeatModelCB.setForeground(Color.RED);
        SeatModelCB.setModel(new DefaultComboBoxModel(new String[] {"Ibiza", "Leon", "Arona", "Ateca", "Tarraco"}));
        SeatModelCB.setBounds(330, 193, 130, 27);
        frame.getContentPane().add(SeatModelCB);
        
        JButton btnUnesi = new JButton("Unesi");
        btnUnesi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnUnesi.setForeground(Color.RED);
        btnUnesi.setBounds(330, 404, 130, 54);
        frame.getContentPane().add(btnUnesi);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(AdminSeat.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(646, 456, 136, 110);
        frame.getContentPane().add(lblNewLabel_1);
        // Unos podataka u tablicu Automobili na bazi
        btnUnesi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
                    String user = "dbirkic";
                    String sifra = "11";

                    Connection veza = DriverManager.getConnection(url, user, sifra);

                    String marka = "Seat";
                    String model = (String) SeatModelCB.getSelectedItem();
                    String godina = (String) SeatGodinaCB.getSelectedItem();
                    String motor = (String) SeatMotorCB.getSelectedItem();
                    String mjenjac = (String) SeatMjenjacCB.getSelectedItem();
                    String kilometraza = SeatKMTF.getText();
                    String cijena = SeatCijenaTF.getText();
                    String snaga = SeatSnagaTF.getText();

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
