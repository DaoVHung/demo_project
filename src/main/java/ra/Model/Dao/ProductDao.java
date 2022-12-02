package ra.Model.Dao;

import ra.Model.Entity.Drinks;

import java.util.List;

public interface DrinksDao<T,V> extends ManagementDao<T,V> {
    List<T> searchDrinksByName(String name);

    boolean delete(Integer id);

    Drinks getById(Integer id);

}
