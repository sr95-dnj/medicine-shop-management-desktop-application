/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.com.pojo;

import static com.oracle.jrockit.jfr.ContentType.Bytes;

/**
 *
 * @author User
 */
public class Product {
    private int id;
    private String name;
    private String type;
    private Category category;
    

    public Product(int id, String name, String type, Category category) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        
    }

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }
    
    

    public Product(String name, String type, Category category) {
        this.name = name;
        this.type = type;
        this.category = category;
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }

    
    
    
}
