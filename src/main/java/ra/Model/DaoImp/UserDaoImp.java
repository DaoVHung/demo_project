package ra.Model.DaoImp;

import ra.Model.Dao.UserDao;
import ra.Model.Entity.User;
import ra.Model.Util.ConnectionDataBase;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao<User, String> {


    @Override
    public List<User> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> userList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_GetAllUser()}");
            ResultSet rs = callSt.executeQuery();
            userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPasswords(rs.getString("Passwords"));
                user.setConfirmPass(rs.getString("ConfirmPass"));
                user.setFullName(rs.getString("FullName"));
                user.setUserStatus(rs.getBoolean("UserStatus"));
                user.setPermission(rs.getBoolean("Permission"));
                user.setEmail(rs.getString("Email"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return userList;
    }
    public boolean matchAcc(String UserName, String Pass){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_MatchAccount(?,?,?)}");
            callSt.setString(1,UserName);
            callSt.setString(2,Pass);
            callSt.registerOutParameter(3, Types.INTEGER);
            callSt.execute();
            int cnt = callSt.getInt(3);
             if(cnt==1){
                 result = true;
             }else {
                 result = false;
             }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return result;
    }

    public Integer IsUser(String UserName, String Pass){
        Connection conn = null;
        CallableStatement callSt = null;
        Integer userID = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_GetUserID(?,?,?)}");
            callSt.setString(1,UserName);
            callSt.setString(2,Pass);
            callSt.registerOutParameter(3, Types.INTEGER);
            callSt.execute();
            userID = callSt.getInt(3);
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return userID;
    }



    public boolean matchAccAdmin(String UserName, String Pass){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_MatchAccountAdmin(?,?,?)}");
            callSt.setString(1,UserName);
            callSt.setString(2,Pass);
            callSt.registerOutParameter(3, Types.INTEGER);
            callSt.execute();
            int cnt = callSt.getInt(3);
            if(cnt==1){
                result = true;
            }else {
                result = false;
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
    public boolean create(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_InsertUser(?,?,?,?,?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, user.getPasswords());
            callSt.setString(3, user.getConfirmPass());
            callSt.setString(4, user.getFullName());
            callSt.setString(5, user.getEmail());
            callSt.setString(6, user.getPhoneNumber());
            callSt.setString(7, user.getAddress());
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
    public boolean update(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_UpdateUserAdmin(?,?)}");
            callSt.setInt(1, user.getUserID());
            callSt.setBoolean(2, user.isPermission());
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
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> searchUserByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> userList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_SearchByUserName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPasswords(rs.getString("Passwords"));
                user.setConfirmPass(rs.getString("ConfirmPass"));
                user.setFullName(rs.getString("FullName"));
                user.setUserStatus(rs.getBoolean("UserStatus"));
                user.setPermission(rs.getBoolean("Permission"));
                user.setEmail(rs.getString("Email"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setAddress(rs.getString("Address"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return userList;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_DeleteUser(?)}");
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
    public User getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 2pr_GetByIdUser(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            user = new User();
            while (rs.next()) {
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPasswords(rs.getString("Passwords"));
                user.setConfirmPass(rs.getString("ConfirmPass"));
                user.setFullName(rs.getString("FullName"));
                user.setUserStatus(rs.getBoolean("UserStatus"));
                user.setPermission(rs.getBoolean("Permission"));
                user.setEmail(rs.getString("Email"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setAddress(rs.getString("Address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return user;
    }
}
