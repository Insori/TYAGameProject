package tya_game1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TyaGame extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/background_title.jpg")).getImage();	//배경이미지
	private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/start.png"));	//시작 버튼
	private ImageIcon howtoplayButtonImage = new ImageIcon(Main.class.getResource("../images/howtoplay.png"));	//방법 버튼
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exit.png"));
	
	private JButton startButton = new JButton(startButtonImage);
	private JButton howtoplayButton = new JButton(howtoplayButtonImage);
	private JButton exitButton = new JButton(exitButtonImage);
	
	public TyaGame() {
		setUndecorated(true);
		setTitle("TYA Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// 창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);	//화면의 위치가 가운데로 옴.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로세스도 종료
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		//setLayout(null);
		
		startButton.setBounds(480, 230, 217, 67);
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
				//게임 시작 이벤트
			}
		});
		add(startButton);
		
		howtoplayButton.setBounds(430, 260, 400, 69);
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
		
		exitButton.setBounds(480, 200, 149, 67);
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
		//그리는 함수 
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);	//background를 그려줌 
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();	//paint함수로 돌아감.
	}

}