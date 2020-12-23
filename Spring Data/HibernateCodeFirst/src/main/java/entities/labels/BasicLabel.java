package entities.labels;

import entities.shampoos.BasicShampoo;

import javax.persistence.*;

@Entity
public class BasicLabel implements Label {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String subtitle;
    @OneToOne(targetEntity = BasicShampoo.class, mappedBy = "label", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BasicShampoo shampoo;

    public BasicLabel() {
    }

    public BasicLabel(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(long id) {

    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public String getSubtitle() {
        return null;
    }

    @Override
    public void setSubtitle(String subtitle) {

    }
}
