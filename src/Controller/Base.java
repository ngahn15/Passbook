/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngocn
 */
public class Base {

    public static Base Instance;

    public Base() {
        Instance = this;
    }
//check null

    public boolean checkStringNull(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }
//check length

    public boolean checkLength(String str, int a, int b) {
        if (str.length() < a || str.length() > b) {
            return true;
        }
        return false;
    }

    public boolean checkLength(String str, int b) {
        if (str.length() > b) {
            return true;
        }
        return false;
    }

//    check ky tu
    public boolean checkChar(String str) {
        char[] arrChar = {'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+',
            '[', ']', '{', '}', '\\', ':', '|', ';', '\"', '\'', '<', '>', ',', '.', '?', '/'};
        for (int i = 0; i < arrChar.length; i++) {
            String c = String.valueOf(arrChar[i]);
            if (str.contains(c)) {
                return true;
            }
        }
        return false;
    }
//    check ky tu

    public boolean checkChar_(String str) {
        char[] arrChar = {'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+',
            '[', ']', '{', '}', '\\', ':', '|', ';', '\"', '\'', '<', '>', ',', '?', '/'};
        for (int i = 0; i < arrChar.length; i++) {
            String c = String.valueOf(arrChar[i]);
            if (str.contains(c)) {
                return true;
            }
        }
        return false;
    }

    //    check ky tu
    public boolean checkCharABC(String str) {
        char[] arrChar = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h',
            'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        for (int i = 0; i < arrChar.length; i++) {
            String c = String.valueOf(arrChar[i]);
            if (str.contains(c) || str.contains(c.toUpperCase())) {
                System.out.println("13");
                return true;
            }
        }
        return false;
    }

//    check so tien nhap vao >= 1.000.000 && %50.000
    public boolean inputDeposit_1(int n) {
        if (n < 1000000) {
            return true;
        }
        return false;
    }

    public boolean inputDeposit_2(int n) {
        if (n % 5000 != 0) {
            return true;
        }
        return false;
    }

//    convert String to Date yyyy-mm-dd
    public Date stringToDate(String str) {
        Date date = null;
        if(str == null || str.equals("")){
            return null;
        }
        try {
            date =  new SimpleDateFormat("dd-MM-yyyy").parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

//    convert Date to String
    public String dateToStringInsert(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(date);
    }

    public String dateToStringShow(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        return formatter.format(date);
    }
//    định dạng giới tính

    public String gioiTinhToString(int i) {
        if (i == 0) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    //    định dạng giới tính
    public int gioiTinhToInt(String str) {
        if (str.equals("Nam")) {
            return 0;
        }
        return 1;
    }
}
