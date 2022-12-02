package ra.Model.Service;

import ra.Model.Entity.Order;

import java.util.List;

public interface BillService<T,V> extends ManageService<T,V> {
    boolean delete(Integer id);

    Order getById(Integer id);

    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();
}
