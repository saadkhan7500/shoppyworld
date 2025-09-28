package shoppyworld.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String email, @RequestParam String password, @RequestParam String type,Model model) {
 
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		
		switch(type.toLowerCase()) {
		case "admin":
			return "forward:/adminLogin";
		case "user":
			return "forward:/userLogin";
		case "vendor":
			return "forward:/vendorLogin";
        default:
        	return "redirect:/error";
		}
		
	}

}
