package DataSet;

import javax.persistence.Entity;

@Entity(name = "UserPhoneList")
public class PhoneDataSet extends DataSet {
    public enum PhoneType {MOBILE, STATIONARY}
    private String phone;
    private PhoneType phoneType = PhoneType.MOBILE;

    public String getPhone() {
        return phone;
    }

    public PhoneDataSet setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public PhoneDataSet setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
        return this;
    }

    @Override
    public String toString() {
        return "PhoneDataSet{" +
                "phone='" + phone + '\'' +
                ", phoneType=" + phoneType +
                "} " + super.toString();
    }
}
