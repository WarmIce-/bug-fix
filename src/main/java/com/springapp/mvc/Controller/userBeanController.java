package com.springapp.mvc.Controller;

import com.springapp.mvc.DAO.serviceImp.UserServiceImp;
import com.springapp.mvc.models.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class userBeanController {
    private Logger logger = Logger.getLogger(userBeanController.class.getName());
    private UserServiceImp userServiceImp;

    @Autowired
    public userBeanController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView welcome(@ModelAttribute(value = "userBean") UserBean userBean, BindingResult result) {
        boolean isUserBeanInserted = userServiceImp.insert(userBean);

        //make sure, data sent from the form are received inside this controller.
        logger.info("data sent from form are: userID=" + userBean.getUserId() + ", password=" + userBean.getPassword());

        ModelAndView model = new ModelAndView("welcome");

        //display 'true' if data are successfully inserted to database.Else display false.
        model.addObject("mess", " is User successfully inserted ? :" + isUserBeanInserted);
        return model;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView model = new ModelAndView("addpage");
        return model;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView model = new ModelAndView("loginpage");
        return model;
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.GET)
    public ModelAndView get(@Valid @ModelAttribute(value = "userBean") UserBean userBean, BindingResult result) {


        //make sure, data sent from the form are received inside this controller.
        logger.info("data sent from form are: userID=" + userBean.getUserId() + ", password=" + userBean.getPassword());

        ModelAndView model = new ModelAndView();

        boolean doesUserExists = userServiceImp.user(userBean);

            if (!doesUserExists){
                model.setViewName("error");
                model.addObject("mess", " ERROR:" + userBean.getUserId()+" , this user doesn't exists in the database!!");
            }

            else{
                model.setViewName("welcome");
                model.addObject("mess", " Login Successful, Welcome:" + userBean.getUserId());
            }

        return model;
    }
}
