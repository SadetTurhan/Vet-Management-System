package patika.vetmanagementsystem.dto.response.vaccine;

import jakarta.persistence.*;

import java.time.LocalDate;

public class VaccineResponse {
    private long id;
    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;

    public VaccineResponse() {
    }

    public VaccineResponse(long id, String name, String code, LocalDate protectionStartDate, LocalDate protectionFinishDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.protectionStartDate = protectionStartDate;
        this.protectionFinishDate = protectionFinishDate;
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
}
