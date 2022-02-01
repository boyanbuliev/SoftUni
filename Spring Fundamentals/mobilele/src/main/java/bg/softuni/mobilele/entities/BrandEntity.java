package bg.softuni.mobilele.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

	@Column(unique = true, nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BrandEntity{" +
				"id=" + id +
				", created=" + created +
				", updated=" + updated +
				", name='" + name + '\'' +
				'}';
	}
}
