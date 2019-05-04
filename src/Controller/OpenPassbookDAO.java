/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
import Model.Customer;
import Model.Passbook;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngocn
 */
public class OpenPassbookDAO implements DAO {

    public static OpenPassbookDAO Instance;
    public static Passbook passbook;
    public static List<Passbook> PassbookListByIDC = new ArrayList<Passbook>();

    public OpenPassbookDAO() {
        Instance = this;
    }

    public static int randomID() {
        return (int) (Math.random() * 2147483647 + 1);
    }

    @Override
    public List getAllByID(Object id) {
        id = id.toString();
        try {
            String sql = "SELECT * FROM passbook WHERE CustomerID = " + id;
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            DBConnect.Instance.rs = DBConnect.Instance.ps.executeQuery(sql);
            while (DBConnect.Instance.rs.next()) {
                int ID = DBConnect.Instance.rs.getInt(1);
                int InterestRateID = DBConnect.Instance.rs.getInt(2);
                int TypeID = DBConnect.Instance.rs.getInt(3);
                String CustomerID = DBConnect.Instance.rs.getString(4);
                int TypePeriod = DBConnect.Instance.rs.getInt(5);
                int InterestMethodID = DBConnect.Instance.rs.getInt(6);
                long DepositsOriginal = DBConnect.Instance.rs.getLong(7);
                Date OpenDate = DBConnect.Instance.rs.getDate(8);
                Date expDate = DBConnect.Instance.rs.getDate(9);
                int status = DBConnect.Instance.rs.getInt(10);

                passbook = new Passbook(ID, InterestRateID, InterestMethodID, TypeID, CustomerID, OpenDate, expDate, DepositsOriginal, TypePeriod, status);
                if (passbook != null) {
                    PassbookListByIDC.add(passbook);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return customer;
        return PassbookListByIDC;
    }

    @Override
    public Passbook getByID(Object id) {
        id = id.toString();
        try {
            String sql = "SELECT * FROM passbook WHERE ID = " + id;
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            DBConnect.Instance.rs = DBConnect.Instance.ps.executeQuery(sql);
            while (DBConnect.Instance.rs.next()) {
                int ID = DBConnect.Instance.rs.getInt(1);
                int InterestRateID = DBConnect.Instance.rs.getInt(2);
                int TypeID = DBConnect.Instance.rs.getInt(3);
                String CustomerID = DBConnect.Instance.rs.getString(4);
                int TypePeriod = DBConnect.Instance.rs.getInt(5);
                int InterestMethodID = DBConnect.Instance.rs.getInt(6);
                long DepositsOriginal = DBConnect.Instance.rs.getLong(7);
                Date OpenDate = DBConnect.Instance.rs.getDate(8);
                Date expDate = DBConnect.Instance.rs.getDate(9);
                int status = DBConnect.Instance.rs.getInt(10);

                passbook = new Passbook(ID, InterestRateID, InterestMethodID, TypeID, CustomerID, OpenDate, expDate, DepositsOriginal, TypePeriod, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return customer;
        return passbook;
    }

    @Override
    public int add(Object t) {
        passbook = (Passbook) t;
        int n = 0;
        try {
            String sql = "INSERT INTO passbook(ID, InterestRateID, TypeID, CustomerID, TypePeriod, InterestMethodID, DepositsOriginal, OpenDate, expDate,  status) VALUES ('"
                    + passbook.getID() + "',N'" + passbook.getInterestRateID() + "',N'" + passbook.getTypeID() + "',N'" + passbook.getCustomerID() + "',N'"
                    + passbook.getTypePeriod() + "',N'" + passbook.getInterestMethodID() + "',N'" + passbook.getDepositsOriginal() + "',N'"
                    + Base.Instance.dateToStringInsert(passbook.getOpenDate()) + "',N'" + Base.Instance.dateToStringInsert(passbook.getExpDate()) + "',N'"
                    + passbook.getStatus() + "')";
            System.out.println(sql);
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            n = DBConnect.Instance.ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
