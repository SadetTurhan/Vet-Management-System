package patika.vetmanagementsystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
@Entity
@Table(name = "availableDates")
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_date_id",columnDefinition = "serial")
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "available_date",nullable = false)
    private LocalDate availableDate;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public AvailableDate() {
    }

    public AvailableDate(long id, Doctor doctor, LocalDate availableDate) {
        this.id = id;
        this.doctor = doctor;
        this.availableDate = availableDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
