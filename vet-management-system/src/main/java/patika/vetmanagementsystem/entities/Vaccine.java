package patika.vetmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vaccines")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id",columnDefinition = "serial")
    private long id;
    @Column(name = "vaccine_name",nullable = false)
    private String name;
    @Column(name = "vaccine_code",nullable = false)
    private String code;
    @Temporal(TemporalType.DATE)
    @Column(name = "protection_start_date",nullable = false)
    private LocalDate protectionStartDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "protection_finish_date",nullable = false)
    private LocalDate protectionFinishDate;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Vaccine() {
    }

    public Vaccine(long id, String name, String code, LocalDate protectionStartDate, LocalDate protectionFinishDate, Animal animal) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.protectionStartDate = protectionStartDate;
        this.protectionFinishDate = protectionFinishDate;
        this.animal = animal;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getProtectionStartDate() {
        return protectionStartDate;
    }

    public void setProtectionStartDate(LocalDate protectionStartDate) {
        this.protectionStartDate = protectionStartDate;
    }

    public LocalDate getProtectionFinishDate() {
        return protectionFinishDate;
    }

    public void setProtectionFinishDate(LocalDate protectionFinishDate) {
        this.protectionFinishDate = protectionFinishDate;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
