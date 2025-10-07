package Renti;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Admin6PregledKorisnika {

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
                    Admin6PregledKorisnika window = new Admin6PregledKorisnika();
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
    public Admin6PregledKorisnika() {
        initialize();
        TablicaKorisniciSQL();
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
        frame.setResizable(true);

        table = new JTable(); 
        JScrollPane scrollPane = new JScrollPane(table); 
        scrollPane.setBounds(34, 73, 736, 303); 
        frame.getContentPane().add(scrollPane);

        btnNewButton = new JButton("Natrag");
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin2MainMenu AdminMenuWindow = new Admin2MainMenu();
                AdminMenuWindow.frame.setVisible(true);
                frame.dispose();
            }
        });
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(20, 20, 117, 29);
        frame.getContentPane().add(btnNewButton);
        
        lblNewLabel = new JLabel("Korisnici");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(350, 31, 301, 39);
        frame.getContentPane().add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(Admin6PregledKorisnika.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(649, 460, 133, 106);
        frame.getContentPane().add(lblNewLabel_1);
    }

    private void TablicaKorisniciSQL() {
        try {
            String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
            String user = "dbirkic";
            String sifra = "11";

            Connection veza = DriverManager.getConnection(url, user, sifra);
            Statement naredba = veza.createStatement();
            String sql = "SELECT * FROM Korisnici"; 
            ResultSet rezultat = naredba.executeQuery(sql);

            DefaultTableModel model = new DefaultTableModel();
            int column = rezultat.getMetaData().getColumnCount();
            for (int i = 1; i <= column; i++) {
                model.addColumn(rezultat.getMetaData().getColumnName(i));
            }

            while(rezultat.next()) {
                Object[] row = new Object[column];
                for (int i = 0; i < column; i++) {
                    row[i] = rezultat.getObject(i + 1);
                }
                model.addRow(row);
            }

            table.setModel(model);
            veza.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}