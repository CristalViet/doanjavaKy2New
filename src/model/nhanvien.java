package model;

import java.sql.Date;
import java.time.LocalDate;

public class nhanvien {
      private String idnv;
      private String tennv;
      private String ngaysinh;
      private String sdt;
      private String diachi;
  
      private String taikhoan;
      private String matkhau;
      private String chucvu;
      private String idanhnv;

	public nhanvien(String idnv, String tennv, String ngaysinh, String sdt, String diachi, String taikhoan, String matkhau,
			String chucvu, String idanhnv) {
		super();
		this.idnv = idnv;
		this.tennv = tennv;
		this.ngaysinh = ngaysinh;
		this.sdt = sdt;
		this.diachi = diachi;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.chucvu = chucvu;
		this.idanhnv = idanhnv;
	}
	
	public nhanvien(String idnv) {
		super();
		this.idnv = idnv;
	}

	public String getIdnv() {
		return idnv;
	}
	public void setIdnv(String idnv) {
		this.idnv = idnv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getIdanhnv() {
		return idanhnv;
	}
	public void setIdanhnv(String idanhnv) {
		this.idanhnv = idanhnv;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	@Override
	public String toString() {
		return "nhanvien [idnv=" + idnv + ", tennv=" + tennv + ", ngaysinh=" + ngaysinh + ", sdt=" + sdt + ", diachi="
				+ diachi + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + ", chucvu=" + chucvu + ", idanhnv="
				+ idanhnv + "]";
	}
      
      
}
