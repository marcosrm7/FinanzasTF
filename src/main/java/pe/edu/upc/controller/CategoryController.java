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

import pe.edu.upc.entity.Category;
import pe.edu.upc.serviceinterface.ICategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private ICategoryService cS;

	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "category/category";
	}

	@PostMapping("/save")
	public String saveCategory(@Validated Category category, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "category/category";
		} else {
			cS.insert(category);
			model.addAttribute("listCategories", cS.list());
			return "redirect:/categories/list";
		}
	}

	@GetMapping("/list")
	public String listCategories(Model model) {
		try {
			model.addAttribute("listCategories", cS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "category/listCategories";
	}

	@RequestMapping("/delete/{id}")
	public String deleteCategory(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				cS.delete(id);
			}
			model.addAttribute("mensajeVerde", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensajeRojo",
					"Ocurrió un error, la categoría seleccionada está registrada en un producto");
		}
		model.addAttribute("listCategories", cS.list());
		return "category/listCategories";
	}

	@RequestMapping("/irupdate/{id}")
	public String irupdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Category> objPro = cS.searchId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensajeRojo", "Ocurrió un error");
			return "redirect:/categories/list";
		} else {
			model.addAttribute("listCategories", cS.list());
			model.addAttribute("category", objPro.get());
			return "category/category";
		}
	}
}
