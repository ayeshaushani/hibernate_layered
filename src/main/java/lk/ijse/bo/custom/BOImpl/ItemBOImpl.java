package lk.ijse.bo.custom.BOImpl;


import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEMDAO);
    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(itemDTO.getItemId(),itemDTO.getName(),itemDTO.getUnitPrice(),itemDTO.getQTY()));
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(itemDTO.getItemId(),itemDTO.getName(),itemDTO.getUnitPrice(),itemDTO.getQTY()));
    }

    @Override
    public boolean deleteItem(String id, ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id,new Item(itemDTO.getItemId(),itemDTO.getName(),itemDTO.getUnitPrice(),itemDTO.getQTY()));
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = itemDAO.getAll();
        ArrayList<ItemDTO> ItemDTOs = new ArrayList<>();

        for (Item item : items) {
            ItemDTOs.add(new ItemDTO(item.getItemId(),item.getName(),item.getQTY(),item.getUnitPrice()));
        }
        return ItemDTOs;
    }
}
