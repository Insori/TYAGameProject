package tya_game1;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TyaGame extends JFrame {
	private Image background=new ImageIcon(Main.class.getResource("���")).getImage();//����̹���
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
	}
	public TyaGame() {
		setTitle("TYA Game");
      	setVisible(true);
      	setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
      	setExtendedState(JFrame.MAXIMIZED_BOTH);   //2560,1440
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //â�� ������ ���μ����� ����
	}
   
	public static void main(String[] args) {
		new TyaGame();
      
	}

}