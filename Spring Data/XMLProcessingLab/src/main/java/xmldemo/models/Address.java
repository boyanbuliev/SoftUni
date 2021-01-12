package xmldemo.models;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @XmlAttribute(required = true)
    private Long id;
    @NonNull
    @XmlElement(required = true)
    private String country;
    @NonNull
    @XmlElement(required = true)
    private String city;
    @NonNull
    private String street;

}
