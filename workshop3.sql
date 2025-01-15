create user 'fred'@'%' identified by 'Password123!';

grant all privileges on northwind.* to 'fred'@'%';

flush privileges;


select * from orders;
desc orders;
## order details order_id is a fk on orders table
select * from order_details;
desc order_details;

select * from products;
desc products;

##order id with order details fk order_id
## order details join with products id


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
WHERE o.id = 30
GROUP BY 
	o.id,
    o.order_date,
    o.customer_id;
    
    
    
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
            WHERE o.id = 30