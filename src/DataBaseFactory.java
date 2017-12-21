import java.sql.*;

public class DataBaseFactory {
    private final String ConnectionURL = "";
    private final String Username = "";
    private final String Password = "";
    Connection connection;

    public DataBaseFactory(){
        try {
            connection = DriverManager.getConnection(ConnectionURL);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
