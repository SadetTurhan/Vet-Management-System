package patika.vetmanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.vetmanagementsystem.business.abstracts.IAvailableDateService;
import patika.vetmanagementsystem.dto.request.availableDate.AvailableDateRequest;
import patika.vetmanagementsystem.entities.AvailableDate;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/v1/doctors/{doctorId}/available-dates")
public class AvailableDateController {
    @Autowired
    private IAvailableDateService availableDateService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AvailableDate> addAvailableDate(@PathVariable Long doctorId, @RequestBody AvailableDateRequest request) {
        LocalDate date = request.getDate();
        if (date == null) {
            return ResponseEntity.badRequest().build();
        }
        AvailableDate newAvailableDate = availableDateService.addAvailableDate(doctorId, date);
        return ResponseEntity.ok(newAvailableDate);
    }

    @GetMapping()
    public ResponseEntity<List<AvailableDate>> getAvailableDatesByDoctor(@PathVariable Long doctorId) {
        List<AvailableDate> availableDates = availableDateService.getAllAvailableDatesByDoctor(doctorId);
        return ResponseEntity.ok(availableDates);
    }

    @DeleteMapping("{availableDateId}")
    public ResponseEntity<Void> deleteAvailableDate(@PathVariable Long doctorId, @PathVariable Long availableDateId) {
        availableDateService.deleteAvailableDate(doctorId, availableDateId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{availableDateId}")
    public ResponseEntity<AvailableDate> updateAvailableDate(@PathVariable Long doctorId, @PathVariable Long availableDateId, @RequestBody AvailableDateRequest request) {
        LocalDate date = request.getDate();
        if (date == null) {
            return ResponseEntity.badRequest().build();
        }
        AvailableDate updatedAvailableDate = availableDateService.updateAvailableDate(doctorId, availableDateId, date);
        return ResponseEntity.ok(updatedAvailableDate);
    }
}
