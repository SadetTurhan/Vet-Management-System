package patika.vetmanagementsystem.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.vetmanagementsystem.business.abstracts.IAnimalService;
import patika.vetmanagementsystem.core.config.ModelMapper.IModelMapperService;
import patika.vetmanagementsystem.core.result.Result;
import patika.vetmanagementsystem.core.result.ResultData;
import patika.vetmanagementsystem.core.utilies.ResultHelper;
import patika.vetmanagementsystem.dao.AnimalRepo;
import patika.vetmanagementsystem.dto.CursorResponse;
import patika.vetmanagementsystem.dto.request.animal.AnimalUpdateRequest;
import patika.vetmanagementsystem.dto.response.animal.AnimalResponse;
import patika.vetmanagementsystem.entities.Animal;
import java.util.List;

@RestController
@RequestMapping("/v1/animals")
public class AnimalController {
    private final IAnimalService animalService;
    private final IModelMapperService modelMapper;
    public AnimalController(IAnimalService animalService, IModelMapperService modelMapper) {
        this.animalService = animalService;
        this.modelMapper = modelMapper;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal){
        return this.animalService.save(animal);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> get(@PathVariable("id") int id){
        Animal animal = this.animalService.get(id);
        AnimalResponse animalResponse = this.modelMapper.forResponse().map(animal,AnimalResponse.class);
        return ResultHelper.success(animalResponse);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AnimalResponse>> cursor(
            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    ){
        Page<Animal> animalPage = this.animalService.cursor(page,pageSize);
        Page<AnimalResponse> animalResponsePage = animalPage
                .map(animal -> this.modelMapper.forResponse().map(animal,AnimalResponse.class));

        return ResultHelper.cursor(animalResponsePage);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<Animal>> filterCustomersByName(@RequestParam String name) {
        List<Animal> filteredAnimals = animalService.filterAnimalsByName(name);
        return ResponseEntity.ok(filteredAnimals);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> update(@Valid @RequestBody AnimalUpdateRequest animalUpdateRequest){
        this.animalService.get(animalUpdateRequest.getId());
        Animal updateAnimal = this.modelMapper.forRequest().map(animalUpdateRequest,Animal.class);
        this.animalService.save(updateAnimal);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateAnimal,AnimalResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.animalService.delete(id);
        return ResultHelper.ok();
    }
}
