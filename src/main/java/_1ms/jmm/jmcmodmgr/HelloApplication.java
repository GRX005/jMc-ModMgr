package _1ms.jmm.jmcmodmgr;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        var vbox = new VBox(20);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        var btn = new Button("TestBtn");
        btn.setStyle("");
        btn.setOnMouseEntered(e->btn.setStyle("-fx-background-color: #2f81f7;"));
        btn.setOnMouseExited(e->setTW(btn));
        btn.setScaleX(1.3);
        btn.setScaleY(1.3);
        var text = new Text("");
        setTW(text, btn);
        btn.setOnAction(e->text.setText("Btn clicked!"));
        vbox.getChildren().addAll(btn,text);
        Scene scene = new Scene(vbox, 1200, 800);
        stage.setMinWidth(1000);
        stage.setMinHeight(600);
        vbox.setStyle("-fx-background-color: #0d1117;");
        stage.setTitle("McModMgr");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

//SetTextWhite
    @SafeVarargs
    public final <T> void setTW(T... elem) {
        for (T e : elem) {
            switch (e) {
                case Text t -> t.setStyle("-fx-fill: #fff;");
                case Button b -> b.setStyle("-fx-text-fill: #fff; -fx-background-color: #3d424b;");
                default -> throw new RuntimeException("StyleExeception");
            }
        }
    }
}