package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.nhanvien;
import test.RunMain;
import view.Login;
import view.MainView;


public class LoginAc implements ActionListener {
     public static String tennhanvienhientai="";
	@Override
	public void actionPerformed(ActionEvent e) {
	    String nguonsukien=e.getActionCommand(); 
		if(nguonsukien.equals("Đăng nhập"))
		{   String taikhoan=Login.tx_taikhoan.getText();
		    String matkhau=Login.tx_pass.getText();
		    boolean kiemtra=false;
			for (nhanvien nhanvien_test : nvActionlistener.listnv) {
				if(taikhoan.equals(nhanvien_test.getTaikhoan())&&matkhau.equals(nhanvien_test.getMatkhau()))
				{
					System.out.println("Đăng nhập thành công");
					kiemtra=true;
					tennhanvienhientai=nhanvien_test.getTennv(); 
					if(nhanvien_test.getChucvu().equals("Quản lí"))
					{   
						
                              
						MainView view=new MainView();
					
						MainView.idmon=Bacctionlistener.getIDcuoi();
						   nhanvien nv= nvActionlistener.listnv.get(nvActionlistener.listnv.size()-1);
						    nvActionlistener.id_nv_STT=Integer.parseInt(nv.getIdnv().substring(2));
					    
					}
					else 
					{   	MainView view2=new MainView(); 
						
					MainView.idmon=Bacctionlistener.getIDcuoi();
					   nhanvien nv= nvActionlistener.listnv.get(nvActionlistener.listnv.size()-1);
					    nvActionlistener.id_nv_STT=Integer.parseInt(nv.getIdnv().substring(2));

					
						
					}
						
				}
				
			}
			if(kiemtra==false)
			{
				JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
			}
		}
		
	}
    
}
