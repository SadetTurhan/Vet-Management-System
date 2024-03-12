package patika.vetmanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.IVaccineService;
import patika.vetmanagementsystem.dao.VaccineRepo;
import patika.vetmanagementsystem.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;
@Service
public class VaccineManager implements IVaccineService {
    @Autowired
    private final VaccineRepo vaccineRepo;

    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    public List<Vaccine> getAllVaccines() {
        return vaccineRepo.findAll();
    }

    @Override
    public Page<Vaccine> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.vaccineRepo.findAll(pageable);
    }
    @Override
    public Vaccine get(Long id) {
        return vaccineRepo.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Vaccine not found with id: " + id));
    }
    @Override
    public Vaccine save(Vaccine vaccine) {
        return vaccineRepo.save(vaccine);
    }
    @Override
    public boolean delete(Long id) {
        vaccineRepo.deleteById(Math.toIntExact(id));
        return false;
    }
    @Override
    public Vaccine updateVaccine(Long id, Vaccine updatedVaccine) {
        Vaccine vaccine = get(id);
        vaccine.setName(updatedVaccine.getName());
        vaccine.setCode(updatedVaccine.getCode());
        vaccine.setProtectionStartDate(updatedVaccine.getProtectionStartDate());
        vaccine.setProtectionFinishDate(updatedVaccine.getProtectionFinishDate());
        return vaccineRepo.save(vaccine);
    }
    @Override
    public boolean isVaccineAlreadyExists(String name, String code, LocalDate protectionFinishDate) {
        return vaccineRepo.existsByNameAndCodeAndProtectionFinishDateAfter(name, code, protectionFinishDate);
    }

    @Override
    public List<Vaccine> getVaccinesByAnimalId(Long animalId) {
        return vaccineRepo.findByAnimalId(animalId);
    }
    public List<Vaccine> getVaccinesByProtectionFinishDateBetween(LocalDate startDate, LocalDate endDate) {
        return vaccineRepo.findByProtectionFinishDateBetween(startDate, endDate);
    }
}
