package tya_game1;

import javax.swing.JFrame;

public class TyaGame extends JFrame {
   //private Image backgroundImage
   public TyaGame() {
      setTitle("TYA Game");
      setVisible(true);
      setExtendedState(JFrame.MAXIMIZED_BOTH);   //2560,1440
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //â�� ������ ���μ����� ����
   }
   
   public static void main(String[] args) {
      new TyaGame();
   }

}