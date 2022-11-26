package tya_game1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BossMode extends JFrame implements Runnable, KeyListener {

	protected static int getScreenHeight() {
		try {
			return Toolkit.getDefaultToolkit().getScreenSize().height;
		} catch (Throwable t) {
			return 1280;
		}
	}

	protected static int getScreenWidth() {
		try {
			return Toolkit.getDefaultToolkit().getScreenSize().width;
		} catch (Throwable t) {
			return 720;
		}
	}

	private int SCREEN_WIDTH = getScreenWidth();
	private int SCREEN_HEIGHT = getScreenHeight();

	// ��� �̹���
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background_game = new ImageIcon(Main.class.getResource("../images/background_game.jpg")).getImage()
			.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);

	// �Ͻ����� ��ư
	private Image stop = new ImageIcon(Main.class.getResource("../images/stop.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 16, SCREEN_WIDTH / 16, 0);
	private ImageIcon stopButton1 = new ImageIcon(stop);
	private JButton stopJButton = new JButton(stopButton1);

	// ���� �̹���
	private Image boss_pink = new ImageIcon(Main.class.getResource("../images/boss_pink.png")).getImage();
	private Image boss_heart = new ImageIcon(Main.class.getResource("../images/boss_heart.png")).getImage();
	// ���� �̹��� ��ǥ
	int bossX = (SCREEN_WIDTH / 2)-125;
	int bossY = (SCREEN_HEIGHT / 2) - 250;
	// ���� ����, ����
	int boss_width = 250;
	int boss_height = 186;
	// ���� ����
	private Image boss_attack_img = new ImageIcon(Main.class.getResource("../images/back.png")).getImage();
	ArrayList<BossAttack> boss_attack_list = new ArrayList<BossAttack>();
	private BossAttack boss_attack;
	// ���� ü��
	int boss_hp = 100;
	// ���� �⺻ �̹��� ����
	private Image boss_img = boss_pink;

	// �÷��̾� �̹���(��ü)
	private Image player = new ImageIcon(Main.class.getResource("../images/button_red.png")).getImage();
	// �÷��̾� ��ǥ
	int playerX = (SCREEN_WIDTH / 2)-48;
	int playerY = (SCREEN_HEIGHT / 2) + (SCREEN_HEIGHT / 3);
	// �÷��̾� ����, ���� - ����
	int player_width = 96;
	int player_height = 96;
	// �÷��̾� ü��
	int player_hp = 100;
	// �÷��̾� ����
	private Image player_attack_img = new ImageIcon(Main.class.getResource("../images/back.png")).getImage();
	ArrayList<PlayerAttack> player_attack_list = new ArrayList<PlayerAttack>();
	private PlayerAttack player_attack;

	// Ű���� Ȯ�� ����
	boolean KeyLeft;
	boolean KeyRight;

	boolean bossMove; // ���� ������ ����
	boolean shooting; // ���� ����

	// Ÿ�̸� 100�ʺ��� ����
	int timer_cnt = 100;
	int time = 0;

	// ������
	Thread th1;

	// sleep
	long pretime;
	int delay = 20;
	int cnt = 0;

	// ���� ����
	private boolean gameover;

	public BossMode() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		setFocusable(true);

		// Ÿ�̸� ����
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (timer_cnt == 0) {
					System.out.println("���� ����");
					time = timer_cnt;
					timer.cancel();
				}
				timer_cnt--;
			}
		};
		timer.schedule(task, 1000, 1000);

		start();

		// �Ͻ����� ��ư
		stopJButton.setBounds(SCREEN_WIDTH - SCREEN_WIDTH / 13, 0, SCREEN_WIDTH / 13, SCREEN_WIDTH / 13);
		stopJButton.setBorderPainted(false);
		stopJButton.setContentAreaFilled(false);
		stopJButton.setFocusPainted(false);
		// �Ͻ����� ��ư �̺�Ʈ
		stopJButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new TyaGame();
			}
		});
		add(stopJButton);

	}

	// Ű�굵 ������ �� �̺�Ʈ ó��
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			KeyLeft = true;
			break;
		case KeyEvent.VK_RIGHT:
			KeyRight = true;
			break;
		case KeyEvent.VK_SPACE:
			shooting = true;
			break;
		default:
			break;
		}
	}

	// Ű���� ���� �� �̺�Ʈ ó��
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			KeyLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			KeyRight = false;
			break;
		case KeyEvent.VK_SPACE:
			shooting = false;
			break;
		default:
			break;
		}
	}

	public void paint(Graphics g) {
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		g.drawImage(boss_img, bossX, bossY, null);
		// ���� ü�¹� �׸���
		g.setColor(Color.GREEN);
		g.fillRect(bossX - 20, bossY - 40, boss_hp * 3, 20);
		g.drawImage(player, playerX, playerY, null);
		// �÷��̾� ü�¹� �׸���
		g.setColor(Color.GREEN);
		g.fillRect(playerX - 20, playerY - 20, player_hp * 2, 10);
		// �÷��̾� ���� �׸���
		for (int i = 0; i < player_attack_list.size(); i++) {
			player_attack = player_attack_list.get(i);
			g.drawImage(player_attack_img, player_attack.x, player_attack.y, null);
		}
		// ���� ���� �׸���
		for (int i = 0; i < boss_attack_list.size(); i++) {
			boss_attack = boss_attack_list.get(i);
			g.drawImage(boss_attack_img, boss_attack.x, boss_attack.y, null);
		}
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background_game, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

	public void start() {
		addKeyListener(this);
		th1 = new Thread(this);
		// ������ ����
		th1.start();
	}

	// ������ ���� �Լ�
	public void run() {
		cnt = 0;
		while (true) {
			while (gameover == false) {
				pretime = System.currentTimeMillis();
				if (System.currentTimeMillis() - pretime < delay) {
					try {
						Thread.sleep(delay - System.currentTimeMillis() + pretime);
						cnt++;
						KeyProcess();
						PlayerAttackProcess();
						BossAttackProcess();
						//BossMove(); //�¿�� ������ �����ϱ�
						repaint();
					} catch (Exception e) {
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

	// ���� ������
//	public void BossMove() {
//		int m = 10;
//		bossX = bossX + m;
//		if (bossX == (SCREEN_WIDTH / 2) - (SCREEN_WIDTH/4) || bossX == SCREEN_WIDTH - (SCREEN_WIDTH / 4)) {
//			m = m * (-1);
//		}
//
//	}

	// Ű���� Ÿ���� �̺�Ʈ
	public void keyTyped(KeyEvent e) {
	}

	// Ű���� ������ �̺�Ʈ
	public void KeyProcess() {
		if (KeyLeft == true) {
			if (playerX == (SCREEN_WIDTH / 2) - (SCREEN_WIDTH / 4)) {
				KeyLeft = false;
			} else
				playerX -= 10;
		}
		if (KeyRight == true) {
			if (playerX == SCREEN_WIDTH - (SCREEN_WIDTH / 4)) {
				KeyRight = false;
			} else
				playerX += 10;
		}
		if (shooting == true && cnt % 5 == 0) {
			player_attack = new PlayerAttack(playerX - 100, playerY - 150); // �̹����� ���� ����
			player_attack_list.add(player_attack);
		}

	}

	// �÷��̾� ���� �̺�Ʈ
	public void PlayerAttackProcess() {
		for (int i = 0; i < player_attack_list.size(); i++) {
			player_attack = player_attack_list.get(i);
			player_attack.fire();

			if (player_attack.x > (bossX-150) && player_attack.x < bossX + 100 && player_attack.y > (bossY-100)
					&& player_attack.y < bossY + 86) {
				boss_hp -= player_attack.attack;
				player_attack_list.remove(player_attack);
			}
			if (boss_hp <= 0) {
				// ���� �������
				// ��ŷ ȭ������ �Ѿ��
			}

		}
	}

	// ���� ���� �̺�Ʈ
	public void BossAttackProcess() {
		if (cnt % 50 == 0) {
			boss_attack = new BossAttack(bossX, bossY + 100);
			boss_attack_list.add(boss_attack);
		}

		for (int i = 0; i < boss_attack_list.size(); i++) {
			boss_attack = boss_attack_list.get(i);
			boss_attack.fire();

			if (boss_attack.x > playerX && boss_attack.x < playerX + player_width && boss_attack.y > playerY
					&& boss_attack.y < playerY + player_height) {
				player_hp -= boss_attack.attack;
				boss_attack_list.remove(boss_attack);
			}
			if (player_hp <= 0) {
				gameover = true;
			}
		}
	}

	// shooting ����
	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	// ���� ���� ����
	public boolean gameover() {
		return gameover;
	}

}
