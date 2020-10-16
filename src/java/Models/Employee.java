//Generated by 24HRS
package Models;


public class Employee{

	private int emp_id;
	private String full_name;
	private String address;
	private String email;
	private String contact_number;
	private String designation;
	private String date_time;

public Employee(){
}

public Employee(int emp_id){
	this.emp_id = emp_id;
}
public Employee(int emp_id,String full_name,String address,String email,String contact_number,String designation,String date_time){
	this.emp_id = emp_id;
	this.full_name = full_name;
	this.address = address;
	this.email = email;
	this.contact_number = contact_number;
	this.designation = designation;
	this.date_time = date_time;
}

public int getEmp_id(){
return emp_id;
}

public void setEmp_id(int emp_id){
	this.emp_id = emp_id;
}

public String getFull_name(){
return full_name;
}

public void setFull_name(String full_name){
	this.full_name = full_name;
}

public String getAddress(){
return address;
}

public void setAddress(String address){
	this.address = address;
}

public String getEmail(){
return email;
}

public void setEmail(String email){
	this.email = email;
}

public String getContact_number(){
return contact_number;
}

public void setContact_number(String contact_number){
	this.contact_number = contact_number;
}

public String getDesignation(){
return designation;
}

public void setDesignation(String designation){
	this.designation = designation;
}

public String getDate_time(){
return date_time;
}

public void setDate_time(String date_time){
	this.date_time = date_time;
}

}