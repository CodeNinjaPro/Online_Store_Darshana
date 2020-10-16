package Controllers;

import Models.Employee;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

    Connector con = Connector.getInstance();

    private EmployeeController() {
    }

    private static final EmployeeController obj = new EmployeeController();

    public static EmployeeController getInstance() {
        return obj;
    }

    public void Save(Employee data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO employee(full_name,address,email,contact_number,designation,date_time) values ('" + data.getFull_name() + "','" + data.getAddress() + "','" + data.getEmail() + "','" + data.getContact_number() + "','" + data.getDesignation() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Employee data) throws Exception {
        con.getConnection();
        con.aud("UPDATE employee SET full_name  = '" + data.getFull_name() + "',address  = '" + data.getAddress() + "',email  = '" + data.getEmail() + "',contact_number  = '" + data.getContact_number() + "',designation  = '" + data.getDesignation() + "',date_time  = '" + data.getDate_time() + "' WHERE emp_id = '" + data.getEmp_id() + "'");
    }

    public void Delete(Employee data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM employee WHERE emp_id = '" + data.getEmp_id() + "'");
    }

    public List<Employee> SearchAll() throws Exception {
        List<Employee> objList = new ArrayList<Employee>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM employee");
        while (rset.next()) {
            Employee obj = new Employee();
            obj.setEmp_id(rset.getInt(1));
            obj.setFull_name(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setEmail(rset.getString(4));
            obj.setContact_number(rset.getString(5));
            obj.setDesignation(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Employee> Search(Employee data) throws Exception {
        List<Employee> objList = new ArrayList<Employee>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM employee WHERE emp_id = '" + data.getEmp_id() + "'");
        while (rset.next()) {
            Employee obj = new Employee();
            obj.setEmp_id(rset.getInt(1));
            obj.setFull_name(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setEmail(rset.getString(4));
            obj.setContact_number(rset.getString(5));
            obj.setDesignation(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public String getUserFullName(int user_id) throws Exception {
        String name = "";

        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM employee WHERE emp_id = '" + user_id + "'");
        if (rset.next()) {
            name = rset.getString(2);
        }

        return name;
    }

}
