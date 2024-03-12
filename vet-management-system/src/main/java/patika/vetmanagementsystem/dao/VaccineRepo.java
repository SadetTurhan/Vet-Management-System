package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Vaccine;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine,Integer> {
    boolean existsByNameAndCodeAndProtectionFinishDateAfter(String name, String code, LocalDate protectionFinishDate);
    List<Vaccine> findByAnimalId(Long animalId);
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate startDate, LocalDate endDate);
}
