package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.time.LocalTime;
import java.util.Timer;

public class Controller {

    public TextField values;
    public ListView<Alarm> list_view;
    public AnchorPane root;
    public Label arr;

    private AlarmModel alarmModel;
    private boolean darkTheme = true;

    public Controller(AlarmModel model) {
        this.alarmModel = model;
    }

    public void initialize() {
        root.getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
        list_view.setItems(alarmModel.getAlarms());

        alarmModel.start();
    }


    public void addAlarm(ActionEvent actionEvent) {
        alarmModel.addAlarm(new Alarm(LocalTime.now().plusSeconds(Long.parseLong((values.getText())))));
    }

    public void deleteAlarm(ActionEvent actionEvent) {
        alarmModel.removeAlarm(list_view.getSelectionModel().getSelectedItem());
    }


    public void ColorChange(ActionEvent actionEvent){
        darkTheme = !darkTheme;
        list_view.getSelectionModel().getSelectedItem().getStylesheets()
                .setAll(getClass().getResource
                        (darkTheme ? "dark.css" : "light.css").toExternalForm());

    }
    public void onExit() {
        alarmModel.stop();
    }
}
