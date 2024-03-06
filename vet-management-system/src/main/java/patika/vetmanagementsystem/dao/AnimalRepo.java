package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.vetmanagementsystem.entities.Animal;

public interface AnimalRepo extends JpaRepository<Animal, Integer> {
}
