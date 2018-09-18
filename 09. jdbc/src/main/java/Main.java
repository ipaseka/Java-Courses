import connection.DBService;
import connection.DBServiceImpl;
import dataSets.UserDataSet;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserDataSet userDataSet = new UserDataSet().setName("Ihor P").setAge(25);
        try (DBService dbService = new DBServiceImpl()){
//            dbService.deleteUserTable();
//            dbService.prepareUserTable();
//            dbService.addUser(userDataSet);
//            dbService.addUserList("Vasiya", "one more", "and more");
            System.out.println(dbService.getUserById(1, userDataSet));
            System.out.println(dbService.getAllUsers(userDataSet));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
