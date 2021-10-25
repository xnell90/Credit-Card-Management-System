package dao;

import java.sql.SQLException;
import java.util.LinkedList;

import interfaces.CreditCardTransactionINTERFACE;
import models.CreditCardTransaction;
import resources.Queries;

public class CreditCardTransactionDAO extends DatabaseDAO implements CreditCardTransactionINTERFACE{

	private LinkedList<CreditCardTransaction> transactions;
	
	public CreditCardTransactionDAO(String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			getConnection(username, password);
		} catch (SQLException e) {
			throw new SQLException();
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (IllegalAccessException e) {
			throw new IllegalAccessException();
		} catch (InstantiationException e) {
			throw new InstantiationException();
		}
		
		
		this.transactions = new LinkedList<CreditCardTransaction>();
	}
	
	@Override
	public void stopConnection(){
		try {
			closeConnection();
		} catch (Exception e) {
			
		}
	}
	
	public void updateTransactionList() {
		try {
			while (this.resultSet.next()) {
				CreditCardTransaction transaction = new CreditCardTransaction();
				
				transaction.setTransactionID(this.resultSet.getInt("TRANSACTION_ID"));
				transaction.setDay(this.resultSet.getInt("DAY"));
				transaction.setMonth(this.resultSet.getInt("MONTH"));
				transaction.setYear(this.resultSet.getInt("YEAR"));
				transaction.setCreditCardNumber(this.resultSet.getString("CREDIT_CARD_NO"));
				transaction.setCustomerSSN(this.resultSet.getInt("CUST_SSN"));
				transaction.setBranchCode(this.resultSet.getInt("BRANCH_CODE"));
				transaction.setTransactionType(this.resultSet.getString("TRANSACTION_TYPE"));
				transaction.setTranscationValue(this.resultSet.getDouble("TRANSACTION_VALUE"));
				
				this.transactions.push(transaction);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void displayTransactions() {
		int counter = 0;
		
		System.out.format("%-14s | %-3s | %-5s | %-4s | "
						+ "%-18s | %-9s | %-12s | "
						+ "%-16s | %-17s \n", 
						"Transaction ID", "Day", "Month", "Year", 
						"Credit Card Number", "SSN", "Branch Code",
						"Transaction Type", "Transaction Value");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		
		for(CreditCardTransaction transaction: this.transactions) {	
			counter += 1;
			int transactionID = transaction.getTransactionID();
			int day = transaction.getDay();
			int month = transaction.getMonth();
			int year = transaction.getYear();
			int ssn = transaction.getCustomerSSN();
			int branchCode = transaction.getBranchCode();
			
			String creditCardNumber = transaction.getCreditCardNumber();
			String transactionType = transaction.getTransactionType();
			double transactionValue = transaction.getTransactionValue();
			
			System.out.format("%-14d | %-3d | %-5d | %-4d | "
							+ "%-18s | %-9d | %-12d | "
							+ "%-16s | %-20.3f \n", 
							  transactionID, day, month, year, 
							  creditCardNumber, ssn, branchCode,
							  transactionType, transactionValue);
			if (counter == 10) {
				break;
			}
		}
		System.out.format("%-14s | %-3s | %-5s | %-4s | "
						+ "%-18s | %-9s | %-12s | "
						+ "%-16s | %-17s \n", 
						":", ":", ":", ":", 
						":", ":", ":",
						":", ":");
		System.out.format("%-14s | %-3s | %-5s | %-4s | "
						+ "%-18s | %-9s | %-12s | "
						+ "%-16s | %-17s \n", 
						":", ":", ":", ":", 
						":", ":", ":",
						":", ":");

		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
	}

	@Override
	public void transactionsByZipMonthYear(int zip, int month, int year) {
		System.out.println("All transactions by Zip Code, Month and Year");
		System.out.println("--------------------------------------------");
		
		try {
			this.prepareStatement = this.connection.prepareStatement(Queries.transactions);
			this.prepareStatement.setInt(1, zip);
			this.prepareStatement.setInt(2, month);
			this.prepareStatement.setInt(3, year);
			this.resultSet = this.prepareStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		updateTransactionList();
		displayTransactions();
	}

	@Override
	public void numberAndTotalValueOfTransactionType(String transactionType) {
		try {
			this.prepareStatement = this.connection.prepareStatement(Queries.allTransactionsOfType);
			this.prepareStatement.setString(1, transactionType);
			this.resultSet = this.prepareStatement.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		updateTransactionList();
		
		//Display all transaction of a given type
		System.out.println("--All transactions of type: " + transactionType + " --");
		System.out.println("----------------------------------------------------------");
		displayTransactions();
	
		//Get number and total value of a transaction type
		System.out.println("--Summary for transaction type: " + transactionType + " --");
		System.out.println("----------------------------------------------------------");
		
		try {
			this.prepareStatement = this.connection.prepareStatement(Queries.numberAndTotalValueOfTransactionType);
			this.prepareStatement.setString(1, transactionType);
			this.resultSet = this.prepareStatement.executeQuery();
			
			while (this.resultSet.next()) {
				int numTransactions = resultSet.getInt("Number of Transactions");
				double totalValue = resultSet.getDouble("Total Value");
				
				System.out.println("Number of Transactions: " + numTransactions);
				System.out.println("Total Value of Transactions: " + totalValue);
				System.out.println("----------------------------------------------------------");
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}

	@Override
	public void numberAndTotalValueOfBranchTransactions(String state) {
		
		//Get all transactions from a given state
		
		try {
			this.prepareStatement = this.connection.prepareStatement(Queries.allTransactionsFromState);
			this.prepareStatement.setString(1, state);
			this.resultSet = this.prepareStatement.executeQuery();
		
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		updateTransactionList();
		
		//Display all transaction from a given state
		System.out.println("--All transactions from state: " + state + " --");
		System.out.println("----------------------------------------------------------");
		displayTransactions();
		
		System.out.println("--Summary for all branches in state: " + state + " --");
		System.out.println("----------------------------------------------------------");
		System.out.format("%-11s | %-22s | %-11s \n", "Branch Code", "Number of Transactions", "Total Value");
		System.out.println("----------------------------------------------------------");
		try {
			this.prepareStatement = this.connection.prepareStatement(Queries.numberAndTotalValueOfBranchTransactions);
			this.prepareStatement.setString(1, state);
			this.resultSet = this.prepareStatement.executeQuery();
			
			while (this.resultSet.next()) {
				
				int branchCode 	= this.resultSet.getInt("Branch Code");
				int numTransactions = this.resultSet.getInt("Number of Transactions");
				double totalValue = this.resultSet.getDouble("Total Value");
				
				System.out.format("%-11d | %-22d | %-20.3f \n", branchCode, numTransactions, totalValue);
			}
			System.out.println("----------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
}
