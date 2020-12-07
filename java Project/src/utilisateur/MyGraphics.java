package utilisateur;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyGraphics extends JPanel implements ActionListener, MouseListener {

	public void paintComponent(Graphics g){
		
		//System.out.println(this.getHeight());
		//System.out.println(this.getWidth());
		super.paintComponent(g);
        this.setBackground(Color.orange);
        g.setColor(Color.white);
        g.fillOval(0, 0,426, 253);
       
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(42,42, 340, 170, 30, 30);
        /*
         * Siege Premium
         */
        g.setColor(Color.cyan);
        
        //1er colone
        g.fillRect(55,45, 30, 30);
        g.fillRect(55,85, 30, 30);
        g.fillRect(55,135, 30, 30);
        g.fillRect(55,175, 30, 30);
        //2eme colone
        g.fillRect(95,45, 30, 30); 
        g.fillRect(95,85, 30, 30);
        g.fillRect(95,135, 30, 30);
        g.fillRect(95,175, 30, 30);
        /*
         * Siege First
         */
        g.setColor(Color.yellow);
        
        //3eme colone
        g.fillRect(135,45, 30, 30); 
        g.fillRect(135,85, 30, 30);
        g.fillRect(135,135, 30, 30);
        g.fillRect(135,175, 30, 30);
        //4eme colone
        g.fillRect(175,45, 30, 30); 
        g.fillRect(175,85, 30, 30);
        g.fillRect(175,135, 30, 30);
        g.fillRect(175,175, 30, 30);
        //5eme colone
        g.fillRect(215,45, 30, 30);
        g.fillRect(215,85, 30, 30);
        g.fillRect(215,135, 30, 30);
        g.fillRect(215,175, 30, 30);
        
        /*
         * Siege Standard
         */
        g.setColor(Color.pink);
        //6eme colone
        g.fillRect(255,45, 30, 30);
        g.fillRect(255,85, 30, 30);
        g.fillRect(255,135, 30, 30);
        g.fillRect(255,175, 30, 30);
        //7eme colone
        g.fillRect(295,45, 30, 30);
        g.fillRect(295,85, 30, 30);
        g.fillRect(295,135, 30, 30);
        g.fillRect(295,175, 30, 30);
        //8eme colone
        g.fillRect(335,45, 30, 30);
        g.fillRect(335,85, 30, 30);
        g.fillRect(335,135, 30, 30);
        g.fillRect(335,175, 30, 30);
         /*
          * les information supplementaires 
          */
        //siege premium
        g.setColor(Color.cyan);
        g.fillRect(165,235, 15, 15);
        //siege first
        g.setColor(Color.yellow);
        g.fillRect(165,268, 15, 15);
        //siege standard
        g.setColor(Color.pink);
        g.fillRect(310,235, 15, 15);
        //siege occupee
        g.setColor(Color.blue);
        g.fillRect(310,268, 15, 15);
        this.setVisible(true);
      //Votre Place
        g.setColor(Color.red);
        g.fillRect(80,300, 15, 15);
        this.setVisible(true);
		}
	/**
	 * Create the panel.
	 */
	public MyGraphics() {
		setLayout(null);
		

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
