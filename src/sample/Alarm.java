package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.io.File;
import java.time.LocalTime;


public class Alarm extends StackPane {

    private boolean active = true;
    private LocalTime time;

    public Alarm(LocalTime time) {
        this.time = time;

        getStyleClass().add("alarm");

        Text text = new Text(time.toString());
        text.getStyleClass().add("alarm_text");

        getChildren().add(text);
        setAlignment(Pos.CENTER_LEFT);
    }

    public LocalTime getTime() {
        return time;
    }

    public boolean isActive() {
        return active;
    }

    public void report() {
        active = false;
        System.out.println("Будильник сработал");

        String file = "02356.mp3";
        Media sound = new Media(new File(file).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Предупреждение: ");
        alert.setHeaderText(null);
        alert.setContentText("ТАЙМЕР СРАБОТАЛ!");
        alert.showAndWait();

        if(alert.isShowing()==false){
            mediaPlayer.stop();
        }
    }
}