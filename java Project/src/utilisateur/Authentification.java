package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Authentification extends JFrame {

	//private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private int Isadmin ;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
					
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
	public Authentification() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 631, 396);
		contentPane = new JPanel();
		//F1 ppl=new F1();
		//contentPane.add(ppl);
		//contentPane.setBackground(Color.ORANGE);
		//contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//setIconImage(Toolkit.getDefaultToolkit().getImage("/2411.jpg"));
		
		JLabel lblNewLabel = new JLabel("LogIn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(90, 81, 65, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PassWord");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(90, 127, 110, 32);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				  Dbconnect a=new Dbconnect(); 
				  
					String ch1 = textField.getText().toString();
					String ch2= String.valueOf(passwordField.getPassword());
					
					  
	if (Isadmin==0) {
			  try{ 
				  if(textField.getText().equals(null) || passwordField.getText().equals(null) ) {
						 JOptionPane.showMessageDialog(null, "Certains champs sont vides");
					 }
				  else {
//step3 create the statement object  
					   Statement stmt=a.con.createStatement();  
				   //step4 execute query  
				   ResultSet rs=stmt.executeQuery("select * from datausers");  // where login="+ch1.toString()+" and MDP="+ch2
				   int i=0,j=0;
				   
				   while(rs.next())  {
					  
					  if (ch1.equals(rs.getString(1)) && ch2.equals(rs.getString(2))){
						  JOptionPane.showMessageDialog(null, "Bienvenue Voyageurs");
				         i=1;
				         break;}
				   }
				   
				if(i==0) {
					JOptionPane.showMessageDialog(null, "Error d'authentification");
				}
				if (i==1) {
					new VoyageurUI().setVisible(true);
				}


				   //step5 close the connection object  
				a.con.close();}  
				  
				  }
			  catch(Exception e1){ 
				
				   System.out.println(e1);
				   JOptionPane.showMessageDialog(null,e1);
				  } 
			}
	if (Isadmin==1) {
		 try{ 
			 if(textField.getText().equals(null) || passwordField.getText().equals(null) ) {
				 JOptionPane.showMessageDialog(null, "Certains champs sont vides");
			 }
			 else {
			 System.out.println("here we are");
			//step3 create the statement object  
			   Statement stmt=a.con.createStatement();  
			   //step4 execute query  
			   ResultSet rs=stmt.executeQuery("select * from dataadmin");  // where login="+ch1.toString()+" and MDP="+ch2
			   int i=0;
			   
			   while(rs.next())  {
				  
				  if (ch1.equals(rs.getString(1)) && ch2.equals(rs.getString(2))){
					  JOptionPane.showMessageDialog(null, "Bienvenue Admin");
			         i=1;
			         break;}
			   }
			   
			if(i==0) {
				JOptionPane.showMessageDialog(null, "Error d'authentification");
			}
			if (i==1) {
				new AdminUI().setVisible(true);
			}


			   //step5 close the connection object  
			a.con.close();  
			  
			  }}
		  catch(Exception e1){ 
			
			   System.out.println(e1);
			   JOptionPane.showMessageDialog(null,e1);
			  }
			}
			}
			
		});
		btnNewButton.setBounds(329, 190, 120, 46);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(236, 81, 110, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 124, 110, 35);
		contentPane.add(passwordField);
		/*
		 * if (comboBox.getModel().toString()=="Compte Voyageur") {Isadmin=0; System.out.println("voy");}
				if (comboBox.getModel().toString()=="Compte Admin") {Isadmin=1; System.out.println("adm");}
				System.out.println(Isadmin);
		 */
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getModel().getSelectedItem().toString()=="Compte Voyageur") {Isadmin=0; System.out.println("voy");}
				if (comboBox.getModel().getSelectedItem().toString()=="Compte Admin") {Isadmin=1; System.out.println("adm");}
				System.out.println(Isadmin);
			}
		});

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Compte Voyageur", "Compte Admin"}));
		comboBox.setBounds(212, 23, 166, 32);
		contentPane.add(comboBox);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new InscriptionVoyageur().setVisible(true);
			}
		});
		btnSinscrire.setBackground(Color.PINK);
		btnSinscrire.setBounds(406, 259, 120, 46);
		contentPane.add(btnSinscrire);
		
		JLabel lblNewLabel_2 = new JLabel("Vous n'avez Pas Un Compte Voyageur ; alors cr\u00E9er le !\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 265, 386, 32);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(530, 310, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\avion-voler-passe-departs-salon-fenetre_13339-215760.jpg"));
		lblNewLabel_3.setBounds(0, 0, 617, 359);
		contentPane.add(lblNewLabel_3);
	}
}
