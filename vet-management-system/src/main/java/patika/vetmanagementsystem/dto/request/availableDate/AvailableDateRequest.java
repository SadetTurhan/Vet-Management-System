package patika.vetmanagementsystem.dto.request.availableDate;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AvailableDateRequest {

    @NotNull
    private LocalDate date;

    @NotNull
    private Long doctorId;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
