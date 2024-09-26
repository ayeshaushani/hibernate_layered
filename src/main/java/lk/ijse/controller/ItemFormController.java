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
import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.viewTm.CustomerTm;
import lk.ijse.viewTm.ItemTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ItemFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtItemId;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtQTY;

    @FXML
    private TableView<ItemTm> tblItem;

    @FXML
    private TableColumn<?, ?> tblItemId;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private TableColumn<?, ?> tblUnitPrice;

    @FXML
    private TableColumn<?, ?> tblQty;

    ItemBO itemBO = (ItemBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ITEM);

    public void initialize() {
        loadAllItems();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        tblItemId.setCellValueFactory(new PropertyValueFactory<>("ItemId"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        tblQty.setCellValueFactory(new PropertyValueFactory<>("QTY"));
    }

    private void loadAllItems() {
        ObservableList<ItemTm> item = FXCollections.observableArrayList();

        try{
            List<ItemDTO> itemDTOS = itemBO.getAllItems();

            for (ItemDTO items: itemDTOS){
                ItemTm itemTm = new ItemTm(
                        items.getItemId(),
                        items.getName(),
                        items.getUnitPrice(),
                        items.getQTY()
                );
                item.add(itemTm);
            }
            tblItem.setItems(item);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtItemId.getText();
        String name = txtItemName.getId();
        String price = txtUnitPrice.getText();
        String qty = txtQTY.getText();

        ItemDTO itemDTO = new ItemDTO(id, name, price, qty);
        try {
            boolean isDeleted = itemBO.deleteItem(id,itemDTO);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION, "Item deleted!").show();

            }else{
                new Alert(Alert.AlertType.INFORMATION, "The customer you selected does not exist").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtItemId.getText();
        String name = txtItemName.getText();
        String unitPrice = txtUnitPrice.getText();
        String qty = txtQTY.getText();

        ItemDTO itemDTO = new ItemDTO(id, name, unitPrice, qty);
        try {
            boolean isSaved = itemBO.saveItem(itemDTO);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "The data you entered is incorrect").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtItemId.getText();
        String name = txtItemName.getText();
        String unitPrice = txtUnitPrice.getText();
        String qty = txtQTY.getText();

        ItemDTO itemDTO = new ItemDTO(id, name, unitPrice, qty);
        try {
            boolean isUpdated = itemBO.updateItem(itemDTO);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Item updated!").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "The data you entered is incorrect").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void txtSearchItemOnAction(ActionEvent event) {

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
