/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.com.pojo;

/**
 *
 * @author User
 */
public class Category {
    private int id;
    private String name;
    private String code;
    private String note;

    public Category() {
    }

    public Category(int id) {
        this.id = id;
    }
    

    public Category(int id, String name, String code, String note) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.note = note;
    }

    public Category(String name, String code, String note) {
        this.name = name;
        this.code = code;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getNote() {
        return note;
    }
    
    
    
}
