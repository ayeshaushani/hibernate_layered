package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    @FXML
    private AnchorPane DashRoot;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer.fxml"));
        AnchorPane anchorPane = loader.load();

        Stage stage = (Stage) DashRoot.getScene().getWindow();
        Scene scene = new Scene(anchorPane);

        stage.setScene(scene);
        stage.setTitle("Customer Form");
        stage.show();
    }

    @FXML
    void btnItemsOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/itemform.fxml"));
        AnchorPane anchorPane = loader.load();

        Stage stage = (Stage) DashRoot.getScene().getWindow();
        Scene scene = new Scene(anchorPane);

        stage.setScene(scene);
        stage.setTitle("Customer Form");
        stage.show();
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {

    }
}
