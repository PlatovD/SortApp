module ru.vsu.cs.dplatov.vvp.task3.gnomesortapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ru.vsu.cs.dplatov.vvp.task3.gnomesortapp to javafx.fxml;
    opens ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.utils to javafx.base;
    exports ru.vsu.cs.dplatov.vvp.task3.gnomesortapp;
    opens ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model to javafx.base;
    opens ru.vsu.cs.dplatov.vvp.task3.gnomesortapp.GUI.model.factory to javafx.base;
}