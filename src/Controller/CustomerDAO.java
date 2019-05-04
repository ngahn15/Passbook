/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
import Model.Customer;
import View.CustomerRegister;
import View.infoCus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author ngocn
 */
public class CustomerDAO implements DAO {

    public static CustomerDAO Instance;
    CustomerRegister CR = new CustomerRegister();

    public CustomerDAO() {
        Instance = this;
    }

    private static Customer customer;

    public boolean checkExist(String ID) {
        customer = CustomerDAO.Instance.getByID(ID);
        if (customer == null) {
            return false;
        }
        return true;
    }

    public String validateCMT(String CMT) {
//        check null
        if (Base.Instance.checkStringNull(CMT)) {
            return Message.Instance.M_CMT_1;
        } //        check length
        else if (Base.Instance.checkLength(CMT, 9, 15)) {
            return Message.Instance.M_CMT_2;
        } //        check ky tu dac biet
        else if (Base.Instance.checkChar(CMT)) {
            return Message.Instance.M_CMT_3;
        } else if (checkExist(CMT)) {
            return Message.Instance.M_CMT_4;
        }
        return null;
    }

    public String validateName(String fullnameStr) {
//        check null
        if (Base.Instance.checkStringNull(fullnameStr)) {
            return Message.Instance.M_Name_1;
        } //        check length
        else if (Base.Instance.checkLength(fullnameStr, 255)) {
            return Message.Instance.M_Name_2;

        }
        return null;
    }

    public String validateDate(Date birthdayDate) {
//        check null
        if (birthdayDate == null) {
            return Message.Instance.M_Date_1;
        }

        return null;
    }

    public String validateAddress(String addressStr) {
//        check null
        if (Base.Instance.checkStringNull(addressStr)) {
            return Message.Instance.M_Date_1;
        }

        return null;
    }

    public String validateEmail(String emailStr) {
//        check null
        if (Base.Instance.checkStringNull(emailStr)) {
            return Message.Instance.M_Email_1;
        }
        return null;
    }

    public String validatePhone(String phoneStr) {
//        check null
        if (Base.Instance.checkStringNull(phoneStr)) {
            return Message.Instance.M_Phone_1;
        } //        check length
        else if (Base.Instance.checkLength(phoneStr, 10, 12)) {
            return Message.Instance.M_Phone_2;
        } //        check ky tu dac biet
        else if (Base.Instance.checkChar(phoneStr)) {
            return Message.Instance.M_Phone_3;
        }
        return null;
    }

    public void showMesage(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public void Register(Customer customer) {

        if (validateCMT(customer.getCMT()) == null && validateName(customer.getFullname()) == null && validateAddress(customer.getAddress()) == null
                && validateDate(customer.getBirthday()) == null && validatePhone(customer.getPhone()) == null && validateEmail(customer.getEmail()) == null) {
            customer = new Customer(customer.getCMT(), customer.getFullname(), customer.getAddress(), customer.getEmail(), customer.getPhone(), customer.getBirthday(), customer.getGender());
            int n = CustomerDAO.Instance.add(customer);
            if (n != 0) {
                showMesage(Message.Instance.register_Success);
                this.CR.dispose();
//                gửi khách hàng vừa đăng ký sang view info
                infoCus ic = new infoCus(customer);
                ic.setVisible(true);
                ic.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            } else {
                showMesage("wrong answer!");
            }
        } else {
            if (validateCMT(customer.getCMT()) != null) {
                showMesage(validateCMT(customer.getCMT()));

            }
            if (validateName(customer.getFullname()) != null) {
                showMesage(validateName(customer.getFullname()));

            }
            if (validateAddress(customer.getAddress()) != null) {
                showMesage(validateAddress(customer.getAddress()));

            }
            if (validateDate(customer.getBirthday()) != null) {
                showMesage(validateDate(customer.getBirthday()));

            }
            if (validateCMT(customer.getPhone()) != null) {
                showMesage(validatePhone(customer.getPhone()));

            }
            if (validateEmail(customer.getEmail()) != null) {
                showMesage(validateEmail(customer.getEmail()));
            }
        }

    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int add(Object c) {
        customer = (Customer) c;
        int n = 0;
        try {
            String sql = "INSERT INTO customer(ID, Fullname, Birthday, Address, Email, Phone, Gender) VALUES ('"
                    + customer.getCMT() + "',N'" + customer.getFullname() + "',N'" + Base.Instance.dateToStringInsert(customer.getBirthday()) + "',N'"
                    + customer.getAddress() + "',N'" + customer.getEmail() + "',N'" + customer.getPhone() + "',N'" + customer.getGender() + "')";
            System.out.println(sql);
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            n = DBConnect.Instance.ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public Customer getByID(Object ID) {
        ID = ID.toString();
        try {
            String sql = "Select * from customer Where ID = " + ID;
            DBConnect.Instance.ps = DBConnect.Instance.conn.prepareStatement(sql);
            DBConnect.Instance.rs = DBConnect.Instance.ps.executeQuery(sql);
            while (DBConnect.Instance.rs.next()) {
                String CMT = DBConnect.Instance.rs.getString(1);
                String fullname = DBConnect.Instance.rs.getString(2);
                Date birthday = DBConnect.Instance.rs.getDate(3);
                String address = DBConnect.Instance.rs.getString(4);
                String email = DBConnect.Instance.rs.getString(5);
                String phone = DBConnect.Instance.rs.getString(6);
                String gender = DBConnect.Instance.rs.getString(7);
                customer = new Customer(CMT, fullname, address, email, phone, birthday, 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    @Override
    public List getAllByID(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
