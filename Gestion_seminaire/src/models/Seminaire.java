/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;



/**
 *
 * @author hpp
 */
public class Seminaire {
    private int id;
    private String theme;
    private double tarif;
    private int nombreMaxPlace;
    private enum duree {MATIN, APRES_MIDI,JOURNEE};
    private Date date;
    private int idAnimateur;
    private int idPrestataire;
    private int idSalle;

    public Seminaire(int id, String theme, double tarif, int nombreMaxPlace, Date date, int idAnimateur, int idPrestataire, int idSalle) {
        this.id = id;
        this.theme = theme;
        this.tarif = tarif;
        this.nombreMaxPlace = nombreMaxPlace;
        this.date = date;
        this.idAnimateur = idAnimateur;
        this.idPrestataire = idPrestataire;
        this.idSalle = idSalle;
    }

    
    public Seminaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public int getNombreMaxPlace() {
        return nombreMaxPlace;
    }

    public void setNombreMaxPlace(int nombreMaxPlace) {
        this.nombreMaxPlace = nombreMaxPlace;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdAnimateur() {
        return idAnimateur;
    }

    public void setIdAnimateur(int idAnimateur) {
        this.idAnimateur = idAnimateur;
    }

    public int getIdPrestataire() {
        return idPrestataire;
    }

    public void setIdPrestataire(int idPrestataire) {
        this.idPrestataire = idPrestataire;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    
    
}
