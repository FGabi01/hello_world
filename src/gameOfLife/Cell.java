package gameOfLife;

public class Cell {
	private boolean active;
	private boolean alive;
	
	public Cell(boolean active, boolean alive) {
		this.active = active;
		this.alive = alive;
	}
	
	public void Die() {
		if(alive && active) alive = false;
	}
	public void Born() {
		if(active && !alive) alive = true;
	}
	
	public boolean getAlive() {
		return alive;
	}
	public boolean getActive() {
		return active;
	}
	public void activate() {
		this.active = true;
	}
	
	public boolean isAlive() {
		return (active && alive);
	}
	
	public Cell copy() {
		Cell ret = new Cell(active, alive);
		return ret;
	}
}
