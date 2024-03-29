import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.StringUtils;

import javax.swing.*;


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
            if(resultSet.next()) {
                String result = resultSet.getString("hasło");
                if (password.equals(result))
                    return true;
            }return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object[][] getData(String table, boolean [] chosenParameters, String [] values, String linker){
        String query = "SELECT * FROM ";

        boolean flagg = false;
        for(int i = 0; i < chosenParameters.length; i++)
            if(chosenParameters[i] == true)
                flagg = true;
        if(flagg == false)
        {
            if(table.equals("osoby"))
            {
                query += "osoby";
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
            if(table.equals("sprzet"))
            {
                query += "sprzet";
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
            if(table.equals("lokalizacja"))
            {
                query += "lokalizacja";
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
                return data;}
        }

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
        JFrame frame = new JFrame();
        boolean success = false;

        String query = " DELETE FROM ";
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

            try{
                statement = conn.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(frame,"Poprawnie usunięto dane");
                success = true;
            }
            catch (SQLException e) {
                e.printStackTrace();
                success = false;
            }

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

            try{
                statement = conn.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(frame,"Poprawnie usunięto dane");
                success = true;

            }
            catch (SQLException e) {
                e.printStackTrace();
                success = false;
            }

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

            try{
                statement = conn.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(frame,"Poprawnie usunięto dane");
                success = true;

              }
            catch (SQLException e) {
                e.printStackTrace();
                success = false;
            }

        }


        return success;
    }

    public boolean addData(String table, String[] dataToAdd){
        // funkcja dodająca wiersz wypełniony danymi z dataToAdd do tabeli table
        // INSERT INTO table_name (column1, column2, column3, ...)
        // VALUES (value1, value2, value3, ...);
        JFrame frame = new JFrame();

        if(table.equals("osoby"))
        {
            String query = "INSERT INTO osoby (id_osoby, id_lokalizacji, imie, nazwisko, nr_tel, adres, mail, login, hasło) VALUES (";
            String []tmp = {"id_osoby", "id_lokalizacji", "imie", "nazwisko", "nr_tel", "adres", "mail", "login", "hasło"};
            boolean flag = true;

            for(int i = 0; i < dataToAdd.length; i++)
            {
                if(tmp[i] == "id_osoby")
                {
                    try {
                        statement = conn.createStatement();
                        resultSet = statement.executeQuery("SELECT count(*) FROM osoby");

                        resultSet.next();
                        int x = resultSet.getInt(1);
                        dataToAdd[i] = String.valueOf(x);
                        JOptionPane.showMessageDialog(frame,"Numer id_osoby został zignorowany i nadany wg kolejności w bazie danych");
                    }catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }

                if(tmp[i] == "id_lokalizacji")
                    if(!checkLockationId(dataToAdd[i]))
                    {
                        JOptionPane.showMessageDialog(frame,"Podane ID Lokalizacji nie jest liczbą lub jest puste");
                        flag = false;
                    }


                if(tmp[i] == "imie" || tmp[i] == "nazwisko")
                    if(dataToAdd[i].isEmpty()) {
                        JOptionPane.showMessageDialog(frame,"Imię lub Nazwisko jest puste");
                        flag = false;
                    }

                if(tmp[i] == "nr_tel")
                    if(!checkPhoneNumber(dataToAdd[i])) {
                        JOptionPane.showMessageDialog(frame, "Podany numer telefonu jest błedny \nPowienien zawierać 9 cyfr");
                        flag = false;
                    }

                if(tmp[i] == "mail")
                    if(!checkEmail(dataToAdd[i]))
                    {
                        JOptionPane.showMessageDialog(frame, "Podany email jest nie prawidłowy lub został nie podany");
                        flag = false;
                    }

                if(tmp[i] == "login")
                    if(!checkLogin(dataToAdd[i]))
                    {
                        JOptionPane.showMessageDialog(frame,"Podany login już istnieje lub zawiera znaki nie dozowolone (' , . / \") lub pole jest puste");
                        flag = false;
                    }

                if(tmp[i] == "hasło")
                    if(!checkPass(dataToAdd[i]))
                    {
                        JOptionPane.showMessageDialog(frame,"Hasło powinno być dłuższe niż 5 znaków");
                        flag = false;
                    }


                query += "'" + dataToAdd[i] + "', ";
            }

            query = query.substring(0,query.length() - 2);
            query += ");";

            if(flag != false)
            {
                try{

                    statement = conn.createStatement();
                    statement.executeUpdate(query);
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }


        }else if(table.equals("sprzet"))
        {
            // Narazie brak zabezpieczeń
            String query = "INSERT INTO sprzet (id_sprzet, typ, marka, parametry, stan_sprzetu, id_lokalizacji, id_osoby, model) VALUES (";
            String []tmp = {"id_sprzet", "typ", "marka", "parametry", "stan_sprzetu", "id_lokalizacji", "id_osoby", "model"};
            boolean flag = true;

            for(int i = 0; i < dataToAdd.length; i++)
            {

                if(tmp[i] == "id_sprzet") {
                    try {
                        statement = conn.createStatement();
                        resultSet = statement.executeQuery("SELECT count(*) FROM sprzet");

                        resultSet.next();
                        int x = resultSet.getInt(1);
                        dataToAdd[i] = String.valueOf(x);

                        JOptionPane.showMessageDialog(frame, "Numer id_sprzetu został zignorowany i nadany wg kolejności w bazie danych");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if(tmp[i] == "stan_sprzetu") {
                    checkEquipmentStatus(dataToAdd[i]);
                }

                if(tmp[i] == "id_lokalizacji")
                    if(!checkIdLockation(dataToAdd[i]))
                    {
                        JOptionPane.showMessageDialog(frame,"Podane Id_lokalizacji nie istnieje lub zostawiłeś/łaś puste pole");
                        flag = false;
                    }

                if(tmp[i] == "id_osoby")
                    if(!checkIdOsoby(dataToAdd[i]))
                    {
                        JOptionPane.showMessageDialog(frame,"Podane Id_osoby nie istnieje lub zostawiłeś/łaś puste pole");
                        flag = false;
                    }


                query += "'" + dataToAdd[i] + "', ";
            }
            query = query.substring(0,query.length() - 2);
            query += ");";

            if(flag!=false) {
                try {

                    statement = conn.createStatement();
                    statement.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }else if(table.equals("lokalizacja"))
        {
            String query = "INSERT INTO lokalizacja (id_lokalizacja, miasto, kod_pocztowy) VALUES (";
            String []tmp = {"id_lokalizacja", "miasto", "kod_pocztowy"};
            boolean flag = true;

            for(int i = 0; i < dataToAdd.length; i++)
            {
                if(tmp[i] == "id_lokalizacja") {
                    try {
                        statement = conn.createStatement();
                        resultSet = statement.executeQuery("SELECT count(*) FROM lokalizacja");

                        resultSet.next();
                        int x = resultSet.getInt(1);
                        dataToAdd[i] = String.valueOf(x);

                        JOptionPane.showMessageDialog(frame, "Numer id_lokalizacji został zignorowany i nadany wg kolejności w bazie danych");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(tmp[i] == "miasto")
                    if(!checkCity(dataToAdd[i]))
                    {
                        flag = false;
                        JOptionPane.showMessageDialog(frame,"Podane miasto zawiera cyfry lub pole jest puste");
                    }
                if(tmp[i] == "kod_pocztowy")
                    if(!checkPostCode(dataToAdd[i]))
                    {
                        flag = false;
                        JOptionPane.showMessageDialog(frame,"Podany kod pocztowy jest błędny\nPowinien wyglądać na przykład tak: '65-012'");
                    }

                query += "'" + dataToAdd[i] + "', ";
            }
            query = query.substring(0,query.length() - 2);
            query += ");";

            if(flag != false) {
                try {
                    statement = conn.createStatement();
                    statement.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        boolean success = false;
        return success;
    }

    public boolean updateData(String table, boolean[] chosenParams, String[] dataToUpdate){
        JFrame frame = new JFrame();
        String query = "";
        if(table.equals("osoby")){
            query = "UPDATE osoby SET ";
            String []tmp = {"id_osoby", "id_lokalizacji", "imie", "nazwisko", "nr_tel", "adres", "mail", "login", "hasło"};

            for(int i = 0; i < dataToUpdate.length; i++) {
                if(tmp[i].equals("id_osoby")) {
                    try {
                        statement = conn.createStatement();
                        resultSet = statement.executeQuery("SELECT count(1) FROM osoby WHERE id_osoby = " + dataToUpdate[0].toString() + ";");
                        resultSet.next();
                        int x = resultSet.getInt(1);
                        if(x == 0){
                            JOptionPane.showMessageDialog(frame,"Rekord o podanym id_osoby nie istnieje!");
                            return false;
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else if(tmp[i].equals("id_lokalizacji") && chosenParams[i]){
                    if(!checkLockationId(dataToUpdate[i])) {
                        JOptionPane.showMessageDialog(frame,"Podane ID Lokalizacji nie jest liczbą lub jest puste");
                        return false;
                    }
                }
                else if(tmp[i].equals("imie") && chosenParams[i]){
                    if(dataToUpdate[i].isEmpty()) {
                        JOptionPane.showMessageDialog(frame,"Imię lub Nazwisko jest puste");
                        return false;
                    }
                }
                else if(tmp[i].equals("nazwisko") && chosenParams[i]){
                    if(dataToUpdate[i].isEmpty()) {
                        JOptionPane.showMessageDialog(frame,"Imię lub Nazwisko jest puste");
                        return false;
                    }
                }
                else if(tmp[i].equals("nr_tel") && chosenParams[i]){
                    if(!checkPhoneNumber(dataToUpdate[i])) {
                        JOptionPane.showMessageDialog(frame, "Podany numer telefonu jest błedny \nPowienien zawierać 9 cyfr");
                        return false;
                    }
                }
                else if(tmp[i].equals("mail") && chosenParams[i]){
                    if(!checkEmail(dataToUpdate[i])){
                        JOptionPane.showMessageDialog(frame, "Podany email jest nie prawidłowy lub został nie podany");
                        return false;
                    }
                }
                else if(tmp[i].equals("login") && chosenParams[i]){
                    if(!checkLogin(dataToUpdate[i])){
                        JOptionPane.showMessageDialog(frame,"Podany login już istnieje lub zawiera znaki nie dozowolone (' , . / \") lub pole jest puste");
                        return false;
                    }
                }
                else if(tmp[i].equals("hasło") && chosenParams[i]){
                    if(!checkPass(dataToUpdate[i])) {
                        JOptionPane.showMessageDialog(frame,"Hasło powinno być dłuższe niż 5 znaków");
                        return false;
                    }
                }
                if(chosenParams[i] && i > 0){
                    query += tmp[i] + " = " + "'" + dataToUpdate[i] + "', ";
                }
            }
            query = query.substring(0, query.length() - 2);     // wyrzuca przecinek i spacje z końca
            query += " WHERE id_osoby = " + dataToUpdate[0].toString() + ";";
        }
        else if(table.equals("sprzet")) {
            query = "UPDATE sprzet SET ";
            String []tmp = {"id_sprzet", "typ", "marka", "parametry", "stan_sprzetu", "id_lokalizacji", "id_osoby", "model"};

            for(int i = 0; i < dataToUpdate.length; i++){
                if(tmp[i].equals("id_sprzet")){
                    try {
                        statement = conn.createStatement();
                        resultSet = statement.executeQuery("SELECT count(1) FROM sprzet WHERE id_sprzet = " + dataToUpdate[0].toString() + ";");

                        resultSet.next();
                        int x = resultSet.getInt(1);
                        if(x == 0){
                            JOptionPane.showMessageDialog(frame,"Rekord o podanym id_osoby nie istnieje!");
                            return false;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else if(tmp[i].equals("stan_sprzetu") && chosenParams[i]){
                    if(!dataToUpdate[i].toUpperCase().equals("NIESPRAWNY") && !dataToUpdate[i].toUpperCase().equals("SPRAWNY")){
                        JOptionPane.showMessageDialog(frame,"Sprzet może mieć tylko dwa stany SPRAWNY i NIESPRAWNY!");
                        return false;
                    }
                }
                else if(tmp[i].equals("id_lokalizacji") && chosenParams[i]){
                    if(!checkIdLockation(dataToUpdate[i])){
                        JOptionPane.showMessageDialog(frame,"Podane Id_lokalizacji nie istnieje lub zostawiłeś/łaś puste pole");
                        return false;
                    }
                }
                else if(tmp[i].equals("id_osoby") && chosenParams[i]){
                    if(!checkIdOsoby(dataToUpdate[i])){
                        JOptionPane.showMessageDialog(frame,"Podane Id_osoby nie istnieje lub zostawiłeś/łaś puste pole");
                        return false;
                    }
                }
                if(chosenParams[i] && i > 0){
                    query += tmp[i] + " = " + "'" + dataToUpdate[i] + "', ";
                }
            }
            query = query.substring(0, query.length() - 2);     // wyrzuca przecinek i spacje z końca
            query += " WHERE id_sprzet = " + dataToUpdate[0].toString() + ";";
        }
        else if(table.equals("lokalizacja")){
            query = "UPDATE lokalizacja SET ";
            String []tmp = {"id_lokalizacja", "miasto", "kod_pocztowy"};

            for(int i = 0; i < dataToUpdate.length; i++){
                if(tmp[i] == "id_lokalizacja") {
                    try {
                        statement = conn.createStatement();
                        resultSet = statement.executeQuery("SELECT count(1) FROM lokalizacja WHERE id_lokalizacja = " + dataToUpdate[0].toString() + ";");

                        resultSet.next();
                        int x = resultSet.getInt(1);
                        if(x == 0){
                            JOptionPane.showMessageDialog(frame,"Rekord o podanym id_lokalizacji nie istnieje!");
                            return false;
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else if(tmp[i].equals("miasto") && chosenParams[i]){
                    if(!checkCity(dataToUpdate[i])){
                        JOptionPane.showMessageDialog(frame,"Podane miasto zawiera cyfry lub pole jest puste");
                        return false;
                    }
                }
                else if(tmp[i] == "kod_pocztowy" && chosenParams[i]){
                    if(!checkPostCode(dataToUpdate[i])){
                        JOptionPane.showMessageDialog(frame,"Podany kod pocztowy jest błędny\nPowinien wyglądać na przykład tak: '65-012'");
                        return false;
                    }
                }
                if(chosenParams[i] && i > 0){
                    query += tmp[i] + " = " + "'" + dataToUpdate[i] + "', ";
                }
            }
            query = query.substring(0, query.length() - 2);     // wyrzuca przecinek i spacje z końca
            query += " WHERE id_lokalizacja = " + dataToUpdate[0].toString() + ";";
        }
        try{
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
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

    public boolean checkLockationId(String veriable){
        if(veriable.isEmpty())
            return false;
        if(!StringUtils.isStrictlyNumeric(veriable))
            return false;
        return true;
    }

    public boolean checkPhoneNumber(String veriable){
        if(veriable.isEmpty())
            return false;
        if(veriable.length() != 9)
            return false;
        if(!StringUtils.isStrictlyNumeric(veriable))
            return false;

        return true;
    }

    public boolean checkEmail(String veriable){
        if(veriable.indexOf("@") < 0 || veriable.indexOf("@") == 0 || veriable.indexOf("@") == veriable.length() -1)
            return false;

        return true;
    }

    public boolean checkLogin(String veriable){

        String  query = "SELECT * FROM osoby WHERE login = '" + veriable + "';";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
                return false;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        if(veriable.indexOf(".") > 0 || veriable.indexOf(",") >0 || veriable.indexOf("/") > 0 || veriable.indexOf("'" ) > 0 || veriable.indexOf("\"") > 0)
            return false;
        if(veriable.isEmpty())
            return false;

        return true;
    }

    public boolean checkPass(String veriable){
        if(veriable.length() <= 5)
            return false;
        if(veriable.isEmpty())
            return false;
        return true;
    }

    public boolean checkCity(String veriable){

        for(int i = 0; i <=9; i++)
            if(veriable.indexOf(i) > 0)
                return false;

        if(veriable.isEmpty())
            return false;

        return true;
    }

    public boolean checkPostCode(String veriable){

        if(veriable.length() != 6)
            return false;

        String two = veriable.substring(0,2);
        String three = veriable.substring(3,6);
        String dash = veriable.substring(2,3);

        if(!StringUtils.isStrictlyNumeric(two))
            return false;
        if(!StringUtils.isStrictlyNumeric(three))
            return  false;
        if(!dash.equals("-"))
            return false;
        return true;
    }

    public String checkEquipmentStatus(String veriable){
        if(veriable.isEmpty())
            veriable = "sprawny";
        if(veriable != "sprawny" & veriable != "niesprawny")
            veriable = "sprawny";
        return veriable;
    }

    public  boolean checkIdLockation(String veriable){
        String  query = "SELECT * FROM sprzet WHERE id_lokalizacji = '" + veriable + "';";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            if(!resultSet.next())
                return false;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        if(veriable.isEmpty())
            return false;

        return true;
    }

    public  boolean checkIdOsoby(String veriable){
        String  query = "SELECT * FROM sprzet WHERE id_osoby = '" + veriable + "';";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            if(!resultSet.next())
                return false;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        if(veriable.isEmpty())
            return false;

        return true;
    }
}
