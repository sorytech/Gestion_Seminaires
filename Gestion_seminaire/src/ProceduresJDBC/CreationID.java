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

/**
 *
 * @author hpp
 */
public class CreationID {

    private final Connexion conn;
    private final Connection getcon;
/**
 * Il permet d'initialiser la connexion à la base de données
 * @param conn
 * @param getcon 
 */
    public CreationID(Connexion conn, Connection getcon) {
        this.conn = conn;
        this.getcon = getcon;
    }
/**
 * 
 * @param req
 * @return le nouveau identifiant generer à partir du dernier
 * @throws SQLException 
 */
    public int CreationId(String req) throws SQLException {
        int id_sem;
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery(req);
            rs.next();
            id_sem = rs.getInt(1);
            id_sem = id_sem + 1;
        }
        return id_sem;
    }

}
