package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Bacctionlistener;
import controller.ComboBox_actionlistener;
import controller.LoginAc;
import controller.nvActionlistener;
import model.hoadon;
import model.monan;
import model.nhanvien;

import view.Login;
import view.MainView;
import view.PrintBill;

public class Test {
	public static int max=0;
	public static void main(String[] args) {
	    
	  
	   
		Bacctionlistener.ID_hoadon=-1;
			     
			nvActionlistener.runDB_first();
			Bacctionlistener.runDB_HoaDon();
			if(Bacctionlistener.listhoadon.size()>=0)
			{   
				for (hoadon hoadon_test : Bacctionlistener.listhoadon) {
					max=Integer.parseInt(hoadon_test.getMahoadon().substring(2));
					if(Bacctionlistener.ID_hoadon<max)
					{
						Bacctionlistener.ID_hoadon=max;
					}
				}
				
				
				

			}
			System.out.println(Bacctionlistener.ID_hoadon);

              Login login=new Login();
	
		
	}

}
