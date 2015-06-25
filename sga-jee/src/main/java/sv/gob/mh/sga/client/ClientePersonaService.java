package sv.gob.mh.sga.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sv.gob.mh.sga.domain.Persona;
import sv.gob.mh.sga.service.PersonaServiceRemote;

public class ClientePersonaService {
 
	public static void main(String[] args) {
		System.out.println("Iniciando llamada al EJB desde el cliente\n");
		try {
			Context jndi = new InitialContext();
			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!sv.gob.mh.sga.service.PersonaServiceRemote");
			
			List<Persona> personas = personaService.listarPersonas();
			
			for (Persona persona: personas) {
				System.out.println(persona.toString());
			}
			
			System.out.println("\nFin llamada al EJB desde el cliente.");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
