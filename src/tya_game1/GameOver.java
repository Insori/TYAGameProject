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

public class GameOver extends JFrame {
	
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
	private Image GameOverImage = new ImageIcon(Main.class.getResource("../images/background_gameover.jpg")).getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);

	private Image quitButtonImage = new ImageIcon(Main.class.getResource("../images/quit.png")).getImage();	//나가기 버튼
	private Image quitButton1 = quitButtonImage.getScaledInstance(SCREEN_WIDTH/15, SCREEN_HEIGHT/22, 0);
	private ImageIcon quitButton = new ImageIcon(quitButton1);
	
	private Image restartButtonImage = new ImageIcon(Main.class.getResource("../images/restart.png")).getImage();	//다시 시작 버튼
	private Image restartButton1 = restartButtonImage.getScaledInstance(SCREEN_WIDTH/12, SCREEN_HEIGHT/22, 0);
	private ImageIcon restartButton = new ImageIcon(restartButton1);
	
	private JButton quitJButton = new JButton(quitButton);
	private JButton restartJButton = new JButton(restartButton);
	
	public GameOver() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		int Button_width = SCREEN_WIDTH;
		int Button_height = SCREEN_WIDTH/20;
		
		//돌아가기 버튼
		quitJButton.setBounds((SCREEN_WIDTH/2)-(SCREEN_WIDTH/5)-50, (SCREEN_HEIGHT/2)+(SCREEN_HEIGHT/4), quitButton1.getWidth(quitJButton), quitButton1.getHeight(quitJButton));
		quitJButton.setBorderPainted(false);
		quitJButton.setContentAreaFilled(false);
		quitJButton.setFocusPainted(false);
		quitJButton.addMouseListener(new MouseAdapter() {
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
		add(quitJButton);
		
		//다시 시작 버튼
		restartJButton.setBounds((SCREEN_WIDTH/2)+(SCREEN_WIDTH/5)-50, (SCREEN_HEIGHT/2)+(SCREEN_HEIGHT/4), restartButton1.getWidth(restartJButton), restartButton1.getHeight(restartJButton));
		restartJButton.setBorderPainted(false);
		restartJButton.setContentAreaFilled(false);
		restartJButton.setFocusPainted(false);
		restartJButton.addMouseListener(new MouseAdapter() {
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
				new NormalMode();
				setVisible(false);
			}
		});
		add(restartJButton);
	}
	
	public void paint(Graphics g) {
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(GameOverImage , 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}