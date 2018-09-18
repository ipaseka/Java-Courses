package connection;

import dataSets.DataSet;
import dataSets.DataSetHandler;
import dataSets.UserDataSet;

import javax.swing.*;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class DBServiceImpl implements DBService {
    @Override
    public void prepareUserTable() throws SQLException {
        connection.createStatement().execute("create table if not exists user (id bigint primary key auto_increment, name varchar(256), age int)");
    }

    @Override
    public void deleteUserTable() throws SQLException {
        connection.createStatement().execute("drop table if exists user");
    }

    @Override
    public <T extends DataSet> void addUser(T t) throws SQLException {
        Map<String, Object> fields = new TreeMap<>();
        for (Field f: t.getClass().getDeclaredFields()){
            try {
                Boolean tmpAcc = f.isAccessible();
                f.setAccessible(true);
                fields.put(f.getName(), f.get(t));
                f.setAccessible(tmpAcc);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        StringBuilder stmt = new StringBuilder("insert into user(")
                .append(fields.keySet().stream().collect(Collectors.joining(", ")))
                .append(") values (")
                .append(fields.keySet().stream().map(s -> "\"" + fields.get(s).toString() + "\"").collect(Collectors.joining(", ")))
                .append(")");
        connection.createStatement().execute(stmt.toString());
    }

    @Override
    public void addUser(String name) throws SQLException {
        addUser(new UserDataSet().setName(name));
    }

    @Override
    public <T extends DataSet> void addUserList(List<T> ts) throws SQLException {
        for (T user: ts){
            addUser(user);
        }
    }

    @Override
    public void addUserList(String... nameList) throws SQLException {
        for (String name: nameList){
            addUser(name);
        }
    }

    @Override
    public <T extends DataSet> T getUserById(int id, DataSetHandler dataSetHandler) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select * from user where id = " + id);
        return (T) dataSetHandler.handle(statement.getResultSet()).get(0);
    }

    @Override
    public <T extends DataSet> List<T> getAllUsers(DataSetHandler dataSetHandler) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select * from user");
        return dataSetHandler.handle(statement.getResultSet());
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
