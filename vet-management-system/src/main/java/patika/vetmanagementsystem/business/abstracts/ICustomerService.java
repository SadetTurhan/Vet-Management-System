package patika.vetmanagementsystem.business.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Animal;
import patika.vetmanagementsystem.entities.Customer;
import java.util.List;
@Repository
public interface ICustomerService {
    Customer save(Customer customer);
    Customer get(int id);
    Page<Customer> cursor(int page, int pageSize);
    boolean delete(int id);
    void deleteCustomer(int customerId);
    public Customer getCustomerByIdWithAnimals(int customerId);
    public List<Customer> filterCustomersByName(String name);
    public List<Animal> getAnimalsByCustomerId(int customerId);
}
