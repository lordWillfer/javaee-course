package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import sv.gob.mh.sga.domain.Usuario;
import sv.gob.mh.sga.service.UsuarioService;

public class UsuarioServiceTest {
	
	private UsuarioService usuarioService;
	
	@Before
	public void setUp() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		usuarioService = (UsuarioService) contenedor.getContext().lookup("java:global/classes/UsuarioServiceImpl!sv.gob.mh.sga.service.UsuarioService");
	}
	
	@Test
	public void testEJBUsuarioService() {
		System.out.println("Iniciando test EJB UsuarioService");
		
		assertTrue(usuarioService != null);
		
		assertEquals(1, usuarioService.listarUsuarios().size());
		
		System.out.println("El númerso de usuarios es igual a: " + usuarioService.listarUsuarios().size());
		this.desplegarUsuarios(usuarioService.listarUsuarios());
		
		System.out.println("Fin test EJB UsuarioService");
	}

	private void desplegarUsuarios(List<Usuario> usuarios) {
		for (Usuario usuario: usuarios) {
			System.out.println(usuario);
		}
	}
}