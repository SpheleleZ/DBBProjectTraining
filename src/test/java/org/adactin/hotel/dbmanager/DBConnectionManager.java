package org.adactin.hotel.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {

    private static DBConnectionManager instance;
    private Connection connection;

    private DBConnectionManager(String url, String username, String password) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DBConnectionManager getInstance(String url, String username, String password) {
        try {
            if (instance == null) {
                instance = new DBConnectionManager(url, username, password);
            } else if (instance.getConnection().isClosed()) {
                instance = new DBConnectionManager(url, username, password);
            }
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
        return instance;
    }
}
