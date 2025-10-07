package Renti;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Admin4Dodavanje {

    JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin4Dodavanje window = new Admin4Dodavanje();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Admin4Dodavanje() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Marka: ");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(259, 236, 61, 16);
        frame.getContentPane().add(lblNewLabel);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        comboBox.setForeground(Color.RED);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Volkswagen", "Audi", "Skoda", "SEAT", "CUPRA", "Porsche"}));
        comboBox.setBounds(316, 232, 176, 27);
        frame.getContentPane().add(comboBox);

        JButton btnNewButton = new JButton("Nastavi");
        btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(316, 260, 180, 27);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Natrag");
        btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

				// Otvara se main menu administratora
				Admin2MainMenu AdminMenuWindow = new Admin2MainMenu();
				AdminMenuWindow.frame.setVisible(true);
				//Zatvara se trenutna
				frame.dispose();
        	}
        });
        btnNewButton_1.setForeground(Color.RED);
        btnNewButton_1.setBounds(6, 18, 117, 29);
        frame.getContentPane().add(btnNewButton_1);
        
        JLabel lblNewLabel_1 = new JLabel("Dodavanje automobila");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(299, 190, 237, 30);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(Admin4Dodavanje.class.getResource("/Slike/RentiLogo.png")));
        lblNewLabel_2.setBounds(653, 449, 157, 123);
        frame.getContentPane().add(lblNewLabel_2);

        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String odabranaMarka = (String) comboBox.getSelectedItem();

                // Zatvara se trenutni prozor
                frame.dispose();

                // Po odabiru iz combobox-a se otvaraju odgovarajući prozori po marki
                if (odabranaMarka.equals("Volkswagen")) {
                    AdminVW vwWindow = new AdminVW();
                    vwWindow.frame.setVisible(true);
                } else if (odabranaMarka.equals("Skoda")) {
                    AdminSkoda skodaWindow = new AdminSkoda();
                    skodaWindow.frame.setVisible(true);
                } else if (odabranaMarka.equals("SEAT")) {
                    AdminSeat seatWindow = new AdminSeat();
                    seatWindow.frame.setVisible(true);
                } else if (odabranaMarka.equals("CUPRA")) {
                	AdminCUPRA cupraWindow = new AdminCUPRA();
                    cupraWindow.frame.setVisible(true);
                } else if (odabranaMarka.equals("Audi")) {
                    AdminAudi audiWindow = new AdminAudi();
                    audiWindow.frame.setVisible(true);
                } else if (odabranaMarka.equals("Porsche")) {
                    AdminPorsche porscheWindow = new AdminPorsche();
                    porscheWindow.frame.setVisible(true);
                } 
            }
        });
    }
}