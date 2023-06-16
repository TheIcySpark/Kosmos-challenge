package kosmos.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosmos.challenge.model.DoctorModel;

public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
}