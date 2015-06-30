package sv.gob.mh.sga.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sv.gob.mh.sga.domain.Usuario;
import sv.gob.mh.sga.service.UsuarioServiceRemote;

public class ClienteUsuarioService {
	
	public static void main(String[] args) {
		System.out.println("Iniciando llamada al EJB desde el cliente\n");
		try {
			Context jndi = new InitialContext();
			UsuarioServiceRemote usuarioService = (UsuarioServiceRemote) jndi.lookup("java:global/sga-jee/UsuarioServiceImpl!sv.gob.mh.sga.service.UsuarioServiceRemote");
			
			List<Usuario> usuarios = usuarioService.listarUsuarios();
			
			for (Usuario usuario: usuarios) {
				System.out.println(usuario.toString());
			}
			
			System.out.println("\nFin llamada al EJB desdel el cliente");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}