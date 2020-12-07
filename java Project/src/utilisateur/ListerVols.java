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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class ListerVols extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListerVols frame = new ListerVols();
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
	public ListerVols() {
		setTitle("Lister Les Vols");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 11, 712, 281);
		contentPane.add(scrollPane);
		
		table = new JTable();
		/*
		 * Un petit Test Pour trouvez comment faire valider les billet 
		 * 
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int a;
				a=table.getSelectedRow();
				JOptionPane.showMessageDialog(null, "Vous avez selectionner la ligne No "+String.valueOf(a)) ;
			}
		});
		*/
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(255, 248, 220));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnNewButton_1.setBounds(521, 332, 106, 56);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("Imprimer");
		btnNewButton_1_1.setBackground(new Color(224, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MessageFormat header=new MessageFormat("Tableau de toutes Les Vols");
					MessageFormat footer=new MessageFormat("Page 1/1");
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					
				}catch(Exception pt) {
					System.out.println(pt);}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(87, 332, 115, 56);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton = new JButton("Actualiser");
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 17));
		btnNewButton.setBounds(259, 333, 185, 55);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\2411.jpg"));
		lblNewLabel.setBounds(0, 0, 762, 399);
		contentPane.add(lblNewLabel);
		UpdateTable();
	}
	private void tab( java.awt.event.MouseEvent evt) {
		int a;
		a=table.getSelectedRow();
		JOptionPane.showMessageDialog(null, String.valueOf(a)) ;
	
	}
	public void UpdateTable() {
		try{ 
			Dbconnect a=new Dbconnect(); 
				//step3 create the statement object  
				   Statement stmt=a.con.createStatement(); 
				   //step4 execute query  
				   ResultSet rs=stmt.executeQuery("select * from vol");  // where login="+ch1.toString()+" and MDP="+ch2
					    table.setModel(DbUtils.resultSetToTableModel(rs));
				   //step5 close the connection object  
				a.con.close();  
				  
				  }
			  catch(Exception e1){ 
				
				   System.out.println(e1);
				  }
	}
}
