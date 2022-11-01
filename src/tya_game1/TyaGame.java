package tya_game1;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TyaGame extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();	//����̹���
	
	public TyaGame() {
		setTitle("TYA Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);	//ȭ���� ��ġ�� ����� ��.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�� ������ ���μ����� ����
		setVisible(true);
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

	public static void main(String[] args) {
		new TyaGame();
	}

}