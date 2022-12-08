package ra.Model.Dao;

import ra.Model.Entity.Product;

import java.util.List;

public interface ProductDao<T,V> extends ManagementDao<T,V> {
    List<T> searchProductByName(String name);
    public List<Product> getProductByUserID(Integer id);
    boolean delete(Integer id);

    Product getById(Integer id);
    List<T> getAllMainFood();
    List<T> getAllDrinks();
    List<T> getAllDesserts();
    List<T> getAllSalad();


}
