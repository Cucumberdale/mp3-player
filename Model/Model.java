package proz.hubertpolak.Model;

import javafx.scene.image.Image;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class Model {
    public Image playButtonImage = new Image("play-button.png");
    public Image pauseButtonImage = new Image("pause.png");
    public Image nextButtonImage = new Image("fast-forward.png");
    public Image prevButtonImage = new Image("fast-backward.png");
    public Image volumeButtonImage = new Image("speaker.png");
    public Image equalizerImage = new Image("equalizer.png");
    public Image mp3FileImage = new Image("mp3Icon.png");

    public AtomicBoolean playing = new AtomicBoolean(false);
    public boolean resume = false;
    private boolean songStartAdded = false;

    private AdvancedPlayer player;

    private Thread playerThread;
    private Thread timerThread;

    private File currentSong;

    private double songPosition = 0;

    private long startTime;
    private long timerStart;
    public long timer;

    private int songStart;
    private int songEnd;

    public void changePlaying() {
        playing.set(!playing.get());

        if (!playing.get()) pauseSong();
        else if (resume) resumeSong();
    }

    public void playSong(File song, int start, int end) {
        timerThread = new Thread() {
            public void run() {
                Thread thisThread = Thread.currentThread();

                if(timerStart == 0)timerStart = System.currentTimeMillis() - (long)(start * 26.122449);

                while (timerThread == thisThread){
                    timer = System.currentTimeMillis() - timerStart;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        playerThread = new Thread() {
            public void run() {
                Thread thisThread = Thread.currentThread();

                if(songStart == 0)songStart = start;
                songEnd = end;

                while (playerThread == thisThread) {
                    try {
                        FileInputStream fis = new FileInputStream(song);
                        BufferedInputStream bis = new BufferedInputStream(fis);

                        player = new AdvancedPlayer(bis);

                        currentSong = song;

                        startTime = System.currentTimeMillis() - (long) (songPosition * 26.122449);
                        songPosition = 0;

                        player.play(start, end);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        timerThread.start();
        playerThread.start();
    }

    private void pauseSong() {
        songPosition = (double) (System.currentTimeMillis() - startTime);
        songPosition += 250;
        songPosition /= 26.122449;
        if (!songStartAdded) {
            songPosition += songStart;
            songStartAdded = true;
        }

        resume = true;

        playerThread = null;
        playing.set(false);
        player.close();

        timerThread = null;
        timer = System.currentTimeMillis() - timerStart;
        timerStart = 0;
    }

    public void stopSong() {
        songStart = 0;
        songEnd = 0;

        songPosition = 0;
        currentSong = null;

        resume = false;

        songStartAdded = false;

        playing.set(false);
        player.close();
        playerThread = null;

        timerStart = 0;
        timer = 0;

        timerThread = null;
    }

    private void resumeSong() {
        playSong(currentSong, (int) songPosition, songEnd);
    }

    public void changeVolume(float changeValue) {
        for(Mixer.Info mixerInfo : AudioSystem.getMixerInfo()) {
            Mixer mixer = AudioSystem.getMixer(mixerInfo);

            try {
                mixer.open();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            for(Line.Info lineInfo : mixer.getTargetLineInfo()) {
                try {
                    Line line = mixer.getLine(lineInfo);

                    if(line instanceof Clip)
                        continue;

                    if(!line.isOpen()) line.open();

                    if(line.isControlSupported(FloatControl.Type.VOLUME)) {
                        FloatControl control = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                        control.setValue(changeValue);
                    }
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
