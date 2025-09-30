package shoppyworld.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shoppyworld.model.Product;
import shoppyworld.service.CartService;

@Controller
public class CartController {
	
	private final CartService cartService;
	
	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@RequestMapping(path= "/cartProducts", method = RequestMethod.GET)
	public String getCartProducts(@RequestParam("userId") int userId, Model model) {
		System.out.println("hellooooo");
		List<Product> productsInUserCart = cartService.getProductsInUserCart(userId);
		model.addAttribute("products", productsInUserCart);
		return "user/cartProduct";
	}

}
