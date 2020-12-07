package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class ListerAvions extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListerAvions frame = new ListerAvions();
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
	public ListerAvions() {
		setTitle("Lister les Avions");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 538, 147);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		UpdateTable();
		JButton btnNewButton = new JButton("Actualiser");
		btnNewButton.setBackground(new Color(255, 182, 193));
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnNewButton.setBounds(233, 199, 134, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(152, 251, 152));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(414, 198, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Imprimer");
		btnNewButton_1_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MessageFormat header=new MessageFormat("Tableau de toutes Les Avions");
					MessageFormat footer=new MessageFormat("Page 1/1");
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					
				}catch(Exception pt) {
					
                    /*
					  * beep de Warning
					 */
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,pt);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1_1.setBounds(77, 199, 106, 37);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\2411.jpg"));
		lblNewLabel.setBounds(0, 0, 558, 261);
		contentPane.add(lblNewLabel);
		
	}
	public void UpdateTable() {
		try{ 
			Dbconnect a=new Dbconnect(); 
				//step3 create the statement object  
				   Statement stmt=a.con.createStatement(); 
				   //step4 execute query  
				   ResultSet rs=stmt.executeQuery("select * from avion");  // where login="+ch1.toString()+" and MDP="+ch2
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
