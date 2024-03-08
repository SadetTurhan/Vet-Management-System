package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.vetmanagementsystem.entities.Vaccine;

public interface VaccineRepo extends JpaRepository<Vaccine,Integer> {
}
