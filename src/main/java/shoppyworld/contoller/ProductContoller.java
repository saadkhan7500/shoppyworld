package shoppyworld.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "general/index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "general/about";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "general/contact";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		List<Product> products =productService.getAllProducts();
		model.addAttribute("products", products);
		System.out.println(products);
		return "general/home";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct() {
		return "vendor/addProduct";
	}
	
	@RequestMapping("/createProduct")
	public String createProduct(@ModelAttribute Product product) {
		  product.setP_i_path("images/card1.jpeg");
		  product.setP_i_name(null);
		  product.setProduct_status("pending");
		  product.setProduct_order("pending");
		  productService.createProduct(product);
		return "vendor/addProduct";
	}
	
	@RequestMapping("/checkoutProduct")
	public String checkoutProduct(@RequestParam int id, Model model) {
		  Product product = productService.getProductById(id);
		  List<Product> relatedProducts = productService.getProductByCategory(product.getProduct_category());
		  
		  model.addAttribute("product", product);
		  model.addAttribute("relatedProducts", relatedProducts);
		return "general/checkoutProduct";
	}

}
