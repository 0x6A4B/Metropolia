module oop.task1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.task1 to javafx.fxml;
    exports oop.task1;
    opens oop.task1.View to javafx.graphics;
    exports oop.task1.View;
}