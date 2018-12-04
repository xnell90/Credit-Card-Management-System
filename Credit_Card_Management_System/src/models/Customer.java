package models;

public class Customer {

	private String FirstName;
	private String MiddleName;
	private String LastName;
	private int SSN;
	private String CreditCardNumber;
	private String AptNum;
	private String StreetName;
	
	private String CustomerCity;
	private String CustomerState;
	private String CustomerCountry;
	private String CustomerZip;
	private int CustomerPhone;
	private String CustomerEmail;
	
	private String LastUpdated;
	
	public Customer() {
		this.FirstName = "";
		this.MiddleName = "";
		this.LastName = "";
		this.SSN = 0;
		this.CreditCardNumber = "";
		this.AptNum = "";
		this.StreetName = "";
		this.CustomerCity = "";
		this.CustomerState = "";
		this.CustomerCountry = "";
		this.CustomerZip = "";
		this.CustomerPhone = 0;
		this.CustomerEmail = "";
		this.LastUpdated = "";
	}
	
	public Customer(String FirstName, 
			 		String MiddleName,
			 		String LastName,
			 		int SSN,
			 		String CreditCardNumber,
			 		String AptNum,
			 		String StreetName,
			 		String CustomerCity,
			 		String CustomerState,
			 		String CustomerCountry,
			 		String CustomerZip,
			 		int CustomerPhone,
			 		String CustomerEmail,
			 		String LastUpdated) {
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		this.SSN = SSN;
		this.CreditCardNumber = CreditCardNumber;
		this.AptNum = AptNum;
		this.StreetName = StreetName;
		this.CustomerCity = CustomerCity;
		this.CustomerState = CustomerState;
		this.CustomerCountry = CustomerCountry;
		this.CustomerZip = CustomerZip;
		this.CustomerPhone = CustomerPhone;
		this.CustomerEmail = CustomerEmail;
		this.LastUpdated = LastUpdated;
	}
	
	public String getFirstName() {
		return this.FirstName;
	}
	
	public String getMiddleName() {
		return this.MiddleName;
	}
	
	public String getLastName() {
		return this.LastName;
	}
	
	public int getSSN() {
		return this.SSN;
	}
	
	public String getCreditCardNumber() {
		return this.CreditCardNumber;
	}
	
	public String getAptNum() {
		return this.AptNum;
	}
	
	public String getStreetName() {
		return this.StreetName;
	}
	
	public String getCustomerCity() {
		return this.CustomerCity;
	}
	
	public String getCustomerState() {
		return this.CustomerState;
	}
	
	public String getCustomerCountry() {
		return this.CustomerCountry;
	}
	
	public String getCustomerZip() {
		return this.CustomerZip;
	}

	public int getCustomerPhone() {
		return this.CustomerPhone;
	}
	
	public String getCustomerEmail() {
		return this.CustomerEmail;
	}
	
	public String getLastUpdated() {
		return this.LastUpdated;
	}
	
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}
	
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public void setSSN(int SSN) {
		this.SSN = SSN;
	}
	
	public void setCreditCardNumber(String CreditCardNumber) {
		this.CreditCardNumber = CreditCardNumber;
	}
	
	public void setAptNum(String AptNum) {
		this.AptNum = AptNum;
	}
	
	public void setStreetName(String StreetName) {
		this.StreetName = StreetName;
	}
	
	public void setCustomerCity(String CustomerCity) {
		this.CustomerCity = CustomerCity;
	}
	
	public void setCustomerState(String CustomerState) {
		this.CustomerState = CustomerState;
	}
	
	public void setCustomerCountry(String CustomerCountry) {
		this.CustomerCountry = CustomerCountry;
	}
	
	public void setCustomerZip(String CustomerZip) {
		this.CustomerZip = CustomerZip;
	}

	public void setCustomerPhone(int CustomerPhone) {
		this.CustomerPhone = CustomerPhone;
	}
	
	public void setCustomerEmail(String CustomerEmail) {
		this.CustomerEmail = CustomerEmail;
	}
	
	public void setLastUpdated(String LastUpdated) {
		this.LastUpdated = LastUpdated;
	}
}
