import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CardsInfo")
public class CreditCards {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int CardId;
	@Column
	String CardNum;
	String CardName;
	String CVV;
	String Expirydate;
	String Address;
	public int getCardId() {
		return CardId;
	}
	public void setCardId(int cardId) {
		CardId = cardId;
	}
	public String getCardNum() {
		return CardNum;
	}
	public void setCardNum(String cardNum) {
		CardNum = cardNum;
	}
	public String getCardName() {
		return CardName;
	}
	public void setCardName(String cardName) {
		CardName = cardName;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public String getExpirydate() {
		return Expirydate;
	}
	public void setExpirydate(String expirydate) {
		Expirydate = expirydate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

}
