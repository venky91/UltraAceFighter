package ultracefighter;

public class Projectile {

	private int x, y, speedY;
	private boolean visible;
	
	public Projectile(int startX, int startY) {
		x = startX;
		y = startY;
		speedY = -7;
		visible = true;
	}
	
	public void update() {
		y += speedY;
		
		if (y < 0) {
			visible = false;
		}
	}

	// Getters and Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	

}
