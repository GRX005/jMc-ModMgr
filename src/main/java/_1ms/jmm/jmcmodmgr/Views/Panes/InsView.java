package _1ms.jmm.jmcmodmgr.Views.Panes;

import _1ms.jmm.jmcmodmgr.Views.ModListView;
import javafx.event.ActionEvent;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;

public class InsView extends ModListView {
    public InsView() {
        this.getChildren().add(formatTex(new Text("This is the Installed View!")));
        ProgressBar prog = new ProgressBar();
        prog.setId("bt");
        prog.setProgress(0.90);
        prog.getStylesheets().add(getClass().getResource("/load.css").toExternalForm());
        prog.setMinWidth(200);
        getChildren().add(prog);
    }

    @Override
    public void handleSearch(ActionEvent e) {

    }
}
