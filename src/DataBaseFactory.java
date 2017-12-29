import java.sql.*;
import java.util.List;
import java.util.ArrayList;
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
            //System.out.println(resultSet);
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

    public Object[][] getData(String table, boolean [] chosenParameters, String [] values, String linker){
        String query = "SELECT * FROM ";
        if(table.equals("osoby")){
            query += table + "osoby WHERE ";


            int dl = chosenParameters.length;
            boolean flag = false;
            for(int i = 0; i < dl ; i++)
            {
                if(chosenParameters[i] == true & flag == false)
                {
                    flag = true;
                    if(i==0)
                    {
                        query += "id_osoby = '" + values[i] + "'";
                    }else if(i == 1)
                    {
                        query += "id_lokalizacji = '" + values[i] + "'";
                    }else if(i == 2)
                    {
                        query += "imie = '" + values[i] + "'";
                    }else if(i == 3)
                    {
                        query += "nazwisko = '" + values[i] + "'";
                    }else if(i == 4)
                    {
                        query += "nr_tel = '" + values[i] + "'";
                    }else if(i == 5)
                    {
                        query += "adres = '" + values[i] + "'";
                    }else if(i == 6)
                    {
                        query += "mail = '" + values[i] + "'";
                    }else if(i == 7)
                    {
                        query += "login = '" + values[i] + "'";
                    }else if(i == 8)
                    {
                        query += "hasło = '" + values[i] + "'";
                    }
                }
                else if(chosenParameters[i] == true & flag == true)
                {
                    if(i==0)
                    {
                        query += linker + " id_osoby = '" + values[i] + "'";
                    }else if(i == 1)
                    {
                        query += linker + " id_lokalizacji = '" + values[i] + "'";
                    }else if(i == 2)
                    {
                        query += linker + " imie = '" + values[i] + "'";
                    }else if(i == 3)
                    {
                        query += linker + " nazwisko = '" + values[i] + "'";
                    }else if(i == 4)
                    {
                        query += linker + " nr_tel = '" + values[i] + "'";
                    }else if(i == 5)
                    {
                        query += linker + " adres = '" + values[i] + "'";
                    }else if(i == 6)
                    {
                        query += linker + " mail = '" + values[i] + "'";
                    }else if(i == 7)
                    {
                        query += linker + " login = '" + values[i] + "'";
                    }else if(i == 8)
                    {
                        query += linker + " hasło = '" + values[i] + "'";
                    }
                }
            }
            query +=";";


            //Object [][] data ;
            List list = new ArrayList();
            try{

                statement = conn.createStatement();
                resultSet = statement.executeQuery(query);
                //System.out.println(resultSet);
                while(resultSet.next()) {

                    Object [] tmp = new Object[9];
                    tmp[0] = resultSet.getString("id_osoby");
                    tmp[1] = resultSet.getString("id_lokalizacji");
                    tmp[2] = resultSet.getString("imie");
                    tmp[3] = resultSet.getString("nazwisko");
                    tmp[4] = resultSet.getString("nr_tel");
                    tmp[5] = resultSet.getString("adres");
                    tmp[6] = resultSet.getString("mail");
                    tmp[7] = resultSet.getString("login");
                    tmp[8] = resultSet.getString("hasło");
                    //*********************************************************
                    list.add(tmp);  // lista wierszy które trzeba by wstawić do JTable
                }                   //**********************************************************
            } catch (SQLException e)
            {
                e.printStackTrace();
            }



            Object [][] data = {{"dupa","dupa","dupa"},{"cycki","cycki","cycki"}};
            return data;

        }
        // funkcja tworząca odpowiednie query i ściągająca dane z bazy. Dane zwraca jako tablicę obiektów
        else if(table.equals("sprzet")){

            query += "osoby WHERE ";

                int dl = chosenParameters.length;
                boolean flag = false;
                    for(int i = 0; i < dl ; i++)
                    {
                        if(chosenParameters[i] == true & flag == false)
                        {
                            flag = true;
                            if(i==0)
                            {
                                query += "id_osoby = '" + values[i] + "'";
                            }else if(i == 1)
                            {
                                query += "id_lokalizacji = '" + values[i] + "'";
                            }else if(i == 2)
                            {
                                query += "imie = '" + values[i] + "'";
                            }else if(i == 3)
                            {
                                query += "nazwisko = '" + values[i] + "'";
                            }else if(i == 4)
                            {
                                query += "nr_tel = '" + values[i] + "'";
                            }else if(i == 5)
                            {
                                query += "adres = '" + values[i] + "'";
                            }else if(i == 6)
                            {
                                query += "mail = '" + values[i] + "'";
                            }else if(i == 7)
                            {
                                query += "login = '" + values[i] + "'";
                            }else if(i == 8)
                            {
                                query += "hasło = '" + values[i] + "'";
                            }
                        }
                        else if(chosenParameters[i] == true & flag == true)
                        {
                            if(i==0)
                            {
                                query += linker + " id_osoby = '" + values[i] + "'";
                            }else if(i == 1)
                            {
                                query += linker + " id_lokalizacji = '" + values[i] + "'";
                            }else if(i == 2)
                            {
                                query += linker + " imie = '" + values[i] + "'";
                            }else if(i == 3)
                            {
                                query += linker + " nazwisko = '" + values[i] + "'";
                            }else if(i == 4)
                            {
                                query += linker + " nr_tel = '" + values[i] + "'";
                            }else if(i == 5)
                            {
                                query += linker + " adres = '" + values[i] + "'";
                            }else if(i == 6)
                            {
                                query += linker + " mail = '" + values[i] + "'";
                            }else if(i == 7)
                            {
                                query += linker + " login = '" + values[i] + "'";
                            }else if(i == 8)
                            {
                                query += linker + " hasło = '" + values[i] + "'";
                            }
                        }
                    }
            query +=";";


            //Object [][] data ;
            List list = new ArrayList();
            try{

            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            //System.out.println(resultSet);
                while(resultSet.next()) {

                    Object [] tmp = new Object[9];
                    tmp[0] = resultSet.getString("id_osoby");
                    tmp[1] = resultSet.getString("id_lokalizacji");
                    tmp[2] = resultSet.getString("imie");
                    tmp[3] = resultSet.getString("nazwisko");
                    tmp[4] = resultSet.getString("nr_tel");
                    tmp[5] = resultSet.getString("adres");
                    tmp[6] = resultSet.getString("mail");
                    tmp[7] = resultSet.getString("login");
                    tmp[8] = resultSet.getString("hasło");
                                    //*********************************************************
                    list.add(tmp);  // lista wierszy które trzeba by wstawić do JTable
                }                   //**********************************************************
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            Object [][] data = {{},{}};
            return data;
        }else {

            Object [][] data = {{},{}};
            return data;
        }
    }

    public boolean removeData(String table, boolean [] chosenParameters, String [] values, String linker ){
        boolean success = false;
        String transaction = " DELETE FROM " + table;
        return success;
    }

    public boolean addData(String table, String[] dataToAdd){
        // funkcja dodająca wiersz wypełniony danymi z dataToAdd do tabeli table
        boolean success = false;
        return success;
    }
}
