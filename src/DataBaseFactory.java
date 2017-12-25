import java.sql.*;
import com.mysql.jdbc.Connection;

public class DataBaseFactory {

    private String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private String MYSQL_URL = "jdbc:mysql://localhost:3306/mydb";
    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;



    public DataBaseFactory(){
        try {
           // Class.forName(MYSQL_DRIVER);
            conn = (Connection)DriverManager.getConnection(MYSQL_URL,"root","admin");
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

    public boolean checkPassword(String loginn, String password){
        String  query = "SELECT hasło FROM osoby WHERE login LIKE " + loginn + ";";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println(resultSet);
            if(password.equals(resultSet.getString("hasło")))
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
