package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.LoginAc;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	public static JTextField tx_taikhoan;
	public static JPasswordField tx_pass;
    public Login()
    {   
    	this.setBounds(0, 0, 600, 400);
    	this.setTitle("Đăng nhập");
    	getContentPane().setLayout(null);
    	LoginAc loginac=new LoginAc();
    	JPanel panel = new JPanel();
    	panel.setBackground(new Color(0, 128, 64));
    	panel.setBounds(0, 0, 228, 363);
    	getContentPane().add(panel);
    	
    	JLabel lblNewLabel_2 = new JLabel("New label");
    	lblNewLabel_2.setBounds(0, 158, 228, 205);
    	ImageIcon originalIcon=new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\setup-quan-cafe-1.jpg");
    	Image fixImage=originalIcon.getImage().getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
    	ImageIcon icon=new ImageIcon(fixImage);
    	panel.setLayout(null);
    	lblNewLabel_2.setIcon(icon);
   
    	panel.add(lblNewLabel_2);
    	
    	JLabel lblNewLabel_4 = new JLabel("New label");
    	lblNewLabel_4.setBounds(0, 0, 228, 159);
    	panel.add(lblNewLabel_4);
    	
   
    	
    	ImageIcon originalIcon2=new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\capuchino.jpg");
     	Image fixImage2=originalIcon2.getImage().getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH);
    	ImageIcon icon2=new ImageIcon(fixImage2);
    	lblNewLabel_4.setIcon(icon2);
    	JPanel panel_1 = new JPanel();
    	panel_1.setBackground(new Color(255, 228, 181));
    	panel_1.setBounds(226, 0, 360, 363);
    	getContentPane().add(panel_1);
    	panel_1.setLayout(null);
    	
    	JButton b_dangnhap = new JButton("Đăng nhập");
    	b_dangnhap.setFont(new Font("Tahoma", Font.PLAIN, 9));
    	b_dangnhap.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\staff.png"));
    	b_dangnhap.setBounds(32, 200, 135, 77);
    	panel_1.add(b_dangnhap);
        b_dangnhap.addActionListener(loginac);
    	
    	JButton b_huy = new JButton("Hủy");
    	b_huy.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	b_huy.setIcon(new ImageIcon("D:\\doancuoikijava\\Quanliquancf2\\iconfolder\\enter.png"));
    	b_huy.setBounds(192, 205, 104, 72);
    	panel_1.add(b_huy);
    	
    	tx_taikhoan = new JTextField();
    	tx_taikhoan.setBounds(113, 76, 96, 19);
    	panel_1.add(tx_taikhoan);
    	tx_taikhoan.setColumns(10);
    	
    	tx_pass = new JPasswordField();
    	tx_pass.setBounds(113, 130, 96, 19);
    	panel_1.add(tx_pass);
    	
    	JLabel lblNewLabel = new JLabel("Tài khoản");
    	lblNewLabel.setBounds(32, 79, 55, 13);
    	panel_1.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
    	lblNewLabel_1.setBounds(32, 133, 55, 13);
    	panel_1.add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_3 = new JLabel("Cà Phê Trí Việt");
    	lblNewLabel_3.setBounds(104, 10, 155, 43);
    	panel_1.add(lblNewLabel_3);
    	lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
    	lblNewLabel_3.setForeground(Color.DARK_GRAY);
    	this.setVisible(true);
    }
}
