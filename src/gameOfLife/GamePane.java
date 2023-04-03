package gameOfLife;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GamePane extends Canvas {
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		setBackground(Color.DARK_GRAY);
		int startX = 10;
		int startY = 10;
		int size = 20;
		for(int i = 0; i < 50; i++) {
			
		}
    }
       
	public static void main(String[] args) {  
        GamePane m=new GamePane();  
        JFrame f=new JFrame();
        f.add(m);
        f.setSize(1440,900);
        //f.setLayout(null);  
        f.setVisible(true);  
    }  
  
}
