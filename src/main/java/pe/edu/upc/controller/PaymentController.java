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

import pe.edu.upc.entity.Payment;
import pe.edu.upc.repository.ISellRepository;
import pe.edu.upc.serviceinterface.IPaymentService;

@Controller
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private IPaymentService payS;
	@Autowired
	private ISellRepository ventasRepository;

	@GetMapping("/new")
	public String newPayment(Model model) {
		model.addAttribute("payment", new Payment());
		model.addAttribute("ventas", ventasRepository.findAll());
		return "payment/payment";
	}

	@PostMapping("/save")
	public String savePayment(@Validated Payment payment, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("ventas", ventasRepository.findAll());
			return "payment/payment";
		} else {
			payS.insert(payment);
			model.addAttribute("ventas", ventasRepository.findAll());
			model.addAttribute("listPayments", payS.list());
			return "redirect:/payments/list";
		}
	}

	@GetMapping("/list")
	public String listPayment(Model model) {
		try {
			model.addAttribute("payment", new Payment());
			model.addAttribute("listPayments", payS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "payment/listPayments";
	}

	@RequestMapping("/delete/{id}")
	public String deletePayment(Model model, @PathVariable(value = "id") int id) {
		try {
			model.addAttribute("payment", new Payment());
			if (id > 0) {
				payS.delete(id);
			}
			model.addAttribute("mensajeVerde", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensajeRojo", "Ocurrió un error");
		}
		model.addAttribute("listPayments", payS.list());
		return "payment/listPayments";
	}

	@RequestMapping("/irupdate/{id}")
	public String irupdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Payment> objPro = payS.searchId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensajeRojo", "Ocurrió un error");
			return "redirect:/payments/list";
		} else {
			model.addAttribute("listPayments", payS.list());
			model.addAttribute("payment", objPro.get());
			model.addAttribute("ventas", ventasRepository.findAll());
			return "payment/payment";
		}
	}
}
