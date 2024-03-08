package patika.vetmanagementsystem.business.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Doctor;
import patika.vetmanagementsystem.entities.Vaccine;
@Repository
public interface IVaccineService {
    Vaccine save(Vaccine vaccine);
    Vaccine get(int id);
    Page<Vaccine> cursor(int page, int pageSize);
    boolean delete(int id);
}
