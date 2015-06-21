package sv.gob.mh.sga.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import sv.gob.mh.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

	public List<Persona> listarPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona(1, "Juan", "Perez", "Suarez", "jperez@gmail.com", "55668798"));
		personas.add(new Persona(2, "Williams", "Fernández", "Rodríguez", "williamsenrique@gmail.com", "78605555"));
		return personas;
	}

	public Persona encontrarPersonaPorId(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona encontrarPerosnaPorEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registrarPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	public void modificarPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	public void eliminatPersona(Persona persona) {
		// TODO Auto-generated method stub

	}
}