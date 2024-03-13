package patika.vetmanagementsystem.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patika.vetmanagementsystem.business.abstracts.IAvailableDateService;
import patika.vetmanagementsystem.dao.AvailableDateRepo;
import patika.vetmanagementsystem.entities.AvailableDate;

import java.util.List;
@Service
public class AvailableDateManager implements IAvailableDateService {
    @Autowired
    private AvailableDateRepo availableDateRepository;
    @Override
    public List<AvailableDate> getAvailableDatesByDoctor(Long doctorId) {
        return availableDateRepository.findByDoctorId(doctorId);
    }
    @Override
    public AvailableDate addAvailableDate(AvailableDate availableDate) {
        return availableDateRepository.save(availableDate);
    }
    @Override
    public boolean deleteAvailableDate(Long availableDateId) {
        availableDateRepository.deleteById(availableDateId);
        return false;
    }
}
