package com.lawliet.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TerstUnmarshaller {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);	// 创建上下文对象
            Unmarshaller unmarshaller = context.createUnmarshaller();	// 获取反序列化对象
            File personXML = new  File("java_example/src/com/zql/jaxb/person.xml");		// 创建文件对象
            Person person = (Person)unmarshaller.unmarshal(personXML);	// 执行反序列化
            System.out.println(person);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
