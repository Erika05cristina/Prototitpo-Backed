package ec.edu.ups.ppw.demojakarta.business;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.ClienteDAO;
import ec.edu.ups.ppw.demojakarta.model.Cliente;
import ec.edu.ups.ppw.demojakarta.services.Respuesta;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@Stateless
public class GestionClientes {
	  @Inject
	    private ClienteDAO daoCliente;
	    
	  
	  //Aqui se aplica la logica y validaciones
		
	 /* public Cliente getClientes(String cedula) throws Exception {
			if(cedula.length() != 10) {
				 Response.status(593).entity(new Respuesta(Respuesta.ERROR, "Cedula Incorrecta")).build();
				throw new Exception("Cedula Incorrecta");
			}
			
			Cliente cliente = daoCliente.read(cedula);
			
			if(cliente == null)
			{
				Response.status(593).entity(new Respuesta(Respuesta.ERROR, "Cliente no existe")).build();
				throw new Exception("Cliente no existe");
			}
				
			return cliente;
		}
	  */
	  
	    public Cliente getCliente(String cedula) throws Exception {
			if(cedula.length() != 10) {
				
				throw new Exception("Cedula Incorrecta");
			}
			
			Cliente cliente = daoCliente.read(cedula);
			if(cliente == null)
				throw new Exception("Cliente no existe");
			return cliente;
		}
		
		public List<Cliente> getClientes(){
			return daoCliente.getAll();
		}
		
		public void createCliente(Cliente cliente) throws Exception {
			if(cliente.getCedula().length() != 10) {
				throw new Exception("Cedula Incorrecta");
			}			
			daoCliente.insert(cliente);
		}
		

		public void deleteCliente(String cedula) throws Exception{
			Cliente cliente = daoCliente.read(cedula);
			if(cliente == null) {				
				throw new Exception("Cliente no existe");
			}
			else {
				daoCliente.delete(cedula);
			}
			
		}
		
		public void updateCliente(Cliente cliente) throws Exception {
	        Cliente existingCliente = daoCliente.read(cliente.getCedula());
	        if (existingCliente == null) {
	            throw new Exception("Cliente no existe");
	        } else {
	            daoCliente.update(cliente);
	        }
	    }


}