package ra.Model.Dao;

import ra.Model.Entity.Table;

import java.util.List;

public interface TableDao<T,V> extends ManagementDao<T,V> {
    List<T> searchTableByName(String name);
    List<T> searchTableConfirm(String name);

    boolean delete(Integer id);

    Table getById(Integer id);
    List<Table> getAllConfirm();
}
