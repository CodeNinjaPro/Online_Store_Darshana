package Models;

public class Grn {

    private int grn_id;
    private int stock_id;
    private int supplier_id;
    private double qty;
    private double total;
    private String date_time;

    public Grn() {
    }

    public Grn(int grn_id) {
        this.grn_id = grn_id;
    }

    public Grn(int grn_id, int stock_id, int supplier_id, double qty, double total, String date_time) {
        this.grn_id = grn_id;
        this.stock_id = stock_id;
        this.supplier_id = supplier_id;
        this.qty = qty;
        this.total = total;
        this.date_time = date_time;
    }

    public int getGrn_id() {
        return grn_id;
    }

    public void setGrn_id(int grn_id) {
        this.grn_id = grn_id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
