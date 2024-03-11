package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Appointment;
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
}
