module com.mycompany.crudexample {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.crudexample to javafx.fxml;
    exports com.mycompany.crudexample;
    
    opens com.mycompany.crudexample.controller to javafx.fxml;
    exports com.mycompany.crudexample.controller;
    
    opens com.mycompany.crudexample.model to javafx.fxml;
    exports com.mycompany.crudexample.model; 
}
