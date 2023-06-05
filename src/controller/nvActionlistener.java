package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import model.nhanvien;
import view.MainView;

public class nvActionlistener implements ActionListener {
	   public static ArrayList<nhanvien> listnv= new ArrayList<>();
	   public static String idanh_nv;
	   public static int id_nv_STT=-1;
	@Override
	public void actionPerformed(ActionEvent e) {
		String nguonsukien=e.getActionCommand();
		if (nguonsukien.equals("Thêm ảnh"))
		{
			JFileChooser fileChooser=new JFileChooser();
			FileNameExtensionFilter imageFilter=new FileNameExtensionFilter("Định dạng ảnh", "jpg","png");
			fileChooser.setFileFilter(imageFilter);
			fileChooser.setMultiSelectionEnabled(false);
			int x=fileChooser.showDialog(null, "chọn file");
			if(x==JFileChooser.APPROVE_OPTION)
			{
				File f=fileChooser.getSelectedFile();
				ImageIcon icon=new ImageIcon(f.getAbsolutePath());
				Image image=icon.getImage();
				Image imagenew=image.getScaledInstance(MainView.lb_anhnv.getWidth(), MainView.lb_anhnv.getHeight(), image.SCALE_SMOOTH);
			    icon=new ImageIcon(imagenew);
			    idanh_nv=f.getAbsolutePath();
			    MainView.lb_anhnv.setIcon(icon);
				
			}
		}
//		 private int idnv;
//	      private String tennv;
//	      private LocalDate ngaysinh;
//	      private int sdt;
//	      private String diachi;
//	  
//	      private String taikhoan;
//	      private String matkhau;
//	      private String chucvu;
//	      private String idanhnv;
		else if (nguonsukien.equals("Thêm"))
		{   
			
			
				String t=MainView.txId_nhanvien.toString();
//				int idnv=Integer.parseInt(MainView.txId_nhanvien.getText());
//				nhanvien nv_check=getNhanVien_byID(idnv+"");
				String id_nv=taoMaAuto();
				String tennv=MainView.tx_tennv.getText();
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				String ngaysinh=df.format(MainView.chooser_ngaysinh.getDate());
				String sdt=MainView.tx_sdt.getText();
				String diachi=MainView.tx_diachi.getText();
				String taikhoan=MainView.tx_taikhoan.getText();
				String matkhau=MainView.tx_matkhau.getText();
				String chucvu=MainView.tx_chucvu.getText();
				String idanh_nv_check=idanh_nv;
				idanh_nv=null;
				
				DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_nhanvien.getModel();
			    String []DATA= {id_nv,tennv,ngaysinh,sdt,diachi,chucvu,taikhoan,matkhau};
			    nhanvien nv1=new nhanvien(id_nv, tennv, ngaysinh, sdt, diachi, taikhoan, matkhau, chucvu, idanh_nv_check);
			    if(checkAccount(nv1)==false)
			    {
			    listnv.add(nv1);
			    tblmodel.addRow(DATA);
			    xoainfo();
			    printlist();
			    String sql="insert into nhanvien values('"+id_nv+"','"+tennv+"','"+ngaysinh+"','"+sdt+"','"+diachi+"','"+taikhoan+"','"+matkhau+"','"+chucvu+"','"+idanh_nv_check+"'"+")";
			    RunUpdateSql(sql);
			    }
			    else JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản khác hoặc số điện thoại khác!");
			
		    
			
		}
		else if (nguonsukien.equals("Xóa"))
		{   
			int idnv=Integer.parseInt(MainView.txId_nhanvien.getText().substring(2));
			listnv.remove(getNhanVien_byID(idnv+""));
			String sql="delete nhanvien where manv='"+MainView.txId_nhanvien.getText()+"'";
		    RunUpdateSql(sql);
			xoainfo();
			DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_nhanvien.getModel();
			int idselectedrow=MainView.table_nhanvien.getSelectedRow();
			tblmodel.removeRow(idselectedrow);
			System.out.print("Xoa thanh cong");
		
			printlist();
		}
		else if (nguonsukien.equals("Sửa"))
		{   int idselectedrow=MainView.table_nhanvien.getSelectedRow();
			String t=MainView.txId_nhanvien.toString();
			String idnv=MainView.txId_nhanvien.getText();
			String tennv=MainView.tx_tennv.getText();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			String ngaysinh=df.format(MainView.chooser_ngaysinh.getDate());
			String sdt=MainView.tx_sdt.getText().replaceAll(" ", "");
			String diachi=MainView.tx_diachi.getText();
			String taikhoan=MainView.tx_taikhoan.getText();
			String matkhau=MainView.tx_matkhau.getText();
			String chucvu=MainView.tx_chucvu.getText();
			String idanh_nv_check=idanh_nv;
			nhanvien nv_check=getNhanVien_byID(idnv+"");
		    if(checkAccount2(nv_check)==1)
		    {
		    	nv_check.setIdnv(idnv+"");
				nv_check.setTennv(tennv);
				nv_check.setNgaysinh(ngaysinh);
				nv_check.setSdt(sdt);
				nv_check.setDiachi(diachi);
				nv_check.setTaikhoan(taikhoan);
				nv_check.setMatkhau(matkhau);
				nv_check.setChucvu(chucvu);
				nv_check.setIdanhnv(idanh_nv_check);
				idanh_nv="";
				DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_nhanvien.getModel();
//			    String []DATA= {idnv+"",tennv,ngaysinh,sdt,diachi,taikhoan,matkhau,chucvu,idanh_nv_check};
			    
			    
			    tblmodel.setValueAt(idnv, idselectedrow, 0);
			    tblmodel.setValueAt(tennv, idselectedrow, 1);
			    tblmodel.setValueAt(ngaysinh, idselectedrow, 2);
			    tblmodel.setValueAt(sdt, idselectedrow, 3);
			    tblmodel.setValueAt(diachi, idselectedrow, 4);
			    tblmodel.setValueAt(chucvu, idselectedrow, 5);
			    tblmodel.setValueAt(taikhoan, idselectedrow, 6);
			    tblmodel.setValueAt(matkhau, idselectedrow, 7);
			 
			    xoainfo();
			    printlist();
			    String sql="update nhanvien set manv='"+idnv+"',tennhanvien='"+tennv+"',ngaysinh='"+ngaysinh+"',sodienthoai='"+sdt+"',diachi='"+diachi+"',taikhoan='"+taikhoan+"',matkhau='"+matkhau+"',chucvu='"+chucvu+"',idanh_nv='"+idanh_nv_check+"' where manv='"+idnv+"'";
			    RunUpdateSql(sql);
		    }
		    else JOptionPane.showMessageDialog(null, "Vui lòng nhập tài khoản khác!");
			
		}
		
		
		
	}
	public void printlist()
	{
		for (nhanvien o : listnv) {
			System.out.println(o.toString());
		}
	}
	public void xoainfo()

	{   idanh_nv=null;
		MainView.tx_tennv.setText("");
		MainView.txId_nhanvien.setText("");
		MainView.chooser_ngaysinh.setCalendar(null);	
		MainView.tx_sdt.setText("");
		MainView.tx_diachi.setText("");
		MainView.tx_taikhoan.setText("");
		MainView.tx_matkhau.setText("");
		MainView.tx_chucvu.setText("");
		MainView.txId_nhanvien.setText("");
		MainView.lb_anhnv.setIcon(null);
		
	}
	public static nhanvien getNhanVien_byID(String id)
	{  
		for (nhanvien o : nvActionlistener.listnv) {
			if(o.getIdnv().equals(id))
			{
				return o;
			}
		}
		return  null;
	}
	public void RunUpdateSql(String sql)
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1=sql;	
			int rs=stmt.executeUpdate(sql1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void RunSql(String sql)
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1=sql;	
			ResultSet rs=stmt.executeQuery(sql1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addToTable()
	{
		for (nhanvien nhanvien : listnv) {
			
		}
	}
	public static void RunDatabase_nv()
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1="Select *from nhanvien";	
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next())
			{
				String manv=rs.getString(1).trim();
		        String tennv=rs.getString(2).trim();
		        String ngaysinh=rs.getString(3);
		        String sdt=rs.getString(4).trim();
		        String diachi=rs.getString(5);
		        String chucvu=rs.getNString(6).trim();
		        String taikhoan=rs.getString(7).trim();
		        String matkhau=rs.getString(8).trim();
		        String idanh_nv=rs.getString(9);
		        DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_nhanvien.getModel();
//		        String Data[]= {manv+"",tennv,ngaysinh,sdt,diachi,chucvu,taikhoan,matkhau,idanh_nv};
//		        nhanvien nv_add=new nhanvien(manv, tennv, ngaysinh, sdt, diachi, taikhoan, matkhau, chucvu, idanh_nv);
//		        listnv.add(nv_add);
		        String []DATA= {manv,tennv,ngaysinh,sdt,diachi,chucvu,taikhoan,matkhau};
		        DefaultTableModel tblmodel1=(DefaultTableModel) MainView.table_nhanvien.getModel();
		        tblmodel1.addRow(DATA);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public static void runDB_first()
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1="Select *from nhanvien";	
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next())
			{
				String manv=rs.getString(1).trim();
		        String tennv=rs.getString(2).trim();
		        String ngaysinh=rs.getString(3);
		        String sdt=rs.getString(4).trim();
		        String diachi=rs.getString(5);
		        String chucvu=rs.getNString(6).trim();
		        String taikhoan=rs.getString(7).trim();
		        String matkhau=rs.getString(8).trim();
		        String idanh_nv=rs.getString(9);
		   
//		        String Data[]= {manv+"",tennv,ngaysinh,sdt,diachi,chucvu,taikhoan,matkhau,idanh_nv};
		        nhanvien nv_add=new nhanvien(manv, tennv, ngaysinh, sdt, diachi, taikhoan, matkhau, chucvu, idanh_nv);
		        listnv.add(nv_add);
	
		    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public int getIdcuoi()
	{
		int id=listnv.size()-1;
		return id;
	}
	public String taoMaAuto()
	{   id_nv_STT++;
		String manv="NV"+id_nv_STT;
		return manv;
	}
	public boolean checkAccount(nhanvien nv)
	{
		for (nhanvien o : listnv) {
			if(nv.getSdt().equals( o.getSdt())&&nv.getTaikhoan().equals(o.getTaikhoan()))
			{
				return true;
			}
		}
		return false;
	}
	public int checkAccount2(nhanvien nv)
	{   int dem=0;
		for (nhanvien o : listnv) {
			if(nv.getSdt().equals( o.getSdt())&&nv.getTaikhoan().equals(o.getTaikhoan()))
			{
				dem++;
			}
		}
		return dem;
	
	}


				}


