package utilisateur;

import java.awt.BorderLayout;
import java.util.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class InscriptionVoyageur extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField Prenom;
	private JTextField Passport;
	private JTextField Adresse;
	private JTextField LogIn;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionVoyageur frame = new InscriptionVoyageur();
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
	public InscriptionVoyageur() {
		setBackground(Color.YELLOW);
		setTitle("Creer Un nouveau Compte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 669, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nom = new JTextField();
		nom.setBounds(291, 35, 198, 38);
		contentPane.add(nom);
		nom.setColumns(10);
		
		Prenom = new JTextField();
		Prenom.setColumns(10);
		Prenom.setBounds(291, 100, 198, 38);
		contentPane.add(Prenom);
		
		Passport = new JTextField();
		Passport.setColumns(10);
		Passport.setBounds(291, 176, 198, 38);
		contentPane.add(Passport);
		
		Adresse = new JTextField();
		Adresse.setColumns(10);
		Adresse.setBounds(291, 234, 198, 38);
		contentPane.add(Adresse);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					 if(
							 nom.getText().equals(null) || Prenom.getText().equals(null) 
					     || Passport.getText().equals(null) || Adresse.getText().equals(null)
					     || LogIn.getText().equals(null) || password.equals(null)
					        
							 )
					 {
				            JOptionPane.showMessageDialog(null, "Certains champs sont vides");
				        }
					 else {
					
				        String name=nom.getText().toString();
				        String pren=Prenom.getText().toString();
				        String passport=Passport.getText().toString();
				        String adress=Adresse.getText().toString();
				        String users=LogIn.getText().toString();
				        @SuppressWarnings("deprecation")
						String motpass=password.getText().toString();
				        
				        Dbconnect conn=new Dbconnect() ;
						 PreparedStatement stm=null;
			          	stm=conn.getConn().prepareStatement("INSERT INTO datausers VALUES(?,?,?,?,?,?)  ");  
			          	
				          stm.setString(1,users);
						  stm.setString(2,motpass);
						  stm.setString(3,passport);
						 stm.setString(4,name);
				         stm.setString(5,pren);
				        stm.setString(6,adress);
				        
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
		btnNewButton.setBounds(482, 460, 147, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(291, 469, 77, 38);
		contentPane.add(btnNewButton_1);
		
		LogIn = new JTextField();
		LogIn.setColumns(10);
		LogIn.setBounds(291, 313, 198, 38);
		contentPane.add(LogIn);
		
		password = new JPasswordField();
		password.setBounds(289, 379, 200, 38);
		contentPane.add(password);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel.setBounds(79, 35, 147, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblPrenom.setBounds(79, 100, 147, 38);
		contentPane.add(lblPrenom);
		
		JLabel lblPassport = new JLabel("Passport");
		lblPassport.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblPassport.setBounds(79, 165, 147, 38);
		contentPane.add(lblPassport);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblAdresse.setBounds(79, 234, 147, 38);
		contentPane.add(lblAdresse);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblUsername.setBounds(79, 313, 147, 38);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblPassword.setBounds(79, 379, 147, 38);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\Image\\Nouveau dossier\\2411.jpg"));
		lblNewLabel_1.setBounds(0, 0, 655, 533);
		contentPane.add(lblNewLabel_1);
	}
}
