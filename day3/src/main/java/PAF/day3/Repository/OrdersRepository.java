package PAF.day3.Repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import PAF.day3.Models.Orders;
import PAF.day3.Utils.SQL;

@Repository
public class OrdersRepository {

    @Autowired
    private JdbcTemplate template;

    public Orders getOrderDetailsWithDiscount(int orderID){
        List<Orders> orderList = new LinkedList<>();
        SqlRowSet rs = template.queryForRowSet(SQL.getOrderByID,orderID);

        while(rs.next()){
            orderList.add(Orders.create(rs));

        }
        return orderList.get(0);
    }


}
