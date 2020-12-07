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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GestionVoyageurs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionVoyageurs frame = new GestionVoyageurs();
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
	public GestionVoyageurs() {
		setTitle("Gestion des Voyageurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Validation des Billets");
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ValidationBillets().setVisible(true);
				//new ValidationVoyageurs_1().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 17));
		btnNewButton.setBounds(24, 29, 279, 65);
		contentPane.add(btnNewButton);
		
		JButton btnListerLesVoyageurs = new JButton("Lister les Voyageurs");
		btnListerLesVoyageurs.setBackground(new Color(175, 238, 238));
		btnListerLesVoyageurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListerVoyageur().setVisible(true);
			}
		});
		btnListerLesVoyageurs.setFont(new Font("Sitka Small", Font.BOLD, 17));
		btnListerLesVoyageurs.setBounds(274, 121, 279, 65);
		contentPane.add(btnListerLesVoyageurs);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(123, 104, 238));
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			dispose();}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(569, 209, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\14155.jpg"));
		lblNewLabel.setBounds(0, 0, 708, 277);
		contentPane.add(lblNewLabel);
	}

}
