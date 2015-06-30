package sv.gob.mh.sga.service;

import java.util.List;

import javax.ejb.Local;

import sv.gob.mh.sga.domain.Persona;

@Local
public interface PersonaService {

	public List<Persona> listarPersonas();
	
	public Persona encontrarPersonaPorId(Persona persona);
	
	public Persona encontrarPerosnaPorEmail(Persona persona);
	
	public void registrarPersona(Persona persona);
	
	public void modificarPersona(Persona persona);
	
	public void eliminarPersona(Persona persona);
}