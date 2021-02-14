package sr.com.utils;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import sr.com.view.PurchaseView;
import sr.com.view.Login;
import sr.com.view.SalesView;
import sr.com.view.CategoryView;
import sr.com.view.DashBoard;
import sr.com.view.Login;

import sr.com.view.ProductView;
import sr.com.view.SalesReport;
import sr.com.view.SalesReport1;
import sr.com.view.SalesView;
import sr.com.view.SalesView1;
import sr.com.view.UserDashBoard;

public class UserMenu {
    
    public void getCommonMenu(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu category = new JMenu("Sales");
        JMenuItem cat = new JMenuItem("Sales");
        cat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new SalesView1().setVisible(true);
            }
        });
        JMenuItem close = new JMenuItem("Back to Home");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new UserDashBoard().setVisible(true);
            }
        });
        
        
        JMenu product=new JMenu("Report");
        JMenuItem pro = new JMenuItem("Sales Report");
        pro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new SalesReport1().setVisible(true);
            }
        });
        JMenuItem pClose = new JMenuItem("Back to Home");
        pClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new UserDashBoard().setVisible(true);
            }
        });
        
        
       
        
        JMenu logout=new JMenu("Log Out");
        JMenuItem log = new JMenuItem("Log Out");
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
              new Login().setVisible(true);
            }
        });
        
        JMenuItem exit = new JMenuItem("Close");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
            }
        });
        category.add(cat);
        category.add(close);
        menuBar.add(category);
        
        product.add(pro);
        product.add(pClose);
        menuBar.add(product);
        
       
        
        logout.add(log);
        logout.add(exit);
        
        
        menuBar.add(logout);
        f.setJMenuBar(menuBar);
    }
}
