package ra.Model.Service;

import ra.Model.Entity.Table;

import java.util.List;

public interface TableService<T,V> extends ManageService<T,V> {
    List<T> searchTableConfirm(String name);

    boolean delete(Integer id);
    List<Table> getAllConfirm();
    Table getById(Integer id);

    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();
}
