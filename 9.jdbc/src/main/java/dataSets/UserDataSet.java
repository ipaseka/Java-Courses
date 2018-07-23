package dataSets;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDataSet extends DataSet {

    @Override
    public String toString() {
        return "UserDataSet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "} " + super.toString();
    }

    @Override
    public <T extends DataSet> List<T> handle(ResultSet resultSet) throws SQLException {
        List<UserDataSet> list = new ArrayList<>();
        while (!resultSet.isLast()){
            resultSet.next();
            UserDataSet userDataSet = new UserDataSet();
            userDataSet.setId(resultSet.getLong("id"));
            userDataSet.setName(resultSet.getString("name"));
            userDataSet.setAge(resultSet.getInt("age"));
            list.add(userDataSet);
        }
        return (List<T>) list;
    }

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public UserDataSet setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDataSet setName(String name) {
        this.name = name;
        return this;
    }
}
