package model;

import java.util.ArrayList;

import org.json.simple.JSONObject;
public class diadiem {
    public static int id;
    public String ten;
    public ArrayList<String> sukien = new ArrayList<String>();
    public ArrayList<String> nhanvat = new ArrayList<String>();

    public diadiem () {

    }
    public diadiem (String ten) {
        this.ten = ten;
    }

    public diadiem (String ten, ArrayList<String> sukien)
    {
        this.ten = ten;
        this.sukien = sukien;
    }
    public diadiem (String ten, ArrayList<String> sukien, ArrayList<String> nhanvat) {
        this.ten = ten;
        this.sukien = sukien;
        this.nhanvat = nhanvat;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        diadiem.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ArrayList<String> getSukien() {
        return sukien;
    }

    public void setSukien(ArrayList<String> sukien) {
        this.sukien = sukien;
    }

    public ArrayList<String> getNhanvat() {
        return nhanvat;
    }

    public void setNhanvat(ArrayList<String> nhanvat) {
        this.nhanvat = nhanvat;
    }
}
