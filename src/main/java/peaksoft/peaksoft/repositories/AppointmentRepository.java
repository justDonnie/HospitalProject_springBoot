package peaksoft.peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.peaksoft.entities.Appointment;

public interface AppointmentRepository extends JpaRepository <Appointment,Long> {
}
