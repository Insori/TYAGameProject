package tya_game1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NormalMode extends JFrame {
	
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
	
	private Image background_game = new ImageIcon(Main.class.getResource("../images/background_game.jpg")).getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);
//	private Image green_mon = new ImageIcon(Main.class.getResource("../images/GreenMon.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
//	private Image blue_mon = new ImageIcon(Main.class.getResource("../images/BlueMon.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
//	private Image red_mon = new ImageIcon(Main.class.getResource("../images/RedMon.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	
	//일시정지버튼 추가
	private Image stop = new ImageIcon(Main.class.getResource("../images/stop.png")).getImage().getScaledInstance(SCREEN_WIDTH/16, SCREEN_WIDTH/16, 0);
	private ImageIcon stopButton1 = new ImageIcon(stop);
	private JButton stopJButton = new JButton(stopButton1);
	
	//눌리기 전 버튼 이미지
	//redButton
	private Image redButton = new ImageIcon(Main.class.getResource("../images/red_button.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	private Image blueButton = new ImageIcon(Main.class.getResource("../images/blue_button.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	private Image greenButton = new ImageIcon(Main.class.getResource("../images/green_button.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	   
	//눌린 버튼 이미지
	private Image redPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_red_button.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	private Image bluePressedButton = new ImageIcon(Main.class.getResource("../images/pressed_blue_button.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	private Image greenPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_green_button.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	
	private Image red = redButton;
	private Image blue = blueButton;
	private Image green = greenButton;
	
	//몬스터
	Image[] po = new Image[7];
	
	//죽인 몬스터의 수 세기
	int cnt_monster = 0;
	
	public NormalMode() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		setFocusable(true);
		
		for(int i = 0; i<po.length; i++) {

			 po[i] = new ImageIcon(Main.class.getResource("../images/Mon"+(i+1)+".png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
		 }
		
		addKeyListener(new KeyAdapter() {   //키 이벤트
	         @Override
	         public void keyPressed(KeyEvent e) {   //키 눌렀을 때
	            switch (e.getKeyCode()) {
	            case KeyEvent.VK_LEFT:   //아래 방향키 눌렀을 때
	            	red = redPressedButton;
	               break;
	            case KeyEvent.VK_DOWN:   //왼쪽 방향키 눌렀을 때
	            	green = greenPressedButton;
	               break;
	            case KeyEvent.VK_RIGHT:   //오른쪽 방향키 눌렀을 때
		            blue = bluePressedButton;
	               break;
	            default:
	               break;
	            }
	         }
	         public void keyReleased(KeyEvent e) {
	        	 switch(e.getKeyCode()) {
	        	 case KeyEvent.VK_LEFT:   //아래 방향키 눌렀을 때
	        		 red = redButton;
	        		 break;
	        	 case KeyEvent.VK_DOWN:   //왼쪽 방향키 눌렀을 때
	        		 green = greenButton;
	        		 break;
	        	 case KeyEvent.VK_RIGHT:   //오른쪽 방향키 눌렀을 때
	        		 blue = blueButton;
	        		 break;
	        	 default:
	        		 break;
	        	 }
	         }
		});
		
		//돌아가기 버튼
		stopJButton.setBounds(SCREEN_WIDTH-SCREEN_WIDTH/13, 0, SCREEN_WIDTH/13, SCREEN_WIDTH/13);
		stopJButton.setBorderPainted(false);
		stopJButton.setContentAreaFilled(false);
		stopJButton.setFocusPainted(false);
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
	
	public void paint(Graphics g) {
		//그리는 함수 
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		g.drawImage(red, SCREEN_WIDTH/10, SCREEN_HEIGHT-SCREEN_HEIGHT/7, null);
		g.drawImage(green, SCREEN_WIDTH/2-SCREEN_WIDTH/19, SCREEN_HEIGHT-SCREEN_HEIGHT/7, null);
		g.drawImage(blue, SCREEN_WIDTH-SCREEN_WIDTH/5, SCREEN_HEIGHT-SCREEN_HEIGHT/7, null);
		for(int i = 0; i<7; i++) {
			g.drawImage(po[i], SCREEN_WIDTH/(i+1), SCREEN_HEIGHT/(i+6), null);
		}
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background_game , 0, 0, null);
		paintComponents(g);
		this.repaint();	//paint함수로 돌아감.
	}
}
