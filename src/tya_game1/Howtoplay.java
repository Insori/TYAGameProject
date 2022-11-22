package tya_game1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Howtoplay extends JFrame {
	
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
	private Image background_howtoplay = new ImageIcon(Main.class.getResource("../images/background_howtoplay.jpg")).getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);

	private Image backButtonImage = new ImageIcon(Main.class.getResource("../images/back.png")).getImage();	//방법 버튼
	private Image backButton1 = backButtonImage.getScaledInstance(SCREEN_WIDTH/13, SCREEN_HEIGHT/6, 0);
	private ImageIcon backButton = new ImageIcon(backButton1);
	
	private JButton backJButton = new JButton(backButton);
	
	public Howtoplay() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		int Button_width = SCREEN_WIDTH;
		int Button_height = SCREEN_WIDTH/20;
		
		//돌아가기 버튼
		backJButton.setBounds(0, 0, SCREEN_WIDTH/13, Button_height);
		backJButton.setBorderPainted(false);
		backJButton.setContentAreaFilled(false);
		backJButton.setFocusPainted(false);
		backJButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				new TyaGame();
			}
		});
		add(backJButton);
	}
	
	public void paint(Graphics g) {
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background_howtoplay , 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}