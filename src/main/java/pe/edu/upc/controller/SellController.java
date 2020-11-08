package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Client;
import pe.edu.upc.entity.Product;
import pe.edu.upc.entity.ProductSelled;
import pe.edu.upc.entity.ProductToSell;
import pe.edu.upc.entity.Sell;
import pe.edu.upc.repository.IClientRepository;
import pe.edu.upc.repository.IProductRepository;
import pe.edu.upc.repository.IProductSelledRepository;
import pe.edu.upc.repository.ISellRepository;
import pe.edu.upc.serviceinterface.IClientService;
import pe.edu.upc.serviceinterface.IProductService;

@Controller
@RequestMapping("/vender")
public class SellController {
	@Autowired
	private IProductRepository productosRepository;
	@Autowired
	 private ISellRepository ventasRepository;
	@Autowired
	private IProductSelledRepository productosVendidosRepository;
	@Autowired
	 private IClientRepository clientRepository;
	@Autowired
	private IProductService pS;
	@Autowired
	private IClientService cli;
	@Autowired
	private ClientController clienteCont;
	
	private void limpiarCarrito(HttpServletRequest request) {
	        this.guardarCarrito(new ArrayList<>(), request);
	    }
	private void guardarCarrito(ArrayList<ProductToSell> carrito, HttpServletRequest request) {
	        request.getSession().setAttribute("carrito", carrito);
	    }
	 @GetMapping(value = "/")
	    public String interfazVender(Model model, HttpServletRequest request) {
			model.addAttribute("listProducts", pS.list());
	        model.addAttribute("producto", new Product());
	       
	        ArrayList<ProductToSell> carrito = this.obtenerCarrito(request);
	        float total = 0;
	        for (ProductToSell p: carrito) total += p.getTotal();
	        model.addAttribute("total", total);
	        return "sell/sell";
	    }
	 
    private ArrayList<ProductToSell> obtenerCarrito(HttpServletRequest request) {
        ArrayList<ProductToSell> carrito = (ArrayList<ProductToSell>) request.getSession().getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        return carrito;
    }

    @PostMapping(value = "/quitar/{indice}")
    public String quitarDelCarrito(@PathVariable int indice, HttpServletRequest request) {
        ArrayList<ProductToSell> carrito = this.obtenerCarrito(request);
        if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
            carrito.remove(indice);
            this.guardarCarrito(carrito, request);
        }
        return "redirect:/vender/";
    }

   

    @GetMapping(value = "/limpiar")
    public String cancelarVenta(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        this.limpiarCarrito(request);
        redirectAttrs
                .addFlashAttribute("mensaje", "Venta cancelada")
                .addFlashAttribute("clase", "info");
        return "redirect:/vender/";
    }

    @PostMapping(value = "/terminar")
    public String terminarVenta(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<ProductToSell> carrito = this.obtenerCarrito(request);
        // Si no hay carrito o está vacío, regresamos inmediatamente
        if (carrito == null || carrito.size() <= 0) {
            return "redirect:/vender/";
        }       
                
        //validar si se queda sin credito
        Sell v = ventasRepository.save(new Sell(clienteCont.objCliente.get()));
       // int i=clienteCont.objCliente.get().getIdClient();
        //Optional<Sell> venta= ventasRepository.findById(v.getId());
        Optional<Client> clo=clientRepository.findById(clienteCont.objCliente.get().getIdClient());
    
    //  Optional<Client> clo = cli.searchId(clienteCont.objCliente.get().getIdClient());
        //clientRepository.search(clienteCont.objCliente.get().getIdClient());
                //   clo.get().restarCredito((double) 1000);
        
       // clientRepository.findById(clienteContobjCliente.get().getIdClient());
        
     // NO FUNKA -> clienteCont.objCliente.get().restarCredito((double) 1000);
        // Recorrer el carrito
      

        for (ProductToSell ProductToSell : carrito) {
            // Obtener el producto fresco desde la base de datos 	
            Product p = productosRepository.findById(ProductToSell.getIdProduct()).orElse(null);
            if (p == null) continue; // Si es nulo o no existe, ignoramos el siguiente código con continue
            // Le restamos existencia
            p.restarExistencia(ProductToSell.getCantidad());
            
            // Lo guardamos con la existencia ya restada
            productosRepository.save(p);
            // Creamos un nuevo producto que será el que se guarda junto con la venta
            ProductSelled productoVendido = new ProductSelled(ProductToSell.getNameProduct(),ProductToSell.getCantidad(), ProductToSell.getPriceProduct(), ProductToSell.getCategory(), v);
            // Y lo guardamos
            productosVendidosRepository.save(productoVendido);
            
        }
        
        //List <Sell> lis = ventasRepository.findByUser(clienteCont.objCliente.get().getIdClient());
       clo.get().restarCredito(ventasRepository.totalCompras(clienteCont.objCliente.get().getIdClient()));
      
      
        // Al final limpiamos el carrito
        this.limpiarCarrito(request);
        // e indicamos una venta exitosa
        redirectAttrs
                .addFlashAttribute("mensaje", "Venta realizada correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/vender/";
    }

   

   

    @PostMapping(value = "/agregar")
    public String agregarAlCarrito(@ModelAttribute Product producto, HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<ProductToSell> carrito = this.obtenerCarrito(request);
        Product productoBuscadoPorCodigo = productosRepository.findFirstByIdProduct(producto.getIdProduct());
        if (productoBuscadoPorCodigo == null) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "El producto con el código " + producto.getIdProduct() + " no existe")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/vender/";
        }
        if (productoBuscadoPorCodigo.sinExistencia()) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "El producto está agotado")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/vender/";
        }
        boolean encontrado = false;
        for (ProductToSell ProductToSellActual : carrito) {
            if (ProductToSellActual.getIdProduct()==(productoBuscadoPorCodigo.getIdProduct())) {
                ProductToSellActual.aumentarCantidad();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            carrito.add(new ProductToSell(productoBuscadoPorCodigo.getIdProduct(),productoBuscadoPorCodigo.getNameProduct(),
            		productoBuscadoPorCodigo.getQuantityProduct(),productoBuscadoPorCodigo.getPriceProduct(),
            		productoBuscadoPorCodigo.getCategory(), 1d));
        }
        this.guardarCarrito(carrito, request);
        return "redirect:/vender/";
    }
}
