package resources;

public class Queries {
	
	//Queries for the Transaction Module

	public static String transactions = 
		("SELECT "
		+ 	"cdw_sapp_creditcard.* "
		+ "FROM "
		+ 	"cdw_sapp_creditcard "
		+ "LEFT JOIN "
		+ 	"cdw_sapp_customer ON cdw_sapp_customer.ssn = cdw_sapp_creditcard.cust_ssn "
		+ "WHERE "
		+ 	"cust_zip = ? AND "
		+ 	"month = ? AND "
		+ 	"year = ?;");
	
	public static String numberAndTotalValueOfTransactionType = 
		("SELECT "
		+ 	"COUNT(*) AS 'Number of Transactions', "
		+ 	"SUM(transaction_value) AS 'Total Value' "
		+ "FROM "
		+	"cdw_sapp_creditcard "
		+ "GROUP BY "
		+ 	"transaction_type "
		+ "HAVING "
		+	"transaction_type = ?;");
	
	public static String allTransactionsOfType = 
		("SELECT "
		+ 	"* "
		+ "FROM "
		+	"cdw_sapp_creditcard "
		+ "WHERE "
		+	"transaction_type = ?;");
	
	public static String numberAndTotalValueOfBranchTransactions = 
		("SELECT "
		+ 	"cdw_sapp_creditcard.branch_code AS 'Branch Code', "
		+ 	"COUNT(*) AS 'Number of Transactions', "
		+ 	"SUM(transaction_value) AS 'Total Value' "
		+ "FROM "
		+ 	"cdw_sapp_creditcard "
		+ "LEFT JOIN "
		+ 	"cdw_sapp_branch ON cdw_sapp_branch.branch_code = cdw_sapp_creditcard.branch_code "
		+ "WHERE "
		+	"cdw_sapp_branch.branch_state = ? "
		+ "GROUP BY "
		+ 	"cdw_sapp_creditcard.branch_code;");
	
	
	public static String allTransactionsFromState = 
		("SELECT "
		+ 	"cdw_sapp_creditcard.*"
		+ "FROM "
		+ 	"cdw_sapp_creditcard "
		+ "LEFT JOIN "
		+ 	"cdw_sapp_branch ON cdw_sapp_branch.branch_code = cdw_sapp_creditcard.branch_code "
		+ "WHERE "
		+	"cdw_sapp_branch.branch_state = ?;");
	
	//Queries for the Customer Module
	public static String displayCustomerSSN = 
		("SELECT "
		+ 	"* "
		+ "FROM "
		+ 	"cdw_sapp_customer "
		+ "WHERE "
		+ "	SSN = ?");
	public static String monthlyBill = 
		("SELECT "
		+ 	"* "
		+ "FROM "
		+ 	"cdw_sapp_creditcard "
		+ "WHERE "
		+ 	"MONTH = ? AND YEAR = ? AND CREDIT_CARD_NO = ?");
	public static String transactionsBetweenTwoDates = 
		("SELECT " 
		+  "* " 
		+ "FROM "  
		+  "cdw_sapp_creditcard "
		+ "WHERE "  
		+ 	"CUST_SSN = ? AND "
		+ 	"CAST(CONCAT(YEAR,\"-\",MONTH,\"-\", DAY) AS DATE) BETWEEN ? AND ? " 
		+ "ORDER BY "  
		+ 	"YEAR DESC, "  
		+ 	"MONTH DESC, "  
		+ 	"DAY DESC; ");
	
	public static String updateCustomerTable(String fieldName) {
		return 
		("UPDATE cdw_sapp_customer SET " 
		+ fieldName + " = ?" 
		+ ", LAST_UPDATED = ? WHERE SSN = ?");
	}
	

}
