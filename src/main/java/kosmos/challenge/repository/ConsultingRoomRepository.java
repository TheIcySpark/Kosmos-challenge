package kosmos.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosmos.challenge.model.ConsultingRoomModel;

public interface ConsultingRoomRepository extends JpaRepository<ConsultingRoomModel, Long> {
  
}
