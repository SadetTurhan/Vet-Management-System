package patika.vetmanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.dao.AvailableDateRepo;
import patika.vetmanagementsystem.entities.AvailableDate;
import patika.vetmanagementsystem.entities.Doctor;

import java.util.List;
@Service
public class AvailableDateManager {
    private final AvailableDateRepo availableDateRepo;
    private final DoctorManager doctorManager;
    @Autowired
    public AvailableDateManager(AvailableDateRepo availableDateRepo, DoctorManager doctorManager) {
        this.availableDateRepo = availableDateRepo;
        this.doctorManager = doctorManager;
    }

    public List<AvailableDate> getAvailableDatesByDoctorId(long doctorId) {
        return availableDateRepo.findByDoctorId(doctorId);
    }

    public AvailableDate addAvailableDate(int doctorId, AvailableDate availableDate) {
        Doctor doctor = doctorManager.get(doctorId);
        availableDate.setDoctor(doctor);
        return availableDateRepo.save(availableDate);
    }

    public void removeAvailableDate(long availableDateId) {
        availableDateRepo.deleteById(availableDateId);
    }
}
