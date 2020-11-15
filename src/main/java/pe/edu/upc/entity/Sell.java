package pe.edu.upc.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Sell {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fechaYHora;

    @OneToMany(mappedBy = "sell", cascade = CascadeType.ALL)
    private Set<ProductSelled> productos;
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaCompra", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date fechaCompra;
	
	private Double interes;
	
    public Sell(Client client) {
        this.fechaYHora = Useful.obtenerFechaYHoraActual();
    	this.client = client;
    	this.fechaCompra=new Date();
    	this.interes=(double) 0;
    	
}
    
    
    public void sumarInteres(Double monto) {
    	this.interes +=monto;
    }




	public Date getFechaCompra() {
		return fechaCompra;
	}





	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}





	public Double getInteres() {
		return interes;
	}





	public void setInteres(Double interes) {
		this.interes = interes;
	}





	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        Double total = (double) 0;
        for (ProductSelled productoVendido : this.productos) {
            total += productoVendido.getTotal();
        }
        return total;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Set<ProductSelled> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductSelled> productos) {
        this.productos = productos;
    }
}
