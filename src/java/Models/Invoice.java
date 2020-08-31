package Models;

public class Invoice {

    private int invoice_id;
    private int customer_id;
    private int loyalty_points;
    private double total;
    private String date_time;

    public Invoice() {
    }

    public Invoice(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Invoice(int invoice_id, int customer_id, int loyalty_points, double total, String date_time) {
        this.invoice_id = invoice_id;
        this.customer_id = customer_id;
        this.loyalty_points = loyalty_points;
        this.total = total;
        this.date_time = date_time;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getLoyalty_points() {
        return loyalty_points;
    }

    public void setLoyalty_points(int loyalty_points) {
        this.loyalty_points = loyalty_points;
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
