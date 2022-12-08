package ra.Model.DaoImp;

import ra.Model.Dao.OrderDetailDao;
import ra.Model.Entity.OrderDetail;

import ra.Model.Entity.Product;
import ra.Model.Entity.Table;
import ra.Model.Util.ConnectionDataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImp implements OrderDetailDao<OrderDetail,String> {

    @Override
    public List<OrderDetail> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<OrderDetail> orderDetails = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 4pr_GetByIdOrderDetail(?)}");
            ResultSet rs = callSt.executeQuery();
            orderDetails = new ArrayList<>();
            while (rs.next()) {
                OrderDetail order = new OrderDetail();
                order.setProductID(rs.getInt("ProductID"));
                order.setOrderID(rs.getInt("OrderID"));
                order.setQuantity(rs.getInt("Quantity"));
                order.setPrice(rs.getInt("Price"));
                orderDetails.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return orderDetails;
    }

    public List<OrderDetail> getAllDetail(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<OrderDetail> orderDetails = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 4pr_GetAllOrderDetail(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            orderDetails = new ArrayList<>();
            while (rs.next()) {
                OrderDetail order = new OrderDetail();
                order.setProductName(rs.getString("ProductName"));
                order.setOrderID(rs.getInt("OrderID"));
                order.setQuantity(rs.getInt("Quantity"));
                order.setPrice(rs.getInt("Price"));
                orderDetails.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return orderDetails;
    }

    @Override
    public boolean create(OrderDetail orderDetail) {
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

    @Override
    public List<OrderDetail> searchProductByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<OrderDetail> orderDetails = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 5pr_SearchByUserName(?)}");
            callSt.setString(1,name);
            ResultSet rs = callSt.executeQuery();
            orderDetails = new ArrayList<>();
            while (rs.next()) {
                OrderDetail order = new OrderDetail();
                order.setProductName(rs.getString("ProductName"));
                order.setOrderID(rs.getInt("OrderID"));
                order.setQuantity(rs.getInt("Quantity"));
                order.setPrice(rs.getInt("Price"));
                orderDetails.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return orderDetails;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public List<OrderDetail> getAllMainFood() {
        return null;
    }

    @Override
    public List<OrderDetail> getAllDrinks() {
        return null;
    }

    @Override
    public List<OrderDetail> getAllDesserts() {
        return null;
    }

    @Override
    public List<OrderDetail> getAllSalad() {
        return null;
    }
}


