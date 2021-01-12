package xmldemo;

import org.xml.sax.SAXException;
import xmldemo.models.Address;
import xmldemo.models.Person;
import xmldemo.models.Persons;
import xmldemo.models.PhoneNumber;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Address> addresses = List.of(
                new Address(1L, "Bulgaria", "Sofia", "bul. Tzar Osvoboditel 50"),
                new Address(2L, "Bulgaria", "Plovdiv", "ul. Gladston 17"));
        List<Person> persons = List.of(
                new Person(1L, "Pesho", "Petrov", addresses.get(0),
                        Set.of(new PhoneNumber("+359 728 278383"), new PhoneNumber("+359 2 556573"))),
                new Person(2L, "Gosho", "Goshov", addresses.get(1),
                        Set.of(new PhoneNumber("+359 788 27388"), new PhoneNumber("+359 5 3778904"))),
                new Person(3L, "Stamat", "Petrov", addresses.get(0),
                        Set.of(new PhoneNumber("+359 881 234567"), new PhoneNumber("+359 2 377893"))));

        try {
            JAXBContext ctx = JAXBContext.newInstance(Person.class, Persons.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons.get(0), new File("person.xml"));
            marshaller.marshal(new Persons(persons), new File("persons.xml"));

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("persons.xsd"));

            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler((ValidationEvent ve) -> {
                if (ve.getSeverity() != ValidationEvent.WARNING) {
                    System.out.printf("%s: Line:Col[%d:%d] - %s%n", ve.getSeverity(),
                            ve.getLocator().getLineNumber(),
                            ve.getLocator().getColumnNumber(), ve.getMessage());
                }
                return true;
            });
            Persons unmarshalled = (Persons) unmarshaller.unmarshal(new File("persons.xml"));
            unmarshalled.getPersons().forEach(p ->
                    System.out.printf("| %5d | %-15.15s | %-15.15s | %-40.40s | %-40.40s |%n",
                            p.getId(), p.getFirstName(), p.getLastName(),
                            p.getAddress().getCountry() + " " + p.getAddress().getCity() + " "
                                    + p.getAddress().getStreet(),
                            p.getPhoneNumbers().stream().map(PhoneNumber::getNumber)
                                    .collect(Collectors.joining(", "))));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
