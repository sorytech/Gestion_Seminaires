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
import models.Animateur;
import models.Conferencier;

/**
 *
 * @author hpp
 */
public class EditerAll {

    private final Connexion conn;
    private final Connection getcon;
    private final ArrayList<Conferencier> listeConferencier;
    private final ArrayList<Animateur> listeAnimateur;
/**
 * 
 * @throws ParseException 
 */
    public EditerAll() throws ParseException {
        this.conn = new Connexion();
        this.getcon = conn.getConnection();
        this.listeConferencier = new ArrayList<>();
        this.listeAnimateur=new ArrayList<>();
    }
/**
 * 
 * @return
 * @throws SQLException 
 */
    public ArrayList<Conferencier> editerConferencier() throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from conferencier");
            while (rs.next()) {
                listeConferencier.add(new Conferencier(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
                stmt.close();
                getcon.close();
            return listeConferencier;
        }
    }
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList<Animateur> editerAnimateur() throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from animateur");
            while (rs.next()) {
                listeAnimateur.add(new Animateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
             stmt.close();
             getcon.close();
            return listeAnimateur;
        }
    }

}
