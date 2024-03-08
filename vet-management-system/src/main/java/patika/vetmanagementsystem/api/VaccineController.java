package patika.vetmanagementsystem.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/v1/vaccines")
public class VaccineController {
    private final IVaccineService vaccineService;
    private final IModelMapperService modelMapper;

    public VaccineController(IVaccineService vaccineService, IModelMapperService modelMapper) {
        this.vaccineService = vaccineService;
        this.modelMapper = modelMapper;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<VaccineResponse> save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest){
        Vaccine saveVaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);
        this.vaccineService.save(saveVaccine);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveVaccine, VaccineResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> get(@PathVariable("id") int id){
        Vaccine vaccine = this.vaccineService.get(id);
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
        this.vaccineService.get(vaccineUpdateRequest.getId());
        Vaccine updateVaccine = this.modelMapper.forRequest().map(vaccineUpdateRequest,Vaccine.class);
        this.vaccineService.save(updateVaccine);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateVaccine,VaccineResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.vaccineService.delete(id);
        return ResultHelper.ok();
    }
}
