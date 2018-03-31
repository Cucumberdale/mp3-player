package proz.hubertpolak;

import proz.hubertpolak.Controller.Controller;
import proz.hubertpolak.Model.Model;
import proz.hubertpolak.Model.EqualizerModel;
import proz.hubertpolak.View.View;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application{
    private Model model = new Model();
    private EqualizerModel equalizerModel = new EqualizerModel();
    private ActionEvent event;

    private View view = new View(model);
    private Controller controller = new Controller(model, equalizerModel, view);

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        view.configure(primaryStage);
        primaryStage.show();

        view.equalizerButton.setOnAction(e -> controller.showEqualizerWindow(event));
        view.playButton.setOnAction(e -> controller.changePlayingButton(event));
    }
}
