package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModifierVol extends JFrame {

	private JPanel contentPane;
	private JTextField NoVol;
	private JTextField NoAvion;
	private JTextField VilleArrivee;
	private JTextField VilleDepart;
	private JTextField HeureDepart;
	private JTextField Duree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierVol frame = new ModifierVol();
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
	public ModifierVol() {
		setTitle("Modifier Vol");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 727, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 713, 435);
		contentPane.add(contentPane_1);
		
		JLabel lblNoVol = new JLabel("entrer le No Vol que vous \r\nvoulez modifier les details :");
		lblNoVol.setBackground(Color.MAGENTA);
		lblNoVol.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNoVol.setBounds(22, 42, 486, 38);
		contentPane_1.add(lblNoVol);
		
		NoVol = new JTextField();
		NoVol.setBackground(new Color(255, 160, 122));
		NoVol.setColumns(10);
		NoVol.setBounds(518, 42, 142, 38);
		contentPane_1.add(NoVol);
		
		JLabel lblNoAvion = new JLabel("No Avion");
		lblNoAvion.setEnabled(false);
		lblNoAvion.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNoAvion.setBounds(22, 142, 147, 38);
		contentPane_1.add(lblNoAvion);
		
		JLabel lblVilleDepart = new JLabel("Ville Depart");
		lblVilleDepart.setEnabled(false);
		lblVilleDepart.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblVilleDepart.setBounds(22, 196, 147, 38);
		contentPane_1.add(lblVilleDepart);
		
		JLabel lblVilleArrivee = new JLabel("Ville Arrivee");
		lblVilleArrivee.setEnabled(false);
		lblVilleArrivee.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblVilleArrivee.setBounds(362, 196, 147, 38);
		contentPane_1.add(lblVilleArrivee);
		
		JLabel lblHeureDepart = new JLabel("Heure Depart");
		lblHeureDepart.setEnabled(false);
		lblHeureDepart.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblHeureDepart.setBounds(22, 236, 147, 38);
		contentPane_1.add(lblHeureDepart);
		
		JLabel lblDuree = new JLabel("Duree");
		lblDuree.setEnabled(false);
		lblDuree.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblDuree.setBounds(22, 294, 147, 38);
		contentPane_1.add(lblDuree);
		
		NoAvion = new JTextField();
		NoAvion.setEnabled(false);
		NoAvion.setColumns(10);
		NoAvion.setBounds(150, 142, 198, 38);
		contentPane_1.add(NoAvion);
		
		VilleArrivee = new JTextField();
		VilleArrivee.setEnabled(false);
		VilleArrivee.setColumns(10);
		VilleArrivee.setBounds(484, 196, 198, 38);
		contentPane_1.add(VilleArrivee);
		
		VilleDepart = new JTextField();
		VilleDepart.setEnabled(false);
		VilleDepart.setColumns(10);
		VilleDepart.setBounds(150, 196, 156, 38);
		contentPane_1.add(VilleDepart);
		
		HeureDepart = new JTextField();
		HeureDepart.setEnabled(false);
		HeureDepart.setColumns(10);
		HeureDepart.setBounds(150, 245, 198, 38);
		contentPane_1.add(HeureDepart);
		
		Duree = new JTextField();
		Duree.setEnabled(false);
		Duree.setColumns(10);
		Duree.setBounds(150, 294, 198, 38);
		contentPane_1.add(Duree);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBackground(new Color(245, 245, 220));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NoVolExist()==1) {
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
		stm=conn.getConn().prepareStatement("update vol set VilleDepart=?, VilleArrivee=?, NoAvion=?,Durée=?, HeureDépart=?, HeureArrivée=? where NoVol=? ");  
				          	
					          
							  stm.setString(1,Vdep);
							  stm.setString(2,Varr);
							 stm.setInt(3,noav);
							 stm.setString(4,Dur);
					         stm.setString(5,Hdep);
					        stm.setString(6,Harr);
					        stm.setInt(7,nov);
					        stm.executeUpdate();
					        
					        stm.close();
					        conn.getConn().close();
					        JOptionPane.showMessageDialog(null, "Updated successfully !") ;  
						 }
					}catch(Exception er)
					    {
	                     /*
						  * beep de Warning
						 */
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null,er);
					    }
				}
				else JOptionPane.showMessageDialog(null,"La valeur entree dans No Avion est invalide ou certains Champs sont vides !");
				
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(457, 349, 147, 54);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(255, 105, 180));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(306, 354, 77, 38);
		contentPane_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("[VALID FORMAT HH24:MI ]");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(385, 248, 233, 26);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("[VALID FORMAT HH24:MI ]");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(417, 296, 156, 26);
		contentPane_1.add(lblNewLabel_1);
		
		JButton btnPasserALa = new JButton("Cliquez pour passer a la modification des details de VOL :");
		btnPasserALa.setBackground(new Color(100, 149, 237));
		btnPasserALa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NoVolExist()==0){ JOptionPane.showMessageDialog(null, "Value Not Exist ..") ;  }
			else {
				JOptionPane.showMessageDialog(null, "Value Exist ") ;
			btnNewButton.setEnabled(true);
			NoAvion.setEnabled(true);
			VilleDepart.setEnabled(true);
			VilleArrivee.setEnabled(true);
			HeureDepart.setEnabled(true);
			Duree.setEnabled(true);
			lblNoAvion.setEnabled(true);
			lblVilleDepart.setEnabled(true);
			lblVilleArrivee.setEnabled(true);
			lblHeureDepart.setEnabled(true);
			lblDuree.setEnabled(true);
			lblNewLabel_1.setEnabled(true);
			lblNewLabel.setEnabled(true);}
			}});
		btnPasserALa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPasserALa.setBounds(113, 85, 486, 46);
		contentPane_1.add(btnPasserALa);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\avion-voler-passe-departs-salon-fenetre_13339-215760.jpg"));
		lblNewLabel_2.setBounds(0, 0, 713, 435);
		contentPane_1.add(lblNewLabel_2);
	}
public int NoVolExist() { 
	int count=0;
	try {
	Dbconnect conn=new Dbconnect() ;
	int nov=Integer.parseInt(NoVol.getText().toString());
	 ResultSet rs;
	 PreparedStatement stm=null;
	 System.out.println("we are here");
 	stm=conn.getConn().prepareStatement("select count(*) from vol where novol=? ");  
 	
     stm.setInt(1,nov);
     rs=stm.executeQuery();	
    
	 while(rs.next()) {
	
		if (rs.getInt(1)>=1)
		 count++;
	 }
   stm.close();
   conn.getConn().close();
    
}
catch(Exception er)
{
	Toolkit.getDefaultToolkit().beep();
   JOptionPane.showMessageDialog(null,er);
   
   count=0;
}
	return count;
}
}
