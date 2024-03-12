package patika.vetmanagementsystem.business.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.dao.VaccineRepo;
import patika.vetmanagementsystem.entities.Doctor;
import patika.vetmanagementsystem.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IVaccineService {
    Vaccine save(Vaccine vaccine);
    Vaccine get(Long id);
    public List<Vaccine> getAllVaccines();
    Page<Vaccine> cursor(int page, int pageSize);
    boolean delete(Long id);
    public Vaccine updateVaccine(Long id, Vaccine updatedVaccine);
    public boolean isVaccineAlreadyExists(String name, String code, LocalDate protectionFinishDate);
    public List<Vaccine> getVaccinesByAnimalId(Long animalId);
    public List<Vaccine> getVaccinesByProtectionFinishDateBetween(LocalDate startDate, LocalDate endDate);
}
