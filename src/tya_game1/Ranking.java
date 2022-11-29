package tya_game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Ranking extends JFrame {

	JTextField name,age;//클래스 변수로 선언
	
	ConnectionTest db = new ConnectionTest();
	
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
	private Image background = new ImageIcon(Main.class.getResource("../images/background_ranking.jpg")).getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0); //배경 이미지 크기 변경

	
	public Ranking() {

		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("  이름 :"));
		name=new JTextField(20);
		panel1.add(name);

		this.add(panel1);
		
		JButton button = new JButton("확인");
		panel1.add(button);
		//버튼 리스너 연결
		button.addActionListener(new Listener(this));
		
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
	}
	
	class Listener implements ActionListener{
		JFrame frame;
		public Listener(JFrame f){
			frame =f;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//버튼을 누르면 이쪽으로 제어가 이동
			System.out.println(arg0.getActionCommand());
			String n =name.getText();
			System.out.println(n);
			//다이얼로그
			JOptionPane.showMessageDialog(frame, n);
		}
	}
	
	public void paint(Graphics g) {
		//그리는 함수 
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background , 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}
