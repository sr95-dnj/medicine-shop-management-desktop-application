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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sr.com.connection.DbConnection;
import sr.com.pojo.Category;
import sr.com.pojo.Product;
import sr.com.service.CommonService;

/**
 *
 * @author User
 */
public class ProductServiceImpl implements CommonService<Product>{
static Connection con=DbConnection.getInstance();


    @Override
    public void createTable() {
        String sql="create table product (id int(5) primary key auto_increment,"
                + "name varchar(200),"
                + "type varchar(50),"
                + "cat_id int(5),"
                + "FOREIGN KEY(cat_id) REFERENCES category(id))";
        try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.execute();
        System.out.println("Table created");
        } 
        catch (SQLException ex) {
        Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void save(Product t) {
        String sql="insert into product(name, type, cat_id) values(?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getType());
            ps.setInt(3, t.getCategory().getId());
            ps.executeUpdate();
            System.out.println("Data insert successfully");
        } catch (SQLException ex) {
        Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void update(Product t) {
        String sql="update product set(name=?, type=?, cat_id=? where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getType());
            ps.setInt(3, t.getCategory().getId());
            ps.setInt(4, t.getId());
            ps.executeUpdate();
            System.out.println("Data update successfully");
        } catch (SQLException ex) {
        Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void delete(int id) {
       String sql="delete form product where id=?";
       try{
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
           System.out.println("Data delete succussfully");
       } catch (SQLException ex) {
        Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public Product get(int id) {
        Product product=null;
        String sql="select * from product where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                product=new Product(rs.getInt("id"), rs.getString("name"), rs.getString("type"),new Category(rs.getInt("id")));
            }
        } catch (SQLException ex) {
        Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return product;
    }

    @Override
    public List<Product> getList() {
        List<Product> products=new ArrayList<>();
    String sql="select * from product";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
         
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Product    product=new Product(rs.getInt("id"), rs.getString("name"), rs.getString("type"),new Category(rs.getInt("cat_id")));
            products.add(product);
            }
        } catch (SQLException ex) {
        Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return products;
    
    }

    @Override
    public List<Product> getListByCategory(int id) {
        List<Product> products=new ArrayList();
        String sql="select * from product where cat_id=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Product    product=new Product(rs.getInt("id"), rs.getString("name"), rs.getString("type"), new Category(rs.getInt("cat_id")));
               products.add(product);
            }
        } catch (SQLException ex) {
        Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return products;
            
    
    }

    @Override
    public Product getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProductByIdAndCategory(String product_name, int cat_id) {
        Product product=null;
        String sql="select * from product where name=? and cat_id =?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, product_name);
            ps.setInt(2, cat_id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                product=new Product(rs.getInt("id"), rs.getString("name"), rs.getString("type"), new Category(rs.getInt("cat_id")));
                        
            }
        } catch (SQLException ex) {
        Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return product;
    }  

    @Override
    public Product getByProductId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getUserByUserIdAndPassword(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
