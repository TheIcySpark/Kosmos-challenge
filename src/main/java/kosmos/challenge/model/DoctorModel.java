package kosmos.challenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class DoctorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String paternalLastName;
    private String maternalLastName;
    private String speciality;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPaternalLastName() {
        return paternalLastName;
    }
    public void setPaternalLastName(String paternalLastName) {
        this.paternalLastName = paternalLastName;
    }
    public String getMaternalLastName() {
        return maternalLastName;
    }
    public void setMaternalLastName(String maternalLastName) {
        this.maternalLastName = maternalLastName;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    
    
}
