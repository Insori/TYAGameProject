package tya_game1;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TyaGame extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/background_title.jpg")).getImage();	//배경이미지
	private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/start.png"));	//시작 버튼
	private ImageIcon howtoplayButtonImage = new ImageIcon(Main.class.getResource("../images/howtoplay.png"));	//방법 버튼
	
	private JButton startButton = new JButton(startButtonImage);
	private JButton howtoplayButton = new JButton(howtoplayButtonImage);
	
	public TyaGame() {
		setTitle("TYA Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// 창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);	//화면의 위치가 가운데로 옴.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로세스도 종료
		setVisible(true);
		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
				//startButton.setIcon(defaultIcon);	
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {	//마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
				//startButton.setIcon(defaultIcon);	
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//게임 시작 이벤트
			}
		});
		add(startButton);
		
		howtoplayButton.setBounds(40, 330, 400, 100);
		howtoplayButton.setBorderPainted(false);
		howtoplayButton.setContentAreaFilled(false);
		howtoplayButton.setFocusPainted(false);
		howtoplayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
				//howtoplayButton.setIcon(defaultIcon);
				howtoplayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {	//마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
				//howtoplayButton.setIcon(defaultIcon);
				howtoplayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		add(howtoplayButton);
		
		howtoplayButton.setBounds(1245, 0, 30, 30);
		howtoplayButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
			}
		});
		add(howtoplayButton);
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
		this.repaint();	//paint함수로 돌아감.
	}

}