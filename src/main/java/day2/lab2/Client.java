package day2.lab2;

import day2.lab2.generated.AddressType;
import day2.lab2.generated.ObjectFactory;
import day2.lab2.generated.PersonType;
import jakarta.xml.bind.*;

import java.io.*;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        try {

            // Step 1: create schema ( Done)

            // Step 2: create XML instance ( Done)

            // Step 3: generate classes using xjc tool ( Done)

            //step 4 : Create the client
            JAXBContext jaxbContext = JAXBContext.newInstance("day2.lab2.generated");

            //step 5: unmarshal objects
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<PersonType> personTypeJAXBElement =
                    (JAXBElement<PersonType>) unmarshaller.unmarshal(new FileReader("src/main/java/day2/lab2/Person.xml"));

            // Step 6: Read objects
            PersonType personType = personTypeJAXBElement.getValue();
            AddressType addressType = (AddressType) personType.getAddress().get(0);

            System.out.println("Person Name:" + personType.getName());
            System.out.println("Second address :"+addressType.getStreet());

            // step 7 : Manipulate objects
            personType.setName("Hamaky");
            List addressList = personType.getAddress();
            addressList.clear();

            ObjectFactory objectFactory = new ObjectFactory();
            AddressType newAddressType = objectFactory.createAddressType();
            newAddressType.setNumber(100);
            newAddressType.setStreet("Geser El Mahaba");
            addressList.add(newAddressType);

            //Step 8 : Marshal objects
            JAXBElement<PersonType> person = objectFactory.createPerson(personType);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(person,new FileWriter("src/main/java/day2/lab2/NewPerson.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
