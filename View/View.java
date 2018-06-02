package proz.hubertpolak.View;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import proz.hubertpolak.Model.Model;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

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
    public Button chooseMusicFolder = new Button("Choose music folder");

    private Label songPlayedLabel;
    private Label songLengthLabel;
    private Label songArtistLabel;
    private Label songTitleLabel;

    public Slider songSlider = new Slider();
    public Slider volumeSlider = new Slider();

    private Canvas canvas = new Canvas(1600, 800);
    private GraphicsContext windowCanvas = canvas.getGraphicsContext2D();

    private Model modelView;

    public TreeView<String> musicFolder = new TreeView<>();

    public File mainDirectory;

    private String windowTitle = "mp3 player";
    private StringProperty songTitle = new SimpleStringProperty("Title -");
    private StringProperty songArtist = new SimpleStringProperty("Artist");
    private StringProperty songTimeMax = new SimpleStringProperty(" 0:00");
    private StringProperty songTime = new SimpleStringProperty("0:00 /");

    private FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();

    private Thread songTimer;

    private Task task = new Task<String>() {
        @Override public String call() {
            while(songTimer != null){
                long time = modelView.timer;
                time /= 1000;

                String string;

                int minutes = (int) time / 60;
                int seconds = (int) time % 60;
                if (seconds >= 10) string = minutes + ":" + seconds + " /";
                else string = minutes + ":0" + seconds + " /";

                updateValue(string);
            }
            return null;
        }
    };

    public View(Model model){
        modelView = model;

        songArtistLabel = new Label();
        songArtistLabel.textProperty().bind(songArtist);

        songTitleLabel = new Label();
        songTitleLabel.textProperty().bind(songTitle);

        songPlayedLabel = new Label();
        songPlayedLabel.textProperty().bind(task.valueProperty().asString());

        songLengthLabel = new Label();
        songLengthLabel.textProperty().bind(songTimeMax);
    }

    public void configure(Stage stage) {
        layout.setStyle("-fx-background-color: #BFBFBF;");

        songLengthLabel.setTranslateX(1170);
        songLengthLabel.setTranslateY(750);

        songPlayedLabel.setTranslateX(1140);
        songPlayedLabel.setTranslateY(750);

        songTitleLabel.setTranslateX(750);
        songTitleLabel.setTranslateY(750);

        songArtistLabel.setTranslateX(785);
        songArtistLabel.setTranslateY(750);

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

        volumeSlider.setValue(50);
        volumeSlider.setPrefSize(130, 20);
        volumeSlider.setTranslateX(255);
        volumeSlider.setTranslateY(760);

        chooseMusicFolder.setTranslateX(100);
        chooseMusicFolder.setTranslateY(350);

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
        layout.getChildren().addAll(songSlider, songLengthLabel, songPlayedLabel, songTitleLabel, songArtistLabel, equalizerButton, playButton, nextButton,
                prevButton, volumeButton, volumeSlider, artist, title, album, time, chooseMusicFolder);

        window = stage;
        window.setTitle(windowTitle);
        window.setScene(scene);



        songTimer = new Thread(task);
        songTimer.start();
    }

    public void changePlayButton(){
        if (!modelView.playing.get()) playButton.setGraphic(new ImageView(modelView.pauseButtonImage));
        else playButton.setGraphic(new ImageView(modelView.playButtonImage));
        modelView.changePlaying();
    }

    public void displayMusicDirectory(Stage stage){
        DirectoryChooser directory = new DirectoryChooser();
        directory.setInitialDirectory(new File(System.getProperty("user.home")));

        File choice = directory.showDialog(stage);

        if(choice == null || !choice.isDirectory()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Could not open directory");
            alert.setContentText("The file is invalid.");

            alert.showAndWait();
        } else {
            mainDirectory = choice;
            musicFolder.setRoot(getNodesForDirectory(choice));
        }

        musicFolder.setMinWidth(320);
        musicFolder.setMinHeight(740);

        layout.getChildren().add(musicFolder);
        layout.getChildren().remove(chooseMusicFolder);
    }

    private TreeItem<String> getNodesForDirectory(File directory){
        TreeItem<String> root = new TreeItem<>(directory.getName());

        for(File f : directory.listFiles()) {
            if(f.isDirectory()) {
                root.getChildren().add(getNodesForDirectory(f));
            } else if (f.getName().endsWith(".mp3")) {
                TreeItem<String> temp = new TreeItem<>(f.getName(), new ImageView(modelView.mp3FileImage));
                root.getChildren().add(temp);
            }
        }

        return root;
    }

    public void setSongTimeMax(String string) {
        songTimeMax.setValue(string);
    }

    public void setArtist(String string) {
        songArtist.setValue(string);
    }

    public void setTitle(String string){
        songTitle.setValue(string);
        songTitleLabel.setTranslateX(songArtistLabel.getTranslateX() - fontLoader.computeStringWidth(songTitleLabel.getText(), songTitleLabel.getFont()));
    }
}
