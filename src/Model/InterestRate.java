/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ngocn
 */
public class InterestRate {

    private int ID, TypeID, Period;
    private Double Rate;

    public InterestRate() {
    }

    public InterestRate(int TypeID, int Period, Double Rate) {
        this.TypeID = TypeID;
        this.Period = Period;
        this.Rate = Rate;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }

    public int getPeriod() {
        return Period;
    }

    public void setPeriod(int Period) {
        this.Period = Period;
    }

    public Double getRate() {
        return Rate;
    }

    public void setRate(Double Rate) {
        this.Rate = Rate;
    }

}
