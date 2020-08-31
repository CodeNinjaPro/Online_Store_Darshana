package Controllers;

import Models.Stock;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StockController {

    Connector con = Connector.getInstance();

    private StockController() {
    }

    private static final StockController obj = new StockController();

    public static StockController getInstance() {
        return obj;
    }

    public void Save(Stock data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO stock(name,description,category,qty,unit_price,date_time) values ('" + data.getName() + "','" + data.getDescription() + "','" + data.getCategory() + "','" + data.getQty() + "','" + data.getUnit_price() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Stock data) throws Exception {
        con.getConnection();
        con.aud("UPDATE stock SET name  = '" + data.getName() + "',description  = '" + data.getDescription() + "',category  = '" + data.getCategory() + "',qty  = '" + data.getQty() + "',unit_price  = '" + data.getUnit_price() + "',date_time  = '" + data.getDate_time() + "' WHERE stock_id = '" + data.getStock_id() + "'");
    }

    public void Delete(Stock data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM stock WHERE stock_id = '" + data.getStock_id() + "'");
    }

    public List<Stock> SearchAll() throws Exception {
        List<Stock> objList = new ArrayList<Stock>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM stock");
        while (rset.next()) {
            Stock obj = new Stock();
            obj.setStock_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setDescription(rset.getString(3));
            obj.setCategory(rset.getString(4));
            obj.setQty(rset.getInt(5));
            obj.setUnit_price(rset.getDouble(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Stock> Search(Stock data) throws Exception {
        List<Stock> objList = new ArrayList<Stock>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM stock WHERE stock_id = '" + data.getStock_id() + "'");
        while (rset.next()) {
            Stock obj = new Stock();
            obj.setStock_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setDescription(rset.getString(3));
            obj.setCategory(rset.getString(4));
            obj.setQty(rset.getInt(5));
            obj.setUnit_price(rset.getDouble(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

}
