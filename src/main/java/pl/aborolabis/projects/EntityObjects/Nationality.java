package pl.aborolabis.projects.EntityObjects;

import javax.persistence.*;

@Entity
@Table(name = "nationalities")
public class Nationality {

    @Id
    @Column(name = "nationality_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private int name;

    @OneToOne
    @JoinColumn(name = "hero_id")
    @Column(name = "owner")
    private int owner_id;

    public Nationality() {
    }

    public Nationality(int name, int owner_id) {
        this.name = name;
        this.owner_id = owner_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "Nationality: " +
                "id=" + id +
                ", name=" + name +
                ", owner_id=" + owner_id;
    }
}
