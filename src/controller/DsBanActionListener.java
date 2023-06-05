package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import model.ban;
import model.hoadon;
import model.hoadon_ban;
import model.monan;
import view.MainView;

public class DsBanActionListener implements ActionListener {
    public static ArrayList<ban> dsban=new ArrayList<>();
    public static int numRow_ban=0;
    public static String idbanselected="";
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String nguonsukien=e.getActionCommand();
		DsBanActionListener.dsban.clear();
		MainView.addBanfromDB();
	    Bacctionlistener.listhoadonban.clear();
	    Bacctionlistener.runDB_MonAnCuaHoaDon();

		for (ban ban : DsBanActionListener.dsban) {
			int indexban= Integer.parseInt(ban.getIdban().substring(3));
			if(ban.getTrangthai().equals("Có khách"))
			{
			
			    MainView.ban[indexban-1].setIcon(MainView.icon1);
			}
			else if(ban.getTrangthai().equals("Đã được chọn"))
			{
				
			    MainView.ban[indexban-1].setEnabled(false);
			}
			else 
				{
			
				 MainView.ban[indexban-1].setIcon(MainView.icon3);
				}
		}
		idbanselected="ban"+nguonsukien.substring(4);
	
		
		DefaultTableModel tbl=(DefaultTableModel) MainView.table_hoadon.getModel();
		 tbl.setRowCount(0);
		
		for (ban ban : dsban) {
			if(idbanselected.equals(ban.getIdban()))
				
			{ 
				

			    ban ban_test=ban;
			   
			    Bacctionlistener.tongtien=0;
			    MainView.lb_tongtien_hoadon.setText("0");
			    int indexban= Integer.parseInt(DsBanActionListener.idbanselected.substring(3));
			    MainView.ban[indexban-1].setIcon(MainView.icon2);
				if(	ban.getTrangthai().equals("Trống"))
				{
					
					  
				    MainView.table_hoadon.setVisible(true);
				    MainView.scrollPane_hoadon.setVisible(true);
					Bacctionlistener.printlistMonAncuaban();
				}
				else if(ban_test.getTrangthai().equals("Có khách")) {
					MainView.table_hoadon.setVisible(true);
				    MainView.scrollPane_hoadon.setVisible(true);
				    
				    JOptionPane.showMessageDialog(null, "Bàn "+nguonsukien+" Đã có khách", "thông báo",JOptionPane.INFORMATION_MESSAGE);
				    for (hoadon_ban hoadon_test : Bacctionlistener.listhoadonban) {
						if (ban_test.getIdban().equals(hoadon_test.getIdban()))
						{   	Bacctionlistener.tongtien=Bacctionlistener.tinhtien(ban_test);
					     	  MainView.lb_tongtien_hoadon.setText(Bacctionlistener.tongtien+"");
							String mamon=hoadon_test.getIdmon();
							String tenmon=hoadon_test.getTenmon();
							double giatien=hoadon_test.getGiatien();
							int soluong=hoadon_test.getSoluong();
							String[] Data= {mamon,tenmon,giatien+"",soluong+""};
							tbl.addRow(Data);
							Bacctionlistener.printlistMonAncuaban();
						
						}
					}
				    
				}
				
			}
//			JOptionPane.showMessageDialog(null, "Bạn đã nhấn chọn "+nguonsukien, "thông báo",JOptionPane.INFORMATION_MESSAGE);
		    
		
		}
	    
//		if(nguonsukien.equals("Thêm"))
//		{
//			String maban=autoID();
//			String tenban= MainView.tx_dsban_tenban.getText();
//			String trangthai="Trống";
//			
//		    ban bantest=new ban(maban, tenban, trangthai);
//		    dsban.add(bantest);
//		    DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_dsban.getModel();
//		    String DATA[]= {maban,tenban,trangthai};
//		    tblmodel.addRow(DATA);
//	         
//		   
//		    printList();
//			xoaInfo();
//			MainView.khoitaoCombox_datban();
//		}
//		else if(nguonsukien.equals("Xóa"))
//		{   
//			String id=MainView.tx_dsban_maban.getText();
//			ban ban_test= returnBanByID(id);
//		    dsban.remove(ban_test);
//		    System.out.println("Xoa thanh cong");
//		    DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_dsban.getModel();
//		    System.out.println(numRow_ban);
//		    tblmodel.removeRow(numRow_ban);
//		    numRow_ban=-1;
//		    printList();
//			MainView.khoitaoCombox_datban();
//		}
//		else if(nguonsukien.equals("Sửa"))
//		{   
//			String maban=MainView.tx_dsban_maban.getText();
//			String tenban= MainView.tx_dsban_tenban.getText();
//			String trangthai="Trống";
//			
//		
//			ban ban_test=returnBanByID(maban);
//			ban_test.setTenban(tenban);
//			ban_test.setTrangthai(trangthai);
//		    String DATA[]= {maban,tenban,trangthai};
//		    DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_dsban.getModel();
//		    tblmodel.setValueAt(maban, numRow_ban, 0);
//		    tblmodel.setValueAt(tenban, numRow_ban, 1);
//		    tblmodel.setValueAt(trangthai, numRow_ban, 2);
//		    printList();
//			MainView.khoitaoCombox_datban();
//		}
		
		
	}
	public void xoaInfo()
	{
		MainView.tx_dsban_maban.setText("");
		MainView.tx_dsban_tenban.setText("");
		MainView.buttonGroup_dsban.clearSelection();
	}
	public boolean checkTonTai(ban ban_test)
	{
		for (ban o : dsban) {
			if(o.getIdban().equals(ban_test.getIdban()));
			return true;
		}
		return false;
	}
	public static ban returnBanByID(String id)
	{
		for (ban o : dsban) {
			if(o.getIdban().equals(id))
			{
			return o;
			}
		}
		return null;
	}
//	public String autoID()
//	{
//		auto_ID_Ban++;
//		return "Ban_"+auto_ID_Ban;
//	}
	public static void printList()
	{
		for (ban o : dsban) {
			System.out.println(o);
		}
	}
}
