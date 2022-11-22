package tya_game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BossMode extends JFrame {
	
	protected static int getScreenHeight() {
		 try {
		  return Toolkit.getDefaultToolkit().getScreenSize().height;
		 } catch (Throwable t) {
		  return 1280;
		 }
	}
	protected static int getScreenWidth() {
		 try {
		  return Toolkit.getDefaultToolkit().getScreenSize().width;
		 } catch (Throwable t) {
		  return 720;
		 }
	}
	
	private int SCREEN_WIDTH = getScreenWidth();
	private int SCREEN_HEIGHT = getScreenHeight();
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background_game = new ImageIcon(Main.class.getResource("../images/background_game.jpg"))
			.getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);
	
	public BossMode() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		int Button_width = SCREEN_WIDTH;
		int Button_height = SCREEN_WIDTH/20;
		
	}
	
	public void paint(Graphics g) {
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background_game, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
