package injury;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DB.DB;

public class InjurySelect extends JFrame implements ActionListener {

	Container c;
	private JPanel panel;
	private JLabel lbl;
	private JButton button;
	private String sql;
	String InjuryArea, InjurySymptom;
	private JComboBox areaCombobox;
	private JComboBox syptomCombobox;
	int selectnum;
	
	String[] injuryArea = { "발목", "무릎", "허벅지", "허리", "손목", "손가락" };
	String[] injurySymptom = { "염좌", "통증", "찰과상", "멍", "타박상" };

	public InjurySelect(int select) {

		setTitle("부상 옵션");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(920, 430);
		setSize(350, 230);
		c = getContentPane();
		c.setLayout(null);

		InjuryCombobox();

		lbl = new JLabel(" 부상 부위와 증상을 선택하세요.");
		lbl.setOpaque(true); // 레이블에 배경줄 때 필요함
		lbl.setBounds(80, 5, 180, 50);
		add(lbl);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0xEDEDED));
		panel.setBounds(25, 30, 285, 145);
		panel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		c.add(panel);

		button = new JButton("입력");
		button.setBounds(107, 95, 65, 30);
		button.addActionListener(this);
		button.setBackground(Color.LIGHT_GRAY);
		panel.add(button);

		setVisible(true);
		
		selectnum = select;		// select 변수에 담긴 값을 사용하기 위해 selectnum에 저장

	}

	private void InjuryCombobox() {
		
		areaCombobox = new JComboBox(injuryArea);
		areaCombobox.setBounds(50, 65, 70, 30);
		add(areaCombobox);

		syptomCombobox = new JComboBox(injurySymptom);
		syptomCombobox.setBounds(210, 65, 70, 30);
		add(syptomCombobox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		String InjPn = null;
		String InjName = null;
		String InjAge = null;
		String InjHeight = null;
		String InjWeight = null;
		String InjPosition = null;
		String InjArea = null;
		String InjSymptom = null;

		if (obj == button) 
		{
			sql = "select * from PLAYER";
			ResultSet rs = DB.getResult(sql);

			for (int i = 0; i < selectnum + 1; i++) {
				try {
					rs.next();
					InjPn = rs.getString("PN");
					InjName = rs.getString("NAME");
					InjAge = rs.getString("AGE");
					InjHeight = rs.getString("HEIGHT");
					InjWeight = rs.getString("WEIGHT");
					InjPosition = rs.getString("POSITION");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			InjArea = areaCombobox.getSelectedItem().toString();	// 콤보박스에서 선택된 값을 InjArea에 저장
			InjSymptom = syptomCombobox.getSelectedItem().toString();	// 콤보박스에서 선택된 값을 InjSymptom에 저장

			// 부상 선수 명단에 값을 추가하고, 추가된 값과 동일한 값을 선수 리스트에서 삭제 
			
			// 부상 선수 명단에 값 추가
			sql = "INSERT INTO CBAN.INJURYPLAYER\r\n"
					+ "(PN, NAME, AGE, HEIGHT, WEIGHT,INJURYAREA,INJURYSYMPTOM, \"POSITION\")\r\n" + "VALUES(" + InjPn
					+ ", '" + InjName + "', '" + InjAge + "', '" + InjHeight + "', '" + InjWeight + "', '" + InjArea
					+ "', '" + InjSymptom + "', '" + InjPosition + "')";
			DB.executeSQL(sql);

			// 선수 리스트에서 삭제
			sql = "DELETE FROM CBAN.PLAYER\r\n" + "WHERE PN=" + InjPn + "";
			DB.executeSQL(sql);

			// DB 수정된 부분 반영하기 위해 클래스 재 호출(창 다시 켜기)
			
			new InjuryPlayerFrame("구단 관리 프로그램");
			dispose();
		
		}

	}
}
