
import javax.persistence.Entity;

//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyHealth_Patient")
public class Patient extends Person {


	public int getPatientId() {
		return PersonId;
	}

	public void setPatientId(int patientId) {
		this.PersonId = patientId;
	}

}
