package com.highradius.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.*;
import com.google.gson.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.*;
import com.highradius.model.*;


public class AddServlet extends HttpServlet{
	 private InvoiceDao invoiceDao;

	    public void init() {    
	        invoiceDao = new InvoiceDaoImpl();
	    }
	    
	    public AddServlet() {
	    	super();
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
//		int sl_no=Integer.parseInt(req.getParameter("Sl_no"));
//    	  int cust_id= (int)Integer.parseInt(req.getParameter("cust_id"));
//    	  int sales_org=(int)Integer.parseInt(req.getParameter("sales_org"));
//          String distribution_channel =(String)req.getParameter("distribution_channel");
//////        String division = req.getParameter("division");
//////        double released_credit_value=Double.parseDouble(req.getParameter("released_credit_value"));
//////        String purchase_order_type= req.getParameter("purchase_order_type");
//          int company_code= (int)Integer.parseInt(req.getParameter("company_code"));
//          String order_creation_date=(String) req.getParameter("order_creation_date");
////        String order_creation_time= req.getParameter("order_creation_time");
//////        String credit_control_area= req.getParameter("credit_control_area");
//////        int sold_to_party= Integer.parseInt(req.getParameter("sold_to_party"));
//          double order_amount=(double)Double.parseDouble(req.getParameter("order_amount"));
////        String requested_delivery_date= req.getParameter("requested_delivery_date");
//          String order_currency= req.getParameter("order_currency");
//////        String credit_status= req.getParameter("credit_status");
//          int customer_number=(int) Integer.parseInt(req.getParameter("customer_number"));
//////          double amount_in_usd=Double.parseDouble(req.getParameter("amount_in_usd"));
//////        long unique_cust_id=Long.parseLong(req.getParameter("unique_cust_id"));
//		
		res.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST,OPTIONS,HEAD,PUT,GET");
        res.setHeader("Access-Control-Allow-Headers", "*");

        Gson gson = new Gson();
        Invoice invoice =null;
        StringBuffer requestBody = new StringBuffer();
        BufferedReader reader = req.getReader();
        String line = null;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        invoice = gson.fromJson(requestBody.toString(), Invoice.class);
        
        
//        String message = "Invoice data added successfully!";
//        
        // Set response content type to plain text
        res.setContentType("text/plain");
//        
        // Send response back to the client
        PrintWriter out = res.getWriter();
//        out.println(message);
        
//        
//        
//       out.println(cust_id+" "+sales_org+" "+distribution_channel+" "+company_code+" "+order_amount
//    		   +" "+order_creation_date+" "+order_currency+" "+customer_number);
//       
//        out.println(cust_id);
//        
//        Invoice invoice = new Invoice (cust_id, sales_org, distribution_channel, company_code,order_amount,
//    			order_creation_date, order_currency, customer_number);
//        
        
//       Invoice invoice =new Invoice(cust_id,sales_org,distribution_channel,company_code,order_amount, order_creation_date, order_currency, customer_number);
        
        
        
        try{
//        addInvoice(invoice); 
        	invoiceDao.insertInvoice(invoice);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally{
            res.getWriter().append("Added");
        }
        
//        Convert invoices to JSON using Gson library
//        Gson gson = new Gson();
//        String json = gson.toJson(invoice);

        // Set response content type to JSON
//        res.setContentType("application/json");  
//        out.close();
	}
	
//	
//	public  static void addInvoice (Invoice i) throws SQLException{
//		invoiceDao.insertInvoice(i); 
//	}
	
}
