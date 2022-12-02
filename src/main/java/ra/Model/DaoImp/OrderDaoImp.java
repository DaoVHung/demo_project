package ra.Model.DaoImp;

import ra.Model.Dao.BillDao;
import ra.Model.Entity.Order;
import ra.Model.Util.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImp implements BillDao<Order, String> {

    @Override
    public List<Order> searchBillByName(String name) throws SQLException {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Order> orderList = null;
        conn = ConnectionDataBase.openConnection();
        callSt = conn.prepareCall("");
        ResultSet rs = callSt.executeQuery();
        orderList = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setBillID(rs.getInt("BillID"));
            order.setFoodID(rs.getInt("FoodID"));
            order.setDrinksID(rs.getInt("DinksID"));
            order.setTableID(rs.getInt("TableID"));
            order.setBillStatus(rs.getBoolean("BillStatus"));
            order.setPrice(rs.getInt("BillPrice"));
            order.setCreated(rs.getDate("CreateDate"));
            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_DeleteBILL(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Order getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Order orderInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetByIdBILL(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            orderInfo = new Order();
            if (rs.next()) {
                orderInfo.setBillID(rs.getInt("BillID"));
                orderInfo.setFoodID(rs.getInt("FoodID"));
                orderInfo.setDrinksID(rs.getInt("DinksID"));
                orderInfo.setTableID(rs.getInt("TableID"));
                orderInfo.setBillStatus(rs.getBoolean("BillStatus"));
                orderInfo.setPrice(rs.getInt("BillPrice"));
                orderInfo.setCreated(rs.getDate("CreateDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return orderInfo;
    }

    @Override
    public List<Order> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Order> orderList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetAllBILL()}");
            ResultSet rs = callSt.executeQuery();
            orderList = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setBillID(rs.getInt("BillID"));
                order.setFoodID(rs.getInt("FoodID"));
                order.setDrinksID(rs.getInt("DinksID"));
                order.setTableID(rs.getInt("TableID"));
                order.setBillStatus(rs.getBoolean("BillStatus"));
                order.setPrice(rs.getInt("BillPrice"));
                order.setCreated(rs.getDate("CreateDate"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return orderList;
    }

    @Override
    public boolean create(Order order) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_InsertBILL(?,?,?,?,?,?,?)}");
            callSt.setInt(1, order.getBillID());
            callSt.setInt(2, order.getFoodID());
            callSt.setInt(3, order.getDrinksID());
            callSt.setInt(4, order.getTableID());
            callSt.setBoolean(5, order.isBillStatus());
            callSt.setInt(6, order.getPrice());
            callSt.setDate(7, new Date(order.getCreated().getTime()));
            callSt.execute();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Order order) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_UpdateBILL(?,?,?,?,?,?,?)}");
            callSt.setInt(1, order.getBillID());
            callSt.setInt(2, order.getFoodID());
            callSt.setInt(3, order.getDrinksID());
            callSt.setInt(4, order.getTableID());
            callSt.setBoolean(5, order.isBillStatus());
            callSt.setInt(6, order.getPrice());
            callSt.setDate(7, new Date(order.getCreated().getTime()));
            callSt.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {

        return false;
    }

    @Override
    public Order getById(String id) {
        return null;
    }
}


