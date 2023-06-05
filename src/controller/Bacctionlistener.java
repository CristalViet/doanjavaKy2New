package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.security.sasl.AuthorizeCallback;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import model.ban;

import model.hoadon;
import model.hoadon_ban;
import model.monan;
import model.nhanvien;
import view.MainView;
import view.PrintBill;

public class Bacctionlistener implements ActionListener {
   public static ArrayList<monan> listmonan= new ArrayList<>();
   public static ArrayList<hoadon> listhoadon= new ArrayList<>();
    public static ArrayList<hoadon_ban> listhoadonban=new ArrayList<>();
  
//   public static ArrayList<E>
 
   public static String idanh;
   public static int idrowselected=-1;
   public static double tongtien=0;
   public static int ID_hoadon=-1;
   
	@Override
	public void actionPerformed(ActionEvent e) {
		LoginAc.tennhanvienhientai=MainView.lb_TenNhanVienHienTai.getText();
		// TODO Auto-generated method stub	
		String nguonsukien=e.getActionCommand();
		if (nguonsukien.equals("Thực đơn"))
		{   
			 
			view.MainView.panelright.removeAll();
			view.MainView.panelright.add(MainView.panel_thucdon);
			view.MainView.panelright.updateUI();
		}
		else if (nguonsukien.equals("Thêm"))
			   
			
		{   int id;
		int soluong=0;
		double giatien=0;
		String idanh_them;
			MainView.idmon++;
		    MainView.txIDmon.setText(MainView.idmon+"");
		    id= MainView.idmon ;
		    	
		    String tenmon=MainView.txTenMon.getText();
		    String tenloai=MainView.comboBox_tenloai.getSelectedItem().toString();
		    String donvi=MainView.txDonvi.getText();
		    if(MainView.txSoluong.getText().equals("")||MainView.txGiatien.getText().equals(""))
		    {
		    	
		    } 
		    else {
		    	soluong=Integer.parseInt(MainView.txSoluong.getText()) ;
			     giatien=Double.parseDouble(MainView.txGiatien.getText());
		    }
		     
		     idanh_them=idanh;
		    String []DATA= {MainView.txIDmon.getText(),tenmon,tenloai,donvi,MainView.txSoluong.getText(),MainView.txGiatien.getText()};
		    monan mon=new monan(id, tenmon, tenloai, donvi, soluong, giatien, idanh_them);
		    if(checkTonTaiMonAn(mon)==true)
		    {
		    	JOptionPane.showMessageDialog(null,"Món ăn đã tồn tại trong hệ thống", "Thông báo", JOptionPane.ERROR_MESSAGE);
		    }
		    else 
		    {
		    DefaultTableModel tbl= (DefaultTableModel) MainView.table.getModel();
		    
		    tbl.addRow(DATA);
			
			String sql="Insert into monan "
					+ "values("+id+",N'"+tenmon+"',N'"+tenloai+"',N'"+donvi+"',"+soluong+","+giatien+",'"+idanh_them+"') ";
			excuteDB(sql);
			listmonan.add(mon);
			printlist();
			xoainfo();
			idrowselected=-1;
		    }
		}
		else if (nguonsukien.equals("Đặt bàn"))
		{
			view.MainView.panelright.removeAll();
			view.MainView.panelright.add(MainView.panel_datban);
			view.MainView.panelright.updateUI();
		}
		else if (nguonsukien.equals("Hóa đơn"))
		{   listhoadonban.clear();
            runDB_MonAnCuaHoaDon();
			view.MainView.panelright.removeAll();
			view.MainView.panelright.add(MainView.panel_hoadon);
	        
		    MainView.table_hoadon.setVisible(false);
		    MainView.scrollPane_hoadon.setVisible(false);
			view.MainView.panelright.updateUI();
			DsBanActionListener.dsban.clear();
			MainView.addBanfromDB();
			for (ban ban : DsBanActionListener.dsban) {
				if(ban.getTrangthai().equals("Có khách"))
				{
					int indexban= Integer.parseInt(ban.getIdban().substring(3));
				    MainView.ban[indexban-1].setIcon(MainView.icon1);
				}	
			}


		}
		if (nguonsukien.equals("Ds bàn hiện tại"))
		{
			view.MainView.panelright.removeAll();
			view.MainView.panelright.add(MainView.panel_danhsachbanhientai);
			view.MainView.panelright.updateUI();
			
			
		}
		
		else if (nguonsukien.equals("Doanh thu"))
		{
			view.MainView.panelright.removeAll();
			view.MainView.panelright.add(MainView.panel_doanhthu);
			listhoadon.clear();
			runDB_HoaDon();
			
			addHoaDonVaoDoanhThu();
			MainView.comboBox_xemngay.setEnabled(false);
			MainView.comboBox_xemthang.setEnabled(false);
			MainView.tx_xemnam.setEnabled(false);
			view.MainView.panelright.updateUI();
		}
		else if (nguonsukien.equals("Nhân viên"))
		{   
			if(LoginAc.tennhanvienhientai.equals("admin"))
			{
				view.MainView.panelright.removeAll();
				view.MainView.panelright.add(MainView.panel_nhanvien);
				view.MainView.panelright.updateUI();
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Bạn không có đủ quyền để truy cập mục này");
			}
			
			
		}
		else if (nguonsukien.equals("DS bàn"))
		{
			view.MainView.panelright.removeAll();
			view.MainView.panelright.add(MainView.panel_danhsachban);
			view.MainView.panelright.updateUI();
		}
		
		else if(nguonsukien.equals("Thêm ảnh"))
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
				Image imagenew=image.getScaledInstance(MainView.anhdoan.getHeight(), MainView.anhdoan.getWidth(), image.SCALE_SMOOTH);
			    icon=new ImageIcon(imagenew);
			    idanh=f.getAbsolutePath();
				MainView.anhdoan.setIcon(icon);
			}
			
		
		}
		else if(e.getSource().equals(MainView.b_hoadon_themmon))
			
		{  
			String check_soluong=MainView.tx_hoadon_soluongdat.getText();
			
			if(isNumeric(check_soluong)==false||check_soluong.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Bạn phải nhập số và không được để trống");
			}
			else 
			{
				DsBanActionListener.dsban.clear();
				MainView.addBanfromDB();
				
				DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_hoadon.getModel();
				tblmodel.setRowCount(0);
				String mamon=MainView.tx_hoadon_mamon.getText();
				String tenmon=MainView.comboBox_monan.getSelectedItem().toString();
				double tien=Double.parseDouble(MainView.tx_hoadon_giatien.getText());
				int soluong=Integer.parseInt(MainView.tx_hoadon_soluongdat.getText());
				
				if(soluong>checkSoLuongMon(tenmon))
				{
					JOptionPane.showMessageDialog(null, "Thêm không thành công vì vượt quá số lượng");
				}
				else
				{
					ban ban_test=DsBanActionListener.returnBanByID(DsBanActionListener.idbanselected);
//					System.out.println(ban_test.getIdban());
					hoadon_ban hoadon_test=new hoadon_ban(ban_test.getIdban(), mamon, tenmon, tien, soluong);
			       
			       
					monan mon_test=new monan(tenmon);
					 mon_test=getMonAnByName(mon_test);
					 mon_test.setSoluong(mon_test.getSoluong()-soluong);
					 MainView.tx_hoadon_soluongcon.setText(mon_test.getSoluong()+"");
					if(checkMonAntrongHoadon(hoadon_test)==true)
					{   
						System.out.println("test");
						 hoadon_ban hoadon_ban=returnMonAnTrongHoaDon(hoadon_test);
						 hoadon_ban.setSoluong(soluong+hoadon_ban.getSoluong());
						 
						 System.out.println(hoadon_ban.toString());
						 nhapvaoTable_hoadon(ban_test);
							tongtien=tinhtien(ban_test);
							String sql="Update moncuaban set soluong="+hoadon_ban.getSoluong()+" where idban='"+hoadon_ban.getIdban()+"' and mamon='"+hoadon_ban.getIdmon()+"';";
							excuteUpdateDB(sql);
							
						MainView.lb_tongtien_hoadon.setText(tongtien+"");
					}
					else 
					{
						listhoadonban.add(hoadon_test);
						nhapvaoTable_hoadon(ban_test);

						tongtien=tinhtien(ban_test);
						MainView.lb_tongtien_hoadon.setText(tongtien+"");
					
					    
					    ban_test.setTrangthai("Có khách");
					    MainView.updateBan(ban_test.getIdban(), ban_test.getTenban(),"Có khách");
			            String sql="insert into moncuaban values ('"+hoadon_test.getIdban()+"','"+hoadon_test.getIdmon()+"',N'"+hoadon_test.getTenmon()+"','"+hoadon_test.getGiatien()+"','"+hoadon_test.getSoluong()+"')";

					    excuteUpdateDB(sql);
					}
					 String sql2="update monan "
								+ "set ID="+mon_test.getIdmon()+",tenmon=N'"+mon_test.getTenmon()+"',tenloai=N'"+mon_test.getTenloai()+"',donvi='"+mon_test.getDonvitinh()+"',soluong="+mon_test.getSoluong()+",dongia="+mon_test.getGiatien()+",idanh='"+mon_test.getIdanhmon()+"'	"
										+ "where id="+mon_test.getIdmon();
					 excuteUpdateDB(sql2);
					MainView.tx_hoadon_soluongdat.setText("");
			}
			
			
			}
			
//			ban ban_test= DsBanActionListener.returnBanByID(DsBanActionListener.idbanselected);
//			System.out.println(ban_test.toString());
//			hoadon_ban moncuaban=new hoadon_ban(ban_test.getIdban(), mamon, tenmon,tien, soluong);
//			if(checkMonAntrongHoadon(moncuaban)==true)
//			{   
//				hoadon_ban hoadon_ban= returnMonAnTrongHoaDon(moncuaban);
//				int soluongmon=hoadon_ban.getSoluong();
//				hoadon_ban.setSoluong(soluong+soluongmon);
//				nhapvaoTable_hoadon(ban_test);
////				printlistMonAncuaban();
//			
//				
//				
//				tongtien=tinhtien(ban_test);
//				MainView.lb_tongtien_hoadon.setText(tongtien+"");
//
//			}
//			else
//			{   
//				listhoadonban.add(moncuaban);
//				nhapvaoTable_hoadon(ban_test);
//
//				tongtien=tinhtien(ban_test);
//				MainView.lb_tongtien_hoadon.setText(tongtien+"");
//			
//			    
//			    ban_test.setTrangthai("Có khách");
//			    MainView.updateBan(ban_test.getIdban(), ban_test.getTenban(),"Có khách");
//			
//				Bacctionlistener.printlistMonAncuaban();
//			}
		
			
		}
		else if(nguonsukien.equals("Thanh toán"))
				{ 
			     try {
			    	 double tienthua=Double.parseDouble(MainView.lb_tienthua_hoadon.getText()) ;
					  ban ban_test= DsBanActionListener.returnBanByID(DsBanActionListener.idbanselected);
					     if(ban_test.getTrangthai().equals("Có khách"))
					     {   
					    	 if(tienthua>=0)
					    	 {   DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_hoadon.getModel();
								tblmodel.setRowCount(0);
							     
					    		 JOptionPane.showMessageDialog(null, "Thanh toán thành công");
						    	 ban_test.setTrangthai("Trống");
						    	 xoaHoaDonCuaban(ban_test);
						    	 int indexban= Integer.parseInt(DsBanActionListener.idbanselected.substring(3));
								    MainView.ban[indexban-1].setIcon(MainView.icon3);
								    MainView.updateBan(ban_test.getIdban(), ban_test.getTenban(), ban_test.getTrangthai());
										  //taobill
												
											taoHoaDon(ban_test.getIdban(),MainView.lb_TenNhanVienHienTai.getText(), tongtien);
										//
								    tongtien=0;
									MainView.lb_tongtien_hoadon.setText(tongtien+"");
									
									xoaHoaDonCuaban(ban_test);
									String sql="delete from moncuaban where idban='"+DsBanActionListener.idbanselected+"'"+ ";";
									excuteUpdateDB(sql);
									MainView.tx_hoadon_tienkhach.setText("");
								    
					    	 }
					    	 else JOptionPane.showMessageDialog(null, "Không thể thanh toán vì tiền trả không đủ");
					    	  
								
					     }
					     else JOptionPane.showMessageDialog(null, "Không thể thanh toán vì bàn trống");
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Khong được để trống phần tiền khách trả");
				}
				
				  
			 
			     
				    
					
					
				}
		else if(e.getSource().equals(MainView.b_deleteInfo))
		{
			MainView.txId_nhanvien.setText("");
			MainView.tx_datban_sodienthoai.setText("");
			MainView.tx_tennv.setText("");
			MainView.tx_diachi.setText("");
			MainView.tx_taikhoan.setText("");
			MainView.tx_matkhau.setText("");
			MainView.tx_chucvu.setText("");
			MainView.lb_anhnv.setIcon(null);
			MainView.chooser_ngaysinh.setDate(null);
			MainView.tx_sdt.setText("");
		}
		// chuc nang Xoa
		else if (nguonsukien.equals("Xóa"))
		{
			int id=Integer.parseInt(MainView.txIDmon.getText());
		    System.out.println(id);
		    DefaultTableModel tbl= (DefaultTableModel) MainView.table.getModel();
		    String sql="delete from Monan "
		    		+ "where id="+id;
		    tbl.removeRow(idrowselected);
		    //Doan nay se getIndex cua phan tu do trong listmonan ra de listmonan xoa theo Index
		    
		    listmonan.remove(getListmonan_idIndex(id));
		    
		    excuteUpdateDB(sql);
		    xoainfo();
				printlist();
				
			idrowselected=-1;
		}
		else if (nguonsukien.equals("Sửa"))
		{   
			try {
				Locale localeVN = new Locale("vi", "VN");
			    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
				int id=Integer.parseInt(MainView.txIDmon.getText());
			    String tenmon=MainView.txTenMon.getText();
			    String tenloai=MainView.comboBox_tenloai.getSelectedItem().toString();
			    String donvi=MainView.txDonvi.getText();
			    int soluong=Integer.parseInt(MainView.txSoluong.getText()) ;
			    double giatien=Double.parseDouble(MainView.txGiatien.getText());
			    String idanh_them=idanh;
			    String []DATA= {MainView.txIDmon.getText(),tenmon,tenloai,MainView.txSoluong.getText(),donvi,MainView.txGiatien.getText()};
			    DefaultTableModel tbl= (DefaultTableModel) MainView.table.getModel();
			    
			    monan monan_check= getmonan(id);
			    //Chỉnh sửa thông tin món an trong arraylist
			    
			    monan_check.setDonvitinh(donvi);
			    
			    monan_check.setGiatien(giatien);
			    
			
			    monan_check.setSoluong(soluong);
			    
			    monan_check.setTenloai(tenloai);
			    monan_check.setTenmon(tenmon);
			    
			    int tblselectedrow=MainView.table.getSelectedRow();
			    tbl.setValueAt(MainView.txIDmon.getText(),tblselectedrow, 0);
			    tbl.setValueAt(MainView.txTenMon.getText(), tblselectedrow, 1);
			    tbl.setValueAt(MainView.comboBox_tenloai.getSelectedItem().toString(), tblselectedrow, 2);
			    tbl.setValueAt(MainView.txDonvi.getText(), tblselectedrow, 3);
			    tbl.setValueAt(MainView.txSoluong.getText(), tblselectedrow, 4);
			    tbl.setValueAt(currencyVN.format(monan_check.getGiatien())  , tblselectedrow, 5);
			    if(idanh!=null)
			    {
			        monan_check.setIdanhmon(idanh_them);
			    }
				String sql="update monan "
						+ "set ID="+id+",tenmon=N'"+tenmon+"',tenloai=N'"+tenloai+"',donvi='"+donvi+"',soluong="+soluong+",dongia="+giatien+",idanh='"+idanh_them+"'	"
								+ "where id="+id;
				xoainfo();
				printlist();
				idrowselected=-1;
				excuteUpdateDB(sql);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		else if(nguonsukien.equals("Tìm"))
				{     
			DefaultTableModel tblmodel=(DefaultTableModel) MainView.table.getModel();
			            if(MainView.TxTimKiem.getText().equals(""))
			            {   tblmodel.setRowCount(0);
			            	listmonan.clear();
			            	MainView.khoitaodulieuDB();
			            }
			            else {
			            	
			            	tblmodel.setRowCount(0);
			            	for (monan o : listmonan) {
								{
									if(o.getTenmon().contains(MainView.TxTimKiem.getText())==true)
									{
										int id=o.getIdmon();
									    String tenmon=o.getTenmon();
									    String tenloai=o.getTenloai();
									    String donvi=o.getDonvitinh();
									    int soluong=o.getSoluong();
									    double giatien=o.getGiatien();
									    String idanh_them=o.getIdanhmon();
									    String []DATA= {id+"",tenmon,tenloai,donvi,soluong+"",giatien+"",idanh};
									    tblmodel.addRow(DATA);
									}
								}
			            }
			            	
			            
			            }
			   }
		else if(e.getSource().equals(MainView.b_capnhapsoluong))
		{  
			String tenmon=MainView.comboBox_monan.getSelectedItem().toString();
			 String idban=DsBanActionListener.idbanselected;
		     String mamon=MainView.tx_hoadon_mamon.getText();
			monan mon_test=new monan(tenmon);
			 mon_test=getMonAnByName(mon_test);
			 int soluong=Integer.parseInt(MainView.tx_hoadon_soluongdat.getText()) ;
			 DefaultTableModel tbl=(DefaultTableModel) MainView.table_hoadon.getModel();
			 int idrow= MainView.table_hoadon.getSelectedRow();
			 int soluongbandau=Integer.parseInt(tbl.getValueAt(idrow, 3).toString()) ;
			 int SoLuongthaydoi= soluong-soluongbandau;
		     mon_test.setSoluong(mon_test.getSoluong()-SoLuongthaydoi);
		     
			 tbl.setValueAt(soluong, idrow, 3);
			 
			 //tinhtien
			 ban ban_test=DsBanActionListener.returnBanByID(DsBanActionListener.idbanselected);
			 
			 
		    
	
		     
		     
			 hoadon_ban hoadon_test=new hoadon_ban(ban_test.getIdban(), mamon, tenmon, mon_test.getGiatien(), soluong);
			 if(checkMonAntrongHoadon(hoadon_test)==true)
			 {
				  hoadon_test=returnMonAnTrongHoaDon(hoadon_test);
				  hoadon_test.setSoluong(soluong);
				  String sql="Update moncuaban set soluong="+hoadon_test.getSoluong()+" where idban='"+hoadon_test.getIdban()+"' and mamon='"+hoadon_test.getIdmon()+"';";
				  System.out.println("Tai day");
				  printlistMonAncuaban();
				  //cap nhap so luong mon an co san
				  String sql2="update monan "
							+ "set ID="+mon_test.getIdmon()+",tenmon=N'"+mon_test.getTenmon()+"',tenloai=N'"+mon_test.getTenloai()+"',donvi='"+mon_test.getDonvitinh()+"',soluong="+mon_test.getSoluong()+",dongia="+mon_test.getGiatien()+",idanh='"+mon_test.getIdanhmon()+"'	"
									+ "where id="+mon_test.getIdmon();
				  tongtien=tinhtien(ban_test);
					 MainView.lb_tongtien_hoadon.setText(tongtien+"");
					 MainView.tx_hoadon_soluongcon.setText(mon_test.getSoluong()+"");
					excuteUpdateDB(sql);
					excuteUpdateDB(sql2);
			 }
			
				
			
			 
	 }
		
		else if(e.getSource().equals(MainView.b_xoathu))
		{
		
			String tenmon=MainView.comboBox_monan.getSelectedItem().toString();
			
			monan mon_test=new monan(tenmon);
			 mon_test=getMonAnByName(mon_test);
			 
			 DefaultTableModel tbl=(DefaultTableModel) MainView.table_hoadon.getModel();
			 int idrow= MainView.table_hoadon.getSelectedRow();
			
		    
			 int soluongbandau=Integer.parseInt(tbl.getValueAt(idrow, 3).toString()) ;
		     mon_test.setSoluong(mon_test.getSoluong()+soluongbandau);
		     System.out.println(DsBanActionListener.idbanselected);
		     
		     xoaMonAnTrongHoaDon(DsBanActionListener.idbanselected, mon_test.getIdmon()+"");
		     tbl.removeRow(idrow);
			 printlistMonAncuaban();
			 ban ban_test=DsBanActionListener.returnBanByID(DsBanActionListener.idbanselected);
			 tongtien=tinhtien(ban_test);
			 MainView.lb_tongtien_hoadon.setText(tongtien+"");
			 MainView.tx_hoadon_soluongcon.setText(mon_test.getSoluong()+"");
			 String sql="delete from moncuaban where idban='"+DsBanActionListener.idbanselected+"' and mamon='"+mon_test.getIdmon()+"';";
			 String sql2="update monan "
						+ "set ID="+mon_test.getIdmon()+",tenmon=N'"+mon_test.getTenmon()+"',tenloai=N'"+mon_test.getTenloai()+"',donvi='"+mon_test.getDonvitinh()+"',soluong="+mon_test.getSoluong()+",dongia="+mon_test.getGiatien()+",idanh='"+mon_test.getIdanhmon()+"'	"
								+ "where id="+mon_test.getIdmon();
			 excuteUpdateDB(sql);
			 excuteUpdateDB(sql2);
		}
		else if(e.getSource().equals(MainView.b_inBill))
		{   
			
		    
		    try {
		    	double tienthua=Double.parseDouble(MainView.lb_tienthua_hoadon.getText()) ;
				if(tienthua>=0)
				{
					new PrintBill();
					
				}
				else JOptionPane.showMessageDialog(null, "Số dư không đủ vui lòng nhập lại");
			} catch (Exception e2) {
				System.out.println("Số dư không đủ vui lòng nhập lại");
			}
			
			
		}
		else if (e.getSource().equals(MainView.b_thongtin))
		{
			view.MainView.panelright.removeAll();
		    view.MainView.panelright.add(MainView.panel_thongtin);
			view.MainView.panelright.updateUI();
		}
		 
	
		
		
			
			 
		
		
		
	
		
	}
	public static void printlist() {
		for (monan o : listmonan) {
			System.out.println(o);
		}
	}	
	public static void printlistMonAncuaban() {
		for (hoadon_ban o : listhoadonban) {
			System.out.println(o);
		}
	}
	//get phần tử món ăn qua id mon an;
	public static monan getmonan(int id)
	{  for (monan o : listmonan) {
		if(id==o.getIdmon())
			return o;
	}
	return null;
		
	}
	public void xoainfo()
	{   idanh=null;
		MainView.txIDmon.setText("");
		MainView.txTenMon.setText("");
		MainView.txDonvi.setText("");
		MainView.txGiatien.setText("");
		MainView.txSoluong.setText("");
		MainView.anhdoan.setIcon(null);
	}
	
	public static void runDB_MonAnCuaHoaDon()
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1="Select *from moncuaban";	
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next())
			{
				String maban=rs.getString(1).trim();
				String mamon=rs.getString(2).trim();
				String tenmon=rs.getNString(3).trim();
				double giatien=rs.getDouble(4);
				int soluong=rs.getInt(5);
		        hoadon_ban hoadon_ban=new hoadon_ban(maban, mamon, tenmon, giatien, soluong);
		        listhoadonban.add(hoadon_ban);

		      
	
		    
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
	
	public static void excuteDB(String sql)
	{
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
	 		String user="viet2";
	 		String pass="123";
	 		try {
	 			Class.forName(driverName);
	 			Connection con=DriverManager.getConnection(url, user, pass);
	 			Statement stmt=con.createStatement();
	 			String sql1=sql;
               ResultSet smt=stmt.executeQuery(sql1);
	 		         //duyet tung dong trong result
	 		    
	 		        
	 		} catch (ClassNotFoundException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		
	 		
	 			
	 		 catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	}
	public static void excuteUpdateDB(String sql)
	{
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
	 		String user="viet2";
	 		String pass="123";
	 		try {
	 			Class.forName(driverName);
	 			Connection con=DriverManager.getConnection(url, user, pass);
	 			Statement stmt=con.createStatement();
	 			String sql1=sql;
               int smt=stmt.executeUpdate(sql1);
	 		         //duyet tung dong trong result
	 		    
	 		        
	 		} catch (ClassNotFoundException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 		
	 		
	 			
	 		 catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	}
	//dòng này sẽ lấy index của phần tử đó trong arraylist món an
	public int getListmonan_idIndex(int id)
	{
		for (monan o : listmonan) {
			if(o.getIdmon()==id)
			{
				return listmonan.indexOf(o);
			}
		}
		return id;
	}
	//check phan tu co tontai khong
	public boolean checkMonan(int id)
	{
		for (monan o : listmonan) {
			if(o.getIdmon()==id)
			{
				return true;
			}
		}
		return false;
	}
	public static int getIDcuoi()
	{   
	    if(listmonan.size()>0)
	    {
	    	monan monan_check=	listmonan.get(listmonan.size()-1);
			return monan_check.getIdmon();
	    }
	    return -1;
		
	}
	public static monan getMonAnByName(monan mon)
	{
		for (monan o : listmonan) {
			if(o.getTenmon().equalsIgnoreCase(mon.getTenmon()))
			{
				return o;
			}
		}
		return null;
	}
	public boolean checkTonTaiMonAn(monan monan)
	{
		for (monan o : listmonan) {
			if(monan.getTenmon().equalsIgnoreCase(o.getTenmon()))
			{
				return true;
			}
		}
		return false;
	}
	public boolean checkMonAntrongHoadon(hoadon_ban monan_ban)
	{
		for (hoadon_ban hoadon_test : listhoadonban) {
			if(monan_ban.getIdban().equals(hoadon_test.getIdban())&&monan_ban.getIdmon().equals(hoadon_test.getIdmon()))
			{    
				System.out.println(hoadon_test.toString());
				return true;
			}
		}
		return false;
	}
	public static double tinhtien(ban ban)
	{   double Bill=0;
		for (hoadon_ban hoadon : listhoadonban) {
			if(ban.getIdban().equals(hoadon.getIdban()))
			{
				Bill+=hoadon.getGiatien()*hoadon.getSoluong();
			}
		}
		return Bill;
	}
	public static void nhapvaoTable_hoadon(ban ban)
	{ DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_hoadon.getModel();
	   tblmodel.setRowCount(0);
		for (hoadon_ban hoadon : listhoadonban) {
			if(ban.getIdban().equals(hoadon.getIdban()))
			{
				
				String []DATA= {hoadon.getIdmon(),hoadon.getTenmon(),hoadon.getGiatien()+"",hoadon.getSoluong()+""};
				tblmodel.addRow(DATA);
			}
		
		}
	}
	public static hoadon_ban returnMonAnTrongHoaDon(hoadon_ban hoadon)
	
	{
		 for (hoadon_ban hoadon_test : listhoadonban) {
			if(hoadon_test.getIdmon().equals(hoadon.getIdmon())&&hoadon.getIdban().equals(hoadon_test.getIdban()))
			{
				return hoadon_test;
			}
		}
		 return null;
	}
	public static void xoaHoaDonCuaban (ban ban_test)
	{
		for (hoadon_ban hoadon : listhoadonban) {
			  if(ban_test.equals(hoadon.getIdban()))
			  {
				  listhoadonban.remove(hoadon);
			  }
		}
	}
	
//	public static void xoaMonCuaBan(String tenmon,String idban)
//	{   
//		for (hoadon_ban hoadon : listhoadonban) {
//			if(idban.equals(hoadon.getIdban())&&tenmon.equals(hoadon.getTenmon()))
//			{
//				listhoadonban.remove(hoadon);
//			}
//		}
//	}
	public static void xoaMonAnTrongHoaDon(String idban,String idmon)
	{
		for(hoadon_ban hoadon : listhoadonban)
		{
			if(idban.equals(hoadon.getIdban())&&idmon.equals(hoadon.getIdmon()))
			{
				listhoadonban.remove(hoadon);
				return;
				
			}
		}
	}
	
	public static int checkSoLuongMon(String tenmon)
	{   
		monan mon_test=new monan(tenmon);
		mon_test=getMonAnByName(mon_test);
		return mon_test.getSoluong();
	}
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	public static void taoHoaDon(String tenban, String tennhanvien,double tongtien)
	{   
		Date ngay=new Date();
	    ID_hoadon++;
		DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		
		hoadon hoadon=new hoadon("HD"+ID_hoadon, tenban, tennhanvien, tongtien, dateformat.format(ngay));
		Bacctionlistener.addHoaDonVaoCSDL("HD"+ID_hoadon, tenban, tennhanvien, tongtien, dateformat.format(ngay));
		listhoadon.add(hoadon);
		for (hoadon o : listhoadon) {
			System.out.println(o);
		}
	}
	
	
	public static void addHoaDonVaoDoanhThu()
	{    DefaultTableModel tbl=(DefaultTableModel) MainView.table_doanhthu.getModel();
	         tbl.setRowCount(0);
	         Locale localeVN = new Locale("vi", "VN");
		      NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	         
		for (hoadon hoadon : listhoadon) {
			 String[]Data= {hoadon.getMahoadon(),hoadon.getTenban(),hoadon.getTenhanvien(),currencyVN.format(hoadon.getTienhang()) +"",hoadon.getNgaythanhtoan()};
			tbl.addRow(Data);
			ComboBox_actionlistener.tienthuve+=hoadon.getTienhang();
			ComboBox_actionlistener.tongdonbanra++;
		}
		MainView.tienthuve.setText(currencyVN.format(ComboBox_actionlistener.tienthuve));
		MainView.tonghoadon.setText(ComboBox_actionlistener.tongdonbanra+" Đơn");
		ComboBox_actionlistener.tienthuve=0;
		ComboBox_actionlistener.tongdonbanra=0;
		
	}
	public static void addHoaDonVaoCSDL(String idhoadon,String idban,String tennhanvien,double tienhang,String ngaythangnam)
	{
		String sql="insert into hoadon values('"+idhoadon+"','"+idban+"',N'"+tennhanvien+"','"+tienhang+"','"+ngaythangnam+"')";
		excuteUpdateDB(sql);
		
	}
	
	public static void runDB_HoaDon()
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1="Select *from hoadon";	
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next())
			{
				String idhoadon=rs.getString(1).trim();
				String idban=rs.getString(2).trim();
				String tennhanvien=rs.getNString(3).trim();
				double tienhang=rs.getDouble(4);
				String ngaythangnam=rs.getString(5).trim();
		        hoadon hoadon_test=new hoadon(idhoadon, idban, tennhanvien, tienhang, ngaythangnam);
		        listhoadon.add(hoadon_test);

		      
	
		    
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
	
	
 
}
