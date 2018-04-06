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
import models.Conference;
import models.Conferencier;
import models.Participant;
import models.Prestataire;
import models.Salle;
import models.Seminaire;

/**
 *
 * @author hpp
 */
public class EditerAll {

    private final Connexion conn;
    private final Connection getcon;
    private final ArrayList<Conferencier> listeConferencier;
    private final ArrayList<Animateur> listeAnimateur;
    private final ArrayList<Participant> listeParticipant;
    private final ArrayList<Prestataire> listePrestataire;
    private final ArrayList<Seminaire> listeSeminaire;
    private final ArrayList<Conference> listeConference;
    private final ArrayList<Salle> listeSalle;
    private final double[] listeTarifPrestataire;

    /**
     *
     * @throws ParseException
     */
    public EditerAll() throws ParseException {
        this.conn = new Connexion();
        this.getcon = conn.getConnection();
        this.listeConferencier = new ArrayList<>();
        this.listeAnimateur = new ArrayList<>();
        this.listeParticipant = new ArrayList<>();
        this.listePrestataire = new ArrayList<>();
        this.listeSeminaire = new ArrayList<>();
        this.listeConference=new ArrayList<>();
        this.listeSalle = new ArrayList<>();
        this.listeTarifPrestataire = new double[2];
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Conferencier> editerConferencier() throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from conferencier order by idconf asc");
            while (rs.next()) {
                listeConferencier.add(new Conferencier(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
            }
            stmt.close();
            //getcon.close();
            return listeConferencier;
        }
    }
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList<Conference> editerConference() throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from conference order by idconf,idsem asc ");
            while (rs.next()) {
                listeConference.add(new Conference(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6)));
            }
            stmt.close();
            // getcon.close();
            return listeConference;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Animateur> editerAnimateur() throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from animateur order by idAnim asc ");
            while (rs.next()) {
                listeAnimateur.add(new Animateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            stmt.close();
            // getcon.close();
            return listeAnimateur;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Participant> editerParticipant() throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from participant order idPart by asc ");
            while (rs.next()) {
                listeParticipant.add(new Participant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            stmt.close();
            // getcon.close();
            return listeParticipant;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Prestataire> editerPrestataire() throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from prestataire order by idPrest asc ");
            while (rs.next()) {
                listePrestataire.add(new Prestataire(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
            stmt.close();
            //getcon.close();
            return listePrestataire;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Seminaire> editerSeminaire() throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from seminaire order by idSem asc ");
            while (rs.next()) {
                listeSeminaire.add(new Seminaire(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getDate(9)));
            }
            stmt.close();
            //getcon.close();
            return listeSeminaire;
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<Salle> editerSalle(int id) throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from salle where idPrest=" + id + " order by numSalle asc ");
            while (rs.next()) {
                listeSalle.add(new Salle(rs.getInt(1), rs.getDouble(2), rs.getInt(3)));
            }
            stmt.close();
            //getcon.close();
            return listeSalle;
        }
    }
/**
 * 
 * @param id
 * @return
 * @throws SQLException 
 */
    public double[] editerTarifPrestataire(int id) throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select tarifRepas,tarifPause from prestataire where idPrest=" + id);
            rs.next();
            listeTarifPrestataire[0] = rs.getDouble(1);
            listeTarifPrestataire[1] = rs.getDouble(2);
            stmt.close();
            //getcon.close();
            return listeTarifPrestataire;
        }
    }
     public int nbrPlaceMaxSeminaire(int idsem) throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select nbMaxPart from seminaire where idSem=" + idsem);
            rs.next();
            int nbplace = rs.getInt("nbMaxPart");
            stmt.close();
            //getcon.close();
            return nbplace;
        }
    }
     public int nbrPlaceMaxReserverSeminaire(int idsem) throws SQLException {
        try (Statement stmt = getcon.createStatement()) {
            ResultSet rs = stmt.executeQuery("select count(*) from inscription where idSem=" + idsem);
            rs.next();
            int nbplace = rs.getInt(1);
            stmt.close();
            //getcon.close();
            return nbplace;
        }
    }
}
