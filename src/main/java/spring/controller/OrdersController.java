package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.dao.AutoDao;
import spring.dao.OrdersDAO;
import spring.model.OrdersEntity;

import java.util.Date;

@Controller
public class OrdersController {

    @Autowired
    OrdersDAO _orderDao;

    @Autowired
    AutoDao _autoDao;

    private String timestampToSring(Long ts) {
        return ts == null ? null : new Date(ts).toString();
    }

    @RequestMapping(value = "/orders_show")
    public ModelAndView showAllOrders() {
        ModelAndView modelAndView = new ModelAndView("orders_show");
        modelAndView.getModelMap().addAttribute("allOrders", _orderDao.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/order_details_show")
    public ModelAndView orderDetails(@RequestParam Integer id) {
        OrdersEntity order = _orderDao.getById(id);
        ModelAndView modelAndView = new ModelAndView("order_details_show");
        modelAndView.getModelMap().addAttribute("order", order);
        modelAndView.getModelMap().addAttribute("sReserved", timestampToSring(order.getStatusReserved()));
        modelAndView.getModelMap().addAttribute("sArrived", timestampToSring(order.getStatusArrived()));
        modelAndView.getModelMap().addAttribute("sTesting", timestampToSring(order.getStatusTesting()));
        modelAndView.getModelMap().addAttribute("sFinished", timestampToSring(order.getStatusFinished()));
        modelAndView.getModelMap().addAttribute("sDenied", timestampToSring(order.getStatusDenied()));
        return modelAndView;
    }

    @RequestMapping(value = "/order_start_test_drive")
    public ModelAndView orderAddTestDrive(@RequestParam Integer id) {
        OrdersEntity order = _orderDao.getById(id);
        if (order.getStatus().equals("Arrived")) {
            Date currentDate = new Date();
            order.setStatus("Test Diving");
            order.setStatusTesting(currentDate.getTime());
            _orderDao.update(order);
            return new ModelAndView(String.format("redirect:order_details_show?id=%d", id));
        } else {
            String msg = "Error. Auto Status should be equal to arrived";
            return new ModelAndView(String.format("redirect:auto_show?id=%d&error=%s", id, msg));
        }
    }

    @RequestMapping(value = "/order_finish")
    public ModelAndView orderFinish(@RequestParam Integer id,
                                    @RequestParam(defaultValue = "0") Integer denied
    ) {
        OrdersEntity order = _orderDao.getById(id);
        if (order.getStatus().equals("Arrived") || order.getStatus().equals("Test Diving")) {
            Date currentDate = new Date();
            if (denied == 0) {
                order.setStatus("Finished");
                order.setStatusFinished(currentDate.getTime());
                order.getAuto().setIsSold(true);
                _autoDao.update(order.getAuto());
            } else {
                order.setStatus("Denied");
                order.setStatusDenied(currentDate.getTime());
            }
            _orderDao.update(order);
            return new ModelAndView(String.format("redirect:order_details_show?id=%d", id));
        } else {
            String msg = "Error. Auto Status should be equal to arrived or testing";
            return new ModelAndView(String.format("redirect:auto_show?id=%d&error=%s", id, msg));
        }
    }
}
