package com.example.demo.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class XmlParserImpl implements XmlParser {
    @Override
    public <T> T unmarshalFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new FileReader(filePath));
    }

    @Override
    public <T> void marshalToFile(String filePath, T rootDto) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(rootDto.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(rootDto, new FileWriter(filePath));
    }
}
