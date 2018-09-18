package connection;
import dataSets.DataSet;
import dataSets.DataSetHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable {
    Connection connection = ConnectionHelper.getConnection();
    void prepareUserTable() throws SQLException;
    void deleteUserTable() throws SQLException;
    <T extends DataSet> void addUser(T t) throws SQLException;
    void addUser(String name) throws SQLException;
    <T extends DataSet> void addUserList (List<T> tList) throws SQLException;
    void addUserList (String... nameList) throws SQLException;
    <T extends DataSet> T getUserById (int id, DataSetHandler dataSetHandler) throws SQLException;
    <T extends DataSet> List<T> getAllUsers(DataSetHandler dataSetHandler) throws SQLException;
}
