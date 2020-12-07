package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GestionAvion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAvion frame = new GestionAvion();
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
	public GestionAvion() {
		setTitle("Gestion Des Avions");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAjouterAvion = new JButton("Ajouter Avion");
		btnAjouterAvion.setBackground(new Color(0, 255, 255));
		btnAjouterAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new AjouterAvion().setVisible(true);
			}
		});
		btnAjouterAvion.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnAjouterAvion.setBounds(104, 74, 333, 59);
		contentPane.add(btnAjouterAvion);
		
		JButton btnSupprimerAvion = new JButton("Supprimer Avion");
		btnSupprimerAvion.setBackground(new Color(221, 160, 221));
		btnSupprimerAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new SupprimerAvion().setVisible(true);
			}
		});
		btnSupprimerAvion.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnSupprimerAvion.setBounds(104, 187, 333, 59);
		contentPane.add(btnSupprimerAvion);
		
		JButton btnModifierAvion = new JButton("Modifier Avion");
		btnModifierAvion.setBackground(new Color(255, 215, 0));
		btnModifierAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ModifierAvion().setVisible(true);}
		});
		btnModifierAvion.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnModifierAvion.setBounds(104, 291, 333, 59);
		contentPane.add(btnModifierAvion);
		
		JButton btnListerAvions = new JButton("Lister Avions");
		btnListerAvions.setBackground(new Color(60, 179, 113));
		btnListerAvions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListerAvions().setVisible(true);
			}
		});
		btnListerAvions.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnListerAvions.setBounds(104, 391, 333, 59);
		contentPane.add(btnListerAvions);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(498, 476, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\14155.jpg"));
		lblNewLabel.setBounds(0, 0, 671, 525);
		contentPane.add(lblNewLabel);
	}
}
