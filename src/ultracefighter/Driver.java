package ultracefighter;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

public class Driver extends Applet implements Runnable, KeyListener {

	private Plane plane;
	private Image image, hero, background;
	private URL base;
	private Graphics second;
	private static Background bg1, bg2;
	private Rectangle testEnemy = new Rectangle(200,200, 30,30); // Dummy rectangle to test collision detection
	enum GameState {
		Running, Dead;
	}

	GameState state = GameState.Running;

	@Override
	public void init() {
		setSize(800, 600);
		setBackground(Color.WHITE);
		setFocusable(true);

		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Ultra Ace Fighter");

		try {
			base = getDocumentBase();
		} catch (Exception e) {

		}

		// Image setups
		hero = getImage(base, "data/F-22B.png");
		background = getImage(base, "data/sky.png");
	}

	@Override
	public void start() {

		bg1 = new Background(0, 0);
		bg2 = new Background(0, -600);

		plane = new Plane();
		Thread thread = new Thread(this);
		thread.start();

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

		if (state == GameState.Running) {
			while (true) {

				plane.update();
				bg1.update();
				bg2.update();

				ArrayList projectiles = plane.getProjectiles();
				for (int i = 0; i < projectiles.size(); i++) {

					Projectile p = (Projectile) projectiles.get(i);
					if (p.isVisible() == true) {
						p.update();
					} else {
						projectiles.remove(i);
					}
				}

				repaint();

				try {

					Thread.sleep(17);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

				if (plane.checkCollision(testEnemy)) {
					state = GameState.Dead;
				}
			}
		}
	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {

		if (state == GameState.Running) {
			g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
			g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);

			ArrayList projectiles = plane.getProjectiles();
			for (int i = 0; i < projectiles.size(); i++) {
				Projectile p = (Projectile) projectiles.get(i);
				g.setColor(Color.YELLOW);
				g.fillRect(p.getX(), p.getY(), 5, 10);
			}
			
			// Rectangles for debugging purposes, collision detection
			g.drawRect((int)plane.rect.getX(), (int)plane.rect.getY(), (int)plane.rect.getWidth(), (int)plane.rect.getHeight());
			g.drawRect((int)plane.rect2.getX(), (int)plane.rect2.getY(), (int)plane.rect2.getWidth(), (int)plane.rect2.getHeight());
			g.drawRect((int)plane.rect3.getX(), (int)plane.rect3.getY(), (int)plane.rect3.getWidth(), (int)plane.rect3.getHeight());
			
			// Test enemy for collision checking and game state checking
			g.drawRect(testEnemy.x, testEnemy.y, testEnemy.width, testEnemy.height);
			//Hero Plane
			g.drawImage(hero, plane.getCenterX() - 40, plane.getCenterY() - 59, this);
		}
		else if (state == GameState.Dead){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 800, 600);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 360, 300);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			plane.moveUp();
			plane.setMovingUp(true);
			break;

		case KeyEvent.VK_DOWN:
			plane.moveDown();
			plane.setMovingDown(true);
			break;

		case KeyEvent.VK_LEFT:
			plane.moveLeft();
			plane.setMovingLeft(true);
			break;

		case KeyEvent.VK_RIGHT:
			plane.moveRight();
			plane.setMovingRight(true);
			break;

		case KeyEvent.VK_CONTROL:
			plane.shoot();
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:
			plane.stopUp();
			break;

		case KeyEvent.VK_DOWN:
			plane.stopDown();
			break;

		case KeyEvent.VK_LEFT:
			plane.stopLeft();
			break;

		case KeyEvent.VK_RIGHT:
			plane.stopRight();
			break;

		case KeyEvent.VK_SPACE:
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public static Background getBg1() {
		return bg1;
	}

	public static Background getBg2() {
		return bg2;
	}

}
