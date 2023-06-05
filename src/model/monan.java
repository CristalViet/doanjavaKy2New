package model;

public class monan {
      private int idmon;
      private String tenmon;
     
      private String tenloai;
      private String donvitinh;
      private int soluong;
      private double giatien;
      private String idanhmon;
	public monan(int idmon, String tenmon, String tenloai, String donvitinh, int soluong, double giatien,
			String idanhmon) {
		super();
		this.idmon = idmon;
		this.tenmon = tenmon;
		this.tenloai = tenloai;
		this.donvitinh = donvitinh;
		this.soluong = soluong;
		this.giatien = giatien;
		this.idanhmon = idanhmon;
	}
	
	
	public monan(String tenmon) {
		super();
		this.tenmon = tenmon;
	}


	public monan(int idmon) {
		super();
		this.idmon = idmon;
	}

	public void setIdanhmon(String idanhmon) {
		this.idanhmon = idanhmon;
	}

	public int getIdmon() {
		return idmon;
	}
	public void setIdmon(int idmon) {
		this.idmon = idmon;
	}
	public String getTenmon() {
		return tenmon;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}

	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public String getDonvitinh() {
		return donvitinh;
	}
	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getGiatien() {
		return giatien;
	}
	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}
	public String getIdanhmon() {
		return idanhmon;
	}

	@Override
	public String toString() {
		return "monan [idmon=" + idmon + ", tenmon=" + tenmon + ", tenloai=" + tenloai + ", donvitinh=" + donvitinh
				+ ", soluong=" + soluong + ", giatien=" + giatien + ", idanhmon=" + idanhmon + "]";
	}
      
}
