package player;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import injury.InjuryPlayerFrame;
import country.PicplayerFrame;
import country.StadiumFrame;
import schedule.ScheduleFrame;
import orders.OrderFrame;

public class FormationFrame extends JFrame implements ActionListener, MouseListener, MouseMotionListener{	

	private JPanel panCenter;
	private JButton btn1;
	private JPanel Infopanel;
	private JPanel Infoaddpanel;
	private JTextField numtf;
	private JTextField nametf;
	private JTextField agetf;
	private JTextField heighttf;
	private JTextField weighttf;
	private JTextField searchnametf;
	private JButton searchnamebtn;
	private JButton searchallbtn;
	private JComboBox combo;
	private JButton addbtn;
	private String inputnum;
	private String inputname;
	private String inputage;
	private String inputheight;
	private Object inputweight;
	private String inputposition;
	private String pn;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btnA;
	private JButton btnB;
	private ImageIcon img1;
	private ImageIcon img2;
	private ImageIcon img3;
	private ImageIcon img4;
	private ImageIcon img5;
	private ImageIcon img6;
	private ImageIcon img7;
	private ImageIcon img8;
	private ImageIcon img9;
	private ImageIcon img10;
	private ImageIcon img11;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private ImageIcon img;
	private JLabel imglbl;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	public FormationFrame(String title) {

		setTitle(title);
		setSize(1010, 639);
		setLocation(570, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);
		setLayout(null);
		
		Container c = getContentPane();
		c.setBackground(Color.LIGHT_GRAY);
		
		panCenter = new JPanel();
		panCenter.setBackground(new Color(0xEDEDED));
		panCenter.setBounds(0, 40, 1000, 600);
					
//맨위 버튼 ---------------------------------------------------------
		btn1 = new JButton("후보 선수 관리");
		btn1.setBounds(10, 10, 120, 30);
		btn1.setBackground(new Color(0xCECECE));
		btn1.setBorderPainted(false); // 버튼 테두리 없애기
		btn1.addActionListener(this);
		
		btn2 = new JButton("선발 선수 관리");
		btn2.setBounds(140, 10, 120, 30);
		btn2.setBackground(new Color(0xCECECE));
		btn2.setBorderPainted(false); // 버튼 테두리 없애기
		btn2.addActionListener(this);
		
		btn3 = new JButton("포메이션");
		btn3.setBounds(270, 10, 120, 30);
		btn3.setBackground(new Color(0xEDEDED));
		btn3.setBorderPainted(false); // 버튼 테두리 없애기
		btn3.addActionListener(this);
		
		btn4 = new JButton("부상자 관리");
		btn4.setBounds(400, 10, 120, 30);
		btn4.setBackground(new Color(0xCECECE));
		btn4.setBorderPainted(false); // 버튼 테두리 없애기
		btn4.addActionListener(this);
		
		btn5 = new JButton("선수 사진");
		btn5.setBounds(530, 10, 120, 30);
		btn5.setBackground(new Color(0xCECECE));
		btn5.setBorderPainted(false); // 버튼 테두리 없애기
		btn5.addActionListener(this);
		
		btn6 = new JButton("경기장");
		btn6.setBounds(660, 10, 120, 30);
		btn6.setBackground(new Color(0xCECECE));
		btn6.setBorderPainted(false); // 버튼 테두리 없애기
		btn6.addActionListener(this);
		
		btn7 = new JButton("식단"); 
		btn7.setBounds(790, 10, 80, 30);
		btn7.setBackground(new Color(0xCECECE));
		btn7.setBorderPainted(false); // 버튼 테두리 없애기
		btn7.addActionListener(this);
		
		btn8 = new JButton("일정");
		btn8.setBounds(880, 10, 80, 30);
		btn8.setBackground(new Color(0xCECECE)); 
		btn8.setBorderPainted(false); // 버튼 테두리 없애기
		btn8.addActionListener(this);

		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);		
//맨위 버튼 ---------------------------------------------------------		

//포메이션 A,B 버튼	---------------------------------------------------------	
		btnA = new JButton("포메이션 A");
		btnA.setBounds(30, 70, 100, 20);
		btnA.addActionListener(this);
		btnA.setBackground(Color.LIGHT_GRAY);
		
		btnB = new JButton("포메이션 B");
		btnB.setBounds(150, 70, 100, 20);
		btnB.addActionListener(this);
		btnB.setBackground(Color.LIGHT_GRAY);
		
		add(btnA);
		add(btnB);
//포메이션 A,B 버튼	---------------------------------------------------------
		
//유니폼 레이블---------------------------------------------------------		
		img = new ImageIcon("images/soccerground.jpg");
		img1 = new ImageIcon("images/uniformkeep.png");
		img2 = new ImageIcon("images/uniform.png");
		img3 = new ImageIcon("images/uniform.png");
		img4 = new ImageIcon("images/uniform.png");
		img5 = new ImageIcon("images/uniform.png");
		img6 = new ImageIcon("images/uniform.png");
		img7 = new ImageIcon("images/uniform.png");
		img8 = new ImageIcon("images/uniform.png");
		img9 = new ImageIcon("images/uniform.png");
		img10 = new ImageIcon("images/uniform.png");
		img11 = new ImageIcon("images/uniform.png");
		
		imglbl = new JLabel(img);
		imglbl.setBounds(-9, 16, 1010, 609);
		imglbl.addMouseListener(this);
		
		//GK
		lbl1 = new JLabel();
		lbl1.setText("No.21");
		lbl1.setIcon(img1);
		lbl1.setHorizontalTextPosition(JLabel.CENTER);
		lbl1.setVerticalTextPosition(JLabel.BOTTOM);
		lbl1.setSize(100, 100);
		lbl1.setLocation(885, 265);
		//LWB
		lbl2 = new JLabel();
		lbl2.setText("No.3");
		lbl2.setIcon(img2);
		lbl2.setHorizontalTextPosition(JLabel.CENTER);
		lbl2.setVerticalTextPosition(JLabel.BOTTOM);
		lbl2.setSize(100, 100);
		lbl2.setLocation(669, 425);
		lbl2.addMouseListener(this);
		lbl2.addMouseMotionListener(this);
		//RB
		lbl3 = new JLabel();
		lbl3.setText("No.5");
		lbl3.setIcon(img3);
		lbl3.setHorizontalTextPosition(JLabel.CENTER);
		lbl3.setVerticalTextPosition(JLabel.BOTTOM);
		lbl3.setSize(100, 100);
		lbl3.setLocation(741, 325);
		lbl3.addMouseListener(this);
		lbl3.addMouseMotionListener(this);
		//LB
		lbl4 = new JLabel(img4);
		lbl4.setText("No.4");
		lbl4.setIcon(img4);
		lbl4.setHorizontalTextPosition(JLabel.CENTER);
		lbl4.setVerticalTextPosition(JLabel.BOTTOM);
		lbl4.setSize(100, 100);
		lbl4.setLocation(741, 205);
		lbl4.addMouseListener(this);
		lbl4.addMouseMotionListener(this);
		//MF
		lbl5 = new JLabel(img5);
		lbl5.setText("No.23");
		lbl5.setIcon(img5);
		lbl5.setHorizontalTextPosition(JLabel.CENTER);
		lbl5.setVerticalTextPosition(JLabel.BOTTOM);
		lbl5.setSize(100, 100);
		lbl5.setLocation(669, 103);
		lbl5.addMouseListener(this);
		lbl5.addMouseMotionListener(this);
		//MF
		lbl6 = new JLabel(img6);
		lbl6.setText("No.11");
		lbl6.setIcon(img6);
		lbl6.setHorizontalTextPosition(JLabel.CENTER);
		lbl6.setVerticalTextPosition(JLabel.BOTTOM);
		lbl6.setSize(100, 100);
		lbl6.setLocation(367, 417);
		lbl6.addMouseListener(this);
		lbl6.addMouseMotionListener(this);
		//MF
		lbl7 = new JLabel(img7);
		lbl7.setText("No.10");
		lbl7.setIcon(img7);
		lbl7.setHorizontalTextPosition(JLabel.CENTER);
		lbl7.setVerticalTextPosition(JLabel.BOTTOM);
		lbl7.setSize(100, 100);
		lbl7.setLocation(462, 191);
		lbl7.addMouseListener(this);
		lbl7.addMouseMotionListener(this);
		//MF
		lbl8 = new JLabel(img8);
		lbl8.setText("No.16");
		lbl8.setIcon(img8);
		lbl8.setHorizontalTextPosition(JLabel.CENTER);
		lbl8.setVerticalTextPosition(JLabel.BOTTOM);
		lbl8.setSize(100, 100);
		lbl8.setLocation(462, 334);
		lbl8.addMouseListener(this);
		lbl8.addMouseMotionListener(this);
		//MF
		lbl9 = new JLabel(img9);
		lbl9.setText("No.19");
		lbl9.setIcon(img9);
		lbl9.setHorizontalTextPosition(JLabel.CENTER);
		lbl9.setVerticalTextPosition(JLabel.BOTTOM);
		lbl9.setSize(100, 100);
		lbl9.setLocation(367, 90);
		lbl9.addMouseListener(this);
		lbl9.addMouseMotionListener(this);
		//FW
		lbl10 = new JLabel(img10);
		lbl10.setText("No.22");
		lbl10.setIcon(img10);
		lbl10.setHorizontalTextPosition(JLabel.CENTER);
		lbl10.setVerticalTextPosition(JLabel.BOTTOM);
		lbl10.setSize(100, 100);
		lbl10.setLocation(111, 330);
		lbl10.addMouseListener(this);
		lbl10.addMouseMotionListener(this);
		//FW
		lbl11 = new JLabel(img11);
		lbl11.setText("No.7");
		lbl11.setIcon(img11);
		lbl11.setHorizontalTextPosition(JLabel.CENTER);
		lbl11.setVerticalTextPosition(JLabel.BOTTOM);
		lbl11.setSize(100, 100);
		lbl11.setLocation(111, 195);
		lbl11.addMouseListener(this);
		lbl11.addMouseMotionListener(this);
		
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(lbl5);
		add(lbl6);
		add(lbl7);
		add(lbl8);
		add(lbl9);
		add(lbl10);
		add(lbl11);
		add(imglbl);
//유니폼 레이블---------------------------------------------------------
		
		
		add(panCenter);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		 if ( obj == btnA ) {
			formationA();
		} else if ( obj == btnB ) {
			formationB();
		} else if ( obj == btn1 ) {
			new SubPlayerFrame("구단 관리 프로그램");
			dispose();
		} else if ( obj == btn2 ) {
			new MainPlayerFrame("구단 관리 프로그램");
			dispose();		
		} else if ( obj == btn4 ) {
			new InjuryPlayerFrame("구단 관리 프로그램");
			dispose();
		} else if ( obj == btn5 ) {
			new PicplayerFrame("구단 관리 프로그램");
			dispose();
		} else if ( obj == btn6 ) {
			new StadiumFrame("구단 관리 프로그램");
			dispose();
		} else if ( obj == btn7 ) {
			new OrderFrame("구단 관리 프로그램");
			dispose();
		} else if ( obj == btn8 ) {
			new ScheduleFrame("구단 관리 프로그램");
			dispose();
		}
		
}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void mouseDragged(MouseEvent e) {
		Object obj = e.getSource();
		int x = e.getX();
		int y = e.getY();
		
		if ( obj == lbl2 ) {
			lbl2.setLocation(lbl2.getX()+x-50, lbl2.getY()+y-30);
		} else if ( obj == lbl3 ) {
			lbl3.setLocation(lbl3.getX()+x-50, lbl3.getY()+y-30);
		} else if ( obj == lbl4 ) {
			lbl4.setLocation(lbl4.getX()+x-50, lbl4.getY()+y-30);
		} else if ( obj == lbl5 ) {
			lbl5.setLocation(lbl5.getX()+x-50, lbl5.getY()+y-30);
		} else if ( obj == lbl6 ) {
			lbl6.setLocation(lbl6.getX()+x-50, lbl6.getY()+y-30);
		} else if ( obj == lbl7 ) {
			lbl7.setLocation(lbl7.getX()+x-50, lbl7.getY()+y-30);
		} else if ( obj == lbl8 ) {
			lbl8.setLocation(lbl8.getX()+x-50, lbl8.getY()+y-30);
		} else if ( obj == lbl9 ) {
			lbl9.setLocation(lbl9.getX()+x-50, lbl9.getY()+y-30);
		} else if ( obj == lbl10 ) {
			lbl10.setLocation(lbl10.getX()+x-50, lbl10.getY()+y-30);
		} else if ( obj == lbl11 ) {
			lbl11.setLocation(lbl11.getX()+x-50, lbl11.getY()+y-30);
		} 
		
	}
			
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}
	
	private void formationA() {
		lbl2.setLocation(669, 425);
		lbl3.setLocation(741, 325);
		lbl4.setLocation(741, 205);
		lbl5.setLocation(669, 103);
		lbl6.setLocation(367, 417);
		lbl7.setLocation(462, 191);
		lbl8.setLocation(462, 334);
		lbl9.setLocation(367, 90);
		lbl10.setLocation(111, 330);
		lbl11.setLocation(111, 195);
	}
	
	private void formationB() {
		lbl2.setLocation(669, 425);
		lbl3.setLocation(741, 325);
		lbl4.setLocation(741, 205);
		lbl5.setLocation(669, 103);
		lbl6.setLocation(437, 265);
		lbl7.setLocation(406, 370);
		lbl8.setLocation(406, 155);
		lbl9.setLocation(330, 465);
		lbl10.setLocation(330, 70);
		lbl11.setLocation(139, 270);
	}
}
