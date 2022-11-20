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
	private Image background = new ImageIcon(Main.class.getResource("../images/background_title.jpg")).getImage();	//����̹���
	private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/start.png"));	//���� ��ư
	private ImageIcon howtoplayButtonImage = new ImageIcon(Main.class.getResource("../images/howtoplay.png"));	//��� ��ư
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exit.png"));
	
	private JButton startButton = new JButton(startButtonImage);
	private JButton howtoplayButton = new JButton(howtoplayButtonImage);
	private JButton exitButton = new JButton(exitButtonImage);
	
	public TyaGame() {
		setUndecorated(true);
		setTitle("TYA Game");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		//setResizable(true);// â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);	//ȭ���� ��ġ�� ����� ��.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�� ������ ���μ����� ����
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		//���۹�ư
		startButton.setBounds(760, 535, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
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
				//���� ���� �̺�Ʈ
			}
		});
		add(startButton);
		
		//���ӹ�� ��ư
		howtoplayButton.setBounds(670, 657, 600, 100);
		howtoplayButton.setBorderPainted(false);
		howtoplayButton.setContentAreaFilled(false);
		howtoplayButton.setFocusPainted(false);
		howtoplayButton.addMouseListener(new MouseAdapter() {
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
				
			}
		});
		add(howtoplayButton);
		
		//������ ��ư
		exitButton.setBounds(760, 780, 400, 100);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
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
		add(exitButton);
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