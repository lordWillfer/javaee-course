package sv.gob.mh.sga.service;

import java.util.List;

import javax.ejb.Remote;

import sv.gob.mh.sga.domain.Persona;

@Remote
public interface PersonaServiceRemote {

	public List<Persona> listarPersonas();
	
	public Persona encontrarPersonaPorId(Persona persona);
	
	public Persona encontrarPerosnaPorEmail(Persona persona);
	
	public void registrarPersona(Persona persona);
	
	public void modificarPersona(Persona persona);
	
	public void eliminatPersona(Persona persona);
}