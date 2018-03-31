package proz.hubertpolak.View;

import proz.hubertpolak.Model.Model;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View {
    private Pane layout = new Pane();

    private Stage window;

    private Scene scene = new Scene(layout, 1280, 800);

    public Button playButton = new Button();
    private Button nextButton = new Button();
    private Button prevButton = new Button();
    private Button volumeButton = new Button();
    public Button equalizerButton = new Button();
    private Button artist = new Button("Artist");
    private Button title = new Button("Title");
    private Button album = new Button("Album");
    private Button time = new Button("Time");

    private Label songInfo;
    private Label songTimeInfo;

    private Slider songSlider = new Slider();
    private Slider volumeSlider = new Slider();

    private Canvas canvas = new Canvas(1600, 800);
    private GraphicsContext windowCanvas = canvas.getGraphicsContext2D();

    private Model modelView;

    public View(Model model){
        modelView = model;

        songInfo = new Label(modelView.songArtist + " - " + modelView.songTitle);
        songTimeInfo = new Label(modelView.songTime + "/" + modelView.songTimeMax);
    }

    public void configure(Stage stage) {
        layout.setStyle("-fx-background-color: #BFBFBF;");

        songInfo.setTranslateX(760);
        songInfo.setTranslateY(750);

        songTimeInfo.setTranslateX(1140);
        songTimeInfo.setTranslateY(750);

        songSlider.setValue(0);
        songSlider.setPrefSize(800, 20);
        songSlider.setTranslateX(400);
        songSlider.setTranslateY(770);

        equalizerButton.setGraphic(new ImageView(modelView.equalizerImage));
        equalizerButton.setTranslateX(1220);
        equalizerButton.setTranslateY(755);

        playButton.setGraphic(new ImageView(modelView.playButtonImage));
        playButton.setTranslateX(100);
        playButton.setTranslateY(755);

        nextButton.setGraphic(new ImageView(modelView.nextButtonImage));
        nextButton.setTranslateX(150);
        nextButton.setTranslateY(755);

        prevButton.setGraphic(new ImageView(modelView.prevButtonImage));
        prevButton.setTranslateX(50);
        prevButton.setTranslateY(755);

        volumeButton.setGraphic(new ImageView(modelView.volumeButtonImage));
        volumeButton.setTranslateX(205);
        volumeButton.setTranslateY(755);

        volumeSlider.setValue(0);
        volumeSlider.setPrefSize(130, 20);
        volumeSlider.setTranslateX(255);
        volumeSlider.setTranslateY(760);

        windowCanvas.setFill(Color.DARKGREY);
        windowCanvas.fillRect(0, 740, 1600, 60);
        windowCanvas.setFill(Color.DIMGREY);
        windowCanvas.fillRect(0,0,320, 740);

        artist.setStyle("-fx-background-color: #BFBFBF;");
        artist.setTranslateX(322);
        artist.setTranslateY(5);

        title.setStyle("-fx-background-color: #BFBFBF;");
        title.setTranslateX(600);
        title.setTranslateY(5);

        album.setStyle("-fx-background-color: #BFBFBF;");
        album.setTranslateX(878);
        album.setTranslateY(5);

        time.setStyle("-fx-background-color: #BFBFBF;");
        time.setTranslateX(1156);
        time.setTranslateY(5);

        layout.getChildren().add(canvas);
        layout.getChildren().addAll(songSlider, songTimeInfo, songInfo, equalizerButton, playButton, nextButton,
                prevButton, volumeButton, volumeSlider, artist, title, album, time);

        window = stage;
        window.setTitle(modelView.windowTitle);
        window.setScene(scene);
    }

    public void changePlayButton(){
        if (modelView.playing == false) playButton.setGraphic(new ImageView(modelView.pauseButtonImage));
        else playButton.setGraphic(new ImageView(modelView.playButtonImage));
        modelView.changePlaying();
    }
}
