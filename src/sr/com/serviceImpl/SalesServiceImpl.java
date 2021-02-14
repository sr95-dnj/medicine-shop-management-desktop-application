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
import java.time.LocalDateTime;
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
public class SalesServiceImpl implements CommonService<Sales>{
static Connection con=DbConnection.getInstance();
    @Override
    public void createTable() {
        String sql="create table sales (id int(5) primary key auto_increment,"
                + "customer_name varchar(50) not null,"
                + "mobile varchar(50) not null,"
                + "total double,"
                + "sales_date dateTime)";
        try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.execute();
        System.out.println("Table created");
        } 
        catch (SQLException ex) {
        Logger.getLogger(SalesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void save(Sales t) {
        String sql="insert into sales(customer_name, mobile, total, sales_date) values(?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setString(2, t.getMobile());
            ps.setDouble(3, t.getTotalPrice());
            ps.setTimestamp(4, Timestamp.valueOf(t.getSalesDate()));
            ps.executeUpdate();
            System.out.println("Data insert successfully");
        } catch (SQLException ex) {
        Logger.getLogger(SalesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void update(Sales t) {
        String sql="update sales set(customer_name=?, mobile=?, total=?, sales_date=? where id=?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, t.getCustomerName());
            ps.setString(2, t.getMobile());
            ps.setDouble(3, t.getTotalPrice());
            ps.setTimestamp(4, Timestamp.valueOf(t.getSalesDate()));
            
            ps.setInt(5, t.getId());
            ps.executeUpdate();
            System.out.println("Data update successfully");
        } catch (SQLException ex) {
        Logger.getLogger(SalesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(SalesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                sale=new Sales(rs.getInt("id"), rs.getString("customer_name"), rs.getString("mobile") ,rs.getDouble("total_price"), rs.getTimestamp("sales_date").toLocalDateTime());
            }
        } catch (SQLException ex) {
        Logger.getLogger(SalesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return sale;
    }

    @Override
    public List<Sales> getList() {
        List<Sales> list = new ArrayList();
        String sql="select * from sales";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Sales sale=new Sales(rs.getInt("id"), rs.getString("customer_name"), rs.getString("mobile"), rs.getDouble("total"), rs.getTimestamp("sales_date").toLocalDateTime());
                list.add(sale);
                
            }
        } catch (SQLException ex) {
        Logger.getLogger(SalesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    
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
