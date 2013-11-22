package ultracefighter;

public class Plane {
	
	final int MOVESPEED = 5;

	private int centerX = 400;
	private int centerY = 482;
	
	private int speedX = 0;
	private int speedY = 0;
	
	private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean movingUp = false;
    private boolean movingDown = false;
	
	public void update() {
		
		centerX += speedX;
		centerY += speedY;
		
		if (centerX <= 39 ) {
			centerX = 40;
		}
		
		if (centerX >= 760) {
			centerX = 759;
		}
		
		if (centerY >= 542) {
			centerY = 541;
		}
		
		if (centerY <= 58) {
			centerY = 59;
		}
	
	}
	
	public void moveUp() {
		speedY = -MOVESPEED;
	}
	
	public void moveDown() {
		speedY = MOVESPEED;
	}
	
	public void stopUp() {
		setMovingUp(false);
		stopY();
	}
	
	public void stopDown() {
		setMovingDown(false);
		stopY();
	}
	
	public void stopY() {
		if (isMovingUp() == false && isMovingDown() == false) {
			speedY = 0;
		}
		else if (isMovingUp() == false && isMovingDown() == true) {
			moveDown();
		}
		else {
			moveUp();
		}
	}
	
	public void moveLeft() {
		speedX = -MOVESPEED;
	}
	
	public void moveRight() {
		speedX = MOVESPEED;
	}
	
	public void stopLeft() {
		setMovingLeft(false);
		stopX();
	}
	
	public void stopRight() {
		setMovingRight(false);
		stopX();
	}
	
	public void stopX() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}
		else if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}
		else {
			moveRight();
		}
	}
	
	
	// Getters and Setters
	public int getCenterX() {
		return centerX;
	}
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	public int getCenterY() {
		return centerY;
	}
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	public int getMOVESPEED() {
		return MOVESPEED;
	}
	public boolean isMovingLeft() {
		return movingLeft;
	}
	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}
	public boolean isMovingRight() {
		return movingRight;
	}
	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}
	public boolean isMovingUp() {
		return movingUp;
	}
	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}
	public boolean isMovingDown() {
		return movingDown;
	}
	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}
	
	


	
}
