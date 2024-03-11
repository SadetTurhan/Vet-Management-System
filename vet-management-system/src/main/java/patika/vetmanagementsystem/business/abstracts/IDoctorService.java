package patika.vetmanagementsystem.business.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Appointment;
import patika.vetmanagementsystem.entities.Doctor;

import java.time.LocalDate;

@Repository
public interface IDoctorService {
    Doctor save(Doctor doctor);
    Doctor get(int id);
    Page<Doctor> cursor(int page, int pageSize);
    boolean delete(int id);

}
