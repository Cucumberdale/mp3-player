package proz.hubertpolak.View;

import proz.hubertpolak.Model.EqualizerModel;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EqualizerView {
    private EqualizerModel modelEqualizerView;

    private Stage equalizerWindow = new Stage();

    private Pane equalizerLayout = new Pane();

    private Scene equalizerScene = new Scene(equalizerLayout, 520, 240);

    private Slider preAmpSlider = new Slider();
    private Slider equalizer32 = new Slider();
    private Slider equalizer64 = new Slider();
    private Slider equalizer125 = new Slider();
    private Slider equalizer250 = new Slider();
    private Slider equalizer500 = new Slider();
    private Slider equalizer1K = new Slider();
    private Slider equalizer2K = new Slider();
    private Slider equalizer4K = new Slider();
    private Slider equalizer8K = new Slider();
    private Slider equalizer16K = new Slider();

    private Label preAmpLabel = new Label("Pre-amp");
    private Label eq32Label = new Label("32");
    private Label eq64Label = new Label("64");
    private Label eq125Label = new Label("125");
    private Label eq250Label = new Label("250");
    private Label eq500Label = new Label("500");
    private Label eq1KLabel = new Label("1K");
    private Label eq2KLabel = new Label("2K");
    private Label eq4KLabel = new Label("4K");
    private Label eq8KLabel = new Label("8K");
    private Label eq16KLabel = new Label("16K");

    public EqualizerView(EqualizerModel model){
        modelEqualizerView = model;
        equalizerLayout.getChildren().addAll(preAmpSlider, preAmpLabel, equalizer32, eq32Label,
                equalizer64, eq64Label, equalizer125, eq125Label, equalizer250,
                eq250Label, equalizer500, eq500Label, equalizer1K, eq1KLabel,
                equalizer2K, eq2KLabel, equalizer4K, eq4KLabel, equalizer8K,
                eq8KLabel, equalizer16K, eq16KLabel);
    }

    public void configureEqualizer(Stage stage) {
        equalizerWindow = stage;

        preAmpSlider.setOrientation(Orientation.VERTICAL);
        preAmpSlider.setTranslateX(40);
        preAmpSlider.setTranslateY(40);
        preAmpSlider.setMin(-6);
        preAmpSlider.setMax(6);
        preAmpSlider.setValue(0);
        preAmpSlider.setShowTickLabels(true);
        preAmpSlider.setMajorTickUnit(6);

        preAmpLabel.setTranslateX(22);
        preAmpLabel.setTranslateY(180);

        equalizer32.setOrientation(Orientation.VERTICAL);
        equalizer32.setTranslateX(120);
        equalizer32.setTranslateY(40);
        equalizer32.setMin(-6);
        equalizer32.setMax(6);
        equalizer32.setValue(0);
        equalizer32.setShowTickLabels(true);
        equalizer32.setMajorTickUnit(6);

        eq32Label.setTranslateX(120);
        eq32Label.setTranslateY(180);

        equalizer64.setOrientation(Orientation.VERTICAL);
        equalizer64.setTranslateX(160);
        equalizer64.setTranslateY(40);
        equalizer64.setMin(-6);
        equalizer64.setMax(6);
        equalizer64.setValue(0);
        equalizer64.setShowTickLabels(true);
        equalizer64.setMajorTickUnit(6);

        eq64Label.setTranslateX(160);
        eq64Label.setTranslateY(180);

        equalizer125.setOrientation(Orientation.VERTICAL);
        equalizer125.setTranslateX(200);
        equalizer125.setTranslateY(40);
        equalizer125.setMin(-6);
        equalizer125.setMax(6);
        equalizer125.setValue(0);
        equalizer125.setShowTickLabels(true);
        equalizer125.setMajorTickUnit(6);

        eq125Label.setTranslateX(197);
        eq125Label.setTranslateY(180);

        equalizer250.setOrientation(Orientation.VERTICAL);
        equalizer250.setTranslateX(240);
        equalizer250.setTranslateY(40);
        equalizer250.setMin(-6);
        equalizer250.setMax(6);
        equalizer250.setValue(0);
        equalizer250.setShowTickLabels(true);
        equalizer250.setMajorTickUnit(6);

        eq250Label.setTranslateX(237);
        eq250Label.setTranslateY(180);

        equalizer500.setOrientation(Orientation.VERTICAL);
        equalizer500.setTranslateX(280);
        equalizer500.setTranslateY(40);
        equalizer500.setMin(-6);
        equalizer500.setMax(6);
        equalizer500.setValue(0);
        equalizer500.setShowTickLabels(true);
        equalizer500.setMajorTickUnit(6);

        eq500Label.setTranslateX(277);
        eq500Label.setTranslateY(180);

        equalizer1K.setOrientation(Orientation.VERTICAL);
        equalizer1K.setTranslateX(320);
        equalizer1K.setTranslateY(40);
        equalizer1K.setMin(-6);
        equalizer1K.setMax(6);
        equalizer1K.setValue(0);
        equalizer1K.setShowTickLabels(true);
        equalizer1K.setMajorTickUnit(6);

        eq1KLabel.setTranslateX(320);
        eq1KLabel.setTranslateY(180);

        equalizer2K.setOrientation(Orientation.VERTICAL);
        equalizer2K.setTranslateX(360);
        equalizer2K.setTranslateY(40);
        equalizer2K.setMin(-6);
        equalizer2K.setMax(6);
        equalizer2K.setValue(0);
        equalizer2K.setShowTickLabels(true);
        equalizer2K.setMajorTickUnit(6);

        eq2KLabel.setTranslateX(360);
        eq2KLabel.setTranslateY(180);

        equalizer4K.setOrientation(Orientation.VERTICAL);
        equalizer4K.setTranslateX(400);
        equalizer4K.setTranslateY(40);
        equalizer4K.setMin(-6);
        equalizer4K.setMax(6);
        equalizer4K.setValue(0);
        equalizer4K.setShowTickLabels(true);
        equalizer4K.setMajorTickUnit(6);

        eq4KLabel.setTranslateX(400);
        eq4KLabel.setTranslateY(180);

        equalizer8K.setOrientation(Orientation.VERTICAL);
        equalizer8K.setTranslateX(440);
        equalizer8K.setTranslateY(40);
        equalizer8K.setMin(-6);
        equalizer8K.setMax(6);
        equalizer8K.setValue(0);
        equalizer8K.setShowTickLabels(true);
        equalizer8K.setMajorTickUnit(6);

        eq8KLabel.setTranslateX(440);
        eq8KLabel.setTranslateY(180);

        equalizer16K.setOrientation(Orientation.VERTICAL);
        equalizer16K.setTranslateX(480);
        equalizer16K.setTranslateY(40);
        equalizer16K.setMin(-6);
        equalizer16K.setMax(6);
        equalizer16K.setValue(0);
        equalizer16K.setShowTickLabels(true);
        equalizer16K.setMajorTickUnit(6);

        eq16KLabel.setTranslateX(477);
        eq16KLabel.setTranslateY(180);

        equalizerLayout.setStyle("-fx-background-color: #BFBFBF;");

        equalizerWindow.setScene(equalizerScene);
        equalizerWindow.show();
    }
}
