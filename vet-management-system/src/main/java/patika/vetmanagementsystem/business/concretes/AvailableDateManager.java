package patika.vetmanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.IAvailableDateService;
import patika.vetmanagementsystem.core.exception.NotFoundException;
import patika.vetmanagementsystem.dao.AvailableDateRepo;
import patika.vetmanagementsystem.dao.DoctorRepo;
import patika.vetmanagementsystem.entities.AvailableDate;
import patika.vetmanagementsystem.entities.Doctor;
import java.util.List;
import java.time.LocalDate;

@Service
public class AvailableDateManager implements IAvailableDateService {
    @Autowired
    private final AvailableDateRepo availableDateRepo;
    @Autowired
    private final DoctorRepo doctorRepo;

    public AvailableDateManager(AvailableDateRepo availableDateRepo, DoctorRepo doctorRepo) {
        this.availableDateRepo = availableDateRepo;
        this.doctorRepo = doctorRepo;
    }

    @Override
    public List<AvailableDate> getAllAvailableDatesByDoctor(Long doctorId) {
        return availableDateRepo.findByDoctorId(doctorId);
    }

    @Override
    public AvailableDate getAvailableDate(Long doctorId, Long availableDateId) {
        return availableDateRepo.findByIdAndDoctorId(availableDateId, doctorId)
                .orElseThrow(() -> new NotFoundException("AvailableDate not found with id: " + availableDateId));
    }

    @Override
    public AvailableDate addAvailableDate(Long doctorId, LocalDate date) {
        try {
            Doctor doctor = doctorRepo.findById(Math.toIntExact(doctorId))
                    .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + doctorId));

            AvailableDate availableDate = new AvailableDate();
            availableDate.setAvailableDate(date);
            availableDate.setDoctor(doctor);
            return availableDateRepo.save(availableDate);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    public AvailableDate updateAvailableDate(Long doctorId, Long availableDateId, LocalDate date) {
        AvailableDate existingAvailableDate = getAvailableDate(doctorId, availableDateId);
        existingAvailableDate.setAvailableDate(date);
        return availableDateRepo.save(existingAvailableDate);
    }

    @Override
    public void deleteAvailableDate(Long doctorId, Long availableDateId) {
        AvailableDate existingAvailableDate = getAvailableDate(doctorId, availableDateId);
        availableDateRepo.delete(existingAvailableDate);
    }

}
