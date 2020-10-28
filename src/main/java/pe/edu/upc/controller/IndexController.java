package pe.edu.upc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


		@GetMapping("/")	
		public String home() {
			return "index";
		}
		
		@GetMapping("/category")	
		public String panel() {
			return "category/listCategories";
		}
	
	
		
}
