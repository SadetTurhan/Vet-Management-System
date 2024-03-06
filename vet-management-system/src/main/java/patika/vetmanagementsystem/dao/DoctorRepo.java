package patika.vetmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patika.vetmanagementsystem.entities.Doctor;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
}
