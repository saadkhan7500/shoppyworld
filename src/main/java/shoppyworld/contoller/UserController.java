package shoppyworld.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shoppyworld.model.User;
import shoppyworld.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping("/userSignUp")
	public String userSignUp() {
		return "user/userSignUp";
	}
	
	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user, Model model)
	{
		int id = userService.createUser(user);
		if(id!=0)
			model.addAttribute("msg", "success");
		return "user/userSignUp";
	}
	
	@RequestMapping(path = "/userLogin", method = RequestMethod.POST)
	public String userLogin(@RequestParam String email , @RequestParam String password ,Model model) {
		System.out.println(email+" ==== "+password);
		User user = userService.findByEmailAndPassword(email, password);
		if(user != null) {
			model.addAttribute("user", user);
			return "user/userDashboard";
		}
		return "general/home";
	}

}
