import java.sql.*;
import com.mysql.jdbc.Connection;

public class DataBaseFactory {

    Connection conn = null ;

    public DataBaseFactory(){
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306","root","admin");
           // Class.forName("com.mysql.jdbc.Driver");
            if (conn != null)
            {
                System.out.println("Connected succesfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // } catch (ClassNotFoundException e) {
       //     e.printStackTrace();
       // }

    }

    public boolean checkPassword(String login, String password){
        String  query = "SELECT hasło FROM osoby WHERE login LIKE '" + login + "';";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(password.equals(resultSet.getString("hasło"))) return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
