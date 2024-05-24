package com.jsp.foodapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.FoodOrderDao;
import com.jsp.foodapp.entities.FoodOrder;

@Controller
public class FoodOrderController {

	@Autowired
	FoodOrderDao dao ;
	
	@RequestMapping("/createorder")
	public ModelAndView createOrder() {
		ModelAndView mav = new ModelAndView("createfoodorder") ;
		FoodOrder foodOrder = new FoodOrder() ;
		mav.addObject("foodorder", foodOrder) ;
		return mav ;
	}
	
	@RequestMapping("/savefoodorder")
    public ModelAndView saveFoodOrder(@ModelAttribute("foodorder") FoodOrder order, HttpSession session) {
    	session.setAttribute("userfoodorder", order);
    	ModelAndView mav = new ModelAndView("redirect:/viewallproduct") ;
    	return mav ;
    }
	
}
