package _1ms.jmm.jmcmodmgr;

import _1ms.jmm.jmcmodmgr.Views.MainView;
import com.google.gson.Gson;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setMinWidth(1000);
        stage.setMinHeight(600);

        stage.setTitle("McModMgr");
        var mv = new MainView();
        var scene = mv.makeView();
        stage.setScene(scene);
        new ModApi().getMods().thenAccept(e-> {
            mv.views[0].modCont(e.toArray(new String[0][0]));
            System.out.println(e);
        });
        System.out.println("Rand");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}