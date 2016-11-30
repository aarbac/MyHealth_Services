import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SlotsInfo")
public class Slots {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int SlotNum;
	String start_time;
	String end_time;
	String day;
	int DocId;
	public int getDocId() {
		return DocId;
	}
	public void setDocId(int docId) {
		DocId = docId;
	}
	public int getSlotNum() {
		return SlotNum;
	}
	public void setSlotNum(int slotNum) {
		SlotNum = slotNum;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	

}
