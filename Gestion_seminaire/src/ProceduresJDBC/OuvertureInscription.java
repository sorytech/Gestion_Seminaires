/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProceduresJDBC;

import Connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import static main.Requetes.InscriptionSeminaire;
import models.InscriptionSeminaire;
import models.Participant;

/**
 *
 * @author hpp
 */
public class OuvertureInscription {
    private final Connexion conn;
    private final Connection getcon;

    public OuvertureInscription() throws ParseException {
         this.conn =new Connexion();
        this.getcon =conn.getConnection();
    }
    
     /**
     * 
     * @param participant
     * @throws SQLException 
     */
    public int creerParticipant(Participant participant) throws SQLException{
        String req = "select idPart from Participant order by idPart desc ";
        CreationID gen=new CreationID(conn, getcon);
        int idPart = gen.CreationId(req);
        String str = "INSERT INTO Participant VALUES (?, ?, ?, ?,?,?)";
        PreparedStatement stm = getcon.prepareStatement(str);
        stm.setInt(1, idPart);
        stm.setString(2, participant.getNom());
        stm.setString(3, participant.getPrenom());
        stm.setString(4, participant.getAdresse());
        stm.setInt(5, participant.getTel());
        stm.setString(6, participant.getEmail());
        stm.executeUpdate();
        stm.close();
        getcon.commit();
        getcon.close();   
        return idPart;
    }
    /**
     * 
     * @param inscrip
     * @throws SQLException 
     */
     public void Inscription(InscriptionSeminaire inscrip) throws SQLException{
        String str = "INSERT INTO inscription VALUES (?, ?, ?, ?)";
        PreparedStatement stm = getcon.prepareStatement(str);
        stm.setInt(1, inscrip.getIdParticipant());
        stm.setInt(2, inscrip.getIdSeminaire());
        stm.setDate(3, new java.sql.Date(inscrip.getDate().getTime()));
        stm.setString(4, inscrip.getEtat());
        stm.executeUpdate();
        stm.close();
        getcon.commit();
        getcon.close();   
    }
    
    
    
}
