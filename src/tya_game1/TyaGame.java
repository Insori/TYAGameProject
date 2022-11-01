package tya_game1;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TyaGame extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();	//배경이미지
	
	public TyaGame() {
		setTitle("TYA Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// 창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);	//화면의 위치가 가운데로 옴.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로세스도 종료
		setVisible(true);
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

	public static void main(String[] args) {
		new TyaGame();
	}

}