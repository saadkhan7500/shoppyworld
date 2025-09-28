package shoppyworld.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shoppyworld.model.Product;
import shoppyworld.model.Vendor;
import shoppyworld.service.VendorService;

@Controller
public class VendorController {
	
	private final VendorService vendorService;
	
	
	public VendorController(VendorService vendorService) {
		super();
		this.vendorService = vendorService;
	}

	@RequestMapping("/vendorSignUp")
	public String vendorSignUp() {
		return "vendorSignUp";
	}
	
	@RequestMapping(path = "/createVendor", method = RequestMethod.POST)
	public String createVendor(@ModelAttribute Vendor vendor, Model model)
	{
		int id = vendorService.createVendor(vendor);
		if(id!=0)
			model.addAttribute("msg", "success");
		else
			model.addAttribute("msg", "fail");
		return "vendorSignUp";
	}
	
	@RequestMapping(path = "/vendorLogin", method = RequestMethod.POST)
	public String userLogin(@RequestParam String email , @RequestParam String password ,Model model) {
		System.out.println(email+" ==== "+password);
		Vendor vendor = vendorService.findByEmailAndPassword(email, password);
		if(vendor != null) {
			model.addAttribute("vendor", vendor);
			List<Product> products = vendorService.getProductByEmail(email);
			model.addAttribute("products", products);
			return "vendorDashboard";
		}
		return "home";
	}

}
