package pe.edu.upc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sell {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fechaYHora;

    @OneToMany(mappedBy = "sell", cascade = CascadeType.ALL)
    private Set<ProductSelled> productos;
    

    public Sell() {
        this.fechaYHora = Useful.obtenerFechaYHoraActual();
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
