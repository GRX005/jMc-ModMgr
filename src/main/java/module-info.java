module _1ms.jmm.jmcmodmgr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens _1ms.jmm.jmcmodmgr to javafx.fxml;
    exports _1ms.jmm.jmcmodmgr;
}