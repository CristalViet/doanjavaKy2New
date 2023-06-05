package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.ban;
import model.hoadon;
import model.monan;
import view.MainView;

public class ComboBox_actionlistener implements ActionListener {
	private static boolean leapYear=false;
	private boolean Year=false;
	private boolean Month=false;
	private boolean Day=false;
	private String ngay="-1";
	private String thang="-1";
	private int nam=-1;
	public static double tienthuve=0;
	public static int tongdonbanra=0;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(MainView.comboBox_monan))
		{
		String Item=MainView.comboBox_monan.getSelectedItem().toString();
		
		monan montest=new monan(Item);
		montest=Bacctionlistener.getMonAnByName(montest);
		MainView.tx_hoadon_loaido.setText(montest.getTenloai());
		MainView.tx_hoadon_giatien.setText(montest.getGiatien()+"");

		MainView.tx_hoadon_mamon.setText(montest.getIdmon()+"");
	
		MainView.tx_hoadon_soluongcon.setText(montest.getSoluong()+"");
		
		
		String url=montest.getIdanhmon();
		System.out.println(url);
		ImageIcon icon=new ImageIcon(url);
		Image image=icon.getImage();
		Image imagenew=image.getScaledInstance(MainView.lb_hoadon_anhdoan.getHeight(),MainView.lb_hoadon_anhdoan.getWidth(), image.SCALE_SMOOTH);
	    icon=new ImageIcon(imagenew);
	
	  
		MainView.lb_hoadon_anhdoan.setIcon(icon);
		}
		else if(e.getSource().equals(MainView.comboBox_datban))
		{
			String Item=MainView.comboBox_datban.getSelectedItem().toString();
		    ban ban_test=DsBanActionListener.returnBanByID(Item);
		    MainView.tx_datban_tenban.setText(ban_test.getTenban());
		}
		else if(e.getSource().equals(MainView.rd_xemtheongay))
		{
			MainView.comboBox_xemngay.setEnabled(true);
			MainView.comboBox_xemthang.setEnabled(true);
			MainView.tx_xemnam.setEnabled(true);

		}
		else if(e.getSource().equals(MainView.rd_xemtheothan))
		{
			MainView.comboBox_xemngay.setEnabled(false);
			MainView.comboBox_xemthang.setEnabled(true);
			MainView.tx_xemnam.setEnabled(true);
		}
		else if(e.getSource().equals(MainView.rd_xemtheonam))
		{
			MainView.comboBox_xemngay.setEnabled(false);
			MainView.comboBox_xemthang.setEnabled(false);
			MainView.tx_xemnam.setEnabled(true);

		}
		else if(e.getSource().equals(MainView.b_doanhthu_timkiem))
		{ Locale localeVN = new Locale("vi", "VN");
	      NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	      DefaultTableModel tbl=(DefaultTableModel) MainView.table_doanhthu.getModel();
			if(MainView.rd_xemtheonam.isSelected()==true)
			{   
				try {
					nam=Integer.parseInt(MainView.tx_xemnam.getText()) ;
					
					tbl.setRowCount(0);
					
					    
				  
					for (hoadon hoadon : Bacctionlistener.listhoadon) {
						
						if(hoadon.getNgaythanhtoan().substring(6).equals(nam+""))
						{
							String [] DATA= {hoadon.getMahoadon(),hoadon.getTenban(),hoadon.getTenhanvien(),currencyVN.format(hoadon.getTienhang()) ,hoadon.getNgaythanhtoan()};
							tbl.addRow(DATA);
							tongdonbanra++;
							tienthuve+=hoadon.getTienhang();
							
						}
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Vui lòng nhập lại");
				}
				 MainView.tienthuve.setText(currencyVN.format(tienthuve));
				 MainView.tonghoadon.setText(tongdonbanra+" Đơn");
				 tienthuve=0;
				 tongdonbanra=0;
				
			}
			else if(MainView.rd_xemtheongay.isSelected())
			{   
				
				try {
					nam=Integer.parseInt(MainView.tx_xemnam.getText()) ;
					thang=MainView.comboBox_xemthang.getSelectedItem().toString();
					ngay=MainView.comboBox_xemngay.getSelectedItem().toString();
					tbl.setRowCount(0);
					 for (hoadon hoadon : Bacctionlistener.listhoadon) {
						
						if(hoadon.getNgaythanhtoan().equals(ngay+"/"+thang+"/"+nam))
						{
							String [] DATA= {hoadon.getMahoadon(),hoadon.getTenban(),hoadon.getTenhanvien(),currencyVN.format(hoadon.getTienhang()) ,hoadon.getNgaythanhtoan()};
							tbl.addRow(DATA);
							tongdonbanra++;
							tienthuve+=hoadon.getTienhang();
						}
					}
				} catch (Exception e2) {
					
				}
				 MainView.tienthuve.setText(currencyVN.format(tienthuve));
				 MainView.tonghoadon.setText(tongdonbanra+" Đơn");
				 tienthuve=0;
				 tongdonbanra=0;
			}
			else if(MainView.rd_xemtheothan.isSelected())
			{
				try {
					nam=Integer.parseInt(MainView.tx_xemnam.getText()) ;
					thang=MainView.comboBox_xemthang.getSelectedItem().toString();
					
					tbl.setRowCount(0);
					 for (hoadon hoadon : Bacctionlistener.listhoadon) {
							
							if(hoadon.getNgaythanhtoan().substring(3).equals(thang+"/"+nam))
							{
								String [] DATA= {hoadon.getMahoadon(),hoadon.getTenban(),hoadon.getTenhanvien(),currencyVN.format(hoadon.getTienhang()) ,hoadon.getNgaythanhtoan()};
								tbl.addRow(DATA);
								tongdonbanra++;
								tienthuve+=hoadon.getTienhang();
							}
						}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				 MainView.tienthuve.setText(currencyVN.format(tienthuve));
				 MainView.tonghoadon.setText(tongdonbanra+" Đơn");
				 tienthuve=0;
				 tongdonbanra=0;
					
					
					
				
			
			
		}
			
			
		}
		else if(e.getSource().equals(MainView.comboBox_xemthang) )
		{  try {
			String thang_test=MainView.comboBox_xemthang.getSelectedItem().toString();
			System.out.println("Ne");
				if(thang_test.equals("02"))
				{
					checkYear();
					if(leapYear==true)
					{ 
						
					   MainView.comboBox_xemngay.setModel(new DefaultComboBoxModel(new String []{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"}) );
					}
					else 
					{
						MainView.comboBox_xemngay.setModel(new DefaultComboBoxModel(new String []{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"}) );
					}
				}
				else if(thang_test.equals("04")||thang_test.equals("06")||thang_test.equals("09")||thang_test.equals("11") )
				{
					MainView.comboBox_xemngay.setModel(new DefaultComboBoxModel(new String []{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}) );
				}
				else 
				{
					MainView.comboBox_xemngay.setModel(new DefaultComboBoxModel(new String []{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}) );
				}
		} catch (Exception e2) {
			// TODO: handle exceptio
			JOptionPane.showMessageDialog(null, "Vui lòng nhập năm");
		}
		
			
		}
	
	}
	public static void capnhapTrangThaiCombox(String tenmon)
	{
		monan montest=new monan(tenmon);
		montest=Bacctionlistener.getMonAnByName(montest);
		MainView.tx_hoadon_loaido.setText(montest.getTenloai());
		MainView.tx_hoadon_giatien.setText(montest.getGiatien()+"");

		MainView.tx_hoadon_mamon.setText(montest.getIdmon()+"");
	
		MainView.tx_hoadon_soluongcon.setText(montest.getSoluong()+"");
		
		
		String url=montest.getIdanhmon();
		System.out.println(url);
		ImageIcon icon=new ImageIcon(url);
		Image image=icon.getImage();
		Image imagenew=image.getScaledInstance(MainView.lb_hoadon_anhdoan.getHeight(),MainView.lb_hoadon_anhdoan.getWidth(), image.SCALE_SMOOTH);
	    icon=new ImageIcon(imagenew);
	
	  
		MainView.lb_hoadon_anhdoan.setIcon(icon);
	}
	
	
	
	public static void checkYear(){
        if(Double.parseDouble(MainView.tx_xemnam.getText())%4==0 && Double.parseDouble(MainView.tx_xemnam.getText())%100!=0 || Double.parseDouble(MainView.tx_xemnam.getText())%400==0 ){
            leapYear=true;
        }
        else    leapYear=false;
    }
	

}
