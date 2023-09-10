package DB;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DBOrderList {
	public static String[] getFoods() {
		try {
			DB.init();
			ArrayList<String> list = new ArrayList<String>();
			ResultSet rs = DB.getResult("select * from FOODTABLE");

			while (rs.next()) {
				list.add(rs.getString("FOOD"));
			}
			String[] arr = new String[list.size()];
			return list.toArray(arr);

		} catch (Exception e) {
			return null;}
		}
		public static String[] getDrinks() {
			try {
				DB.init();
				ArrayList<String> list = new ArrayList<String>();
				ResultSet rs = DB.getResult("select * from FOODTABLE");

				while (rs.next()) {
					list.add(rs.getString("DRINK"));
				}
				String[] arr = new String[list.size()];
				return list.toArray(arr);

			} catch (Exception e) {
				return null;
			}

	}
	
	
}
