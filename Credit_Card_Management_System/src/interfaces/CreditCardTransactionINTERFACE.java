package interfaces;

public interface CreditCardTransactionINTERFACE {
	
	public void displayTransactions();
	public void stopConnection();
	public void transactionsByZipMonthYear(int zip, int month, int year);
	public void numberAndTotalValueOfTransactionType(String transactionType);
	public void numberAndTotalValueOfBranchTransactions(String state);
	
}
