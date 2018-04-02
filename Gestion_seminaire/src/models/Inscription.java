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
public class Inscription {
    private Date date;
    private enum etat {confirme,attente,desister}

    public Inscription(Date date, enum etat) {
        this.date = date;
        this.etat=etat;
    }

    public Inscription() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
