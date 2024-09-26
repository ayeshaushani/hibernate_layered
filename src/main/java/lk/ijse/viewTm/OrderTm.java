package lk.ijse.viewTm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderTm {
    @Id
    private String ItemID;
    private String ItemName;
    private String UnitPrice;
    private String QTY;
    private String TotalPrice;
    private String Action;

    public OrderTm() {
    }

    public OrderTm(String itemID, String itemName, String unitPrice, String QTY, String totalPrice, String action) {
        ItemID = itemID;
        ItemName = itemName;
        UnitPrice = unitPrice;
        this.QTY = QTY;
        TotalPrice = totalPrice;
        Action = action;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getQTY() {
        return QTY;
    }

    public void setQTY(String QTY) {
        this.QTY = QTY;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    @Override
    public String toString() {
        return "OrderTm{" +
                "ItemID='" + ItemID + '\'' +
                ", ItemName='" + ItemName + '\'' +
                ", UnitPrice='" + UnitPrice + '\'' +
                ", QTY='" + QTY + '\'' +
                ", TotalPrice='" + TotalPrice + '\'' +
                ", Action='" + Action + '\'' +
                '}';
    }
}
