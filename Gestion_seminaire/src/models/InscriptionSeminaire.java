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
public class InscriptionSeminaire {
    private int idParticipant;
    private int idSeminaire;
    private Date date;
    private String etat ;

    public InscriptionSeminaire(int idParticipant, int idSeminaire,Date date,String etat) {
        this.idParticipant = idParticipant;
        this.idSeminaire = idSeminaire;
         this.date = date;
         this.etat=etat;
    }


    public InscriptionSeminaire() {
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public int getIdSeminaire() {
        return idSeminaire;
    }

    public void setIdSeminaire(int idSeminaire) {
        this.idSeminaire = idSeminaire;
    }

   
    
    
}
