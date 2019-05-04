/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngocn
 */
public class TinhLai {

    public TinhLai() {
    }

    public static long ngayThuc(Date start, Date end) {
        long difference = start.getTime() - end.getTime();
        long time = (difference) / (1000 * 60 * 60 * 24);
        return time;
    }

    public static Double CongThuc(Double laiSuat, long ngaythuc, long soTienGui) {
        if (ngaythuc < 0) {
            ngaythuc = - ngaythuc;
        }
        double x = soTienGui * (laiSuat / 100d) * (ngaythuc / 360d);
        System.out.println(x);
        return soTienGui * (laiSuat / 100d) * (ngaythuc / 360d);
    }

    public static double TinhLai(long ngaythuc, Date hanRut, Date ngayRut, Double laiSuat, int kyhan, long soTienGui) {

        String hanRut_Str = Base.Instance.dateToStringShow(hanRut);
        String ngayRut_Str = Base.Instance.dateToStringShow(ngayRut);

        boolean time = ngayRut.after(hanRut);
        double tienLai = 0d;
//        time = false => rút trước hạn => lãi suất về không kỳ hạn
//          time = true => rút >= hạn

        if (time == false) {
            laiSuat = IRateDAO.Instance.getLaiSuatKhongKyHan();
            tienLai = CongThuc(laiSuat, ngaythuc, soTienGui);
        } else {
            laiSuat = IRateDAO.Instance.getLaiSuatCoKyHan(kyhan);
//            dung han
            tienLai = CongThuc(laiSuat, ngaythuc, soTienGui);
            if (hanRut_Str.equals(ngayRut_Str) == false) {
//              sau han
                long ngayDu = ngayThuc(hanRut, ngayRut);
                laiSuat = IRateDAO.Instance.getLaiSuatKhongKyHan();
                tienLai += CongThuc(laiSuat, ngayDu, soTienGui);
            }

        }
        System.out.println("Tien gui: " + soTienGui);
        return tienLai;
    }
//
//    public static void main(String[] args) {
//
//        try {
//            String sDate1 = "31/12/1998";
//            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//            System.out.println(sDate1 + "\t" + date1);
//
//            TinhLai tinhlai = new TinhLai();
//            Date d1 = new Date();
//            System.out.println(d1);
//            Calendar c1 = Calendar.getInstance();
//            c1.add(Calendar.MONTH, 0);
//            Date d2 = c1.getTime();
//            System.out.println(d2);
//            System.out.println(d2.toString().equals(d1.toString()));
//        } catch (ParseException ex) {
//            Logger.getLogger(TinhLai.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
