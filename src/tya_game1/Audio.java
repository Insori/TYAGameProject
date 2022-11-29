package tya_game1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	private Clip clip = null;
	private boolean isLoop;

	public Audio(String pathname, boolean isLoop) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream
					(new FileInputStream(pathname)));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		}catch(LineUnavailableException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	public void start() {
		clip.setFramePosition(0);
		clip.start();
		if(isLoop) clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}

}
