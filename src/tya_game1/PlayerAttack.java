package tya_game1;

public class PlayerAttack {
	int x, y;
	int attack = 20;
	private Audio gameOver = new Audio("src/audio/gameover.wav", true);
	
	public PlayerAttack(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void fire() {
		gameOver.start();
		this.y -= 10;
		
	}
}
