package patika.vetmanagementsystem.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.vetmanagementsystem.business.abstracts.IVaccineService;
import patika.vetmanagementsystem.core.config.ModelMapper.IModelMapperService;
import patika.vetmanagementsystem.core.result.Result;
import patika.vetmanagementsystem.core.result.ResultData;
import patika.vetmanagementsystem.core.utilies.ResultHelper;
import patika.vetmanagementsystem.dto.CursorResponse;
import patika.vetmanagementsystem.dto.request.doctor.DoctorSaveRequest;
import patika.vetmanagementsystem.dto.request.doctor.DoctorUpdateRequest;
import patika.vetmanagementsystem.dto.request.vaccine.VaccineSaveRequest;
import patika.vetmanagementsystem.dto.request.vaccine.VaccineUpdateRequest;
import patika.vetmanagementsystem.dto.response.doctor.DoctorResponse;
import patika.vetmanagementsystem.dto.response.vaccine.VaccineResponse;
import patika.vetmanagementsystem.entities.Doctor;
import patika.vetmanagementsystem.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/vaccines")
public class VaccineController {
    private final IVaccineService vaccineService;
    private final IModelMapperService modelMapper;

    public VaccineController(IVaccineService vaccineService, IModelMapperService modelMapper) {
        this.vaccineService = vaccineService;
        this.modelMapper = modelMapper;
    }
    @PostMapping
    public ResponseEntity<Vaccine> save(@RequestBody Vaccine vaccine) {
        boolean vaccineExists = vaccineService.isVaccineAlreadyExists(vaccine.getName(), vaccine.getCode(), vaccine.getProtectionFinishDate());
        if (vaccineExists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Vaccine savedVaccine = vaccineService.save(vaccine);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVaccine);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> get(@PathVariable("id") int id){
        Vaccine vaccine = this.vaccineService.get((long) id);
        return ResultHelper.success(this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<VaccineResponse>> cursor(
            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    ){
        Page<Vaccine> vaccinePage = this.vaccineService.cursor(page,pageSize);
        Page<VaccineResponse> vaccineResponsePage = vaccinePage
                .map(vaccine -> this.modelMapper.forResponse().map(vaccine,VaccineResponse.class));

        return ResultHelper.cursor(vaccineResponsePage);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> update(@Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest){
        this.vaccineService.get((long) vaccineUpdateRequest.getId());
        Vaccine updateVaccine = this.modelMapper.forRequest().map(vaccineUpdateRequest,Vaccine.class);
        this.vaccineService.save(updateVaccine);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateVaccine,VaccineResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.vaccineService.delete((long) id);
        return ResultHelper.ok();
    }
    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<Vaccine>> getVaccinesByAnimalId(@PathVariable Long animalId) {
        List<Vaccine> vaccines = vaccineService.getVaccinesByAnimalId(animalId);
        return ResponseEntity.ok(vaccines);
    }
    @GetMapping("/expiration")
    public ResponseEntity<List<Vaccine>> getExpiringVaccines(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Vaccine> vaccines = vaccineService.getVaccinesByProtectionFinishDateBetween(startDate, endDate);
        return ResponseEntity.ok(vaccines);
    }
}
