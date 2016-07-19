package javase8sample.chapter13.javafx8.features;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Created by deng on 2014/10/19.
 */
public class TreeTableViewDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final TreeItem<String> root = new TreeItem<String>("Root node");
        final TreeItem<String> childNode1 = new TreeItem<String>("Child Node 1");
        final TreeItem<String> childNode2 = new TreeItem<String>("Child Node 2");
        final TreeItem<String> childNode3 = new TreeItem<String>("Child Node 3");
        root.setExpanded(true);
        root.getChildren().setAll(childNode1, childNode2, childNode3);


        TreeTableColumn<String, String> column = new TreeTableColumn<String, String>("Column");
        column.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> p) {
                return new ReadOnlyStringWrapper(p.getValue().getValue());
            }
        });

        final TreeTableView<String> treeTableView = new TreeTableView<String>(root);
        treeTableView.getColumns().add(column);

        Scene scene=new Scene(treeTableView);

        primaryStage.setTitle("Hello TreeTable!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
