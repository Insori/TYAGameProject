package tya_game1;

public class PlayerAttack {
	int x, y;
	int attack = 20;
	private Audio player_attack = new Audio("src/audio/attack.wav", true);
	
	public PlayerAttack(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void fire() {
		player_attack.start();
		this.y -= 10;
		
	}
}
