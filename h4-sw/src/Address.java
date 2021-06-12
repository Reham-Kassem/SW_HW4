/*
 * this class 
 */

public class Address {
    private int streetnumber;
    private String streetname;
    private String city;

    public Address() {
        city = "";
        streetname = "";
        streetnumber = 0;
    }

    public Address(int streetNumber, String streetName, String City) {
        city = City;
        streetname = streetName;
        streetnumber = streetNumber;
    }

    public int getstreetnumber() {
        return streetnumber;
    }

    public void setstreetnumber(int streetNumber) {
        streetnumber = streetNumber;
    }

    public String getstreetname() {
        return streetname;
    }

    public void setstreetname(String streetName) {
        streetname = streetName;
    }

    public String getcity() {
        return city;
    }

    public void setcity(String City) {
        city = City;
    }
}
