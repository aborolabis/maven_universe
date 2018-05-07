package pl.aborolabis.projects.EntityObjects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nationalities")
public class Nationality {

    @Id
    @Column(name = "nationality_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "hero_id")
    private Hero owner;

    @OneToMany
    @JoinTable(name = "citizens")
    @Column(name = "citizens")
    private List <Hero> listOfCitizens;

    public Nationality() {
    }

    public Nationality(String name) {
        this.name = name;
    }

    public Nationality(String name, Hero owner_id, List<Hero> listOfCitizens) {
        this.name = name;
        this.owner = owner;
        this.listOfCitizens = listOfCitizens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getOwner() {
        return owner;
    }

    public void setOwner(Hero owner) {
        this.owner = owner;
    }

    public List<Hero> getListOfCitizens() {
        return listOfCitizens;
    }

    public void setListOfCitizens(List<Hero> listOfCitizens) {
        this.listOfCitizens = listOfCitizens;
    }

    @Override
    public String toString() {
        return "Nationality: " +
                "id=" + id +
                ", name=" + name;
    }
}
