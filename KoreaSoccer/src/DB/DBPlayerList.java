package DB;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DBPlayerList {

   public static String[][] getPlayers() {
	   
      try {
         DB.init();
         
         ArrayList<String[]> list = new ArrayList<String[]>();
         ResultSet rs = DB.getResult("select * from PLAYER");

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