package Models;

public class Stock {

    private int stock_id;
    private String name;
    private String description;
    private String category;
    private int qty;
    private double unit_price;
    private String date_time;

    public Stock() {
    }

    public Stock(int stock_id) {
        this.stock_id = stock_id;
    }

    public Stock(int stock_id, String name, String description, String category, int qty, double unit_price, String date_time) {
        this.stock_id = stock_id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.qty = qty;
        this.unit_price = unit_price;
        this.date_time = date_time;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
