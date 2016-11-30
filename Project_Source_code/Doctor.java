import javax.persistence.Entity;

//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyHealth_Doctor")
public class Doctor extends Person {

	String specialization;
	
	public int getDocId() {
		return PersonId;
	}
	public void setDocId(int docId) {
		this.PersonId = docId;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
