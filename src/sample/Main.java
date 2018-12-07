package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("form_alarm.fxml"));

        Controller controller = new Controller(new AlarmModel());
        loader.setController(controller);

        stage.setScene(new Scene(loader.load()));
        stage.setOnCloseRequest(e -> controller.onExit());
        stage.setTitle("Будильник");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
  launch(args);



    }

}
