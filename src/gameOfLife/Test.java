package gameOfLife;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Test extends Thread {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Point> cells = new ArrayList<Point>(0);
		int s = 50;
		for(int i = 0; i < s; i++) {
			for(int j = 0; j < s; j++) {
				if(Math.random() < 0.5) cells.add(new Point(i,j));
			}
		}
		ArrayList<Color> colors = new ArrayList<Color>();
		colors.add(Color.white);
		/*colors.add(Color.yellow);
		colors.add(Color.red);
		colors.add(Color.blue);*/
		SquareTable tb = new SquareTable(cells,colors,CellShape.Square,s,s);
        JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(tb);
        f.setSize(800,850);
        //f.setLayout(null);
        f.setVisible(true);
        Thread table = new Thread(tb);
        int timeToSleep = 250;
		while(true) {
			Thread.sleep(timeToSleep);
			long currentTime = System.currentTimeMillis();
			table.run();
			timeToSleep = 250 - (int)(System.currentTimeMillis() - currentTime);
		}
	}
}
