package shoppyworld.contoller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import shoppyworld.model.Product;
import shoppyworld.model.Purchase;
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
		return "vendor/vendorSignUp";
	}

	@RequestMapping(path = "/createVendor", method = RequestMethod.POST)
	public String createVendor(@ModelAttribute Vendor vendor, Model model) {
		int id = vendorService.createVendor(vendor);
		if (id != 0)
			model.addAttribute("msg", "success");
		else
			model.addAttribute("msg", "fail");
		return "vendor/vendorSignUp";
	}

	@RequestMapping(path = "/vendorLogin", method = RequestMethod.POST)
	public String userLogin(@RequestParam String email, @RequestParam String password, Model model) {
		Vendor vendor = vendorService.findByEmailAndPassword(email, password);
		if (vendor != null) {
			model.addAttribute("vendor", vendor);
			List<Product> products = vendorService.getProductByEmail(email);
			model.addAttribute("products", products);
			return "vendor/vendorDashboard";
		}
		return "general/home";
	}

	@RequestMapping(path = "/vendorProduct", method = RequestMethod.GET)
	public String vendorProduct(@RequestParam String email, Model model) {
		List<Product> products = vendorService.getProductByEmail(email);
		model.addAttribute("products", products);
		return "vendor/vendorProduct";
	}

	@RequestMapping(path = "/uploadProductImage", method = RequestMethod.GET)
	public String uploadProductImage(@RequestParam("id") int productId, Model model) {
		model.addAttribute("productId", productId);
		return "vendor/uploadProductImage";
	}

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("productId") int productId,
			HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		try {
			if (file.isEmpty()) {
		        redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
		        return "redirect:/uploadProductImage?id=" + productId;
		    }
			if (!file.isEmpty()) {
				byte[] data = file.getBytes();
				String path = session.getServletContext().getRealPath("/") + "resources" + File.separator + "images"
						+ File.separator + file.getOriginalFilename();
				System.out.println(path);
				FileOutputStream fos = new FileOutputStream(path);
				
				vendorService.uploadProductImage(productId, file.getOriginalFilename());
				
				fos.write(data);
				fos.close();
				System.out.println("uplpaded file: " + file.getOriginalFilename());
				model.addAttribute("fileName", file.getOriginalFilename());
				model.addAttribute("msg", "file has been uploaded");
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		return "vendor/vendorProduct";
	}
	
	@RequestMapping(path = "/vendorToBeDeliverProduct", method = RequestMethod.GET)
	public String vendorToBeDeliverProduct(@RequestParam String email, Model model) {
		List<Purchase> purchases = vendorService.getPurchaseByEmailAndStatus(email);
		model.addAttribute("purchases", purchases);
		return "vendor/vendorToBeDeliverProduct";
	}

}
