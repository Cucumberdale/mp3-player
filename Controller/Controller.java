package proz.hubertpolak.Controller;

import proz.hubertpolak.Model.Model;
import proz.hubertpolak.Model.EqualizerModel;
import proz.hubertpolak.View.EqualizerView;
import javafx.stage.Stage;
import proz.hubertpolak.View.View;

import java.awt.event.ActionEvent;

public class Controller {
    private Model modelController;
    private EqualizerModel modelEqualizerController;
    private EqualizerView equalizerViewController;
    private View viewController;

    private Stage equalizerStage = new Stage();

    public Controller(Model model, EqualizerModel equalizerModel, View view){
        modelController = model;
        modelEqualizerController = equalizerModel;
        equalizerViewController = new EqualizerView(modelEqualizerController);
        viewController = view;
    }

    public void showEqualizerWindow(ActionEvent event){
        equalizerViewController.configureEqualizer(equalizerStage);
    }

    public void changePlayingButton(ActionEvent event){
        viewController.changePlayButton();
    }
}
