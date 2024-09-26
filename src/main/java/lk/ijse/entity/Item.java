package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    private String itemId;
    private String Name;
    private String unitPrice;
    private String QTY;

    public Item() {
    }

    public Item(String itemId, String name, String unitPrice, String QTY) {
        this.itemId = itemId;
        Name = name;
        this.unitPrice = unitPrice;
        this.QTY = QTY;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQTY() {
        return QTY;
    }

    public void setQTY(String QTY) {
        this.QTY = QTY;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", Name='" + Name + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", QTY='" + QTY + '\'' +
                '}';
    }
}
