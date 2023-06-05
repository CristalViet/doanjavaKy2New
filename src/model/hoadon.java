package model;

import java.util.Date;

public class hoadon {
    private String mahoadon;
    private String tenban;
    private String tenhanvien;
    private double tienhang;
    private String ngaythanhtoan;
	public hoadon(String mahoadon, String tenban, String tenhanvien, double tienhang, String ngaythanhtoan) {
		super();
		this.mahoadon = mahoadon;
		this.tenban = tenban;
		this.tenhanvien = tenhanvien;
		this.tienhang = tienhang;
		this.ngaythanhtoan = ngaythanhtoan;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getTenban() {
		return tenban;
	}
	public void setTenban(String tenban) {
		this.tenban = tenban;
	}
	public String getTenhanvien() {
		return tenhanvien;
	}
	public void setTenhanvien(String tenhanvien) {
		this.tenhanvien = tenhanvien;
	}
	public double getTienhang() {
		return tienhang;
	}
	public void setTienhang(double tienhang) {
		this.tienhang = tienhang;
	}
	public String getNgaythanhtoan() {
		return ngaythanhtoan;
	}
	public void setNgaythanhtoan(String ngaythanhtoan) {
		this.ngaythanhtoan = ngaythanhtoan;
	}
	@Override
	public String toString() {
		return "hoadon [mahoadon=" + mahoadon + ", tenban=" + tenban + ", tenhanvien=" + tenhanvien + ", tienhang="
				+ tienhang + ", ngaythanhtoan=" + ngaythanhtoan + "]";
	}
    
    
    
	
     
     
}
