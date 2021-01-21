package com.lawliet.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class TestMarshaller {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter writer = new StringWriter();
            Person person = new Person();
            person.setId(1);
            person.setName("张三");
            person.setAge(28);
            Address address = new Address();
            address.setId(2);
            address.setProvince("那个省");
            address.setCity("那个市");
            address.setArea("那个区");
            person.setAddress(address);
            marshaller.marshal(person, writer);
            System.out.println(writer.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
