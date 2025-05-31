package _1ms.jmm.jmcmodmgr.Views.Panes;

import _1ms.jmm.jmcmodmgr.Views.BaseView;
import javafx.scene.text.Text;

public class InsView extends BaseView {
    public InsView() {
        this.getChildren().add(formatTex(new Text("This is the Installed View!")));
    }
}
