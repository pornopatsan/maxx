package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.dao.AutoDao;
import spring.dao.OrdersDAO;
import spring.model.AutoEntity;
import spring.model.OrdersEntity;

import javax.xml.bind.ValidationException;
import java.util.List;

@Controller
public class AutoController {

    @Autowired
    AutoDao _autoDao;

    @Autowired
    OrdersDAO _orderDao;

    @RequestMapping(value = "/auto_show")
    public ModelAndView showAuto(@RequestParam Integer id,
                                 @RequestParam(defaultValue = "") String error)
    {
        ModelAndView modelAndView = new ModelAndView("auto_show");
        modelAndView.getModelMap().addAttribute("auto", _autoDao.getById(id));
        modelAndView.getModelMap().addAttribute("error", error);
        return modelAndView;
    }

    @RequestMapping(value = "/add_auto_form")
    public ModelAndView addAutoForm() {
        try {
            ModelAndView modelAndView =  new ModelAndView("add_auto_form");
            modelAndView.getModelMap().addAttribute("newAuto", new AutoEntity());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:main");
        }
    }

    @RequestMapping(value = "/add_auto")
    public ModelAndView addAuto(@ModelAttribute AutoEntity newAuto) {
        try {
            _autoDao.save(newAuto);
            return new ModelAndView(String.format("redirect:auto_show?id=%d", newAuto.getId()));
        } catch (Exception e) {
            return new ModelAndView("redirect:add_auto_form");
        }
    }

    @RequestMapping(value = "/update_auto_form")
    public ModelAndView updateAutoForm(@RequestParam Integer id) {
        try {
            ModelAndView modelAndView =  new ModelAndView("update_auto_form");
            modelAndView.getModelMap().addAttribute("auto", _autoDao.getById(id));
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:add_auto_form");
        }
    }

    @RequestMapping(value = "/update_auto")
    public ModelAndView updateAuto(@ModelAttribute AutoEntity auto) {
        try {
            _autoDao.update(auto);
            return new ModelAndView(String.format("redirect:auto_show?id=%d", auto.getId()));
        } catch (Exception e) {
            return new ModelAndView(String.format("redirect:update_auto_form?id=%d", auto.getId()));
        }
    }

    @RequestMapping(value = "/delete_auto")
    public ModelAndView updateAuto(@RequestParam Integer id) {
        try {
            _autoDao.delete(_autoDao.getById(id));
            return new ModelAndView("redirect:main");
        } catch (Exception e) {
            String msg = "Error. Can't delete ordered Auto";
            return new ModelAndView(String.format("redirect:auto_show?id=%d&error=%s", id, msg));
        }
    }

    @RequestMapping(value = "/add_to_stock")
    public ModelAndView addToStock(@RequestParam Integer id) {
        try {
            AutoEntity auto = _autoDao.getById(id);
            if (auto.getInStock()) {
                throw new ValidationException("Error. Auto is already in stock");
            } else {
                auto.setInStock(true);
                _autoDao.update(auto);
                List<OrdersEntity> orders = _orderDao.findByAutoId(auto.getId());
                for (OrdersEntity o: orders) {
                    if (o.getStatus().equals("Reserved")) {
                        o.setStatus("Arrived");
                        _orderDao.update(o);
                    }
                }
            }
            return new ModelAndView(String.format("redirect:auto_show?id=%d", id));
        } catch (ValidationException e) {
            String msg = e.getMessage();
            return new ModelAndView(String.format("redirect:auto_show?id=%d&error=%s", id, msg));
        }
    }
}
