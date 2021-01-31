package day2.lab1;

import jakarta.xml.bind.annotation.*;

import java.util.List;


@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlAttribute(name = "student_id")
    private int Id;
    private String firstName;
    private String lastName;

    @XmlElementWrapper(name = "addresses")
    @XmlElement(name = "address")
    private List<Address> addressList;

    public Student(){

    }

    public Student(int id, String firstName, String lastName, List<Address> addressList) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressList = addressList;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
