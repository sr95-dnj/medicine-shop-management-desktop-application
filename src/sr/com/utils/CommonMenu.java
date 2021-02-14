package sr.com.utils;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import sr.com.view.CategoryDeleteView;
import sr.com.view.CategoryUpdateView;
import sr.com.view.PurchaseView;
import sr.com.view.Login;
import sr.com.view.SalesView;
import sr.com.view.CategoryView;
import sr.com.view.DashBoard;
import sr.com.view.Login;

import sr.com.view.ProductView;
import sr.com.view.SalesReport;
import sr.com.view.SalesView;
import sr.com.view.UserListView;
import sr.com.view.UserView;

public class CommonMenu {
    
    public void getCommonMenu(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu category = new JMenu("Category");
        JMenuItem cat = new JMenuItem("Add Category");
        cat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new CategoryView().setVisible(true);
            }
        });
        
        JMenuItem delete = new JMenuItem("Delete Category");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new CategoryDeleteView().setVisible(true);
            }
        });
        JMenuItem update = new JMenuItem("Update Category");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new CategoryUpdateView().setVisible(true);
            }
        });
        
        JMenuItem close = new JMenuItem("Back to Home");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new DashBoard().setVisible(true);
            }
        });
        
        
        JMenu product=new JMenu("Product");
        JMenuItem pro = new JMenuItem("Add Product");
        pro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new ProductView().setVisible(true);
            }
        });
        JMenuItem pClose = new JMenuItem("Back to Home");
        pClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new DashBoard().setVisible(true);
            }
        });
        
        
        JMenu purchase=new JMenu("Purchase");
        JMenuItem purch = new JMenuItem("Purchase Product");
        purch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
              new PurchaseView().setVisible(true);
            }
        });
        JMenuItem closePurchase = new JMenuItem("Back to Home");
        closePurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new DashBoard().setVisible(true);
            }
        });
        
        JMenu sales=new JMenu("Sales");
        JMenuItem sale = new JMenuItem("Sales Product");
        sale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
              new SalesView().setVisible(true);
            }
        });
        JMenuItem salesReport = new JMenuItem("Sales Report");
        salesReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new SalesReport().setVisible(true);
            }
        });
        JMenuItem closeSale = new JMenuItem("Back to Home ");
        closeSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new DashBoard().setVisible(true);
            }
        });
        
         JMenu user=new JMenu("User Option");
        JMenuItem users = new JMenuItem("Add New User");
        users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
              new UserView().setVisible(true);
            }
        });
        
        JMenuItem userList = new JMenuItem("User List");
        userList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
              new UserListView().setVisible(true);
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
        category.add(update);
        category.add(delete);
        category.add(close);
        menuBar.add(category);
        
        product.add(pro);
        product.add(pClose);
        menuBar.add(product);
        
        purchase.add(purch);
        purchase.add(closePurchase);
        menuBar.add(purchase);
        sales.add(sale);
        sales.add(salesReport);
        sales.add(closeSale);
        menuBar.add(sales);
        
        user.add(users);
        user.add(userList);
        menuBar.add(user);
        
        logout.add(log);
        logout.add(exit);
        
        
        menuBar.add(logout);
        f.setJMenuBar(menuBar);
    }
}
