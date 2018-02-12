package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseConn {

    private  Connection conn;

    public  Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/TicTac?user=postgres&password=ruslan");
        } catch (SQLException ex) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  conn;
    }
}