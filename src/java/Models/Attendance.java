//Generated by 24HRS
package Models;

public class Attendance {

    private int attendance_id;
    private int emp_id;
    private String month;
    private double no_of_days;
    private double no_of_ot;
    private double advance;
    private String date_time;

    public Attendance() {
    }

    public Attendance(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public Attendance(int attendance_id, int emp_id, String month, double no_of_days, double no_of_ot, double advance, String date_time) {
        this.attendance_id = attendance_id;
        this.emp_id = emp_id;
        this.month = month;
        this.no_of_days = no_of_days;
        this.no_of_ot = no_of_ot;
        this.advance = advance;
        this.date_time = date_time;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(double no_of_days) {
        this.no_of_days = no_of_days;
    }

    public double getNo_of_ot() {
        return no_of_ot;
    }

    public void setNo_of_ot(double no_of_ot) {
        this.no_of_ot = no_of_ot;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
