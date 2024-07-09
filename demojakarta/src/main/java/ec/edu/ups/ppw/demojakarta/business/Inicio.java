package ec.edu.ups.ppw.demojakarta.business;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.ClienteDAO;
import ec.edu.ups.ppw.demojakarta.model.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@PostConstruct
	public void init() {
		System.out.println("hola mundo ejb");
		
		Cliente cliente = new Cliente();
		cliente.setCedula("0106411937");
		cliente.setNombre("Erika Villa");
		cliente.setDireccion("Ricaurte");
		
		Cliente cliente1 = new Cliente();
		cliente1.setCedula("5205656021");
		cliente1.setNombre("Andres Villa");
		cliente1.setDireccion("Ricaurte");
		
		daoCliente.insert(cliente);
		daoCliente.insert(cliente1);
		
		
		List<Cliente> listado = daoCliente.getAll();
		for(Cliente cli: listado) {
			System.out.println(cli.getCedula() + " " + cli.getNombre());
		}
	}	
}
