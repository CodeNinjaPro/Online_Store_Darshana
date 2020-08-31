package Controllers;

import Models.Attedance;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttedanceController {

    Connector con = Connector.getInstance();

    private AttedanceController() {
    }

    private static final AttedanceController obj = new AttedanceController();

    public static AttedanceController getInstance() {
        return obj;
    }

    public void Save(Attedance data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO attedance(employee_id,month,no_of_days,no_of_ot,bonus,advance,date_time) values ('" + data.getEmployee_id() + "','" + data.getMonth() + "','" + data.getNo_of_days() + "','" + data.getNo_of_ot() + "','" + data.getBonus() + "','" + data.getAdvance() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Attedance data) throws Exception {
        con.getConnection();
        con.aud("UPDATE attedance SET employee_id  = '" + data.getEmployee_id() + "',month  = '" + data.getMonth() + "',no_of_days  = '" + data.getNo_of_days() + "',no_of_ot  = '" + data.getNo_of_ot() + "',bonus  = '" + data.getBonus() + "',advance  = '" + data.getAdvance() + "',date_time  = '" + data.getDate_time() + "' WHERE attendance_id = '" + data.getAttendance_id() + "'");
    }

    public void Delete(Attedance data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM attedance WHERE attendance_id = '" + data.getAttendance_id() + "'");
    }

    public List<Attedance> SearchAll() throws Exception {
        List<Attedance> objList = new ArrayList<Attedance>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM attedance");
        while (rset.next()) {
            Attedance obj = new Attedance();
            obj.setAttendance_id(rset.getInt(1));
            obj.setEmployee_id(rset.getInt(2));
            obj.setMonth(rset.getString(3));
            obj.setNo_of_days(rset.getDouble(4));
            obj.setNo_of_ot(rset.getDouble(5));
            obj.setBonus(rset.getDouble(6));
            obj.setAdvance(rset.getDouble(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

    public List<Attedance> Search(Attedance data) throws Exception {
        List<Attedance> objList = new ArrayList<Attedance>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM attedance WHERE attendance_id = '" + data.getAttendance_id() + "'");
        while (rset.next()) {
            Attedance obj = new Attedance();
            obj.setAttendance_id(rset.getInt(1));
            obj.setEmployee_id(rset.getInt(2));
            obj.setMonth(rset.getString(3));
            obj.setNo_of_days(rset.getDouble(4));
            obj.setNo_of_ot(rset.getDouble(5));
            obj.setBonus(rset.getDouble(6));
            obj.setAdvance(rset.getDouble(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

}
