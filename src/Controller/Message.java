/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author ngocn
 */
public class Message {

    public static Message Instance;
//    Register
    public static String register_Success = "Thêm khách hàng thành công!";
    public static String M_CMT_1 = "Số chứng minh thư không được để trống!";
    public static String M_CMT_2 = "Số chứng minh thư tối thiểu 9 ký tự, tối đa 15 ký tự!";
    public static String M_CMT_3 = "Số chứng minh thư không chứa ký tự đặc biệt!";
    public static String M_CMT_4 = "Khách hàng này đã tồn tại trong CSDL";
    public static String M_Name_1 = "Họ tên không được để trống!";
    public static String M_Name_2 = "Họ tên không quá 255 ký tự!";
    public static String M_Date_1 = "Ngày sinh không được để trống!";
    public static String M_Address_1 = "Địa chỉ không được để trống!";
    public static String M_Email_1 = "Email không được để trống!";
    public static String M_Phone_1 = "Số điện thoại không được để trống!";
    public static String M_Phone_2 = "Số điện thoại tối thiểu 10 ký tự, tối đa 12 ký tự!";
    public static String M_Phone_3 = "Số điện thoại chứa ký tự đặc biệt!";

//    OpenPassbook
    public static String openPassbook_Success = "Mở sổ thành công!";
    public static String money_1 = "Vui lòng nhập vào số tiền gửi!";
    public static String money_2 = "Số tiền nhập vào không chứ ký tự chữ cái, hoặc ký tự đặc biệt!";
    public static String money_3 = "Tiền gửi tối thiểu là 1.000.000 đồng!";
    public static String money_4 = "Tiền gửi là bội số của 5000!";
    public static String combobox_1 = "Vui lòng chọn loại sổ tiết kiệm!";    
    public static String combobox_2_1 = "Vui lòng chọn kỳ hạn!";    
    public static String combobox_2_2 = "Kỳ hạn không hợp lệ!";
    public static String combobox_3 = "Vui lòng chọn phương thức rút lãi!";


//    public static String M_CMT_3 = "Số chứng minh thư không chứa ký tự đặc biệt!";
//    public static String M_CMT_4 = "Khách hàng này đã tồn tại trong CSDL";
//    public static String M_Name_1 = "Họ tên không được để trống!";
//    public static String M_Name_2 = "Họ tên không quá 255 ký tự!";
//    public static String M_Date_1 = "Ngày sinh không được để trống!";
//    public static String M_Address_1 = "Địa chỉ không được để trống!";
//    public static String M_Email_1 = "Email không được để trống!";
//    public static String M_Phone_1 = "Số điện thoại không được để trống!";
//    public static String M_Phone_2 = "Số điện thoại tối thiểu 10 ký tự, tối đa 12 ký tự!";
//    public static String M_Phone_3 = "Số điện thoại chứa ký tự đặc biệt!";
    public Message() {
        Instance = this;
    }
}
