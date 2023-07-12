package com.highradius.implementation;
import com.highradius.connection.*;
import java.util.*;
import com.highradius.model.*;

import java.sql.*;
public class InvoiceDaoImpl implements InvoiceDao {

//	private DatabaseConnection dc=new DatabaseConnection();
	
	
	private static final  String sqlQuery = "INSERT INTO hrc.h2h_oap" + "  (CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, DIVISION, RELEASED_CREDIT_VALUE, PURCHASE_ORDER_TYPE, COMPANY_CODE, ORDER_CREATION_DATE, ORDER_CREATION_TIME, CREDIT_CONTROL_AREA, SOLD_TO_PARTY, ORDER_AMOUNT, REQUESTED_DELIVERY_DATE, ORDER_CURRENCY, CREDIT_STATUS, CUSTOMER_NUMBER, AMOUNT_IN_USD, UNIQUE_CUST_ID) VALUES "
  			+ " ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";

	private static final String SELECT_INVOICE_BY_ID = "select invoiceNumber, salesOrg, distributionChannel, division, releasedCreditValue, purchaseOrderType, companyCode, orderCreationDate, orderCreationTime, creditControlArea, soldToParty, orderAmount, requestedDeliveryDate, orderCurrency, creditStatus, customerNumber, amountInUSD, uniqueCustID from hrc.h2h_oap where id =?";

	private static final String SELECT_ALL_INVOICES = "select invoiceNumber, salesOrg, distributionChannel, division, releasedCreditValue, purchaseOrderType, companyCode, orderCreationDate, orderCreationTime, creditControlArea, soldToParty, orderAmount, requestedDeliveryDate, orderCurrency, creditStatus, customerNumber, amountInUSD, uniqueCustID from hrc.h2h_oap";

	private static final String DELETE_INVOICES_SQL = "delete from hrc.h2h_oap where Sl_no = ?;";
	
	private static final String UPDATE_INVOICS_SQL = "update hrc.h2h_oap set DISTRIBUTION_CHANNEL = ?, COMPANY_CODE = ?, ORDER_CURRENCY = ?  where Sl_no = ?;";

//		public static void main(String[] args) {
////			InvoiceDao invoiceDao = new InvoiceDaoImpl();
////			invoiceDao.insertInvoice(new Invoice(1048576,12,12,"asa","asafa",12.31,"adf",12,"as","as","3",12,124,"fa","adf","afs",441,14,1422));
//		
//			InvoiceDaoImpl i2=new InvoiceDaoImpl();
//			System.out.println("jeff");
//			List<Invoice>ls=i2.getInvoice();
//			System.out.print(ls.toString());
//		}
	
	public void insertInvoice (Invoice invoice) throws ClassNotFoundException  {
//		 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrc", "root", "Ashu@3255");
				Connection connection= DatabaseConnection.connect();
				try {
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//				DatabaseConnection.getInvoices();
//				preparedStatement.setInt(1, DatabaseConnection.invoice_list.size()+1);
	            preparedStatement.setInt(1, invoice.getCustomer_order_id());
	            preparedStatement.setInt(2, invoice.getSales_org());
	            preparedStatement.setString(3, invoice.getDistribution_channel());
	            preparedStatement.setString(4, invoice.getDivision());
	            preparedStatement.setDouble(5, invoice.getReleased_credit_value());
	            preparedStatement.setString(6, invoice.getPurchase_order_type());
	            preparedStatement.setInt(7, invoice.getCompany_code());
	            preparedStatement.setString(8, invoice.getOrder_creation_date());
	            preparedStatement.setString(9, invoice.getOrder_creation_time());
	            preparedStatement.setString(10, invoice.getCredit_control_area());
	            preparedStatement.setInt(11, invoice.getSold_to_party());
	            preparedStatement.setDouble(12, invoice.getOrder_amount());
	            preparedStatement.setString(13, invoice.getRequested_delivery_date());
	            preparedStatement.setString(14, invoice.getOrder_currency());
	            preparedStatement.setString(15, invoice.getCredit_status());
	            preparedStatement.setInt(16, invoice.getCustomer_number());
	            preparedStatement.setDouble(17, invoice.getAmount_in_usd());
	            preparedStatement.setLong(18, invoice.getUnique_cust_id());

	            preparedStatement.executeUpdate();
	        }
	        catch (SQLException e) {
	        	e.printStackTrace();
	        }	
	}
	
	public List<Invoice> getInvoice () throws SQLException, ClassNotFoundException {
//		System.out.print(dc.getInvoices().toString());
		Connection connection= DatabaseConnection.connect();
		return  DatabaseConnection.invoice_list;
		
	}
	
	public void updateInvoice(int Sl_no,String distribution_channel,int company_code,String order_currency) throws SQLException, ClassNotFoundException{
//		List<Invoice>ls=DatabaseConnection.invoice_list;
		Connection connection= DatabaseConnection.connect();
		try {
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_INVOICS_SQL);
	 	
		
        preparedStatement.setString(1, distribution_channel);
        preparedStatement.setInt(2, company_code);
        preparedStatement.setString(3, order_currency);
        preparedStatement.setInt(4, Sl_no);
        
        preparedStatement.executeUpdate();
    }
    catch (SQLException e) {
    	e.printStackTrace();
    }	
		
		
	}
	
	
	public void deleteInvoice(long Sl_no) throws SQLException, ClassNotFoundException {
		
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrc", "root", "Ashu@3255");
//				PreparedStatement statement = connection.prepareStatement(DELETE_INVOICES_SQL);) {
//			statement.setLong(1, cust_id);
//			statement.executeUpdate();
//			
			try {
				Connection connection= DatabaseConnection.connect();
				PreparedStatement statement = connection.prepareStatement(DELETE_INVOICES_SQL);
					statement.setLong(1, Sl_no);
					statement.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
			
	}
		
		
	
	
	
}
