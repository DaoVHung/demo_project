package ra.Model.ServiceImp;

import ra.Model.Dao.ProductDao;
import ra.Model.Dao.UserDao;
import ra.Model.DaoImp.ProductDaoImp;
import ra.Model.DaoImp.UserDaoImp;
import ra.Model.Entity.Product;
import ra.Model.Entity.User;
import ra.Model.Service.UserService;

import java.util.List;

public class UserServiceImp implements UserService<User,String> {
    private UserDao<User,String> userDaoImp = new UserDaoImp();

    @Override
    public List<User> getAll() {
        return userDaoImp.getAll();
    }

    @Override
    public boolean save(User user) {
        return userDaoImp.create(user);
    }

    @Override
    public boolean update(User user) {
        return userDaoImp.update(user);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public User getById(String id) {
        return userDaoImp.getById(id);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public User getById(Integer id) {
        return userDaoImp.getById(id);
    }

    @Override
    public boolean matchAcc(String UserName, String Pass) {
        return userDaoImp.matchAcc(UserName,Pass);
    }

    @Override
    public boolean matchAccAdmin(String UserName, String Pass) {
        return userDaoImp.matchAccAdmin(UserName,Pass);
    }

    @Override
    public Integer IsUser(String UserName, String Pass) {
        return userDaoImp.IsUser(UserName,Pass);
    }

    @Override
    public List<User> searchProByName(String name) {
        return userDaoImp.searchUserByName(name);
    }

    @Override
    public List<User> searchBetween(Float num1, Float num2) {
        return null;
    }

    @Override
    public List<User> getAllBySort() {
        return null;
    }
}
