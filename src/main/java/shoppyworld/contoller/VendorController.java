package shoppyworld.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
