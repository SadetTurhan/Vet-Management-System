package patika.vetmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", columnDefinition = "serial")
    private long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Appointment() {
    }

    public Appointment(long id, Doctor doctor, Customer customer, LocalDateTime appointmentDate, Animal animal) {
        this.id = id;
        this.doctor = doctor;
        this.customer = customer;
        this.appointmentDate = appointmentDate;
        this.animal = animal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}