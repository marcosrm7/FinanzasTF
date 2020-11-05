package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.repository.ISellRepository;

@Controller
@RequestMapping("/sales")
public class SalesController {
	   @Autowired
	    ISellRepository ventasRepository;
	   
	   @GetMapping(value = "/")
	    public String mostrarVentas(Model model) {
	        model.addAttribute("ventas", ventasRepository.findAll());
	        return "sell/listSales";
	    }
}
