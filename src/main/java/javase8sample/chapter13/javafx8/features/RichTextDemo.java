package javase8sample.chapter13.javafx8.features;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * Created by deng on 2014/9/19.
 */
public class RichTextDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        setUserAgentStylesheet(STYLESHEET_MODENA);
        Text hello = new Text("Hello ");
        hello.setFont(Font.font("Helvetica", FontWeight.BOLD, 140));
        hello.setStroke(Color.BLACK);
//        hello.setFill(new ImagePattern( new Image(getClass().getResourceAsStream("clipboard.png"))));
        hello.setStrokeWidth(5);
        Text world = new Text("World");
        world.setFont(Font.font("Helvetica", FontPosture.ITALIC, 170));
        world.setFill(Color.RED);
        world.setStrokeWidth(5);
        TextFlow flow = new TextFlow(hello, world);

        Scene scene = new Scene(flow);


        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
