import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RecordsInfo")
public class Records {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int RecordId;
	@Column
	String RType;
	String Rtestname;
	int RPatId;
	int RDocId;
	String RApproval;
	String Status;
	public String getRtestname() {
		return Rtestname;
	}
	public void setRtestname(String rtestname) {
		Rtestname = rtestname;
	}
	public int getRecordId() {
		return RecordId;
	}
	public void setRecordId(int recordId) {
		RecordId = recordId;
	}
	public String getRType() {
		return RType;
	}
	public void setRType(String rType) {
		RType = rType;
	}
	public int getRPatId() {
		return RPatId;
	}
	public void setRPatId(int rPatId) {
		RPatId = rPatId;
	}
	public int getRDocId() {
		return RDocId;
	}
	public void setRDocId(int rDocId) {
		RDocId = rDocId;
	}
	public String getRApproval() {
		return RApproval;
	}
	public void setRApproval(String rApproval) {
		RApproval = rApproval;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

	

}
