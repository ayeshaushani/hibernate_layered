package lk.ijse.dto;

public class OrderDetailDTO {
    private String ItemId;
    private String OrderId;
    private String qty;
    private String unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String itemId, String orderId, String qty, String unitPrice) {
        ItemId = itemId;
        OrderId = orderId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "ItemId='" + ItemId + '\'' +
                ", OrderId='" + OrderId + '\'' +
                ", qty='" + qty + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}
