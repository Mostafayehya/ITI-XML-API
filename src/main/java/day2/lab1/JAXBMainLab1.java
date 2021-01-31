package day2.lab1;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JAXBMainLab1 {

    public static void main(String[] args) {
//        marshallAddress();
//        unmarshallAddress();
//        marshalStudent();
//        unmarshalStudent();
    }

    private static void unmarshalStudent() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Student student = (Student) unmarshaller.unmarshal(new FileReader("student.xml"));
            System.out.println(student);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void marshalStudent() {
        Address address = new Address(1, "Egypt", "Cairo");
        Address address1 = new Address(2, "Saudi", "Jedda");
        Address address2 = new Address(3, "Russia", "Moscow");
        List<Address> addressList = new ArrayList<>();
        Collections.addAll(addressList, address, address1, address2);
        Student student = new Student(1, "Mostafa", "Yehya", addressList);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(student,new FileWriter("student.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void unmarshallAddress() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Address address = (Address) unmarshaller.unmarshal(new FileReader("address.xml"));
            System.out.println(address.toString());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void marshallAddress() {
        Address address = new Address(1, "Egypt", "Cairo");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(address, new FileWriter("address.xml"));
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
