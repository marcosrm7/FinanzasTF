package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Client;
import pe.edu.upc.serviceinterface.IRateService;
import pe.edu.upc.serviceinterface.ICapitalizationService;
import pe.edu.upc.serviceinterface.IInterestService;
import pe.edu.upc.serviceinterface.IClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private IClientService pS;
	@Autowired
	private IRateService cS;
	@Autowired
	private ICapitalizationService pp;
	
	@Autowired
	private IInterestService ii;
	
	@GetMapping("/new")
	public String newClient(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("listRates", cS.list());
		model.addAttribute("listCapitalizations", pp.list());
		model.addAttribute("listClients", pS.list());
		model.addAttribute("listInterests", ii.list());
		return "client/client";
	}
	@PostMapping("/save")
	public String saveClient(@Validated Client client, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listRates", cS.list());
			model.addAttribute("listCapitalizations", pp.list());
			model.addAttribute("listClients", pS.list());
			model.addAttribute("listInterests", ii.list());
			return "client/client";
		} else {
			pS.insert(client);
			model.addAttribute("listRates", cS.list());
			model.addAttribute("listCapitalizations", pp.list());
			model.addAttribute("listInterests", ii.list());
			model.addAttribute("listClients", pS.list());
			return "redirect:/clients/list";
		}
	}
	@GetMapping("/list")
	public String listClients(Model model) {
		try {
			model.addAttribute("client", new Client());
			model.addAttribute("listClients", pS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "client/listClients";
	}

	
	
	
}
