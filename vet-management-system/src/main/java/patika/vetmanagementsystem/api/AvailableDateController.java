package patika.vetmanagementsystem.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.vetmanagementsystem.business.concretes.AvailableDateManager;
import patika.vetmanagementsystem.dao.AvailableDateRepo;
import patika.vetmanagementsystem.dto.request.availableDate.AvailableDateSaveRequest;
import patika.vetmanagementsystem.entities.AvailableDate;
import java.util.List;
@RestController
@RequestMapping("/api/available-dates")
public class AvailableDateController {

    private final AvailableDateManager availableDateManager;

    public AvailableDateController(AvailableDateManager availableDateManager) {
        this.availableDateManager = availableDateManager;
    }

    @GetMapping("/doctor/{doctorId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AvailableDate>> getAvailableDatesByDoctor(@PathVariable long doctorId) {
        List<AvailableDate> availableDates = availableDateManager.getAvailableDatesByDoctorId(doctorId);
        return ResponseEntity.ok(availableDates);
    }

    @PostMapping("/doctor/{doctorId}")
    public ResponseEntity<AvailableDate> addAvailableDate(
            @PathVariable long doctorId,
            @RequestBody AvailableDateSaveRequest request) {
        AvailableDate newDate = new AvailableDate();
        // Set date and other properties from the request
        newDate.setAvailableDate(request.getAvailableDate());
        // Add any other properties as needed

        AvailableDate savedDate = availableDateManager.addAvailableDate((int) doctorId, newDate);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDate);
    }

    @DeleteMapping("/{availableDateId}")
    public ResponseEntity<Void> removeAvailableDate(@PathVariable long availableDateId) {
        availableDateManager.removeAvailableDate(availableDateId);
        return ResponseEntity.noContent().build();
    }

    // Other API endpoints as needed
}
