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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Admin3PregledAutomobila {

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
                    Admin3PregledAutomobila window = new Admin3PregledAutomobila();
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
    public Admin3PregledAutomobila() {
        initialize();
        TablicaAutomobiliSQL(); // automatski učitava podatke
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
        scrollPane.setBounds(32, 77, 736, 303);
        frame.getContentPane().add(scrollPane);
        
        btnNewButton = new JButton("Natrag");
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {


				// Otvara se main menu od administratora
				Admin2MainMenu AdminMenuWindow = new Admin2MainMenu();
				AdminMenuWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
			
			
        	}
        });
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(6, 6, 117, 29);
        frame.getContentPane().add(btnNewButton);
        
        lblNewLabel = new JLabel("Automobili");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(328, 48, 165, 16);
        frame.getContentPane().add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(Admin3PregledAutomobila.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(658, 474, 142, 92);
        frame.getContentPane().add(lblNewLabel_1);
    }
    //Metodom TablicaAutomobili se pozivaju podatci iz tablice Automobili na bazi podataka
    private void TablicaAutomobiliSQL() {
        try {
            String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
            String user = "dbirkic";
            String sifra = "11";

            Connection veza = DriverManager.getConnection(url, user, sifra);
            Statement naredba = veza.createStatement();
            String sql = "SELECT Marka, Model, Godina, Motor, Mjenjac, Kilometraza, Cijena, Snaga FROM Automobili";
            ResultSet rezultat = naredba.executeQuery(sql);

            // Izrada modela za tablicu
            DefaultTableModel model = new DefaultTableModel(
                new String[]{"Marka","Model","Godina","Motor","Mjenjac","Kilometraza","Cijena","Snaga"}, 0);

            while(rezultat.next()) {
                String marka = rezultat.getString("Marka");
                String modelName = rezultat.getString("Model");
                String godina = rezultat.getString("Godina");
                String motor = rezultat.getString("Motor");
                String mjenjac = rezultat.getString("Mjenjac");
                String kilometraza = rezultat.getString("Kilometraza");
                String cijena = rezultat.getString("Cijena");
                String snaga = rezultat.getString("Snaga");

                model.addRow(new Object[]{marka, modelName, godina, motor, mjenjac, kilometraza, cijena, snaga});
            }

            table.setModel(model);
            veza.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
