package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.MainView;

public class keyac implements KeyListener {
	public static double tienkhach=0;
	public static double tienthua=0;
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		String nguonsukien=e.getSource().toString();
		if(e.getSource().equals(MainView.tx_hoadon_tienkhach))
		{
//			double sum=Double.parseDouble(MainView.lb_tongtien_hoadon.getText());
			
			try {
				String tien=MainView.tx_hoadon_tienkhach.getText();
				tienkhach=Double.parseDouble(tien);
			
			
//				tienthua=test2);
				tienthua=tienkhach-Bacctionlistener.tongtien;
				System.out.println(tienthua);
				MainView.lb_tienthua_hoadon.setText(tienthua+"");
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
				
			
			
			}
	}

}
