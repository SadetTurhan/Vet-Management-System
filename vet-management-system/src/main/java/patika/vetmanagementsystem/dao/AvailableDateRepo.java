package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.AvailableDate;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate,Long> {
    List<AvailableDate> findByDoctorId(Long doctorId);
    List<AvailableDate>  findByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate);
}
