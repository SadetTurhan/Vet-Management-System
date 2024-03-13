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
    private LocalDate availableDate;

    public AvailableDateSaveRequest() {
    }

    public AvailableDateSaveRequest( LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
}
