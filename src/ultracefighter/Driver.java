package ultracefighter;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class Driver extends Applet implements Runnable, KeyListener {

	private Plane plane;
	private Image image, hero;
	private URL base;
	private Graphics second;

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
	}

	@Override
	public void start() {

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
		while (true) {
			plane.update();

			repaint();

			try {

				Thread.sleep(17);
			} catch (InterruptedException e) {

				e.printStackTrace();
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
		g.drawImage(hero, plane.getCenterX() - 40, plane.getCenterY() - 59,
				this);
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

		case KeyEvent.VK_SPACE:
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

}
