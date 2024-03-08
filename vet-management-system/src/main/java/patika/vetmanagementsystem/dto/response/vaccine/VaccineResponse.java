package patika.vetmanagementsystem.dto.response.vaccine;

import jakarta.persistence.*;

import java.time.LocalDate;

public class VaccineResponse {
    private long id;
    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;
}
