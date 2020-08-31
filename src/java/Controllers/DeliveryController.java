package Controllers;

import Models.Delivery;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeliveryController {

    Connector con = Connector.getInstance();

    private DeliveryController() {
    }

    private static final DeliveryController obj = new DeliveryController();

    public static DeliveryController getInstance() {
        return obj;
    }

    public void Save(Delivery data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO delivery(invoice_id,address,status,driver_contact,date_time) values ('" + data.getInvoice_id() + "','" + data.getAddress() + "','" + data.getStatus() + "','" + data.getDriver_contact() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Delivery data) throws Exception {
        con.getConnection();
        con.aud("UPDATE delivery SET invoice_id  = '" + data.getInvoice_id() + "',address  = '" + data.getAddress() + "',status  = '" + data.getStatus() + "',driver_contact  = '" + data.getDriver_contact() + "',date_time  = '" + data.getDate_time() + "' WHERE delivery_id = '" + data.getDelivery_id() + "'");
    }

    public void Delete(Delivery data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM delivery WHERE delivery_id = '" + data.getDelivery_id() + "'");
    }

    public List<Delivery> SearchAll() throws Exception {
        List<Delivery> objList = new ArrayList<Delivery>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM delivery");
        while (rset.next()) {
            Delivery obj = new Delivery();
            obj.setDelivery_id(rset.getInt(1));
            obj.setInvoice_id(rset.getInt(2));
            obj.setAddress(rset.getString(3));
            obj.setStatus(rset.getString(4));
            obj.setDriver_contact(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<Delivery> Search(Delivery data) throws Exception {
        List<Delivery> objList = new ArrayList<Delivery>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM delivery WHERE delivery_id = '" + data.getDelivery_id() + "'");
        while (rset.next()) {
            Delivery obj = new Delivery();
            obj.setDelivery_id(rset.getInt(1));
            obj.setInvoice_id(rset.getInt(2));
            obj.setAddress(rset.getString(3));
            obj.setStatus(rset.getString(4));
            obj.setDriver_contact(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}
