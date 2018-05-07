package pl.aborolabis.projects.EntityObjects;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @Column(name = "hero_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "nationality")
    private Nationality nationality;

    public Hero() {
    }

    public Hero(String nickname, String firstName, String lastName, double height, int weight, int age, Nationality nationality) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", nationality=" + nationality +
                '}';
    }

}
