package Controller;

import Model.Model;
import Model.EqualizerModel;
import View.EqualizerView;

import java.awt.event.ActionEvent;

public class Controller {
    Model modelController;
    EqualizerModel modelEqualizerController;
    EqualizerView equalizerView;

    public Controller(Model model, EqualizerModel equalizerModel){
        modelController = model;
        modelEqualizerController = equalizerModel;
        equalizerView = new EqualizerView(modelEqualizerController);
    }

    public void showEqualizerWindow(ActionEvent event){
        equalizerView.configureEqualizer(modelController.equalizerStage);
    }
}
