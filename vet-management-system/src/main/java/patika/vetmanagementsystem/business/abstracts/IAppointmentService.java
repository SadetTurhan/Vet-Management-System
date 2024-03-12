package patika.vetmanagementsystem.business.abstracts;

import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Appointment;

import java.util.List;

@Repository
public interface IAppointmentService {
    public List<Appointment> getAll();
    public Appointment getById(Long id);
    public Appointment save(Appointment appointment);
    public void delete(Long id);
    public Appointment update(Long id, Appointment updatedAppointment);
}
