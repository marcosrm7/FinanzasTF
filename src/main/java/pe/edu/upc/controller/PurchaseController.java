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

import pe.edu.upc.entity.Purchase;
import pe.edu.upc.serviceinterface.IClientService;
import pe.edu.upc.serviceinterface.IProductService;
import pe.edu.upc.serviceinterface.IPurchaseService;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

	@Autowired
	private IPurchaseService purS;
	@Autowired
	private IClientService cS;
	@Autowired
	private IProductService pS;
	@Autowired
	private ClientController clienteCont;
	
	@GetMapping("/new")
	public String newPurchase(Model model) {
		model.addAttribute("purchase", new Purchase());
		model.addAttribute("cliente", clienteCont.objCliente.get());
		//model.addAttribute("listClients", cS.list());
		model.addAttribute("listProducts", pS.list());
		return "purchase/purchase";
	}

	@PostMapping("/save")
	public String savePurchase(@Validated Purchase purchase, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listClients", cS.list());
			model.addAttribute("listProducts", pS.list());
			return "purchase/purchase";
		} else {
			purS.insert(purchase);
			model.addAttribute("listClients", cS.list());
			model.addAttribute("listProducts", pS.list());
			model.addAttribute("listPurchases", purS.list());
			return "redirect:/purchases/list";
		}
	}

	@GetMapping("/list")
	public String listPurchases(Model model) {
		model.addAttribute("client", clienteCont.objCliente.get());
		
		try {
			model.addAttribute("purchase", new Purchase());
			model.addAttribute("listPurchases", purS.listarComprasPorID(clienteCont.objCliente.get().getIdClient()));
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "purchase/listPurchases";
	}

	@RequestMapping("/delete/{id}")
	public String deletePurchase(Model model, @PathVariable(value = "id") int id) {
		try {
			model.addAttribute("purchase", new Purchase());
			if (id > 0) {
				purS.delete(id);
			}
			model.addAttribute("mensajeVerde", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensajeRojo", "Ocurrió un error, la compra seleccionada seleccionado...");
		}
		model.addAttribute("listPurchases", purS.list());
		return "purchase/listPurchases";
	}

	@RequestMapping("/irupdate/{id}")
	public String irupdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Purchase> objPro = purS.searchId(id);
								
		if (objPro == null) {
			objRedir.addFlashAttribute("mensajeRojo", "Ocurrió un error");
			return "redirect:/purchases/list";
		} else {
			model.addAttribute("listClients", cS.list());
			model.addAttribute("listProducts", pS.list());
			model.addAttribute("listPurchases", purS.list());
			model.addAttribute("purchase", objPro.get());
			return "purchase/purchase";
		}
	}
}
