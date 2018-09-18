package DataSet;

import javax.persistence.Entity;

@Entity(name = "UserAddressList")
public class AddressDataSet extends DataSet {
    private String country;
    private String city;
    private String street;
    private String home;

    public AddressDataSet (){}
    public AddressDataSet(String country, String city, String street, String home) {
        setCountry(country)
                .setCity(city)
                .setStreet(street)
                .setHome(home);
    }

    public String getCountry() {
        return country;
    }

    public AddressDataSet setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDataSet setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressDataSet setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getHome() {
        return home;
    }

    public AddressDataSet setHome(String home) {
        this.home = home;
        return this;
    }

    @Override
    public String toString() {
        return "AddressDataSet{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home='" + home + '\'' +
                "} " + super.toString();
    }
}
