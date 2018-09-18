package DataSet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "UserList")
public class UserDataSet extends DataSet {
    private String name;
    private int age;
    @OneToOne(targetEntity = PhoneDataSet.class, cascade = CascadeType.ALL)
    private PhoneDataSet phone;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<AddressDataSet> addressList = new ArrayList<AddressDataSet>();

    @Override
    public String toString() {
        return "UserDataSet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", addressList=" + addressList +
                "} " + super.toString();
    }

    public List<AddressDataSet> getAddressList() {
        return addressList;
    }

    public UserDataSet setAddressList(List<AddressDataSet> addressList) {
        this.addressList = addressList;
        return this;
    }

    public UserDataSet setAddress(AddressDataSet address) {
        addressList.add(address);
        return this;
    }

    public PhoneDataSet getPhone() {
        return phone;
    }

    public UserDataSet setPhone(PhoneDataSet phone) {
        this.phone = phone;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDataSet setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserDataSet setAge(int age) {
        this.age = age;
        return this;
    }

}
