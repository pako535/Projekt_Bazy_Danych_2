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
            query += "osoby WHERE ";
            int dl = chosenParameters.length;
            boolean flag = false;
            for(int i = 0; i < dl ; i++) {
                if(chosenParameters[i] == true & flag == false) {
                    flag = true;
                    if(i==0) {
                        query += "id_osoby = '" + values[i] + "'";
                    }
                    else if(i == 1) {
                        query += "id_lokalizacji = '" + values[i] + "'";
                    }
                    else if(i == 2) {
                        query += "imie = '" + values[i] + "'";
                    }
                    else if(i == 3) {
                        query += "nazwisko = '" + values[i] + "'";
                    }
                    else if(i == 4) {
                        query += "nr_tel = '" + values[i] + "'";
                    }
                    else if(i == 5) {
                        query += "adres = '" + values[i] + "'";
                    }
                    else if(i == 6) {
                        query += "mail = '" + values[i] + "'";
                    }
                    else if(i == 7) {
                        query += "login = '" + values[i] + "'";
                    }
                    else if(i == 8) {
                        query += "hasło = '" + values[i] + "'";
                    }
                }
                else if(chosenParameters[i] == true & flag == true) {
                    if(i==0) {
                        query += linker + " id_osoby = '" + values[i] + "'";
                    }
                    else if(i == 1) {
                        query += linker + " id_lokalizacji = '" + values[i] + "'";
                    }
                    else if(i == 2) {
                        query += linker + " imie = '" + values[i] + "'";
                    }
                    else if(i == 3) {
                        query += linker + " nazwisko = '" + values[i] + "'";
                    }
                    else if(i == 4) {
                        query += linker + " nr_tel = '" + values[i] + "'";
                    }
                    else if(i == 5) {
                        query += linker + " adres = '" + values[i] + "'";
                    }
                    else if(i == 6) {
                        query += linker + " mail = '" + values[i] + "'";
                    }
                    else if(i == 7) {
                        query += linker + " login = '" + values[i] + "'";
                    }
                    else if(i == 8) {
                        query += linker + " hasło = '" + values[i] + "'";
                    }
                }
            }
            query +=";";

            List<Object[]> list = new ArrayList<Object[]>();
            try{
                statement = conn.createStatement();
                resultSet = statement.executeQuery(query);
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
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            Object [][] data = new Object[list.size()][];
            for(int i = 0; i < list.size(); i++){
                data[i] = list.get(i);
            }
            return data;
        }
        else if(table.equals("sprzet")){
            query += "sprzet WHERE ";
                int dl = chosenParameters.length;
                boolean flag = false;
                    for(int i = 0; i < dl ; i++) {
                        if(chosenParameters[i] == true & flag == false) {
                            flag = true;
                            if(i==0) {
                                query += "id_sprzet = '" + values[i] + "'";
                            }
                            else if(i == 1) {
                                query += "typ = '" + values[i] + "'";
                            }
                            else if(i == 2) {
                                query += "marka = '" + values[i] + "'";
                            }
                            else if(i == 3) {
                                query += "parametry = '" + values[i] + "'";
                            }
                            else if(i == 4) {
                                query += "stan_sprzetu = '" + values[i] + "'";
                            }
                            else if(i == 5) {
                                query += "id_lokalizacji = '" + values[i] + "'";
                            }
                            else if(i == 6) {
                                query += "id_osoby = '" + values[i] + "'";
                            }
                            else if(i == 7) {
                                query += "model = '" + values[i] + "'";
                            }
                        }
                        else if(chosenParameters[i] == true & flag == true) {
                            if(i==0) {
                                query += linker + " id_sprzet = '" + values[i] + "'";
                            }
                            else if(i == 1) {
                                query += linker + " typ = '" + values[i] + "'";
                            }
                            else if(i == 2) {
                                query += linker + " marka = '" + values[i] + "'";
                            }
                            else if(i == 3) {
                                query += linker + " parametry = '" + values[i] + "'";
                            }
                            else if(i == 4) {
                                query += linker + " stan_sprzetu = '" + values[i] + "'";
                            }
                            else if(i == 5) {
                                query += linker + " id_lokalizacji = '" + values[i] + "'";
                            }
                            else if(i == 6) {
                                query += linker + " id_osoby = '" + values[i] + "'";
                            }
                            else if(i == 7) {
                                query += linker + " model = '" + values[i] + "'";
                            }
                        }
                    }
            query +=";";
            List<Object[]> list = new ArrayList<Object[]>();
            try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    Object [] tmp = new Object[8];
                    tmp[0] = resultSet.getString("id_sprzet");
                    tmp[1] = resultSet.getString("typ");
                    tmp[2] = resultSet.getString("marka");
                    tmp[3] = resultSet.getString("parametry");
                    tmp[4] = resultSet.getString("stan_sprzetu");
                    tmp[5] = resultSet.getString("id_lokalizacji");
                    tmp[6] = resultSet.getString("id_osoby");
                    tmp[7] = resultSet.getString("model");
                                    //*********************************************************
                    list.add(tmp);  // lista wierszy które trzeba by wstawić do JTable
                }                   //**********************************************************
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            Object [][] data = new Object[list.size()][];
            for(int i = 0; i < list.size(); i++){
                data[i] = list.get(i);
            }
            return data;
        }
        else {
            query += "lokalizacja WHERE ";
            int dl = chosenParameters.length;
            boolean flag = false;
            for(int i = 0; i < dl ; i++) {
                if(chosenParameters[i] == true & flag == false) {
                    flag = true;
                    if(i==0) {
                        query += "id_lokalizacja = '" + values[i] + "'";
                    }
                    else if(i == 1) {
                        query += "miasto = '" + values[i] + "'";
                    }
                    else if(i == 2) {
                        query += "kod_pocztowy = '" + values[i] + "'";
                    }
                }
                else if(chosenParameters[i] == true & flag == true) {
                    if(i==0) {
                        query += linker + " id_lokalizacja = '" + values[i] + "'";
                    }
                    else if(i == 1) {
                        query += linker + " miasto = '" + values[i] + "'";
                    }
                    else if(i == 2) {
                        query += linker + " kod_pocztowy = '" + values[i] + "'";
                    }
                }
            }
            query +=";";
            List<Object[]> list = new ArrayList<Object[]>();
            try{
                statement = conn.createStatement();
                resultSet = statement.executeQuery(query);
                //System.out.println(resultSet);
                while(resultSet.next()) {
                    Object [] tmp = new Object[3];
                    tmp[0] = resultSet.getString("id_lokalizacja");
                    tmp[1] = resultSet.getString("miasto");
                    tmp[2] = resultSet.getString("kod_pocztowy");
                    //*********************************************************
                    list.add(tmp);  // lista wierszy które trzeba by wstawić do JTable
                }                   //**********************************************************
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            Object [][] data = new Object[list.size()][];
            for(int i = 0; i < list.size(); i++){
                data[i] = list.get(i);
            }
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
        // INSERT INTO table_name (column1, column2, column3, ...)
        // VALUES (value1, value2, value3, ...);

        if(table.equals("osoby"))
        {
            String query = "INSERT INTO osoby (id_osoby, id_lokalizacji, imie, nazwisko, nr_tel, adres, mail, login, hasło) VALUES (";
            String []tmp = {"id_osoby", "id_lokalizacji", "imie", "nazwisko", "nr_tel", "adres", "mail", "login", "hasło"};


            for(int i = 0; i < dataToAdd.length; i++)
            {
                query += "'" + dataToAdd[i] + "', ";
            }
            query = query.substring(0,query.length() - 2);
            query += ");";


            try{

                statement = conn.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }


        }else if(table.equals("sprzet"))
        {
            // Narazie brak zabezpieczeń
            String query = "INSERT INTO sprzet (id_sprzet, typ, marka, parametry, stan_sprzetu, id_lokalizacji, id_osoby, model) VALUES (";
            String []tmp = {"id_sprzet", "typ", "marka", "parametry", "stan_sprzetu", "id_lokalizacji", "id_osoby", "model"};


            for(int i = 0; i < dataToAdd.length; i++)
            {
                query += "'" + dataToAdd[i] + "', ";
            }
            query = query.substring(0,query.length() - 2);
            query += ");";


            try{

                statement = conn.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        }else if(table.equals("lokalizacja"))
        {

        }

        boolean success = false;
        return success;
    }

    public String[] getViewsNames(){
        String query = "SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_TYPE LIKE 'VIEW' AND TABLE_SCHEMA LIKE 'mydb';";
        List<String> list = new ArrayList<String>();
        try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                list.add(resultSet.getString("TABLE_NAME"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String [] names = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            names[i] = list.get(i);
        }
        return names;
    }

    public String[] getViewColumnsNames(String view){
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + view + "';";
        List<String> list = new ArrayList<String>();
        try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                 list.add(resultSet.getString("COLUMN_NAME"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String [] columnsNames = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            columnsNames[i] = list.get(i);
        }
        return columnsNames;
    }

    public Object[][] getView(String view, int numberOFColumns){
        String query = "SELECT * FROM " + view + ";";
        List<Object[]> list = new ArrayList<Object[]>();
        try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                Object [] tmp = new Object[numberOFColumns];
                for(int i = 1; i <= numberOFColumns; i++){
                    tmp[i - 1] = resultSet.getString(i);
                }
                list.add(tmp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        Object [][] data = new Object[list.size()][numberOFColumns];
        for(int i = 0; i < list.size(); i++){
            data[i] = list.get(i);
        }
        return data;
    }
}
