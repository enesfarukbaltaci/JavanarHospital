import java.sql.SQLException;

public class DenemekeRunnerke {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        HemsireTransactions hemsireTransactions = new HemsireTransactions();

        hemsireTransactions.add();
        hemsireTransactions.read();
        hemsireTransactions.update();
        hemsireTransactions.delete();


    }
}
