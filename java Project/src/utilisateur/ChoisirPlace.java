package utilisateur;

import java.awt.BorderLayout;
import utilisateur.VoyageurUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ChoisirPlace extends JFrame {
 public ArrayList <JButton> pl=null;
 public static String InformationPlace ;
 public static int place ;
 private boolean PlaceChoisi=false;
 private boolean[] reservee= {false,false,false,false,false,false,false,
		 false,false,false,false,false,false,false,false,false,false,
		 false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
 /*
  * for(int i=0;i<32;i++) {System.out.print("false,");   }
  */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoisirPlace frame = new ChoisirPlace();
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
	public ChoisirPlace() {
		setTitle("Choix De la Place");
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 439, 397);
		contentPane = new JPanel();
		this.setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MyGraphics Pan = new MyGraphics();
		contentPane.add(Pan);
		
		Pan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x=e.getX(); int y=e.getY();
				//System.out.println(x);
				//System.out.println("et pour Y");
				//System.out.println(y);
				
				/*
				 * J'abandonne de definir l'action sur les element Graphics avec ces methodes getX et GetY ,
				 *  et j'utilise alors des bouton Transparents.
				 */

			}
		});
		JLabel lblNewLabel = new JLabel("Choisir La place que vous voulez :");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(110, 11, 296, 28);
		Pan.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Si\u00E8ge Primium");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(73, 232, 92, 21);
		Pan.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Si\u00E8ge First");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(73, 264, 92, 21);
		Pan.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Si\u00E8ge Standard");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_2.setBounds(217, 232, 92, 21);
		Pan.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Place Ocupp\u00E9e");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_3.setBounds(217, 264, 92, 21);
		Pan.add(lblNewLabel_1_1_3);
		
		JButton Place1 = new JButton("");
		Place1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(1)==false) {
					InformationPlace="Place No 1 -- Siege Premium ";
					
					PlaceChoisi=true;
					Place1.setBackground(Color.red);
					Place1.setOpaque(true);
					place=1;
				}
				else if (IsReserved(1)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
			}
		});
		Place1.setOpaque(false);
		Place1.setContentAreaFilled(false);
		Place1.setBorderPainted(true);
		Place1.setBounds(55, 45, 30, 30);
		Pan.add(Place1);
		JButton Place2 = new JButton("");
		Place2.setFont(new Font("Tahoma", Font.PLAIN, 5));
		Place2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(2)==false) {
					InformationPlace="Place No 2 -- Siege Premium ";
					PlaceChoisi=true;
					Place2.setBackground(Color.red);
					Place2.setOpaque(true);
					place=2;
				}
				else if (IsReserved(2)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
			}
		});
		Place2.setOpaque(false);
		Place2.setContentAreaFilled(false);
		Place2.setBorderPainted(true);
		Place2.setBounds(55,85, 30, 30);
		Pan.add(Place2);
	
		JButton Place3 = new JButton("");
		Place3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(3)==false) {
					InformationPlace="Place No 3 -- Siege Premium ";
					PlaceChoisi=true;
					Place3.setBackground(Color.red);
					Place3.setOpaque(true);
					place=3;
				}
				else if (IsReserved(3)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place3.setOpaque(false);
		Place3.setContentAreaFilled(false);
		Place3.setBorderPainted(true);
		Place3.setBounds(55,135, 30, 30);
		Pan.add(Place3);
		
		JButton Place4 = new JButton("");
		Place4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(4)==false) {
					InformationPlace="Place No 4 -- Siege Premium ";
					PlaceChoisi=true;
					Place4.setBackground(Color.red);
					Place4.setOpaque(true);place=4;
				}
				else if (IsReserved(4)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
			}
		});
		Place4.setOpaque(false);
		Place4.setContentAreaFilled(false);
		Place4.setBorderPainted(true);
		Place4.setBounds(55,175, 30, 30);
		Pan.add(Place4);
		
		JButton Place5 = new JButton("");
		Place5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(5)==false) {
					InformationPlace="Place No 5 -- Siege Premium ";
					PlaceChoisi=true;
					Place5.setBackground(Color.red);
					Place5.setOpaque(true);place=5;
				}
				else if (IsReserved(5)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");}
		});
		Place5.setOpaque(false);
		Place5.setContentAreaFilled(false);
		Place5.setBorderPainted(true);
		Place5.setBounds(95,45, 30, 30); 
		Pan.add(Place5);
		
		JButton Place6 = new JButton("");
		Place6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(6)==false) {
					InformationPlace="Place No 6 -- Siege Premium ";
					PlaceChoisi=true;
					Place6.setBackground(Color.red);
					Place6.setOpaque(true);place=6;
				}
				else if (IsReserved(6)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place6.setOpaque(false);
		Place6.setContentAreaFilled(false);
		Place6.setBorderPainted(true);
		Place6.setBounds(95,85, 30, 30);
		Pan.add(Place6);
		
		JButton Place7 = new JButton("");
		Place7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false&& IsReserved(7)==false) {
					InformationPlace="Place No 7 -- Siege Premium ";
					PlaceChoisi=true;
					Place7.setBackground(Color.red);
					Place7.setOpaque(true);place=7;
				}
				else if (IsReserved(7)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place7.setOpaque(false);
		Place7.setContentAreaFilled(false);
		Place7.setBorderPainted(true);
		Place7.setBounds(95,135, 30, 30);
		Pan.add(Place7);
		
		JButton Place8 = new JButton("");
		Place8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(8)==false) {
					InformationPlace="Place No 8 -- Siege Premium ";
					PlaceChoisi=true;
					Place8.setBackground(Color.red);
					Place8.setOpaque(true);place=8;
				}
				else if (IsReserved(8)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place8.setOpaque(false);
		Place8.setContentAreaFilled(false);
		Place8.setBorderPainted(true);
		Place8.setBounds(95,175, 30, 30);
		Pan.add(Place8);
		
		JButton Place9 = new JButton("");
		Place9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(9)==false) {
					//InformationPlace="Place No 1 -- Siege First ";
					InformationPlace="Place No 9 -- Siege First ";
					PlaceChoisi=true;
					Place9.setBackground(Color.red);
					Place9.setOpaque(true);place=9;
				}
				else if (IsReserved(9)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
			}
		});
		Place9.setOpaque(false);
		Place9.setContentAreaFilled(false);
		Place9.setBorderPainted(true);
		Place9.setBounds(135, 45, 30, 30);
		Pan.add(Place9);
		
		JButton Place10 = new JButton("");
		Place10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (PlaceChoisi==false && IsReserved(10)==false) {
					//InformationPlace="Place No 2 -- Siege First ";
					InformationPlace="Place No 10 -- Siege First ";
					PlaceChoisi=true;
					Place10.setBackground(Color.red);
					Place10.setOpaque(true);place=10;
				}
				else if (IsReserved(10)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");}
		});
		Place10.setOpaque(false);
		Place10.setContentAreaFilled(false);
		Place10.setBorderPainted(true);
		Place10.setBounds(135, 85, 30, 30);
		Pan.add(Place10);
		
		JButton Place11 = new JButton("");
		Place11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(11)==false) {
					//InformationPlace="Place No 3 -- Siege First ";
					InformationPlace="Place No 11 -- Siege First ";
					PlaceChoisi=true;
					Place11.setBackground(Color.red);
					Place11.setOpaque(true);place=11;
				}
				else if (IsReserved(11)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place11.setOpaque(false);
		Place11.setContentAreaFilled(false);
		Place11.setBorderPainted(true);
		Place11.setBounds(135, 135, 30, 30);
		Pan.add(Place11);
		
		JButton Place12 = new JButton("");
		Place12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(12)==false) {
					//InformationPlace="Place No 4 -- Siege First ";
					InformationPlace="Place No 12 -- Siege First ";
					PlaceChoisi=true;
					Place12.setBackground(Color.red);
					Place12.setOpaque(true);place=12;
				}
				else if (IsReserved(12)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place12.setOpaque(false);
		Place12.setContentAreaFilled(false);
		Place12.setBorderPainted(true);
		Place12.setBounds(135, 175, 30, 30);
		Pan.add(Place12);
		
		JButton Place13 = new JButton("");
		Place13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(13)==false) {
					//InformationPlace="Place No 5 -- Siege First ";
					InformationPlace="Place No 13 -- Siege First ";
					PlaceChoisi=true;
					Place13.setBackground(Color.red);
					Place13.setOpaque(true);place=13;
				}
				else if (IsReserved(13)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place13.setOpaque(false);
		Place13.setContentAreaFilled(false);
		Place13.setBorderPainted(true);
		Place13.setBounds(175, 45, 30, 30);
		Pan.add(Place13);
		
		JButton Place14 = new JButton("");
		Place14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(14)==false) {
					//InformationPlace="Place No 6 -- Siege First ";
					InformationPlace="Place No 14 -- Siege First ";
					PlaceChoisi=true;
					Place14.setBackground(Color.red);
					Place14.setOpaque(true);place=14;
				}
				else if (IsReserved(14)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
			}
		});
		Place14.setOpaque(false);
		Place14.setContentAreaFilled(false);
		Place14.setBorderPainted(true);
		Place14.setBounds(175, 85, 30, 30);
		Pan.add(Place14);
		
		JButton Place15 = new JButton("");
		Place15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(15)==false) {
					//InformationPlace="Place No 7 -- Siege First ";
					InformationPlace="Place No 15 -- Siege First ";
					PlaceChoisi=true;
					Place15.setBackground(Color.red);
					Place15.setOpaque(true);place=15;
				}
				else if (IsReserved(15)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
			}
		});
		Place15.setOpaque(false);
		Place15.setContentAreaFilled(false);
		Place15.setBorderPainted(true);
		Place15.setBounds(175, 135, 30, 30);
		Pan.add(Place15);
		
		JButton Place16 = new JButton("");
		Place16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(16)==false) {
					//InformationPlace="Place No 8 -- Siege First ";
					InformationPlace="Place No 16 -- Siege First ";
					PlaceChoisi=true;
					Place16.setBackground(Color.red);
					Place16.setOpaque(true);place=16;
				}
				else if (IsReserved(16)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
			}
		});
		Place16.setOpaque(false);
		Place16.setContentAreaFilled(false);
		Place16.setBorderPainted(true);
		Place16.setBounds(175, 175, 30, 30);
		Pan.add(Place16);
		
		JButton Place17 = new JButton("");
		Place17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(17)==false) {
					//InformationPlace="Place No 9 -- Siege First ";
					InformationPlace="Place No 17 -- Siege First ";
					PlaceChoisi=true;
					Place17.setBackground(Color.red);
					Place17.setOpaque(true);place=17;
				}
				else if (IsReserved(17)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");}
		});
		Place17.setOpaque(false);
		Place17.setContentAreaFilled(false);
		Place17.setBorderPainted(true);
		Place17.setBounds(215, 45, 30, 30);
		Pan.add(Place17);
		
		JButton Place18 = new JButton("");
		Place18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (PlaceChoisi==false && IsReserved(18)==false) {
					//InformationPlace="Place No 10 -- Siege First ";
					InformationPlace="Place No 18 -- Siege First ";
					PlaceChoisi=true;
					Place18.setBackground(Color.red);
					Place18.setOpaque(true);place=18;
				}
				else if (IsReserved(18)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place18.setOpaque(false);
		Place18.setContentAreaFilled(false);
		Place18.setBorderPainted(true);
		Place18.setBounds(215, 85, 30, 30);
		Pan.add(Place18);
		
		JButton Place19 = new JButton("");
		Place19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (PlaceChoisi==false && IsReserved(19)==false) {
				//	InformationPlace="Place No 11 -- Siege First ";
					InformationPlace="Place No 19 -- Siege First ";
					PlaceChoisi=true;
					Place19.setBackground(Color.red);
					Place19.setOpaque(true);place=19;
				}
				else if (IsReserved(19)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place19.setOpaque(false);
		Place19.setContentAreaFilled(false);
		Place19.setBorderPainted(true);
		Place19.setBounds(215, 135, 30, 30);
		Pan.add(Place19);
		
		JButton Place20 = new JButton("");
		Place20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (PlaceChoisi==false && IsReserved(20)==false) {
					//InformationPlace="Place No 12 -- Siege First ";
					InformationPlace="Place No 20 -- Siege First ";
					PlaceChoisi=true;
					Place20.setBackground(Color.red);
					Place20.setOpaque(true);place=20;
				}
				else if (IsReserved(20)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place20.setOpaque(false);
		Place20.setContentAreaFilled(false);
		Place20.setBorderPainted(true);
		Place20.setBounds(215, 175, 30, 30);
		Pan.add(Place20);
		
		JButton Place21 = new JButton("");
		Place21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(21)==false) {
					InformationPlace="Place No 21 -- Siege Standard ";
					PlaceChoisi=true;
					Place21.setBackground(Color.red);
					Place21.setOpaque(true);place=21;
				}
				else if (IsReserved(21)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
			}
		});
		Place21.setOpaque(false);
		Place21.setContentAreaFilled(false);
		Place21.setBorderPainted(true);
		Place21.setBounds(255, 45, 30, 30);
		Pan.add(Place21);
		
		JButton Place22 = new JButton("");
		Place22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(22)==false) {
					InformationPlace="Place No 22 -- Siege Standard ";
					PlaceChoisi=true;
					Place22.setBackground(Color.red);
					Place22.setOpaque(true);place=22;
				}
				else if (IsReserved(22)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place22.setOpaque(false);
		Place22.setContentAreaFilled(false);
		Place22.setBorderPainted(true);
		Place22.setBounds(255, 85, 30, 30);
		Pan.add(Place22);
		
		JButton Place23 = new JButton("");
		Place23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(23)==false) {
					InformationPlace="Place No 23 -- Siege Standard ";
					PlaceChoisi=true;
					Place23.setBackground(Color.red);
					Place23.setOpaque(true);place=23;
				}
				else if (IsReserved(23)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place23.setOpaque(false);
		Place23.setContentAreaFilled(false);
		Place23.setBorderPainted(true);
		Place23.setBounds(255, 135, 30, 30);
		Pan.add(Place23);
		
		JButton Place24 = new JButton("");
		Place24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(24)==false) {
					InformationPlace="Place No 24 -- Siege Standard ";
					PlaceChoisi=true;
					Place24.setBackground(Color.red);
					Place24.setOpaque(true);place=24;
				}
				else if (IsReserved(24)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place24.setOpaque(false);
		Place24.setContentAreaFilled(false);
		Place24.setBorderPainted(true);
		Place24.setBounds(255, 175, 30, 30);
		Pan.add(Place24);
		
		JButton Place25 = new JButton("");
		Place25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(25)==false) {
					InformationPlace="Place No 25 -- Siege Standard ";
					PlaceChoisi=true;
					Place25.setBackground(Color.red);
					Place25.setOpaque(true);place=25;
				}
				else if (IsReserved(25)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place25.setOpaque(false);
		Place25.setContentAreaFilled(false);
		Place25.setBorderPainted(true);
		Place25.setBounds(295, 45, 30, 30);
		Pan.add(Place25);
		
		JButton Place26 = new JButton("");
		Place26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(26)==false) {
					InformationPlace="Place No 26 -- Siege Standard ";
					PlaceChoisi=true;
					Place26.setBackground(Color.red);
					Place26.setOpaque(true);place=26;
				}
				else if (IsReserved(26)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place26.setOpaque(false);
		Place26.setContentAreaFilled(false);
		Place26.setBorderPainted(true);
		Place26.setBounds(295, 85, 30, 30);
		Pan.add(Place26);
		
		JButton Place27 = new JButton("");
		Place27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(27)==false) {
					InformationPlace="Place No 27 -- Siege Standard ";
					PlaceChoisi=true;
					Place27.setBackground(Color.red);
					Place27.setOpaque(true);place=27;
				}
				else if (IsReserved(27)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place27.setOpaque(false);
		Place27.setContentAreaFilled(false);
		Place27.setBorderPainted(true);
		Place27.setBounds(295, 135, 30, 30);
		Pan.add(Place27);
		
		JButton Place28 = new JButton("");
		Place28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==false && IsReserved(28)==false) {
					InformationPlace="Place No 28 -- Siege Standard ";
					PlaceChoisi=true;
					Place28.setBackground(Color.red);
					Place28.setOpaque(true);place=28;
				}
				else if (IsReserved(28)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place28.setOpaque(false);
		Place28.setContentAreaFilled(false);
		Place28.setBorderPainted(true);
		Place28.setBounds(295, 175, 30, 30);
		Pan.add(Place28);
		
		JButton Place29 = new JButton("");
		Place29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (PlaceChoisi==false && IsReserved(29)==false) {
					InformationPlace="Place No 29 -- Siege Standard ";
					PlaceChoisi=true;
					Place29.setBackground(Color.red);
					Place29.setOpaque(true);place=29;
				}
				else if (IsReserved(29)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place29.setOpaque(false);
		Place29.setContentAreaFilled(false);
		Place29.setBorderPainted(true);
		Place29.setBounds(335, 45, 30, 30);
		Pan.add(Place29);
		
		JButton Place30 = new JButton("");
		Place30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (PlaceChoisi==false && IsReserved(30)==false) {
					InformationPlace="Place No 30 -- Siege Standard ";
					PlaceChoisi=true;
					Place30.setBackground(Color.red);
					Place30.setOpaque(true);place=30;
				}
				else if (IsReserved(30)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place30.setOpaque(false);
		Place30.setContentAreaFilled(false);
		Place30.setBorderPainted(true);
		Place30.setBounds(335, 85, 30, 30);
		Pan.add(Place30);
		
		JButton Place31 = new JButton("");
		Place31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (PlaceChoisi==false && IsReserved(31)==false) {
					InformationPlace="Place No 31 -- Siege Standard ";
					PlaceChoisi=true;
					Place31.setBackground(Color.red);
					Place31.setOpaque(true);place=31;
				}
				else if (IsReserved(31)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place31.setOpaque(false);
		Place31.setContentAreaFilled(false);
		Place31.setBorderPainted(true);
		Place31.setBounds(335, 135, 30, 30);
		Pan.add(Place31);
		
		JButton Place32 = new JButton("");
		Place32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (PlaceChoisi==false && IsReserved(32)==false) {
					InformationPlace="Place No 32 -- Siege Standard ";
					PlaceChoisi=true;
					Place32.setBackground(Color.red);
					Place32.setOpaque(true);place=32;
				}
				else if (IsReserved(32)) JOptionPane.showMessageDialog(null, "cette place selectionnée est déja Reservée  !");
				else JOptionPane.showMessageDialog(null, "Vous avez deja selectionner une Place !");
				}
		});
		Place32.setOpaque(false);
		Place32.setContentAreaFilled(false);
		Place32.setBorderPainted(true);
		Place32.setBounds(335, 175, 30, 30);
		Pan.add(Place32);
		
		JButton btnNewButton_14 = new JButton("Valider");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlaceChoisi==true) {
					VoyageurUI.Valid=true;
					JOptionPane.showMessageDialog(null, "Vous avez Choisir la Place : "+InformationPlace);
					dispose();
				}
				if (PlaceChoisi==false) {
					VoyageurUI.Valid=true;
					JOptionPane.showMessageDialog(null, "Vous n'avez Pas choisir Une Place !");
				}
			}
		});
		btnNewButton_14.setBackground(Color.MAGENTA);
		btnNewButton_14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_14.setBounds(320, 300, 92, 34);
		Pan.add(btnNewButton_14);
		
		JButton btnNewButton_14_1 = new JButton("Rechoisir");
		btnNewButton_14_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ChoisirPlace().setVisible(true);
			}
		});
		btnNewButton_14_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_14_1.setBackground(Color.GREEN);
		btnNewButton_14_1.setBounds(175, 300, 121, 34);
		Pan.add(btnNewButton_14_1);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Votre Place");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_4.setBounds(10, 296, 80, 21);
		Pan.add(lblNewLabel_1_1_4);
		/*
		 * Coloration des Places deja reservees !
		 */
		   ReloadPlaces();
		  if (IsReserved(1)) {
		    	Place1.setBackground(Color.blue);
				Place1.setOpaque(true);
		    }
		    if (IsReserved(2)) {
		    	Place2.setBackground(Color.blue);
				Place2.setOpaque(true); } 
		    
		    if (IsReserved(3)) {Place3.setBackground(Color.blue);Place3.setOpaque(true); }
		    if (IsReserved(4)) {Place4.setBackground(Color.blue);Place4.setOpaque(true); }
		    if (IsReserved(5)) {Place5.setBackground(Color.blue);Place5.setOpaque(true); }
		    if (IsReserved(6)) {Place6.setBackground(Color.blue);Place6.setOpaque(true); }
		    if (IsReserved(7)) {Place7.setBackground(Color.blue);Place7.setOpaque(true); }
		    if (IsReserved(8)) {Place8.setBackground(Color.blue);Place8.setOpaque(true); }
		    if (IsReserved(9)) {Place9.setBackground(Color.blue);Place9.setOpaque(true); }
		    
		    if (IsReserved(10)) {Place10.setBackground(Color.blue);Place10.setOpaque(true); }
		    if (IsReserved(11)) {Place11.setBackground(Color.blue);Place11.setOpaque(true); }
		    if (IsReserved(12)) {Place12.setBackground(Color.blue);Place12.setOpaque(true); }
		    if (IsReserved(13)) {Place13.setBackground(Color.blue);Place13.setOpaque(true); }
		    if (IsReserved(14)) {Place14.setBackground(Color.blue);Place14.setOpaque(true); }
		    if (IsReserved(15)) {Place15.setBackground(Color.blue);Place15.setOpaque(true); }
		    if (IsReserved(16)) {Place16.setBackground(Color.blue);Place16.setOpaque(true); }
		    if (IsReserved(17)) {Place17.setBackground(Color.blue);Place17.setOpaque(true); }
		    if (IsReserved(18)) {Place18.setBackground(Color.blue);Place18.setOpaque(true); }
		    if (IsReserved(19)) {Place19.setBackground(Color.blue);Place19.setOpaque(true); }
		    if (IsReserved(20)) {Place20.setBackground(Color.blue);Place20.setOpaque(true); }
		    if (IsReserved(21)) {Place21.setBackground(Color.blue);Place21.setOpaque(true); }
		    if (IsReserved(22)) {Place22.setBackground(Color.blue);Place22.setOpaque(true); }
		    if (IsReserved(23)) {Place23.setBackground(Color.blue);Place23.setOpaque(true); }
		    if (IsReserved(24)) {Place24.setBackground(Color.blue);Place24.setOpaque(true); }
		    if (IsReserved(25)) {Place25.setBackground(Color.blue);Place25.setOpaque(true); }
		    if (IsReserved(26)) {Place26.setBackground(Color.blue);Place26.setOpaque(true); }
		    if (IsReserved(27)) {Place27.setBackground(Color.blue);Place27.setOpaque(true); }
		    if (IsReserved(28)) {Place28.setBackground(Color.blue);Place28.setOpaque(true); }
		    if (IsReserved(29)) {Place29.setBackground(Color.blue);Place29.setOpaque(true); }
		    if (IsReserved(30)) {Place30.setBackground(Color.blue);Place30.setOpaque(true); }
		    if (IsReserved(31)) {Place31.setBackground(Color.blue);Place31.setOpaque(true); }
		    if (IsReserved(32)) {Place32.setBackground(Color.blue);Place32.setOpaque(true); }
		
	}
	private boolean IsReserved(int i) {
		boolean b = false;
		if(reservee[i]==true) {
			b=true;
		}
		else if(reservee[i]==false) b=false;
		return b;
	}
	public static int getPlace(String I) {
		/*
		 * En fait entrer Notre String de siege selectionnee qui contien un numero de place , on fait extraire ce numero 
		 */
		String Place=I;
		   String[] a=Place.split("\\ ");
             return Integer.parseInt(a[2]) ;
	}
	public void ReloadPlaces() {
	for(int i=1 ;i<=32;i++) {
		try{
				Dbconnect conn=new Dbconnect() ;
               int j = 0;
	      //  String Siege=ChoisirPlace.InformationPlace;
	        //int PF=ChoisirPlace.getPlace(ChoisirPlace.InformationPlace);
           //JOptionPane.showMessageDialog(null, "here !") ;
			 PreparedStatement stm=null;
			 ResultSet rs;
			 
         	stm=conn.getConn().prepareStatement("Select count(*) From billet where NoPlace=?  ");  
	        stm.setInt(1,i);
				 rs=stm.executeQuery();	
				 
				 while(rs.next()) {
				if(rs.getInt("count(*)")>0){
					
					//System.out.println(rs.getInt("count(*)"));
						reservee[i]=true;
						//cad f achaque appelle de cette fct , il va remplir le tableau reservee par des true or false selon le contenue de bdd !
						 j++;//c'est un conteur des places reservee 
			             //JOptionPane.showMessageDialog(null, "cette place est reservee  !"+String.valueOf(i)) ;//+String.valueOf(j)
						  //pl.add((JButton)("Place"+String.valueOf(PF)));
						// pl<1>.Opa
					}
				   }
			//JOptionPane.showMessageDialog(null, String.valueOf(j)+"Demande Effectuee !") ;	   
	        stm.close();
	        conn.getConn().close();
	        //JOptionPane.showMessageDialog(null, "Demande Effectuee !") ;
			}
	catch(Exception er)
	    {
        /*
		  * beep de Warning
		 */
		Toolkit.getDefaultToolkit().beep();
	        JOptionPane.showMessageDialog(null,er);
	    }	
		}
		/*for(int i=0 ;i<32;i++) {
			try{
					 Dbconnect conn=new Dbconnect() ;
                        int j = 0;
			        
			        String Siege=ChoisirPlace.InformationPlace;
			        int PF=ChoisirPlace.getPlace(ChoisirPlace.InformationPlace);
                    JOptionPane.showMessageDialog(null, "here !") ;
			        JOptionPane.showMessageDialog(null, "here !") ;
					 PreparedStatement stm=null;
					 ResultSet rs;
		          	stm=conn.getConn().prepareStatement("Select count(*) From billet where NoPlace=?  ");  
			        stm.setInt(1,PF);
						 rs=stm.executeQuery();	
						 
						 while(rs.next()) {
							 if(rs.getInt("count(*)")!=0);{
								 reservee[i]=true;
								 j++;
								  //pl.add((JButton)("Place"+String.valueOf(PF)));
								// pl<1>.Opa
							 }
						   }
					JOptionPane.showMessageDialog(null, String.valueOf(j)+"Demande Effectuee !") ;	   
			        stm.close();
			        conn.getConn().close();
			        JOptionPane.showMessageDialog(null, "Demande Effectuee !") ;
			        
			          
				 }
			catch(Exception er)
			    {
			        JOptionPane.showMessageDialog(null,er);
			    }
		}*/
	}
}
