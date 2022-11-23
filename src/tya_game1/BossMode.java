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
	
	//배경 이미지
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background_game = new ImageIcon(Main.class.getResource("../images/background_game.jpg"))
			.getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);
	
	//보스 몬스터 이미지
	private Image boss_red = new ImageIcon(Main.class.getResource("../images/boss_red.png")).getImage();
	private Image boss_blue = new ImageIcon(Main.class.getResource("../images/boss_blue.png")).getImage();
	private Image boss_green = new ImageIcon(Main.class.getResource("../images/boss_green.png")).getImage();
	private Image boss_pink = new ImageIcon(Main.class.getResource("../images/boss_pink.png")).getImage();
	private Image boss_heart = new ImageIcon(Main.class.getResource("../images/boss_heart.png")).getImage();
	
	//눌리기 전 버튼 이미지
	private Image redButton = new ImageIcon(Main.class.getResource("../images/button_red.png")).getImage();
	private Image blueButton = new ImageIcon(Main.class.getResource("../images/button_blue.png")).getImage();
	private Image greenButton = new ImageIcon(Main.class.getResource("../images/button_green.png")).getImage();
	
	//눌린 버튼 이미지
	private Image redPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_button_red.png")).getImage();
	private Image bluePressedButton = new ImageIcon(Main.class.getResource("../images/pressed_button_blue.png")).getImage();
	private Image greenPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_button_green.png")).getImage();
	
	//기본 이미지 설정
	private Image boss = boss_red;	
	private Image red = redButton;
	private Image blue= blueButton;
	private Image green = greenButton;
	
	//보스 체력
	int boss_hp = 100;
	
	//boss 이미지 좌표
	int bossX = (SCREEN_WIDTH/2)-140;
	int bossY = (SCREEN_HEIGHT/2)-200;
	
	public BossMode() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyAdapter() {	//키 이벤트
			@Override
			public void keyPressed(KeyEvent e) {	//키 눌렀을 때
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:	//아래 방향키 눌렀을 때
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
				case KeyEvent.VK_DOWN:	//왼쪽 방향키 눌렀을 때
					blue = bluePressedButton;
					if(boss == boss_blue) boss_hp--;
					break;
				case KeyEvent.VK_RIGHT:	//오른쪽 방향키 눌렀을 때
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
				case KeyEvent.VK_LEFT:	//아래 방향키 뗐을 때
					red = redButton;
					break;
				case KeyEvent.VK_DOWN:	//왼쪽 방향키 뗐을 때
					blue = blueButton;
					break;
				case KeyEvent.VK_RIGHT:	//오른쪽 방향키 뗐을 때
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
