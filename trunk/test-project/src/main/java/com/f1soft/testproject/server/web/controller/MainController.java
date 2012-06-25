package com.f1soft.testproject.server.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.f1soft.testproject.server.utils.AuthenticationUtil;

@Controller
public class MainController {

	@RequestMapping(method = RequestMethod.GET, value = "/main")
	public String getHome(ModelMap modelMap) {
		modelMap.put("username", AuthenticationUtil.getCurrentUser().getUserName());
		return "main";
	}

}
