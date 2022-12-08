package ra.Model.Service;

import ra.Model.Entity.User;

import java.util.List;

public interface UserService<T,V> extends ManageService<T,V> {
    boolean delete(Integer id);

    User getById(Integer id);

    boolean matchAcc(String UserName, String Pass);
    boolean matchAccAdmin(String UserName, String Pass);
    public Integer IsUser(String UserName, String Pass);

    List<T> searchProByName(String name);

    List<T> searchBetween(Float num1, Float num2);

    List<T> getAllBySort();
}
