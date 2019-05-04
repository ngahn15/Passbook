/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Base;
import Controller.CustomerDAO;
import Controller.DBConnect;
import Controller.IRateDAO;
import Controller.Message;
import Controller.OpenPassbookDAO;
import View.Home;

/**
 *
 * @author ngocn
 */
public class ManagePassbook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnect db = new DBConnect("localhost", "3306", "root", "");
        Base base = new Base();        
        Message mesage = new Message();

        CustomerDAO customerDAO = new CustomerDAO();
        OpenPassbookDAO opDAO = new OpenPassbookDAO();
        IRateDAO IRDAO = new IRateDAO();
        Home home = new Home();
        home.setVisible(true);
    }
    
}
