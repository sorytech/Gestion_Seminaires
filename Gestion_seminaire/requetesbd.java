
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in
 Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author catherineberrut
 */
public class requetesbd {

    /**
     * Afficher toutes les informations sur tous les spectacles.
     *     
* @param conn connexion � la base de donn�es
     * @throws SQLException en cas d'erreur d'acc�s � la base de donn�es
     */
    public static void nbemp(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT count(*)FROM EMP ");
        while (rs.next()) {
            System.out.println("Nombre d'employes : " + rs.getInt(1));
        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
    }

    public static void employes(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
        while (rs.next()) {
            System.out.print("empno : " + rs.getInt(1) + " ");
            System.out.print("nom : " + rs.getString(2) + "");
            System.out.println("job : " + rs.getString(3));
        }
        // Close the result set, statement and the  connection 
        rs.close();
        stmt.close();
    }

    public static void infoEmployes(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT ename,sal, nvl(comm,0) FROM emp");
        while (rs.next()) {
            System.out.print("Nom empoyé : " + rs.getString(1) + " ");
            System.out.print("Salaire : " + rs.getDouble(2) + "");
            System.out.println("Commission : " + rs.getDouble(3));
        }
        // Close the result set, statement and the  connection 
        rs.close();
        stmt.close();
    }

    public static void superieurHierarchique(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("select subord.ename EMPLOYE, nvl(chef.ename, 'BIG BOSS') CHEF from emp subord left outer join emp chef on subord.mgr=chef.empno order by subord.ename ");
        while (rs.next()) {
            System.out.print("Nom empoyé : " + rs.getString(1) + " ");
            System.out.println("Nom supérieur Hierarchique : " + rs.getString(2) + "");

        }
        // Close the result set, statement and the  connection 
        rs.close();
        stmt.close();
    }

    public static void sommeRevenuParDepartement(Connection conn) throws
            SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("select deptno DEPARTEMENT, sum(sal + nvl(comm,0)) SOMMEREVENU\n"
                + "from emp\n"
                + "group by deptno");
        while (rs.next()) {
            System.out.print("Departement: " + rs.getInt(1) + " ");
            System.out.println("Somme revenu : " + rs.getDouble(2) + "");

        }
        // Close the result set, statement and the  connection 
        rs.close();
        stmt.close();
    }
    
}
