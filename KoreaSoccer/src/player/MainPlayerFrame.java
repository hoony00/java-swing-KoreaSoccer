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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DB.DB;
import DB.MainPlayerList;
import DB.SubPlayerList;
import injury.InjuryPlayerFrame;
import country.PicplayerFrame;
import country.StadiumFrame;
import schedule.ScheduleFrame;
import orders.OrderFrame;

public class MainPlayerFrame extends JFrame implements ActionListener, KeyListener{	

	private JPanel panCenter;
	private JButton btn1;
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
	private JPanel SubInfopanel;
	private JPanel MainInfopanel;
	private JButton trbtn;
	private MainPlayerList Mainmodel;
	private JTable Maintable;
	private JScrollPane Mainsp;
	private SubPlayerList Submodel;
	private JTable Subtable;
	private JScrollPane Subsp;
	private String sql;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	public MainPlayerFrame(String title) {

		setTitle(title);
		setSize(1000, 600);
		setLocation(570, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		Container c = getContentPane();
		c.setBackground(Color.LIGHT_GRAY);
		
		panCenter = new JPanel();
		panCenter.setBackground(new Color(0xEDEDED));
		panCenter.setBounds(0, 40, 1000, 600);
		
		MainInfopanel = new JPanel();
		MainInfopanel.setBackground(new Color(0xEDEDED));
		MainInfopanel.setBounds(10, 80, 440, 450);
		MainInfopanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1)));
		
		SubInfopanel = new JPanel();
		SubInfopanel.setBackground(new Color(0xEDEDED));
		SubInfopanel.setBounds(535, 80, 440, 450);
		SubInfopanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1)));

//맨위 버튼 ---------------------------------------------------------		
		btn1 = new JButton("후보 선수 관리");
		btn1.setBounds(10, 10, 120, 30);
		btn1.setBackground(new Color(0xCECECE));
		btn1.setBorderPainted(false); // 버튼 테두리 없애기
		btn1.addActionListener(this);
		
		btn2 = new JButton("선발 선수 관리");
		btn2.setBounds(140, 10, 120, 30);
		btn2.setBackground(new Color(0xEDEDED));
		btn2.setBorderPainted(false); // 버튼 테두리 없애기
		btn2.addActionListener(this);
		
		btn3 = new JButton("포메이션");
		btn3.setBounds(270, 10, 120, 30);
		btn3.setBackground(new Color(0xCECECE));
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
		
//트레이드 버튼 ---------------------------------------------------------
		trbtn = new JButton("교체");
		trbtn.setBounds(460, 260, 60, 30);
		trbtn.setBackground(new Color(0xCECECE));
		trbtn.setBorderPainted(false); // 버튼 테두리 없애기
		trbtn.addActionListener(this);
		
		add(trbtn);
//트레이드 버튼 ---------------------------------------------------------
		
//선발, 후보 선수 리스트 레이블 ---------------------------------------------------------		
		JLabel Mainlbl = new JLabel("선발 선수 리스트");
		Mainlbl.setBounds(10, 70, 100, 20);
		Mainlbl.setOpaque(true); // 레이블에 배경줄 때 필요함
		Mainlbl.setBackground(new Color(0xEDEDED));
		
		JLabel Sublbl = new JLabel("후보 선수 리스트");
		Sublbl.setBounds(535, 70, 100, 20);
		Sublbl.setOpaque(true); // 레이블에 배경줄 때 필요함
		Sublbl.setBackground(new Color(0xEDEDED));
		
		add(Mainlbl);
		add(Sublbl);		
//선발, 후보 선수 리스트 레이블 ---------------------------------------------------------

// 선수 리스트 --------------------------------------------------------		
		JLabel searchname = new JLabel("이름 검색");
		searchname.setBounds(560, 120, 120, 20);
				
		searchnametf = new JTextField();
		searchnametf.setBounds(640, 120, 190, 20);
		searchnametf.addKeyListener(this);
				
		add(searchnametf);
		add(searchname);		
//선수 리스트----------------------------------------------------------
		
		
//JTable ---------------------------------------------------------				
		Mainmodel = new MainPlayerList();
		Mainmodel.setData();
				
		Maintable = new JTable(Mainmodel);
		Maintable.setRowHeight(25);
		Maintable.setFont(new Font("고딕",Font.BOLD,15));
		Maintable.setAlignmentX(0);
		Maintable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);			
		
		Mainsp = new JScrollPane(Maintable);
		Mainsp.setBounds(20, 170, 420, 353);      
				
		Submodel = new SubPlayerList();
		Submodel.setData();
				
		Subtable = new JTable(Submodel);
		Subtable.setRowHeight(25);
		Subtable.setFont(new Font("고딕",Font.BOLD,15));
		Subtable.setAlignmentX(0);
		Subtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Subsp = new JScrollPane(Subtable);
		Subsp.setBounds(545, 170, 420, 353);
				
		add(Mainsp);
		add(Subsp);
//JTable ---------------------------------------------------------		
		
		add(MainInfopanel);
		add(SubInfopanel);
		add(panCenter);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if ( obj == btn1 ) {
			new SubPlayerFrame("구단 관리 프로그램");
			dispose();
		} else if ( obj == btn3 ) {
			new FormationFrame("구단 관리 프로그램");
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
		} else if ( obj == trbtn ) {
			
			int Mainselect = Maintable.getSelectedRow();
			int Subselect = Subtable.getSelectedRow();
			String Mainpn = null;
			String Mainname = null;
			String Mainage = null;
			String Mainheight = null;
			String Mainweight = null;
			String Mainposition = null;
			String Subpn = null;
			String Subname = null;
			String Subage = null;
			String Subheight = null;
			String Subweight = null;
			String Subposition = null;

// 선택을 안했을 경우 -------------------------------------------------		
			if ( Mainselect < 0) {
				JOptionPane.showMessageDialog(this, "선발 선수를 선택해주세요.");
				return;		
				}	
			if ( Subselect < 0) {
				JOptionPane.showMessageDialog(this, "후보 선수를 선택해주세요.");
				return;		
				}	
// 선택을 안했을 경우 ------------------------------------------------
			

// 선발 선수 데이터 뽑기-----------------------------------------------		
			sql = "select * from MAINPLAYER";			
			ResultSet rs = DB.getResult(sql);
			
			for (int i = 0; i < Mainselect + 1; i++) {
				try {
					rs.next();
					Mainpn = rs.getString("PN");
					Mainname = rs.getString("NAME");
					Mainage = rs.getString("AGE");
					Mainheight = rs.getString("HEIGHT");
					Mainweight = rs.getString("WEIGHT");
					Mainposition = rs.getString("POSITION");					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
						
// 선발 선수 데이터 뽑기-----------------------------------------
			
// 후보 선수 데이터 뽑기-----------------------------------------			
			sql = "select * from SUBPLAYER";			
			rs = DB.getResult(sql);
			for (int i = 0; i < Subselect + 1; i++) {
				try {
					rs.next();
					Subpn = rs.getString("PN");
					Subname = rs.getString("NAME");
					Subage = rs.getString("AGE");
					Subheight = rs.getString("HEIGHT");
					Subweight = rs.getString("WEIGHT");
					Subposition = rs.getString("POSITION");					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
									
// 후보 선수 데이터 뽑기-----------------------------------------			
			
			if(JOptionPane.showConfirmDialog(this, "선수를 교체하시겠습니까?", "교체", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE)== JOptionPane.YES_OPTION ) {
				
// 선발,후보 삭제--------------------------------------------
			sql = "INSERT INTO CBAN.MAINPLAYER\r\n"
					+ "(PN, NAME, AGE, HEIGHT, WEIGHT, \"POSITION\")\r\n"
					+ "VALUES("+Subpn+", '"+Subname+"', "+Subage+", "+Subheight+", "+Subweight+", '"+Subposition+"')";
			DB.executeSQL(sql);			
			
			sql = "INSERT INTO CBAN.SUBPLAYER\r\n"
					+ "(PN, NAME, AGE, HEIGHT, WEIGHT, \"POSITION\")\r\n"
					+ "VALUES("+Mainpn+", '"+Mainname+"', "+Mainage+", "+Mainheight+", "+Mainweight+", '"+Mainposition+"')";
			DB.executeSQL(sql);
// 선발,후보 삭제--------------------------------------------

// 선발,후보 삽입--------------------------------------------
			sql = "DELETE FROM CBAN.SUBPLAYER\r\n"
					+ "WHERE PN="+Subpn+"";
			DB.executeSQL(sql);
			
			
			sql = "DELETE FROM CBAN.MAINPLAYER\r\n"
					+ "WHERE PN="+Mainpn+"";			
			DB.executeSQL(sql);
// 선발,후보 삽입--------------------------------------------	
			JOptionPane.showMessageDialog(this, "선수가 교체되었습니다.");
			
			new MainPlayerFrame("구단 관리 프로그램");
			dispose();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String val=searchnametf.getText();
        //현재 행이 데이터를 갖고 있지 않으면 정리가 되도록함
        TableRowSorter<TableModel> trs= new TableRowSorter<>(Subtable.getModel());
        Subtable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(val));		
	}
}
