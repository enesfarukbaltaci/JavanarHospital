import java.sql.SQLException;

public interface Transactions {
    void add() throws ClassNotFoundException, SQLException;

    void read() throws ClassNotFoundException, SQLException;

    void update() throws SQLException, ClassNotFoundException;

    void delete() throws ClassNotFoundException, SQLException;
}
