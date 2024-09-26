package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<Item> items = new ArrayList<>();

        String sql = "SELECT * FROM item";

        List<Object[]> itemList = session.createNativeQuery(sql).list();
        for (Object[] item : itemList){
            String id = (String) item[0];
            String name = (String) item[1];
            String quantity = (String) item[2];
            String price = (String) item[3];

            Item item1 = new Item(id, name, quantity, price);
            items.add(item1);
        }
        transaction.commit();
        session.close();


        return items;
    }

    @Override
    public boolean save(Item dto)  {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String id, Item dto) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(id,dto);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Item find(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
