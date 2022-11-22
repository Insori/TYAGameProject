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
	private Image green_mon = new ImageIcon(Main.class.getResource("../images/GreenMon.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	private Image blue_mon = new ImageIcon(Main.class.getResource("../images/BlueMon.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	private Image red_mon = new ImageIcon(Main.class.getResource("../images/RedMon.png")).getImage().getScaledInstance(SCREEN_WIDTH/10, SCREEN_WIDTH/10, 0);
	
	//�Ͻ�������ư �߰�
	private Image stop = new ImageIcon(Main.class.getResource("../images/stop.png")).getImage().getScaledInstance(SCREEN_WIDTH/16, SCREEN_WIDTH/16, 0);
	private ImageIcon stopButton1 = new ImageIcon(stop);
	private JButton stopJButton = new JButton(stopButton1);
	
	//������ �� ��ư �̹���
	//redButton
	private Image redButton = new ImageIcon(Main.class.getResource("../images/red_button.png")).getImage();
	private Image blueButton = new ImageIcon(Main.class.getResource("../images/blue_button.png")).getImage();
	private Image greenButton = new ImageIcon(Main.class.getResource("../images/green_button.png")).getImage();
	   
	//���� ��ư �̹���
	private Image redPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_red_button.png")).getImage();
	private Image bluePressedButton = new ImageIcon(Main.class.getResource("../images/pressed_blue_button.png")).getImage();
	private Image greenPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_green_button.png")).getImage();


	private Image red = redButton;
	private Image blue = blueButton;
	private Image green = greenButton;
	
	
	public NormalMode() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		//���ư��� ��ư
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
		
		addKeyListener(new KeyAdapter() {   //Ű �̺�Ʈ
	         @Override
	         public void keyPressed(KeyEvent e) {   //Ű ������ ��
	            switch (e.getKeyCode()) {
	            case KeyEvent.VK_LEFT:   //�Ʒ� ����Ű ������ ��
	               red = redPressedButton;
	               break;
	            case KeyEvent.VK_DOWN:   //���� ����Ű ������ ��
	               blue = bluePressedButton;
	               break;
	            case KeyEvent.VK_RIGHT:   //������ ����Ű ������ ��
	               green = greenPressedButton;
	               break;
	            default:
	               break;
	            }
	         }
	         public void keyReleased(KeyEvent e) {
	        	 switch(e.getKeyCode()) {
	        	 case KeyEvent.VK_LEFT:   //�Ʒ� ����Ű ������ ��
	        		 red = redButton;
	        		 break;
	        	 case KeyEvent.VK_DOWN:   //���� ����Ű ������ ��
	        		 green = greenButton;
	        		 break;
	        	 case KeyEvent.VK_RIGHT:   //������ ����Ű ������ ��
	        		 blue = blueButton;
	        		 break;
	        	 default:
	        		 break;
	        	 }
	         }
		});
	}
//	
//	class MyKeyListener extends KeyAdapter {
//
//        public void keyPressed(KeyEvent e) {
//            int keyCode = e.getKeyCode();	// Ű �ڵ� �˾Ƴ���
//            
//        }
//
//        public void keyReleased(KeyEvent e) {
//        	
//        }
//
//    }
	
	public void paint(Graphics g) {
		//�׸��� �Լ� 
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		g.drawImage(red, 200, 200, null);
		g.drawImage(green, 400, 400, null);
		g.drawImage(blue, 600, 600, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background_game , 0, 0, null);
		paintComponents(g);
		this.repaint();	//paint�Լ��� ���ư�.
	}
}
