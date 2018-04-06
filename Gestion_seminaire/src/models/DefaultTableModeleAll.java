/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ProceduresJDBC.EditerAll;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hpp
 */
public class DefaultTableModeleAll {
/**
 * 
 * @return
 * @throws ParseException
 * @throws SQLException 
 */
    public DefaultTableModel tableModelConferencier() throws ParseException, SQLException {
        // Entête de colonne
        EditerAll conferencier = new EditerAll();
        String[] entetes = {"ID Conferencier", "ID Animateur", "Nom", "Prénom", "Adresse", "Téléphone", "E-mail"};
        // Tableau de données
        Object[][] data = null;
        // Créer le modèle
        DefaultTableModel modele = new DefaultTableModel(data, entetes);
        for (Conferencier conf : conferencier.editerConferencier()) {
            modele.addRow(new Object[]{conf.getId(), conf.getIdAnim(), conf.getNom(), conf.getPrenom(), conf.getAdresse(), conf.getTel(), conf.getEmail()});
        }
        return modele;
    }
    /**
     * 
     * @return
     * @throws ParseException
     * @throws SQLException 
     */
    public DefaultTableModel tableModelSeminaire() throws ParseException, SQLException {
        // Entête de colonne
        EditerAll seminaire = new EditerAll();
        String[] entetes = {"ID Seminaire", "ID Prestataire", "ID Animateur", "N°Salle", "Theme", "Nombre de Place", "Tarif Par Personne", "Date","Durée"};
        // Tableau de données
        Object[][] data = null;
        // Créer le modèle
        DefaultTableModel modele = new DefaultTableModel(data, entetes);
        for (Seminaire sem : seminaire.editerSeminaire()) {
            modele.addRow(new Object[]{sem.getId(), sem.getIdPrestataire(), sem.getIdAnimateur(), sem.getIdSalle(), sem.getTheme(), sem.getNombreMaxPlace(), sem.getTarif(),sem.getDate(),sem.getDuree()});
        }
        return modele;
    }
    /**
     * 
     * @return
     * @throws ParseException
     * @throws SQLException 
     */
    public DefaultTableModel tableModelPrestataire() throws ParseException, SQLException  {
      
            // Entête de colonne
        EditerAll prestab = new EditerAll();
        String[] entetes = { "ID Prestataire", " Nom ", " Adresse ", " Téléphone ", " E-mail ", " Tarif Repas ", " Tarif Pause "};
        // Tableau de données
        Object[][] data = null;
        // Créer le modèle
        DefaultTableModel modele = new DefaultTableModel(data, entetes);
        for (Prestataire p: prestab.editerPrestataire()) {
            modele.addRow(new Object[]{p.getId(), p.getNom(), p.getAdresse(), p.getTel(), p.getEmail(), p.getTarifRepas(), p.getTarifPause()});
        }
        return modele;
    }
    /**
     * 
     * @return
     * @throws ParseException
     * @throws SQLException 
     */
    public DefaultTableModel tableModelConference() throws ParseException, SQLException  {   
            // Entête de colonne
        EditerAll prestab = new EditerAll();
        String[] entetes = { "ID Conference", " ID Seminaire ", " Titre Coference ", " Supports ", " Montant Prestation ", " Activités "};
        // Tableau de données
        Object[][] data = null;
        // Créer le modèle
        DefaultTableModel modele = new DefaultTableModel(data, entetes);
        for (Conference confer: prestab.editerConference()) {
            modele.addRow(new Object[]{confer.getIdConferencier(), confer.getIdSeminaire(), confer.getTitre(), confer.getSupport(), confer.getMontantPrestation(), confer.getActivites()});
        }
        return modele;
    }
}
