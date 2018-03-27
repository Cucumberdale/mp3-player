package Model;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Model {

    public Pane layout = new Pane();

    public Stage window;
    public Stage equalizerStage = new Stage();

    public Scene scene = new Scene(layout, 1280, 800);

    public Button playButton = new Button();
    public Button nextButton = new Button();
    public Button prevButton = new Button();
    public Button volumeButton = new Button();
    public Button equalizerButton = new Button();
    public Button artist = new Button("Artist");
    public Button title = new Button("Title");
    public Button album = new Button("Album");
    public Button time = new Button("Time");

    public Image playButtonImage = new Image("Model/play-button.png");
    public Image pauseButtonImage = new Image("Model/Pause.png");
    public Image nextButtonImage = new Image("Model/fast-forward.png");
    public Image prevButtonImage = new Image("Model/fast-backward.png");
    public Image volumeButtonImage = new Image("Model/speaker.png");
    public Image equalizerImage = new Image("Model/equalizer.png");

    public String windowTitle = "mp3 player";
    public String songTitle = new String("Title");
    public String songArtist = new String("Artist");
    public String songTimeMax = new String("0:00");
    public String songTime = new String("0:00");

    public Label songInfo = new Label(songArtist + " - " + songTitle);
    public Label songTimeInfo = new Label(songTime + "/" + songTimeMax);

    public Slider songSlider = new Slider();
    public Slider volumeSlider = new Slider();

    public Canvas canvas = new Canvas(1600, 800);
    public GraphicsContext windowCanvas = canvas.getGraphicsContext2D();
}
