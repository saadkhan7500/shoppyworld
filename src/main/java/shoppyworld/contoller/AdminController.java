package shoppyworld.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shoppyworld.model.Admin;
import shoppyworld.model.User;
import shoppyworld.model.Vendor;
import shoppyworld.model.Purchase;
import shoppyworld.model.Product;
import shoppyworld.service.AdminService;

@Controller
public class AdminController {
	
	private final AdminService adminService;
	
	
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	
	@RequestMapping(path = "/adminLogin", method = RequestMethod.POST)
	public String userLogin(@RequestParam String email , @RequestParam String password ,Model model) {
		Admin admin = adminService.findByEmailAndPassword(email, password);
		if(admin != null) {
			model.addAttribute("user", admin);
			return "admin/adminDashboard";
		}
		return "general/home";
	}
	
	@RequestMapping(path = "/allVendors", method = RequestMethod.GET)
	public String allVendors(Model model) {
		List<Vendor> vendors = adminService.getAllVendors();
		model.addAttribute("vendors", vendors);
		return "admin/allVendors";
	}
	
	@RequestMapping(path = "/allUsers", method = RequestMethod.GET)
	public String allUsers(Model model) {
		List<User> users = adminService.getAllUsers();
		model.addAttribute("users", users);
		return "admin/allUsers";
	}
	
	@RequestMapping(path = "/orderRequest", method = RequestMethod.GET)
	public String orderRequest(Model model) {
		List<Purchase> purchases = adminService.getAllOrderPurchaseRequest();
		model.addAttribute("purchases", purchases);
		return "admin/orderRequest";
	}
	
	@RequestMapping(path = "/informVendor", method = RequestMethod.GET)
	public String informVendor(@RequestParam("id") int productId) {
		adminService.updatePurchaseStatusByProductId(productId);
		return "admin/orderRequest";
	}
	
	@RequestMapping(path = "/newProducts", method = RequestMethod.GET)
	public String newProducts(Model model) {
		List<Product> products = adminService.getAllNewlyAddedProduct();
		model.addAttribute("products",products);
		return "admin/newProducts";
	}

}
