package patika.vetmanagementsystem.business.abstracts;

import patika.vetmanagementsystem.entities.AvailableDate;

import java.util.List;

public interface IAvailableDateService {
    List<AvailableDate> getAvailableDatesByDoctor(Long doctorId);
    AvailableDate addAvailableDate(AvailableDate availableDate);
    boolean deleteAvailableDate(Long availableDateId);
}
