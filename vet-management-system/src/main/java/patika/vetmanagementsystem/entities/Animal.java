package patika.vetmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id",columnDefinition = "serial")
    private long id;
    @Column(name = "animal_name",nullable = false)
    private String name;
    @Column(name = "animal_species",nullable = false)
    private String species;
    @Column(name = "animal_breed")
    private String breed;
    @Column(name = "animal_gender",nullable = false)
    private String gender;
    @Column(name = "animal_colour",nullable = false)
    private String colour;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Vaccine> vaccines = new ArrayList<>();
    public Animal() {
    }

    public Animal(long id, String name, String species,
                  String breed, String gender, String colour,
                  LocalDate dateOfBirth, Customer customer,List<Vaccine> vaccines) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.gender = gender;
        this.colour = colour;
        this.dateOfBirth = dateOfBirth;
        this.customer = customer;
        this.vaccines = vaccines;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }
}
