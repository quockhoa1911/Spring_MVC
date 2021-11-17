package btt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import btt.model.bean.User;
import btt.model.dao.UserDao;

public class login {
	@Autowired
	private UserDao userdao; //Dependence injection
	private static String err = "ban chua kich hoat tai khoan";
	private static String err1 = "sai tai khoan hoac mat khau";
	@GetMapping("login")
	public String index()
	{
		return "login";
	}
	@PostMapping("login")
	public String check(Model model,@RequestParam String username , @RequestParam String password,RedirectAttributes re)
	{
		for(User a : userdao.getUsers())
		{
			if(username.equals(a.getUsername()) && password.equals(a.getPassword()))
			{
				if(a.getActive().equals("active"))
				{
				model.addAttribute("user", a);
				return "index";
				}else {
					re.addFlashAttribute("msg",err);
					return "login";
				}
			}
		}
		re.addFlashAttribute("msg",err1);
		return "login";
	}
	
	
}
