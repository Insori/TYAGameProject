package tya_game1;

public class BossAttack {
	int x, y;
	int attack = 2;
	
	public BossAttack(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void fire() {
		this.y += 10;
	}
}
