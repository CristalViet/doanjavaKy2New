package model;

public class dondat {
      private String madondat;
      private String tenkhachhang;
      private String sodienthoai;
      private String maban;
      private String ngaydat;
      private String ghichu;
	public dondat(String madondat, String tenkhachhang, String sodienthoai, String maban, String ngaydat,
			String ghichu) {
		super();
		this.madondat = madondat;
		this.tenkhachhang = tenkhachhang;
		this.sodienthoai = sodienthoai;
		this.maban = maban;
		this.ngaydat = ngaydat;
		this.ghichu = ghichu;
	}
	public String getMadondat() {
		return madondat;
	}
	public void setMadondat(String madondat) {
		this.madondat = madondat;
	}
	public String getTenkhachhang() {
		return tenkhachhang;
	}
	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getMaban() {
		return maban;
	}
	public void setMaban(String maban) {
		this.maban = maban;
	}
	public String getNgaydat() {
		return ngaydat;
	}
	public void setNgaydat(String ngaydat) {
		this.ngaydat = ngaydat;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	@Override
	public String toString() {
		return "dondat [madondat=" + madondat + ", tenkhachhang=" + tenkhachhang + ", sodienthoai=" + sodienthoai
				+ ", maban=" + maban + ", ngaydat=" + ngaydat + ", ghichu=" + ghichu + "]";
	}
      
}
