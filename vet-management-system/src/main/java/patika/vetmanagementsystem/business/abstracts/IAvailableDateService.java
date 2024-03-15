package patika.vetmanagementsystem.business.abstracts;

import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.dao.AvailableDateRepo;
import patika.vetmanagementsystem.entities.AvailableDate;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IAvailableDateService {
    List<AvailableDate> getAllAvailableDatesByDoctor(Long doctorId);
    AvailableDate getAvailableDate(Long doctorId, Long availableDateId);
    AvailableDate addAvailableDate(Long doctorId, LocalDate date);
    AvailableDate updateAvailableDate(Long doctorId, Long availableDateId, LocalDate date);
    void deleteAvailableDate(Long doctorId, Long availableDateId);
}
