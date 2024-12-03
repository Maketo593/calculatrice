module be.iramps.ue1396.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens be.iramps.ue1396.gui to javafx.fxml;
    exports be.iramps.ue1396.gui;
}
