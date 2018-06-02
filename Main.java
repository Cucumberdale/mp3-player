package proz.hubertpolak;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import proz.hubertpolak.Controller.Controller;
import proz.hubertpolak.Model.Model;
import proz.hubertpolak.Model.EqualizerModel;
import proz.hubertpolak.View.View;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.event.ChangeEvent;


public class Main extends Application{
    private Model model = new Model();
    private EqualizerModel equalizerModel = new EqualizerModel();
    private ActionEvent event;
    private ChangeEvent changeEvent;
    private MouseEvent mouseEvent;

    private View view;
    private Controller controller;

    public static void main(String[] args){ launch(args); }

    @Override
    public void start(Stage primaryStage) {
        view = new View(model);
        controller = new Controller(model, equalizerModel, view, primaryStage);

        view.configure(primaryStage);
        primaryStage.show();

        EventHandler<MouseEvent> playSongEvent = (MouseEvent event) -> {
            view.songSlider.setValue(0);
            if (event.getClickCount() == 2) controller.playChosenSong(event);
        };

        view.musicFolder.addEventHandler(MouseEvent.MOUSE_CLICKED, playSongEvent);

        view.equalizerButton.setOnAction(e -> controller.showEqualizerWindow(event));
        view.playButton.setOnAction(e -> controller.changePlayingButton(event));
        view.chooseMusicFolder.setOnAction(e -> controller.chooseMusicFolder(event));

        view.volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                controller.volumeChange(changeEvent);
            }
        });

        /*view.songSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                if(old_val.intValue() + 1 < new_val.intValue() || old_val.intValue() > new_val.intValue()) controller.playChosenSong(mouseEvent);
            }
        });*/

        view.songSlider.setOnMouseClicked(e -> {
            controller.playChosenSong(mouseEvent);
        });
    }
}
