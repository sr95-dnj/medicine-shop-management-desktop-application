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
import sr.com.pojo.User;
import sr.com.service.CommonService;

public class UserServiceImpl implements CommonService<User> {

    static Connection con = DbConnection.getInstance();

    @Override
    public void save(User t) {
        String sql="insert into user(name, username, password, email, address, gender, note) values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getUsername());
            ps.setString(3, t.getPassword());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getAddress());
            ps.setString(6, t.getGender());
            ps.setString(7, t.getNote());
            ps.executeUpdate();
            System.out.println("Data insert successfully");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(User t) {
        String sql = "update user set name=?,username=?,password=?, email=?, address=?, gender=?, note=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setString(2, t.getUsername());
            ps.setString(3, t.getPassword());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getAddress());
            ps.setString(6, t.getGender());
            ps.setString(7, t.getNote());
            ps.setInt(8, t.getId());
            ps.executeUpdate();
            System.out.println("::::: Data Updated Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "update user set status=false where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("::::: User Disabled Successfully :::::");
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User get(int id) {
        User user = null;
        String sql = "select * from user where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"), rs.getString("address"), rs.getString("gender"), rs.getString("note"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    

    @Override
    public List<User> getList() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"), rs.getString("address"),
                        rs.getString("gender"), rs.getString("note"));
                users.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    @Override
    public void createTable() {
        String sql = "create table user(id int(5) primary key auto_increment,"
                + "name varchar(50) not null,"
                + "username varchar(50) not null,"
                + "password varchar(50) not null,"
                + "email varchar(50) not null,"
                + "address varchar(200) not null,"
                + "gender varchar(50) not null,"
                + "note varchar(500) not null)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            System.out.println("::::: Table Created :::::");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getListByCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getProductByIdAndCategory(String product_name, int cat_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getByProductId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByUserIdAndPassword(String userName, String password) {
        User user = null;
        String sql = "select * from user where username=? and password=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("username"),
                        rs.getString("password"),  rs.getString("email"), rs.getString("address"), rs.getString("gender"), rs.getString("note"));
            }

        } catch (SQLException ex) {
            user = null;
        }
        return user;
    }

}
