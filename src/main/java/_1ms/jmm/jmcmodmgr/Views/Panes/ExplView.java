package _1ms.jmm.jmcmodmgr.Views.Panes;

import _1ms.jmm.jmcmodmgr.ModApi;
import _1ms.jmm.jmcmodmgr.Views.ModListView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ExplView extends ModListView {

    public ExplView() {
        //this.getChildren().add(formatTex((new Text("This is the Explore View!"))));
        setVisible(true);
        ProgressBar prog = new ProgressBar();
        prog.setId("bt");
        prog.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
        prog.getStylesheets().add(getClass().getResource("/load.css").toExternalForm());

        var tx = new TextField();
        tx.setPromptText("Search for mods!");
        tx.setMaxWidth(250);
        tx.setMinHeight(40);
        tx.getStylesheets().add(getClass().getResource("/textField.css").toExternalForm());


        tx.setOnAction(this::handleSearch);

        getChildren().addAll(prog,tx);
    }

    @Override
    public void handleSearch(ActionEvent e) {
        getChildren().remove(scroll);
        var load = lookup("#bt");
        load.setVisible(true);
        load.setManaged(true);
        ModApi.getMods(((TextField)e.getSource()).getText()).thenAccept(f->{
            if(f.isEmpty()) {
                var shouldAdd = lookup("#failText") == null;
                if( shouldAdd) {
                    var fail = new Text("No such mod found :(");
                    fail.setFill(Color.RED);
                    fail.setFont(Font.font(15));
                    fail.setId("failText");
                    Platform.runLater(()-> getChildren().add(fail));
                }
                Platform.runLater(()->{//TODO PRobably unoptimal.
                    load.setVisible(false);
                    load.setManaged(false);
                });
                return;
            }
            modCont(f.toArray(new String[0][0]));

        });
    }
}
