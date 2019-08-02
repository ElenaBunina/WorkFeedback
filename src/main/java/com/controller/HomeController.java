package com.controller;


import com.dao.DAO;
import com.model.Company;
import com.model.Entity;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@Controller
//@RequestMapping(value = "/user")
public class HomeController {

    @Autowired
    private DAO dao;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView visitHome() {
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        return model;
    }
    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public ModelAndView usersAll() {
        ModelAndView model = new ModelAndView();
        List<? extends Entity> listAllObjects = dao.getAllObjects();
        model.addObject("listAllObjects", listAllObjects);
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/newCompany", method = RequestMethod.GET)
    public ModelAndView newCompany ( ModelAndView model) {
        Company company = new Company();
        model.addObject("company", company);
        model.setViewName("newCompany");
        return model;
    }
    @RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
    public ModelAndView saveCompany(@ModelAttribute("company") Company company) throws IllegalAccessException {
        dao.saveEntity(company);
        return new ModelAndView("redirect:/newCompany");
    }
}
