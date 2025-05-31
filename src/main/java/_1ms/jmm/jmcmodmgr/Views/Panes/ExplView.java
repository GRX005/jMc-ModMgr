package _1ms.jmm.jmcmodmgr.Views.Panes;

import _1ms.jmm.jmcmodmgr.Views.BaseView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ExplView extends BaseView {
    public ExplView() {
        this.getChildren().add(formatTex((new Text("This is the Explore View!"))));
        this.setVisible(true);
    }



}
