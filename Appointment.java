

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "AppointmentInfo")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int appointmentID;
	@Column
	String AppointmentDetails;
	int patientID;
	int DOCID;
	int slotnum;
	public int getAppointmentID() {
		return appointmentID;
	}
	public String getAppointmentDetails() {
		return AppointmentDetails;
	}
	public void setAppointmentDetails(String appointmentDetails) {
		AppointmentDetails = appointmentDetails;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getDOCID() {
		return DOCID;
	}
	public void setDOCID(int dOCID) {
		DOCID = dOCID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public int getSlotnum() {
		return slotnum;
	}
	public void setSlotnum(int slotnum) {
		this.slotnum = slotnum;
	}
}	
	



