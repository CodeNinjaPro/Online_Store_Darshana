package Models;

public class Invoice_details {

    private int invoice_details_id;
    private int invoice_id;
    private int stock_id;
    private int qty;
    private String date_time;

    public Invoice_details() {
    }

    public Invoice_details(int invoice_details_id) {
        this.invoice_details_id = invoice_details_id;
    }

    public Invoice_details(int invoice_details_id, int invoice_id, int stock_id, int qty, String date_time) {
        this.invoice_details_id = invoice_details_id;
        this.invoice_id = invoice_id;
        this.stock_id = stock_id;
        this.qty = qty;
        this.date_time = date_time;
    }

    public int getInvoice_details_id() {
        return invoice_details_id;
    }

    public void setInvoice_details_id(int invoice_details_id) {
        this.invoice_details_id = invoice_details_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
