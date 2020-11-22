package pe.edu.upc.controller;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
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

import pe.edu.upc.entity.Capitalization;
import pe.edu.upc.entity.Client;
import pe.edu.upc.entity.Interest;
import pe.edu.upc.entity.Sell;
import pe.edu.upc.repository.IClientRepository;
import pe.edu.upc.repository.ISellRepository;
import pe.edu.upc.serviceinterface.IRateService;
import pe.edu.upc.serviceinterface.ICapitalizationService;
import pe.edu.upc.serviceinterface.IInterestService;
import pe.edu.upc.serviceinterface.IPurchaseService;
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
	@Autowired
	public Optional<Client> objCliente;
	@Autowired
	ISellRepository ventasRepository;
	@Autowired
	IClientRepository clientesRepository;
	@Autowired
	private IPurchaseService purS;
	
	
	public void calcularInteres() {
		    
		for (Client client: pS.list()) {
			Double	sumaInteresCompras=(double) 0;
			Double	sumaCompras=(double) 0;
			//INICIO: PRUEBA PARA OBTENER INTERES.
			for (Sell v : ventasRepository.findByUser(client.getIdClient())){
				Double interes=(double) 0;
				int milisecondsByDay = 86400000;		
				Date hoy=new Date(System.currentTimeMillis());				
				//INICIO: PARA MODIFICAR FECHA... DOESNT WORKS
				//String formato = "yyyy-MM-dd HH:mm:ss";
			    // DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);		
				//Date hoy= (Date) formateador.parse("2020-11-11 00:00:00.0") ;
				//FIN.
				int diasTranscurridos=  (int) ((hoy.getTime()-v.getFechaCompra().getTime())/milisecondsByDay);	
			
		  if (v.getEstadoCompra()==0) {
			//INTERES SIMPLE=1
				if(client.getInterest().getIdInterest()==1) {
					Double aux=(double) client.getRate().getDaysRate();
					interes= v.getTotal()*(1+(client.getRateClient()/100)*diasTranscurridos/aux)-v.getTotal();									
				}
			//INTERES COMPUESTO O NOMINAL
				else if (client.getInterest().getIdInterest()==2) {
					Double aux=(double) client.getCapitalization().getDaysCapitalization();
					Double aux2=(double) client.getRate().getDaysRate();					
					Double parte2=Math.pow((1+(client.getRateClient()/100)/(aux2/aux)), diasTranscurridos/aux);					
					//interes= (double) Math.round(v.getTotal()*parte2-v.getTotal()) ;
					interes= v.getTotal()*parte2-v.getTotal() ;
				}
			//INTERES EFECTIVO
				else if (client.getInterest().getIdInterest()==3){					
					Double aux=(double) client.getRate().getDaysRate();
					Double par= Math.pow(1+(client.getRateClient()/100), diasTranscurridos/aux);
					interes=v.getTotal()*par-v.getTotal();
				}
				v.interesCero();
				sumaCompras+=v.getTotal();
				sumaInteresCompras +=interes;
				v.sumarInteres(interes);
				ventasRepository.save(v);
			}
				
				
				
		
				
			}
			//RESTAR CREDITO_SUMAR DEUDA
			client.setCreditoDisponible(client.getCreditClient());
			client.setDebtCliente((double) 0);
			client.aumentarDeuda(sumaCompras);
			client.restarCredito(sumaCompras);
			
			client.aumentarDeuda(sumaInteresCompras);
			client.restarCredito(sumaInteresCompras);
			pS.insert(client);
					
							
			//FIN	
			
		}
	}
	
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
			if (client.getInterest().getIdInterest()!=2) {
				Capitalization c = new Capitalization(9, "N. A.",0);
				client.setCapitalization(c);
				}
			client.setCreditoDisponible(client.getCreditClient());
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
			calcularInteres();
			model.addAttribute("client", new Client());
			model.addAttribute("listClients",clientesRepository.findAllByOrderByIdClient());// pS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "client/listClients";
	}

	@RequestMapping("/delete/{id}")
	public String deleteClient(Model model, @PathVariable(value = "id") int id) {
		try {
			if (id > 0) {
				pS.delete(id);
			}
			model.addAttribute("mensajeVerde", "Se eliminó correctamente");
		} catch (Exception e) {
			model.addAttribute("mensajeRojo", "Ocurrió un error, el cliente seleccionado está registrado en una venta");
		}
		model.addAttribute("listClients", pS.list());
		return "client/listClients";
	}

	@RequestMapping("/irupdate/{id}")
	public String irupdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Client> objPro = pS.searchId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensajeRojo", "Ocurrió un error");
			return "redirect:/clients/list";
		} else {
			model.addAttribute("listRates", cS.list());
			model.addAttribute("listCapitalizations", pp.list());
			model.addAttribute("listInterests", ii.list());
			model.addAttribute("listClients", pS.list());
			model.addAttribute("client", objPro.get());
			return "client/client";
		}
	}
	@RequestMapping("/purchases/{id}")
	public String purchases(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Client> objPro = pS.searchId(id);
						objCliente=objPro;
		if (objPro == null) {
			objRedir.addFlashAttribute("mensajeRojo", "Ocurrió un error");
			return "redirect:/clients/list";
		} else {
		model.addAttribute("listPurchases", purS.listarComprasPorID(objPro.get().getIdClient()));	
		model.addAttribute("client", objPro.get());
		
		return "purchase/listPurchases";
		}
	}
	
	@RequestMapping("/sales/{id}")
	public String Sales(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Client> objPro = pS.searchId(id);
						objCliente=objPro;
			//Double	sumaPrueba=(double) 0;
		if (objPro == null) {
			objRedir.addFlashAttribute("mensajeRojo", "Ocurrió un error");
			return "redirect:/clients/list";
		} else {
			/*
			//INICIO: PRUEBA PARA OBTENER INTERES.
			for (Sell v : ventasRepository.findByUser(objPro.get().getIdClient())){
				Double interes=(double) 0;
				int milisecondsByDay = 86400000;		
				Date hoy=new Date(System.currentTimeMillis());
				//DIAS A OBTENER 35 - RESULTADO: OKKKK
				int diasTranscurridos=  (int) ((hoy.getTime()-v.getFechaCompra().getTime())/milisecondsByDay);					
			//INTERES SIMPLE=1
				if(objPro.get().getInterest().getIdInterest()==1) {
					Double aux=(double) objPro.get().getRate().getDaysRate();
					interes= v.getTotal()*(1+(objPro.get().getRateClient()/100)*diasTranscurridos/aux)-v.getTotal();									
				}
			//INTERES COMPUESTO O NOMINAL
				else if (objPro.get().getInterest().getIdInterest()==2) {
					Double aux=(double) objPro.get().getCapitalization().getDaysCapitalization();
					Double aux2=(double) objPro.get().getRate().getDaysRate();					
					Double parte2=Math.pow((1+(objPro.get().getRateClient()/100)/(aux2/aux)), diasTranscurridos/aux);					
					//interes= (double) Math.round(v.getTotal()*parte2-v.getTotal()) ;
					interes= v.getTotal()*parte2-v.getTotal() ;
				}
			//INTERES EFECTIVO
				else if (objPro.get().getInterest().getIdInterest()==3){					
					Double aux=(double) objPro.get().getRate().getDaysRate();
					Double par= Math.pow(1+(objPro.get().getRateClient()/100), diasTranscurridos/aux);
					interes=v.getTotal()*par-v.getTotal();
				}
				
				sumaPrueba +=interes;
				v.sumarInteres(interes);
				ventasRepository.save(v);
		
				
			}
			//RESTAR CREDITO_SUMAR DEUDA-> No funka
			objPro.get().aumentarDeuda(sumaPrueba);
			objPro.get().restarCredito(sumaPrueba);
					
							
			//FIN	
			*/
			
		    //model.addAttribute("ventas", ventasRepository.findAll());
			model.addAttribute("ventas", ventasRepository.findByUser(objPro.get().getIdClient()));
		    model.addAttribute("client", objPro.get());
		
		return "sell/listSales";
		}
	}
	
	
}
