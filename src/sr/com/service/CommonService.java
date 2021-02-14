/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.com.service;

import java.util.List;

/**
 *
 * @author User
 */
public interface CommonService<T> {

    void createTable();

    void save(T t);

    void update(T t);

    void delete(int id);

    T get(int id);
    
    T getByName(String name);

    List<T> getList();

    List<T> getListByCategory(int id);
    
    T getProductByIdAndCategory(String product_name, int cat_id);
    
    T getByProductId(int id);
    
    T getUserByUserIdAndPassword(String userName, String password);

}
