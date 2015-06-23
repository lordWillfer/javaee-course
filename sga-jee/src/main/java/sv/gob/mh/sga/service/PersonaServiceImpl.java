package sv.gob.mh.sga.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sv.gob.mh.sga.domain.Persona;
import sv.gob.mh.sga.eis.PersonaDao;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

	@EJB
	private PersonaDao personaDao;
	
	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

	public Persona encontrarPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	public Persona encontrarPerosnaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}

	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

	public void eliminatPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}
}