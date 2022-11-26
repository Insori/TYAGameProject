package tya_game1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BossMode extends JFrame implements Runnable, KeyListener{

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

	//��� �̹���
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background_game = new ImageIcon(Main.class.getResource("../images/background_game.jpg")).getImage()
			.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);

	//���� ���� �̹���
	private Image boss_red = new ImageIcon(Main.class.getResource("../images/boss_red.png")).getImage();
	private Image boss_blue = new ImageIcon(Main.class.getResource("../images/boss_blue.png")).getImage();
	private Image boss_green = new ImageIcon(Main.class.getResource("../images/boss_green.png")).getImage();
	private Image boss_pink = new ImageIcon(Main.class.getResource("../images/boss_pink.png")).getImage();
	private Image boss_heart = new ImageIcon(Main.class.getResource("../images/boss_heart.png")).getImage();

	//�Ͻ����� ��ư
	private Image stop = new ImageIcon(Main.class.getResource("../images/stop.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 16, SCREEN_WIDTH / 16, 0);
	private ImageIcon stopButton1 = new ImageIcon(stop);
	private JButton stopJButton = new JButton(stopButton1);

	//�÷��̾� �̹���(��ü)
	private Image player = new ImageIcon(Main.class.getResource("../images/button_red.png")).getImage();

	//�⺻ �̹��� ����
	private Image boss = boss_red;

	//boss �̹��� ��ǥ
	int bossX = (SCREEN_WIDTH/2)-300;
	int bossY = (SCREEN_HEIGHT / 2) - 300;

	//ĳ���� ��ǥ
	int x = SCREEN_WIDTH/2;
	int y = (SCREEN_HEIGHT/2)+(SCREEN_HEIGHT/5);

	//Ű���� Ȯ�� ����
	boolean KeyLeft = false;
	boolean KeyRight = false;

	//������
	Thread th1;
	
	public BossMode() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		setFocusable(true);
		
		start();

		//�Ͻ����� ��ư
		stopJButton.setBounds(SCREEN_WIDTH - SCREEN_WIDTH / 13, 0, SCREEN_WIDTH / 13, SCREEN_WIDTH / 13);
		stopJButton.setBorderPainted(false);
		stopJButton.setContentAreaFilled(false);
		stopJButton.setFocusPainted(false);
		//�Ͻ����� ��ư �̺�Ʈ
		stopJButton.addMouseListener(new MouseAdapter() {
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
		add(stopJButton);

	}
	
	//Ű�굵 ������ �� �̺�Ʈ ó��
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			KeyLeft = true;
			break;
		case KeyEvent.VK_RIGHT:
			KeyRight = true;
			break;
		default:
			break;
		}
	}

	//Ű���� ���� �� �̺�Ʈ ó��
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			KeyLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			KeyRight = false;
			break;
		default:
			break;
		}
	}

	public void start() {
		addKeyListener(this);
		th1 = new Thread(this);
		//������ ����
		th1.start();	
	}
	
	public void paint(Graphics g) {
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		g.drawImage(boss, bossX, bossY, null);
		g.drawImage(player, x, y, this);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background_game, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

	//������ ���� �Լ�
	public void run() {
		try {
			while (true) {
				KeyProcess();
				repaint();
				Thread.sleep(20);
			}
		} catch(Exception e) {}
				
	}

	public void keyTyped(KeyEvent e) {}
	
	//Ű���� ������
	public void KeyProcess() {
		if (KeyLeft == true) {
			if(x == (SCREEN_WIDTH/2)-(SCREEN_WIDTH/4)) {
				KeyLeft = false;
			} else x -= 10;
		}
		if (KeyRight == true) {
			if(x == SCREEN_WIDTH-(SCREEN_WIDTH/4)) {
				KeyRight = false;
			} else x += 10;
		}
			
	}
}
