package tya_game1;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TyaGame extends JFrame {
	private Image background;
	public void paint(Graphics g) {
		//그리는 함수 
		g.drawImage(background, 0, 0, null);	//background를 그려줌 
	}
	public TyaGame() {
		setTitle("TYA Game");
		setVisible(true);
		setResizable(false);// 창의 크기를 변경하지 못하게
		setExtendedState(JFrame.MAXIMIZED_BOTH); // 2560,1440
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로세스도 종료
		background = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();	//배경이미지
	}

	public static void main(String[] args) {
		new TyaGame();
	}

}