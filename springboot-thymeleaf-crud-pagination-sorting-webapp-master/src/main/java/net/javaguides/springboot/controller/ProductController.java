package net.javaguides.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// display list of products
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "name", "asc", model);		
	}
	@RequestMapping("index")
	public String Project1(Model model, @Param("keyword") String keyword) {
		List<Product> listProduct = productService.getAllProduct(keyword);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("keyword", keyword);
		return "index";
	}
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model model , HttpSession session) {
		// create model attribute to bind form data
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("product") Product product,HttpSession session) {
		// save product to database
		productService.saveProduct(product);
		session.setAttribute("msg", "Product  Added Sucessfully..!!!");
		return "redirect:/";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product,HttpSession session) {
		// save product to database
		productService.saveProduct(product);
		session.setAttribute("msg", "Product Data Updated Sucessfully..!!");
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get product from the service
		Product product = productService.getProductById(id);
		
		// set product as a model attribute to pre-populate the form
		model.addAttribute("product", product);
		return "update_product";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable (value = "id") long id,HttpSession session) {
		
		// call delete product method 
		this.productService.deleteProductById(id);
		session.setAttribute("msg", "Product deleted successfully..!!");
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated( @PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 10;
		Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Product> listProducts = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
}
