package model;

public class ban {
       private String idban;
       private String tenban;
       private String trangthai;
	public ban(String idban, String tenban, String trangthai) {
		super();
		this.idban = idban;
		this.tenban = tenban;
		this.trangthai =trangthai;
	}
	public String getIdban() {
		return idban;
	}
	public void setIdban(String idban) {
		this.idban = idban;
	}
	public String getTenban() {
		return tenban;
	}
	public void setTenban(String tenban) {
		this.tenban = tenban;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	@Override
	public String toString() {
		return "ban [idban=" + idban + ", tenban=" + tenban + ", trangthai=" + trangthai + "]";
	}
      
}
