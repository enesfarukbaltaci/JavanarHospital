import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class Connector {


    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastahane?serverTimezone=UTC", "root", "1234");
        return con;
    }


}
