package Controllers;

import Models.Invoice_details;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Invoice_detailsController {

    Connector con = Connector.getInstance();

    private Invoice_detailsController() {
    }

    private static final Invoice_detailsController obj = new Invoice_detailsController();

    public static Invoice_detailsController getInstance() {
        return obj;
    }

    public void Save(Invoice_details data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO invoice_details(invoice_id,stock_id,qty,date_time) values ('" + data.getInvoice_id() + "','" + data.getStock_id() + "','" + data.getQty() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Invoice_details data) throws Exception {
        con.getConnection();
        con.aud("UPDATE invoice_details SET invoice_id  = '" + data.getInvoice_id() + "',stock_id  = '" + data.getStock_id() + "',qty  = '" + data.getQty() + "',date_time  = '" + data.getDate_time() + "' WHERE invoice_details_id = '" + data.getInvoice_details_id() + "'");
    }

    public void Delete(Invoice_details data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM invoice_details WHERE invoice_details_id = '" + data.getInvoice_details_id() + "'");
    }

    public List<Invoice_details> SearchAll() throws Exception {
        List<Invoice_details> objList = new ArrayList<Invoice_details>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM invoice_details");
        while (rset.next()) {
            Invoice_details obj = new Invoice_details();
            obj.setInvoice_details_id(rset.getInt(1));
            obj.setInvoice_id(rset.getInt(2));
            obj.setStock_id(rset.getInt(3));
            obj.setQty(rset.getInt(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

    public List<Invoice_details> Search(Invoice_details data) throws Exception {
        List<Invoice_details> objList = new ArrayList<Invoice_details>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM invoice_details WHERE invoice_details_id = '" + data.getInvoice_details_id() + "'");
        while (rset.next()) {
            Invoice_details obj = new Invoice_details();
            obj.setInvoice_details_id(rset.getInt(1));
            obj.setInvoice_id(rset.getInt(2));
            obj.setStock_id(rset.getInt(3));
            obj.setQty(rset.getInt(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

}
