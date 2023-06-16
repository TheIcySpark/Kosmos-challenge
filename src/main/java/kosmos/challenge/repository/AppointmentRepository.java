package kosmos.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosmos.challenge.model.AppointmentModel;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {
}
