package injury;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DB.DB;
import DB.DBInjuryPlayerList;
import DB.DBPlayerList;
import country.PicplayerFrame;
import country.StadiumFrame;
import player.FormationFrame;
import player.MainPlayerFrame;
import player.SubPlayerFrame;
import schedule.ScheduleFrame;
import orders.OrderFrame;

public class InjuryPlayerFrame extends JFrame implements ActionListener, KeyListener {

	Container c;
	private JPanel panCenter;
	private String sql;
	private JPanel injuryPlayerPanel;
	private JPanel playerPanel;
	private JTable playerTable;
	private JScrollPane playerJsp;
	private JTable injuryPlayerTable;
	private JScrollPane injuryPlayerJsp;
	private JLabel searchInjuryPlayerName;
	private JTextField textInjuryPlayer;
	private JLabel searchPlayerName;
	private JTextField textPlayer;
	private JButton addInjuryBtn;
	private JButton addDeleteBtn;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;

	public InjuryPlayerFrame(String title) {

		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(570, 240);
		setSize(1000, 600);
		setResizable(false);
		setLayout(null);
		
		c = getContentPane();
		c.setBackground(Color.LIGHT_GRAY);

		panCenter = new JPanel();
		panCenter.setBackground(new Color(0xEEEEEE));
		panCenter.setBounds(0, 40, 1000, 600);
		
		injuryPlayerPanel = new JPanel();
		injuryPlayerPanel.setBackground(new Color(0xEDEDED));
		injuryPlayerPanel.setBounds(10, 80, 455, 470);
		injuryPlayerPanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		add(injuryPlayerPanel);

		playerPanel = new JPanel();
		playerPanel.setBackground(new Color(0xEDEDED));
		playerPanel.setBounds(480, 80, 495, 470);
		playerPanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		add(playerPanel);
		
		// 부상자 리스트 테이블 -----------------------------------------
		
		JLabel lbl1 = new JLabel("부상 선수명단");
		lbl1.setBounds(10, 70, 80, 20);
		lbl1.setOpaque(true); // 레이블에 배경줄 때 필요함
		lbl1.setBackground(new Color(0xEDEDED));
		add(lbl1);

		searchInjuryPlayerName = new JLabel("이름 검색");
		searchInjuryPlayerName.setBounds(65, 100, 125, 20);

		textInjuryPlayer = new JTextField();
		textInjuryPlayer.setBounds(125, 100, 170, 20);
		textInjuryPlayer.addKeyListener(this);

		addDeleteBtn = new JButton("부상삭제");
		addDeleteBtn.setBounds(320, 100, 90, 20);
		addDeleteBtn.setBackground(Color.LIGHT_GRAY);
		addDeleteBtn.addActionListener(this);

		add(searchInjuryPlayerName);
		add(textInjuryPlayer);
		add(addDeleteBtn);

		String[][] injuryPlayers = DBInjuryPlayerList.getInjuryPlayers();
		String[] injuryPlayersHeader = { "등번호", "이름", "나이", "포지션", "부상부위", "부상증상" };

		injuryPlayerTable = new JTable(injuryPlayers, injuryPlayersHeader);
		injuryPlayerTable.setRowHeight(30);
		injuryPlayerTable.setAlignmentX(0);
		injuryPlayerTable.setFont(new Font("고딕", Font.BOLD, 15));
		injuryPlayerTable.setPreferredScrollableViewportSize(new Dimension(800, 600));
		injuryPlayerTable.setFillsViewportHeight(true);

		injuryPlayerJsp = new JScrollPane(injuryPlayerTable);
		injuryPlayerJsp.setBounds(22, 140, 430, 395);
		add(injuryPlayerJsp);
		
		//------------------------------------------------------------
		
		
		// 선수 리스트 테이블 --------------------------------------------
		
		JLabel lbl2 = new JLabel("선수 리스트");
		lbl2.setBounds(480, 70, 80, 20);
		lbl2.setOpaque(true); // 레이블에 배경줄 때 필요함
		lbl2.setBackground(new Color(0xEDEDED));
		add(lbl2);

		searchPlayerName = new JLabel("이름 검색");
		searchPlayerName.setBounds(555, 100, 125, 20);

		textPlayer = new JTextField();
		textPlayer.setBounds(615, 100, 170, 20);
		textPlayer.addKeyListener(this);

		addInjuryBtn = new JButton("부상추가");
		addInjuryBtn.setBounds(810, 100, 90, 20);
		addInjuryBtn.setBackground(Color.LIGHT_GRAY);
		addInjuryBtn.addActionListener(this);

		add(searchPlayerName);
		add(textPlayer);
		add(addInjuryBtn);

		String[][] players = DBPlayerList.getPlayers();
		String[] playersHeader = { "등번호", "이름", "나이", "키", "몸무게", "포지션" };

		playerTable = new JTable(players, playersHeader);
		playerTable.setRowHeight(30);
		playerTable.setAlignmentX(0);
		playerTable.setFont(new Font("고딕", Font.BOLD, 15));
		playerTable.setPreferredScrollableViewportSize(new Dimension(800, 600));
		playerTable.setFillsViewportHeight(true);

		playerJsp = new JScrollPane(playerTable);
		playerJsp.setBounds(495, 140, 470, 395);
		add(playerJsp);
		
		//------------------------------------------------------------

		
		// 맨 윗부분 버튼 -----------------------------------------------
		
		btn1 = new JButton("후보 선수 관리");
		btn1.setBounds(10, 10, 120, 30);
		btn1.setBackground(new Color(0xCECECE));
		btn1.setBorderPainted(false);	// 버튼 테두리 없애기
		btn1.addActionListener(this);

		btn2 = new JButton("선발 선수 관리");
		btn2.setBounds(140, 10, 120, 30);
		btn2.setBackground(new Color(0xCECECE));
		btn2.setBorderPainted(false);	// 버튼 테두리 없애기
		btn2.addActionListener(this);

		btn3 = new JButton("포메이션");
		btn3.setBounds(270, 10, 120, 30);
		btn3.setBackground(new Color(0xCECECE));
		btn3.setBorderPainted(false);	// 버튼 테두리 없애기
		btn3.addActionListener(this);

		btn4 = new JButton("부상자 관리");
		btn4.setBounds(400, 10, 120, 30);
		btn4.setBackground(new Color(0xEDEDED));
		btn4.setBorderPainted(false);	// 버튼 테두리 없애기
		
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
		
		//------------------------------------------------------------
		
		add(playerPanel);
		add(injuryPlayerPanel);
		add(panCenter);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();

		String pn = null;
		String name = null;
		String age = null;
		String height = null;
		String weight = null;
		String position = null;

		// 부상자 추가
		if (obj == addInjuryBtn) 
		{
			int select = playerTable.getSelectedRow();	// 선택된 행의 값을 int 값으로 select에 저장

			if (JOptionPane.showConfirmDialog(this, "선수를 부상명단에 추가하시겠습니까?", "추가", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				new InjurySelect(select);
			}

		}

		// 부상자 삭제
		if (obj == addDeleteBtn)
		{
			int select = injuryPlayerTable.getSelectedRow();	// 선택된 행의 값을 int 값으로 select에 저장

			sql = "select * from INJURYPLAYER";
			ResultSet rs = DB.getResult(sql);

			for (int i = 0; i < select + 1; i++) {
				try {
					rs.next();
					pn = rs.getString("PN");
					name = rs.getString("NAME");
					age = rs.getString("AGE");
					height = rs.getString("HEIGHT");
					weight = rs.getString("WEIGHT");
					position = rs.getString("POSITION");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (JOptionPane.showConfirmDialog(this, "부상 선수를 명단에서 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) 
			{
				// 부상 선수 명단에 값을 추가하고, 추가된 값과 동일한 값을 선수 리스트에서 삭제 
				
				// 부상 선수명단에서 삭제
				sql = "DELETE FROM CBAN.INJURYPLAYER\r\n" + "WHERE PN=" + pn + "";
				DB.executeSQL(sql);

				// 선수 리스트에 값 추가
				sql = "INSERT INTO CBAN.PLAYER\r\n" + "(PN, NAME, AGE, HEIGHT, WEIGHT, \"POSITION\")\r\n" + "VALUES("
						+ pn + ", '" + name + "', " + age + ", " + height + ", " + weight + ", '" + position + "')";
				DB.executeSQL(sql);

				new InjuryPlayerFrame("구단 관리 프로그램");
				dispose();
			}
		}

		if ( obj == btn1 ) {
			new SubPlayerFrame("구단 관리 프로그램");
			dispose();
		} else if ( obj == btn2 ) {
			new MainPlayerFrame("구단 관리 프로그램");
			dispose();		
		} else if ( obj == btn3 ) {
			new FormationFrame("구단 관리 프로그램");
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {

		// 부상자 테이블 검색
		String injPlayer = textInjuryPlayer.getText();
		// 현재 행이 데이터를 갖고 있지 않으면 정리가 되도록함
		TableRowSorter<TableModel> injuryPlayerTrs = new TableRowSorter<>(injuryPlayerTable.getModel());
		injuryPlayerTable.setRowSorter(injuryPlayerTrs);
		injuryPlayerTrs.setRowFilter(RowFilter.regexFilter(injPlayer));

		// 선수 테이블 검색
		String player = textPlayer.getText();
		// 현재 행이 데이터를 갖고 있지 않으면 정리가 되도록함
		TableRowSorter<TableModel> playerTrs = new TableRowSorter<>(playerTable.getModel());
		playerTable.setRowSorter(playerTrs);
		playerTrs.setRowFilter(RowFilter.regexFilter(player));
	}
}
