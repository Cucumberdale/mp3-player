package proz.hubertpolak.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;
import proz.hubertpolak.Model.Model;
import proz.hubertpolak.Model.EqualizerModel;
import proz.hubertpolak.View.EqualizerView;
import javafx.stage.Stage;
import proz.hubertpolak.View.View;

import javax.swing.event.ChangeEvent;
import java.io.*;

public class Controller {
    private Model modelController;
    private EqualizerModel modelEqualizerController;
    private EqualizerView equalizerViewController;
    private View viewController;

    private Stage equalizerStage = new Stage();
    private Stage primaryStage;

    private String songLength;
    private String artist;
    private String title;

    public Controller(Model model, EqualizerModel equalizerModel, View view, Stage stage){
        modelController = model;
        modelEqualizerController = equalizerModel;
        equalizerViewController = new EqualizerView(modelEqualizerController);
        viewController = view;
        primaryStage = stage;
    }

    public void showEqualizerWindow(ActionEvent event){
        equalizerViewController.configureEqualizer(equalizerStage);
    }

    public void changePlayingButton(ActionEvent event){ viewController.changePlayButton(); }

    public void chooseMusicFolder(ActionEvent event){
        viewController.displayMusicDirectory(primaryStage);
    }

    public void playChosenSong(MouseEvent event){
        if (viewController.musicFolder.getSelectionModel().getSelectedItem().getValue().endsWith(".mp3")){
            String relativePath;
            String directoryString = viewController.mainDirectory.toString();
            TreeItem<String> treeItem = viewController.musicFolder.getSelectionModel().getSelectedItem();
            relativePath = treeItem.getValue();

            while(treeItem.getParent().getParent() != null){
                relativePath = treeItem.getParent().getValue() + '\\' + relativePath;

                treeItem = treeItem.getParent();
            }

            directoryString = directoryString + '\\' + relativePath;

            File directory = new File(directoryString);

            AudioFile audioFile;
            double trackLength = 0;
            int start = 0;

            try {
                audioFile = new AudioFileIO().readFile(directory);

                double frameLength = 1152.0d/audioFile.getAudioHeader().getSampleRateAsNumber();

                int minutes = audioFile.getAudioHeader().getTrackLength()/60;
                int seconds = audioFile.getAudioHeader().getTrackLength()%60;
                songLength = " " + minutes + ":" + seconds;

                artist = audioFile.getTag().getFirst(FieldKey.ARTIST);

                title = audioFile.getTag().getFirst(FieldKey.TITLE) + " - ";

                trackLength = audioFile.getAudioHeader().getTrackLength();
                trackLength = trackLength/frameLength;


                start = (int)(trackLength*(viewController.songSlider.getValue()/100));
            } catch (CannotReadException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TagException e) {
                e.printStackTrace();
            } catch (ReadOnlyFileException e) {
                e.printStackTrace();
            } catch (InvalidAudioFrameException e) {
                e.printStackTrace();
            }

            if(modelController.playing.get() || modelController.resume) modelController.stopSong();

            viewController.setArtist(artist);
            viewController.setTitle(title);
            viewController.setSongTimeMax(songLength);
            viewController.changePlayButton();

            modelController.playSong(directory, start, (int)trackLength);
        }
    }

    public void volumeChange(ChangeEvent event){
        modelController.changeVolume((float)viewController.volumeSlider.getValue()/100);
    }
}
