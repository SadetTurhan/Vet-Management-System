package patika.vetmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id",columnDefinition = "serial")
    private long id;
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Temporal(TemporalType.DATE)
    @Column(name = "appointment_date",nullable = false)
    private LocalDate appointmentDate;

    public Appointment() {
    }

    public Appointment(long id, Doctor doctor, Customer customer, LocalDate appointmentDate) {
        this.id = id;
        this.doctor = doctor;
        this.customer = customer;
        this.appointmentDate = appointmentDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
