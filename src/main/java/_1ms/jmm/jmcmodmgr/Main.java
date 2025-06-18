package _1ms.jmm.jmcmodmgr;

import _1ms.jmm.jmcmodmgr.Views.MainView;
import _1ms.jmm.jmcmodmgr.Views.ModListView;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setMinWidth(1000);
        stage.setMinHeight(600);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/iconCut.png"))));
        stage.setTitle("McModMgr");
        var mv = new MainView();
        var scene = mv.makeView();
        stage.setScene(scene);
        ModApi.getMods(null).thenAccept(e-> ((ModListView) mv.allViews[0]).modCont(e.toArray(new String[0][0])));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}