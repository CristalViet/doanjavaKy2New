package model;

public class hoadon_ban {
     String idban;
     String idmon;
     String tenmon;
     double giatien;
     int soluong;
     
	public hoadon_ban(String idban, String idmon, String tenmon, double giatien, int soluong) {
		super();
		this.idban = idban;
		this.idmon = idmon;
		this.tenmon = tenmon;
		this.giatien = giatien;
		this.soluong = soluong;
	}
	public String getTenmon() {
		return tenmon;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}
	public String getIdban() {
		return idban;
	}
	public void setIdban(String idban) {
		this.idban = idban;
	}
	public String getIdmon() {
		return idmon;
	}
	public void setIdmon(String idmon) {
		this.idmon = idmon;
	}
	public double getGiatien() {
		return giatien;
	}
	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public String toString() {
		return "hoadon_ban [idban=" + idban + ", idmon=" + idmon + ", tenmon=" + tenmon + ", giatien=" + giatien
				+ ", soluong=" + soluong + "]";
	}
    
     
}
