package patika.vetmanagementsystem.dto.request.vaccine;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class VaccineUpdateRequest {
    @Positive(message = "ID has to be a positive number")
    private int id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String code;
    @NotNull
    @NotEmpty
    private LocalDate protectionStartDate;
    @NotNull
    @NotEmpty
    private LocalDate protectionFinishDate;

    public VaccineUpdateRequest() {
    }

    public VaccineUpdateRequest(int id, String name, String code, LocalDate protectionStartDate, LocalDate protectionFinishDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.protectionStartDate = protectionStartDate;
        this.protectionFinishDate = protectionFinishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
