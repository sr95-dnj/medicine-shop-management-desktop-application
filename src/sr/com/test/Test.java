/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.com.test;

import java.sql.Connection;
import sr.com.connection.DbConnection;
import sr.com.service.CommonService;
import sr.com.serviceImpl.CategorServiceImpl;
import sr.com.serviceImpl.ProductServiceImpl;
import sr.com.serviceImpl.PurchaseServiceImpl;
import sr.com.serviceImpl.SalesServiceImpl;
import sr.com.serviceImpl.UserServiceImpl;

/**
 *
 * @author User
 */
public class Test {
    public static void main(String[] args) {
        Connection con=DbConnection.getInstance();
        
        CommonService inService=new UserServiceImpl();
        inService.createTable();
    }
    
}
