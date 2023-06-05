package controller;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

import model.monan;
import model.nhanvien;
import view.MainView;

public class mouse_ActionListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getComponent().equals(MainView.table))
		{   
			DefaultTableModel tbl=(DefaultTableModel) MainView.table.getModel();
			int tblselectedrow=MainView.table.getSelectedRow();
			int idmon=Integer.parseInt(tbl.getValueAt(tblselectedrow, 0).toString()) ;
			monan monan_test= Bacctionlistener.getmonan(idmon);
			MainView.txIDmon.setText(tbl.getValueAt(tblselectedrow, 0).toString());
			MainView.txTenMon.setText(tbl.getValueAt(tblselectedrow, 1).toString());
			MainView.comboBox_tenloai.setSelectedItem(tbl.getValueAt(tblselectedrow, 2).toString());
			MainView.txDonvi.setText(tbl.getValueAt(tblselectedrow, 3).toString());
			MainView.txSoluong.setText(tbl.getValueAt(tblselectedrow, 4).toString());
			MainView.txGiatien.setText(monan_test.getGiatien()+"");
			
			Bacctionlistener.idrowselected=tblselectedrow;
//			MainView.txKhoa.setText(st.getKhoa());
//			ImageIcon icon=new ImageIcon(st.getIdanh());
//			Image image=icon.getImage();
//			Image newimage=image.getScaledInstance(MainView.anh.getHeight(), MainView.anh.getWidth(), image.SCALE_SMOOTH);
//			Icon scaleimage=new ImageIcon(newimage);
//		     
//		      MainView.anh.setIcon(scaleimage);
			
			monan montest= Bacctionlistener.getmonan(idmon);
			ImageIcon image_them=new ImageIcon(montest.getIdanhmon());
			Image icon_tao=image_them.getImage();
			Image anhnew=icon_tao.getScaledInstance( MainView.anhdoan.getWidth(), MainView.anhdoan.getHeight(),Image.SCALE_SMOOTH);
			Icon scale_image=new ImageIcon(anhnew);
			MainView.anhdoan.setIcon(scale_image);
		}
		else if(e.getComponent().equals(MainView.table_nhanvien))
		{
			DefaultTableModel tbl=(DefaultTableModel) MainView.table_nhanvien.getModel();
			int tblselectedrow2=MainView.table_nhanvien.getSelectedRow();
			String idnv_check=tbl.getValueAt(tblselectedrow2, 0).toString();
			MainView.txId_nhanvien.setText(tbl.getValueAt(tblselectedrow2, 0).toString());
			MainView.tx_tennv.setText(tbl.getValueAt(tblselectedrow2, 1).toString());
			java.util.Date d1;
			try {
				d1 = new SimpleDateFormat("yyyy-MM-dd").parse(tbl.getValueAt(tblselectedrow2, 2).toString());
				MainView.chooser_ngaysinh.setDate(d1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			MainView.tx_sdt.setText(tbl.getValueAt(tblselectedrow2, 3).toString());
			MainView.tx_diachi.setText(tbl.getValueAt(tblselectedrow2, 4).toString());
			MainView.tx_chucvu.setText(tbl.getValueAt(tblselectedrow2, 5).toString());
			MainView.tx_taikhoan.setText(tbl.getValueAt(tblselectedrow2, 6).toString());
			MainView.tx_matkhau.setText(tbl.getValueAt(tblselectedrow2, 7).toString());

			nhanvien nv_test= nvActionlistener.getNhanVien_byID(idnv_check);
			
		     
			ImageIcon image_them=new ImageIcon(nv_test.getIdanhnv());
			Image icon_tao=image_them.getImage();
			Image anhnew=icon_tao.getScaledInstance(MainView.lb_anhnv.getWidth(), MainView.lb_anhnv.getHeight(),Image.SCALE_SMOOTH);
			Icon scale_image=new ImageIcon(anhnew);
	
			
			MainView.lb_anhnv.setIcon(scale_image);
		}
		else if(e.getComponent().equals(MainView.table_dsban))
		{   
			DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_dsban.getModel();
			 DsBanActionListener.numRow_ban=MainView.table_dsban.getSelectedRow();
			System.out.println(DsBanActionListener.numRow_ban);
			MainView.tx_dsban_maban.setText(tblmodel.getValueAt(DsBanActionListener.numRow_ban, 0).toString());
			MainView.tx_dsban_tenban.setText(tblmodel.getValueAt(DsBanActionListener.numRow_ban, 1).toString());
			String trangthai=tblmodel.getValueAt(DsBanActionListener.numRow_ban, 2).toString();
			
		}
		else if(e.getComponent().equals(MainView.table_banhientai))
		{
			DefaultTableModel tblmodel=(DefaultTableModel) MainView.table_banhientai.getModel();
			int selectedrownumber=MainView.table_banhientai.getSelectedRow();
			MainView.tx_dsbht_maban.setText(tblmodel.getValueAt(selectedrownumber, 0).toString());
			MainView.tx_dsbht_tenban.setText(tblmodel.getValueAt(selectedrownumber, 1).toString());
			String trangthai=tblmodel.getValueAt(selectedrownumber, 2).toString();
			if(trangthai.equals("Trống"))
			{
			      MainView.rd_bht_trong.setSelected(true);
			}
			else if(trangthai.equals("Có khách"))
			{
				   MainView.rd_bht_cokhach.setSelected(true);
			}
			else if(trangthai.equals("Đã đặt trước"))
			{
				   MainView.rd_bht_cokhach.setSelected(true);
			}
			
		}
		else if(e.getSource().equals(MainView.table_hoadon))
		{
			DefaultTableModel tbl=(DefaultTableModel) MainView.table_hoadon.getModel();
			int rowselect=MainView.table_hoadon.getSelectedRow();
			String tenmon=tbl.getValueAt(rowselect, 1).toString();
			MainView.comboBox_monan.setSelectedItem(tenmon);
			ComboBox_actionlistener.capnhapTrangThaiCombox(tenmon);
			String soluong=tbl.getValueAt(rowselect, 3).toString();
			MainView.tx_hoadon_soluongdat.setText(soluong);
 			
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}
