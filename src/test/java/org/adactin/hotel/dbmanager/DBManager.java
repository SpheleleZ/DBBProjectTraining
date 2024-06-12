package org.adactin.hotel.dbmanager;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class DBManager {

    static String[][] result;

    //for testing only should be removed
    @Test
    public void testingMethod() {
        String q = "SELECT * FROM adactinhotel.hoteldetails\n" +
                "where idHotelDetails = 2";
        String[][] result = fetchDataFromDB(q);
        System.out.println(Arrays.deepToString(result));
    }

    public static String[][] fetchDataFromDB(String query) {
        try {
            //String url =
            String url = "jdbc:mysql://localhost:3306/adactinhotel";
            String username = "root";
            String password = "Nok2lasphe@1";
            DBConnectionManager dbInstance = DBConnectionManager.getInstance(url, username, password);
            Connection connection = dbInstance.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            //To get Total number of column returned
            int clmCount = resultSet.getMetaData().getColumnCount();

            //To get total number of rows returned
            int rowCount = resultSet.getRow(); //This will give the index of the last row

            //Create a object
            result = new String[rowCount][clmCount];
            int i = 0;

            System.out.println("Contents of the first record: ");
            //Current record details.
            System.out.print("ID: " + resultSet.getInt("idHotelDetails") + ", ");
            System.out.print("Username: " + resultSet.getString("Location") + ", ");
            System.out.print("Password: " + resultSet.getString("HotelsType") + ", ");
            return result;
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
        return result;
    }
}
