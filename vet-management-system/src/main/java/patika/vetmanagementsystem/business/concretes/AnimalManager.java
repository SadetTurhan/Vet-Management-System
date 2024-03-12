package patika.vetmanagementsystem.business.concretes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.IAnimalService;
import patika.vetmanagementsystem.core.exception.NotFoundException;
import patika.vetmanagementsystem.core.utilies.Msg;
import patika.vetmanagementsystem.dao.AnimalRepo;
import patika.vetmanagementsystem.entities.Animal;

import java.util.List;

@Service
public class AnimalManager implements IAnimalService {
    private final AnimalRepo animalRepo;

    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public Animal save(Animal animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public Animal get(int id) {
        return this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Animal> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.animalRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        Animal animal = this.get(id);
        this.animalRepo.delete(animal);
        return true;
    }

    @Override
    public List<Animal> filterAnimalsByName(String name) {
        return animalRepo.findByNameContaining(name);
    }

}
