package _1ms.jmm.jmcmodmgr.Views.Panes;

import _1ms.jmm.jmcmodmgr.Views.BaseView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;

public class ExplView extends BaseView{

    public ExplView() {
        this.getChildren().add(formatTex((new Text("This is the Explore View!"))));
        this.setVisible(true);
        ProgressBar prog = new ProgressBar();
        prog.setId("bt");
        prog.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
        prog.getStylesheets().add(getClass().getResource("/load.css").toExternalForm());
        this.getChildren().add(prog);

    }

}
