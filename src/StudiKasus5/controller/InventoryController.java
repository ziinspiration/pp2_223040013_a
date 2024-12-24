package StudiKasus5.controller;

import StudiKasus5.model.*;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import java.util.concurrent.*;

public class InventoryController {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void addInventory(Inventory inventory) {
        executorService.submit(() -> {
            try (SqlSession session = MyBatisUtil.getSqlSession()) {
                DataMapper mapper = session.getMapper(DataMapper.class);
                mapper.insertInventory(inventory);
                session.commit();
            }
        });
    }

    public List<Inventory> getAllInventories() {
        Future<List<Inventory>> future = executorService.submit(() -> {
            try (SqlSession session = MyBatisUtil.getSqlSession()) {
                DataMapper mapper = session.getMapper(DataMapper.class);
                return mapper.getAllInventories();
            }
        });

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateInventory(Inventory inventory) {
        executorService.submit(() -> {
            try (SqlSession session = MyBatisUtil.getSqlSession()) {
                DataMapper mapper = session.getMapper(DataMapper.class);
                mapper.updateInventory(inventory);
                session.commit();
            }
        });
    }

    public void deleteInventory(int id) {
        executorService.submit(() -> {
            try (SqlSession session = MyBatisUtil.getSqlSession()) {
                DataMapper mapper = session.getMapper(DataMapper.class);
                mapper.deleteInventory(id);
                session.commit();
            }
        });
    }

    public Inventory getInventoryById(int id) {
        Future<Inventory> future = executorService.submit(() -> {
            try (SqlSession session = MyBatisUtil.getSqlSession()) {
                DataMapper mapper = session.getMapper(DataMapper.class);
                return mapper.getInventoryById(id);
            }
        });

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
