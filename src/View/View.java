package View;

import Model.Model;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View {
    Model modelView;

    public View(Model model){
        modelView = model;
    }

    public void configure(Stage stage) {
        modelView.layout.setStyle("-fx-background-color: #BFBFBF;");

        modelView.songInfo.setTranslateX(760);
        modelView.songInfo.setTranslateY(750);

        modelView.songTimeInfo.setTranslateX(1140);
        modelView.songTimeInfo.setTranslateY(750);

        modelView.songSlider.setValue(0);
        modelView.songSlider.setPrefSize(800, 20);
        modelView.songSlider.setTranslateX(400);
        modelView.songSlider.setTranslateY(770);

        modelView.equalizerButton.setGraphic(new ImageView(modelView.equalizerImage));
        modelView.equalizerButton.setTranslateX(1220);
        modelView.equalizerButton.setTranslateY(755);

        modelView.playButton.setGraphic(new ImageView(modelView.playButtonImage));
        modelView.playButton.setTranslateX(100);
        modelView.playButton.setTranslateY(755);

        modelView.nextButton.setGraphic(new ImageView(modelView.nextButtonImage));
        modelView.nextButton.setTranslateX(150);
        modelView.nextButton.setTranslateY(755);

        modelView.prevButton.setGraphic(new ImageView(modelView.prevButtonImage));
        modelView.prevButton.setTranslateX(50);
        modelView.prevButton.setTranslateY(755);

        modelView.volumeButton.setGraphic(new ImageView(modelView.volumeButtonImage));
        modelView.volumeButton.setTranslateX(205);
        modelView.volumeButton.setTranslateY(755);

        modelView.volumeSlider.setValue(0);
        modelView.volumeSlider.setPrefSize(130, 20);
        modelView.volumeSlider.setTranslateX(255);
        modelView.volumeSlider.setTranslateY(760);

        modelView.windowCanvas.setFill(Color.DARKGREY);
        modelView.windowCanvas.fillRect(0, 740, 1600, 60);
        modelView.windowCanvas.setFill(Color.DIMGREY);
        modelView.windowCanvas.fillRect(0,0,320, 740);

        modelView.artist.setStyle("-fx-background-color: #BFBFBF;");
        modelView.artist.setTranslateX(322);
        modelView.artist.setTranslateY(5);

        modelView.title.setStyle("-fx-background-color: #BFBFBF;");
        modelView.title.setTranslateX(600);
        modelView.title.setTranslateY(5);

        modelView.album.setStyle("-fx-background-color: #BFBFBF;");
        modelView.album.setTranslateX(878);
        modelView.album.setTranslateY(5);

        modelView.time.setStyle("-fx-background-color: #BFBFBF;");
        modelView.time.setTranslateX(1156);
        modelView.time.setTranslateY(5);

        modelView.layout.getChildren().add(modelView.canvas);
        modelView.layout.getChildren().addAll(modelView.songSlider, modelView.songTimeInfo, modelView.songInfo, modelView.equalizerButton, modelView.playButton, modelView.nextButton,
                modelView.prevButton, modelView.volumeButton, modelView.volumeSlider, modelView.artist, modelView.title, modelView.album, modelView.time);

        modelView.window = stage;
        modelView.window.setTitle(modelView.windowTitle);
        modelView.window.setScene(modelView.scene);
    }
}
