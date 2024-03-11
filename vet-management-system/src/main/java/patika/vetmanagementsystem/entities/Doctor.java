package patika.vetmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", columnDefinition = "serial")
    private long id;
    @Column(name = "doctor_name",nullable = false)
    private String name;
    @Column(name = "doctor_phone")
    private String phone;
    @Column(name = "doctor_mail")
    private String mail;
    @Column(name = "doctor_address")
    private String address;
    @Column(name = "doctor_city")
    private String city;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AvailableDate> availableDates = new HashSet<>();

    public Doctor() {
    }

    public Doctor(long id, String name, String phone, String mail, String address, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.city = city;
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

    public Set<AvailableDate> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(Set<AvailableDate> availableDates) {
        this.availableDates = availableDates;
    }
    public void addAvailableDate(AvailableDate availableDate) {
        availableDates.add(availableDate);
        availableDate.setDoctor(this);
    }

    public void removeAvailableDate(AvailableDate availableDate) {
        availableDates.remove(availableDate);
        availableDate.setDoctor(null);
    }

}
