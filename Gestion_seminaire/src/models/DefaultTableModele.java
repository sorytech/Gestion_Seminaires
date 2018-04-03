/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ProceduresJDBC.EditerAll;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hpp
 */
public class DefaultTableModele {

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
}
