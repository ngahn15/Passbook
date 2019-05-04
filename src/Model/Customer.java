/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ngocn
 */
public class Customer {

    private String CMT, fullname, address, email, phone;
    private Date birthday;
    private int gender;

    public Customer() {
    }

    public Customer(String CMT, String fullname, String address, String email, String phone, Date birthday, int gender) {
        this.CMT = CMT;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Customer(String cmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCMT() {
        return CMT;
    }

    public void setCMT(String CMT) {
        this.CMT = CMT;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" + "CMT=" + CMT + ", fullname=" + fullname + ", address=" + address + ", email=" + email + ", phone=" + phone + ", birthday=" + birthday + ", gender=" + gender + '}';
    }

}
