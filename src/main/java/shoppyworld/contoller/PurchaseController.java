package shoppyworld.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shoppyworld.model.Product;
import shoppyworld.service.PurchaseService;

@Controller
public class PurchaseController {
	
	private final PurchaseService purchaseService;
	
	public PurchaseController(PurchaseService purchaseService) {
		super();
		this.purchaseService = purchaseService;
	}

	@RequestMapping(path= "/purchaseProducts", method = RequestMethod.GET)
	public String getCartProducts(@RequestParam("userEmail") String userEmail, Model model) {
		List<Product> productsInUserCart = purchaseService.getProductsInUserCart(userEmail);
		model.addAttribute("products", productsInUserCart);
		return "user/purchaseProduct";
	}

}
