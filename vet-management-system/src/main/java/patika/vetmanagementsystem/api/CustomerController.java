package patika.vetmanagementsystem.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.vetmanagementsystem.business.abstracts.IAnimalService;
import patika.vetmanagementsystem.business.abstracts.ICustomerService;
import patika.vetmanagementsystem.core.config.ModelMapper.IModelMapperService;
import patika.vetmanagementsystem.core.result.Result;
import patika.vetmanagementsystem.core.result.ResultData;
import patika.vetmanagementsystem.core.utilies.ResultHelper;
import patika.vetmanagementsystem.dto.CursorResponse;
import patika.vetmanagementsystem.dto.request.customer.CustomerSaveRequest;
import patika.vetmanagementsystem.dto.request.customer.CustomerUpdateRequest;
import patika.vetmanagementsystem.dto.response.customer.CustomerResponse;
import patika.vetmanagementsystem.entities.Animal;
import patika.vetmanagementsystem.entities.Customer;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    private final ICustomerService customerService;
    private final IModelMapperService modelMapper;
    private final IAnimalService animalService;
    public CustomerController(ICustomerService customerService, IModelMapperService modelMapper, IAnimalService animalService) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
        this.animalService = animalService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CustomerResponse> save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest){
        Customer saveCostumer = this.modelMapper.forRequest().map(customerSaveRequest, Customer.class);
        Animal animal = this.animalService.get(customerSaveRequest.getAnimalId());
        saveCostumer.setAnimals((List<Animal>) animal);
        this.customerService.save(saveCostumer);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveCostumer, CustomerResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> get(@PathVariable("id") int id){
        Customer customer = this.customerService.getCustomerByIdWithAnimals(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(customer, CustomerResponse.class));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CustomerResponse>> cursor(
            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    ){
        Page<Customer> customerPage = this.customerService.cursor(page,pageSize);
        Page<CustomerResponse> customerResponsePage = customerPage
                .map(customer -> this.modelMapper.forResponse().map(customer,CustomerResponse.class));

        return ResultHelper.cursor(customerResponsePage);
    }
    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Customer>> filterCustomersByName(@RequestParam String name) {
        List<Customer> filteredCustomers = customerService.filterCustomersByName(name);
        return ResponseEntity.ok(filteredCustomers);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> update(@Valid @RequestBody CustomerUpdateRequest customerUpdateRequest){
        this.customerService.get(customerUpdateRequest.getId());
        Customer updateCustomer = this.modelMapper.forRequest().map(customerUpdateRequest,Customer.class);
        this.customerService.save(updateCustomer);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateCustomer,CustomerResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.customerService.deleteCustomer(id);
        return ResultHelper.ok();
    }
    @GetMapping("/{customerId}/animals")
    public ResponseEntity<List<Animal>> getAnimalsByCustomerId(@PathVariable Long customerId) {
        List<Animal> animals = customerService.getAnimalsByCustomerId(Math.toIntExact(customerId));
        return ResponseEntity.ok(animals);
    }
}
