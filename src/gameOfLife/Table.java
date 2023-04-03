package gameOfLife;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Table extends Canvas implements Runnable {
	
	private ArrayList<Point> aliveCells;
	private ArrayList<Color> colors;
	private CellShape cellshape;
	private int height;
	private int width;
	private int generation = 0;
	
	public Table(ArrayList<Point> aliveCells, ArrayList<Color> colors, CellShape cellshape, int height, int width) {
		this.aliveCells = aliveCells;
		this.colors = colors;
		this.cellshape = cellshape;
		this.height = height;
		this.width = width;
	}
	
	public Table() {
		this.aliveCells = new ArrayList<Point>(0);
		this.colors = new ArrayList<Color>();
		this.colors.add(Color.LIGHT_GRAY);
		this.cellshape = CellShape.Square;
		this.height = 50;
		this.width = 50;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int h) {
		height = h;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int w) {
		width = w;
	}
	
	public ArrayList<Color> getColors() {
		return colors;
	}
	public void setColors(ArrayList<Color> c) {
		colors = c;
	}
	
	public Color getColor() {
		return colors.get(generation % colors.size());
	}

	public synchronized void run() {
		boolean[][] table = new boolean[width+2][height+2];
		for(Point cell : aliveCells) {
			table[cell.x+1][cell.y+1] = true;
		}
		ArrayList<Point> survivingCells = new ArrayList<Point>(0);
		for(int i = 1; i < width+1; i++) {
			for(int j = 1; j < height+1; j++) {
				int neighbours = 0;
				if (table[i-1][j-1]) { neighbours++; }
                if (table[i-1][j])   { neighbours++; }
                if (table[i-1][j+1]) { neighbours++; }
                if (table[i][j-1])   { neighbours++; }
                if (table[i][j+1])   { neighbours++; }
                if (table[i+1][j-1]) { neighbours++; }
                if (table[i+1][j])   { neighbours++; }
                if (table[i+1][j+1]) { neighbours++; }
                if(table[i][j] && neighbours == 2) {
                	survivingCells.add(new Point(i-1,j-1));
                }
                else if(neighbours == 3) {
                	survivingCells.add(new Point(i-1,j-1));
                }
			}
		}
		aliveCells.clear();
		repaint();
		aliveCells.addAll(survivingCells);
		generation++;
		repaint();
		System.gc();
	}
	
	public synchronized void paint(Graphics g) {
		setBackground(Color.DARK_GRAY);
		int size = (800 / height);
		g.setColor(colors.get(generation%colors.size()));
		for(Point point : aliveCells) {
			g.fillRect((point.x)*size, (point.y)*size, size, size);
		}
		g.setColor(Color.LIGHT_GRAY);
		for (int i=0; i<=width; i++) {
            g.drawLine(size*i, 0, size*i, height*size);
        }
        for (int i=0; i<=height; i++) {
        	g.drawLine(0, size*i, width*size, size*i);
        }
	}
}
