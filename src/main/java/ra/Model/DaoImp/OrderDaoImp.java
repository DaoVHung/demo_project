package ra.Model.DaoImp;

import ra.Model.Dao.OrderDao;
import ra.Model.Entity.Order;
import ra.Model.Entity.OrderDetail;
import ra.Model.Util.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImp implements OrderDao<Order, String> {

    @Override
    public List<Order> searchBillByName(String name) throws SQLException {
        return null;
    }

    public Integer getEarning() {
        Connection conn = null;
        CallableStatement callSt = null;
        Integer earning = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call getEarning(?)}");
            callSt.registerOutParameter(1, Types.INTEGER);
            callSt.execute();
            earning = callSt.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return earning;
    }

    @Override
    public List<Order> searchProductByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Order> orderList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 5pr_SearchByUserName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            orderList = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserId"));
                order.setDate(rs.getDate("OrderDate").toLocalDate());
                order.setTotalAmount(rs.getInt("TotalAmount"));
                order.setNote(rs.getString("Note"));
                order.setFullName(rs.getString("FullName"));
                order.setAddress(rs.getString("Address"));
                order.setPhoneNumber(rs.getInt("PhoneNumber"));
                order.setEmail(rs.getString("Email"));
                order.setOrderStatus(rs.getBoolean("OrderStatus"));
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
    public List<Order> searchConfirm(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Order> orderList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 5pr_SearchConfirm(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            orderList = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserId"));
                order.setDate(rs.getDate("OrderDate").toLocalDate());
                order.setTotalAmount(rs.getInt("TotalAmount"));
                order.setNote(rs.getString("Note"));
                order.setFullName(rs.getString("FullName"));
                order.setAddress(rs.getString("Address"));
                order.setPhoneNumber(rs.getInt("PhoneNumber"));
                order.setEmail(rs.getString("Email"));
                order.setOrderStatus(rs.getBoolean("OrderStatus"));
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
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 5pr_DeleteOrder(?)}");
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
        Order order = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 5pr_GetByIdOrder(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            order = new Order();
            if (rs.next()) {
                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserId"));
                order.setDate(rs.getDate("OrderDate").toLocalDate());
                order.setTotalAmount(rs.getInt("TotalAmount"));
                order.setNote(rs.getString("Note"));
                order.setFullName(rs.getString("FullName"));
                order.setAddress(rs.getString("Address"));
                order.setPhoneNumber(rs.getInt("PhoneNumber"));
                order.setEmail(rs.getString("Email"));
                order.setOrderStatus(rs.getBoolean("OrderStatus"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return order;
    }

    @Override
    public List<Order> getConfrim() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Order> orderList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 5pr_GetAllOrdersConfrim()}");
            ResultSet rs = callSt.executeQuery();
            orderList = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserId"));
                order.setDate(rs.getDate("OrderDate").toLocalDate());
                order.setTotalAmount(rs.getInt("TotalAmount"));
                order.setNote(rs.getString("Note"));
                order.setFullName(rs.getString("FullName"));
                order.setAddress(rs.getString("Address"));
                order.setPhoneNumber(rs.getInt("PhoneNumber"));
                order.setEmail(rs.getString("Email"));
                order.setOrderStatus(rs.getBoolean("OrderStatus"));
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
    public List<Order> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Order> orderList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 5pr_GetAllOrders()}");
            ResultSet rs = callSt.executeQuery();
            orderList = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserId"));
                order.setDate(rs.getDate("OrderDate").toLocalDate());
                order.setTotalAmount(rs.getInt("TotalAmount"));
                order.setNote(rs.getString("Note"));
                order.setFullName(rs.getString("FullName"));
                order.setAddress(rs.getString("Address"));
                order.setPhoneNumber(rs.getInt("PhoneNumber"));
                order.setEmail(rs.getString("Email"));
                order.setOrderStatus(rs.getBoolean("OrderStatus"));
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
            callSt = conn.prepareCall("{call 5pr_InsertOrder(?,?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, order.getUserID());
            callSt.setDate(2, Date.valueOf(order.getDate()));
            callSt.setInt(3, order.getTotalAmount());
            callSt.setString(4, order.getNote());
            callSt.setString(5, order.getFullName());
            callSt.setString(6, order.getAddress());
            callSt.setInt(7, order.getPhoneNumber());
            callSt.setString(8, order.getEmail());
            callSt.registerOutParameter(9, Types.INTEGER);
            callSt.execute();
            int orderId = callSt.getInt(9);
            //Them du lieu cho bang OrderDetail
            for (OrderDetail od : order.getListOrderDetail()) {
                CallableStatement callSt2 = conn.prepareCall("{call 4pr_InsertOrderDetail(?,?,?,?,?)}");
                callSt2.setInt(1, od.getProductID());
                callSt2.setInt(2, orderId);
                callSt2.setInt(3, od.getQuantity());
                callSt2.setInt(4, od.getPrice() * od.getQuantity());
                callSt2.setInt(5, od.getPrice());
                callSt2.execute();
                callSt2.close();
            }

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
            callSt = conn.prepareCall("{call 5pr_UpdateOrder(?,?)}");
            callSt.setInt(1, order.getOrderID());
            callSt.setBoolean(2, order.isOrderStatus());
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
    public boolean delete(String id) {

        return false;
    }

    @Override
    public Order getById(String id) {
        return null;
    }
}


