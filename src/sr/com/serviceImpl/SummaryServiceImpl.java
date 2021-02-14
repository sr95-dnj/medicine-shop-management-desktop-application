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
import sr.com.pojo.Sales;
import sr.com.service.CommonService;

/**
 *
 * @author User
 */
public class SummaryServiceImpl implements CommonService<Sales>{
static Connection con=DbConnection.getInstance();
    @Override
    public void createTable() {
        String sql="create table sales (id int(5) primary key auto_increment,"
                + "product_id int(11),"
                + "customer_name varchar(100),"
                + "mobile varchar(15),"
                + "quantity int(10),"
                + "unit_price double,"
                + "total_price double,"
                + "sales_date datetime,"
                + "foreign key (product_id) references product(id))";
        try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.execute();
        System.out.println("Table created");
        } 
        catch (SQLException ex) {
        Logger.getLogger(SummaryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void save(Sales t) {
        String sql="insert into sales(id, product_id, customer_name, mobile, quantity, unit_price, total_price, sales_date) values(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, t.getProduct().getId());
            ps.setString(2, t.getCustomerName());
            ps.setString(3, t.getMobile());
            ps.setInt(4, t.getQuantity());
            ps.setDouble(5, t.getUnitPrice());
            ps.setDouble(6, t.getTotalPrice());
            ps.setTimestamp(7, Timestamp.valueOf(t.getSalesDate()));
            ps.executeUpdate();
            System.out.println("Data insert successfully");
        } catch (SQLException ex) {
        Logger.getLogger(SummaryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void update(Sales t) {
        String sql="update sales set(product_id=?, customer_name=?, mobile=?, quantity=?, unit_price=?, total_price=?,sales_date=? where id=?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
           
            ps.setInt(1, t.getProduct().getId());
            ps.setString(2, t.getCustomerName());
            ps.setString(3, t.getMobile());
            ps.setInt(4, t.getQuantity());
            ps.setDouble(5, t.getUnitPrice());
            ps.setDouble(6, t.getTotalPrice());
            ps.setTimestamp(7, Timestamp.valueOf(t.getSalesDate()));
            ps.setInt(8, t.getId());
            ps.executeUpdate();
            System.out.println("Data update successfully");
        } catch (SQLException ex) {
        Logger.getLogger(SummaryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void delete(int id) {
       String sql="delete form sales where id=?";
       try{
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setInt(id, id);
           ps.executeUpdate();
           System.out.println("Data delete succussfully");
       } catch (SQLException ex) {
        Logger.getLogger(SummaryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public Sales get(int id) {
        Sales sale=null;
        String sql="select * from sales where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                sale=new Sales(rs.getInt("id"), new Product(rs.getInt("id")), rs.getString("customer_name"), rs.getString("mobile"), rs.getInt("quantity"), rs.getDouble("unit_price"), rs.getDouble("total_price"), rs.getTimestamp("sales_date").toLocalDateTime());
            }
        } catch (SQLException ex) {
        Logger.getLogger(SummaryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return sale;
    }

    @Override
    public List<Sales> getList() {
        List<Sales> sales=new ArrayList<>();
    String sql="select * from sales";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
           
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              Sales  sale=new Sales(rs.getInt("id"), new Product(rs.getInt("id")), rs.getString("customer_name"), rs.getString("mobile"), rs.getInt("quantity"), rs.getDouble("unit_price"), rs.getDouble("total_price"), rs.getTimestamp("sales_date").toLocalDateTime());
            }
        } catch (SQLException ex) {
        Logger.getLogger(SummaryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return sales;
    
    }

    @Override
    public List<Sales> getListByCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sales getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sales getProductByIdAndCategory(String product_name, int cat_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sales getByProductId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sales getUserByUserIdAndPassword(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
