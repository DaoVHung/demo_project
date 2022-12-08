package ra.Model.DaoImp;

import javafx.scene.control.Tab;
import ra.Model.Dao.TableDao;
import ra.Model.Entity.Table;
import ra.Model.Util.ConnectionDataBase;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImp implements TableDao<Table, String> {

    public List<Table> getAllConfirm() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Table> tableList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 1pr_GetAllTableConfirm()}");
            ResultSet rs = callSt.executeQuery();
            tableList = new ArrayList<>();
            if (rs.next()) {
                Table table = new Table();
                table.setTableID(rs.getInt("TableID"));
                table.setUserID(rs.getInt("UserID"));
                table.setUserName(rs.getString("FullName"));
                table.setEmail(rs.getString("Email"));
                table.setPhoneNumber(rs.getInt("PhoneNumber"));
                table.setPeople(rs.getInt("People"));
                table.setDate(rs.getDate("Dates").toLocalDate());
                table.setTime(rs.getTime("Times").toLocalTime());
                table.setSubject(rs.getString("Subjects"));
                table.setMessege(rs.getString("Message"));
                table.setStatus(rs.getBoolean("OrderStatus"));
                tableList.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return tableList;
    }
    @Override
    public List<Table> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Table> tableList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 1pr_GetAllTable()}");
            ResultSet rs = callSt.executeQuery();
            tableList = new ArrayList<>();
            if (rs.next()) {
                Table table = new Table();
                table.setTableID(rs.getInt("TableID"));
                table.setUserID(rs.getInt("UserID"));
                table.setUserName(rs.getString("FullName"));
                table.setEmail(rs.getString("Email"));
                table.setPhoneNumber(rs.getInt("PhoneNumber"));
                table.setPeople(rs.getInt("People"));
                table.setDate(rs.getDate("Dates").toLocalDate());
                table.setTime(rs.getTime("Times").toLocalTime());
                table.setSubject(rs.getString("Subjects"));
                table.setMessege(rs.getString("Message"));
                table.setStatus(rs.getBoolean("OrderStatus"));
                tableList.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return tableList;
    }

    @Override
    public boolean create(Table table) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 1pr_InsertTable(?,?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, table.getUserID());
            callSt.setString(2, table.getUserName());
            callSt.setString(3, table.getEmail());
            callSt.setInt(4, table.getPhoneNumber());
            callSt.setInt(5, table.getPeople());
            callSt.setDate(6, Date.valueOf(table.getDate()));
            callSt.setTime(7, Time.valueOf(table.getTime()));
            callSt.setString(8, table.getSubject());
            callSt.setString(9,table.getMessege());
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
    public boolean update(Table table) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 1pr_UpdateTable(?,?)}");
            callSt.setInt(1, table.getTableID());
            callSt.setBoolean(2,table.isStatus());
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
    public Table getById(String id) {
        return null;
    }

    @Override
    public List<Table> searchTableByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Table> tableList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 1pr_SearchByUserName(?)}");
            callSt.setString(1,name);
            ResultSet rs = callSt.executeQuery();
            tableList = new ArrayList<>();
            if (rs.next()) {
                Table table = new Table();
                table.setTableID(rs.getInt("TableID"));
                table.setUserID(rs.getInt("UserID"));
                table.setUserName(rs.getString("FullName"));
                table.setEmail(rs.getString("Email"));
                table.setPhoneNumber(rs.getInt("PhoneNumber"));
                table.setPeople(rs.getInt("People"));
                table.setDate(rs.getDate("Dates").toLocalDate());
                table.setTime(rs.getTime("Times").toLocalTime());
                table.setSubject(rs.getString("Subjects"));
                table.setMessege(rs.getString("Message"));
                table.setStatus(rs.getBoolean("OrderStatus"));
                tableList.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return tableList;
    }

    @Override
    public List<Table> searchTableConfirm(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Table> tableList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 1pr_SearchByConfirm(?)}");
            callSt.setString(1,name);
            ResultSet rs = callSt.executeQuery();
            tableList = new ArrayList<>();
            if (rs.next()) {
                Table table = new Table();
                table.setTableID(rs.getInt("TableID"));
                table.setUserID(rs.getInt("UserID"));
                table.setUserName(rs.getString("FullName"));
                table.setEmail(rs.getString("Email"));
                table.setPhoneNumber(rs.getInt("PhoneNumber"));
                table.setPeople(rs.getInt("People"));
                table.setDate(rs.getDate("Dates").toLocalDate());
                table.setTime(rs.getTime("Times").toLocalTime());
                table.setSubject(rs.getString("Subjects"));
                table.setMessege(rs.getString("Message"));
                table.setStatus(rs.getBoolean("OrderStatus"));
                tableList.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return tableList;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_DeleteTable(?)}");
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
    public Table getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Table table = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 1pr_GetByIdTable(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            table = new Table();
            if (rs.next()) {
                table.setTableID(rs.getInt("TableID"));
                table.setUserID(rs.getInt("UserID"));
                table.setUserName(rs.getString("FullName"));
                table.setEmail(rs.getString("Email"));
                table.setPhoneNumber(rs.getInt("PhoneNumber"));
                table.setPeople(rs.getInt("People"));
                table.setDate(rs.getDate("Dates").toLocalDate());
                table.setTime(rs.getTime("Times").toLocalTime());
                table.setSubject(rs.getString("Subjects"));
                table.setMessege(rs.getString("Message"));
                table.setStatus(rs.getBoolean("OrderStatus"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return table;
    }
}
