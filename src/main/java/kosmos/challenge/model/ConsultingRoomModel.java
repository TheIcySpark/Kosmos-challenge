package kosmos.challenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consulting_rooms")
public class ConsultingRoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int roomNumber;
    private int floor;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }

    

}
