//Generated by 24HRS
package Models;


public class Salary_shedule{

	private int salary_shedule_id;
	private int emp_id;
	private double basic_salary;
	private double ot_rate;
	private double bonus;
	private String date_time;

public Salary_shedule(){
}

public Salary_shedule(int salary_shedule_id){
	this.salary_shedule_id = salary_shedule_id;
}
public Salary_shedule(int salary_shedule_id,int emp_id,double basic_salary,double ot_rate,double bonus,String date_time){
	this.salary_shedule_id = salary_shedule_id;
	this.emp_id = emp_id;
	this.basic_salary = basic_salary;
	this.ot_rate = ot_rate;
	this.bonus = bonus;
	this.date_time = date_time;
}

public int getSalary_shedule_id(){
return salary_shedule_id;
}

public void setSalary_shedule_id(int salary_shedule_id){
	this.salary_shedule_id = salary_shedule_id;
}

public int getEmp_id(){
return emp_id;
}

public void setEmp_id(int emp_id){
	this.emp_id = emp_id;
}

public double getBasic_salary(){
return basic_salary;
}

public void setBasic_salary(double basic_salary){
	this.basic_salary = basic_salary;
}

public double getOt_rate(){
return ot_rate;
}

public void setOt_rate(double ot_rate){
	this.ot_rate = ot_rate;
}

public double getBonus(){
return bonus;
}

public void setBonus(double bonus){
	this.bonus = bonus;
}

public String getDate_time(){
return date_time;
}

public void setDate_time(String date_time){
	this.date_time = date_time;
}

}