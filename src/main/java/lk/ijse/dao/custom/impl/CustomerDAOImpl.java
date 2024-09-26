package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customer";

        List<Object[]> customerList = session.createNativeQuery(sql).list();
        for (Object[] customer : customerList){
            String id = (String) customer[0];
            String email = (String) customer[1];
            String name = (String) customer[2];
            String phoneNumber = (String) customer[3];

            Customer customer1 = new Customer(id, name, email, phoneNumber);
            customers.add(customer1);
        }
        transaction.commit();
        session.close();


        return customers;
    }

    @Override
    public boolean save(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(customer);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String id,Customer customer) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(id,customer);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Customer find(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
