package ra.Model.Service;

import ra.Model.Entity.Order;

import java.util.List;

public interface OrderService<T,V> extends ManageService<T,V> {
    boolean delete(Integer id);

    Order getById(Integer id);
    List<T> searchConfirm(String name) ;

    Integer getEarning();
    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();

    List<Order> getConfrim()   ;
}
