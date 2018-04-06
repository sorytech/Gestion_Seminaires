/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author dian
 */
public class Inscription_Seminair {

    @SuppressWarnings("UseSpecificCatch")
    public static void ajouterInscription(Connection conn) throws SQLException {
        @SuppressWarnings("UnusedAssignment")
        int id_part = 0;
        int numTel = 0, confirmation = 0;
        String nom = "", prenom = "", adr = "", email = "";
        Scanner sc = new Scanner(System.in);
        Statement stmt = conn.createStatement();

        ArrayList<Integer> ID_Part = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("select idPart from participant");
        while (rs.next()) {
            ID_Part.add(rs.getInt(1));
        }
        System.out.println("Bonjour, veuillez saisir un ID pour le participant");
        id_part = sc.nextInt();
        if (!(ID_Part.contains(id_part))) {
            System.out.println("Cet ID n'hexiste pas encore, si vous souhaitez "
                    + "vous inscrire avec cet ID tapez 1 pour annuler tapez 0");
            confirmation = sc.nextInt();
            while (confirmation != 0 && confirmation != 1) {
                System.out.println("Si vous souhaitez vous inscrire avec cet ID "
                        + "tapez 1 pour annuler tapez 0");
                confirmation = sc.nextInt();
            }
            if (confirmation == 0) {
                exit();
            } else {
                System.out.println("Veuillez saisir votre nom");
                sc = new Scanner(System.in);
                nom = sc.nextLine();
                System.out.println("Saisissez votre prénom");
                sc = new Scanner(System.in);
                prenom = sc.nextLine();
                System.out.println("Saisissez votre adresse");
                sc = new Scanner(System.in);
                adr = sc.nextLine();
                System.out.println("Saisissez votre email");
                sc = new Scanner(System.in);
                email = sc.nextLine();

                sc = new Scanner(System.in);
                System.out.println("Saisissez votre numéro de téléphone");
                numTel = sc.nextInt();
                // une variable length pour avoir la longueur du numero
                int length = (int) (Math.log10(numTel) + 2);
                System.out.println("la longueur du numTel est : " + length);
                while (length != 10) {
                    System.out.println("Saisissez un numéro valide XXXXXXXXXX");
                    numTel = sc.nextInt();
                    length = (int) (Math.log10(numTel) + 2);
                }
            }
        }
        /**
         * ****************Saisie du séminaire ********************
         */
        ArrayList<Integer> ID_Sem = new ArrayList<>();
        rs = stmt.executeQuery("select idSem from seminaire");
        boolean if_exist = false;
        int id_sem = 0;
        while (rs.next()) {
            ID_Sem.add(rs.getInt(1));
        }
        while (if_exist == false) {
            System.out.println("Veuillez saisir un seminaire : ");
            id_sem = sc.nextInt();
            if (ID_Sem.contains(id_sem)) {
                if_exist = true;
            }
        }
        /*on doit faire l'ajout du participant dans la table séminaire 
        avant de le faire dans inscription si l'utilisateur saisit un nouvel
        identifiant parce que inscription(idPart) est inclus dans 
        participant(idPart)
         */
        if ((!ID_Part.contains(id_part)) && (confirmation == 1)) {
            String req1 = "INSERT INTO participant VALUES('" + id_part + "','"
                    + nom + "','" + prenom + "','" + adr + "','" + numTel
                    + "','" + email + "')";
            System.out.println(req1);
            try {
                stmt.executeUpdate(req1);

            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
            System.out.println("Ajout réussi dans la table participant");
        }

        /*
        ajouter le participant dans la table inscription avec un etat confirme
        parce que la liste d'attente est gérée par le trigger. Avant d'inserer 
        un n-uplet, si le nbreMax est atteint, et qu'on est à plus d'une semaine
        du séminaire, le participant est placé en attente
         */
        String req2 = "INSERT INTO inscription VALUES('" + id_part + "','"
                + id_sem + "',sysdate,'attente')";
        System.out.println(req2);
        try {
            stmt.executeUpdate(req2);
            System.out.println("Ajout réussi dans la table inscription");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }

        sc.close();
        rs.close();
        stmt.close();

    }

    @SuppressWarnings({"UseSpecificCatch", "ConvertToTryWithResources", "UnusedAssignment"})
    public static void supprimerInscription(Connection conn)
            throws SQLException {

        Scanner sc = new Scanner(System.in);
        Statement stmt = conn.createStatement();
        ArrayList<Integer> ID_Part = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("select idPart from inscription");
        boolean if_exist = false;
        int id_part = 0;
        while (rs.next()) {
            ID_Part.add(rs.getInt(1));
        }
        while (if_exist == false) {
            System.out.println("Veuillez saisir un participant : ");
            id_part = sc.nextInt();
            if (ID_Part.contains(id_part)) {
                if_exist = true;
            }
        }
        /**
         * Saisie du séminaire pour lequel on veut supprimer le participant*
         */
        ArrayList<Integer> ID_Sem = new ArrayList<>();
        String req1 = "select idSem from inscription where idPart = " + id_part;
        rs = stmt.executeQuery(req1);
        if_exist = false;
        int id_sem = 0;
        while (rs.next()) {
            ID_Sem.add(rs.getInt(1));
        }
        while (if_exist == false) {
            System.out.println("Veuillez saisir un numero du seminaire :");
            id_sem = sc.nextInt();
            if (ID_Sem.contains(id_sem)) {
                if_exist = true;
            }
        }
        String req = "select etat from inscription where idPart=" + id_part
                + " and idSem = " + id_sem;
        String etat = "";
        rs = stmt.executeQuery(req);
        while (rs.next()) {
            etat = rs.getString(1);
        }

        String req2 = "delete from inscription where idPart="
                + id_part + " and idSem=" + id_sem;
        System.out.println(req2);
        try {
            stmt.executeUpdate(req2);
            System.out.println("Suppression réussie");
            conn.commit();
            /*
            quand on supprime un n-uplet dans la table inscription, on doit
            confirmer une réservation pour le même séminaire. la réservation qui
            doit être confirmée doit être la ancienne.
             */
            String req3 = "SELECT idPart,dateIns from inscription where idSem="
                    + id_sem + " and etat ='attente' and dateIns=("
                    + "select min(dateIns) from Inscription where idSem=" + id_sem
                    + " and etat='attente')";
            rs = stmt.executeQuery(req3);

            while (rs.next()) {
                id_part = rs.getInt(1);
            }
            if (etat.equals("confirme")) {
                String req4 = "UPDATE inscription SET etat = 'confirme' where idPart="
                        + id_part + " and idSem = " + id_sem;
                System.out.println(req4);
                stmt.executeUpdate(req4);
                System.out.println("Réservation confirmée pour le participant "+id_part+" au séminaire "+id_sem);
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }

        sc.close();
        rs.close();
        stmt.close();

    }

}
///SELECT idPart,idSem,dateIns from inscription where idSem=1 and etat ='attente' and dateIns=(select min(dateIns) from Inscription where idSem=1 and etat='attente'); 

