package ultracefighter;

public class Background {

	private int bgX, bgY, speedY;
	
	public Background(int x, int y) {
		this.bgX = x;
		this.bgY = y;
		this.speedY = 3;
	}
	
	public void update() {
		bgY += speedY;
		
		if (bgY >= 600) {
			bgY -= 1200;
		}
	}
	
	public int getBgX() {
		return bgX;
	}

	public void setBgX(int bgX) {
		this.bgX = bgX;
	}

	public int getBgY() {
		return bgY;
	}

	public void setBgY(int bgY) {
		this.bgY = bgY;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}
