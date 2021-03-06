package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import sv.gob.mh.sga.domain.Persona;
import sv.gob.mh.sga.service.PersonaService;

public class PersonaServiceTest {

	private PersonaService personaService;
	
	@Before
	public void setUp() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		personaService = (PersonaService) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!sv.gob.mh.sga.service.PersonaService");
	}
	
	@Test
	public void testEJBPersonaService() {
		System.out.println("Iniciando test EJB PersonaService");
		
		assertTrue(personaService != null);
		
		assertEquals(3, personaService.listarPersonas().size());
		
		System.out.println("El número de personas es igual a: " + personaService.listarPersonas().size());
		this.desplegarPersonas(personaService.listarPersonas());
		
		System.out.println("Fin test EJB PersonaService");
	}

	private void desplegarPersonas(List<Persona> personas) {
		for (Persona persona: personas) {
			System.out.println(persona);
		}
	}
}