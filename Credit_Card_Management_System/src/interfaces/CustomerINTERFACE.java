package interfaces;

public interface CustomerINTERFACE {
	
	public void displayCustomerInformation(int SSN);
	public void stopConnection();
	public void updateCustomerInformation(int SSN, String fieldNanme, String fieldValue);
	public void generateMonthlyBill(String creditCardNumber, int month, int year);
	public void transactionsBetweenTwoDates(int ssn, int day1, int month1, int year1, int day2, int month2, int year2);

}
