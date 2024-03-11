package patika.vetmanagementsystem.business.concretes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.IDoctorService;
import patika.vetmanagementsystem.core.exception.NotFoundException;
import patika.vetmanagementsystem.core.utilies.Msg;
import patika.vetmanagementsystem.dao.DoctorRepo;
import patika.vetmanagementsystem.entities.Doctor;
@Service
public class DoctorManager implements IDoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Doctor get(int id) {
        return this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.doctorRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
