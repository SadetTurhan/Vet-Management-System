package patika.vetmanagementsystem.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patika.vetmanagementsystem.business.abstracts.IAppointmentService;
import patika.vetmanagementsystem.entities.Appointment;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {

}