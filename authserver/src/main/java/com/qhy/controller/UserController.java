package com.qhy.controller;

import com.qhy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;






/**
 * 
 * @ClassName: LoginController   
 * @Description: 登录controller
 * @Description:跳转到登录界面
 */

@RequestMapping("/user")
@Controller
public class UserController{

	@RequestMapping("/showUser")
	public ModelAndView toShowUser(){
		User user = new User();
		user.setUid(1);
		user.setUname("qhy");
		user.setUemail("aaa@163.com");
		user.setUpassword("bbbbb");
		ModelAndView mv = new ModelAndView("user01");
		mv.addObject("user", user);
		mv.addObject("ok", "ok01");
		System.out.println(user.getUid());
		System.out.println(user.getUname());
		System.out.println(user.getUpassword());
		System.out.println(user.getUemail());
		return mv;
	}
	
	
	
}