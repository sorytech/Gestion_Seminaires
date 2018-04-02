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

    public Seminaire(int id, String theme, double tarif, int nombreMaxPlace,enum duree,Date date) {
        this.id = id;
        this.theme = theme;
        this.tarif = tarif;
        this.nombreMaxPlace = nombreMaxPlace;
        this.duree=duree;
        this.date = date;
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

  

    
    
    
    
}
