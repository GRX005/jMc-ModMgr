package _1ms.jmm.jmcmodmgr;

import _1ms.jmm.jmcmodmgr.Views.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {

        stage.setMinWidth(1000);
        stage.setMinHeight(600);

        stage.setTitle("McModMgr");
        stage.setScene(new MainView().makeView());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}