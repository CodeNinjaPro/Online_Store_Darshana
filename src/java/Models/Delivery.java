package Models;

public class Delivery {

    private int delivery_id;
    private int invoice_id;
    private String address;
    private String status;
    private String driver_contact;
    private String date_time;

    public Delivery() {
    }

    public Delivery(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public Delivery(int delivery_id, int invoice_id, String address, String status, String driver_contact, String date_time) {
        this.delivery_id = delivery_id;
        this.invoice_id = invoice_id;
        this.address = address;
        this.status = status;
        this.driver_contact = driver_contact;
        this.date_time = date_time;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDriver_contact() {
        return driver_contact;
    }

    public void setDriver_contact(String driver_contact) {
        this.driver_contact = driver_contact;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
