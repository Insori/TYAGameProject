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


public class TyaGame extends JFrame {

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
	private Image background = new ImageIcon(Main.class.getResource("../images/background_title.jpg")).getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0); //배경 이미지 크기 변경

	//startButtonImage 크기 지정
	private Image startButtonImage = new ImageIcon(Main.class.getResource("../images/start.png")).getImage();//시작 버튼 Image
	private Image startButton1 = startButtonImage.getScaledInstance(SCREEN_WIDTH/6, SCREEN_WIDTH/20, 0);	//Image 크기 지정
	private ImageIcon startButton = new ImageIcon(startButton1);	//Image->Imageicon
	
	//howtoplayButtonImage 크기 지정
	private Image howtoplayButtonImage = new ImageIcon(Main.class.getResource("../images/howtoplay.png")).getImage();	//방법 버튼
	private Image howtoplayButton1 = howtoplayButtonImage.getScaledInstance(SCREEN_WIDTH/3, SCREEN_WIDTH/19, 0);
	private ImageIcon howtoplayButton = new ImageIcon(howtoplayButton1);
	
	//exitButtonImage 크기 지정
	private Image exitButtonImage = new ImageIcon(Main.class.getResource("../images/exit.png")).getImage();
	private Image exitButton1 = exitButtonImage.getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/20, 0);
	private ImageIcon exitButton = new ImageIcon(exitButton1);
	
	private JButton startJButton = new JButton(startButton);
	private JButton howtoplayJButton = new JButton(howtoplayButton);
	private JButton exitJButton = new JButton(exitButton);
	
	public TyaGame() {
		setUndecorated(true);
		setTitle("TYA Game");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);	//화면의 위치가 가운데로 옴.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로세스도 종료
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
	
		//버튼 크기, 위치
//		int Button_width = SCREEN_WIDTH;
//		int Button_height = SCREEN_WIDTH/20;
//		int Button_X = 0;
//		int Button_Y = SCREEN_WIDTH/4+SCREEN_WIDTH/31;
		int Button_YPlus = SCREEN_WIDTH/17;
		
		//시작버튼
		startJButton.setBounds(SCREEN_WIDTH/2-SCREEN_WIDTH/12, SCREEN_HEIGHT/2, SCREEN_WIDTH/6, SCREEN_WIDTH/20);
		startJButton.setBorderPainted(false);
		startJButton.setContentAreaFilled(false);
		startJButton.setFocusPainted(false);
		startJButton.addMouseListener(new MouseAdapter() {
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
				//게임 시작 이벤트
			}
		});
		add(startJButton);
		
		//게임방법 버튼
		howtoplayJButton.setBounds(SCREEN_WIDTH/2-SCREEN_WIDTH/6, SCREEN_HEIGHT/2+Button_YPlus, SCREEN_WIDTH/3, SCREEN_WIDTH/19);
		howtoplayJButton.setBorderPainted(false);
		howtoplayJButton.setContentAreaFilled(false);
		howtoplayJButton.setFocusPainted(false);
		howtoplayJButton.addMouseListener(new MouseAdapter() {
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
				new Howtoplay();
				setVisible(false);
			}
		});
		add(howtoplayJButton);
		
		//나가기 버튼
		exitJButton.setBounds(SCREEN_WIDTH/2-SCREEN_WIDTH/20, SCREEN_HEIGHT/2+(Button_YPlus*2), SCREEN_WIDTH/10, SCREEN_WIDTH/20);
		exitJButton.setBorderPainted(false);
		exitJButton.setContentAreaFilled(false);
		exitJButton.setFocusPainted(false);
		exitJButton.addMouseListener(new MouseAdapter() {
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
				System.exit(0);
			}
		});
		add(exitJButton);
	}
	
	public void paint(Graphics g) {
		//그리는 함수 
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);	//background를 그려줌 
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background , 0, 0, null);
		paintComponents(g);
		this.repaint();	//paint함수로 돌아감.
	}

}