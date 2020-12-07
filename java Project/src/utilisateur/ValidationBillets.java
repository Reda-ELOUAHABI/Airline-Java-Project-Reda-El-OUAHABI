package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ValidationBillets extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidationBillets frame = new ValidationBillets();
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
	public ValidationBillets() {
		setTitle("Validation des Billets");
		//JLabel backgr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1093, 572);
		contentPane = new JPanel();
		//setIconImage(Toolkit.getDefaultToolkit().getImage("/2411.jpg"));
	    //ImageIcon img=new ImageIcon("/2411.jpg");
	    //backgr=new JLabel("",img,JLabel.CENTER);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Veuillez choisir les  *** NO des Places***  de Voyageur dont l'etat est \"non valid\u00E9\" pour les valider !\r\n");
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel.setBounds(17, 23, 1052, 61);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 1059, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object a;//JOptionPane.showMessageDialog(null, "Vous avez selectionner la ligne/col :") ;
				a= table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
				String intermidiare=String.valueOf(a);
				
				JOptionPane.showMessageDialog(null, "Vous avez selectionner la Place No :"+intermidiare) ;
		int ff=Integer.parseInt(intermidiare);
			
			 int result = JOptionPane.showConfirmDialog(null,"Voulez Vous Vraiment Valider cette Billet", "Validation Billet",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	try{ 
			        			Dbconnect bd=new Dbconnect(); 
			        			ResultSet rs;
			        			 PreparedStatement stm=null;
			        			 stm=bd.getConn().prepareStatement("UPDATE billet SET etat ='validé' WHERE NoPlace =? ");  
			        			 stm.setInt(1,ff );
			        			 rs=stm.executeQuery();	
			        				   stm.close();
			        				bd.con.close();  
			        				  }
			        			  catch(Exception e1){ 
			        				
			                          /*
			     					  * beep de Warning
			     					 */
			     					Toolkit.getDefaultToolkit().beep();
			     					JOptionPane.showMessageDialog(null,e1);
			        				  }
			            }else if (result == JOptionPane.NO_OPTION){
			            	JOptionPane.showMessageDialog(null, "Vous avez annuler la validation") ;
			            }else {
			            	JOptionPane.showMessageDialog(null, "Vous avez annuler la validation") ;
			            }
			            
			}
	
		});
		JButton btnNewButton = new JButton("Imprimer La Liste Des Billets\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MessageFormat header=new MessageFormat("Tableau de toutes Les Billets");
					MessageFormat footer=new MessageFormat("Page 1/1");
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					
				}catch(Exception pt) {   /*
					  * beep de Warning
					 */
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,pt);
					}
			}
			
		});
		btnNewButton.setBackground(new Color(147, 112, 219));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(55, 471, 323, 53);
		contentPane.add(btnNewButton);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnActualiser.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnActualiser.setBackground(new Color(127, 255, 212));
		btnActualiser.setBounds(469, 471, 323, 53);
		contentPane.add(btnActualiser);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\Image\\Nouveau dossier\\2411.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1079, 535);
		contentPane.add(lblNewLabel_1);
		UpdateTable();
	}
public void UpdateTable() {
		
		try{ 
			Dbconnect a=new Dbconnect(); 
			ResultSet rs;
			 PreparedStatement stm=null;
			 stm=a.getConn().prepareStatement("SELECT NoPlace ,ETAT,NOBILLET ,DATERESERVATION ,SIEGE ,DATEVOYAGE ,VILLEDEPART ,VILLEARRIVEE ,HEUREDEPART ,HEUREARRIVEE FROM billet ");  
			// stm.setInt(1, ChoisirPlace.getPlace(ChoisirPlace.InformationPlace));
			 rs=stm.executeQuery();	
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			/*
			//step3 create the statement object  
			   Statement stmt=a.con.createStatement(); 
			   //step4 execute query  
			   ResultSet rs=stmt.executeQuery("select * from  billet w");  // where login="+ch1.toString()+" and MDP="+ch2
				    table_1.setModel(DbUtils.resultSetToTableModel(rs));
				   //step5 close the connection object  
				    * */
				  stm.close(); 
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
