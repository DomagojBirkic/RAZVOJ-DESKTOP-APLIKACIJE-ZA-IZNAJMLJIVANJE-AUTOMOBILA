package Renti;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Korisnik3MainMenu {

    JFrame frame;
    private JLabel welcomeLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    Korisnik3MainMenu window = new Korisnik3MainMenu("testtest");
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    public Korisnik3MainMenu() {
        initialize(null);
    }

  
    public Korisnik3MainMenu(String ime) {
        initialize(ime);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(String ime) {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Dostupni automobili");
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

				// Otvara se prijava korisnika
				Korisnik4DostupniAutomobili DostupniWindow = new Korisnik4DostupniAutomobili();
				DostupniWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
        	}
        });
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(276, 178, 205, 61);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Moje rezervacije");
        btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Otvara se prozor rezervacije
				Korisnik5MojeRezervacije rezervacijeWindow = new Korisnik5MojeRezervacije();
				rezervacijeWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
        	}
        });
        btnNewButton_1.setForeground(Color.RED);
        btnNewButton_1.setBounds(276, 262, 205, 61);
        frame.getContentPane().add(btnNewButton_1);

                welcomeLabel = new JLabel();
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(6, 516, 400, 30);
        frame.getContentPane().add(welcomeLabel);
        
        JLabel lblNewLabel = new JLabel("Glavni izbornik");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(276, 135, 205, 16);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(Korisnik3MainMenu.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_1.setBounds(644, 446, 136, 120);
        frame.getContentPane().add(lblNewLabel_1);

        if (ime != null) {
            welcomeLabel.setText("Dobrodošli, " + ime + "!");
        }
    }
}

