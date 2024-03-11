package patika.vetmanagementsystem.dto.request.availableDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import patika.vetmanagementsystem.entities.Doctor;

import java.time.LocalDate;

public class AvailableDateSaveRequest {
    @NotNull
    @NotEmpty
    private Doctor doctor;
    @NotNull
    @NotEmpty
    private LocalDate availableDate;

    public AvailableDateSaveRequest() {
    }

    public AvailableDateSaveRequest(Doctor doctor, LocalDate availableDate) {
        this.doctor = doctor;
        this.availableDate = availableDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
}
