package patika.vetmanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.IAppointmentService;
import patika.vetmanagementsystem.dao.AppointmentRepo;
import patika.vetmanagementsystem.entities.Appointment;
import java.util.List;
@Service
public class AppointmentManager implements IAppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Override
    public List<Appointment> getAll() {
        return appointmentRepo.findAll();
    }
    @Override
    public Appointment getById(Long id) {
        return appointmentRepo.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }
    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }
    @Override
    public void delete(Long id) {
        appointmentRepo.deleteById(Math.toIntExact(id));
    }
    @Override
    public Appointment update(Long id, Appointment updatedAppointment) {
        Appointment appointment = getById(id);
        appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
        return appointmentRepo.save(appointment);
    }
}
