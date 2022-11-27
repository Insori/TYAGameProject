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

	//노트북 해상도 구하기
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
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
	
		//버튼 크기, 위치
		int Button_X = SCREEN_WIDTH/2;
		int Button_Y = SCREEN_WIDTH/4+SCREEN_WIDTH/31;
		int Button_YPlus = SCREEN_WIDTH/16;
		
		//시작버튼
		startJButton.setBounds(Button_X-SCREEN_WIDTH/12, Button_Y, startButton1.getWidth(startJButton), startButton1.getHeight(startJButton));
		startJButton.setBorderPainted(false);
		startJButton.setContentAreaFilled(false);
		startJButton.setFocusPainted(false);
		startJButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				//startJButton.setIcon(exitButton);//이미지 바꾸기
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				//startJButton.setIcon(startButton);//이미지 바꾸기
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//게임 시작 이벤트
				new NormalMode();
				setVisible(false);
			}
		});
		add(startJButton);
		
		//게임방법 버튼
		howtoplayJButton.setBounds(Button_X-SCREEN_WIDTH/6, Button_Y+Button_YPlus, howtoplayButton1.getWidth(howtoplayJButton), howtoplayButton1.getHeight(howtoplayJButton));
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
		exitJButton.setBounds(Button_X-SCREEN_WIDTH/20, Button_Y+(Button_YPlus*2), exitButton1.getWidth(exitJButton), exitButton1.getHeight(exitJButton));
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