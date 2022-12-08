package ra.Model.Service;

import ra.Model.Entity.Order;
import ra.Model.Entity.OrderDetail;

import java.util.List;

public interface OrderDetailService<T,V> extends ManageService<T,V>  {
    boolean delete(Integer id);

    Order getById(Integer id);

    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);
    public List<OrderDetail> getAllDetail(Integer id);

    List<T> getAllBySort();
}
