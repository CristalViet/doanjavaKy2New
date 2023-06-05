package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import controller.Bacctionlistener;
import controller.DsBanActionListener;
import controller.keyac;
import controller.mouse_ActionListener;
import model.hoadon_ban;

import java.awt.print.PrinterException;
import java.lang.System.Logger;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;

public class PrintBill extends JFrame {
	public static JTextPane textPane;
	public PrintBill()
	{
		this.setBounds(0, 0, 500, 500);
		this.setTitle("In Bill");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 37, 250, 364);
		getContentPane().add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.setBounds(335, 279, 85, 21);
		getContentPane().add(btnNewButton);
		InBill(DsBanActionListener.idbanselected);
		
		this.setVisible(true);
	}
	public static void InBill(String idban)
	{
		 Locale localeVN = new Locale("vi", "VN");
		    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		
		String test="";
		
		try {
			textPane.setText("                      Cà phê Trí Việt\n");
			textPane.setText(textPane.getText()+ "\tKTX Đại Học CNTT&&TT Việt Hàn\n");
			textPane.setText(textPane.getText()+ "\tNgũ Hành Sơn,Đà Nẵng\n");
			textPane.setText(textPane.getText()+ "\tPhone:0799456639\n");
			textPane.setText(textPane.getText()+DsBanActionListener.idbanselected+"\n");
			textPane.setText(textPane.getText()+ "------------------------------------------------------------------\n");
			textPane.setText(textPane.getText()+ "Tên món\t\t     \t Đơn giá\n");
			textPane.setText(textPane.getText()+ "------------------------------------------------------------------\n");
			for (hoadon_ban hoadon : Bacctionlistener.listhoadonban) {
				if(idban.equals(hoadon.getIdban()))
				{   
				
					String tenmon=hoadon.getTenmon().trim();
					int soluong=hoadon.getSoluong();
					double dongia=hoadon.getGiatien();
					textPane.setText(textPane.getText()+tenmon+"\n");
					textPane.setText(textPane.getText()+"\t"+soluong+"*"+dongia+"\t\t"+soluong*dongia+"\n");
					
				}
			}
			textPane.setText(textPane.getText() + "----------------------------------------------------------------\n");
			textPane.setText(textPane.getText() + "Tiền Hàng :"+currencyVN.format(Bacctionlistener.tongtien) +"\n");
			textPane.setText(textPane.getText() + "Tiền khách đưa :"+currencyVN.format(keyac.tienkhach)+"\n");
			textPane.setText(textPane.getText() + "Tiền trả khách :"+currencyVN.format(keyac.tienthua)+"\n");
			textPane.setText(textPane.getText() + "====================================\n");
			textPane.setText(textPane.getText() +"                     Cảm ơn quý khách...!"+"\n");
			textPane.setText(textPane.getText() + "----------------------------------------------------------------\n");
			textPane.setText(textPane.getText() +"                     Software by Viethacherpro"+"\n");

			textPane.print();
		} catch (PrinterException e) {
			System.out.println("In không thành công!Vui lòng in lại");
			
		}
	
		
		
	}
}
