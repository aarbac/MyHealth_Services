import javax.persistence.Entity;

//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyHealth_Doctor")
public class Doctor extends Person {
	
	public int getDocId() {
		return PersonId;
	}
	public void setDocId(int docId) {
		this.PersonId = docId;
	}


}
