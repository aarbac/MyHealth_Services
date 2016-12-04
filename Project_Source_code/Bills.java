import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BillsInfo")
public class Bills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int BillId;
	@Column
	int BPatId;
	int BDocId;
	double BAmount;
	public double getBAmount() {
		return BAmount;
	}
	public void setBAmount(double string) {
		BAmount = string;
	}
	String TestType;
	String BApproval;
	String BPaid;
	String BStatus;
	public int getBillId() {
		return BillId;
	}
	public void setBillId(int bilId) {
		BillId = bilId;
	}
	public int getBPatId() {
		return BPatId;
	}
	public void setBPatId(int bPatId) {
		BPatId = bPatId;
	}
	public int getBDocId() {
		return BDocId;
	}
	public void setBDocId(int bDocId) {
		BDocId = bDocId;
	}
	public String getTestType() {
		return TestType;
	}
	public void setTestType(String testType) {
		TestType = testType;
	}
	public String getBApproval() {
		return BApproval;
	}
	public void setBApproval(String bApproval) {
		BApproval = bApproval;
	}
	public String getBPaid() {
		return BPaid;
	}
	public void setBPaid(String bPaid) {
		BPaid = bPaid;
	}
	public String getBStatus() {
		return BStatus;
	}
	public void setBStatus(String bStatus) {
		BStatus = bStatus;
	}
	
	
	

}
