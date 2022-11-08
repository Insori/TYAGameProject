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
	private Image background = new ImageIcon(Main.class.getResource("../images/background_title.jpg")).getImage();	//����̹���
	private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/start.png"));	//���� ��ư
	private ImageIcon howtoplayButtonImage = new ImageIcon(Main.class.getResource("../images/howtoplay.png"));	//��� ��ư
	
	private JButton startButton = new JButton(startButtonImage);
	private JButton howtoplayButton = new JButton(howtoplayButtonImage);
	
	public TyaGame() {
		setTitle("TYA Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);	//ȭ���� ��ġ�� ����� ��.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�� ������ ���μ����� ����
		setVisible(true);
		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//���콺�� �ش� ������Ʈ ���� ������ ���ö� �߻�
				//startButton.setIcon(defaultIcon);	
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {	//���콺�� �ش� ������Ʈ ���� ������ ������ �߻�
				//startButton.setIcon(defaultIcon);	
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//���� ���� �̺�Ʈ
			}
		});
		add(startButton);
		
		howtoplayButton.setBounds(40, 330, 400, 100);
		howtoplayButton.setBorderPainted(false);
		howtoplayButton.setContentAreaFilled(false);
		howtoplayButton.setFocusPainted(false);
		howtoplayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//���콺�� �ش� ������Ʈ ���� ������ ���ö� �߻�
				//howtoplayButton.setIcon(defaultIcon);
				howtoplayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {	//���콺�� �ش� ������Ʈ ���� ������ ������ �߻�
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
		//�׸��� �Լ� 
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);	//background�� �׷��� 
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		this.repaint();	//paint�Լ��� ���ư�.
	}

}