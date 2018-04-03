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
public class Salle {
    private int numero;
    private double tarif;
    private int idPrestataire;

    public Salle() {
       
    }

    public Salle(int numero, double tarif, int idPrestataire) {
        this.numero = numero;
        this.tarif = tarif;
        this.idPrestataire = idPrestataire;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public int getIdPrestataire() {
        return idPrestataire;
    }

    public void setIdPrestataire(int idPrestataire) {
        this.idPrestataire = idPrestataire;
    }
    
    
    
}
