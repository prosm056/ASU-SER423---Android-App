package bsse.asu.edu.ser423sambuddhanathandroid.models;

public class Address {
    private String street;
    private String City;
    private String state;
    private String country;
    private int zipCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCompleteAddress() {
        return this.getStreet() + ", " + this.getCity() + ", " + this.getState() + ", " +
                this.getCountry() + ", " + this.getZipCode();
    }
}
