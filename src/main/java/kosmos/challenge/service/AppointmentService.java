package kosmos.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosmos.challenge.model.AppointmentModel;
import kosmos.challenge.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentModel> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<AppointmentModel> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public AppointmentModel createAppointment(AppointmentModel appointment) {
        return appointmentRepository.save(appointment);
    }

    public AppointmentModel updateAppointment(Long id, AppointmentModel appointment) {
        Optional<AppointmentModel> existingAppointmentOptional = appointmentRepository.findById(id);
        if (existingAppointmentOptional.isPresent()) {
            AppointmentModel existingAppointment = existingAppointmentOptional.get();
            existingAppointment.setConsultingRoom(appointment.getConsultingRoom());
            existingAppointment.setDoctor(appointment.getDoctor());
            existingAppointment.setAppointmentTime(appointment.getAppointmentTime());
            existingAppointment.setPatientName(appointment.getPatientName());
            return appointmentRepository.save(existingAppointment);
        } else {
            return null;
        }
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
