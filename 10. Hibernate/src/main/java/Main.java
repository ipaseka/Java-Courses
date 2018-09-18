import DataBase.DBService;
import DataBase.DBServiceImpl;
import DataSet.AddressDataSet;
import DataSet.PhoneDataSet;
import DataSet.UserDataSet;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBServiceImpl();
        AddressDataSet addressDataSet1 = new AddressDataSet().setCountry("Ukraine").setCity("Kiev").setStreet("Lepse").setHome("22/26");
        AddressDataSet addressDataSet2 = new AddressDataSet().setCountry("Ukr").setCity("Letichev").setStreet("VV").setHome("50");
        AddressDataSet addressDataSet3 = new AddressDataSet("urk", "vinnica", "kelecka", "60");

        try {
            dbService.saveUser(new UserDataSet().setName("Kristina Naichuk").setAge(26)
                    .setPhone(new PhoneDataSet().setPhoneType(PhoneDataSet.PhoneType.STATIONARY).setPhone("0446966363"))
                    .setAddress(addressDataSet1).setAddress(addressDataSet2).setAddress(addressDataSet3));
            dbService.saveUser(new UserDataSet().setName("Ihor Pasieka").setAge(25)
                    .setPhone(new PhoneDataSet().setPhoneType(PhoneDataSet.PhoneType.MOBILE).setPhone("0855966599"))
                    .setAddress(addressDataSet1));
            dbService.saveUser(new UserDataSet().setName("Serega Grigor").setAge(27)
                    .setPhone(new PhoneDataSet().setPhone("0966366552"))
                    .setAddress(addressDataSet2));
            dbService.saveUser(new UserDataSet().setName("Alina Pasieka").setAge(22).setAddress(addressDataSet3));
            dbService.saveUser(new UserDataSet().setName("Kyba").setAge(24).setAddress(addressDataSet2).setAddress(addressDataSet3));
            dbService.saveUser(new UserDataSet().setName("Kyba").setAge(28)
                    .setPhone(new PhoneDataSet().setPhone("59559595")).setAddress(addressDataSet1));
            dbService.saveUser(new UserDataSet().setName("Oleg Palamar").setAge(26).setAddress(addressDataSet2));

            System.out.println(dbService.getUserById(3));

            System.out.println(dbService.getUserByName("Kyba"));

            System.out.println(dbService.getAllUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbService.shutdown();
            System.exit(0);
        }
    }
}
