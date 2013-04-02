package com.me.testproject.server.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.testproject.exceptions.ClientException;
import com.me.testproject.server.api.IUserApi;
import com.me.testproject.server.utils.AuthenticationUtil;
import com.me.testproject.server.web.model.RegistrationModel;
import com.me.testproject.server.web.model.UserModel;

@Controller
public class UserController {
	
	@Autowired
	private IUserApi userApi;
	
	@ModelAttribute("user")
	public RegistrationModel getUser() {
		return new RegistrationModel();
	}
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		return new UserModel();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public ModelAndView register(@ModelAttribute("user") RegistrationModel user) {
		userApi.registerUser(user);
		ModelAndView mvc=new ModelAndView("redirect:/login");
		mvc.addObject("msg", "Registeration successsful.");
		return mvc;
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/register")
	public String registerView()
	{
		return "register";
	}
	
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(ModelMap modelMap, @RequestParam(value = "errormessage", required = false) String errormessage,
			@RequestParam(value = "spring-security-redirect", required = false) String redirect) {
		if(AuthenticationUtil.getCurrentUser()==null) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelAndView cpView = new ModelAndView("changepass");
		modelMap.put("errormessage", errormessage == null ? "" : errormessage);
		return cpView;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/changePassword")
	public ModelAndView changePassword(@ModelAttribute("userModel") UserModel user) {
		String oldPassword=user.getOldPassword();
		String newPassword=user.getNewPassword();
		String confirmPassword=user.getConfirmNewPassword();
		long userId=AuthenticationUtil.getCurrentUser().getId();
		
		try {
			if(newPassword.equals(confirmPassword)) {
			userApi.changePassword(userId, oldPassword, newPassword);
			}
			else {
				throw new ClientException("Password don't match");
			}
		}
		catch (ClientException e) {
			ModelAndView mvc=new ModelAndView("changepass");
			mvc.addObject("errormessage", "Error: "+e.getMessage());
			return mvc;
		}
		SecurityContextHolder.clearContext();
		ModelAndView mvc=new ModelAndView("redirect:/login");
		mvc.addObject("msg", "Change password successsful.");
		return mvc;
	}
}
