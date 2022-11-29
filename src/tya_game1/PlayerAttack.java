package tya_game1;

public class PlayerAttack {
	int x, y;
	int attack = 20;
	
	public PlayerAttack(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void fire() {
		this.y -= 10;
		
	}
}
