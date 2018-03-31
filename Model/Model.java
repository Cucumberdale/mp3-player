package proz.hubertpolak.Model;

import javafx.scene.image.Image;

public class Model {
    public Image playButtonImage = new Image("play-button.png");
    public Image pauseButtonImage = new Image("pause.png");
    public Image nextButtonImage = new Image("fast-forward.png");
    public Image prevButtonImage = new Image("fast-backward.png");
    public Image volumeButtonImage = new Image("speaker.png");
    public Image equalizerImage = new Image("equalizer.png");

    public String windowTitle = "mp3 player";
    public String songTitle = new String("Title");
    public String songArtist = new String("Artist");
    public String songTimeMax = new String("0:00");
    public String songTime = new String("0:00");

    public boolean playing = false;

    public void changePlaying (){
        playing = !playing;
    }
}
