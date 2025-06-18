package _1ms.jmm.jmcmodmgr.Views.Panes;

import _1ms.jmm.jmcmodmgr.Views.BaseView;
import _1ms.jmm.jmcmodmgr.Views.ModListView;
import javafx.scene.text.Text;

public class SettView extends BaseView {
    public SettView() {
        this.getChildren().add(formatTex(new Text("This is the Settings View!")));
    }
}
