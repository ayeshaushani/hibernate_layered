package lk.ijse.dto;

import java.util.List;

public class PlaceOrderDTO {
    private OrderDTO orderDTO;
    private List<OrderDetailDTO> odList;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(OrderDTO orderDTO, List<OrderDetailDTO> odList) {
        this.orderDTO = orderDTO;
        this.odList = odList;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public List<OrderDetailDTO> getOdList() {
        return odList;
    }

    public void setOdList(List<OrderDetailDTO> odList) {
        this.odList = odList;
    }

    @Override
    public String toString() {
        return "PlaceOrderDTO{" +
                "orderDTO=" + orderDTO +
                ", odList=" + odList +
                '}';
    }
}
