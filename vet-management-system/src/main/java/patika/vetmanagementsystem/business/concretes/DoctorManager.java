package patika.vetmanagementsystem.business.concretes;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.IDoctorService;
import patika.vetmanagementsystem.entities.Doctor;
@Service
public class DoctorManager implements IDoctorService {
    @Override
    public Doctor save(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor get(int id) {
        return null;
    }

    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
