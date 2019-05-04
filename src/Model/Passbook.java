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
public class Passbook {

    private int ID;
    private int InterestRateID;
    private int InterestMethodID;
    private int TypeID;
    private String CustomerID;
    private Date OpenDate;
    private Date expDate;
    private long DepositsOriginal;
    private int TypePeriod;
    private int status;

    public Passbook() {
    }

    public Passbook(int ID, int InterestRateID, int InterestMethodID, int TypeID, String CustomerID, Date OpenDate, Date expDate, long DepositsOriginal, int TypePeriod, int status) {
        this.ID = ID;
        this.InterestRateID = InterestRateID;
        this.InterestMethodID = InterestMethodID;
        this.TypeID = TypeID;
        this.CustomerID = CustomerID;
        this.OpenDate = OpenDate;
        this.expDate = expDate;
        this.DepositsOriginal = DepositsOriginal;
        this.TypePeriod = TypePeriod;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getInterestRateID() {
        return InterestRateID;
    }

    public void setInterestRateID(int InterestRateID) {
        this.InterestRateID = InterestRateID;
    }

    public int getInterestMethodID() {
        return InterestMethodID;
    }

    public void setInterestMethodID(int InterestMethodID) {
        this.InterestMethodID = InterestMethodID;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Date getOpenDate() {
        return OpenDate;
    }

    public void setOpenDate(Date OpenDate) {
        this.OpenDate = OpenDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public long getDepositsOriginal() {
        return DepositsOriginal;
    }

    public void setDepositsOriginal(long DepositsOriginal) {
        this.DepositsOriginal = DepositsOriginal;
    }

    public int getTypePeriod() {
        return TypePeriod;
    }

    public void setTypePeriod(int TypePeriod) {
        this.TypePeriod = TypePeriod;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Passbook{" + "ID=" + ID + ", InterestRateID=" + InterestRateID + ", InterestMethodID=" + InterestMethodID + ", TypeID=" + TypeID + ", CustomerID=" + CustomerID + ", OpenDate=" + OpenDate + ", expDate=" + expDate + ", DepositsOriginal=" + DepositsOriginal + ", TypePeriod=" + TypePeriod + ", status=" + status + '}';
    }

}
