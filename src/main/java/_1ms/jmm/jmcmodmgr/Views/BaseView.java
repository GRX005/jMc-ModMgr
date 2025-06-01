package _1ms.jmm.jmcmodmgr.Views;

import _1ms.jmm.jmcmodmgr.ItemBox;
import javafx.application.Platform;
import javafx.geometry.Pos;
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

    public void modCont(String[]... text) {//TODO MAKE ASYNC
        Platform.runLater(()-> {
            this.getChildren().clear();
            for (String[] s : text) {
                this.getChildren().add(new ItemBox(s[0],s[1],s[2]));
            }
        });
    }


}
