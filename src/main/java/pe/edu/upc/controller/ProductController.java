package pe.edu.upc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Product;
import pe.edu.upc.serviceinterface.ICategoryService;
import pe.edu.upc.serviceinterface.IProductService;

@Controller
@RequestMapping("/products")
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
			return "redirect:/products/list";
		}
	}

	@GetMapping("/list")
	public String listProducts(Model model) {
		try {
			model.addAttribute("product", new Product());
			model.addAttribute("listProducts", pS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "category/listProducts";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(Model model, @PathVariable(value = "id") int id) {
		try {
			model.addAttribute("product", new Product());
			if (id > 0) {
				pS.delete(id);
			}
			model.addAttribute("mensajeVerde", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensajeRojo", "Ocurrió un error, el producto seleccionado...");
		}
		model.addAttribute("listProducts", pS.list());
		return "category/listProducts";
	}

	@RequestMapping("/irupdate/{id}")
	public String irupdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Product> objPro = pS.searchId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensajeRojo", "Ocurrió un error");
			return "redirect:/products/list";
		} else {
			model.addAttribute("listProducts", pS.list());
			model.addAttribute("listCategories", cS.list());
			model.addAttribute("product", objPro.get());
			return "category/product";
		}
	}
}
