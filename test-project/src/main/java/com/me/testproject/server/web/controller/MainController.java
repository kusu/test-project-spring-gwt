package com.me.testproject.server.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.testproject.server.utils.AuthenticationUtil;

@Controller
public class MainController {

	@GetMapping(value = "/main")
	public String getHome(ModelMap modelMap) {
		modelMap.put("username", AuthenticationUtil.getCurrentUser().getUserName());
		return "main";
	}

}
