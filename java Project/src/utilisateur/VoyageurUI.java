package utilisateur;

import java.awt.BorderLayout;
import utilisateur.ChoisirPlace;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.time.*;


import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
public class VoyageurUI extends JFrame {
 public static int  NoBillet=1;
 boolean done=false;
 public static int nbplaces=32;
 public static int placeFinal=ChoisirPlace.place;
 public static boolean Valid =false;
 private JPanel contentPane;
 private JTable table_1;
 
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoyageurUI frame = new VoyageurUI();
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
	public VoyageurUI() {
		setTitle("Espace Voyageur");
		
		setBackground(new Color(135, 206, 250));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("/2411.png"));
		setBounds(100, 100, 1009, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox<String> VilleDepart = new JComboBox<String>();
		VilleDepart.setBackground(new Color(147, 112, 219));
		
		
		try{ 
		Dbconnect a=new Dbconnect(); 
			//step3 create the statement object  
			   Statement stmt=a.con.createStatement(); 
			   System.out.println("hiii");
			   //step4 execute query  
			   ResultSet rs=stmt.executeQuery("select villeDepart from vol");  // where login="+ch1.toString()+" and MDP="+ch2
			
			   
			   while(rs.next())  {
				   VilleDepart.addItem(rs.getString("villeDepart"));   
			   }
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
		
		VilleDepart.setBounds(209, 45, 84, 48);
		contentPane.add(VilleDepart);
		
		
		JLabel lblNewLabel_2 = new JLabel("Ville de Depart");
		lblNewLabel_2.setFont(new Font("SimSun-ExtB", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10,54, 189, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel VilleArrive = new JLabel("Ville d'Arrivee");
		VilleArrive.setFont(new Font("SimSun-ExtB", Font.BOLD, 18));
		VilleArrive.setBounds(369, 54,189, 28);
		contentPane.add(VilleArrive);
		
		JComboBox<String> VilleArrivee = new JComboBox<String>();
		VilleArrivee.setBackground(new Color(147, 112, 219));
		try{ 
			Dbconnect a=new Dbconnect(); 
				//step3 create the statement object  
				   Statement stmt=a.con.createStatement(); 
				   System.out.println("hiii");
				   //step4 execute query  
				   ResultSet rs=stmt.executeQuery("select villeArrivee from vol"); 
				   // where login="+ch1.toString()+" and MDP="+ch2
				   while(rs.next())  {
					   VilleArrivee.addItem(rs.getString("villeArrivee"));   
				   }
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
		VilleArrivee.setBounds(568, 45, 84, 48);
		contentPane.add(VilleArrivee);
		
		JDateChooser date = new JDateChooser();
		date.getCalendarButton().setBackground(new Color(123, 104, 238));
		date.setBounds(209, 131, 90, 42);
		contentPane.add(date);
		String h;
		JLabel lblNewLabel_2_2 = new JLabel("Jour de Depart");
		lblNewLabel_2_2.setFont(new Font("SimSun-ExtB", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(10, 131, 189, 28);
		contentPane.add(lblNewLabel_2_2);
		
		JComboBox<String> HeureDepart = new JComboBox<String>();
		HeureDepart.setBackground(new Color(147, 112, 219));

	//	boolean existVol =false;

		try{ 
			     Dbconnect a=new Dbconnect(); 
				//step3 create the statement object  
				   Statement stmt=a.con.createStatement(); 
				   System.out.println("hiiiii");
				   //step4 execute query  
				   ResultSet rs=stmt.executeQuery("select HeureDépart,HeureArrivée from vol");  
				   
				   while(rs.next())  {
					   HeureDepart.addItem(rs.getString("HeureDépart"));
				   }
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
		
		
		HeureDepart.setBounds(541, 131, 111, 28);
		contentPane.add(HeureDepart);
		
		h=(String) HeureDepart.getSelectedItem();
	
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Heure de Depart");
		lblNewLabel_2_2_1.setFont(new Font("SimSun-ExtB", Font.BOLD, 18));
		lblNewLabel_2_2_1.setBounds(358, 131, 189, 28);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Heure d'Arrivee");
		lblNewLabel_2_1_1_1.setFont(new Font("SimSun-ExtB", Font.BOLD, 18));
		lblNewLabel_2_1_1_1.setBounds(677, 131, 189, 28);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton_1_1 = new JButton("EXIT");
		btnNewButton_1_1.setBackground(new Color(123, 104, 238));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1_1.setBounds(860, 272, 77, 38);
		contentPane.add(btnNewButton_1_1);
		
		
		
		JButton btnValidationDeVoyage = new JButton("Enregistrer La demande\r\n\r\n");
		btnValidationDeVoyage.setBackground(new Color(221, 160, 221));
		
		btnValidationDeVoyage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Valid) {
					try{
						 if( date.equals(null))
						 {
					            JOptionPane.showMessageDialog(null, "Certains champs sont vides");
					        }
						 else {
							 Dbconnect conn=new Dbconnect() ;
						
					        
					        
					        LocalDateTime today=LocalDateTime.now();
					        String dateRes=today.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
					        System.out.println(String.valueOf(today.getDayOfYear())+
					        		String.valueOf(today.getHour())+String.valueOf(today.getMinute())+
					        		String.valueOf(today.getSecond())+String.valueOf(today.getNano()));
					        
					        //int id=ChoisirPlace.getPlace(ChoisirPlace.InformationPlace)+today.getSecond()+today.getMinute()+today;
					        int id=Integer.parseInt(String.valueOf(today.getDayOfYear())+
					        		String.valueOf(today.getHour())+String.valueOf(today.getMinute())+
					        		String.valueOf(today.getSecond()));
					        
					        /*
					         * Vraiment c'est une Valeur Uniue constitue que avec la date a partir d jour de l'annee vers le nano second !
					         *Desciption : Gets the nano-of-second field.
                             *Returns:the nano-of-second, from 0 to 999,999,999
					         */
					        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						    String dateVoy = sdf.format(date.getDate());
						    
					        
					        String heureDep=(String) HeureDepart.getSelectedItem();
					        String heureArr=GetHeureArrivee(heureDep);
					        
					        String Siege=ChoisirPlace.InformationPlace;
					        int PF=ChoisirPlace.getPlace(ChoisirPlace.InformationPlace);

						    String VilDep=VilleDepart.getSelectedItem().toString();
					        String VilArr=VilleArrivee.getSelectedItem().toString();
					        
							 PreparedStatement stm=null;
				          	stm=conn.getConn().prepareStatement("INSERT INTO Billet VALUES(?,?,?,?,?,?,?,?,?,?)  ");  
							 
							
					        
							 stm.setInt(1,id);
							 stm.setString(2,dateRes);
					         stm.setString(3,dateVoy);
					        stm.setString(4,heureDep);
					        stm.setString(5,heureArr);
					        stm.setString(6,Siege);
					        stm.setString(7,VilDep);
					        stm.setString(8,VilArr);
					        stm.setString(9,"non Validé");
					        stm.setInt(10,PF);
					        stm.executeUpdate();
					        done=true;
					        stm.close();
					        conn.getConn().close();
					        JOptionPane.showMessageDialog(null, "Demande Effectuee !") ;
					        
								/*
									 String[][] data = {
								{String.valueOf(id),dateRes,dateVoy,heureDep,heureArr,Siege,
									VilDep,VilArr,"non Validé",String.valueOf(PF)}
									};
									String[] coloneTitre= {"No de Billet","Date De Reservation",
											"Date De Voyage","Heure Depart","Heure d'Arrivée",
											"Siege","Ville Depart","Ville Arrivee","Etat de Billet","No Place"};
									//JTable table = new JTable(data,coloneTitre);
									
								
									try {
										MessageFormat header=new MessageFormat("Tableau de toutes Les Avions");
										MessageFormat footer=new MessageFormat("Page 1/1");
										table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
										JOptionPane.showMessageDialog(null, "Demande Effectuee !") ;
										
	
									}catch(Exception pt) {
										JOptionPane.showMessageDialog(null, pt) ;}
										*/
									
								
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
				else JOptionPane.showMessageDialog(null, "Vous Avez Une faute , Verifier Bien !");
			}
		});
		btnValidationDeVoyage.setFont(new Font("Sitka Small", Font.BOLD, 17));
		btnValidationDeVoyage.setBounds(10, 264, 756, 57);
		contentPane.add(btnValidationDeVoyage);
		
		JLabel lblEffectiveDesPlaces = new JLabel("Effective des Places : 32");
		lblEffectiveDesPlaces.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblEffectiveDesPlaces.setBounds(707, 41, 261, 57);
		contentPane.add(lblEffectiveDesPlaces);
		
		JLabel lblNewLabel = new JLabel("Veuillez  remplir  les  differents  cas  et  choisir  la  place  qui  vous convient ! \u2665\u2665");
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 11, 958, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnValidationDeVoyage_1 = new JButton("Reserver La Place =>");
		btnValidationDeVoyage_1.setBackground(new Color(64, 224, 208));
		btnValidationDeVoyage_1.setFont(new Font("Sitka Small", Font.BOLD, 17));
		btnValidationDeVoyage_1.setBounds(10, 194, 756, 57);
		contentPane.add(btnValidationDeVoyage_1);
		
		JLabel lblHeureArrivee = new JLabel("...");
		lblHeureArrivee.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeureArrivee.setBackground(new Color(135, 206, 250));
		lblHeureArrivee.setBounds(843, 131, 111, 25);
		contentPane.add(lblHeureArrivee);
		lblHeureArrivee.setText(GetHeureArrivee(h));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 404, 958, 48);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Aper\u00E7u Votre Billet");
		btnNewButton.setBackground(new Color(255, 127, 80));
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateTable();
			
				
			}
		
		});
		btnNewButton.setBounds(10, 332, 756, 48);
		contentPane.add(btnNewButton);
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(978, 11, 17, 657);
		contentPane.add(scrollBar);
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 664, 975, 25);
		JButton btnImprimerVotreBillet = new JButton("Imprimer Votre Billet");
		btnImprimerVotreBillet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(done ) {
					try {
						MessageFormat header=new MessageFormat("Votre Billet ");
						MessageFormat footer=new MessageFormat("Bon Voyage Page 1/1");
						table_1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
						
					}catch(Exception pt) {

	                     /*
						  * beep de Warning
						 */
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null,pt);}
				}
			}
		});
		btnImprimerVotreBillet.setFont(new Font("Sitka Small", Font.BOLD, 17));
		btnImprimerVotreBillet.setBackground(new Color(0, 250, 154));
		btnImprimerVotreBillet.setBounds(10, 471, 756, 48);
		contentPane.add(btnImprimerVotreBillet);
		
		contentPane.add(slider);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\12631.jpg"));
		lblNewLabel_3.setBounds(0, 0, 995, 553);
		contentPane.add(lblNewLabel_3);
		 
;			btnValidationDeVoyage_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChoisirPlace().setVisible(true);
				
			}
		});	
		HeureDepart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String h=(String) HeureDepart.getSelectedItem();
				lblHeureArrivee.setText(GetHeureArrivee(h));
		}
		});
		VilleDepart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(VilleDepart.getSelectedItem()==VilleArrivee.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "Vous Avez choisir la ville meme que la ville d'arrivee ") ;
					Valid=false;
				}
		}
		});
		VilleArrivee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(VilleDepart.getSelectedItem()==VilleArrivee.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "Vous Avez choisir la ville meme que la ville de depart ") ;
					Valid=false;
				}
		}
		});
		
	}
	public String GetHeureArrivee(String h) {
		String Return = "00:00";
		try{ 
		     Dbconnect a=new Dbconnect(); 
		     ResultSet rs;
			 PreparedStatement stm=null;
			 stm=a.getConn().prepareStatement("select HeureArrivée from vol where HeureDépart=?   ");  
			 stm.setString(1, h);
			 rs=stm.executeQuery();	
			 while(rs.next()) {
				 Return=rs.getString("HeureArrivée");
			   }
			 
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
		return Return;
	}
	public void UpdateTable() {
		
		try{ 
			Dbconnect a=new Dbconnect(); 
			ResultSet rs;
			 PreparedStatement stm=null;
			 stm=a.getConn().prepareStatement("select * from  billet  where NoPlace=? ");  
			 stm.setInt(1, ChoisirPlace.getPlace(ChoisirPlace.InformationPlace));
			 rs=stm.executeQuery();	
			 table_1.setModel(DbUtils.resultSetToTableModel(rs));
			/*
			//step3 create the statement object  
			   Statement stmt=a.con.createStatement(); 
			   //step4 execute query  
			   ResultSet rs=stmt.executeQuery("select * from  billet w");  // where login="+ch1.toString()+" and MDP="+ch2
				    table_1.setModel(DbUtils.resultSetToTableModel(rs));
				   //step5 close the connection object  
				    * */
				   
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