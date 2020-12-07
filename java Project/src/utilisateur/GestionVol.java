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

public class GestionVol extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionVol frame = new GestionVol();
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
	public GestionVol() {
		setTitle("Gestion des Vols");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAjouterVol = new JButton("Ajouter Vol");
		btnAjouterVol.setBackground(new Color(0, 191, 255));
		btnAjouterVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new AjouterVol().setVisible(true);
			}
		});
		btnAjouterVol.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnAjouterVol.setBounds(51, 52, 333, 59);
		contentPane.add(btnAjouterVol);
		
		JButton btnSupprimerVol = new JButton("Supprimer Vol");
		btnSupprimerVol.setBackground(new Color(127, 255, 212));
		btnSupprimerVol.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
		new SupprimerVol().setVisible(true);
		}
		});
		btnSupprimerVol.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnSupprimerVol.setBounds(51, 137, 333, 59);
		contentPane.add(btnSupprimerVol);
		
		JButton btnModifierVol = new JButton("Modifier Vol");
		btnModifierVol.setBackground(new Color(221, 160, 221));
		btnModifierVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ModifierVol().setVisible(true);
			}
		});
		btnModifierVol.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnModifierVol.setBounds(51, 230, 333, 59);
		contentPane.add(btnModifierVol);
		
		JButton btnListerVols = new JButton("Lister Vols");
		btnListerVols.setBackground(new Color(255, 215, 0));
		btnListerVols.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListerVols().setVisible(true);
			}
		});
		btnListerVols.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		btnListerVols.setBounds(51, 328, 333, 59);
		contentPane.add(btnListerVols);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(147, 112, 219));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(441, 435, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\14155.jpg"));
		lblNewLabel.setBounds(0, 0, 664, 496);
		contentPane.add(lblNewLabel);
	}
}
