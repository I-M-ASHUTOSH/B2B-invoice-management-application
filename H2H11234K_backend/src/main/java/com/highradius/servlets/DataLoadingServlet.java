package com.highradius.servlets;
//import com.highradius.connection.DatabaseConnection;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
//import com.google.gson.Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.model.*;


public class DataLoadingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private InvoiceDao invoiceDao=new InvoiceDaoImpl();
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
//		res.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		String requestOrigin = req.getHeader("Origin");
		
		res.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
	    res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
	    res.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
	    res.addHeader("Access-Control-Max-Age", "1728000");
	    
//		DatabaseConnection.connect();
		List<Invoice>list=new ArrayList<>();
		try {
		list=invoiceDao.getInvoice().subList(0, 1000);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.print(list.toString());
//		
		String json =new String();	
		Gson gson = new GsonBuilder().serializeNulls().create();
		json = gson.toJson(list);
	     
//	    System.out.println("he");
//	    
//	    System.out.print(json);
	     // Set response content type to JSON
		
	        res.setContentType("application/json");
	        res.setHeader("Access-Control-Allow-Origin", "*");
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().append(json);
	        
//	        
//	        res.getWriter().append("Done!");
	        
		
	}
	
	
	
	
//	List<Invoice> getInvoice () {
//		return invoiceDao.getInvoice();
//	}

}
