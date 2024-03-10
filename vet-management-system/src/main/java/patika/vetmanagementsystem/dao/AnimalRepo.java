package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.vetmanagementsystem.entities.Animal;
import patika.vetmanagementsystem.entities.Customer;

import java.util.List;

public interface AnimalRepo extends JpaRepository<Animal, Integer> {
    List<Animal> findByCustomerId(int customerId);
}
