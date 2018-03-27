import Controller.Controller;
import Model.Model;
import Model.EqualizerModel;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application{
    private Model model = new Model();
    private EqualizerModel equalizerModel = new EqualizerModel();
    private ActionEvent event;

    private Controller controller = new Controller(model, equalizerModel);
    private View view = new View(model);

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        view.configure(primaryStage);
        primaryStage.show();

        model.equalizerButton.setOnAction(e -> controller.showEqualizerWindow(event));
    }
}
