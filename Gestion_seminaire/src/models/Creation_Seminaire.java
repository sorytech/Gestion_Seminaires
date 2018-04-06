package models;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Creation_Seminaire {

    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
    public static void creer_seminaire(Connection conn) throws SQLException {
        
        int id_sem=0, i = 0;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select max(idSem) from seminaire");

        while (rs.next()) {
            id_sem = rs.getInt(1) + 1;

        }
        System.out.println("new idsem "+id_sem);
        //----------------------Animateur----------------------
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ID_Anim = new ArrayList<>();
        rs = stmt.executeQuery("select idAnim from animateur");
        boolean if_exist = false;
        int id_anim = 0;
        while (rs.next()) {
            ID_Anim.add(rs.getInt(1));
        }
        while (if_exist == false) {
            System.out.println("Veuillez saisir un animateur:");
            id_anim= sc.nextInt();
            while ((i < ID_Anim.size()) && (if_exist == false)) {
                if (ID_Anim.get(i) == id_anim) {
                    if_exist = true;
                }
                i++;
            }
            i = 0;
        }
        //----------------------Prestataire----------------------
        ArrayList<Integer> ID_Prest = new ArrayList<>();
        rs = stmt.executeQuery("select idPrest from prestataire");
        if_exist = false;
        int id_prest = 0;
        while (rs.next()) {
            ID_Prest.add(rs.getInt(1));
        }
        while (if_exist == false) {
            System.out.println("Veuillez saisir un prestataire:");
            id_prest = sc.nextInt();
            i = 0;
            while ((i < ID_Prest.size()) && (if_exist == false)) {
                if (ID_Prest.get(i) == id_prest) {
                    if_exist = true;
                }
                i++;
            }
        }
        //--------------------Num Salle----------------------------
        ArrayList<Integer> ID_Salle = new ArrayList<>();
        rs = stmt.executeQuery("select numSalle from salle where idPrest = " + id_prest);
        if_exist = false;
        int id_salle = 0;
        while (rs.next()) {
            ID_Salle.add(rs.getInt(1));
        }
        while (if_exist == false) {
            System.out.println("Veuillez saisir le numero de la salle :");
            id_salle = sc.nextInt();
            i = 0;
            while ((i < ID_Salle.size()) && (if_exist == false)) {
                if (ID_Salle.get(i) == id_salle) {
                    if_exist = true;
                }
                i++;
            }
        }
        //------------------le theme -----------------
        sc = new Scanner(System.in);       
        System.out.println("Veuillez saisir le theme de seminaire:");
        String theme = sc.nextLine();       
        //-------------------------Le nombre de participant------------------
        System.out.println("Veuillez saisir le nombre maximum de partcipants ");
        int nbMaxPart = sc.nextInt();
        System.out.println("le nombre max d participants est de "+nbMaxPart);
        //-------------- Le tarif de seminaire ------------------------------
        System.out.println("Veuillez saisir le tarif de participation");
        double tarif = sc.nextDouble();                
        //--------------------Duree---------------------------------      
        String duree = sc.nextLine();
        while (!(duree.equals("JOURNEE") || duree.equals("MATIN") || duree.equals("APRES-MIDI"))) {
            System.out.println("Veuillez saisir la duree");
            duree = sc.nextLine();
        }        
        //-----------------la date de seminaire ------------------------
        System.out.println("Veuillez saisir la date de seminaire:");
        String dateSem = sc.nextLine();
        DateFormat df = new SimpleDateFormat("dd-MM-yy");
        Date d = null;
        try {
            d = df.parse(dateSem);
        } catch (ParseException e) {
            System.out.println("Impossible de parser "
                    + dateSem
                    + ". Veuillez entrer la date au format JJ-MM-AA");
            System.out.println("message"+e.getMessage());
        }
       /***************************************** a revoir ************************************/
        String requete="INSERT INTO seminaire VALUES('" + id_sem + "'"
                + ",'" + id_anim + "'" + "," + "'" + id_prest + "','" + id_salle
                + "'" + "," + "'" + theme + "'" + "," + "'" + nbMaxPart + "'" + "," + "'" + tarif + "',"
                + "'" + duree + "'" + "," + "TO_DATE('"+dateSem+"','dd/mm/yy'))";
        System.out.println(requete);
        try {
            stmt.executeUpdate(requete);
            System.out.println("Ajout réussi");
        }catch (Exception e) { 
            System.out.println("ERROR "+e.getMessage());
        }
        // calcul des dépenses et du bénéfice
        double depMin=0,depMax=0;
        if(duree.equals("JOURNEE")){
             String req="select tarifRepas,tarifPause from prestataire where "
                     + "idPrest = "+id_prest;
             rs=stmt.executeQuery(req);
             while(rs.next()){
                 depMin=(rs.getInt(1)+rs.getInt(2))*(nbMaxPart/2);
                 depMax=(rs.getInt(1)+rs.getInt(2))*(nbMaxPart);
             }
        }else{
            String req="select tarifPause from prestataire where "
                     + "idPrest = "+id_prest;
             rs=stmt.executeQuery(req);
             while(rs.next()){
                 depMin=rs.getInt(1)*(nbMaxPart/2);
                 depMax=rs.getInt(1)*(nbMaxPart);
             }
        }
        System.out.println("Les dépenses sont comprises entre  [ "
                +depMin+", "+depMax+" ]");
        double benefmin=(tarif*(nbMaxPart/2));
        double benefmax=tarif*nbMaxPart;
        System.out.println("Le bénéfice est compris entre  [ "
                +benefmin+", "+benefmax+" ]");        
        sc.close();
        rs.close();
        stmt.close();       
        System.out.println("***********************************************\n");       
    }
}
