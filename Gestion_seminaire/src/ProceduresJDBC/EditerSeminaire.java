/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProceduresJDBC;

import Connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author hpp
 */
public class EditerSeminaire {
    
    private final Connexion conn;
    private final Connection getcon;
    private final ArrayList<String> list;
    
    public EditerSeminaire() throws ParseException {
        this.conn=new Connexion();
        this.getcon=conn.getConnection();
        this.list=new ArrayList<>();
    }
    
    
    public  ArrayList<String>  EditeSemaire() throws SQLException {
        
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from seminaire");
            while(rs.next()){
                list.add(rs.getString(5)); 
            }
            stmt.close();
            getcon.close();
        }
        return list;
    }
    
}
