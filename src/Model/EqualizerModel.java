package Model;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EqualizerModel {
    public Stage equalizerWindow = new Stage();

    public Pane equalizerLayout = new Pane();

    public Scene equalizerScene = new Scene(equalizerLayout, 520, 240);

    public Slider preAmpSlider = new Slider();
    public Slider equalizer32 = new Slider();
    public Slider equalizer64 = new Slider();
    public Slider equalizer125 = new Slider();
    public Slider equalizer250 = new Slider();
    public Slider equalizer500 = new Slider();
    public Slider equalizer1K = new Slider();
    public Slider equalizer2K = new Slider();
    public Slider equalizer4K = new Slider();
    public Slider equalizer8K = new Slider();
    public Slider equalizer16K = new Slider();

    public Label preAmpLabel = new Label("Pre-amp");
    public Label eq32Label = new Label("32");
    public Label eq64Label = new Label("64");
    public Label eq125Label = new Label("125");
    public Label eq250Label = new Label("250");
    public Label eq500Label = new Label("500");
    public Label eq1KLabel = new Label("1K");
    public Label eq2KLabel = new Label("2K");
    public Label eq4KLabel = new Label("4K");
    public Label eq8KLabel = new Label("8K");
    public Label eq16KLabel = new Label("16K");
}
