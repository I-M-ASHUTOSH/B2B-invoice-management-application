package com.highradius.model;

import com.highradius.connection.DatabaseConnection;

public class Invoice {
	private int sl_no;
    private int customer_order_id;
    private int sales_org;
    private String distribution_channel;
    private String division;
    private double released_credit_value;
    private String purchase_order_type;
    private int company_code;
    private String order_creation_date;
    private String order_creation_time;
    private String credit_control_area;
    private int sold_to_party;
    private double order_amount;
    private String requested_delivery_date;
    private String order_currency;
    private String credit_status;
    private int customer_number;
    private double amount_in_usd;
    private long unique_cust_id;
    
	public  Invoice(int sl_no,int customer_order_id,int sales_org,String distribution_channel,String division,double released_credit_value,
			String purchase_order_type,int company_code,String order_creation_date,String order_creation_time,String credit_control_area,
			int sold_to_party,double order_amount,String requested_delivery_date,
            String order_currency,String credit_status,int customer_number,double amount_in_usd,long unique_cust_id)
	{
		this.sl_no=sl_no;
		this.customer_order_id=customer_order_id;
		this.sales_org=sales_org;
		this.distribution_channel=distribution_channel;
		this.division=division;
		this.released_credit_value=released_credit_value;
		this.purchase_order_type=purchase_order_type;
		this.company_code=company_code;
		this.order_creation_date=order_creation_date;
		this.order_creation_time=order_creation_time;
		this.credit_control_area=credit_control_area;
		this.sold_to_party=sold_to_party;
		this.order_amount=order_amount;
		this.requested_delivery_date=requested_delivery_date;
		this.order_currency=order_currency;
		this.credit_status=credit_status;
		this.customer_number=customer_number;
		this.amount_in_usd=amount_in_usd;
		this.unique_cust_id=unique_cust_id;
	}

    public Invoice(int cust_id, int sales_org, String distribution_channel, int company_code,double order_amount,
			String order_creation_date, String order_currency, int customer_number)  {
    	
//		DatabaseConnection.connect();
		this.sl_no=DatabaseConnection.invoice_list.size()+1;
		this.customer_order_id=cust_id;
		this.sales_org=sales_org;
		this.distribution_channel=distribution_channel;
		this.division="";
		this.released_credit_value=0;
		this.purchase_order_type="";
		this.company_code=company_code;
		this.order_creation_date=order_creation_date;
		this.order_creation_time="";
		this.credit_control_area="";
		this.sold_to_party=0;
		this.order_amount=order_amount;
		this.requested_delivery_date="";
		this.order_currency=order_currency;
		this.credit_status="";
		this.customer_number=customer_number;
		
		
		if(order_currency.equals("USD"))this.amount_in_usd=order_amount*1;
		else if(order_currency.equals("EUR"))this.amount_in_usd=order_amount*1.08;
			else if(order_currency.equals("AUD"))this.amount_in_usd=order_amount*0.65;
				else if(order_currency.equals("CAD"))this.amount_in_usd=order_amount*0.74;
					else if(order_currency.equals("GBP"))this.amount_in_usd=order_amount*1.24;
						else if(order_currency.equals("MYR"))this.amount_in_usd=order_amount*0.22;
							else if(order_currency.equals("PLN"))this.amount_in_usd=order_amount*0.24;
								else if(order_currency.equals("AED"))this.amount_in_usd=order_amount*0.27;
									else if(order_currency.equals("HKD"))this.amount_in_usd=order_amount*0.13;
										else if(order_currency.equals("CHF"))this.amount_in_usd=order_amount*1.11;
											else if(order_currency.equals("RON"))this.amount_in_usd=order_amount*0.22;
												else if(order_currency.equals("SGD"))this.amount_in_usd=order_amount*0.74;
													else if(order_currency.equals("CZK"))this.amount_in_usd=order_amount*0.045;
														else if(order_currency.equals("HU1"))this.amount_in_usd=order_amount*0.0029;
															else if(order_currency.equals("NZD"))this.amount_in_usd=order_amount*0.61;
																else if(order_currency.equals("BHD"))this.amount_in_usd=order_amount*2.65;
																	else if(order_currency.equals("SAR"))this.amount_in_usd=order_amount*0.27;
																		else if(order_currency.equals("QAR"))this.amount_in_usd=order_amount*0.27;
																			else if(order_currency.equals("KWD"))this.amount_in_usd=order_amount*3.25;
																				else if(order_currency.equals("SEK")) this.amount_in_usd=order_amount*0.094;
																							
//		this.amount_in_usd=amount_in_usd;
	
		this.unique_cust_id=Long.parseLong(Integer.toString(customer_number)+Integer.toString(company_code));
		System.out.println(order_currency);
		System.out.println(customer_order_id+" "+sales_org+" "+order_amount+" "+amount_in_usd);
		
		
	}
	
	

//    public Invoice(int cust_id, int sales_org2, String distribution_channel2, int company_code2,
//			String order_creation_date2, String order_currency2, int customer_number2, double amount_in_usd2) {
//		// TODO Auto-generated constructor stub
//	}
	public int getSl_no() {
        return sl_no;
    }

    public void setSl_no(int sl_no) {
        this.sl_no = sl_no;
    }

    public int getCustomer_order_id() {
        return customer_order_id;
    }

    public void setCustomer_order_id(int customer_order_id) {
        this.customer_order_id = customer_order_id;
    }

    public int getSales_org() {
        return sales_org;
    }

    public void setSales_org(int sales_org) {
        this.sales_org = sales_org;
    }

    public String getDistribution_channel() {
        return distribution_channel;
    }

    public void setDistribution_channel(String distribution_channel) {
        this.distribution_channel = distribution_channel;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public double getReleased_credit_value() {
        return released_credit_value;
    }

    public void setReleased_credit_value(double released_credit_value) {
        this.released_credit_value = released_credit_value;
    }

    public String getPurchase_order_type() {
        return purchase_order_type;
    }

    public void setPurchase_order_type(String purchase_order_type) {
        this.purchase_order_type = purchase_order_type;
    }

    public int getCompany_code() {
        return company_code;
    }

    public void setCompany_code(int company_code) {
        this.company_code = company_code;
    }

    public String getOrder_creation_date() {
        return order_creation_date;
    }

    public void setOrder_creation_date(String order_creation_date) {
        this.order_creation_date = order_creation_date;
    }

    public String getOrder_creation_time() {
        return order_creation_time;
    }

    public void setOrder_creation_time(String order_creation_time) {
        this.order_creation_time = order_creation_time;
    }

    public String getCredit_control_area() {
        return credit_control_area;
    }

    public void setCredit_control_area(String credit_control_area) {
        this.credit_control_area = credit_control_area;
    }

    public int getSold_to_party() {
        return sold_to_party;
    }

    public void setSold_to_party(int sold_to_party) {
        this.sold_to_party = sold_to_party;
    }

    public double getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(double order_amount) {
        this.order_amount = order_amount;
    }

    public String getRequested_delivery_date() {
        return requested_delivery_date;
    }

    public void setRequested_delivery_date(String requested_delivery_date) {
        this.requested_delivery_date = requested_delivery_date;
    }

    public String getOrder_currency() {
        return order_currency;
    }

    public void setOrder_currency(String order_currency) {
        this.order_currency = order_currency;
    }

    public String getCredit_status() {
        return credit_status;
    }

    public void setCredit_status(String credit_status) {
        this.credit_status = credit_status;
    }

    public int getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(int customer_number) {
        this.customer_number = customer_number;
    }

    public double getAmount_in_usd() {
        return amount_in_usd;
    }

    public void setAmount_in_usd(double amount_in_usd) {
        this.amount_in_usd = amount_in_usd;
    }

    public long getUnique_cust_id() {
        return unique_cust_id;
    }

    public void setUnique_cust_id(long unique_cust_id) {
        this.unique_cust_id = unique_cust_id;
    }
	
	

}
