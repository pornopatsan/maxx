package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.dao.AutoDao;
import spring.dao.CustomerDAO;
import spring.dao.OrdersDAO;
import spring.model.AutoEntity;
import spring.model.CustomerEntity;
import spring.model.OrdersEntity;

import java.util.Date;

@Controller
public class MainController {

    @Autowired
    AutoDao _autoDao;

    @Autowired
    CustomerDAO _customerDao;

    @Autowired
    OrdersDAO _orderDao;

    private AutoEntity orderedAuto;

    @RequestMapping(value = "/main")
    public ModelAndView main(){
        ModelAndView modelAndView =  new ModelAndView("index");
        modelAndView.getModelMap().addAttribute("allAutos", _autoDao.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/add_customer_form")
    public ModelAndView addCustomerForm(@RequestParam Integer id) {
        try {
            orderedAuto = _autoDao.getById(id);
            ModelAndView modelAndView = new ModelAndView("add_customer_form");
            modelAndView.getModelMap().addAttribute("newCustomer", new CustomerEntity());
            return modelAndView;
        } catch (Exception e) {
            orderedAuto = null;
            return new ModelAndView("redirect:main");
        }
    }

    @RequestMapping(value = "/add_customer")
    public ModelAndView addCustomer(@ModelAttribute CustomerEntity newCustomer) {
        try {
            Date currentDate = new Date();
            OrdersEntity newOrder = new OrdersEntity();
            newOrder.setAuto(orderedAuto);
            newOrder.setCustomer(newCustomer);
            newOrder.setStatusReserved(currentDate.getTime());
            newOrder.setStatus("Reserved");

            if (orderedAuto.getInStock()) {
                newOrder.setStatusArrived(currentDate.getTime());
                newOrder.setStatus("Arrived");
            }

            _customerDao.save(newCustomer);
            _orderDao.save(newOrder);
            return new ModelAndView("redirect:orders_show");
        } catch (Exception e) {
            orderedAuto = null;
            throw e;
//            return new ModelAndView("redirect:main");
        }
    }
}
