package ra.Model.ServiceImp;

import javafx.scene.control.Tab;
import ra.Model.Dao.ProductDao;
import ra.Model.Dao.TableDao;
import ra.Model.DaoImp.ProductDaoImp;
import ra.Model.DaoImp.TableDaoImp;
import ra.Model.Entity.Product;
import ra.Model.Entity.Table;
import ra.Model.Service.TableService;

import java.util.List;

public class TableServiceImp implements TableService<Table,String> {

    private TableDao<Table,String> tableDao = new TableDaoImp();

    @Override
    public List<Table> getAll() {
        return tableDao.getAll();
    }

    @Override
    public boolean save(Table table) {
        return tableDao.create(table);
    }

    @Override
    public boolean update(Table table) {
        return tableDao.update(table);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Table getById(String id) {
        return null;
    }

    @Override
    public List<Table> searchTableConfirm(String name) {
        return tableDao.searchTableConfirm(name);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Table> getAllConfirm() {
        return tableDao.getAllConfirm();
    }

    @Override
    public Table getById(Integer id) {
        return tableDao.getById(id);
    }

    @Override
    public List<Table> searchProByName(String name) {
        return tableDao.searchTableByName(name);
    }

    @Override
    public List<Table> searchBetween(Float num1, Float num2) {
        return null;
    }

    @Override
    public List<Table> getAllBySort() {
        return null;
    }
}
