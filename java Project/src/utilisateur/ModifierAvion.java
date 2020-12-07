package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModifierAvion extends JFrame {

	private JPanel contentPane;
	private JTextField NoAvion;
	private JTextField Companie;
	private JTextField NbPlaces;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierAvion frame = new ModifierAvion();
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
	public ModifierAvion() {
		setTitle("Modifier Avion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 683, 377);
		contentPane.add(contentPane_1);
		
		JLabel lblEntrerLeNo = new JLabel("entrer le No Avion que vous \r\nvoulez modifier les details :");
		lblEntrerLeNo.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblEntrerLeNo.setBackground(Color.MAGENTA);
		lblEntrerLeNo.setBounds(22, 42, 486, 38);
		contentPane_1.add(lblEntrerLeNo);
		
		NoAvion = new JTextField();
		NoAvion.setColumns(10);
		NoAvion.setBackground(new Color(255, 160, 122));
		NoAvion.setBounds(518, 42, 142, 38);
		contentPane_1.add(NoAvion);
		
		JLabel lblCompanie = new JLabel("Companie");
		lblCompanie.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblCompanie.setEnabled(false);
		lblCompanie.setBounds(22, 142, 147, 38);
		contentPane_1.add(lblCompanie);
		
		JLabel lblnbPlaces = new JLabel("Nombre de Places");
		lblnbPlaces.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblnbPlaces.setEnabled(false);
		lblnbPlaces.setBounds(22, 196, 147, 38);
		contentPane_1.add(lblnbPlaces);
		
		Companie = new JTextField();
		Companie.setEnabled(false);
		Companie.setColumns(10);
		Companie.setBounds(173, 142, 198, 38);
		contentPane_1.add(Companie);
		
		NbPlaces = new JTextField();
		NbPlaces.setEnabled(false);
		NbPlaces.setColumns(10);
		NbPlaces.setBounds(173, 196, 198, 38);
		contentPane_1.add(NbPlaces);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NoVolExist()==1) {
					try{
						 if(
								 Companie.getText().equals(null) || NoAvion.getText().equals(null) 
						     || NbPlaces.getText().equals(null) 
								 )
						 {
					            JOptionPane.showMessageDialog(null, "Certains champs sont vides");
					        }
						 else {
						
					        int nbP=Integer.parseInt(NbPlaces.getText().toString());
					        int noav=Integer.parseInt(NoAvion.getText().toString());
					        String Comp=Companie.getText().toString();
							
					        Dbconnect conn=new Dbconnect() ;
							 PreparedStatement stm=null;
							 System.out.println("we are here here");
		stm=conn.getConn().prepareStatement("update avion set Companie=?, NbPlace=? where Noavion=? ");  
				          	
					          
							  stm.setString(1,Comp);
							  stm.setInt(2,nbP);
							 stm.setInt(3,noav);
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(447, 261, 147, 54);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(294, 270, 77, 38);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnPasserALa = new JButton("Cliquez pour passer a la modification des details d'Avion :");
		btnPasserALa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NoVolExist()==0){ JOptionPane.showMessageDialog(null, "Value Not Exist ..") ;  }
				else {
					JOptionPane.showMessageDialog(null, "Value Exist ") ;
				btnNewButton.setEnabled(true);
				Companie.setEnabled(true);
				lblnbPlaces.setEnabled(true);
				NbPlaces.setEnabled(true);
				lblCompanie.setEnabled(true);
				}
			}
		});
		btnPasserALa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPasserALa.setBackground(new Color(186, 85, 211));
		btnPasserALa.setBounds(113, 85, 486, 46);
		contentPane_1.add(btnPasserALa);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\avion-voler-passe-departs-salon-fenetre_13339-215760.jpg"));
		lblNewLabel.setBounds(0, 0, 683, 377);
		contentPane_1.add(lblNewLabel);
	}
	public int NoVolExist() { 
		int count=0;
		try {
		Dbconnect conn=new Dbconnect() ;
		int noav=Integer.parseInt(NoAvion.getText().toString());
		 ResultSet rs;
		 PreparedStatement stm=null;
		 System.out.println("we are here");
	 	stm=conn.getConn().prepareStatement("select count(*) from avion where noavion=? ");  
	 	
	     stm.setInt(1,noav);
	     rs=stm.executeQuery();	
	    
		 while(rs.next()) {
		
			if (rs.getInt(1)>=1)
			 count=1;
		 }
	   stm.close();
	   conn.getConn().close();
	    
	}
	catch(Exception er)
	{
        /*
		  * beep de Warning
		 */
		Toolkit.getDefaultToolkit().beep();

	   JOptionPane.showMessageDialog(null,er);
	   count=0;
	}
		return count;
	}
}
