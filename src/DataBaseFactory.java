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
            conn = (Connection)DriverManager.getConnection(MYSQL_URL,"root","admin");
            if (conn != null)
            {
                System.out.println("Connected succesfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPassword(String login, String password){
        String  query = "SELECT hasło FROM osoby WHERE login = '" + login + "';";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println(resultSet);
            if(resultSet.next()) {
                String result = resultSet.getString("hasło");
                if (password.equals(result))
                    return true;
            }return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(login.equals(password)) return true;
        return false;
    }

    public Object[][] getData(String table, boolean [] chosenParameters, String [] values){
        // funkcja tworząca odpowiednie query i ściągająca dane z bazy. Dane zwraca jako tablicę obiektów
        String query = "SELECT * FROM ";
        if(table.equals("lokalizacja")){
            query += table + " WHERE ";

        }
        if(table.equals("osoby")){
            Object [][] data = {{"dupa", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki"},
                    {"dupa", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki"}};
            return data;
        }else if(table.equals("sprzet")){
            Object [][] data = {{"dupa", "dupa", "cycki", "dupa", "cycki", "dupa", "cycki", "cycki"},
                    {"dupa", "dupa", "cycki", "dupa", "cycki", "dupa", "dupa", "cycki"}};
            return data;
        }else{
            Object [][] data = {{"dupa","dupa","dupa"},{"cycki","cycki","cycki"}};
            return data;
        }
    }

    public boolean removeData(String table, int id){
        // funkcja usuwająca wiersz o danym id z tabeli table
        boolean success = false;
        return success;
    }

    public boolean addData(String table, String[] dataToAdd){
        // funkcja dodająca wiersz wypełniony danymi z dataToAdd do tabeli table
        boolean success = false;
        return success;
    }
}
