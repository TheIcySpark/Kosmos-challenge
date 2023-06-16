package kosmos.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import kosmos.challenge.model.ConsultingRoomModel;
import kosmos.challenge.model.DoctorModel;
import kosmos.challenge.repository.ConsultingRoomRepository;
import kosmos.challenge.repository.DoctorRepository;

@SpringBootApplication
public class ChallengeApplication {

	@Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultingRoomRepository consultingRoomRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
    public void createDoctors() {
        for (int i = 1; i <= 5; i++) {
            // Create 5 doctors
            DoctorModel doctor = new DoctorModel();
            doctor.setName("Doctor #" + i);
            doctor.setPaternalLastName("Paternal LastName #" + i);
            doctor.setMaternalLastName("Maternal LastName #" + i);
            doctor.setSpeciality("Specialty #" + i);
            doctorRepository.save(doctor);

            // Create 5 consulting rooms
            ConsultingRoomModel consultingRoom = new ConsultingRoomModel();
            consultingRoom.setRoomNumber(i);
            consultingRoom.setFloor(i);
            consultingRoomRepository.save(consultingRoom);
        }
    }
}
