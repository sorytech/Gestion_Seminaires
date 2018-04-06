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
public class Conference {
    private int idConferencier;
    private int idSeminaire;
    private String titre;
    private String support;
    private double montantPrestation;
    private String activites;
   

    public Conference( int idConferencier, int idSeminaire,String titre, String support, double montantPrestation, String activites) {
        this.idConferencier = idConferencier;
        this.idSeminaire = idSeminaire;
        this.titre = titre;
        this.support = support;
        this.montantPrestation = montantPrestation;
        this.activites = activites;
        
    }

  

    public Conference() {
    }

    public int getIdConferencier() {
        return idConferencier;
    }

    public void setIdConferencier(int idConferencier) {
        this.idConferencier = idConferencier;
    }

    public int getIdSeminaire() {
        return idSeminaire;
    }

    public void setIdSeminaire(int idSeminaire) {
        this.idSeminaire = idSeminaire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public double getMontantPrestation() {
        return montantPrestation;
    }

    public void setMontantPrestation(double montantPrestation) {
        this.montantPrestation = montantPrestation;
    }

    public String getActivites() {
        return activites;
    }

    public void setActivites(String activites) {
        this.activites = activites;
    }
    
    
    
}
