package Models;

public class Attedance {

    private int attendance_id;
    private int employee_id;
    private String month;
    private double no_of_days;
    private double no_of_ot;
    private double bonus;
    private double advance;
    private String date_time;

    public Attedance() {
    }

    public Attedance(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public Attedance(int attendance_id, int employee_id, String month, double no_of_days, double no_of_ot, double bonus, double advance, String date_time) {
        this.attendance_id = attendance_id;
        this.employee_id = employee_id;
        this.month = month;
        this.no_of_days = no_of_days;
        this.no_of_ot = no_of_ot;
        this.bonus = bonus;
        this.advance = advance;
        this.date_time = date_time;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
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
