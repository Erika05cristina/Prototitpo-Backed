package ec.edu.ups.ppw.demojakarta.views;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.business.GestionClientes;
import ec.edu.ups.ppw.demojakarta.model.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.core.Response;

@Named("clientes")
@RequestScoped
public class VistaClientes {
	
	@Inject
	private GestionClientes gClientes;
	
	private Cliente persona = new Cliente();
	
	private List<Cliente> listado;
	
	
	public GestionClientes getgClientes() {
		return gClientes;
	}
	public void setgClientes(GestionClientes gClientes) {
		this.gClientes = gClientes;
	}
	public List<Cliente> getListado() {
		return listado;
	}
	
	@PostConstruct
	public void init () {
		listado=gClientes.getClientes();
	}
	
	
	public void setListado(List<Cliente> listado) {
		this.listado = listado;
	}
	
	public Cliente getPersona() {
		return persona;
	}
	public void setPersona(Cliente persona) {
		this.persona = persona;
	}
	
	
	public String guardar() {
		System.out.println(this.persona);
		

		try {
			gClientes.createCliente(persona);
			return "listadoclientes?faces-redirect=true" ;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
			
	}
	
	
}
