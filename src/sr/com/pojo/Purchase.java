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
public class Purchase {
    private int id;
    private Product product;
    
    private int quantity;
    private double unitPrice;
    private double sellPrice;
    private double totalPrice;
    private LocalDateTime purchaseDate;

    public Purchase() {
    }

    public Purchase(int id, Product product, int quantity, double unitPrice, double sellPrice, double totalPrice, LocalDateTime purchaseDate) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.sellPrice = sellPrice;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
    }

    public Purchase(Product product, int quantity, double unitPrice, double sellPrice, double totalPrice, LocalDateTime purchaseDate) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.sellPrice = sellPrice;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
    }

    public Purchase(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
    
    
    
}
