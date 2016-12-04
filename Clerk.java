import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MyHealth_Clerk")
public class Clerk extends Person{
	public int getClerkId() {
		return PersonId;
	}
	public void setClerkId(int docId) {
		this.PersonId = docId;
	}
}
