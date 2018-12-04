package models;

public class CreditCardTransaction {
	private int transactionID;
	private int day;
	private int month;
	private int year;
	private String CreditCardNumber;
	private int CustomerSSN;
	private int BranchCode;
	private String TransactionType;
	private double TransactionValue;
	
	public CreditCardTransaction() {
		this.transactionID = 0;
		this.day = 0;
		this.month = 0;
		this.year = 0;
		this.CreditCardNumber = "";
		this.CustomerSSN = 0;
		this.BranchCode = 0;
		this.TransactionType = "";
		this.TransactionValue = 0.0;
	}
	
	public CreditCardTransaction(int transactionID,
					  			 int day,
					  			 int month,
					  			 int year,
					  			 String CreditCardNumber,
					  			 int CustomerSSN,
					  			 int BranchCode,
					  			 String TransactionType,
					  			 double TransactionValue) {
		this.transactionID = transactionID;
		this.day = day;
		this.month = month;
		this.year = year;
		this.CreditCardNumber = CreditCardNumber;
		this.CustomerSSN = CustomerSSN;
		this.BranchCode = BranchCode;
		this.TransactionType = TransactionType;
		this.TransactionValue = TransactionValue;
	}
	
	public int getTransactionID() {
		return this.transactionID;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String getCreditCardNumber() {
		return this.CreditCardNumber;
	}
	
	public int getCustomerSSN() {
		return this.CustomerSSN;
	}
	
	public int getBranchCode() {
		return this.BranchCode;
	}
	
	public String getTransactionType() {
		return this.TransactionType;
	}
	
	public double getTransactionValue() {
		return this.TransactionValue;
	}
	
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setCreditCardNumber(String CreditCardNumber) {
		this.CreditCardNumber = CreditCardNumber;
	}
	
	public void setCustomerSSN(int CustomerSSN) {
		this.CustomerSSN = CustomerSSN;
	}
	
	public void setBranchCode(int BranchCode) {
		this.BranchCode = BranchCode;
	}
	
	public void setTransactionType(String TransactionType) {
		this.TransactionType = TransactionType;
	}
	
	public void setTranscationValue(double TransactionValue) {
		this.TransactionValue = TransactionValue;
	}
	

}
