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
public class TypePassbook {
    private int ID;
    private String NameType;

    public TypePassbook() {
    }

    public TypePassbook(int ID, String NameType) {
        this.ID = ID;
        this.NameType = NameType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameType() {
        return NameType;
    }

    public void setNameType(String NameType) {
        this.NameType = NameType;
    }
    
}
