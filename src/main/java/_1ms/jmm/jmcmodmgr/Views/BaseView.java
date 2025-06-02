package _1ms.jmm.jmcmodmgr.Views;

import _1ms.jmm.jmcmodmgr.ItemBox;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class BaseView extends VBox{

    public BaseView() {
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #0d1117; -fx-padding: 40;");
        this.setVisible(false);
    }

    @SafeVarargs
    public final <T extends BaseView> void show(T... otherViews) {
        this.setVisible(true);
        for (T v : otherViews) {
            v.setVisible(false);
        }
    }

    public Text formatTex(Text t) {
        t.setFill(Color.WHITE);
        return t;
    }
    ScrollPane scroll;
    public void modCont(String[]... text) {//TODO MAKE ASYNC
        var cucc = new ItemBox().make(this::modCallback,text);
        var box = new VBox();
        cucc.thenAccept(c->c.forEach(d->Platform.runLater(()->box.getChildren().add(d))));

        scroll = new ScrollPane(box);
        scroll.setMaxWidth(516);
        scroll.setStyle("-fx-background-color: #0d1117;");
        box.setStyle("-fx-background-color: #0d1117;");
        box.setSpacing(10);
        scroll.getStylesheets().add(getClass().getResource("/scroll.css").toExternalForm());


    }

    public void modCallback() {
        var prog = ((ProgressBar) lookup("#bt"));
        prog.setVisible(false);
        prog.setManaged(false);
        Platform.runLater(()-> getChildren().add(scroll));
    }


}
