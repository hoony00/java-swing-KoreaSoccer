package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import DB.DB;

public class MainPlayerList extends AbstractTableModel {

	Vector data = new Vector();
	Vector colName = new Vector();
	private String sql, pn, name, age, height, weight, position;

	@Override
	public int getRowCount() {

		return data.size(); // Row의 개수를 정해주는 메소드
	}

	@Override
	public int getColumnCount() {

		return colName.size(); // 컬럼의 개수를 정해주는 메소드
	}

	@Override
	public Object getValueAt(int row, int col) {

		Vector rowData = (Vector) data.elementAt(row);
		Object returnValue = rowData.elementAt(col);

		return returnValue; // 각 셀의 데이터를 결정하는 메소드
	}

	public String getColumnName(int col) {
		String name = (String) colName.elementAt(col);
		return name; // 컬럼명을 정해주는 메소드
	}

	public void setData() {
		DB.init();

		sql = "select * from MAINPLAYER";

		ResultSet rs = DB.getResult(sql);

		String list[] = { "번호", "이름", "나이", "키", "몸무게", "포지션" };

		for (int i = 0; i < list.length; i++) {
			colName.addElement(list[i]);
		}

		try {
			while (rs.next()) {

				Vector vpn = new Vector();

				pn = rs.getString("PN");
				name = rs.getString("NAME");
				age = rs.getString("AGE");
				height = rs.getString("HEIGHT");
				weight = rs.getString("WEIGHT");
				position = rs.getString("POSITION");

				vpn.addElement(pn);
				vpn.addElement(name);
				vpn.addElement(age);
				vpn.addElement(height);
				vpn.addElement(weight);
				vpn.addElement(position);

				data.addElement(vpn);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static String[][] getPlayers() {
		try {
			DB.init();
			ArrayList<String[]> list = new ArrayList<String[]>();
			ResultSet rs = DB.getResult("select * from MAINPLAYER");

			while (rs.next()) {
				list.add(new String[] { rs.getString("pn"), rs.getString("name"), rs.getString("age"),
						rs.getString("height"), rs.getString("weight"), rs.getString("position") }

				);
			}

			String[][] arr = new String[list.size()][6];
			return list.toArray(arr);

		} catch (Exception e) {
			return null;
		}
	}
}
