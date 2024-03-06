package patika.vetmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id",columnDefinition = "serial")
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "appointment_date",nullable = false)
    private LocalDate appointmentDate;

    public Appointment() {
    }

    public Appointment(long id, LocalDate appointmentDate) {
        this.id = id;
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
}
