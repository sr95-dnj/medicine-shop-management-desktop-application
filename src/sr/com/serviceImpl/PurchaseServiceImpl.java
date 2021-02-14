/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.com.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sr.com.connection.DbConnection;
import sr.com.pojo.Product;
import sr.com.pojo.Purchase;
import sr.com.service.CommonService;

/**
 *
 * @author User
 */
public class PurchaseServiceImpl implements CommonService<Purchase>{
static Connection con=DbConnection.getInstance();
    @Override
    public void createTable() {
        String sql="create table purchase (id int(5) primary key auto_increment,"
                + "product_id int(11),"
                + "quantity int(10),"
                + "unit_price double,"
                + "total_price double,"
                + "sell_price double,"
                + "purchase_date datetime,"
                + "foreign key (product_id) references product(id))";
        try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.execute();
        System.out.println("Table created");
        } 
        catch (SQLException ex) {
        Logger.getLogger(PurchaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void save(Purchase t) {
        String sql="insert into purchase(product_id, quantity, unit_price, sell_price, total_price, purchase_date) values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, t.getProduct().getId());
            ps.setInt(2, t.getQuantity());
            ps.setDouble(3, t.getUnitPrice());
            ps.setDouble(4, t.getTotalPrice());
            ps.setDouble(5, t.getSellPrice());
            ps.setTimestamp(6, Timestamp.valueOf(t.getPurchaseDate()));
            ps.executeUpdate();
            System.out.println("Data insert successfully");
        } catch (SQLException ex) {
        Logger.getLogger(PurchaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void update(Purchase t) {
        String sql="update purchase set(product_id=?, quantity=?, unit_price=?, sell_price=?, total_price=?, purchase_date=? where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
           
            ps.setInt(1, t.getProduct().getId());
            ps.setInt(2, t.getQuantity());
            ps.setDouble(3, t.getUnitPrice());
            ps.setDouble(4, t.getTotalPrice());
            ps.setDouble(5, t.getSellPrice());
            ps.setTimestamp(6, Timestamp.valueOf(t.getPurchaseDate()));
            ps.setInt(7, t.getId());
            ps.executeUpdate();
            System.out.println("Data update successfully");
        } catch (SQLException ex) {
        Logger.getLogger(PurchaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void delete(int id) {
       String sql="delete form purchase where id=?";
       try{
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setInt(id, id);
           ps.executeUpdate();
           System.out.println("Data delete succussfully");
       } catch (SQLException ex) {
        Logger.getLogger(PurchaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public Purchase get(int id) {
        Purchase purchase=null;
        String sql="select * from purchase where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                purchase=new Purchase(rs.getInt("id"), new Product(rs.getInt("product_id")), rs.getInt("quantity"), rs.getDouble("unit_price"), rs.getDouble("total_price"), rs.getDouble("sell_price"), rs.getTimestamp("purchase_date").toLocalDateTime());
            }
        } catch (SQLException ex) {
        Logger.getLogger(PurchaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return purchase;
    }

    @Override
    public List<Purchase> getList() {
        List<Purchase> purchases=new ArrayList<>();
    String sql="select * from purchase";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
           
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              Purchase  purchase=new Purchase(rs.getInt("id"), new Product(rs.getInt("product_id")), rs.getInt("quantity"), rs.getDouble("unit_price"), rs.getDouble("total_price"), rs.getDouble("sell_price"), rs.getTimestamp("purchase_date").toLocalDateTime());
              purchases.add(purchase);
            }
        } catch (SQLException ex) {
        Logger.getLogger(PurchaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return purchases;
    
    }

    @Override
    public List<Purchase> getListByCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase getProductByIdAndCategory(String product_name, int cat_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase getByProductId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase getUserByUserIdAndPassword(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
