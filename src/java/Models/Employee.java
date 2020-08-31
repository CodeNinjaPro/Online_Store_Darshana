package Models;

public class Employee {

    private int employee_id;
    private String name;
    private String address;
    private String designation;
    private String contact;
    private String email;
    private double basic_salary;
    private double ot_rate;
    private String date_time;

    public Employee() {
    }

    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }

    public Employee(int employee_id, String name, String address, String designation, String contact, String email, double basic_salary, double ot_rate, String date_time) {
        this.employee_id = employee_id;
        this.name = name;
        this.address = address;
        this.designation = designation;
        this.contact = contact;
        this.email = email;
        this.basic_salary = basic_salary;
        this.ot_rate = ot_rate;
        this.date_time = date_time;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }

    public double getOt_rate() {
        return ot_rate;
    }

    public void setOt_rate(double ot_rate) {
        this.ot_rate = ot_rate;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
