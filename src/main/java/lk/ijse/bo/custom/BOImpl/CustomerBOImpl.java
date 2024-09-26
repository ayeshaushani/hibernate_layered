package lk.ijse.bo.custom.BOImpl;

import lk.ijse.bo.custom.CustomerBO;

import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.entity.Customer;


import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMERDAO);
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(customerDTO.getCustomerId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPhoneNumber()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(customerDTO.getCustomerId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPhoneNumber()));
    }

    @Override
    public boolean deleteCustomer(String id,CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id,new Customer(customerDTO.getCustomerId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPhoneNumber()));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers = customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOs = new ArrayList<>();

        for (Customer customer : customers) {
            customerDTOs.add(new CustomerDTO(customer.getCustomerId(), customer.getName(), customer.getEmail(), customer.getPhoneNumber()));
        }
        return customerDTOs;
    }


}
