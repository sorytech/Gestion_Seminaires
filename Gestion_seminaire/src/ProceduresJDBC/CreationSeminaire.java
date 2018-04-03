/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProceduresJDBC;

import Connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import static main.Requetes.CreationId;
import models.Animateur;
import models.Conferencier;

/**
 *
 * @author hpp
 */
public class CreationSeminaire {
    private final Connexion conn;
    private final Connection getcon;
/**
 * 
 * @param conn
 * @param getcon 
 */
    public CreationSeminaire() throws ParseException {
        this.conn =new Connexion();
        this.getcon =conn.getConnection();
    }
    /**
     * 
     * @param anim
     * @throws SQLException 
     */
    public void creerAnimateur(Animateur anim) throws SQLException{
        String req = "select idAnim from animateur order by idAnim desc ";
        CreationID gen=new CreationID(conn, getcon);
        int idAnim = gen.CreationId(req);
        String str = "INSERT INTO animateur VALUES (?, ?, ?, ?,?,?)";
        PreparedStatement stm = getcon.prepareStatement(str);
        stm.setInt(1, idAnim);
        stm.setString(2, anim.getNom());
        stm.setString(3, anim.getPrenom());
        stm.setString(4, anim.getAdresse());
        stm.setInt(5, anim.getTel());
        stm.setString(6,anim.getEmail() );
        stm.executeUpdate();
        stm.close();
        getcon.commit();
        getcon.close();   
    }
    /**
     * 
     * @param anim
     * @throws SQLException 
     */
    public void creerConferencier(Conferencier conf) throws SQLException{
        String req = "select idConf from conferencier order by idConf desc ";
        CreationID gen=new CreationID(conn, getcon);
        int idConf = gen.CreationId(req);
        String str = "INSERT INTO conferencier VALUES (?, ?, ?, ?,?,?,?)";
        PreparedStatement stm = getcon.prepareStatement(str);
        stm.setInt(1, idConf);
        stm.setInt(2, conf.getIdAnim());
        stm.setString(3, conf.getNom());
        stm.setString(4, conf.getPrenom());
        stm.setString(5, conf.getAdresse());
        stm.setInt(6, conf.getTel());
        stm.setString(7,conf.getEmail() );
        stm.executeUpdate();
        stm.close();
        getcon.commit();
        getcon.close();   
    }
    
    
    
}
