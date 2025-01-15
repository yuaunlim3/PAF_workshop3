package PAF.day3.Utils;

public class SQL {
    public static final String getOrderByID = """
            SELECT 
            o.id AS order_id,
            DATE_FORMAT(o.order_date,'%d/%m/%Y') AS order_date,
            o.customer_id AS customer_id,
            SUM(od.quantity * od.unit_price) AS total_price,
            (SUM(od.quantity * od.unit_price) - SUM(od.quantity * od.unit_price * od.discount)) AS discounted_price,
            SUM(od.quantity * p.standard_cost) as cost_price
    
            FROM orders AS o
            INNER JOIN order_details AS od
                ON o.id = od.order_id
            INNER JOIN products AS p
                ON od.product_id = p.id
            WHERE o.id = ?

            """;


    

}
