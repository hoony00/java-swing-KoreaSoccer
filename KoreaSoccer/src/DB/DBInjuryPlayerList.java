package DB;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DBInjuryPlayerList {

   public static String[][] getInjuryPlayers() {
	   
      try {
         DB.init();
         
         ArrayList<String[]> list = new ArrayList<String[]>();
         ResultSet rs = DB.getResult("select * from INJURYPLAYER");

         while (rs.next()) {
            list.add(new String[] { rs.getString("pn"), rs.getString("name"), rs.getString("age"),
                  rs.getString("position"), rs.getString("INJURYAREA"), rs.getString("INJURYSYMPTOM") }

            );
            
         }
         
         String[][] arr = new String[list.size()][6];
         return list.toArray(arr);

      } catch (Exception e) {
         return null;
      }

   }
  
}