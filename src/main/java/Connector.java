import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class Connector {
    
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
       // 1) Driver Yukle
       Class.forName("com.mysql.cj.jdbc.Driver");

       // 2) Baglanti Olustu

       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
       // 3) Statement
      Statement st = con.createStatement();

       // 4) Result Set
       int deneme = 0;
       st.executeUpdate("insert into"+" Doktorlar("+ "id)"  +" values ("+deneme+")");

      // PreparedStatement ps = con.prepareStatement("insert into"+ " Doktorlar(id)"  +" values ("+ deneme + ")");


   }
}
