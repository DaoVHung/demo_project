package ra.Model.DaoImp;

import ra.Model.Dao.DrinksDao;
import ra.Model.Entity.Bill;
import ra.Model.Entity.Drinks;
import ra.Model.Util.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrinksDaoImp implements DrinksDao<Drinks,String> {

    @Override
    public List<Drinks> searchDrinksByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Drinks> drinksInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_SearchByDrinksName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            drinksInfo = new ArrayList<>();
            while (rs.next()) {
                Drinks drinks = new Drinks();
                drinks.setDrinksID(rs.getInt("DrinksID"));
                drinks.setCatalogID(rs.getString("CatalogName"));
                drinks.setDrinksName(rs.getString("DrinksName"));
                drinks.setPrice(rs.getInt("DrinksPrice"));
                drinks.setTitle(rs.getString("DrinksTitle"));
                drinks.setDrinksStatus(rs.getBoolean("DrinksStatus"));
                drinksInfo.add(drinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return drinksInfo;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt2 = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt2 = conn.prepareCall(" call 3pr_DeleteDrinksImg(?) ");
            callSt2.setInt(1,id);
            callSt2.executeUpdate();
            callSt = conn.prepareCall("{call 3pr_DeleteDrinks(?)}");
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
    public Drinks getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Drinks drinksInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetByIdDrinks(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            drinksInfo = new Drinks();
            if (rs.next()) {
                drinksInfo.setDrinksID(rs.getInt("DrinksID"));
                drinksInfo.setDrinksName(rs.getString("DrinksName"));
                drinksInfo.setPrice(rs.getInt("DrinksPrice"));
                drinksInfo.setTitle(rs.getString("DrinksTitle"));
                drinksInfo.setDrinksImg(rs.getString("DrinksImg"));
                CallableStatement callSt2 = conn.prepareCall("{call 7pr_get_Img_ID(?) }");
                callSt2.setInt(1,id);
                ResultSet rs2 = callSt2.executeQuery();
                while (rs2.next()){
                    drinksInfo.getListImgLinks().add(rs2.getString("imgLink"));

                }
                callSt2.close();
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return drinksInfo;
    }
    @Override
    public List<Drinks> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Drinks> drinksInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetAllDrinks()}");
            ResultSet rs = callSt.executeQuery();
           drinksInfo = new ArrayList<>();
            while (rs.next()) {
                Drinks drinks = new Drinks();
                drinks.setDrinksID(rs.getInt("DrinksID"));
                drinks.setCatalogID(rs.getString("CatalogName"));
                drinks.setDrinksName(rs.getString("DrinksName"));
                drinks.setPrice(rs.getInt("DrinksPrice"));
                drinks.setTitle(rs.getString("DrinksTitle"));
                drinks.setDrinksStatus(rs.getBoolean("DrinksStatus"));
                drinks.setDrinksImg(rs.getString("DrinksImg"));
                drinksInfo.add(drinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return drinksInfo;
    }
    public List<Drinks> getAllShort() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Drinks> drinksInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetAllDrinks()}");
            ResultSet rs = callSt.executeQuery();
            drinksInfo = new ArrayList<>();
            while (rs.next()) {
                Drinks drinks = new Drinks();
                drinks.setDrinksID(rs.getInt("DrinksID"));
                drinks.setCatalogID(rs.getString("CatalogName"));
                drinks.setDrinksName(rs.getString("DrinksName"));
                drinks.setPrice(rs.getInt("DrinksPrice"));
                drinks.setTitle(rs.getString("DrinksTitle"));
                drinks.setDrinksStatus(rs.getBoolean("DrinksStatus"));
                drinksInfo.add(drinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return drinksInfo;
    }

    @Override
    public boolean create(Drinks drinks) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_InsertDrinks(?,?,?,?,?,?,?)}");
            callSt.setInt(1, Integer.parseInt(drinks.getCatalogID()));
            callSt.setString(2, drinks.getDrinksName());
            callSt.setInt(3, drinks.getPrice());
            callSt.setString(4, drinks.getTitle());
            callSt.setBoolean(5, drinks.isDrinksStatus());
            callSt.setString(6,drinks.getDrinksImg());
            callSt.registerOutParameter(7, Types.INTEGER);
            callSt.execute();
            int drinksID = callSt.getInt(7);
            for (String imgLinks : drinks.getListImgLinks()){
                CallableStatement callSt2 = conn.prepareCall("{call 7pr_insert_Image(?,?) }");
                callSt2.setString(1,imgLinks);
                callSt2.setInt(2,drinksID);
                callSt2.executeUpdate();
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
    public boolean update(Drinks drinks) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_UpdateDrinks(?,?,?,?,?,?,?)}");
            callSt.setInt(1,drinks.getDrinksID());
            callSt.setInt(2, Integer.parseInt(drinks.getCatalogID()));
            callSt.setString(3, drinks.getDrinksName());
            callSt.setInt(4, drinks.getPrice());
            callSt.setString(5, drinks.getTitle());
            callSt.setBoolean(6, drinks.isDrinksStatus());
            callSt.setString(7,drinks.getDrinksImg());
            callSt.executeUpdate();
            int drinksID = drinks.getDrinksID();
            for (String imgLinks : drinks.getListImgLinks()){
                CallableStatement callSt2 = conn.prepareCall("{call 7pr_updateImg(?,?) }");
                callSt2.setString(1,imgLinks);
                callSt2.setInt(2,drinksID);
                callSt2.executeUpdate();
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
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Drinks getById(String id) {
        return null;
    }
}
