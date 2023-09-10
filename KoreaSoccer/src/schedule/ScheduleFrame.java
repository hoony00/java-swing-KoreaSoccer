package schedule;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import injury.InjuryPlayerFrame;
import country.Gana;
import country.PicplayerFrame;
import country.Porto;
import country.StadiumFrame;
import country.Uruguay;
import player.FormationFrame;
import player.MainPlayerFrame;
import player.SubPlayerFrame;
import orders.OrderFrame;

public class ScheduleFrame extends JFrame implements ActionListener {

	JButton[] buttons = new JButton[49]; // 요일 및 날짜를 표현하는 버튼의 수
	String[] dotw = { "일", "월", "화", "수", "목", "금", "토" }; // dotw = DAY OF THE WEEK(요일)
	Container c;
	Calendar calendar;
	int year, month;
	private JButton beforeButton;
	private JButton afterButton;
	JLabel day = new JLabel();
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JPanel panCenter;
	private JTextField tf;
	private JLabel memoday;
	private JButton memosave;
	private String clickday;
	private String view = "";
	private JButton memodelete;
	private JPanel edgePanel;
	private JPanel edgePanel2;
	
	public ScheduleFrame(String title) {
		
		// 달력 값을 관리하는 기본 메소드 _ 이진우
		calManage();
		
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
		
		edgePanel = new JPanel();
		edgePanel.setLayout(null);
		edgePanel.setBackground(new Color(0xEDEDED));
		edgePanel.setBounds(10, 80, 520, 450);
		edgePanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1)));
		
		add(edgePanel);	
		
		edgePanel2 = new JPanel();
		edgePanel2.setLayout(null);
		edgePanel2.setBackground(new Color(0xEDEDED));
		edgePanel2.setBounds(540, 80, 435, 450);
		edgePanel2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1)));
		
		add(edgePanel2);	
		
		// 달력을 붙이는 패널 _ 이진우 -----------------------------------------------------------
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(0xEDEDED));
		panel2.setBounds(10, 80, 500, 340);
		panel2.setLayout(new GridLayout(7, 7, 7, 7));	
		// _ 이진우 --------------------------------------------------------------------------
		
		// 달력의 값을 한 달 전으로 바꿈 _ 이진우 --------------------------------------------------
		beforeButton = new JButton("<");
		beforeButton.setBackground(new Color(0xEDEDED));
		beforeButton.setBounds(40, 28, 41, 25);
		edgePanel.add(beforeButton); 
		beforeButton.addActionListener(this);				
		
		day.setText("  " + year + "년 " + month + "월 구단 일정  ");
		day.setFont(new Font("monospaced", Font.BOLD, 25));
		day.setBounds(90, 0, 400, 80);
		edgePanel.add(day);
		// _ 이진우 --------------------------------------------------------------------------
		
		// 달력의 값을 한 달 후로 바꿈 _ 이진우 ----------------------------------------------------
		afterButton = new JButton(">");
		afterButton.setBackground(new Color(0xEDEDED));
		afterButton.setBounds(430, 28, 41, 25);
		edgePanel.add(afterButton);
		afterButton.addActionListener(this);	
		
		day.setText("  " + year + "년 " + month + "월 구단 일정  ");
		day.setFont(new Font("monospaced", Font.BOLD, 25));
		day.setBounds(90, 0, 400, 80);
		edgePanel.add(day);
		// _ 이진우 --------------------------------------------------------------------------
		
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
		btn3.setBackground(new Color(0xCECECE));
		btn3.setBorderPainted(false);	// 버튼 테두리 없애기
		btn3.addActionListener(this);
		
		btn4 = new JButton("부상자 관리");
		btn4.setBounds(400, 10, 120, 30);
		btn4.setBackground(new Color(0xCECECE));
		btn4.setBorderPainted(false);	// 버튼 테두리 없애기
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
		btn8.setBackground(new Color(0xEDEDED)); 
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
		
		// 반복문을 이용하여 버튼을 패널에 붙임 _ 이진우 --------------------------------------------------
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setBackground(new Color(0xEDEDED));
			panel2.add(buttons[i]);
			buttons[i].addActionListener(this);

			if (i < 7) 
			{
				buttons[i].setText(dotw[i]);
				buttons[i].setFont(new Font("monospaced", Font.BOLD, 16));
				panel2.add(buttons[i]);

				if (buttons[i] == buttons[0]) {
					buttons[i].setForeground(Color.RED); // '일요일'의 색을 빨간색으로 지정
				}

				if (buttons[i] == buttons[6]) {
					buttons[i].setForeground(Color.BLUE); // '토요일'의 색을 파란색으로 지정
				}
			} 
			
			else 
			{
				buttons[i].setFont(new Font("monospaced", Font.PLAIN, 14));

				if (i % 7 == 6) // 토요일
				{
					buttons[i].setForeground(Color.BLUE);

				}
				else if (i % 7 == 0) // 일요일
				{
					buttons[i].setForeground(Color.RED);

				}
			}
	
		}
		// _ 이진우 --------------------------------------------------------------------------------
		
		// 달력에 날짜를 등록하는 메소드 _ 이진우
		calSet();
		
		edgePanel.add(panel2);
		add(panCenter);
//메모장 버튼 및 레이블 _ 노종민 ---------------------------------------------------		
		memoday = new JLabel();
		memoday.setBounds(10, 10, 200, 30);
		edgePanel2.add(memoday);
				
		tf = new JTextField();
		tf.setBounds(10, 50, 415, 270);
		edgePanel2.add(tf);			
			
		memosave = new JButton("메모 저장");
		memosave.setBounds(110, 360, 90, 30);
		memosave.addActionListener(this);
		memosave.setBackground(Color.LIGHT_GRAY);
		edgePanel2.add(memosave);	
		
		memodelete = new JButton("메모 삭제");
		memodelete.setBounds(240, 360, 90, 30);
		memodelete.addActionListener(this);
		memodelete.setBackground(Color.LIGHT_GRAY);
		edgePanel2.add(memodelete);	
//메모장 버튼 및 레이블 _ 노종민  ---------------------------------------------------
			
		setVisible(true);
	}

	
	// 달력 값을 관리하는 기본 메소드 _ 이진우 ------------------------------------------------
	private void calManage() {
		calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}
	// _ 이진우 -------------------------------------------------------------------------

	// 달력의 값을 변경하는 메소드 _ 이진우 ---------------------------------------------------
	private void calUpdate() {
		for (int i = 7; i < buttons.length; i++) // 요일의 값은 그대로 두고 일자의 값만 바꿔야 하기 때문에 초기값을 7로 설정
		{
			buttons[i].setText(""); // 달력의 값을 지움
		}

		calSet(); // 달력의 값을 다시 등록 _ 이진우
		day.setText("  " + year + "년 " + month + "월 구단 일정  ");
	}
	// _ 이진우 -----------------------------------------------------------------------------

	// 달력의 연도를 바꾸는 메소드 _ 이진우 ------------------------------------------------------
	private void calChange() {
		if (month <= 0)
		{
			month = 12;
			year--;
		} 
		else if (month >= 13) 
		{
			month = 1;
			year++;
		}
	}
	// _ 이진우 ----------------------------------------------------------------------------

	// 달력에 날짜를 등록하는 메소드 _ 이진우 -----------------------------------------------------
	private void calSet() {
		calendar.set(year, month - 1, 1);
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) { // getActualMaximum = 그 달의 값을 얻어옴				
			{
				buttons[6 + firstDay + i].setText(Integer.toString(i));
			}

		}
	// _ 이진우 -----------------------------------------------------------------------------
		
//달력 빈칸 없애기 _ 노종민 ----------------------------------------------------------
		for (int i = 0; i < buttons.length; i++) {
			if ( buttons[i].getText().equals("")) {
				buttons[i].setEnabled(false);
			} else
				buttons[i].setEnabled(true);
		} 
//달력 빈칸 없애기 _ 노종민 ---------------------------------------------------------
		
//메모가 있는 버튼에 색넣기 _ 노종민  ----------------------------------------
		for (int i = 0; i < buttons.length; i++) {
			clickday = buttons[i].getText();
			try {
				FileReader fr = new FileReader("C:\\Users\\UserK\\Desktop\\" + month +"월"+ clickday +"일 일정.txt");
				buttons[i].setBackground(new Color(0xFFFFCC));
				fr.close();
			} catch (FileNotFoundException e) {
				buttons[i].setBackground(new Color(0xEDEDED));
			} catch (IOException e) {
				e.printStackTrace();
			}
//메모가 있는 버튼에 색넣기 _ 노종민  ----------------------------------------
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		// < > 버튼을 눌러 달력의 달을 전 후로 옮김 _ 이진우 ---------------------------
		if (obj == beforeButton) {
			month -= 1;
			calChange();
			calUpdate();		
		}
		
		if (obj == afterButton) {
			month += 1;
			calChange();
			calUpdate();
		} 
		// _ 이진우 --------------------------------------------------------------
		
		// 경기가 있는 날짜를 클릭하면 해당 나라의 정보가 있는 프레임을 띄움 _ 이진우 ----------
		if (obj == buttons[32] && year == 2022 && month == 11)
		{
			setVisible(true);
			new Uruguay();
		}
		else if (obj == buttons[36] && year == 2022 && month == 11)
		{
			setVisible(true);
			new Gana();
		} 
		else if (obj == buttons[13] && year == 2022 && month ==12)
		{
			setVisible(true);
			new Porto();
		}
		// _ 이진우 --------------------------------------------------------------
		
		if ( obj == btn1 ) {
			new SubPlayerFrame("구단 관리 프로그램");
			dispose();
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
		} 
//0년0월0일 불러오기 _ 노종민  --------------------------------------
		for (int i = 0; i < buttons.length; i++) {
			if ( obj == buttons[i]) {				
				clickday = buttons[i].getText();				
				try {
					int aa = Integer.parseInt(buttons[i].getText());
					memoday.setText(year+"년 "+month+"월 "+buttons[i].getText()+"일");
				} catch (Exception e2) {
					// 요일을 클릭했을때
				}
// 0년0월0일 불러오기 _ 노종민  --------------------------------------
					
//메모 불러오기 _ 노종민  ------------------------------------------------				
				try {
						FileReader fr = new FileReader("C:\\Users\\UserK\\Desktop\\" + month +"월"+ clickday +"일 일정.txt");
						int c = 0;
						while ( (c = fr.read()) != -1 ) {
							view = ""+view+(char)c+"";
							tf.setText(view);
						}
						view = "";
						fr.close();
					} catch (FileNotFoundException e1) {
						tf.setText("");
					} catch (IOException e1) {
						System.out.println("오류");
						e1.printStackTrace();
					}														
			}
		}
//메모 불러오기 _ 노종민  ------------------------------------------------		
			
//메모 바탕화면에 저장 _ 노종민  ------------------------------------------------				
		if ( obj == memosave) {
				//날짜 선택 안할 경우
				if( clickday == null) {
					JOptionPane.showMessageDialog(this, "날짜를 선택해주세요.");
					return;
				//메모장이 빈 칸일 경우
				} else if (tf.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "메모를 입력해주세요.");
					return;
				}
			
				String text = ""+tf.getText()+"";
				String fileNm = "C:\\Users\\UserK\\Desktop\\" + month +"월"+ clickday +"일 일정.txt";
				
				
				FileWriter fileWrite;
				try {
					File file = new File(fileNm);
					fileWrite = new FileWriter(file);
										
					fileWrite.write(text);
					fileWrite.flush(); 
					fileWrite.close();
					JOptionPane.showMessageDialog(this, "메모가 저장되었습니다.");
					fileWrite.close();
					calSet();
				} catch (IOException e1) {
					System.out.println("오류");
					e1.printStackTrace();
				}
//메모 바탕화면에 저장 _ 노종민  ------------------------------------------------

//메모 삭제 _ 노종민  ---------------------------------------------------------
			} else if ( obj == memodelete) {
				//날짜 선택 안할 경우
				if( clickday == null) {
					JOptionPane.showMessageDialog(this, "날짜를 선택해주세요.");
					return;																
				}
				
				String fileNm = "C:\\Users\\UserK\\Desktop\\" + month +"월"+ clickday +"일 일정.txt";
				File file = new File(fileNm);
				
				if( file.exists() ){ //파일존재여부확인	    			
		    		if(file.delete()){
		    			if(JOptionPane.showConfirmDialog(this, "메모를 삭제하시겠습니까?", "삭제", 
		    					JOptionPane.YES_NO_OPTION, 
		    					JOptionPane.WARNING_MESSAGE)== JOptionPane.YES_OPTION ) {
		    				JOptionPane.showMessageDialog(this, "메모가 삭제되었습니다.");
		    			}
		    			tf.setText("");
		    			calSet();
		    		}else{
		    			System.out.println("파일삭제 실패");
		    		}	    		
		    	} else{
		    		JOptionPane.showMessageDialog(this, "저장된 메모가 없습니다.");
		    	}
//메모 삭제 _ 노종민  ---------------------------------------------------------			
			}
	}	
	}


