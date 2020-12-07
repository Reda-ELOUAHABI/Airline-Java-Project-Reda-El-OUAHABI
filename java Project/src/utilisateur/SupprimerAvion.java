package utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SupprimerAvion extends JFrame {

	private JPanel contentPane;
	private JTextField NoAvion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerAvion frame = new SupprimerAvion();
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
	public SupprimerAvion() {
		setTitle("Supprimer un Avion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 736, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblEntrerLeNo = new JLabel("Entrer le No Avion \u00E0 Supprimer");
		lblEntrerLeNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEntrerLeNo.setBounds(66, 94, 283, 61);
		contentPane_1.add(lblEntrerLeNo);
		
		NoAvion = new JTextField();
		NoAvion.setColumns(10);
		NoAvion.setBounds(394, 96, 188, 61);
		contentPane_1.add(NoAvion);
		
		JButton btnNewButton = new JButton("Supprimer ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					 if(NoAvion.getText().equals(null) )
					 {
				            JOptionPane.showMessageDialog(null, "Ce Champ est vide");
				        }
					 else {
					
				        int noav=Integer.parseInt(NoAvion.getText().toString());
				        
					
						
				        Dbconnect conn=new Dbconnect() ;
						 PreparedStatement stm=null;
						 System.out.println("we are here");
			          	stm=conn.getConn().prepareStatement("DELETE FROM Avion WHERE NOAvion =?   ");  
			          	
				          stm.setInt(1,noav);
						  
				        stm.executeUpdate();
				        
				        stm.close();
				        conn.getConn().close();
				        JOptionPane.showMessageDialog(null, "Deleted !") ;  
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
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setBounds(503, 275, 141, 61);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(123, 104, 238));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(380, 297, 77, 38);
		contentPane_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Reda El Ouahabi\\eclipse-workspace\\java Project\\image\\newFolderImages\\2411.jpg"));
		lblNewLabel.setBounds(0, 0, 712, 384);
		contentPane_1.add(lblNewLabel);
	}

}
