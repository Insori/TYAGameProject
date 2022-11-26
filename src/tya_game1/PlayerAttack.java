package tya_game1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerAttack {
	int x, y;
	
	public PlayerAttack(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void fire() {
		this.y -= 10;	//나중에 hp와 함께 조정
		
	}
}
