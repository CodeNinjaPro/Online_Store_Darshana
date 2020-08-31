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
        con.aud("INSERT INTO employee(name,address,designation,contact,email,basic_salary,ot_rate,date_time) values ('" + data.getName() + "','" + data.getAddress() + "','" + data.getDesignation() + "','" + data.getContact() + "','" + data.getEmail() + "','" + data.getBasic_salary() + "','" + data.getOt_rate() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Employee data) throws Exception {
        con.getConnection();
        con.aud("UPDATE employee SET name  = '" + data.getName() + "',address  = '" + data.getAddress() + "',designation  = '" + data.getDesignation() + "',contact  = '" + data.getContact() + "',email  = '" + data.getEmail() + "',basic_salary  = '" + data.getBasic_salary() + "',ot_rate  = '" + data.getOt_rate() + "',date_time  = '" + data.getDate_time() + "' WHERE employee_id = '" + data.getEmployee_id() + "'");
    }

    public void Delete(Employee data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM employee WHERE employee_id = '" + data.getEmployee_id() + "'");
    }

    public List<Employee> SearchAll() throws Exception {
        List<Employee> objList = new ArrayList<Employee>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM employee");
        while (rset.next()) {
            Employee obj = new Employee();
            obj.setEmployee_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setDesignation(rset.getString(4));
            obj.setContact(rset.getString(5));
            obj.setEmail(rset.getString(6));
            obj.setBasic_salary(rset.getDouble(7));
            obj.setOt_rate(rset.getDouble(8));
            obj.setDate_time(rset.getString(9));
            objList.add(obj);
        }

        return objList;
    }

    public List<Employee> Search(Employee data) throws Exception {
        List<Employee> objList = new ArrayList<Employee>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM employee WHERE employee_id = '" + data.getEmployee_id() + "'");
        while (rset.next()) {
            Employee obj = new Employee();
            obj.setEmployee_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setDesignation(rset.getString(4));
            obj.setContact(rset.getString(5));
            obj.setEmail(rset.getString(6));
            obj.setBasic_salary(rset.getDouble(7));
            obj.setOt_rate(rset.getDouble(8));
            obj.setDate_time(rset.getString(9));
            objList.add(obj);
        }

        return objList;
    }

}
