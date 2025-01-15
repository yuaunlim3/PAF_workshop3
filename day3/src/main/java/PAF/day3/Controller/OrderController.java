package PAF.day3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import PAF.day3.Models.Orders;
import PAF.day3.Service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/total/{order_id}")
    public String getOrder(@PathVariable("order_id")int id, Model model){
        Orders order = orderService.getOrderDetailsWithDiscount(id);

        model.addAttribute("order",order);
        return "orderList";
    }

    @GetMapping("/total")
    public String start(@RequestParam("orderId") String orderId) {
        System.out.println(orderId);

        return "redirect:/order/total/" + orderId;
    }
}
