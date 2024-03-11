package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.vetmanagementsystem.entities.AvailableDate;
import java.util.List;

public interface AvailableDateRepo extends JpaRepository<AvailableDate,Long> {
    List<AvailableDate> findByDoctorId(long doctorId);
}
