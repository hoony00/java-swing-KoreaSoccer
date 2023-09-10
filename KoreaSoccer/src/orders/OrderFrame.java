package orders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DB.DBOrderList;
import injury.InjuryPlayerFrame;
import country.PicplayerFrame;
import country.StadiumFrame;
import player.FormationFrame;
import player.MainPlayerFrame;
import player.SubPlayerFrame;
import schedule.ScheduleFrame;

public class OrderFrame extends JFrame implements ActionListener {
   private JLabel food_txt;
   private JLabel drink_txt;
   private JButton drink_add_btn;
   private JButton food_add_btn;
   private DefaultTableModel model;
   private JTable table;
   private JScrollPane scrollPane;
   private JButton paybtn;
   private JButton delbtn;
   private JPanel btnPanel;
   private JComboBox<String> food_combo;
   private ArrayList pay_list;
   private JComboBox<String> drink_combo;
   private JButton btn1;
   private JButton btn2;
   private JButton btn3;
   private JButton btn4;
   private JButton btn5;
   private JButton btn6;
   private JButton btn7;
   private JButton btn8;
   private JPanel panCenter;
private JPanel Edgepanel;

   public OrderFrame(String title) {
      setTitle(title);
      setSize(1000, 600);
      setLocation(570, 240);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
      Container c = getContentPane();
      c.setBackground(Color.LIGHT_GRAY);
      getContentPane().setLayout(null);
      
	  panCenter = new JPanel();
	  panCenter.setBackground(new Color(0xEDEDED));
	  panCenter.setBounds(0, 40, 1000, 600);
      

        Edgepanel = new JPanel();
        Edgepanel.setLayout(null);
		Edgepanel.setBackground(new Color(0xEDEDED));
		Edgepanel.setBounds(10, 80, 965, 450);
		Edgepanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY,1)));
		
		getContentPane().add(Edgepanel);	
		
		
	    getContentPane().add(panCenter);
	    
	      
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
   		btn7.setBackground(new Color(0xEDEDED));
    	btn7.setBorderPainted(false); // 버튼 테두리 없애기
   		btn7.addActionListener(this);
    		
    	btn8 = new JButton("일정");
    	btn8.setBounds(880, 10, 80, 30);
    	btn8.setBackground(new Color(0xCECECE)); 
    	btn8.setBorderPainted(false); // 버튼 테두리 없애기
    	btn8.addActionListener(this);

    	getContentPane().add(btn1);
    	getContentPane().add(btn2);
    	getContentPane().add(btn3);
    	getContentPane().add(btn4);
    	getContentPane().add(btn5);
    	getContentPane().add(btn6);
    	getContentPane().add(btn7);
    	getContentPane().add(btn8);		
//맨위 버튼 ---------------------------------------------------------		
     
    	food_txt = new JLabel("음식");
		food_txt.setHorizontalAlignment(SwingConstants.CENTER);
		food_txt.setFont(new Font("고딕", Font.BOLD, 17));
		food_txt.setBounds(147, 5, 52, 50);

		String food_arr[] = DBOrderList.getFoods();
		food_combo = new JComboBox<String>(food_arr);
		food_combo.setBounds(280, 5, 300, 50);

		food_add_btn = new JButton("음식추가");
		food_add_btn.setFont(new Font("고딕", Font.BOLD, 17));
		food_add_btn.setBackground(new Color(0xCECECE));
		food_add_btn.setBorderPainted(false); // 버튼 테두리 없애기
		food_add_btn.addActionListener(this);
		food_add_btn.setBounds(633, 10, 202, 40);

		drink_txt = new JLabel("음료");
		drink_txt.setHorizontalAlignment(SwingConstants.CENTER);
		drink_txt.setFont(new Font("고딕", Font.BOLD, 17));
		drink_txt.setBounds(147, 60, 52, 50);

		String drink_arr[] = DBOrderList.getDrinks();
		drink_combo = new JComboBox<String>(drink_arr);
		drink_combo.setBounds(280, 60, 300, 50);

		drink_add_btn = new JButton("음료추가");
		drink_add_btn.setFont(new Font("고딕", Font.BOLD, 17));
		drink_add_btn.setBackground(new Color(0xCECECE));
		drink_add_btn.setBorderPainted(false); // 버튼 테두리 없애기
		drink_add_btn.addActionListener(this);
		drink_add_btn.setBounds(633, 65, 202, 40);

		String titleArray[] = { "주문내역", "가격" };

		model = new DefaultTableModel(titleArray, 0);
		table = new JTable(model);
		table.setRowHeight(28);

		// jtable 가운데 정렬
		setAlignment();

		table.setFont(new Font("고딕", Font.BOLD, 17));
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(33, 118, 917, 251);
		pay_list = new ArrayList();

		paybtn = new JButton("결제");
		paybtn.setFont(new Font("고딕", Font.BOLD, 17));
		paybtn.setBackground(new Color(0xCECECE));
		paybtn.setBounds(264, 379, 169, 50);
		paybtn.addActionListener(this);

		delbtn = new JButton("삭제");
		delbtn.setFont(new Font("고딕", Font.BOLD, 17));
		delbtn.setBackground(new Color(0xCECECE));
		delbtn.setBounds(530, 379, 169, 50);
		delbtn.addActionListener(this);
     
      Edgepanel.add(food_txt);
      Edgepanel.add(food_combo);
      Edgepanel.add(food_add_btn);

      Edgepanel.add(drink_txt);
      Edgepanel.add(drink_combo);
      Edgepanel.add(drink_add_btn);
      
      Edgepanel.add(paybtn);
      Edgepanel.add(delbtn);
      
      Edgepanel.add(scrollPane, BorderLayout.CENTER);

      setVisible(true);
   }
   //데이터 값 가운데 정렬
   private void setAlignment() {
	   DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
		tableCell.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel CellModel = table.getColumnModel();
		
		for (int i = 0; i < CellModel.getColumnCount(); i++) {
			CellModel.getColumn(i).setCellRenderer(tableCell);}
	   
}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == food_add_btn) { // 음식 추가 버튼 클릭이벤트 처리
				String info[] = new String[2]; // 한행 (row) 에 저장할 데이터 모음
				info[0] = food_combo.getSelectedItem().toString(); // 콤보박스 값을 가져온다
				info[1] = "5000";
				model.addRow(info); // 테이블 모델에 데이터 삽입 실시
				pay_list.add(food_combo.getSelectedItem().toString() + " : " + "5000"); // 결제 금액 리스트에 추가
			} else if (obj == drink_add_btn) { // 음식 추가 버튼 클릭이벤트 처리
				String info[] = new String[2]; // 한행 (row) 에 저장할 데이터 모음
				info[0] = drink_combo.getSelectedItem().toString(); // 콤보박스 값을 가져온다
				info[1] = "3000";
				model.addRow(info); // 테이블 모델에 데이터 삽입 실시
				pay_list.add(drink_combo.getSelectedItem().toString() + " : " + "3000"); // 결제 금액 리스트에 추가
			} else if (obj == paybtn) { // 결제 처리

				int showdata = JOptionPane.showConfirmDialog(this, "결제하시겠습니까?", "주문내역", JOptionPane.YES_NO_OPTION);
				if (showdata == 0) { // [예] 버튼
					JOptionPane.showMessageDialog(this, "결제되었습니다." + "\n" + "[주문내역]\n" + pay_list.toString());
					model.setNumRows(0); // 결제 후 리스트 항목 삭제

				} else if (showdata == 1) { // [아니오] 버튼
					JOptionPane.showMessageDialog(this, "취소되었습니다.");
					model.setNumRows(0);// 결제 후 리스트 항목 삭제

				}

			} else if (obj == delbtn) { // 삭제 버튼 클릭이벤트 처리
				// 선택한 줄(row)의 번호 알아내기
				int rowIndex = table.getSelectedRow();

				// 선택 안하고 누를 경우 리턴값 -1
				if (rowIndex == -1) {
					return;
				}
				model.removeRow(rowIndex); // 해당 테이블 행 삭제
				pay_list.remove(rowIndex); // 결제 금액 리스트에서도 삭제 실시
      } else if ( obj == btn1 ) {
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
		}  else if ( obj == btn8 ) {
			new ScheduleFrame("구단 관리 프로그램");
			dispose();
		}
   }
		
};