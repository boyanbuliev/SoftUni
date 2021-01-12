package xmldemo.models;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumber {
    private static long nextId = 0;
    @XmlAttribute(required = true)
    private Long id = ++nextId;
    @NonNull
    private String number;
}
