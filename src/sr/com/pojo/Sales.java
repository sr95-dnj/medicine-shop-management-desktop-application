/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.com.pojo;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class Sales {
    private int id;
    private Product product;
    private String customerName;
    private String medicineName;
    private String mobile;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private LocalDateTime salesDate;

    public Sales() {
    }

    public Sales(int id) {
        this.id = id;
    }

    public Sales(String medicineName, int quantity, double unitPrice, double totalPrice) {
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public Sales(int id, String customerName, String mobile, double totalPrice, LocalDateTime salesDate) {
        this.id = id;
        this.customerName = customerName;
        this.mobile = mobile;
        this.totalPrice = totalPrice;
        this.salesDate = salesDate;
    }
    
    

    public Sales(Product product, int quantity, double unitPrice, double totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }
    
    

    public Sales(int id, Product product, String customerName, String mobile, int quantity, double unitPrice, double totalPrice, LocalDateTime salesDate) {
        this.id = id;
        this.product = product;
        this.customerName = customerName;
        this.mobile = mobile;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.salesDate = salesDate;
    }

    public Sales(Product product, String customerName, String mobile, int quantity, double unitPrice, double totalPrice, LocalDateTime salesDate) {
        this.product = product;
        this.customerName = customerName;
        this.mobile = mobile;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.salesDate = salesDate;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getSalesDate() {
        return salesDate;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public Sales(String customerName, String mobile, double totalPrice, LocalDateTime salesDate) {
        this.customerName = customerName;
        this.mobile = mobile;
        this.totalPrice = totalPrice;
        this.salesDate = salesDate;
    }
    
    
    
    
}
