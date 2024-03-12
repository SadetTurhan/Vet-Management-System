package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Appointment;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByAppointmentDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
