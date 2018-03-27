package View;

import Model.EqualizerModel;
import javafx.geometry.Orientation;
import javafx.stage.Stage;

public class EqualizerView {
    EqualizerModel modelEqualizerView;

    public EqualizerView(EqualizerModel model){
        modelEqualizerView = model;
    }

    public void configureEqualizer(Stage stage) {
        modelEqualizerView.equalizerWindow = stage;

        modelEqualizerView.preAmpSlider.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.preAmpSlider.setTranslateX(40);
        modelEqualizerView.preAmpSlider.setTranslateY(40);
        modelEqualizerView.preAmpSlider.setMin(-6);
        modelEqualizerView.preAmpSlider.setMax(6);
        modelEqualizerView.preAmpSlider.setValue(0);
        modelEqualizerView.preAmpSlider.setShowTickLabels(true);
        modelEqualizerView.preAmpSlider.setMajorTickUnit(6);

        modelEqualizerView.preAmpLabel.setTranslateX(22);
        modelEqualizerView.preAmpLabel.setTranslateY(180);

        modelEqualizerView.equalizer32.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer32.setTranslateX(120);
        modelEqualizerView.equalizer32.setTranslateY(40);
        modelEqualizerView.equalizer32.setMin(-6);
        modelEqualizerView.equalizer32.setMax(6);
        modelEqualizerView.equalizer32.setValue(0);
        modelEqualizerView.equalizer32.setShowTickLabels(true);
        modelEqualizerView.equalizer32.setMajorTickUnit(6);

        modelEqualizerView.eq32Label.setTranslateX(120);
        modelEqualizerView.eq32Label.setTranslateY(180);

        modelEqualizerView.equalizer64.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer64.setTranslateX(160);
        modelEqualizerView.equalizer64.setTranslateY(40);
        modelEqualizerView.equalizer64.setMin(-6);
        modelEqualizerView.equalizer64.setMax(6);
        modelEqualizerView.equalizer64.setValue(0);
        modelEqualizerView.equalizer64.setShowTickLabels(true);
        modelEqualizerView.equalizer64.setMajorTickUnit(6);

        modelEqualizerView.eq64Label.setTranslateX(160);
        modelEqualizerView.eq64Label.setTranslateY(180);

        modelEqualizerView.equalizer125.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer125.setTranslateX(200);
        modelEqualizerView.equalizer125.setTranslateY(40);
        modelEqualizerView.equalizer125.setMin(-6);
        modelEqualizerView.equalizer125.setMax(6);
        modelEqualizerView.equalizer125.setValue(0);
        modelEqualizerView.equalizer125.setShowTickLabels(true);
        modelEqualizerView.equalizer125.setMajorTickUnit(6);

        modelEqualizerView.eq125Label.setTranslateX(197);
        modelEqualizerView.eq125Label.setTranslateY(180);

        modelEqualizerView.equalizer250.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer250.setTranslateX(240);
        modelEqualizerView.equalizer250.setTranslateY(40);
        modelEqualizerView.equalizer250.setMin(-6);
        modelEqualizerView.equalizer250.setMax(6);
        modelEqualizerView.equalizer250.setValue(0);
        modelEqualizerView.equalizer250.setShowTickLabels(true);
        modelEqualizerView.equalizer250.setMajorTickUnit(6);

        modelEqualizerView.eq250Label.setTranslateX(237);
        modelEqualizerView.eq250Label.setTranslateY(180);

        modelEqualizerView.equalizer500.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer500.setTranslateX(280);
        modelEqualizerView.equalizer500.setTranslateY(40);
        modelEqualizerView.equalizer500.setMin(-6);
        modelEqualizerView.equalizer500.setMax(6);
        modelEqualizerView.equalizer500.setValue(0);
        modelEqualizerView.equalizer500.setShowTickLabels(true);
        modelEqualizerView.equalizer500.setMajorTickUnit(6);

        modelEqualizerView.eq500Label.setTranslateX(277);
        modelEqualizerView.eq500Label.setTranslateY(180);

        modelEqualizerView.equalizer1K.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer1K.setTranslateX(320);
        modelEqualizerView.equalizer1K.setTranslateY(40);
        modelEqualizerView.equalizer1K.setMin(-6);
        modelEqualizerView.equalizer1K.setMax(6);
        modelEqualizerView.equalizer1K.setValue(0);
        modelEqualizerView.equalizer1K.setShowTickLabels(true);
        modelEqualizerView.equalizer1K.setMajorTickUnit(6);

        modelEqualizerView.eq1KLabel.setTranslateX(320);
        modelEqualizerView.eq1KLabel.setTranslateY(180);

        modelEqualizerView.equalizer2K.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer2K.setTranslateX(360);
        modelEqualizerView.equalizer2K.setTranslateY(40);
        modelEqualizerView.equalizer2K.setMin(-6);
        modelEqualizerView.equalizer2K.setMax(6);
        modelEqualizerView.equalizer2K.setValue(0);
        modelEqualizerView.equalizer2K.setShowTickLabels(true);
        modelEqualizerView.equalizer2K.setMajorTickUnit(6);

        modelEqualizerView.eq2KLabel.setTranslateX(360);
        modelEqualizerView.eq2KLabel.setTranslateY(180);

        modelEqualizerView.equalizer4K.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer4K.setTranslateX(400);
        modelEqualizerView.equalizer4K.setTranslateY(40);
        modelEqualizerView.equalizer4K.setMin(-6);
        modelEqualizerView.equalizer4K.setMax(6);
        modelEqualizerView.equalizer4K.setValue(0);
        modelEqualizerView.equalizer4K.setShowTickLabels(true);
        modelEqualizerView.equalizer4K.setMajorTickUnit(6);

        modelEqualizerView.eq4KLabel.setTranslateX(400);
        modelEqualizerView.eq4KLabel.setTranslateY(180);

        modelEqualizerView.equalizer8K.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer8K.setTranslateX(440);
        modelEqualizerView.equalizer8K.setTranslateY(40);
        modelEqualizerView.equalizer8K.setMin(-6);
        modelEqualizerView.equalizer8K.setMax(6);
        modelEqualizerView.equalizer8K.setValue(0);
        modelEqualizerView.equalizer8K.setShowTickLabels(true);
        modelEqualizerView.equalizer8K.setMajorTickUnit(6);

        modelEqualizerView.eq8KLabel.setTranslateX(440);
        modelEqualizerView.eq8KLabel.setTranslateY(180);

        modelEqualizerView.equalizer16K.setOrientation(Orientation.VERTICAL);
        modelEqualizerView.equalizer16K.setTranslateX(480);
        modelEqualizerView.equalizer16K.setTranslateY(40);
        modelEqualizerView.equalizer16K.setMin(-6);
        modelEqualizerView.equalizer16K.setMax(6);
        modelEqualizerView.equalizer16K.setValue(0);
        modelEqualizerView.equalizer16K.setShowTickLabels(true);
        modelEqualizerView.equalizer16K.setMajorTickUnit(6);

        modelEqualizerView.eq16KLabel.setTranslateX(477);
        modelEqualizerView.eq16KLabel.setTranslateY(180);

        modelEqualizerView.equalizerLayout.setStyle("-fx-background-color: #BFBFBF;");
        modelEqualizerView.equalizerLayout.getChildren().addAll(modelEqualizerView.preAmpSlider, modelEqualizerView.preAmpLabel, modelEqualizerView.equalizer32, modelEqualizerView.eq32Label,
                modelEqualizerView.equalizer64, modelEqualizerView.eq64Label, modelEqualizerView.equalizer125, modelEqualizerView.eq125Label, modelEqualizerView.equalizer250,
                modelEqualizerView.eq250Label, modelEqualizerView.equalizer500, modelEqualizerView.eq500Label, modelEqualizerView.equalizer1K, modelEqualizerView.eq1KLabel,
                modelEqualizerView.equalizer2K, modelEqualizerView.eq2KLabel, modelEqualizerView.equalizer4K, modelEqualizerView.eq4KLabel, modelEqualizerView.equalizer8K,
                modelEqualizerView.eq8KLabel, modelEqualizerView.equalizer16K, modelEqualizerView.eq16KLabel);

        modelEqualizerView.equalizerWindow.setScene(modelEqualizerView.equalizerScene);
        modelEqualizerView.equalizerWindow.show();
    }
}
