package Sesi13.Latihan.controller;

import Sesi13.Latihan.model.*;
import org.apache.ibatis.session.SqlSession;
import javax.swing.*;
import java.util.List;

public class InventoryController {

    public void addInventory(Inventory inventory) {
        SwingUtilities.invokeLater(() -> {
            try (SqlSession session = MyBatisUtil.getSqlSession()) {
                DataMapper mapper = session.getMapper(DataMapper.class);
                mapper.insertInventory(inventory);
                session.commit();
            }
        });
    }

    public List<Inventory> getAllInventories() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            DataMapper mapper = session.getMapper(DataMapper.class);
            return mapper.getAllInventories();
        }
    }

    public void updateInventory(Inventory inventory) {
        SwingUtilities.invokeLater(() -> {
            try (SqlSession session = MyBatisUtil.getSqlSession()) {
                DataMapper mapper = session.getMapper(DataMapper.class);
                mapper.updateInventory(inventory);
                session.commit();
            }
        });
    }

    public void deleteInventory(int id) {
        SwingUtilities.invokeLater(() -> {
            try (SqlSession session = MyBatisUtil.getSqlSession()) {
                DataMapper mapper = session.getMapper(DataMapper.class);
                mapper.deleteInventory(id);
                session.commit();
            }
        });
    }

    public Inventory getInventoryById(int id) {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            DataMapper mapper = session.getMapper(DataMapper.class);
            return mapper.getInventoryById(id);
        }
    }
}
