package _1ms.jmm.jmcmodmgr.Views;

import _1ms.jmm.jmcmodmgr.Views.Panes.ExplView;
import _1ms.jmm.jmcmodmgr.Views.Panes.InsView;
import _1ms.jmm.jmcmodmgr.Views.Panes.SettView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static javafx.scene.layout.Priority.ALWAYS;

public class MainView {

    //ALLViews : , new SettView()
    public BaseView[] allViews;

    public Scene makeView() {
        //TOP BAR (HBox with 3 switch buttons)
        var topBtns = new HBox(25);
        topBtns.setPadding(new Insets(15));// optional spacing around the bar
        topBtns.setStyle("-fx-background-color: #1f1f1f;");
        topBtns.setAlignment(Pos.CENTER);

        Button[] swBtns = { new Button("Explore"), new Button("Installed"), new Button("Settings") };

        setTW(swBtns);
        for (Button b : swBtns) {

            b.setOnMouseEntered(e -> b.setStyle("-fx-background-color: #2f81f7; -fx-text-fill: white; -fx-scale-x: 1.4; -fx-scale-y: 1.4"));
            b.setOnMouseExited(e  -> setTW(b));
        }

        topBtns.getChildren().addAll(swBtns);

        //THREE VIEWS, STACKPANE TO HOLD THEM, WITH ONLY ONE VISIBLE AT A TIME
        var contStack = new StackPane();
        contStack.setPrefHeight(700); //TODO  bind to scene?

        allViews = new BaseView[]{new ExplView(),new InsView(),new SettView()};
        contStack.getChildren().addAll(allViews);

        //WIRING THE BUTTONS TO SWITCH VIEWS
        swBtns[0].setOnAction(e -> allViews[0].show(allViews[1], allViews[2]));
        swBtns[1].setOnAction(e -> allViews[1].show(allViews[0], allViews[2]));
        swBtns[2].setOnAction(e -> allViews[2].show(allViews[0], allViews[1]));

        //COMBINE “topBtns” + “contentStack” INTO A SINGLE PARENT

        var root = new VBox();
        root.getChildren().addAll(topBtns, contStack);

        VBox.setVgrow(contStack, ALWAYS);
        return new Scene(root, 1200, 800);
    }

    //SetTextWhite
    @SafeVarargs
    public final <T extends Node> void setTW(T... elem) {
        for (T e : elem) {
            switch (e) {
                case Text t -> t.setStyle("-fx-fill: #fff;");
                case Button b -> b.setStyle("-fx-text-fill: #fff; -fx-background-color: #3d424b; -fx-scale-x: 1.2; -fx-scale-y: 1.2");
                default -> throw new RuntimeException("StyleExeception");
            }
        }
    }
}
