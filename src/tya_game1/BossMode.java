package tya_game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	
	//��� �̹���
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background_game = new ImageIcon(Main.class.getResource("../images/background_game.jpg"))
			.getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);
	
	//���� ���� �̹���
	private Image boss_red = new ImageIcon(Main.class.getResource("../images/boss_red.png")).getImage();
	private Image boss_blue = new ImageIcon(Main.class.getResource("../images/boss_blue.png")).getImage();
	private Image boss_green = new ImageIcon(Main.class.getResource("../images/boss_green.png")).getImage();
	private Image boss_pink = new ImageIcon(Main.class.getResource("../images/boss_pink.png")).getImage();
	private Image boss_heart = new ImageIcon(Main.class.getResource("../images/boss_heart.png")).getImage();
	
	//������ �� ��ư �̹���
	private Image redButton = new ImageIcon(Main.class.getResource("../images/button_red.png")).getImage();
	private Image blueButton = new ImageIcon(Main.class.getResource("../images/button_blue.png")).getImage();
	private Image greenButton = new ImageIcon(Main.class.getResource("../images/button_green.png")).getImage();
	
	//���� ��ư �̹���
	private Image redPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_button_red.png")).getImage();
	private Image bluePressedButton = new ImageIcon(Main.class.getResource("../images/pressed_button_blue.png")).getImage();
	private Image greenPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_button_green.png")).getImage();
	
	//�⺻ �̹��� ����
	private Image boss = boss_red;	
	private Image red = redButton;
	private Image blue= blueButton;
	private Image green = greenButton;
	
	//���� ü��
	int boss_hp = 100;
	
	//boss �̹��� ��ǥ
	int bossX = (SCREEN_WIDTH/2)-140;
	int bossY = (SCREEN_HEIGHT/2)-200;
	
	public BossMode() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyAdapter() {	//Ű �̺�Ʈ
			@Override
			public void keyPressed(KeyEvent e) {	//Ű ������ ��
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:	//�Ʒ� ����Ű ������ ��
					red = redPressedButton;
					if(boss == boss_red) {
						boss_hp--;
						boss = boss_heart;
//						try {
//							Thread.sleep(1000);
//							boss = boss_red;
//						}catch(InterruptedException e1) {
//							boss = boss_red;
//						}
					}
					break;
				case KeyEvent.VK_DOWN:	//���� ����Ű ������ ��
					blue = bluePressedButton;
					if(boss == boss_blue) boss_hp--;
					break;
				case KeyEvent.VK_RIGHT:	//������ ����Ű ������ ��
					//green = greenPressedButton;
					System.exit(0);
					if(boss == boss_green) boss_hp--;
					break;
				default:
					break;
				}
			}
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:	//�Ʒ� ����Ű ���� ��
					red = redButton;
					break;
				case KeyEvent.VK_DOWN:	//���� ����Ű ���� ��
					blue = blueButton;
					break;
				case KeyEvent.VK_RIGHT:	//������ ����Ű ���� ��
					green = greenButton;
					break;
				default:
					break;
				}
			}
		});
		if(boss_hp == 0) System.exit(0);
	}
	
	public void paint(Graphics g) {
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		g.drawImage(boss, (SCREEN_WIDTH/2)-140, (SCREEN_HEIGHT/2)-200, null);
		g.drawImage(red, (SCREEN_WIDTH/4)-38, (SCREEN_HEIGHT/2)+(SCREEN_HEIGHT/5), null);
		g.drawImage(blue, (SCREEN_WIDTH/2)-38, (SCREEN_HEIGHT/2)+(SCREEN_HEIGHT/5), null);
		g.drawImage(green, (SCREEN_WIDTH/2)+(SCREEN_WIDTH/4)-38, (SCREEN_HEIGHT/2)+(SCREEN_HEIGHT/5), null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background_game, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
