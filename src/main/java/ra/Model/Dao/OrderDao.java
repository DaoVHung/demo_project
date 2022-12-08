package ra.Model.Dao;

import ra.Model.Entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao<T,V> extends ManagementDao<T,V> {
    List<T> searchBillByName(String name) throws SQLException;
    List<T> searchProductByName(String name);
    List<T> searchConfirm(String name) ;
    boolean delete(Integer id);
    Integer getEarning();
    Order getById(Integer id);
    List<T> getConfrim();
}
