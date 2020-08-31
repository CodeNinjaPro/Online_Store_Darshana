package Models;

public class Customer {

    private int customer_id;
    private String name;
    private String address;
    private String contact;
    private int loyality;
    private String date_time;

    public Customer() {
    }

    public Customer(int customer_id) {
        this.customer_id = customer_id;
    }

    public Customer(int customer_id, String name, String address, String contact, int loyality, String date_time) {
        this.customer_id = customer_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.loyality = loyality;
        this.date_time = date_time;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getLoyality() {
        return loyality;
    }

    public void setLoyality(int loyality) {
        this.loyality = loyality;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
