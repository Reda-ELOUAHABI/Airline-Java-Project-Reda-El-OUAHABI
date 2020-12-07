package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SupprimerVol extends JFrame {

	private JPanel contentPane;
	private JTextField noVol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerVol frame = new SupprimerVol();
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
	public SupprimerVol() {
		setTitle("Supprimer Vol");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entrer le No vol \u00E0 Supprimer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 141, 283, 61);
		contentPane.add(lblNewLabel);
		
		noVol = new JTextField();
		noVol.setBounds(404, 141, 188, 61);
		contentPane.add(noVol);
		noVol.setColumns(10);
		
		JButton btnNewButton = new JButton("Supprimer ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					 if(noVol.getText().equals(null) )
					 {
				            JOptionPane.showMessageDialog(null, "Ce Champ est vide");
				        }
					 else {
					
				        int nov=Integer.parseInt(noVol.getText().toString());
				        
					
						
				        Dbconnect conn=new Dbconnect() ;
						 PreparedStatement stm=null;
						 System.out.println("we are here");
			          	stm=conn.getConn().prepareStatement("DELETE FROM vol WHERE NOVOL =?   ");  
			          	
				          stm.setInt(1,nov);
						  
				        stm.executeUpdate();
				        
				        stm.close();
				        conn.getConn().close();
				        JOptionPane.showMessageDialog(null, "Deleted !") ;  
					 }
				}catch(Exception er)
				    {
                    /*
					  * beep of Warning
					 */
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,er);
				    }
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(503, 275, 141, 61);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(349, 297, 77, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\2411.jpg"));
		lblNewLabel_1.setBounds(0, 0, 746, 389);
		contentPane.add(lblNewLabel_1);
	}
}
