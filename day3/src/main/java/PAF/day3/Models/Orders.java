package PAF.day3.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Orders {
    private int order_id;
    private LocalDate order_date;
    private int customer_id;
    private double total_price;
    private double cost_price;
    private double discounted_price;

    public Orders(){}

    public static Orders create(SqlRowSet rs){
        Orders order = new Orders();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        order.setOrder_id(rs.getInt("order_id"));
        order.setOrder_date(LocalDate.parse(rs.getString("order_date"),formatter));
        order.setCustomer_id(rs.getInt("customer_id"));
        order.setTotal_price(rs.getDouble("total_price"));
        order.setCost_price(rs.getDouble("cost_price"));
        order.setDiscounted_price(rs.getDouble("discounted_price"));

        return order;

    }

    

    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public LocalDate  getOrder_date() {
        return order_date;
    }
    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    public double getCost_price() {
        return cost_price;
    }
    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
    }

    public double getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(double discounted_price) {
        this.discounted_price = discounted_price;
    }

    
    
}
