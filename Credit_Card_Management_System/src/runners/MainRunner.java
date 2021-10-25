package runners;

import dao.CreditCardTransactionDAO;
import dao.CustomerDAO;

import interfaces.CreditCardTransactionINTERFACE;
import interfaces.CustomerINTERFACE;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainRunner {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean continueMain = true;
		CreditCardTransactionINTERFACE creditcardINTERFACE = null;
		CustomerINTERFACE customerINTERFACE = null;
		
		while (continueMain) {
			System.out.println("------------------------------------");
			System.out.println("---------CDW_SAPP database----------");
			System.out.println("------------------------------------");
			System.out.println("1: Transaction Database");
			System.out.println("2: Customer Databse");
			System.out.println("3: Quit");
			System.out.println("------------------------------------");
			System.out.print("Select Option: ");
			String menuOption = input.next();
			
			boolean transactionMenu = false;
			boolean customerMenu = false;
			
			switch(menuOption) {
			case "1":
				System.out.println("------------------------------------");
				System.out.print("Enter Username: ");
				String usernameTransaction = input.next();
				System.out.print("Enter Password: ");
				String passwordTransaction = input.next();
				System.out.println("------------------------------------");
				System.out.println();
				
				try {
					creditcardINTERFACE = new CreditCardTransactionDAO(usernameTransaction, passwordTransaction);
					transactionMenu = true;
				} catch (SQLException e) {
					System.out.println("Error Connecting to Database: " + e + ", please make sure your username and password are correct.");
				} catch (ClassNotFoundException e) {
					System.out.println("Error Connecting to Database: " + e + ", please make sure your username and password are correct.");
				} catch (IllegalAccessException e) {
					System.out.println("Error Connecting to Database: " + e + ", please make sure your username and password are correct.");
				} catch (InstantiationException e) {
					System.out.println("Error Connecting to Database: " + e + ", please make sure your username and password are correct.");
				}
				
				break;	
			case "2":
				System.out.println("------------------------------------");
				System.out.print("Enter Username: ");
				String usernameCustomer= input.next();
				System.out.print("Enter Password: ");
				String passwordCustomer = input.next();
				System.out.println("------------------------------------");
				System.out.println();
				
				try {
					customerINTERFACE = new CustomerDAO(usernameCustomer, passwordCustomer);
					customerMenu = true;
				} catch (SQLException e) {
					System.out.println("Error Connecting to Database: " + e + ", please make sure your username and password are correct.");
				} catch (ClassNotFoundException e) {
					System.out.println("Error Connecting to Database: " + e + ", please make sure your username and password are correct.");
				} catch (IllegalAccessException e) {
					System.out.println("Error Connecting to Database: " + e + ", please make sure your username and password are correct.");
				} catch (InstantiationException e) {
					System.out.println("Error Connecting to Database: " + e + ", please make sure your username and password are correct.");
				}
				
				break;
			case "3":
				continueMain = false;
				System.out.println("Turning Off System...");
				break;
			default:
				System.out.println("------------------------------------");
				System.out.println("!!!Invalid Input: Please Enter 1, 2, or 3!!!");
				System.out.println("------------------------------------");
				break;
				
			}
		
			while (transactionMenu) {
				System.out.println("------------------------------------------------");
				System.out.println("----------CDW_SAPP/Tranasction database---------");
				System.out.println("------------------------------------------------");
				System.out.println("1: Display Transactions by Zip Code, Month, and Year");
				System.out.println("2: Display Transactions by Type");
				System.out.println("3: Display Transactions by State");
				System.out.println("4: Quit");
				System.out.println("------------------------------------------------");
				System.out.print("Select Option: ");
				String transactionOption = input.next();
				
				switch(transactionOption) {
				case "1":
					while(true) {
						try {
							System.out.println("------------------------------------------------");
							System.out.print("Enter Zip Code: ");
							int zipCode = input.nextInt();
							System.out.print("Enter Month: ");
							int month = input.nextInt();
							System.out.print("Enter Year: ");
							int year = input.nextInt();
							System.out.println("------------------------------------------------");
							System.out.println();
								
							creditcardINTERFACE.transactionsByZipMonthYear(zipCode, month, year);
							break;
						} catch (InputMismatchException e) {
							System.out.println("------------------------------------------------");
							System.out.println("!!!Invalid Input Error: Please Enter a Number!!!");
							input.next();
						}
					}

					break;	
				case "2":
					System.out.println("------------------------------------------------");
					System.out.print("Enter Transaction Type: ");
					String transactionType = input.next();
					System.out.println("------------------------------------------------");
					System.out.println();
					
					creditcardINTERFACE.numberAndTotalValueOfTransactionType(transactionType);
					break;
				case "3":
					System.out.println("------------------------------------------------");
					System.out.print("Enter State: ");
					String state = input.next();
					System.out.println("------------------------------------------------");
					System.out.println();
					
					creditcardINTERFACE.numberAndTotalValueOfBranchTransactions(state);
					break;
				case "4":
					System.out.println("Quiting Transaction Database System...");
					System.out.println();
					transactionMenu = false;
					creditcardINTERFACE.stopConnection();
					break;
				default:
					System.out.println();
					break;
					
				}
				
			}
			
			while (customerMenu) {
				System.out.println("----------------------------------------------------------");
				System.out.println("---------------CDW_SAPP/Customer database-----------------");
				System.out.println("----------------------------------------------------------");
				System.out.println("1: Display Customer Information by SSN");
				System.out.println("2: Modify an Existing Customer Account");
				System.out.println("3: Generate Monthly Bill for a Credit Card Number");
				System.out.println("4: Display Transactions made by Customer Between Two Dates");
				System.out.println("5: Quit");
				System.out.println("----------------------------------------------------------");
				System.out.print("Select Option: ");
				
				String customerOption = input.next();
				
				int SSN;
				switch(customerOption) {
				case "1":
					while (true) {
						try {
							System.out.println("----------------------------------------------------------");
							System.out.print("Enter Customer SSN: ");
							SSN = input.nextInt();
							System.out.println("----------------------------------------------------------");
							System.out.println();
								
							customerINTERFACE.displayCustomerInformation(SSN);
							System.out.println();
							break;
						} catch(InputMismatchException e) {
							System.out.println("----------------------------------------------------------");
							System.out.println("!!!Invalid Input Error: Please Enter a Number!!!");
							input.next();
						}
					}
					
					break;
				case "2":
					while (true) {
						try {
							System.out.println("----------------------------------------------------------");
							System.out.print("Enter Customer SSN: ");
							SSN = input.nextInt();
							System.out.println("----------------------------------------------------------");
							System.out.println();
								
							customerINTERFACE.displayCustomerInformation(SSN);
							System.out.println();
							break;
						} catch(InputMismatchException e) {
							System.out.println("----------------------------------------------------------");
							System.out.println("!!!Invalid Input Error: Please Enter a Number!!!");
							input.next();
						}
					}
					
					String fieldName = "";
					boolean continueLoop = true;
					
					while(continueLoop) {
						System.out.println("----------------------------------------------------------");
						System.out.println("Select Field Name ");
						System.out.println("----------------------------------------------------------");
						System.out.format("%-20s	%-20s	%-20s \n", "1)First Name", "2)Middle Name", "3)Last Name");
						System.out.format("%-20s	%-20s	%-20s \n", "4)Appartment Number", "5)Street Name", "6)Customer City"); 
						System.out.format("%-20s	%-20s	%-20s \n", "7)Customer State", "8)Customer Country", "9)Customer Zip");
						System.out.format("%-20s 	%-20s \n", "10)Customer Phone", "11)Customer Email"); 
						System.out.println("----------------------------------------------------------");
						System.out.print("Selection Number: ");
						String selection = input.next();
						
						switch(selection) {
						case "1":
							fieldName = "FIRST_NAME";
							break;
						case "2":
							fieldName = "MIDDLE_NAME";
							break;
						case "3":
							fieldName = "LAST_NAME";
							break;
						case "4":
							fieldName = "APT_NO";
							break;
						case "5":
							fieldName = "STREET_NAME";
							break;
						case "6":
							fieldName = "CUST_CITY";
							break;
						case "7":
							fieldName = "CUST_STATE";
							break;
						case "8":
							fieldName = "CUST_COUNTRY";
							break;
						case "9":
							fieldName = "CUST_ZIP";
							break;
						case "10":
							fieldName = "CUST_PHONE";
							break;
						case "11":
							fieldName = "CUST_EMAIL";
							break;
						default:
							System.out.println("----------------------------------------------------------");
							System.out.println("!!!Invalid Input: Please Enter A Number From 1 to 11!!!");
							System.out.println("----------------------------------------------------------");
							break;
						}
						
						if (!fieldName.equals("")) {
							continueLoop = false;
						}
						
					}
					input.nextLine();
					System.out.print("Enter New " + fieldName + ": ");
					String fieldValue = input.nextLine();
					System.out.println("----------------------------------------------------------");
					System.out.println();
					
					customerINTERFACE.updateCustomerInformation(SSN, fieldName, fieldValue);
					System.out.println();
					break;
				case "3":
					System.out.println("----------------------------------------------------------");
					System.out.print("Enter Credit Card Number: ");
					String creditCardNumber = input.next();
					
					while(true) {
						try {
							System.out.print("Enter Month: ");
							int month = input.nextInt();
							System.out.print("Enter Year: ");
							int year = input.nextInt();
							System.out.println("----------------------------------------------------------");
							System.out.println();
							
							customerINTERFACE.generateMonthlyBill(creditCardNumber, month, year);
							break;
						} catch (InputMismatchException e) {
							System.out.println("----------------------------------------------------------");
							System.out.println("!!!Invalid Input Error: Please Enter a Number!!!");
							System.out.println("----------------------------------------------------------");
							input.next();
						}
					}

					break;
				case "4":
					while(true) {
						try {
							System.out.println("----------------------------------------------------------");
							System.out.print("Enter Customer SSN: ");
							int ssn = input.nextInt();
							System.out.print("(1st Date) Enter Day: ");
							int day1 = input.nextInt();
							System.out.print("(1st Date) Enter Month: ");
							int month1 = input.nextInt();
							System.out.print("(1st Date) Enter Year: ");
							int year1 = input.nextInt();
							System.out.print("(2nd Date) Enter Day: ");
							int day2 = input.nextInt();
							System.out.print("(2nd Date) Enter Month: ");
							int month2 = input.nextInt();
							System.out.print("(2nd Date) Enter Year: ");
							int year2 = input.nextInt();
							System.out.println("----------------------------------------------------------");
							System.out.println();
							
							customerINTERFACE.transactionsBetweenTwoDates(ssn, day1, month1, year1, day2, month2, year2);
							break;
							
						} catch (InputMismatchException e) {
							System.out.println("----------------------------------------------------------");
							System.out.println("!!!Invalid Input Error: Please Enter a Number!!!");
							System.out.println("----------------------------------------------------------");
							input.next();
						}
					}
					
					break;
				case "5":
					System.out.println("Quiting Customer Database System...");
					System.out.println();
					customerMenu = false;
					
					customerINTERFACE.stopConnection();
					break;
				default:
					System.out.println();
					break;
					
				}

			}
		}
		
		input.close();
	}

}
