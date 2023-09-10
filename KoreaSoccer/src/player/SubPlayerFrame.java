package player;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DB.DB;
import DB.SubPlayerList;
import injury.InjuryPlayerFrame;
import country.PicplayerFrame;
import country.StadiumFrame;
import schedule.ScheduleFrame;
import orders.OrderFrame;

public class SubPlayerFrame extends JFrame implements ActionListener, MouseListener, KeyListener{	

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
	private String inputweight;
	private String inputposition;
	private String pn;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
    private JTextField search;
    private JTable table;
    private String[][] data;
    private String[] headers;
	private JScrollPane scrollPane;
	private DefaultTableModel tm;
	private JButton delbtn;
	private String sql;
	private SubPlayerList model;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private String name;
	
	public SubPlayerFrame(String title) {

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
		
		Infoaddpanel = new JPanel();
		Infoaddpanel.setBackground(new Color(0xEDEDED));
		Infoaddpanel.setBounds(10, 80, 300, 450);
		Infoaddpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1)));
		
		Infopanel = new JPanel();
		Infopanel.setBackground(new Color(0xEDEDED));
		Infopanel.setBounds(340, 80, 635, 450);
		Infopanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1)));
// 기본 패널 --------------------------------------------------------
		
// 선수 정보 입력 레이블--------------------------------------------		
		JLabel lbl1 = new JLabel("선수 정보입력");
		lbl1.setBounds(10, 70, 80, 20);
		lbl1.setOpaque(true); // 레이블에 배경줄 때 필요함
		lbl1.setBackground(new Color(0xEDEDED));
		
		JLabel lbl2 = new JLabel("선수 리스트");
		lbl2.setBounds(340, 70, 80, 20);
		lbl2.setOpaque(true); // 레이블에 배경줄 때 필요함
		lbl2.setBackground(new Color(0xEDEDED));
		
		JLabel num = new JLabel("번호");
		num.setBounds(50, 100, 60, 20);
		
		JLabel name = new JLabel("이름");
		name.setBounds(50, 150, 60, 20);
		
		JLabel age = new JLabel("나이");
		age.setBounds(50, 200, 60, 20);
		
		JLabel height = new JLabel("키");
		height.setBounds(50, 250, 60, 20);
		
		JLabel weight = new JLabel("몸무게");
		weight.setBounds(50, 300, 60, 20);
		
		JLabel position = new JLabel("포지션");
		position.setBounds(50, 350, 60, 20);
						
		add(lbl1);
		add(lbl2);
		add(num);
		add(name);
		add(age);
		add(height);
		add(weight);
		add(position);
// 선수 정보 입력 레이블--------------------------------------------	
		
// 선수 정보 입력 텍스트필드--------------------------------------------
		numtf = new JTextField();
		numtf.setBounds(120, 100, 120, 20);	
		
		nametf = new JTextField();
		nametf.setBounds(120, 150, 120, 20);	
		
		agetf = new JTextField();
		agetf.setBounds(120, 200, 120, 20);	
		
		heighttf = new JTextField();
		heighttf.setBounds(120, 250, 120, 20);	
		
		weighttf = new JTextField();
		weighttf.setBounds(120, 300, 120, 20);
		
		combo = new JComboBox<>();
		combo.setBounds(120, 350, 120, 20);
		combo.addItem("");
		combo.addItem("FW");
		combo.addItem("MF");
		combo.addItem("DF");
		combo.addItem("GK");
		combo.setBackground(Color.WHITE);
		
		addbtn = new JButton("추가");
		addbtn.setBounds(120, 430, 70, 30);
		addbtn.setBackground(Color.LIGHT_GRAY);
		addbtn.addActionListener(this);
		
		delbtn = new JButton("삭제");
		delbtn.setBounds(890, 485, 70, 30);
		delbtn.setBackground(Color.LIGHT_GRAY);
		delbtn.addActionListener(this);
				
		add(delbtn);
		add(addbtn);
		add(combo);		
		add(numtf);
		add(nametf);
		add(agetf);
		add(heighttf);
		add(weighttf);		
// 선수 정보 입력 텍스트필드--------------------------------------------		
		
// 선수 리스트 검색--------------------------------------------------------		
		JLabel searchname = new JLabel("이름 검색");
		searchname.setBounds(400, 100, 120, 20);
		
		searchnametf = new JTextField();
		searchnametf.setBounds(480, 100, 190, 20);
		searchnametf.addKeyListener(this);		
		
		add(searchnametf);
		add(searchname);		
//선수 리스트 검색----------------------------------------------------------
		
//맨위 버튼 ---------------------------------------------------------		
		btn1 = new JButton("후보 선수 관리");
		btn1.setBounds(10, 10, 120, 30);
		btn1.setBackground(new Color(0xEDEDED));
		btn1.setBorderPainted(false); // 버튼 테두리 없애기
		
		btn2 = new JButton("선발 선수 관리");
		btn2.setBounds(140, 10, 120, 30);
		btn2.setBackground(new Color(0xCECECE));
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
		
//JTable ---------------------------------------------------------				
		model = new SubPlayerList();
		model.setData();
		
		table = new JTable(model);
		table.addMouseListener(this);
		table.setRowHeight(30);
		table.setFont(new Font("고딕",Font.BOLD,15));
		table.setAlignmentX(0);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(360, 150, 600, 320);      
        
        add(scrollPane);		
//JTable ---------------------------------------------------------		
		add(Infopanel);
		add(Infoaddpanel);
		add(panCenter);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		sql = "select * from SUBPLAYER";
		
		ResultSet rs = DB.getResult(sql);
		
		if( obj == addbtn ){
// 빈칸이 있는 경우 --------------------------------------------			
				if( numtf.getText().equals("") ) {
					JOptionPane.showMessageDialog(this, "번호를 입력해주세요.");
					return;
				} 
				inputnum = numtf.getText();
				
				try {
					while (rs.next()) {
						pn = rs.getString("PN");
						
						if( pn.equals(numtf.getText())) {
							JOptionPane.showMessageDialog(this, "중복된 번호 입니다.");
							return;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
				if ( nametf.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "이름를 입력해주세요.");
					return;
				} 
				inputname = nametf.getText();
				
				if ( agetf.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "나이를 입력해주세요.");
					return;
				} 
				inputage = agetf.getText();
				
				if ( heighttf.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "키를 입력해주세요.");
					return;
				} 
				inputheight = heighttf.getText();
				
				if ( weighttf.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "몸무게를 입력해주세요.");
					return;
				} 
				inputweight = weighttf.getText();
				
				if (combo.getSelectedItem().toString().equals("") ) {
					JOptionPane.showMessageDialog(this, "포지션을 선택해주세요.");
					return;
				}				
				inputposition = combo.getSelectedItem().toString();
// 빈칸이 있는 경우---------------------------------------------------------------
				
// 모든 칸을 채웠을 경우 ------------------------------------------------------------------				
				sql = "INSERT INTO CBAN.SUBPLAYER\r\n"
						+ "(PN, NAME, AGE, HEIGHT, WEIGHT, \"POSITION\")\r\n"
						+ "VALUES("+inputnum+", '"+inputname+"', "+inputage+", "+inputheight+", "+inputweight+", '"+inputposition+"')";
				
				DB.executeSQL(sql);
				
				JOptionPane.showMessageDialog(this, "선수가 추가되었습니다.");
				
				new SubPlayerFrame("구단 관리 프로그램");
				dispose();
// 모든 칸을 채웠을 경우 ------------------------------------------------------------------				
		} else if ( obj == btn2 ) {
			new MainPlayerFrame("구단 관리 프로그램");
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
		} else if ( obj == delbtn ) {
				
			int select = table.getSelectedRow();
			String delnum = null;		
			
			for (int i = 0; i < select + 1; i++) {
				try {
					rs.next();
					delnum = rs.getString("PN");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
			
			if ( select < 0) {
				JOptionPane.showMessageDialog(this, "선수를 선택해주세요.");
				return;		
				}			
			
			if(JOptionPane.showConfirmDialog(this, "선수를 삭제하시겠습니까?", "삭제", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE)== JOptionPane.YES_OPTION ) {
			sql = "DELETE FROM CBAN.SUBPLAYER WHERE PN="+delnum;
			
			DB.executeSQL(sql);
			
			JOptionPane.showMessageDialog(this, "선수가 삭제되었습니다.");	
			}
			
			new SubPlayerFrame("구단 관리 프로그램");
			dispose();
			
		} 				
	} 

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

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
        TableRowSorter<TableModel> trs= new TableRowSorter<>(table.getModel());
        table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(val));
		
	}
}
