package ra.Model.DaoImp;

import ra.Model.Dao.CatalogDao;
import ra.Model.Entity.Bill;
import ra.Model.Entity.Catalog;
import ra.Model.Util.ConnectionDataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatalogImp implements CatalogDao<Catalog, String> {

    @Override
    public List<Catalog> searchBillByName(String name) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_DeleteCatalog(?)}");
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
    public Catalog getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Catalog cata = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetByIdCatalog()}");
            ResultSet rs = callSt.executeQuery();
            cata = new Catalog();
            while (rs.next()) {
                cata.setCatalogID(rs.getInt("CatalogID"));
                cata.setCatalogName(rs.getString("CatalogName"));
                cata.setTitle(rs.getString("Title"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return cata;
    }

    @Override
    public List<Catalog> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> catalogList = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_GetAllCatalog()}");
            ResultSet rs = callSt.executeQuery();
            catalogList = new ArrayList<>();
            while (rs.next()) {
                Catalog cata = new Catalog();
                cata.setCatalogID(rs.getInt("CatalogID"));
                cata.setCatalogName(rs.getString("CatalogName"));
                cata.setTitle(rs.getString("Title"));
                catalogList.add(cata);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return catalogList;
    }

    @Override
    public boolean create(Catalog catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_InsertDrinks_Catalog(?,?,?)}");
            callSt.setInt(1, catalog.getCatalogID());
            callSt.setString(2, catalog.getCatalogName());
            callSt.setString(3, catalog.getTitle());
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
    public boolean update(Catalog catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call pr_UpdateDrinks_Catalog(?,?,?)}");
            callSt.setInt(1, catalog.getCatalogID());
            callSt.setString(2, catalog.getCatalogName());
            callSt.setString(3, catalog.getTitle());
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
    public Catalog getById(String id) {
        return null;
    }
}
