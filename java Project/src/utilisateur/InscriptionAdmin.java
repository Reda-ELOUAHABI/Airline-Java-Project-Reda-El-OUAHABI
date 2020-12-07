package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class InscriptionAdmin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionAdmin frame = new InscriptionAdmin();
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
	public InscriptionAdmin() {
		setTitle("Creer Un nouveau Compte ADMINISTRATEUR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 729, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dbconnect a=new Dbconnect();
				 try{ 
					 String users=textField.getText().toString();
					@SuppressWarnings("deprecation")
					String motpass=passwordField.getText().toString();
					 PreparedStatement stm=a.con.prepareStatement("insert into dataadmin VALUES(?,?)   ");  
 
						 stm.setString(1,users);
						stm.setString(2,motpass);
				        stm.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Added") ;
				        stm.close();																																																																																																																																																																																																																																																																																																																																																																																		
				        

					   //step5 close the connection object  
					a.con.close();  
					  
					  }
				  catch(Exception e1){ 
					
	                     /*
						  * beep de Warning
						 */
						Toolkit.getDefaultToolkit().beep();
					   JOptionPane.showMessageDialog(null, "Not Added!! car :"+e.toString()) ;
					  }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(403, 254, 147, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(127, 255, 212));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(605, 263, 77, 38);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 175, 233, 44);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(290, 92, 233, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New Admin LogIn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(100, 90, 169, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(100, 179, 169, 33);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\Image\\Nouveau dossier\\2411.jpg"));
		lblNewLabel_1.setBounds(0, 0, 715, 321);
		contentPane.add(lblNewLabel_1);
	}
}
