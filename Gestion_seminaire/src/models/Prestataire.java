/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hpp
 */
public class Prestataire {
    private int id;
    private String nom;
    private String adresse;
    private int tel;
    private String email;
    private double tarifRepas;
    private double tarifPause;

    public Prestataire(int id, String nom, String adresse, int tel, String email, double tarifRepas, double tarifPause) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.tarifRepas = tarifRepas;
        this.tarifPause = tarifPause;
    }

    public Prestataire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTarifRepas() {
        return tarifRepas;
    }

    public void setTarifRepas(double tarifRepas) {
        this.tarifRepas = tarifRepas;
    }

    public double getTarifPause() {
        return tarifPause;
    }

    public void setTarifPause(double tarifPause) {
        this.tarifPause = tarifPause;
    }
    
    
}
