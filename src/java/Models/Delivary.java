//Generated by 24HRS
package Models;


public class Delivary{

	private int delivary_id;
	private int invoice_id;
	private int emp_id;
	private String address;
	private String cus_contact;
	private String status;
	private String date_time;

public Delivary(){
}

public Delivary(int delivary_id){
	this.delivary_id = delivary_id;
}
public Delivary(int delivary_id,int invoice_id,int emp_id,String address,String cus_contact,String status,String date_time){
	this.delivary_id = delivary_id;
	this.invoice_id = invoice_id;
	this.emp_id = emp_id;
	this.address = address;
	this.cus_contact = cus_contact;
	this.status = status;
	this.date_time = date_time;
}

public int getDelivary_id(){
return delivary_id;
}

public void setDelivary_id(int delivary_id){
	this.delivary_id = delivary_id;
}

public int getInvoice_id(){
return invoice_id;
}

public void setInvoice_id(int invoice_id){
	this.invoice_id = invoice_id;
}

public int getEmp_id(){
return emp_id;
}

public void setEmp_id(int emp_id){
	this.emp_id = emp_id;
}

public String getAddress(){
return address;
}

public void setAddress(String address){
	this.address = address;
}

public String getCus_contact(){
return cus_contact;
}

public void setCus_contact(String cus_contact){
	this.cus_contact = cus_contact;
}

public String getStatus(){
return status;
}

public void setStatus(String status){
	this.status = status;
}

public String getDate_time(){
return date_time;
}

public void setDate_time(String date_time){
	this.date_time = date_time;
}

}