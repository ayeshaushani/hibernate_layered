package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    private String OrderId;
    private String Date;
    private String CustomerId;
    private String NetTotal;

    public Order() {
    }

    public Order(String orderId, String date, String customerId, String netTotal) {
        OrderId = orderId;
        Date = date;
        CustomerId = customerId;
        NetTotal = netTotal;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getNetTotal() {
        return NetTotal;
    }

    public void setNetTotal(String netTotal) {
        NetTotal = netTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderId='" + OrderId + '\'' +
                ", Date='" + Date + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", NetTotal='" + NetTotal + '\'' +
                '}';
    }
}
