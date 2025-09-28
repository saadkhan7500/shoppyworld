package shoppyworld.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import shoppyworld.model.Product;
import shoppyworld.service.ProductService;

@Controller
public class ProductContoller {
	
	private final ProductService productService;
	
	
	
	public ProductContoller(ProductService productService) {
		super();
		this.productService = productService;
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		List<Product> products =productService.getAllProducts();
		model.addAttribute("products", products);
		System.out.println(products);
		return "home";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct() {
		System.out.println("heyyyyy there");
		return "addProduct";
	}
	
	@RequestMapping("/createProduct")
	public String createProduct(@ModelAttribute Product product) {
		  product.setP_i_path("images/card1.jpeg");
		  product.setP_i_name(null);
		  product.setProduct_status("pending");
		  product.setProduct_order("pending");
		  productService.createProduct(product);
		System.out.println(product);
		return "addProduct";
	}

}
