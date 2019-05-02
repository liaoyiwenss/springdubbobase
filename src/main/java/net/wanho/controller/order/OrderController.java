package net.wanho.controller.order;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Order;
import net.wanho.pojo.User;
import net.wanho.service.order.OrderService;
import net.wanho.service.order.OrderdetailService;
import net.wanho.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("doorder")
public class OrderController {

@Autowired
    private OrderdetailService orderdetailService;


@Autowired
    private OrderService orderService;

@Autowired
    private ProductService productService;



@RequestMapping("orderdetail")
public String orderdetail(HttpSession session, Integer pageno, String flag)
{

    User user = (User) session.getAttribute("users");

    session.setAttribute("flag", flag);

    if(pageno==null)
    {
        pageno=1;
    }

    PageInfo<Order> pagehelper = null;

    if(flag.equals("1"))
    {
        pagehelper = orderService.queryorderbyuserId(user.getTid(), pageno, 2, 4);
    }
    else
    {
        pagehelper = orderService.queryorderbyuserId(null, pageno, 2, 4);
    }
    session.setAttribute("pagehelper", pagehelper);
    return "redirect:/show/Member_Packet";

}


}
