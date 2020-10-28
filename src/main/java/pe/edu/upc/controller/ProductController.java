package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Product;
import pe.edu.upc.serviceinterface.ICategoryService;
import pe.edu.upc.serviceinterface.IProductService;

@Controller
@RequestMapping("categories/products")
public class ProductController {
	@Autowired
	private IProductService pS;
	@Autowired
	private ICategoryService cS;

	@GetMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories", cS.list());
		return "category/product";
	}

	@PostMapping("/save")
	public String saveProduct(@Validated Product product, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listCategories", cS.list());
			return "category/product";
		} else {
			pS.insert(product);
			model.addAttribute("listCategories", cS.list());
			model.addAttribute("listProducts", pS.list());
			return "redirect:/categories/products/list";
		}
	}

	@GetMapping("/list")
	public String listProducts(Model model) {
		try {
			model.addAttribute("listProducts", pS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "category/listProducts";
	}
}
