package com.me.testproject.server.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.testproject.server.utils.AuthenticationUtil;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public ModelAndView login(ModelMap modelMap, @RequestParam(value = "errormessage", required = false) String errormessage,
			@RequestParam(value = "spring-security-redirect", required = false) String redirect) {
		ModelAndView loginView = new ModelAndView("login");

		/*
		 * if( StringUtils.hasText(redirect) ){ modelMap.put("action",
		 * "/j_spring_security_check?spring-security-redirect=testt"); }else{
		 * modelMap.put("action", "/j_spring_security_check"); }
		 */
		modelMap.put("action", "j_spring_security_check");
		modelMap.put("errormessage", errormessage == null ? "" : errormessage);
		loginView.addObject("msg", "Login is required!!");
		return loginView;
	}

	@GetMapping(value = "/")
	public String getHome() {
		if (AuthenticationUtil.getCurrentUser() != null) {
			return "redirect:/main";
		}
		return "redirect:/login";
	}
}
