package DataBase;

import DataSet.UserDataSet;

import java.sql.SQLException;
import java.util.List;

public interface DBService {
    void saveUser(UserDataSet user) throws SQLException;
    UserDataSet getUserById(long id) throws SQLException;
    List<UserDataSet> getUserByName(String name) throws SQLException;
    List<UserDataSet> getAllUsers() throws SQLException;
    void shutdown();
}
