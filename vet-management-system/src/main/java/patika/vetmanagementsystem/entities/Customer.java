package patika.vetmanagementsystem.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "serial")
    private int id;
    @Column(name = "customer_name",nullable = false)
    private String name;
    @Column(name = "customer_phone")
    private String phone;
    @Column(name = "customer_mail")
    private String mail;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_city")
    private String city;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animal;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    public Customer() {
    }

    public Customer(int id, String name, String phone, String mail, String address, String city, List<Animal> animal) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.city = city;
        this.animal = animal;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }
}
