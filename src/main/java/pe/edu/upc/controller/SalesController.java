package pe.edu.upc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Client;
import pe.edu.upc.repository.ISellRepository;

@Controller
@RequestMapping("/sales")
public class SalesController {
	   @Autowired
	    ISellRepository ventasRepository;
	
		@Autowired
		private ClientController clienteCont;
	   @GetMapping(value = "/")
	    public String mostrarVentas(Model model) {
			model.addAttribute("client", clienteCont.objCliente.get());
		   model.addAttribute("ventas", ventasRepository.findByUser(clienteCont.objCliente.get().getIdClient()));
	       // model.addAttribute("ventas", ventasRepository.findAll());
	        return "sell/listSales";
	    }
	   
	   @GetMapping(value = "/all")
	    public String mostrarVentasall(Model model) {
		
		   	model.addAttribute("ventas", ventasRepository.findAll());
	        return "sell/listSalesAll";
	    }
}
