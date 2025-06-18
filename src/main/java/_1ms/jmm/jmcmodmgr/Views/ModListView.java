package _1ms.jmm.jmcmodmgr.Views;

import _1ms.jmm.jmcmodmgr.ItemBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public abstract class ModListView extends BaseView {

    public ScrollPane scroll;
    public void modCont(String[]... text) {
        var cucc = new ItemBox().make(this::modCallback,text);
        var box = new VBox();
        cucc.thenAccept(c-> Platform.runLater(()->{
            box.getChildren().addAll(c);
            if (box.getChildren().size()<=4) { //Smaller if no scroll bar.
                scroll.setMaxWidth(502);
            }
        }));

        scroll = new ScrollPane(box);
        scroll.setMaxWidth(516);

        scroll.setStyle("-fx-background-color: #0d1117;");
        box.setStyle("-fx-background-color: #0d1117;");
        box.setSpacing(10);
        scroll.getStylesheets().add(getClass().getResource("/scroll.css").toExternalForm());
        scroll.setId("sc");

    }
//asd
    public void modCallback() {
        var prog = ((ProgressBar) lookup("#bt"));
        prog.setVisible(false);
        prog.setManaged(false);
        Platform.runLater(()-> {
            getChildren().add(scroll);
            try {
                getChildren().remove(lookup("#failText"));
            } catch (Exception ignored) {}
        });
    }

    public abstract void handleSearch(ActionEvent e);

}
