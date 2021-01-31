package day2.lab1;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = {"country", "city"})
@XmlAccessorType(XmlAccessType.NONE)
public class Address {

    @XmlTransient
    private int id;
    @XmlElement
    private String country;
    @XmlElement
    private String city;

    public Address() {

    }

    public Address(int id, String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
