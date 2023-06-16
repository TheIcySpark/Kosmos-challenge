package kosmos.challenge.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private ConsultingRoomModel consultingRoom;

    @ManyToOne
    private DoctorModel doctor;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime appointmentTime;

    private String patientName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConsultingRoomModel getConsultingRoom() {
        return consultingRoom;
    }

    public void setConsultingRoom(ConsultingRoomModel consultingRoom) {
        this.consultingRoom = consultingRoom;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    

    
}