package patika.vetmanagementsystem.dto.response.customer;

import jakarta.persistence.*;
import patika.vetmanagementsystem.dto.response.animal.AnimalResponse;
import patika.vetmanagementsystem.entities.Animal;

import java.util.List;

public class CustomerResponse {
    private int id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
    private List<Animal> animals;
    public CustomerResponse() {
    }

    public CustomerResponse(int id, String name, String phone, String mail, String address, String city, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.city = city;
        this.animals = animals;
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

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
