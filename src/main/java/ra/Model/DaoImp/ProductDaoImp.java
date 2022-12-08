package ra.Model.DaoImp;

import ra.Model.Dao.ProductDao;
import ra.Model.Entity.Product;
import ra.Model.Util.ConnectionDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao<Product,String> {
    public List<Product> getProductByUserID(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productsInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_ProductByUser(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            productsInfo = new ArrayList<>();
            while (rs.next()) {
                Product products = new Product();
                products.setProductID(rs.getInt("productID"));
                products.setOrderID(rs.getInt("OrderID"));
                products.setProductName(rs.getString("productName"));
                products.setProductImg(rs.getString("productImg"));
                productsInfo.add(products);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productsInfo;
    }
    @Override
    public List<Product> searchProductByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productsInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_SearchByProductName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            productsInfo = new ArrayList<>();
            while (rs.next()) {
                Product products = new Product();
                products.setProductID(rs.getInt("productID"));
                products.setCatalogID(rs.getString("CatalogName"));
                products.setProductName(rs.getString("productName"));
                products.setPrice(rs.getInt("productPrice"));
                products.setDescription(rs.getString("Description"));
                products.setProductStatus(rs.getBoolean("productStatus"));
                productsInfo.add(products);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productsInfo;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_DeleteProduct(?)}");
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
    public Product getById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetByIdProduct(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            productInfo = new Product();
            if (rs.next()) {
                productInfo.setProductID(rs.getInt("ProductID"));
                productInfo.setProductName(rs.getString("ProductName"));
                productInfo.setPrice(rs.getInt("ProductPrice"));
                productInfo.setDescription(rs.getString("Description"));
                productInfo.setProductImg(rs.getString("ProductImg"));
                productInfo.setDiscount(rs.getInt("Discount"));
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }
    @Override
    public List<Product> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetAllProduct()}");
            ResultSet rs = callSt.executeQuery();
            productInfo = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCatalogID(rs.getString("CatalogName"));
                product.setProductName(rs.getString("ProductName"));
                product.setPrice(rs.getInt("ProductPrice"));
                product.setProductStatus(rs.getBoolean("ProductStatus"));
                product.setProductImg(rs.getString("ProductImg"));
                product.setDescription(rs.getString("Description"));
                product.setDiscount(rs.getInt("Discount"));
                productInfo.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }
// ==========================   get all mainfood  =========================== //
public List<Product> getAllMainFood() {
    Connection conn = null;
    CallableStatement callSt = null;
    List<Product> productInfo = null;
    try {
        conn = ConnectionDataBase.openConnection();
        callSt = conn.prepareCall("{call 3pr_GetALLMainFood()}");
        ResultSet rs = callSt.executeQuery();
        productInfo = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setCatalogID(rs.getString("CatalogName"));
            product.setProductName(rs.getString("ProductName"));
            product.setPrice(rs.getInt("ProductPrice"));
            product.setProductStatus(rs.getBoolean("ProductStatus"));
            product.setProductImg(rs.getString("ProductImg"));
            product.setDescription(rs.getString("Description"));
            product.setDiscount(rs.getInt("Discount"));
            productInfo.add(product);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        ConnectionDataBase.closeConnection(conn, callSt);
    }
    return productInfo;
}
    // ==========================   get all drinks  =========================== //
    public List<Product> getAllDrinks() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetALLDrinks()}");
            ResultSet rs = callSt.executeQuery();
            productInfo = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCatalogID(rs.getString("CatalogName"));
                product.setProductName(rs.getString("ProductName"));
                product.setPrice(rs.getInt("ProductPrice"));
                product.setProductStatus(rs.getBoolean("ProductStatus"));
                product.setProductImg(rs.getString("ProductImg"));
                product.setDescription(rs.getString("Description"));
                product.setDiscount(rs.getInt("Discount"));
                productInfo.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }

    @Override
    public List<Product> getAllDesserts() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetALLDesserts()}");
            ResultSet rs = callSt.executeQuery();
            productInfo = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCatalogID(rs.getString("CatalogName"));
                product.setProductName(rs.getString("ProductName"));
                product.setPrice(rs.getInt("ProductPrice"));
                product.setProductStatus(rs.getBoolean("ProductStatus"));
                product.setProductImg(rs.getString("ProductImg"));
                product.setDescription(rs.getString("Description"));
                product.setDiscount(rs.getInt("Discount"));
                productInfo.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }

    // ==========================   get all salas  =========================== //
    public List<Product> getAllSalad() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetALLSalad()}");
            ResultSet rs = callSt.executeQuery();
            productInfo = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCatalogID(rs.getString("CatalogName"));
                product.setProductName(rs.getString("ProductName"));
                product.setPrice(rs.getInt("ProductPrice"));
                product.setProductStatus(rs.getBoolean("ProductStatus"));
                product.setProductImg(rs.getString("ProductImg"));
                product.setDescription(rs.getString("Description"));
                product.setDiscount(rs.getInt("Discount"));
                productInfo.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }
    // ==========================   get all drinks  =========================== //







    public List<Product> getAllShort() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productInfo = null;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_GetAllProduct()}");
            ResultSet rs = callSt.executeQuery();
            productInfo = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setCatalogID(rs.getString("CatalogName"));
                product.setProductName(rs.getString("ProductName"));
                product.setPrice(rs.getInt("ProductPrice"));
                product.setProductStatus(rs.getBoolean("ProductStatus"));
                productInfo.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDataBase.closeConnection(conn, callSt);
        }
        return productInfo;
    }

    @Override
    public boolean create(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;

        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_InsertProduct(?,?,?,?,?,?,?)}");
            callSt.setInt(1, Integer.parseInt(product.getCatalogID()));
            callSt.setString(2, product.getProductName());
            callSt.setInt(3, product.getPrice());
            callSt.setString(4, product.getDescription());
            callSt.setBoolean(5, product.isProductStatus());
            callSt.setString(6,product.getProductImg());
            callSt.setInt(7, product.getDiscount());
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
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDataBase.openConnection();
            callSt = conn.prepareCall("{call 3pr_UpdateProduct(?,?,?,?,?,?,?,?)}");
            callSt.setInt(1,product.getProductID());
            callSt.setInt(2, Integer.parseInt(product.getCatalogID()));
            callSt.setString(3, product.getProductName());
            callSt.setInt(4, product.getPrice());
            callSt.setString(5, product.getDescription());
            callSt.setBoolean(6, product.isProductStatus());
            callSt.setString(7,product.getProductImg());
            callSt.setInt(8,product.getDiscount());
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
    public Product getById(String id) {
        return null;
    }
}
