package gameOfLife;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class SquareTable extends Table {
	
	public SquareTable(ArrayList<Point> aliveCells, ArrayList<Color> colors, CellShape cellshape, int height, int width) {
		super(aliveCells,colors,cellshape,height,width);
	}
	
	public SquareTable() {
		super();
	}
}
