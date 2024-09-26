package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.viewTm.CustomerTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerFormController {
    @FXML
    public TableView<CustomerTm> tblCustomer;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TableColumn<?, ?> tblCustomerId;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private TableColumn<?, ?> tblEmail;

    @FXML
    private TableColumn<?, ?> tblPhoneNumber;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public void initialize() {
        loadAllCustomers();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        tblCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    }

    private void loadAllCustomers() {
        ObservableList<CustomerTm> customers = FXCollections.observableArrayList();

        try{
            List<CustomerDTO> customerDTOS = customerBO.getAllCustomers();

            for (CustomerDTO customer: customerDTOS){
                CustomerTm customerTm = new CustomerTm(
                        customer.getCustomerId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPhoneNumber()
                );
                customers.add(customerTm);
            }
            tblCustomer.setItems(customers);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();

        CustomerDTO customerDTO = new CustomerDTO(id, name, email, phoneNumber);
        try {
            boolean isDeleted = customerBO.deleteCustomer(id,customerDTO);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted!").show();

            }else{
                new Alert(Alert.AlertType.INFORMATION, "The customer you selected does not exist").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();

        CustomerDTO customerDTO = new CustomerDTO(id, name, email, phoneNumber);
        try {
            boolean isSaved = customerBO.saveCustomer(customerDTO);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();

            }else{
                new Alert(Alert.AlertType.INFORMATION, "The data you entered is incorrect").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();

        CustomerDTO customerDTO = new CustomerDTO(id, name, email, phoneNumber);
        try {
            boolean isUpdated = customerBO.updateCustomer(customerDTO);
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION, "Customer updated!").show();

            }else{
                new Alert(Alert.AlertType.INFORMATION, "The data you entered is incorrect").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    public void txtSearchCustomerOnAction(ActionEvent actionEvent) {

    }

    @FXML
    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboardform.fxml"));
        AnchorPane anchorPane = loader.load();

        Stage stage = (Stage) root.getScene().getWindow();
        Scene scene = new Scene(anchorPane);

        stage.setScene(scene);
        stage.setTitle("Customer Form");
        stage.show();
    }
}
