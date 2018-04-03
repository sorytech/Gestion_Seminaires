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
public class Conferencier {

    private int id;
    private int idAnim;
    private String nom;
    private String prenom;
    private String adresse;
    private int tel;
    private String email;

    public Conferencier(int id, int idAnim, String nom, String prenom, String adresse, int tel, String email) {
        this.id = id;
        this.idAnim = idAnim;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;

    }

    public int getIdAnim() {
        return idAnim;
    }

    public void setIdAnim(int idAnim) {
        this.idAnim = idAnim;
    }

    public Conferencier() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

}
