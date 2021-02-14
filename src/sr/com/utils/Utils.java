/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;
import sr.com.pojo.Sales;

/**
 *
 * @author User
 */
public class Utils {
    public static void writeFile(String filename, Sales s){
        File dFile = new File(filename + ".txt");
        try{
            if(dFile.exists() == false){
                System.out.println("We had a new file");
                dFile.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(dFile, true));
            out.append(s.getMedicineName()+ ", " + s.getUnitPrice()+ ", " + s.getQuantity()+ ", " + s.getTotalPrice()+"\n");
            out.close();
                    }
        catch(Exception e){
            System.out.println("Could not log");
        }
    }
    public static void readFile(String filename, DefaultTableModel model){
        String line;
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(filename + ".txt"));
            while((line = reader.readLine()) != null){
                model.addRow(line.split(", "));
            }
            reader.close();
            
        }
        catch(Exception e){
            System.out.println("Buffered issued");
        }
    }
    
}
