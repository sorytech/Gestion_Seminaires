package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {

    private static final String configurationFile = "BD.properties";
    private static Connection conn;

    public Connection getConnection() throws ParseException {

        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);// Get a connection to the database
            conn = DriverManager.getConnection(dbUrl, username, password);
            SQLWarningsExceptions.printWarnings(conn);
            //conn.close() ;
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
