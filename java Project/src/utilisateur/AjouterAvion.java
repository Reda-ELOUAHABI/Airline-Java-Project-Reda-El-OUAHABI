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
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AjouterAvion extends JFrame {

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
					AjouterAvion frame = new AjouterAvion();
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
	public AjouterAvion() {
		setTitle("Ajouter Un Avion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNoAvion = new JLabel("No Avion");
		lblNoAvion.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNoAvion.setBounds(50, 60, 147, 38);
		contentPane.add(lblNoAvion);
		
		JLabel lblCompanie = new JLabel("Companie");
		lblCompanie.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblCompanie.setBounds(50, 126, 147, 38);
		contentPane.add(lblCompanie);
		
		JLabel lblNombreDesPlaces = new JLabel("Nombre des Places");
		lblNombreDesPlaces.setBackground(new Color(0, 139, 139));
		lblNombreDesPlaces.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNombreDesPlaces.setBounds(50, 186, 187, 38);
		contentPane.add(lblNombreDesPlaces);
		
		NoAvion = new JTextField();
		NoAvion.setColumns(10);
		NoAvion.setBounds(263, 60, 198, 38);
		contentPane.add(NoAvion);
		
		Companie = new JTextField();
		Companie.setColumns(10);
		Companie.setBounds(263, 126, 198, 38);
		contentPane.add(Companie);
		
		NbPlaces = new JTextField();
		NbPlaces.setColumns(10);
		NbPlaces.setBounds(263, 186, 198, 38);
		contentPane.add(NbPlaces);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(238, 130, 238));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(271, 296, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					 if(
							 NoAvion.getText().equals(null) || Companie.getText().equals(null) 
					     || NbPlaces.getText().equals(null) 
							 )
					 {
				            JOptionPane.showMessageDialog(null, "Certains champs sont vides");
				        }
					 else {
						 
					   int noav=Integer.parseInt(NoAvion.getText().toString()); 
					   String Comp=Companie.getText().toString();
				        int nbP=Integer.parseInt(NbPlaces.getText().toString()); 
				       
				     

				        Dbconnect conn=new Dbconnect() ;
						 PreparedStatement stm=null;
						 System.out.println("we are here");
			          	stm=conn.getConn().prepareStatement("INSERT INTO Avion VALUES(?,?,?)  ");  
			          	
				          stm.setInt(1,noav);
						  stm.setString(2,Comp);
						 stm.setInt(3,nbP);
						 
				        stm.executeUpdate();
				        
				        stm.close();
				        conn.getConn().close();
				        JOptionPane.showMessageDialog(null, "Added") ;  
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
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(441, 287, 147, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\12631.jpg"));
		lblNewLabel.setBounds(0, 0, 637, 368);
		contentPane.add(lblNewLabel);
		
	}

}
