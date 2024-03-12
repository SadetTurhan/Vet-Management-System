package patika.vetmanagementsystem.business.concretes;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.ICustomerService;
import patika.vetmanagementsystem.core.exception.NotFoundException;
import patika.vetmanagementsystem.core.utilies.Msg;
import patika.vetmanagementsystem.dao.AnimalRepo;
import patika.vetmanagementsystem.dao.CustomerRepo;
import patika.vetmanagementsystem.dto.response.animal.AnimalResponse;
import patika.vetmanagementsystem.dto.response.customer.CustomerResponse;
import patika.vetmanagementsystem.entities.Animal;
import patika.vetmanagementsystem.entities.Customer;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;
    private final AnimalRepo animalRepo;

    public CustomerManager(CustomerRepo customerRepo, AnimalRepo animalRepo) {
        this.customerRepo = customerRepo;
        this.animalRepo = animalRepo;
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer get(int id) {
        return this.customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }
    @Transactional
    public Customer getCustomerByIdWithAnimals(int customerId) {
        return customerRepo.findById(customerId)
                .orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public List<Customer> filterCustomersByName(String name) {
        return customerRepo.findByNameContaining(name);
    }

    @Override
    public List<Animal> getAnimalsByCustomerId(int customerId) {
        Optional<Customer> customerOptional = customerRepo.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return customer.getAnimals();
        }
        return Collections.emptyList();
    }

    @Override
    public Page<Customer> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.customerRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
    @Transactional
    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        List<Animal> animals = animalRepo.findByCustomerId(customerId);
        if (customer != null) {
            customerRepo.delete(customer);
        }
    }

}
