package patika.vetmanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.IAppointmentService;
import patika.vetmanagementsystem.dao.AppointmentRepo;
import patika.vetmanagementsystem.dao.AvailableDateRepo;
import patika.vetmanagementsystem.entities.Appointment;
import patika.vetmanagementsystem.entities.AvailableDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentManager implements IAppointmentService {


}

