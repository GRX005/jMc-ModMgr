module _1ms.jmm.jmcmodmgr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.net.http;
    requires com.google.gson;


    opens _1ms.jmm.jmcmodmgr to javafx.fxml;
    exports _1ms.jmm.jmcmodmgr;
    exports _1ms.jmm.jmcmodmgr.Views;
    opens _1ms.jmm.jmcmodmgr.Views to javafx.fxml;
    exports _1ms.jmm.jmcmodmgr.Views.Panes;
    opens _1ms.jmm.jmcmodmgr.Views.Panes to javafx.fxml;
}