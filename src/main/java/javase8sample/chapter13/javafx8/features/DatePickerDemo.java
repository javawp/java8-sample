package javase8sample.chapter13.javafx8.features;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by deng on 2014/9/21.
 */
public class DatePickerDemo extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        DatePicker datePicker = new DatePicker();
        datePicker.setShowWeekNumbers(true);
        HBox hbox = new HBox(15, new Label("Date Picker:"), datePicker);
        hbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
