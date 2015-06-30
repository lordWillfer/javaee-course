package sv.gob.mh.sga.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sv.gob.mh.sga.domain.Persona;
import sv.gob.mh.sga.eis.PersonaDao;

@Stateless
public class PersonaServiceImpl implements PersonaService, PersonaServiceRemote {

	@EJB
	private PersonaDao personaDao;
	
	@Override
	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	@Override
	public Persona encontrarPerosnaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}

	@Override
	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	@Override
	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

	@Override
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}
}