/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JComboBox;

/**
 *
 * @author diallo1
 */
public class Requetes {

    public enum etat {

        confirme, attente, desister
    };
/**
 * 
 * @param conn
 * @param idSeminaire
 * @param idInscrip
 * @throws SQLException 
 */
    public static void InscriptionSeminaire(Connection conn, int idSeminaire,int idInscrip) throws SQLException {
      
        ResultSet rs = null;
        String str = "INSERT INTO inscription VALUES (?, ?, ?, ?)";
        // Get a statement from the connection
        PreparedStatement stmtV = conn.prepareStatement(str);
        stmtV.setInt(1, idInscrip);
        stmtV.setInt(2, idSeminaire);
        stmtV.setDate(3, java.sql.Date.valueOf("2018-05-08"));
        stmtV.setString(4, "confirme");
        rs = stmtV.executeQuery();
        stmtV.close();
        System.out.println("Insertion ok");

    }
/**
 * 
 * @param conn
 * @param idSeminaire
 * @param idConferencier
 * @throws SQLException 
 */
    public static void CreationConference(Connection conn, int idSeminaire, int idConferencier) throws SQLException {
        ResultSet rs = null;
        String str = "INSERT INTO conference VALUES (?, ?, ?, ?,?,?)";
        Scanner sc = new Scanner(System.in);
        System.out.println("THEME DE LA CONFERENCE");
        String theme=sc.nextLine();
        System.out.println("SUPPORT ");
        String file=sc.nextLine();
        System.out.println("Montant Prestation");
        double montant=sc.nextDouble();
        sc = new Scanner(System.in);
        System.out.println("LES ACTIVITÉS !");
        String activites=sc.nextLine();
       
        PreparedStatement stmtV = conn.prepareStatement(str);
        stmtV.setInt(1, idConferencier);
        stmtV.setInt(2, idSeminaire);
        stmtV.setString(3,theme);
        stmtV.setString(4, file);
        stmtV.setDouble(5, montant);
        stmtV.setString(6, activites);
        stmtV.execute();
        stmtV.close();
        System.out.println("Insertion ok");
    }
    /**
     * 
     * @param conn
     * @param idSeminaire
     * @param idConferencier
     * @throws SQLException 
     */
    public static void CreationConferencier(Connection conn,int idConferencier) throws SQLException {
         String req = "select max(idconf) from conferencier";
         int idC = CreationId(conn, req);
        ResultSet rs = null;
        String str = "INSERT INTO conference VALUES (?, ?, ?, ?,?,?,?)";
        Scanner sc = new Scanner(System.in);
        System.out.println("L'identifiant de l'animateur");
        int IdAn=sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("Le nom du conferencier ");
        String nom=sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Prenom");
        String prenom=sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Adresse");
        String adr=sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Telephone");
        int tel=sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("Email");
        String email=sc.nextLine();
       
        PreparedStatement stmtV = conn.prepareStatement(str);
        stmtV.setInt(1, idC);
        stmtV.setInt(2, IdAn);
        stmtV.setString(3,nom);
        stmtV.setString(4, prenom);
        stmtV.setString(5, adr);
        stmtV.setInt(6, tel);
        stmtV.setString(7, email);
        stmtV.execute();
        stmtV.close();
        System.out.println("Insertion ok");
    }

  /**
   * 
   * @param conn
   * @param req
   * @return
   * @throws SQLException 
   */
    public static int CreationId(Connection conn, String req) throws SQLException {

        int id_sem;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(req);
        rs.next();
        id_sem = rs.getInt(1);
        id_sem=id_sem+1;
        stmt.close();
        return id_sem;
    }
    public  void EditeSemaire(Connection conn, JComboBox combo) throws SQLException {
        
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from seminaire");
            combo.addItem("Selectionner un Seminaire");
            while(rs.next()){
                combo.addItem(rs.getString(5)); 
            }
        }
    }

}
