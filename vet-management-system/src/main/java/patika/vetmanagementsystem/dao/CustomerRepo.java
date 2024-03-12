package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Customer;
import java.util.List;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    List<Customer> findByNameContaining(String name);
}
