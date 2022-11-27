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

	//��Ʈ�� �ػ� ���ϱ�
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
	private Image background = new ImageIcon(Main.class.getResource("../images/background_title.jpg")).getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0); //��� �̹��� ũ�� ����

	//startButtonImage ũ�� ����
	private Image startButtonImage = new ImageIcon(Main.class.getResource("../images/start.png")).getImage();//���� ��ư Image
	private Image startButton1 = startButtonImage.getScaledInstance(SCREEN_WIDTH/6, SCREEN_WIDTH/20, 0);	//Image ũ�� ����
	private ImageIcon startButton = new ImageIcon(startButton1);	//Image->Imageicon
	
	//howtoplayButtonImage ũ�� ����
	private Image howtoplayButtonImage = new ImageIcon(Main.class.getResource("../images/howtoplay.png")).getImage();	//��� ��ư
	private Image howtoplayButton1 = howtoplayButtonImage.getScaledInstance(SCREEN_WIDTH/3, SCREEN_WIDTH/19, 0);
	private ImageIcon howtoplayButton = new ImageIcon(howtoplayButton1);
	
	//exitButtonImage ũ�� ����
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
		setLocationRelativeTo(null);	//ȭ���� ��ġ�� ����� ��.
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
	
		//��ư ũ��, ��ġ
		int Button_X = SCREEN_WIDTH/2;
		int Button_Y = SCREEN_WIDTH/4+SCREEN_WIDTH/31;
		int Button_YPlus = SCREEN_WIDTH/16;
		
		//���۹�ư
		startJButton.setBounds(Button_X-SCREEN_WIDTH/12, Button_Y, startButton1.getWidth(startJButton), startButton1.getHeight(startJButton));
		startJButton.setBorderPainted(false);
		startJButton.setContentAreaFilled(false);
		startJButton.setFocusPainted(false);
		startJButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				//startJButton.setIcon(exitButton);//�̹��� �ٲٱ�
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				//startJButton.setIcon(startButton);//�̹��� �ٲٱ�
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//���� ���� �̺�Ʈ
				new NormalMode();
				setVisible(false);
			}
		});
		add(startJButton);
		
		//���ӹ�� ��ư
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
		
		//������ ��ư
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
		//�׸��� �Լ� 
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);	//background�� �׷��� 
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background , 0, 0, null);
		paintComponents(g);
		this.repaint();	//paint�Լ��� ���ư�.
	}

}