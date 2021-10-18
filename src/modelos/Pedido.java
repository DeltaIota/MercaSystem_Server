package modelos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
    private int idPedido;
    private EstadoPedido estadoPedido;
    private Proveedor proveedor;
    private List<Linea> listaPedido;
    private Date fechaPedido;
    private Date fechaEntrega;
    
    public Pedido() {
	idPedido = 0;
	setEstadoPedido(EstadoPedido.PENDIENTE);
	proveedor = new Proveedor();
	listaPedido = new ArrayList<>();
	fechaPedido = Date.valueOf(LocalDate.now());
    }
    
    public Pedido(int idPedido, EstadoPedido estadoPedido, Proveedor proveedor, List<Linea> listaPedido, 
	    	  double precioTotal, Date fechaPedido) {
    	this.idPedido = idPedido;
    	setEstadoPedido(estadoPedido);
    	this.proveedor = proveedor;
    	this.listaPedido = listaPedido;
    	this.fechaPedido = fechaPedido;
    }
    
    public Pedido(int idPedido, EstadoPedido estadoPedido, Proveedor proveedor, List<Linea> listaPedido, 
	    	  double precioTotal, Date fechaPedido, Date fechaEntrega) {
	this.idPedido = idPedido;
    	setEstadoPedido(estadoPedido);
    	this.proveedor = proveedor;
    	this.listaPedido = listaPedido;
    	this.fechaPedido = fechaPedido;
    	setFechaEntrega(fechaEntrega);
    }
    
    public int getIdPedido() {
    	return idPedido;
    }
    
    public EstadoPedido getEstadoPedido() {
    	return estadoPedido;
    }
    
    public void setEstadoPedido(EstadoPedido estadoPedido) {
    	this.estadoPedido = estadoPedido;
    }
    
    public Proveedor getProveedor() {
    	return proveedor;
    }
    
    public double getPrecioTotal() {
	double res = 0;
	for (Linea l : listaPedido) {
	    res += l.getPrecioCompra();
	}
    	return res;
    }
    
    public Date getFechaPedido() {
    	return fechaPedido;
    }
    
    public Date getFechaEntrega() {
    	return fechaEntrega;
    }
    
    public void setFechaEntrega(Date fechaEntrega) {
    	this.fechaEntrega = fechaEntrega;
    }

    public List<Linea> getListaPedido() {
	return listaPedido;
    }
}
