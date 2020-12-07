package utilisateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminUI extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminUI() {
		setTitle("Acceuil Admin");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 625, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestion des Voyageurs");
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionVoyageurs().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(32, 22, 333, 59);
		contentPane.add(btnNewButton);
		
		JButton btnGestionDesAvions = new JButton("Gestion des Avions");
		btnGestionDesAvions.setBackground(new Color(0, 250, 154));
		btnGestionDesAvions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionAvion().setVisible(true);
			}
		});
		btnGestionDesAvions.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnGestionDesAvions.setBounds(32, 102, 333, 59);
		contentPane.add(btnGestionDesAvions);
		
		JButton btnGestionDesVols = new JButton("Gestion des Vols");
		btnGestionDesVols.setBackground(new Color(218, 165, 32));
		btnGestionDesVols.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionVol().setVisible(true);
			}
		});
		btnGestionDesVols.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnGestionDesVols.setBounds(32, 185, 333, 59);
		contentPane.add(btnGestionDesVols);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(148, 0, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(480, 274, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnCreerCompteAdministrateur = new JButton("Creer Compte Administrateur");
		btnCreerCompteAdministrateur.setBackground(new Color(221, 160, 221));
		btnCreerCompteAdministrateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new InscriptionAdmin().setVisible(true);
			}
		});
		btnCreerCompteAdministrateur.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnCreerCompteAdministrateur.setBounds(32, 264, 333, 59);
		contentPane.add(btnCreerCompteAdministrateur);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\8338.jpg"));
		lblNewLabel.setBounds(0, 0, 611, 332);
		contentPane.add(lblNewLabel);
	}
}
