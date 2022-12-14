package tya_game1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class NormalMode extends JFrame {

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

	private Image screenImage;
	private Graphics screenGraphic;

	// 필요한 이미지들 (배경 ,몬스터)
	private Image background_game = new ImageIcon(Main.class.getResource("../images/background_game.jpg")).getImage()
			.getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);
	private Image Mon1 = new ImageIcon(Main.class.getResource("../images/Mon1.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image Mon2 = new ImageIcon(Main.class.getResource("../images/Mon2.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image Mon3 = new ImageIcon(Main.class.getResource("../images/Mon3.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image Mon4 = new ImageIcon(Main.class.getResource("../images/Mon4.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image Mon5 = new ImageIcon(Main.class.getResource("../images/Mon5.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image Mon6 = new ImageIcon(Main.class.getResource("../images/Mon6.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image Mon7 = new ImageIcon(Main.class.getResource("../images/Mon7.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);

	// 타이머 이미지
	private Image timer_back_image = new ImageIcon(Main.class.getResource("../images/timer_back_image.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH - SCREEN_WIDTH / 6, SCREEN_HEIGHT / 20, 0);
	private Image timer_image = new ImageIcon(Main.class.getResource("../images/timer_image.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH - SCREEN_WIDTH / 6, SCREEN_HEIGHT / 20, 0);

	// 일시정지버튼 추가
	private Image stop = new ImageIcon(Main.class.getResource("../images/stop.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 16, SCREEN_WIDTH / 16, 0);
	private ImageIcon stopButton1 = new ImageIcon(stop);
	private JButton stopJButton = new JButton(stopButton1);

	// 눌리기 전 버튼 이미지
	// redButton
	private Image redButton = new ImageIcon(Main.class.getResource("../images/red_button.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image blueButton = new ImageIcon(Main.class.getResource("../images/blue_button.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image greenButton = new ImageIcon(Main.class.getResource("../images/green_button.png")).getImage()
			.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);

	// 눌린 버튼 이미지
	private Image redPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_red_button.png"))
			.getImage().getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image bluePressedButton = new ImageIcon(Main.class.getResource("../images/pressed_blue_button.png"))
			.getImage().getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
	private Image greenPressedButton = new ImageIcon(Main.class.getResource("../images/pressed_green_button.png"))
			.getImage().getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);

	private Image red = redButton;
	private Image blue = blueButton;
	private Image green = greenButton;

	// 몬스터
	Image[] mon = new Image[9];

	// 몬스터의 위치를 담고 있는 배열
	private int position_x[] = new int[3];
	private int position_y[] = new int[3];

	// 죽인 몬스터의 수 세기
	private int cnt_monster = 0;

	// 몬스터의 유무
	private int monster[][] = new int[3][3];

	// 타이머 100초부터 시작
	private int timer_cnt = 100;
	private int time = 0;

	// 몬스터를 위한 변수
	int i1 = 2;
	
	private Audio monHeart;

	public NormalMode() {
		setUndecorated(true);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		setFocusable(true);

		monHeart = new Audio("src/audio/monHeart.wav", true);

		// 타이머 실행
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (timer_cnt < 0) {
					System.out.println("게임 오버");
					new GameOver();
					timer.cancel();
				}
				if (cnt_monster>70&& i1==0) {
					new BossMode();
					setVisible(false);
					timer.cancel();
				}
				time = timer_cnt;
				timer_cnt--;
				timer_image = new ImageIcon(Main.class.getResource("../images/timer_Image.png")).getImage().getScaledInstance(SCREEN_WIDTH - SCREEN_WIDTH / 6 - (SCREEN_WIDTH / 120) * (100 - timer_cnt) + 1,SCREEN_HEIGHT / 20, 0);

			}
		};
		timer.schedule(task, 1000, 1000);

		for (int i = 0; i < position_x.length; i++) {
			position_x[i] = SCREEN_WIDTH / 10 + (SCREEN_HEIGHT / 2 + SCREEN_HEIGHT / 8) * i;
			position_y[i] = SCREEN_HEIGHT / 10 + SCREEN_HEIGHT / 30 + (SCREEN_HEIGHT / 3 - SCREEN_WIDTH / 20) * i;
		}

		make_monster();


			addKeyListener(new KeyAdapter() { // 키 이벤트
				@Override
				public void keyPressed(KeyEvent e) { // 키 눌렀을 때
					if (i1 < 0)
						make_monster();
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT: // 아래 방향키 눌렀을 때
						if (monster[0][i1] == 1) {
							monster[0][i1] = 0;
							monHeart.start();
							cnt_monster++;
						} else
							timer_cnt--;
						red = redPressedButton;
						break;
					case KeyEvent.VK_DOWN: // 왼쪽 방향키 눌렀을 때
						if (monster[1][i1] == 1) {
							monster[1][i1] = 0;
							monHeart.start();
							cnt_monster++;
							}
						else
							timer_cnt--;
						green = greenPressedButton;
						break;
					case KeyEvent.VK_RIGHT: // 오른쪽 방향키 눌렀을 때
						if (monster[2][i1] == 1) {
							monster[2][i1] = 0;
							monHeart.start();
							cnt_monster++;
						} else
							timer_cnt--;
						blue = bluePressedButton;
						break;
					default:
						break;
					}
					if(monster[0][0]==0&& monster[0][1]==0 && monster[0][2]==0&&monster[1][0]==0&&monster[1][1]==0&&monster[1][2]==0&&monster[2][0]==0&&monster[2][1]==0&&monster[2][2]==0) {
						make_monster();
						i1 = 2;
					}
					if (monster[0][i1] == 0 && monster[1][i1] == 0 && monster[2][i1] == 0 && i1>0) i1--;
					
				}

				public void keyReleased(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT: // 왼쪽 방향키 떼졌을 때
						red = redButton;
						break;
					case KeyEvent.VK_DOWN: // 아래 방향키 떼졌을 때
						green = greenButton;
						break;
					case KeyEvent.VK_RIGHT: // 오른쪽 방향키 떼졌을 때
						blue = blueButton;
						break;
					default:
						break;
					}
				}
			});

			// 멈추기 버튼
			stopJButton.setBounds(SCREEN_WIDTH - SCREEN_WIDTH / 13, 0, SCREEN_WIDTH / 13, SCREEN_WIDTH / 13);
			stopJButton.setBorderPainted(false);
			stopJButton.setContentAreaFilled(false);
			stopJButton.setFocusPainted(false);
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
					setVisible(false);
				}
			});
			add(stopJButton);
		if (cnt_monster >= 20) {
			new BossMode();
			setVisible(false);
		}
	}

	// 몬스터 배열을 만드는 함수
	void make_monster() {
		double r = 0;
		int a;
		// 몬스터 이미지 넣어주기
		for (int i = 0; i < mon.length; i++) {
			r = Math.random();
			a = (int) (r * 7) + 1;
			mon[i] = new ImageIcon(Main.class.getResource("../images/Mon" + a + ".png")).getImage()
					.getScaledInstance(SCREEN_WIDTH / 10, SCREEN_WIDTH / 10, 0);
		}
		for (int i = 0; i < monster.length; i++) {
			for (int j = 0; j < monster[i].length; j++) {

				r = Math.random();
				a = (int) (r * 2);
				monster[i][j] = a;
			}
		}
	}

	// 그리는 함수
	public void paint(Graphics g) {
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		g.drawImage(red, SCREEN_WIDTH / 10, SCREEN_HEIGHT - SCREEN_HEIGHT / 7, null);
		g.drawImage(green, SCREEN_WIDTH / 2 - SCREEN_WIDTH / 19, SCREEN_HEIGHT - SCREEN_HEIGHT / 7, null);
		g.drawImage(blue, SCREEN_WIDTH - SCREEN_WIDTH / 5, SCREEN_HEIGHT - SCREEN_HEIGHT / 7, null);
		g.drawImage(timer_back_image, SCREEN_WIDTH / 12, SCREEN_HEIGHT / 21, null);
		g.drawImage(timer_image, SCREEN_WIDTH / 12, SCREEN_HEIGHT / 21, null);

		int a = 0;
		// 몬스터가 있으면 그리기
		for (int i = 0; i < monster.length; i++) {
			for (int j = 0; j < monster[i].length; j++) {
				if (monster[i][j] == 1) {
					g.drawImage(mon[a], position_x[i], position_y[j], null);
				}
				a++;
			}
		}
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background_game, 0, 0, null);
		paintComponents(g);
		this.repaint(); // paint함수로 돌아감.
	}
}
