/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.*;
import java.util.Date;

/**
 *
 * @author ngocn
 */
public class TinhLai {

    private long soTienGui;
    private Date ngayGui, ngayRut;
//    private int ngayThuc = 0;
    private float laiSuat;
    private Double tienLai;

    public TinhLai() {
    }

    public TinhLai(long soTienGui, Date ngayGui, Date ngayRut, float laiSuat, Double tienLai) {
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.ngayRut = ngayRut;
        this.laiSuat = laiSuat;
        this.tienLai = tienLai;
    }

    public long getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(long soTienGui) {
        this.soTienGui = soTienGui;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

    public Date getNgayRut() {
        return ngayRut;
    }

    public void setNgayRut(Date ngayRut) {
        this.ngayRut = ngayRut;
    }

    public float getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(float laiSuat) {
        this.laiSuat = laiSuat;
    }

    public Double getTienLai() {
        return tienLai;
    }

    public void setTienLai(Double tienLai) {
        this.tienLai = tienLai;
    }
}
