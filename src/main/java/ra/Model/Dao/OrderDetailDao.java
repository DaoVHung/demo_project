package ra.Model.Dao;

import ra.Model.Entity.OrderDetail;
import ra.Model.Entity.Product;

import java.util.List;

public interface OrderDetailDao<T,V> extends ManagementDao<T,V> {
    List<T> searchProductByName(String name);

    boolean delete(Integer id);
    public List<OrderDetail> getAllDetail(Integer id);

    Product getById(Integer id);
    List<T> getAllMainFood();
    List<T> getAllDrinks();
    List<T> getAllDesserts();
    List<T> getAllSalad();
}
