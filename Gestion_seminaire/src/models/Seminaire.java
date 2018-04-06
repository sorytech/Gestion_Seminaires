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
    private int idAnimateur;
    private int idPrestataire;
    private int idSalle;
    private String theme;
    private int nombreMaxPlace;
    private double tarif;
    private String duree ;
    private Date date;

    public Seminaire(int id, int idAnimateur, int idPrestataire, int idSalle, String theme, int nombreMaxPlace, double tarif,String duree, Date date) {
        this.id = id;
        this.idAnimateur = idAnimateur;
        this.idPrestataire = idPrestataire;
        this.idSalle = idSalle;
        this.theme = theme;
        this.nombreMaxPlace = nombreMaxPlace;
        this.tarif = tarif;
        this.duree=duree;
        this.date = date;
    }

    public Seminaire() {
    }

    public int getId() {
        return id;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
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
