package patika.vetmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "availableDates")
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id",columnDefinition = "serial")
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "available_date",nullable = false)
    private LocalDate availableDate;

    public AvailableDate() {
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
}
