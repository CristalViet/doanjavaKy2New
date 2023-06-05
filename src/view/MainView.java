package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;

import javax.swing.ComboBoxModel;
import javax.swing.DebugGraphics;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import controller.Bacctionlistener;

import controller.ComboBox_actionlistener;
import controller.DsBanActionListener;
import controller.LoginAc;
import controller.keyac;
import controller.mouse_ActionListener;
import controller.nvActionlistener;
import model.Constants;
import model.monan;
import model.nhanvien;
import test.RunMain;

import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import java.awt.ComponentOrientation;


public class MainView extends JFrame {
	public static JButton ButtonTrangChu;
	public static JButton tglbtnThcn;
	public static JButton bdatban;
	public static JButton bthucdon;
	public static JPanel panel_datban;
	public static JPanel panelright;
	public static JPanel panel_thucdon;
	public static JPanel panel_hoadon;
	public static JPanel panel_doanhthu;
	public static JTextField txIDmon;
	public static JTextField txTenMon;
	public static JTextField txSoluong;
	public static JTextField txDonvi;
	public static JTable table;
	public static JLabel anhdoan;
	public static JTextField txGiatien;
	public static JComboBox comboBox_tenloai;
	public static JTextField TxTimKiem;
	public static int idmon=-1;
	public static JPanel panel_nhanvien;
	public static JLabel lb_anhnv;
	public static JTable table_nhanvien;
	public static JTextField txId_nhanvien;
	public static JTextField tx_tennv;
	public static JTextField tx_sdt;
	public static JTextField tx_diachi;
	public static JTextField tx_chucvu;
	public static JTextField tx_taikhoan;
	public static JTextField tx_matkhau;
	public static JDateChooser chooser_ngaysinh;
	public static JTextField tx_tenkhachhang_datban;
	public static  JComboBox comboBox_monan;
	public static JTextField tx_hoadon_soluongcon;
	public static JTextField tx_hoadon_mamon;
	public static JTextField tx_hoadon_loaido;
	public static JTextField tx_hoadon_soluongdat;
	public static JTextField tx_hoadon_giatien;
	public static JTable table_hoadon;
	public static  JScrollPane scrollPane_hoadon;
	public static JTextField tx_hoadon_tienkhach;
	public static JTextField tx_dsban_tenban;
	public static JTextField tx_dsban_maban;
	public static  JPanel panel_danhsachban;
	public static ButtonGroup buttonGroup_dsban ;
	public static JButton b_dsban_them;
	public static JButton b_dsban_xoa;
	public static  JButton b_dsban_sua;
	public static JTable table_dsban;
	public static JComboBox comboBox_datban;
	public static JTextField tx_datban_Madatban;
	public static JTable table_datban;
	public static JTextField tx_datban_tenban;
	public static JTextField tx_datban_sodienthoai;
	public static JTextField tx_datban_trangthai;
	public static JDateChooser dateChooser_ngaydat;
	public static JEditorPane editPan_ghichu_datban;
	public static  JPanel panel_danhsachbanhientai;
	public static JTable table_banhientai;
	public static JDateChooser dateChooser_chonngay_ban;
	public static JButton b_dsbanhientai_tim;
	public static JTextField tx_dsbht_maban;
	public static JTextField tx_dsbht_tenban;
	public static JRadioButton rd_bht_trong;
	public static JRadioButton rd_bth_dadattruoc;
	public static JRadioButton rd_bht_cokhach;
	public static ButtonGroup buttonGroup_dsbht = new ButtonGroup();
	public static ButtonGroup buttonGroup_ban_hoadon= new ButtonGroup();
	public static JButton b_hoadon_themmon;
	public static JLabel lb_tongtien_hoadon;
	public static JLabel lb_hoadon_anhdoan;
	public static JLabel lb_tienthua_hoadon ;
	public static ButtonGroup buttonGroup = new ButtonGroup();
	public static JPanel panel_banhoadon;
	public static DsBanActionListener ds;
	public static JButton b_capnhapsoluong;
	public static JButton b_xoathu;
	public static JLabel lb_TenNhanVienHienTai ;
	public static ImageIcon icon1=new ImageIcon("D:/doancuoikijava/Quanliquancf2/iconfolder/coffee-table (1).png");
	public static ImageIcon icon2=new ImageIcon("D:/doancuoikijava/Quanliquancf2/iconfolder/coffee-table.png");
	public static  ImageIcon icon3=new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\coffee-table (3).png");
	public static JButton b_inBill;
	public static JComboBox comboBox_xemthang;
	public static JButton []ban=new JButton[Constants.soBanNgang*Constants.soBanDoc];
	public static JTable table_doanhthu;
	public static JTextField tx_xemnam;
	public static JButton b_doanhthu_timkiem;
	public static JRadioButton rd_xemtheongay;
	public static JRadioButton rd_xemtheonam;
	public static ButtonGroup buttonGroup_1 = new ButtonGroup();
	public static  JComboBox comboBox_xemngay ;
	public static JRadioButton rd_xemtheothan;
	public static JLabel tienthuve;
	public static JLabel tonghoadon;
	public static JButton b_thongtin;
	public static JPanel panel_thongtin;
	public static JButton b_deleteInfo;
	public MainView() {
		
		setMaximizedBounds(new Rectangle(0, 0, 1200, 700));
		setMaximumSize(new Dimension(1200, 700));
		 Bacctionlistener ac=new Bacctionlistener();
		 mouse_ActionListener mc=new mouse_ActionListener();
		 nvActionlistener nv=new nvActionlistener();
		 ComboBox_actionlistener cb=new ComboBox_actionlistener();
		 ds=new DsBanActionListener();
		
		 keyac key=new keyac();
	     this.setBounds(0, 0, 1200, 700);
		 this.setTitle("Quản lí quán ăn");
		 getContentPane().setLayout(null);
		 
		 panelright = new JPanel();
		 panelright.setInheritsPopupMenu(true);
		 panelright.setName("");
		 panelright.setLocation(167, 15);
		 getContentPane().add(panelright);
		 panelright.setSize(1009, 648);
		 panelright.setLayout(new CardLayout(0, 0));
		 //panel thucdon
		 
		 
		 panel_thucdon = new JPanel();
		 panel_thucdon.setBackground(new Color(0, 128, 128));
		 panelright.add(panel_thucdon, "name_698969782140400");
		 panel_thucdon.setLayout(null);
		 
		 JLabel lblNewLabel_1 = new JLabel("ID món");
		 lblNewLabel_1.setBounds(728, 68, 45, 13);
		 panel_thucdon.add(lblNewLabel_1);
		 
		 txIDmon = new JTextField();
		 txIDmon.setEditable(false);
		 txIDmon.setBounds(728, 91, 96, 19);
		 panel_thucdon.add(txIDmon);
		 txIDmon.setColumns(10);
		 
		 JLabel lblNewLabel_2 = new JLabel("Tên món");
		 lblNewLabel_2.setBounds(728, 120, 68, 13);
		 panel_thucdon.add(lblNewLabel_2);
		 
		 txTenMon = new JTextField();
		 txTenMon.setBounds(729, 155, 203, 19);
		 panel_thucdon.add(txTenMon);
		 txTenMon.setColumns(10);
		 
		 JLabel lblNewLabel_3 = new JLabel("Tên loại");
		 lblNewLabel_3.setBounds(877, 68, 55, 13);
		 panel_thucdon.add(lblNewLabel_3);
		 
		 txSoluong = new JTextField();
		 txSoluong.setBounds(877, 207, 96, 19);
		 panel_thucdon.add(txSoluong);
		 txSoluong.setColumns(10);
		 
		 JLabel lblNewLabel_4 = new JLabel("Số lượng");
		 lblNewLabel_4.setBounds(877, 184, 55, 13);
		 panel_thucdon.add(lblNewLabel_4);
		 
		 txDonvi = new JTextField();
		 txDonvi.setBounds(728, 205, 96, 19);
		 panel_thucdon.add(txDonvi);
		 txDonvi.setColumns(10);
		 
		 JLabel lblNewLabel_5 = new JLabel("Đơn vị tính");
		 lblNewLabel_5.setBounds(739, 184, 68, 13);
		 panel_thucdon.add(lblNewLabel_5);
		 
		  comboBox_tenloai = new JComboBox();
		 String []Data= {"Đồ ăn vặt", "Đồ ăn thường", "Nước uống"};
//		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đồ ăn vặt", "Đồ ăn thường", "Nước uống"}));
		 comboBox_tenloai.setModel(new DefaultComboBoxModel( Data));
		 comboBox_tenloai.setBounds(877, 90, 96, 21);
		 panel_thucdon.add(comboBox_tenloai);
		 
	
		 
		 table = new JTable();
		 table.addMouseListener(mc);
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 	},
		 	new String[] {
		 		"ID m\u00F3n", "T\u00EAn m\u00F3n", "T\u00EAn lo\u1EA1i", "\u0110\u01A1n v\u1ECB t\u00EDnh", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1"
		 	}
		 ) {
		 	boolean[] columnEditables = new boolean[] {
		 		false, true, true, true, true, true
		 	};
		 	public boolean isCellEditable(int row, int column) {
		 		return columnEditables[column];
		 	}
		 });
		 JScrollPane scrollPane = new JScrollPane(table);
		 
		 scrollPane.setBounds(40, 74, 571, 497);
		 panel_thucdon.add(scrollPane);
		 table.setBounds(663, 93, -630, 387);
		 
		 JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		 scrollPane.setColumnHeaderView(internalFrame);
		 internalFrame.setVisible(true);
		 
		 JLabel lblNewLabel_6 = new JLabel("Danh Sách Thực Đơn");
		 lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		 lblNewLabel_6.setForeground(new Color(255, 0, 0));
		 lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_6.setBounds(40, 10, 571, 48);
		 panel_thucdon.add(lblNewLabel_6);
		 
		 anhdoan = new JLabel("");
		 anhdoan.setBorder(new LineBorder(new Color(218, 165, 32), 5, true));
		 anhdoan.setBounds(740, 296, 233, 247);
		 
		 panel_thucdon.add(anhdoan);
		 
		 JButton themanhdoan = new JButton("Thêm ảnh");
		 themanhdoan.setBounds(810, 568, 85, 21);
		 themanhdoan.addActionListener(ac);
		 panel_thucdon.add(themanhdoan);
		 
		 JButton them_doan = new JButton("Thêm");
		 them_doan.setBounds(628, 296, 85, 21);
		 them_doan.addActionListener(ac);
		 panel_thucdon.add(them_doan);
		 
		 JButton xoa_doan = new JButton("Xóa");
		 xoa_doan.setBounds(628, 338, 85, 21);
		 xoa_doan.addActionListener(ac);
		 panel_thucdon.add(xoa_doan);
		 
		 JButton sua_doan = new JButton("Sửa");
		 sua_doan.setBounds(628, 383, 85, 21);
		 panel_thucdon.add(sua_doan);
		 sua_doan.addActionListener(ac);
		 
		 JLabel lblNewLabel_7 = new JLabel("Đơn giá");
		 lblNewLabel_7.setBounds(728, 234, 45, 13);
		 panel_thucdon.add(lblNewLabel_7);
		 
		 txGiatien = new JTextField();
		 txGiatien.setBounds(783, 231, 96, 19);
		 panel_thucdon.add(txGiatien);
		 txGiatien.setColumns(10);
		 
		 TxTimKiem = new JTextField();
		 TxTimKiem.setBounds(663, 31, 161, 19);
		 panel_thucdon.add(TxTimKiem);
		 TxTimKiem.setColumns(10);
		 
		 JButton bTim = new JButton("Tìm");
		 bTim.setBounds(847, 30, 85, 21);
		 panel_thucdon.add(bTim);
		 bTim.addActionListener(ac);
		 
		 JLabel lblNewLabel_8 = new JLabel("Tìm theo ID");
		 lblNewLabel_8.setBounds(663, 10, 68, 13);
		 panel_thucdon.add(lblNewLabel_8);
//		 panel_thucdon.add(table);
		//panel datban
		 
		 panel_datban = new JPanel();
		 panel_datban.setBackground(new Color(240, 255, 255));
		 panelright.add(panel_datban, "name_698990818434800");
		 panel_datban.setLayout(null);
		 
		 tx_tenkhachhang_datban = new JTextField();
		 tx_tenkhachhang_datban.setBounds(44, 142, 135, 19);
		 panel_datban.add(tx_tenkhachhang_datban);
		 tx_tenkhachhang_datban.setColumns(10);
		 
		 JLabel lblNewLabel_17 = new JLabel("Tên khách hàng");
		 lblNewLabel_17.setBounds(44, 92, 77, 40);
		 panel_datban.add(lblNewLabel_17);
		 
		 JLabel lblNewLabel_18 = new JLabel("Mã bàn");
		 lblNewLabel_18.setBounds(301, 31, 45, 13);
		 panel_datban.add(lblNewLabel_18);
		 
		 comboBox_datban = new JComboBox();
		 comboBox_datban.setEditable(true);
		 comboBox_datban.setBounds(301, 62, 77, 21);
		 panel_datban.add(comboBox_datban);
		 comboBox_datban.addActionListener(cb);
		 
		 tx_datban_Madatban = new JTextField();
		 tx_datban_Madatban.setEditable(false);
		 tx_datban_Madatban.setBounds(44, 63, 96, 19);
		 panel_datban.add(tx_datban_Madatban);
		 tx_datban_Madatban.setColumns(10);
		 
		 JLabel lblNewLabel_34 = new JLabel("Mã đặt bàn");
		 lblNewLabel_34.setBounds(44, 31, 107, 13);
		 panel_datban.add(lblNewLabel_34);
		 
		 JScrollPane scrollPane_3 = new JScrollPane();
		 scrollPane_3.setBounds(44, 328, 825, 310);
		 panel_datban.add(scrollPane_3);
		 
		 table_datban = new JTable();
		 table_datban.setModel(new DefaultTableModel(
		 	new Object[][] {
		 		{null, null, null, null, null, null},
		 	},
		 	new String[] {
		 		"M\u00E3 \u0111\u1EB7t b\u00E0n", "T\u00EAn kh\u00E1ch h\u00E0ng", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "M\u00E3 b\u00E0n", "Ng\u00E0y \u0111\u1EB7t", "Ghi ch\u00FA"
		 	}
		 ));
		 scrollPane_3.setViewportView(table_datban);
		 
		 tx_datban_tenban = new JTextField();
		 tx_datban_tenban.setEnabled(false);
		 tx_datban_tenban.setBounds(302, 142, 96, 19);
		 panel_datban.add(tx_datban_tenban);
		 tx_datban_tenban.setColumns(10);
		 
		 JLabel lblNewLabel_35 = new JLabel("Tên bàn");
		 lblNewLabel_35.setBounds(301, 119, 45, 13);
		 panel_datban.add(lblNewLabel_35);
		 
		 dateChooser_ngaydat = new JDateChooser();
		 dateChooser_ngaydat.setBounds(44, 263, 149, 19);
		 panel_datban.add(dateChooser_ngaydat);
		 
		 JLabel lblNewLabel_36 = new JLabel("Ngày đặt");
		 lblNewLabel_36.setBounds(46, 240, 45, 13);
		 panel_datban.add(lblNewLabel_36);
		 
		 tx_datban_sodienthoai = new JTextField();
		 tx_datban_sodienthoai.setBounds(44, 210, 96, 19);
		 panel_datban.add(tx_datban_sodienthoai);
		 tx_datban_sodienthoai.setColumns(10);
		 
		 JLabel lblNewLabel_37 = new JLabel("Số điện thoại");
		 lblNewLabel_37.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_37.setBounds(44, 181, 107, 13);
		 panel_datban.add(lblNewLabel_37);
		 
		 JButton b_dondat_them = new JButton("Thêm");
		 b_dondat_them.setBounds(400, 209, 90, 73);
		 
		 panel_datban.add(b_dondat_them);

		 JButton b_datban_xoa = new JButton("Xóa");
		 b_datban_xoa.setBounds(523, 209, 77, 73);
		 panel_datban.add(b_datban_xoa);
		 
		 JButton b_datban_sua = new JButton("Sửa");
		 b_datban_sua.setBounds(640, 209, 77, 73);
		 panel_datban.add(b_datban_sua);
		 
		 JLabel lblNewLabel_38 = new JLabel("Ghi chú");
		 lblNewLabel_38.setBounds(454, 31, 45, 13);
		 panel_datban.add(lblNewLabel_38);
		 
		 JScrollPane scrollPane_4 = new JScrollPane();
		 scrollPane_4.setBounds(470, 55, 425, 139);
		 panel_datban.add(scrollPane_4);
		 
		 editPan_ghichu_datban = new JEditorPane();
		 scrollPane_4.setViewportView(editPan_ghichu_datban);
		 editPan_ghichu_datban.setBorder(new LineBorder(SystemColor.activeCaption, 13, true));
		 
		 tx_datban_trangthai = new JTextField();
		 tx_datban_trangthai.setBounds(244, 210, 96, 19);
		 panel_datban.add(tx_datban_trangthai);
		 tx_datban_trangthai.setColumns(10);
		 
		 JLabel lblNewLabel_39 = new JLabel("Trạng thái");
		 lblNewLabel_39.setBounds(244, 182, 77, 13);
		 panel_datban.add(lblNewLabel_39);
		 khoitaoCombox_datban();
		//panel hoadon
		 
		 
		 panel_hoadon = new JPanel();
		 panel_hoadon.setBackground(new Color(255, 255, 255));
		 panelright.add(panel_hoadon, "name_699043289679600");
		 
		  comboBox_monan = new JComboBox();
		  comboBox_monan.setBounds(84, 51, 105, 21);
		 comboBox_monan.addActionListener(cb);
		 panel_hoadon.setLayout(null);
		 panel_hoadon.add(comboBox_monan);
	    
		
		//panel doanhthu
		 
		 
		 panel_doanhthu = new JPanel();
		 panel_doanhthu.setBackground(SystemColor.info);
		 panelright.add(panel_doanhthu, "name_699047994164600");
		 panel_doanhthu.setLayout(null);
		 
		 JScrollPane scrollPane_6 = new JScrollPane();
		 scrollPane_6.setBounds(52, 126, 533, 387);
		 panel_doanhthu.add(scrollPane_6);
		 
		 table_doanhthu = new JTable();
		 table_doanhthu.setModel(new DefaultTableModel(
		 	new Object[][] {
		 	},
		 	new String[] {
		 		"M\u00E3 H\u00F3a \u0110\u01A1n", "T\u00EAn b\u00E0n", "T\u00EAn nh\u00E2n vi\u00EAn", "Ti\u1EC1n H\u00E0ng", "Ng\u00E0y Thanh To\u00E1n"
		 	}
		 ));
		 table_doanhthu.getColumnModel().getColumn(2).setPreferredWidth(116);
		 scrollPane_6.setViewportView(table_doanhthu);
		 
		 tx_xemnam = new JTextField();
		 tx_xemnam.setBounds(854, 267, 107, 19);
		 panel_doanhthu.add(tx_xemnam);
		 tx_xemnam.setColumns(10);
		 
		 comboBox_xemngay = new JComboBox();
		 comboBox_xemngay.setBounds(625, 266, 104, 21);
		 panel_doanhthu.add(comboBox_xemngay);
		 
		 comboBox_xemthang = new JComboBox();
		 comboBox_xemthang.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		 comboBox_xemthang.setBounds(739, 266, 105, 21);
		 panel_doanhthu.add(comboBox_xemthang);
		 comboBox_xemthang.addActionListener(cb);
		 
		 rd_xemtheonam = new JRadioButton("Xem theo năm");
		 rd_xemtheonam.setFont(new Font("Tahoma", Font.PLAIN, 9));
		 buttonGroup_1.add(rd_xemtheonam);
		 rd_xemtheonam.setBounds(857, 217, 104, 21);
		 panel_doanhthu.add(rd_xemtheonam);
		 rd_xemtheonam.addActionListener(cb);
		 
		 
		 rd_xemtheongay = new JRadioButton("Xem theo ngày");
		 buttonGroup_1.add(rd_xemtheongay);
		 rd_xemtheongay.setBounds(625, 217, 95, 21);
		 panel_doanhthu.add(rd_xemtheongay);
		 rd_xemtheongay.addActionListener(cb);
		
	
		 JLabel lblNewLabel = new JLabel("Doanh Thu");
		 lblNewLabel.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\bill (1).png"));
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		 lblNewLabel.setBounds(238, 26, 260, 61);
		 panel_doanhthu.add(lblNewLabel);
		 
		 rd_xemtheothan = new JRadioButton("Xem theo tháng");
		 buttonGroup_1.add(rd_xemtheothan);
		 rd_xemtheothan.addActionListener(cb);
		 rd_xemtheothan.setBounds(741, 217, 103, 21);
		 panel_doanhthu.add(rd_xemtheothan);
		 
		  b_doanhthu_timkiem = new JButton("Tìm Kiếm");
		 b_doanhthu_timkiem.setBounds(830, 332, 118, 33);
		 panel_doanhthu.add(b_doanhthu_timkiem);
		 
		 JLabel label_1 = new JLabel("");
		 label_1.setBackground(new Color(72, 209, 204));
		 label_1.setBounds(777, 285, 130, 169);
		 panel_doanhthu.add(label_1);
		 
		 JLabel lblNewLabel_27 = new JLabel("Tổng tiền thu về :");
		 lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_27.setBounds(358, 586, 140, 33);
		 panel_doanhthu.add(lblNewLabel_27);
		 
		  tienthuve = new JLabel("");
		 tienthuve.setBounds(508, 588, 130, 33);
		 panel_doanhthu.add(tienthuve);
		 
		 JLabel lblNewLabel_31 = new JLabel("Tổng hóa đơn :");
		 lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_31.setBounds(31, 586, 107, 31);
		 panel_doanhthu.add(lblNewLabel_31);
		 
		  tonghoadon = new JLabel("");
		 tonghoadon.setBounds(148, 592, 130, 19);
		 panel_doanhthu.add(tonghoadon);
		 b_doanhthu_timkiem.addActionListener(cb);
		 rd_xemtheothan.addActionListener(cb);
		 // nhan vien
		 panel_nhanvien = new JPanel();
		 panel_nhanvien.setBackground(new Color(250, 240, 230));
		 panelright.add(panel_nhanvien, "name_1212547462503100");
		 panel_nhanvien.setLayout(null);
		 
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(10, 305, 999, 333);
		 panel_nhanvien.add(scrollPane_1);
		 
		 table_nhanvien = new JTable();
		 table_nhanvien.addMouseListener(mc);
		 table_nhanvien.setModel(new DefaultTableModel(
		 	new Object[][] {
		 	},
		 	new String[] {
		 		"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Ch\u1EE9c v\u1EE5", "T\u00E0i Kho\u1EA3n", "M\u1EADt kh\u1EA9u"
		 	}
		 ));
		 scrollPane_1.setViewportView(table_nhanvien);
		 
		 txId_nhanvien = new JTextField();
		 txId_nhanvien.setEnabled(false);
		 txId_nhanvien.setBounds(32, 45, 96, 19);
		 panel_nhanvien.add(txId_nhanvien);
		 txId_nhanvien.setColumns(10);
		 
		 tx_tennv = new JTextField();
		 tx_tennv.setBounds(32, 112, 96, 19);
		 panel_nhanvien.add(tx_tennv);
		 tx_tennv.setColumns(10);
		 
		 JLabel lblNewLabel_9 = new JLabel("Mã nv");
		 lblNewLabel_9.setBounds(32, 10, 69, 25);
		 panel_nhanvien.add(lblNewLabel_9);
		 
		 JLabel lblNewLabel_10 = new JLabel("Tên nhân viên");
		 lblNewLabel_10.setBounds(32, 89, 96, 13);
		 panel_nhanvien.add(lblNewLabel_10);
		 
		 JLabel lblNewLabel_11 = new JLabel("Ngày sinh");
		 lblNewLabel_11.setBounds(32, 145, 69, 19);
		 panel_nhanvien.add(lblNewLabel_11);
		 
		 tx_sdt = new JTextField();
		 tx_sdt.setBounds(202, 45, 96, 19);
		 panel_nhanvien.add(tx_sdt);
		 tx_sdt.setColumns(10);
		 
		 JLabel lblNewLabel_12 = new JLabel("Số điện thoại");
		 lblNewLabel_12.setBounds(202, 10, 107, 25);
		 panel_nhanvien.add(lblNewLabel_12);
		 
		 tx_diachi = new JTextField();
		 tx_diachi.setBounds(202, 112, 213, 19);
		 panel_nhanvien.add(tx_diachi);
		 tx_diachi.setColumns(10);
		 
		 JLabel lblNewLabel_13 = new JLabel("Địa chỉ");
		 lblNewLabel_13.setBounds(202, 89, 45, 13);
		 panel_nhanvien.add(lblNewLabel_13);
		 
		 tx_chucvu = new JTextField();
		 tx_chucvu.setBounds(202, 174, 96, 19);
		 panel_nhanvien.add(tx_chucvu);
		 tx_chucvu.setColumns(10);
		 
		 JLabel lblNewLabel_14 = new JLabel("Chức vụ");
		 lblNewLabel_14.setBounds(202, 151, 85, 13);
		 panel_nhanvien.add(lblNewLabel_14);
		 
		 tx_taikhoan = new JTextField();
		 tx_taikhoan.setBounds(355, 45, 107, 19);
		 panel_nhanvien.add(tx_taikhoan);
		 tx_taikhoan.setColumns(10);
		 
		 JLabel lblNewLabel_15 = new JLabel("Tài khoản");
		 lblNewLabel_15.setBounds(355, 16, 76, 19);
		 panel_nhanvien.add(lblNewLabel_15);
		 
		 tx_matkhau = new JTextField();
		 tx_matkhau.setBounds(524, 45, 136, 19);
		 panel_nhanvien.add(tx_matkhau);
		 tx_matkhau.setColumns(10);
		 
		 JLabel lblNewLabel_16 = new JLabel("Mật khẩu");
		 lblNewLabel_16.setBounds(533, 19, 69, 13);
		 panel_nhanvien.add(lblNewLabel_16);
		 
         chooser_ngaysinh = new JDateChooser();
		 chooser_ngaysinh.setDateFormatString("yyyy-MM-dd");
		 chooser_ngaysinh.setBounds(32, 174, 113, 19);
		 panel_nhanvien.add(chooser_ngaysinh);
		 
		 lb_anhnv = new JLabel("");
		 lb_anhnv.setBorder(new LineBorder(new Color(0, 0, 51), 7, true));
		 lb_anhnv.setBounds(748, 16, 154, 193);
		 panel_nhanvien.add(lb_anhnv);
		 
		 JButton b_themanh_nv = new JButton("Thêm ảnh");
		 b_themanh_nv.setBounds(773, 219, 85, 21);
		 panel_nhanvien.add(b_themanh_nv);
		 b_themanh_nv.addActionListener(nv);
		 JButton B_them = new JButton("Thêm");
		 B_them.setBounds(44, 255, 85, 21);
		
		 panel_nhanvien.add(B_them);
		 B_them.addActionListener(nv);
		 JButton b_Xoa = new JButton("Xóa");
		 b_Xoa.setBounds(167, 255, 85, 21);
		 panel_nhanvien.add(b_Xoa);
		 b_Xoa.addActionListener(nv);
		 
		 JButton b_sua = new JButton("Sửa");
		 b_sua.setBounds(305, 255, 85, 21);
		 panel_nhanvien.add(b_sua);
		 
		  b_deleteInfo = new JButton("Delete Information");
		 b_deleteInfo.setBounds(436, 255, 117, 21);
		 panel_nhanvien.add(b_deleteInfo);
		 b_deleteInfo.addActionListener(ac);
		 b_sua.addActionListener(nv);
		 

		  	  	 
		  	  	 JPanel panelleft = new JPanel();
		  	  	 panelleft.setBounds(10, 15, 161, 648);
		  	  	 getContentPane().add(panelleft);
		  	  	 panelleft.setBackground(new Color(0, 153, 255));
		  	  	 panelleft.setLayout(null);
		  	  	  	 
		  	  	  	 ButtonTrangChu = new JButton("Trang chủ");
		  	  	  	 ButtonTrangChu.addActionListener(new ActionListener() {
		  	  	  	 	public void actionPerformed(ActionEvent e) {
		  	  	  	 		new LoginAc ();
		  	  	  	 		dispose();
		  	  	  	 	}
		  	  	  	 });
		  	  	  	 ButtonTrangChu.setRequestFocusEnabled(false);
		  	  	  	 ButtonTrangChu.setRolloverEnabled(false);
		  	  	  	 ButtonTrangChu.setBorder(null);
		  	  	  	 ButtonTrangChu.setBackground(new Color(0, 153, 255));
		  	  	  	 ButtonTrangChu.setAutoscrolls(true);
		  	  	  	 ButtonTrangChu.setBounds(18, 24, 119, 40);
		  	  	
		  	  	  	 panelleft.add(ButtonTrangChu);
		  	  	  	 ButtonTrangChu.setSelectedIcon(new ImageIcon("C:\\Users\\shen\\Documents\\iconselected4.png"));
		  	  	  	 ButtonTrangChu.setRolloverSelectedIcon(new ImageIcon("C:\\Users\\shen\\Documents\\iconselected4.png"));
		  	  	  	 ButtonTrangChu.setRolloverIcon(new ImageIcon("C:\\Users\\shen\\Documents\\iconselected4.png"));
		  	  	  	 ButtonTrangChu.setHorizontalTextPosition(SwingConstants.RIGHT);
		  	  	  	 ButtonTrangChu.setIcon(new ImageIcon("D:\\eclipse-workspace\\Quanliquancf\\iconfolder\\Home.png"));
		  	  	  	 ButtonTrangChu.setMinimumSize(new Dimension(120, 40));
		  	  	  	 ButtonTrangChu.setMaximumSize(new Dimension(120, 40));
		  	  	  	 ButtonTrangChu.setPreferredSize(new Dimension(120, 40));
		  	    	
		  	  	     JButton bthucdon = new JButton("Thực đơn");
		  	  	  	 bthucdon.setBorderPainted(false);
		  	  	  	 bthucdon.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\4014672-bill-contract-cost-document-mobile-receipt-service_112892.png"));
		  	  	  	 bthucdon.setBorder(null);
		  	  	  	
		  	  	  	 bthucdon.addActionListener(ac);
		  	  	  	 bthucdon.setBackground(new Color(0, 153, 255));
		  	  	  	 bthucdon.setBounds(18, 84, 119, 40);
		  	  	  	 panelleft.add(bthucdon);
		  	  	  	 bthucdon.setPreferredSize(new Dimension(120, 40));
		  	  	  	 bthucdon.setMinimumSize(new Dimension(120, 40));
		  	  	  	 bthucdon.setMaximumSize(new Dimension(120, 40));
		  	  	  	 bthucdon.setHorizontalTextPosition(SwingConstants.RIGHT);
		  	  	  	 
		  	           	 JButton bdatban = new JButton("");
		  	  	  	 bdatban.setBorder(null);
		  	  	  	 bdatban.setBackground(new Color(0, 153, 255));
		  	  	  	 bdatban.setBounds(10, 413, 119, 40);
		  	  	  	 bdatban.addActionListener(ac);
		  	  	  	 panelleft.add(bdatban);
		  	  	  	 bdatban.setPreferredSize(new Dimension(120, 40));
		  	  	  	 bdatban.setMinimumSize(new Dimension(120, 40));
		  	  	  	 bdatban.setMaximumSize(new Dimension(120, 40));
		  	  	  	 bdatban.setHorizontalTextPosition(SwingConstants.RIGHT);
		  	  	  	 
		  	  	    JButton b_nhanvien = new JButton("Nhân viên");
		  	  	  	 b_nhanvien.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\staff.png"));
		  	  	  	 b_nhanvien.setBorder(null);
		  	  	  	 b_nhanvien.setBackground(new Color(0, 153, 255));
		  	  	  	 b_nhanvien.setBounds(17, 235, 120, 40);
		  	  	  	 b_nhanvien.addActionListener(ac);
		  	  	  	 panelleft.add(b_nhanvien);
		  	  	  	 b_nhanvien.setPreferredSize(new Dimension(120, 40));
		  	  	  	 b_nhanvien.setMinimumSize(new Dimension(120, 40));
		  	  	  	 b_nhanvien.setMaximumSize(new Dimension(120, 40));
		  	  	  	 b_nhanvien.setHorizontalTextPosition(SwingConstants.RIGHT);
		  	  	  	 
		  	  	       JButton b_hoadon = new JButton("Hóa đơn");
		  	  	      
		  	  	  	 b_hoadon.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\table.png"));
		  	  	  	 b_hoadon.setBackground(new Color(0, 153, 255));
		  	  	  	 b_hoadon.setBorder(null);
		  	  	  	 b_hoadon.setBounds(17, 135, 120, 40);
		  	  	  	 b_hoadon.addActionListener(ac);
		  	  	  	 panelleft.add(b_hoadon);
		  	  	  	 b_hoadon.setPreferredSize(new Dimension(120, 40));
		  	  	  	 b_hoadon.setMinimumSize(new Dimension(120, 40));
		  	  	  	 b_hoadon.setMaximumSize(new Dimension(120, 40));
		  	  	  	 b_hoadon.setHorizontalTextPosition(SwingConstants.RIGHT);
		  	  	  	 //panel doanhthu
		  	  	  	 
		  	  	     JButton b_doanhthu = new JButton("Doanh thu");
		  	  	  	 b_doanhthu.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\profit.png"));
		  	  	  	 b_doanhthu.setBorder(null);
		  	  	  	 b_doanhthu.setBackground(new Color(0, 153, 255));
		  	  	  	 b_doanhthu.setBounds(18, 185, 119, 40);
		  	  	  	 b_doanhthu.addActionListener(ac);
		  	  	  	 panelleft.add(b_doanhthu);
		  	  	  	 b_doanhthu.setPreferredSize(new Dimension(120, 40));
		  	  	  	 b_doanhthu.setMinimumSize(new Dimension(120, 40));
		  	  	  	 b_doanhthu.setMaximumSize(new Dimension(120, 40));
		  	  	  	 b_doanhthu.setHorizontalTextPosition(SwingConstants.RIGHT);
		  	  	  	 
		  	  	  	 
		  	  	  	 
		  	  	  	 //
		  	  	        b_thongtin = new JButton("Thông tin");
		  	  	       b_thongtin.addActionListener(ac);
		  	  	        	
		  	  	       
		  	  	       	
		  	  	  	 b_thongtin.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\info.png"));
		  	  	  	 b_thongtin.setBorder(null);
		  	  	  	 b_thongtin.setBackground(new Color(0, 153, 255));
		  	  	  	 b_thongtin.setBounds(17, 280, 120, 40);
		  	  	  	 panelleft.add(b_thongtin);
		  	  	  	 b_thongtin.setPreferredSize(new Dimension(120, 40));
		  	  	  	 b_thongtin.setMinimumSize(new Dimension(120, 40));
		  	  	  	 b_thongtin.setMaximumSize(new Dimension(120, 40));
		  	  	  	 b_thongtin.setHorizontalTextPosition(SwingConstants.RIGHT);
		  	  	  	 
		  	  	  	 lb_TenNhanVienHienTai = new JLabel(LoginAc.tennhanvienhientai);
		  	  	  	 
		  	  	  	 lb_TenNhanVienHienTai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		  	  	  	 lb_TenNhanVienHienTai.setBounds(18, 530, 119, 24);
		  	  	  	 panelleft.add(lb_TenNhanVienHienTai);
		  	  	  	 
		  	  	  	 JLabel lblNewLabel_26 = new JLabel("Nhân Viên");
		  	  	  	 lblNewLabel_26.setFont(new Font("Tahoma", Font.PLAIN, 13));
		  	  	  	 lblNewLabel_26.setForeground(new Color(240, 255, 240));
		  	  	  	 lblNewLabel_26.setBounds(18, 493, 88, 27);
		  	  	  	 panelleft.add(lblNewLabel_26);
		             //nap du lieu tu DB
		  	  	   khoitaodulieuDB();
		  	  	
		  	  	   
				 
		  	  	 
		  	  	 
				 DefaultComboBoxModel dml=new DefaultComboBoxModel<>();
					
			     for(int i=0;i<Bacctionlistener.listmonan.size();i++)
			     {
			    	dml.addElement(Bacctionlistener.listmonan.get(i).getTenmon());
			
			     }
				
			     
				 comboBox_monan.setModel(dml);
				 
				 JLabel lblNewLabel_19 = new JLabel("Tên món");
				 lblNewLabel_19.setBounds(84, 28, 45, 13);
				 panel_hoadon.add(lblNewLabel_19);
				 
				 tx_hoadon_soluongcon = new JTextField();
				 tx_hoadon_soluongcon.setBounds(262, 52, 96, 19);
				 tx_hoadon_soluongcon.setEnabled(false);
				 panel_hoadon.add(tx_hoadon_soluongcon);
				 tx_hoadon_soluongcon.setColumns(10);
				 
				 tx_hoadon_mamon = new JTextField();
				 tx_hoadon_mamon.setBounds(84, 104, 96, 21);
				 tx_hoadon_mamon.setEnabled(false);
				 panel_hoadon.add(tx_hoadon_mamon);
				 tx_hoadon_mamon.setColumns(10);
				 
				 tx_hoadon_loaido = new JTextField();
				 tx_hoadon_loaido.setBounds(220, 105, 96, 19);
				 tx_hoadon_loaido.setEnabled(false);
				 panel_hoadon.add(tx_hoadon_loaido);
				 tx_hoadon_loaido.setColumns(10);
				 
				 tx_hoadon_soluongdat = new JTextField();
				 tx_hoadon_soluongdat.setBounds(220, 205, 96, 19);
				 panel_hoadon.add(tx_hoadon_soluongdat);
				 tx_hoadon_soluongdat.setColumns(10);
				 
				 JLabel lblNewLabel_20 = new JLabel("Số lượng còn");
				 lblNewLabel_20.setBounds(263, 28, 117, 13);
				 panel_hoadon.add(lblNewLabel_20);
				 
				 JLabel lblNewLabel_21 = new JLabel("Mã món");
				 lblNewLabel_21.setBounds(94, 81, 45, 13);
				 panel_hoadon.add(lblNewLabel_21);
				 
				 JLabel lblNewLabel_22 = new JLabel("Loại đồ");
				 lblNewLabel_22.setBounds(220, 82, 45, 13);
				 panel_hoadon.add(lblNewLabel_22);
				 
				 JLabel label = new JLabel("New label");
				 label.setBounds(423, 55, -1, -14);
				 panel_hoadon.add(label);
				 
				 JLabel lblNewLabel_25 = new JLabel("Giá tiền");
				 lblNewLabel_25.setBounds(387, 28, 58, 13);
				 panel_hoadon.add(lblNewLabel_25);
				 
				 tx_hoadon_giatien = new JTextField();
				 tx_hoadon_giatien.setBounds(379, 52, 96, 19);
				 tx_hoadon_giatien.setEnabled(false);
				 panel_hoadon.add(tx_hoadon_giatien);
				 tx_hoadon_giatien.setColumns(10);
				 
				 JLabel lb1 = new JLabel("Số lượng");
				 lb1.setBounds(223, 167, 71, 21);
				 panel_hoadon.add(lb1);
				 scrollPane_hoadon = new JScrollPane();
				 scrollPane_hoadon.setBounds(33, 260, 376, 278);
				 panel_hoadon.add(scrollPane_hoadon);
				 table_hoadon = new JTable();
				 table_hoadon.setModel(new DefaultTableModel(
				 	new Object[][] {
				 		{null, null, null, null},
				 	},
				 	new String[] {
				 		"M\u00E3 m\u00F3n", "T\u00EAn m\u00F3n", "Gi\u00E1 ti\u1EC1n", "S\u1ED1 l\u01B0\u1EE3ng"
				 	}
				 ));
				 scrollPane_hoadon.setViewportView(table_hoadon);
				table_hoadon.addMouseListener(mc);
				  b_hoadon_themmon = new JButton("Thêm món");
				  b_hoadon_themmon.setFont(new Font("Tahoma", Font.PLAIN, 10));
				 b_hoadon_themmon.setBounds(10, 564, 86, 61);
				 panel_hoadon.add(b_hoadon_themmon);
				 b_hoadon_themmon.addActionListener(ac);
				 JLabel lblNewLabel_28 = new JLabel("Tổng tiền :");
				 lblNewLabel_28.setFont(new Font("Times New Roman", Font.PLAIN, 13));
				 lblNewLabel_28.setForeground(new Color(255, 0, 0));
				 lblNewLabel_28.setBounds(450, 553, 71, 19);
				 panel_hoadon.add(lblNewLabel_28);
				 
				  lb_tongtien_hoadon = new JLabel("");
				 lb_tongtien_hoadon.setBounds(553, 553, 112, 21);
				 panel_hoadon.add(lb_tongtien_hoadon);
				 
				 JLabel lblNewLabel_30 = new JLabel("Tiền nhận của khách :");
				 lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 14));
				 lblNewLabel_30.setBounds(410, 582, 167, 21);
				 panel_hoadon.add(lblNewLabel_30);
				 
				 tx_hoadon_tienkhach = new JTextField();
				 tx_hoadon_tienkhach.setBounds(569, 585, 113, 19);
				 panel_hoadon.add(tx_hoadon_tienkhach);
				 tx_hoadon_tienkhach.setColumns(10);
				 tx_hoadon_tienkhach.addKeyListener(key);
				 
				 
				 JLabel lb_tienthua = new JLabel("Tiền thừa");
				 lb_tienthua.setBounds(491, 615, 68, 13);
				 panel_hoadon.add(lb_tienthua);
				 
				 lb_tienthua_hoadon = new JLabel("");
				 lb_tienthua_hoadon.setBorder(new LineBorder(new Color(0, 0, 0)));
				 lb_tienthua_hoadon.setBounds(569, 612, 117, 13);
				 panel_hoadon.add(lb_tienthua_hoadon);
				 
				 JButton btnNewButton_2 = new JButton("Thanh toán");
			
				 btnNewButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
				 btnNewButton_2.setBounds(728, 573, 105, 45);
				 panel_hoadon.add(btnNewButton_2);
				 btnNewButton_2.addActionListener(ac);
				 
				 panel_danhsachban = new JPanel();
				 panelright.add(panel_danhsachban, "name_220334693159800");
				 panel_danhsachban.setLayout(null);
				 
				 JScrollPane scrollPane_2 = new JScrollPane();
				 scrollPane_2.setBounds(33, 110, 663, 362);
				 panel_danhsachban.add(scrollPane_2);
				 
				 table_dsban = new JTable();
				 table_dsban.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				 table_dsban.setModel(new DefaultTableModel(
				 	new Object[][] {
				 	},
				 	new String[] {
				 		"M\u00E3 b\u00E0n", "T\u00EAn b\u00E0n", "Tr\u1EA1ng th\u00E1i"
				 	}
				 ));
				 table_dsban.addMouseListener(mc);
				 scrollPane_2.setViewportView(table_dsban);
//				 scrollPane_2.add(table_dsban);
				 JLabel lblNewLabel_29 = new JLabel("Danh Sách Bàn");
				 lblNewLabel_29.setForeground(new Color(255, 0, 0));
				 lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 25));
				 lblNewLabel_29.setBounds(201, 21, 181, 48);
				 panel_danhsachban.add(lblNewLabel_29);
				 
				 JLabel lblNewLabel_32 = new JLabel("Tên bàn");
				 lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 15));
				 lblNewLabel_32.setBounds(730, 110, 80, 66);
				 panel_danhsachban.add(lblNewLabel_32);
				 
				 tx_dsban_tenban = new JTextField();
				 tx_dsban_tenban.setBounds(832, 136, 96, 19);
				 panel_danhsachban.add(tx_dsban_tenban);
				 tx_dsban_tenban.setColumns(10);
				 
				 tx_dsban_maban = new JTextField();
				 tx_dsban_maban.setEditable(false);
				 tx_dsban_maban.setBounds(832, 95, 96, 19);
				 panel_danhsachban.add(tx_dsban_maban);
				 tx_dsban_maban.setColumns(10);
				 
		
				 JLabel lblNewLabel_33 = new JLabel("Mã bàn");
				 lblNewLabel_33.setFont(new Font("Tahoma", Font.PLAIN, 20));
				 lblNewLabel_33.setBounds(730, 88, 67, 25);
				 panel_danhsachban.add(lblNewLabel_33);
				 buttonGroup_dsban = new ButtonGroup();
				 
				
				  b_dsban_them = new JButton("Thêm");
				 b_dsban_them.setBounds(743, 329, 85, 66);
				 panel_danhsachban.add(b_dsban_them);
				 b_dsban_them.addActionListener(ds);
				  b_dsban_xoa = new JButton("Xóa");
				 b_dsban_xoa.setBounds(865, 329, 85, 66);
				 panel_danhsachban.add(b_dsban_xoa);
				 b_dsban_xoa.addActionListener(ds);
				 b_dsban_sua = new JButton("Sửa");
				 b_dsban_sua.setBounds(743, 416, 85, 58);
				 panel_danhsachban.add(b_dsban_sua);
				 
				 panel_danhsachbanhientai = new JPanel();
				 panelright.add(panel_danhsachbanhientai, "name_600052488955400");
				 panel_danhsachbanhientai.setLayout(null);
				 
				 JScrollPane scrollPane_5 = new JScrollPane();
				 scrollPane_5.setBounds(101, 133, 619, 374);
				 panel_danhsachbanhientai.add(scrollPane_5);
				 
				 table_banhientai = new JTable();
				 table_banhientai.addMouseListener(mc);
				 table_banhientai.setModel(new DefaultTableModel(
				 	new Object[][] {
				 		{null, null, null},
				 	},
				 	new String[] {
				 		"M\u00E3 b\u00E0n", "T\u00EAn b\u00E0n", "Tr\u1EA1ng th\u00E1i"
				 	}
				 ));
				 scrollPane_5.setViewportView(table_banhientai);
				 
				 JLabel lblNewLabel_40 = new JLabel("Danh sách bàn");
				 lblNewLabel_40.setFont(new Font("Tahoma", Font.PLAIN, 20));
				 lblNewLabel_40.setBounds(197, 32, 209, 48);
				 panel_danhsachbanhientai.add(lblNewLabel_40);
				 
				 dateChooser_chonngay_ban = new JDateChooser();
				 dateChooser_chonngay_ban.setBounds(565, 48, 125, 19);
				 panel_danhsachbanhientai.add(dateChooser_chonngay_ban);
			
				 
				 JLabel lblNewLabel_41 = new JLabel("Chọn ngày");
				 lblNewLabel_41.setBounds(565, 10, 76, 13);
				 panel_danhsachbanhientai.add(lblNewLabel_41);
				 
				  b_dsbanhientai_tim = new JButton("Tìm");

				  
				   lb_hoadon_anhdoan = new JLabel("");
				  lb_hoadon_anhdoan.setBorder(new LineBorder(SystemColor.activeCaption, 5));
				  lb_hoadon_anhdoan.setBounds(423, 135, 117, 139);
				  panel_hoadon.add(lb_hoadon_anhdoan);
				  
				   panel_banhoadon = new JPanel();
				  panel_banhoadon.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				  panel_banhoadon.setBounds(558, 10, 396, 528);
				  panel_hoadon.add(panel_banhoadon);
				  panel_banhoadon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				  
				  JLabel lblNewLabel_24 = new JLabel("");
				  lblNewLabel_24.setBounds(84, 196, 45, 13);
				  panel_hoadon.add(lblNewLabel_24);
				  
				  b_capnhapsoluong = new JButton("Cập nhập số lượng");
				  b_capnhapsoluong.setFont(new Font("Tahoma", Font.PLAIN, 10));
				  b_capnhapsoluong.setBounds(228, 564, 130, 60);
				  panel_hoadon.add(b_capnhapsoluong);
				  
				  b_xoathu = new JButton("Xóa món");
				  b_xoathu.setBounds(120, 564, 85, 61);
				  panel_hoadon.add(b_xoathu);
				  
				  b_inBill = new JButton("");
				  b_inBill.setHorizontalTextPosition(SwingConstants.RIGHT);
				  b_inBill.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\printer.png"));
				  b_inBill.setBounds(868, 568, 85, 53);
				  panel_hoadon.add(b_inBill);
				  b_inBill.addActionListener(ac);
				  b_xoathu.addActionListener(ac);
			
				  
				  
				
				  b_capnhapsoluong.addActionListener(ac);
				 b_dsbanhientai_tim.setBounds(729, 50, 85, 21);
				 panel_danhsachbanhientai.add(b_dsbanhientai_tim);
				 
				 JButton b_dsbth_capnhap = new JButton("Cập nhập");
				 b_dsbth_capnhap.setBounds(763, 433, 85, 78);
				 panel_danhsachbanhientai.add(b_dsbth_capnhap);
				 
				 tx_dsbht_maban = new JTextField();
				 tx_dsbht_maban.setBounds(763, 173, 96, 19);
				 panel_danhsachbanhientai.add(tx_dsbht_maban);
				 tx_dsbht_maban.setColumns(10);
				 
				 JLabel lblNewLabel_42 = new JLabel("Mã bàn");
				 lblNewLabel_42.setBounds(763, 140, 45, 13);
				 panel_danhsachbanhientai.add(lblNewLabel_42);
				 
				 rd_bht_trong = new JRadioButton("Trống");
				 buttonGroup_dsbht.add(rd_bht_trong);
				 rd_bht_trong.setBounds(763, 288, 103, 21);
				 panel_danhsachbanhientai.add(rd_bht_trong);
				 
				 tx_dsbht_tenban = new JTextField();
				 tx_dsbht_tenban.setBounds(763, 246, 96, 19);
				 panel_danhsachbanhientai.add(tx_dsbht_tenban);
				 tx_dsbht_tenban.setColumns(10);
				 
				 JLabel lblNewLabel_43 = new JLabel("Tên bàn");
				 lblNewLabel_43.setBounds(763, 223, 45, 13);
				 panel_danhsachbanhientai.add(lblNewLabel_43);
				 
				 rd_bht_cokhach = new JRadioButton("Có khách");
				 buttonGroup_dsbht.add(rd_bht_cokhach);
				 rd_bht_cokhach.setBounds(763, 334, 103, 21);
				 panel_danhsachbanhientai.add(rd_bht_cokhach);
				 
				 rd_bth_dadattruoc = new JRadioButton("Đã đặt trước");
				 buttonGroup_dsbht.add(rd_bth_dadattruoc);
				 rd_bth_dadattruoc.setBounds(883, 288, 103, 21);
				 panel_danhsachbanhientai.add(rd_bth_dadattruoc);
				 
				  panel_thongtin = new JPanel();
				 panelright.add(panel_thongtin, "name_277158732748600");
				 panel_thongtin.setLayout(null);
				 
				 JLabel lblNewLabel_44 = new JLabel("Đồ Án Cuối Kì Java đã xong");
				 lblNewLabel_44.setFont(new Font("Tahoma", Font.PLAIN, 21));
				 lblNewLabel_44.setBounds(53, 10, 293, 189);
				 panel_thongtin.add(lblNewLabel_44);
				 
				 JLabel lblNewLabel_45 = new JLabel("Ứng dụng quản lý quán ăn, cà phê và nhà hàng");
				 lblNewLabel_45.setFont(new Font("Tahoma", Font.PLAIN, 18));
				 lblNewLabel_45.setBounds(53, 181, 426, 81);
				 panel_thongtin.add(lblNewLabel_45);
				 
				 JLabel lblNewLabel_46 = new JLabel("Tác giả: Viethacherpro");
				 lblNewLabel_46.setFont(new Font("Tahoma", Font.PLAIN, 20));
				 lblNewLabel_46.setBounds(53, 309, 397, 65);
				 panel_thongtin.add(lblNewLabel_46);
				 b_dsban_sua.addActionListener(ds);
			
					MainView.taoBan();
					nvActionlistener.RunDatabase_nv();
					
					
		this.setVisible(true);
		
	
	}
	public static void khoitaodulieuDB()
	{   Bacctionlistener.listmonan.clear();
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
	  		String user="viet2";
	  		String pass="123";
	  		try {
	  			Class.forName(driverName);
	  			Connection con=DriverManager.getConnection(url, user, pass);
	  			Statement stmt=con.createStatement();
	  			String sql="SELECT * FROM Monan";
	  		      ResultSet result= stmt.executeQuery(sql);
	  		         //duyet tung dong trong result
	  		         while(result.next()) {
	  		        	
	  		        	 int id=Integer.parseInt(result.getString(1)) ;
	  		        	 String tenmon=result.getNString(2);
	  		             String tenloai=result.getNString(3);
	  		             String donvi=result.getNString(4).replaceAll(" ", "");
	  		             int soluong=Integer.parseInt(result.getString(5));
	  		             double giatien=Double.parseDouble(result.getString(6));
	  		             String idanh=result.getString(7);
	  		       	    monan monan_check=new monan(id, tenmon, tenloai, donvi, soluong, giatien, idanh);
	  		        	 Bacctionlistener.listmonan.add(monan_check);
	  		
	  		         }
	  	           Bacctionlistener.printlist();
	  		} catch (ClassNotFoundException e) {
	  			// TODO Auto-generated catch block
	  			System.out.println("Ket noi khong thanh cong");
	  		}
	  		
	  		
	  			
	  		 catch (SQLException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	  	  	 //khoi tao du lieu Jtable
	  		Locale localeVN = new Locale("vi", "VN");
	  	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	  	  	 for (monan o : Bacctionlistener.listmonan) {
				 DefaultTableModel tblmodel=(DefaultTableModel) table.getModel();
	        	 int id=o.getIdmon();
	        	 String tenmon=o.getTenmon();
	             String tenloai=o.getTenloai();
	             String donvi=o.getDonvitinh();
	             int soluong=o.getSoluong();
	             double giatien=o.getGiatien();
	             String idanh=o.getIdanhmon();
	             
	             String []DATA= {id+"",tenmon,tenloai,donvi,soluong+"",currencyVN.format(giatien) +"",idanh};
				 
	             tblmodel.addRow(DATA);
				 
			}
	}
	public static void khoitaoCombox_datban()
	{
		String[] array_datban=new String[DsBanActionListener.dsban.size()];
	  	   DefaultComboBoxModel dml_datban=new DefaultComboBoxModel<>();
	  	   for(int i=0;i<DsBanActionListener.dsban.size();i++)
	  	   {
	  		   dml_datban.addElement(DsBanActionListener.dsban.get(i).getIdban());
	  	   }
	  	   comboBox_datban.setModel(dml_datban);
	  	   
	  	   String []array=new String[(Bacctionlistener.listmonan.size())];
	}
//	public static void khoitaoCombox_hoadon()
//	{
//		String[] array_hoadon=new String[DsbanhientaiaAC.listbanhhientai.size()];
//	  	   DefaultComboBoxModel dml_hoadon=new DefaultComboBoxModel<>();
//	  	   for(int i=0;i<DsbanhientaiaAC.listbanhhientai.size();i++)
//	  	   {
//	  		   dml_hoadon.addElement(DsbanhientaiaAC.listbanhhientai.get(i).getIdban());
//	  	   }
//	  	   comboBox_maban.setModel(dml_hoadon);
//	  	   
//	  	   String []array=new String[(DsbanhientaiaAC.listbanhhientai.size())];
//	}
	public static void taoBan(){
        int count=1;
        JButton oldButton=new JButton();
        oldButton.setBounds(0,0,0,0);
        int soban=0;
        for(int i = 0; i < Constants.soBanDoc; i++){
            for(int j = 0; j < Constants.soBanNgang; j++){
                
                
				JButton button = new JButton("bàn "+count,icon3);
                button.setHorizontalTextPosition(JButton.CENTER);
                button.setVerticalTextPosition(JButton.BOTTOM);
                
                button.setBounds(oldButton.getX()+oldButton.getWidth(), oldButton.getY(), Constants.Button_Width, Constants.Button_Height);
//                button.addActionListener(ql);
                button.addActionListener(ds);
                oldButton.setBounds(button.getX(),button.getY() , button.getWidth()+Constants.distance, button.getHeight()+Constants.distance);
               soban++;
               MainView.panel_banhoadon.add(button);
//               String maban="ban"+soban;
//               String tenban="bàn "+soban;
//               String trangthai="Trống";
//               model.ban ban2=new model.ban(maban, tenban, trangthai);
////               updateBan(maban, tenban, trangthai);
//               DsBanActionListener.dsban.add(ban2);
               ban[count-1]=button; 
               count++;
                
                }
            oldButton.setBounds(0, oldButton.getY()+oldButton.getHeight(), 0, 0);
        }
    }
	public static void xoaBan()
	{
		panel_banhoadon.removeAll();
	}
	public static void addBanfromDB()
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	        
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1="select * from ban";	
			ResultSet rs=stmt.executeQuery(sql1);
			while(rs.next())
			{
				String idban=rs.getString(1).trim();
				String tenban=rs.getNString(2).trim();
				String trangthai2=rs.getNString(3).trim();
				model.ban ban_new=new model.ban(idban, tenban, trangthai2);
		        DsBanActionListener.dsban.add(ban_new);	
			}
			DsBanActionListener.printList();
		
		    
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateBan(String idban, String tenban,String trangthai)
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1="update ban set idban='"+idban+"',tenban=N'"+tenban+"',trangthai=N'"+trangthai+"'where idban='"+idban+"'";	
			int rs=stmt.executeUpdate(sql1);
			
	
		    
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	public static void capnhaptrangthaiBan(String idban, String tenban,String trangthai)
	{
		String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=quanliquancf;integratedSecurity=false;trustServerCertificate=true";
		String name="viet2";
		String pass="123";
		try {
	
			Class.forName(drivername);
		
			Connection con=DriverManager.getConnection(url, name, pass);
			java.sql.Statement stmt=con.createStatement();
			String sql1="update ban set idban='"+idban+"',tenban=N'"+tenban+"',trangthai=N'"+trangthai+"'where idban='"+idban+"'";	
			boolean rs=stmt.execute(sql1);
			
	
		    
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
