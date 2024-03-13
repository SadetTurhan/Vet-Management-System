package patika.vetmanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.vetmanagementsystem.business.abstracts.IAvailableDateService;
import patika.vetmanagementsystem.core.exception.NotFoundException;
import patika.vetmanagementsystem.dao.AvailableDateRepo;
import patika.vetmanagementsystem.dao.DoctorRepo;
import patika.vetmanagementsystem.dto.request.availableDate.AvailableDateSaveRequest;
import patika.vetmanagementsystem.entities.AvailableDate;
import patika.vetmanagementsystem.entities.Doctor;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/doctors/{doctorId}/available-dates")
public class AvailableDateController {
    @Autowired
    private final IAvailableDateService availableDateService;
    @Autowired
    private final AvailableDateRepo availableDateRepo;
    @Autowired
    private final DoctorRepo doctorRepo;
    public AvailableDateController(IAvailableDateService availableDateService, AvailableDateRepo availableDateRepo, DoctorRepo doctorRepo) {
        this.availableDateService = availableDateService;
        this.availableDateRepo = availableDateRepo;
        this.doctorRepo = doctorRepo;
    }

    @GetMapping()
    public ResponseEntity<List<AvailableDate>> getAvailableDatesByDoctor(@PathVariable Long doctorId) {
        List<AvailableDate> availableDates = availableDateService.getAvailableDatesByDoctor(doctorId);
        return ResponseEntity.ok(availableDates);
    }
    @DeleteMapping("/{availableDateId}")
    public ResponseEntity<Void> deleteAvailableDate(@PathVariable Long availableDateId) {
        availableDateService.deleteAvailableDate(availableDateId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping()
    public ResponseEntity<AvailableDate> addAvailableDate(@PathVariable Long doctorId, @RequestBody AvailableDateSaveRequest request) {
        Doctor doctor = doctorRepo.findById(Math.toIntExact(doctorId))
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + doctorId));

        AvailableDate availableDate = new AvailableDate();
        availableDate.setAvailableDate(request.getAvailableDate());
        availableDate.setDoctor(doctor);

        AvailableDate newAvailableDate = availableDateService.addAvailableDate(availableDate);
        return ResponseEntity.ok(newAvailableDate);
    }
    @PutMapping("/{availableDateId}")
    public ResponseEntity<AvailableDate> updateAvailableDate(@PathVariable Long doctorId, @PathVariable Long availableDateId, @RequestBody AvailableDateSaveRequest request) {
        Doctor doctor = doctorRepo.findById(Math.toIntExact(doctorId))
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + doctorId));

        AvailableDate availableDate = availableDateRepo.findById(availableDateId)
                .orElseThrow(() -> new NotFoundException("AvailableDate not found with id: " + availableDateId));
        availableDate.setAvailableDate(availableDate.getAvailableDate());
        availableDate.setDoctor(doctor);

        AvailableDate updatedAvailableDate = availableDateRepo.save(availableDate);
        return ResponseEntity.ok(updatedAvailableDate);
    }
}
