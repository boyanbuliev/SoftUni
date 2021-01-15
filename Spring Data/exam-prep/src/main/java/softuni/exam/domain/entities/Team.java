package softuni.exam.domain.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
    @NotNull
    @Length(min = 3, max = 20, message = "Name should be between 3 and 20 characters")
    private String name;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Picture picture;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
