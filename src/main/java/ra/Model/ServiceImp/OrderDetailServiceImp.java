package ra.Model.ServiceImp;

import ra.Model.Dao.CatalogDao;
import ra.Model.Dao.OrderDetailDao;
import ra.Model.DaoImp.CatalogImp;
import ra.Model.DaoImp.OrderDetailDaoImp;
import ra.Model.Entity.Catalog;
import ra.Model.Entity.Order;
import ra.Model.Entity.OrderDetail;
import ra.Model.Service.OrderDetailService;

import java.util.List;

public class OrderDetailServiceImp implements OrderDetailService<OrderDetail,String> {
    private OrderDetailDao<OrderDetail,String> orderDetailDaoImp = new OrderDetailDaoImp();

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Order getById(Integer id) {
        return null;
    }

    @Override
    public List<OrderDetail> searchProByName(String name) {
        return null;
    }

    @Override
    public List<OrderDetail> searchBetween(Float num1, Float num2) {
        return null;
    }

    @Override
    public List<OrderDetail> getAllBySort() {
        return null;
    }
    public List<OrderDetail> getAllDetail(Integer id){
        return orderDetailDaoImp.getAllDetail(id);
    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailDaoImp.getAll();
    }

    @Override
    public boolean save(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public OrderDetail getById(String id) {
        return null;
    }
}
