package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ListerVoyageur extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListerVoyageur frame = new ListerVoyageur();
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
	public ListerVoyageur() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(127, 255, 212));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(550, 222, 107, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Actualiser");
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton.setBounds(230, 223, 214, 59);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 676, 188);
		contentPane.add(scrollPane);
		
		table = new JTable();
		UpdateTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1_1 = new JButton("Print");
		btnNewButton_1_1.setBackground(new Color(34, 139, 34));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MessageFormat header=new MessageFormat("Tableau de toutes Les Voyageurs");
					MessageFormat footer=new MessageFormat("Page 1/1");
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					
				}catch(Exception pt) {
					   /*
					  * beep de Warning
					 */
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,pt);}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1_1.setBounds(34, 222, 107, 59);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\Image\\Nouveau dossier\\2411.jpg"));
		lblNewLabel.setBounds(0, 0, 696, 304);
		contentPane.add(lblNewLabel);
	}

	public void UpdateTable() {
		try{ 
			Dbconnect a=new Dbconnect(); 
				//step3 create the statement object  
				   Statement stmt=a.con.createStatement(); 
				   //step4 execute query  
				   ResultSet rs=stmt.executeQuery("select * from datausers");  // where login="+ch1.toString()+" and MDP="+ch2
					    table.setModel(DbUtils.resultSetToTableModel(rs));
				   //step5 close the connection object  
				a.con.close();  
				  
				  }
			  catch(Exception e1){ 
				   /*
					  * beep de Warning
					 */
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,e1);
				  }
	}
}
