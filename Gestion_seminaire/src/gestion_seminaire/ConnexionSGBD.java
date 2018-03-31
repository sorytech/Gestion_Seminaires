package gestion_seminaire;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnexionSGBD {

    private static final String configurationFile
            = "BD.properties";

    public static void main(String args[]) {
        try {
            String jdbcDriver, dbUrl, username, password;

            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            System.out.println("  dbUrl " + dbUrl + "username" + username + "password" + password);
            // Load the database driver
            Class.forName(jdbcDriver);

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl,
                    username, password);
            System.out.println("%%%%%%%%%%%%%%%%%%%%%% CREATION ID %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            String req="select max(idpart) from participant";
            int CreationId = Requetes.CreationId(conn,req);
            System.out.println("L'ID est : "+CreationId);
          //Requetes.InscriptionSeminaire(conn,006,002);
            
            //Requetes.CreationConference(conn,007,001);
            Requetes.CreationConferencier(conn,001);
            //Spectacles_Requetes.afficherNomSpectacle(conn);
            
            // Print information about connection warnings
            SQLWarningsExceptions.printWarnings(conn);
            conn.close();
        } catch (SQLException se) {

            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);

            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
}
