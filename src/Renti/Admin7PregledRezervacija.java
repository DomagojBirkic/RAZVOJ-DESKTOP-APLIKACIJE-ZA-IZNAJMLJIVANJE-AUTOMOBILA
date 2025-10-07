package Renti;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Admin7PregledRezervacija {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin7PregledRezervacija window = new Admin7PregledRezervacija();
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
	public Admin7PregledRezervacija() {
		initialize();
		 TablicaRezerviraniAutomobili();
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
        scrollPane.setBounds(31, 85, 739, 311);
        frame.getContentPane().add(scrollPane);
		

		
		JButton btnNewButton = new JButton("Natrag");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                Admin2MainMenu AdminMenuWindow = new Admin2MainMenu();
                AdminMenuWindow.frame.setVisible(true);
                frame.dispose();
            
			}
		});
		btnNewButton.setBounds(16, 6, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Rezervacije");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(340, 48, 181, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Admin7PregledRezervacija.class.getResource("/Slike/RentiLogo.png")));
		lblNewLabel_1.setBounds(655, 438, 155, 128);
		frame.getContentPane().add(lblNewLabel_1);
	}
	private void TablicaRezerviraniAutomobili() {
	    try {
	        String url = "jdbc:mysql://ucka.veleri.hr:3306/dbirkic";
	        String user = "dbirkic";
	        String sifra = "11";

	        Connection veza = DriverManager.getConnection(url, user, sifra);

	        Statement naredba = veza.createStatement();

	        // Administrator vidi sve rezervacije, bez filtera na email
	        String sql = "SELECT Naziv, Marka, Godina, Cijena, Datum_Rezervacije, Datum_Povratka, Email " +
	                     "FROM RezerviraniAutomobili";

	        ResultSet rezultat = naredba.executeQuery(sql);

	        // Kreiraj model za tablicu BEZ email stupca
	        DefaultTableModel model = new DefaultTableModel(
	        		 new String[]{"Naziv","Marka","Godina","Cijena","Datum_Rezervacije","Datum_Povratka","Email"}, 0);

	        while(rezultat.next()) {
	            String naziv = rezultat.getString("Naziv");
	            String marka = rezultat.getString("Marka");
	            String godina = rezultat.getString("Godina");
	            String cijena = rezultat.getString("Cijena");
	            String datum_rezervacije = rezultat.getString("Datum_Rezervacije");
	            String datum_povratka = rezultat.getString("Datum_Povratka");
	            String email=rezultat.getString("Email")	;
	            model.addRow(new Object[]{naziv, marka, godina, cijena, datum_rezervacije, datum_povratka, email});
	        }

	        table.setModel(model);
	        veza.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}
