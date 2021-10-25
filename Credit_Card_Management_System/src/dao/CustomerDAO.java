package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import interfaces.CustomerINTERFACE;
import models.Customer;

import resources.Queries;

//Modified the update method by adding this.customer = new Customer().
public class CustomerDAO extends DatabaseDAO implements CustomerINTERFACE{
	
	private Customer customer;
	
	public CustomerDAO(String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
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
		
		this.customer = new Customer();
	}
	
	@Override
	public void displayCustomerInformation(int SSN) {
		
		try {
			/*if ssn is the same as customer.getSSN then get the information from the class. 
			Otherwise, get access to the database*/
			
			if (SSN == this.customer.getSSN()) {
				System.out.println("Customer Information with SSN: " + SSN);
				System.out.println("-------------------------------------------------");
				System.out.format("%-20s	%-40s \n", "First Name:", this.customer.getFirstName());
				System.out.format("%-20s	%-40s \n", "Middle Name:", this.customer.getMiddleName());
				System.out.format("%-20s	%-40s \n", "Last Name:"	, this.customer.getLastName());
				System.out.format("%-20s	%-40d \n", "SSN:", this.customer.getSSN());
				System.out.format("%-20s	%-40s \n", "Credit Card Number", this.customer.getCreditCardNumber());
				System.out.format("%-20s	%-40s \n", "Appartment Number:", this.customer.getAptNum());
				System.out.format("%-20s	%-40s \n", "Street Name:", this.customer.getStreetName());
				System.out.format("%-20s	%-40s \n", "Customer City:", this.customer.getCustomerCity());
				System.out.format("%-20s	%-40s \n", "Customer State:", this.customer.getCustomerState());
				System.out.format("%-20s	%-40s \n", "Customer Country:", this.customer.getCustomerCountry());
				System.out.format("%-20s	%-40s \n", "Customer Zip:", this.customer.getCustomerZip());
				System.out.format("%-20s	%-40d \n", "Customer Phone:", this.customer.getCustomerPhone());
				System.out.format("%-20s	%-40s \n", "Customer Email:", this.customer.getCustomerEmail());
				System.out.format("%-20s	%-40s \n", "Last Updated:", this.customer.getLastUpdated());
				System.out.println("-------------------------------------------------");
			} else {
				this.prepareStatement = this.connection.prepareStatement(Queries.displayCustomerSSN);
				this.prepareStatement.setInt(1, SSN);
				this.resultSet = prepareStatement.executeQuery();
				
				System.out.println("Customer Information with SSN: " + SSN);
				System.out.println("-------------------------------------------------");
				while (resultSet.next()) {
					System.out.format("%-20s	%-40s \n", "First Name:", resultSet.getString("FIRST_NAME"));
					System.out.format("%-20s	%-40s \n", "Middle Name:", resultSet.getString("MIDDLE_NAME"));
					System.out.format("%-20s	%-40s \n", "Last Name:"	, resultSet.getString("LAST_NAME"));
					System.out.format("%-20s	%-40d \n", "SSN:", resultSet.getInt("SSN"));
					System.out.format("%-20s	%-40s \n", "Credit Card Number", resultSet.getString("CREDIT_CARD_NO"));	
					System.out.format("%-20s	%-40s \n", "Appartment Number:", resultSet.getString("APT_NO"));
					System.out.format("%-20s	%-40s \n", "Street Name:", resultSet.getString("STREET_NAME"));
					System.out.format("%-20s	%-40s \n", "Customer City:", resultSet.getString("CUST_CITY"));
					System.out.format("%-20s	%-40s \n", "Customer State:", resultSet.getString("CUST_STATE"));
					System.out.format("%-20s	%-40s \n", "Customer Country:", resultSet.getString("CUST_COUNTRY"));
					System.out.format("%-20s	%-40s \n", "Customer Zip:", resultSet.getString("CUST_ZIP"));
					System.out.format("%-20s	%-40s \n", "Customer Phone:", resultSet.getInt("CUST_PHONE"));
					System.out.format("%-20s	%-40s \n", "Customer Email:", resultSet.getString("CUST_EMAIL"));
					System.out.format("%-20s	%-40s \n", "Last Updated:", resultSet.getString("LAST_UPDATED"));
					
					this.customer.setFirstName(resultSet.getString("FIRST_NAME"));
					this.customer.setMiddleName(resultSet.getString("MIDDLE_NAME"));
					this.customer.setLastName(resultSet.getString("LAST_NAME"));
					this.customer.setSSN(resultSet.getInt("SSN"));
					this.customer.setCreditCardNumber(resultSet.getString("CREDIT_CARD_NO"));
					this.customer.setAptNum	(resultSet.getString("APT_NO"));
					this.customer.setStreetName(resultSet.getString("STREET_NAME"));
					this.customer.setCustomerCity(resultSet.getString("CUST_CITY"));
					this.customer.setCustomerState(resultSet.getString("CUST_STATE"));
					this.customer.setCustomerCountry(resultSet.getString("CUST_COUNTRY"));
					this.customer.setCustomerZip(resultSet.getString("CUST_ZIP"));
					this.customer.setCustomerPhone(resultSet.getInt("CUST_PHONE"));
					this.customer.setCustomerEmail(resultSet.getString("CUST_EMAIL"));
					this.customer.setLastUpdated(resultSet.getString("LAST_UPDATED"));
					
				}
				System.out.println("-------------------------------------------------");
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
	}

	@Override
	public void stopConnection() {
		try {
			closeConnection();
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public void updateCustomerInformation(int SSN, String fieldName, String fieldValue) {
		
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			Date currentDate = Calendar.getInstance().getTime();

			this.prepareStatement = this.connection.prepareStatement(Queries.updateCustomerTable(fieldName));
			this.prepareStatement.setString(2, dateFormat.format(currentDate));
			this.prepareStatement.setString(1, fieldValue);
			this.prepareStatement.setInt(3, SSN);

			int numUpdates = this.prepareStatement.executeUpdate();
			if (numUpdates != 0) {
				System.out.println("Customer Information Has Been Updated");
			} else {
				System.out.println("Customer Information Has Not Been Updated");
			}
			this.customer = new Customer();
		
		} catch (SQLException e) {
			System.out.println("Error: " + e);
			System.out.println("Customer Information Has Not Been Updated");
		}
		
	}

	@Override
	public void generateMonthlyBill(String creditCardNumber, int month, int year) {
		double totalBill = 0.0;
		
		try {
			this.prepareStatement = this.connection.prepareStatement(Queries.monthlyBill);
			this.prepareStatement.setInt(1, month);
			this.prepareStatement.setInt(2, year);
			this.prepareStatement.setString(3, creditCardNumber);
			
			this.resultSet = prepareStatement.executeQuery();
			
			System.out.println("Monthly Bill - Month: " + month + " Year: " + year);
			System.out.println("-------------------------------------------------");
			System.out.format("%-20s	%-40s \n", "Transaction Type", "Transaction Value");
			System.out.println("-------------------------------------------------");
			while (resultSet.next()) {
				System.out.format("%-20s	%-20.2f \n", resultSet.getString("TRANSACTION_TYPE"), resultSet.getDouble("TRANSACTION_VALUE"));
				totalBill += resultSet.getDouble("TRANSACTION_VALUE");
			}
			System.out.println("-------------------------------------------------");
			System.out.format("%-20s	%-40s \n", "Total Bill:", totalBill);
			System.out.println("-------------------------------------------------");
			System.out.println();
			
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
	}

	@Override
	public void transactionsBetweenTwoDates(int ssn, int day1, int month1, int year1, int day2, int month2, int year2) {
		try {
			this.prepareStatement = this.connection.prepareStatement(Queries.transactionsBetweenTwoDates);
			this.prepareStatement.setInt(1, ssn);
			
			String dateString1 = year1 + "-" + month1 + "-" + day1;
			String dateString2 = year2 + "-" + month2 + "-" + day2;
			
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString1);
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString2);
		
			java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime()); 
			java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
			
			this.prepareStatement.setDate(2, sqlDate1);
			this.prepareStatement.setDate(3, sqlDate2);
			
			this.resultSet = this.prepareStatement.executeQuery();
			
			System.out.println("List of Transactions For: ");
			System.out.println("Customer SSN - " + ssn);
			System.out.println("Between " + dateString1 + " and " + dateString2);
			
			System.out.println();
			System.out.format("%-14s | %-3s | %-5s | %-4s | %-18s | %-12s | %-11s | %-18s | %-18s \n"
							, "Transaction ID", "Day", "Month", "Year"
							, "Credit Card Number", "Customer SSN", "Branch Code"
							, "Transaction Type", "Transaction Value");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------");
			while (resultSet.next()) {
				System.out.format("%-14d | %-3d | %-5d | %-4d | %-18s | %-12d | %-11d | %-18s | %-18f \n"
						 		, resultSet.getInt("TRANSACTION_ID")
						 		, resultSet.getInt("DAY")
						 		, resultSet.getInt("MONTH")
						 		, resultSet.getInt("YEAR")
						 		, resultSet.getString("CREDIT_CARD_NO")
						 		, resultSet.getInt("CUST_SSN")
						 		, resultSet.getInt("BRANCH_CODE")
						 		, resultSet.getString("TRANSACTION_TYPE")
						 		, resultSet.getDouble("TRANSACTION_VALUE"));
			}
			System.out.println();
			
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		} catch (ParseException e) {
			System.out.println("Error: " + e);
		}
		
	}
	


}
