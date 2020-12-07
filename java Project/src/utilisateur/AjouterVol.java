package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AjouterVol extends JFrame {

	private JPanel contentPane;
	private JTextField NoVol;
	private JTextField NoAvion;
	private JTextField VilleDepart;
	private JTextField VilleArrivee;
	private JTextField HeureDepart;
	private JTextField Duree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterVol frame = new AjouterVol();
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
	public AjouterVol() {
		setTitle("Ajouter Vol");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNoVol = new JLabel("No Vol");
		lblNoVol.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNoVol.setBounds(22, 42, 147, 38);
		contentPane.add(lblNoVol);
		
		NoVol = new JTextField();
		NoVol.setColumns(10);
		NoVol.setBounds(209, 42, 198, 38);
		contentPane.add(NoVol);
		
		JLabel lblNoAvion = new JLabel("No Avion");
		lblNoAvion.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNoAvion.setBounds(22, 91, 147, 38);
		contentPane.add(lblNoAvion);
		
		JLabel lblVilleDepart = new JLabel("Ville Depart");
		lblVilleDepart.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblVilleDepart.setBounds(22, 138, 147, 38);
		contentPane.add(lblVilleDepart);
		
		JLabel lblVilleArrivee = new JLabel("Ville Arrivee");
		lblVilleArrivee.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblVilleArrivee.setBounds(22, 187, 147, 38);
		contentPane.add(lblVilleArrivee);
		
		JLabel lblHeureDepart = new JLabel("Heure Depart");
		lblHeureDepart.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblHeureDepart.setBounds(22, 236, 147, 38);
		contentPane.add(lblHeureDepart);
		
		JLabel lblDuree = new JLabel("Duree");
		lblDuree.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblDuree.setBounds(22, 284, 147, 38);
		contentPane.add(lblDuree);
		
		NoAvion = new JTextField();
		NoAvion.setColumns(10);
		NoAvion.setBounds(209, 100, 198, 38);
		contentPane.add(NoAvion);
		
		VilleDepart = new JTextField();
		VilleDepart.setColumns(10);
		VilleDepart.setBounds(209, 147, 198, 38);
		contentPane.add(VilleDepart);
		
		VilleArrivee = new JTextField();
		VilleArrivee.setColumns(10);
		VilleArrivee.setBounds(209, 196, 198, 38);
		contentPane.add(VilleArrivee);
		
		HeureDepart = new JTextField();
		HeureDepart.setColumns(10);
		HeureDepart.setBounds(209, 245, 198, 38);
		contentPane.add(HeureDepart);
		
		Duree = new JTextField();
		Duree.setColumns(10);
		Duree.setBounds(209, 293, 198, 38);
		contentPane.add(Duree);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBackground(new Color(255, 250, 205));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					 if(
							 NoVol.getText().equals(null) || NoAvion.getText().equals(null) 
					     || VilleDepart.getText().equals(null) || VilleArrivee.getText().equals(null)
					     || HeureDepart.getText().equals(null) || Duree.getText().equals(null)
					        
							 )
					 {
				            JOptionPane.showMessageDialog(null, "Certains champs sont vides");
				        }
					 else {
					
				        int nov=Integer.parseInt(NoVol.getText().toString());
				        int noav=Integer.parseInt(NoAvion.getText().toString());
				        String Vdep=VilleDepart.getText().toString();
				        String Varr=VilleArrivee.getText().toString();
				        String Hdep=HeureDepart.getText().toString();
						String Dur=Duree.getText().toString();
						
						Timehh24mi test =new Timehh24mi();
						String Harr=test.SommeTime(Hdep, Dur);//Pour l'heure d'arrivee
					
						
				        Dbconnect conn=new Dbconnect() ;
						 PreparedStatement stm=null;
						 System.out.println("we are here");
			          	stm=conn.getConn().prepareStatement("INSERT INTO vol VALUES(?,?,?,?,?,?,?)  ");  
			          	
				          stm.setInt(1,nov);
						  stm.setString(2,Vdep);
						  stm.setString(3,Varr);
						 stm.setInt(4,noav);
						 stm.setString(5,Dur);
				         stm.setString(6,Hdep);
				        stm.setString(7,Harr);
				        
				        stm.executeUpdate();
				        
				        stm.close();
				        conn.getConn().close();
				        JOptionPane.showMessageDialog(null, "Added") ;  
					 }
				}catch(Exception er)
				    {                     /*
					  * beep de Warning
					 */
					Toolkit.getDefaultToolkit().beep();
				        JOptionPane.showMessageDialog(null,er);
				    }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(457, 349, 147, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(306, 354, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("[VALID FORMAT HH24:MI ]");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(417, 251, 156, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("[VALID FORMAT HH24:MI ]");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(417, 296, 156, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\12631.jpg"));
		lblNewLabel_2.setBounds(0, 0, 652, 428);
		contentPane.add(lblNewLabel_2);
	}
}
