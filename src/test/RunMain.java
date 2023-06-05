package test;

import controller.Bacctionlistener;
import controller.nvActionlistener;
import model.nhanvien;
import view.MainView;


public class RunMain {
   public static void main(String[] args) {
//	  MainView mainView=new MainView();
	 
//	   MainView.idmon=Bacctionlistener.getIDcuoi();
//	   nhanvien nv= nvActionlistener.listnv.get(nvActionlistener.listnv.size()-1);
//	    nvActionlistener.id_nv_STT=Integer.parseInt(nv.getIdnv().substring(2));
}
   public static void runMainDB()
   {
	   MainView.idmon=Bacctionlistener.getIDcuoi();
	   if(nvActionlistener.listnv.size()>0)
	   {
		   nhanvien nv= nvActionlistener.listnv.get(nvActionlistener.listnv.size()-1);
		    nvActionlistener.id_nv_STT=Integer.parseInt(nv.getIdnv().substring(2));
	   }
	   else nvActionlistener.id_nv_STT=0;
	    
   }
}
