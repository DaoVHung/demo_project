package ra.Model.ServiceImp;

import ra.Model.Dao.OrderDao;
import ra.Model.Dao.ProductDao;
import ra.Model.DaoImp.OrderDaoImp;
import ra.Model.DaoImp.ProductDaoImp;
import ra.Model.Entity.Order;
import ra.Model.Entity.Product;
import ra.Model.Service.OrderService;

import java.util.List;

public class OrderServiceImp implements OrderService<Order, String> {
    private OrderDao<Order,String> orderDao = new OrderDaoImp();


    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public boolean save(Order order) {
        return orderDao.create(order);
    }

    @Override
    public boolean update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Order getById(String id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Order getById(Integer id) {
        return orderDao.getById(id);
    }

    @Override
    public List<Order> searchConfirm(String name) {
        return orderDao.searchConfirm(name);
    }

    @Override
    public Integer getEarning() {
        return orderDao.getEarning();
    }

    @Override
    public List<Order> searchProByName(String name) {
        return orderDao.searchProductByName(name);
    }

    @Override
    public List<Order> searchBetween(Float num1, Float num2) {
        return null;
    }

    @Override
    public List<Order> getAllBySort() {
        return null;
    }

    @Override
    public List<Order> getConfrim() {
        return orderDao.getConfrim();
    }
}
