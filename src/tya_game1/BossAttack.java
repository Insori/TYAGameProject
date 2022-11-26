package tya_game1;

public class BossAttack {
	int x, y;
	int attack = 5;
	
	public BossAttack(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void fire() {
		this.y += 10;		//나중에 hp와 함께 조정
	}
}
