/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngocn
 */
public class DBConnect {

    public static DBConnect Instance;
    public Connection conn = null;
    public String hostName, port;
    public String username = "root";
    public String password = "";
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    public DBConnect(String hostName, String port, String username, String password) {
        Instance = this;
        this.hostName = hostName;
        this.port = port;
        this.username = username;
        this.password = password;

        Init();
    }

    public void Init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8", username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
