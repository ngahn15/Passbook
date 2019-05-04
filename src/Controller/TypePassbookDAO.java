/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngocn
 */
public class TypePassbookDAO {

    public static String getNameTypeByID(int id) {
        String ID = Integer.toString(id);
        String NameType = null;
        try {
            String sql = "SELECT NameType FROM typepassbook WHERE ID = " + ID;
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            DBConnect.Instance.rs = DBConnect.Instance.ps.executeQuery(sql);
            while (DBConnect.Instance.rs.next()) {
                NameType = DBConnect.Instance.rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NameType;
    }
}
