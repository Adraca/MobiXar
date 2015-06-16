package mobixar.puydufou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.lang.Exception;

public class DbConnection {
    String url = "jdbc:mysql://localhost/puydufou";
    String login = "root";
    String password = "";

    /*try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection dbConnection = DriverManager.getConnection(url, login, password);

        Statement state = dbConnection.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM activity");
        ResultSetMetaData resultMeta = result.getMetaData();
    }
    catch (Exception e) {
        e.printStackTrace();
    }*/
}
