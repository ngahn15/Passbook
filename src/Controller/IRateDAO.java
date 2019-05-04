/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngocn
 */
public class IRateDAO implements DAO {

    public static IRateDAO Instance;

    public IRateDAO() {
        Instance = this;
    }
// lay ky han

    public int getKyHanByID(int ID) {
        int kyhan = 0;

        try {
            String sql = "SELECT period FROM interestrate WHERE ID = '" + ID + "'";
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            DBConnect.Instance.rs = DBConnect.Instance.ps.executeQuery(sql);
            while (DBConnect.Instance.rs.next()) {
                kyhan = DBConnect.Instance.rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IRateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kyhan;
    }

    public double getLaiSuatKhongKyHan() {
        double ls = 0;

        try {
            String sql = "SELECT rate FROM interestrate WHERE TypeID = '" + 1 + "AND Period = " + 0 + "'";
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            DBConnect.Instance.rs = DBConnect.Instance.ps.executeQuery(sql);
            while (DBConnect.Instance.rs.next()) {
                ls = DBConnect.Instance.rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IRateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public double getLaiSuatCoKyHan(int IRateID) {
        double ls = 0;
        try {
            String sql = "SELECT rate FROM interestrate WHERE ID = '" + IRateID + "'";
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            DBConnect.Instance.rs = DBConnect.Instance.ps.executeQuery(sql);
            while (DBConnect.Instance.rs.next()) {
                ls = DBConnect.Instance.rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IRateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

//    lấy kỳ hạn gửi
    @Override
    public Object getByID(Object e) {
        return null;
    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllByID(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int add(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
