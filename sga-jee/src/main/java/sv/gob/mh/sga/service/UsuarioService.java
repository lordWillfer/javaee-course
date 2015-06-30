package sv.gob.mh.sga.service;

import java.util.List;

import javax.ejb.Local;

import sv.gob.mh.sga.domain.Usuario;

@Local
public interface UsuarioService {
	
	public List<Usuario> listarUsuarios();
	
	public Usuario encontrarUsuarioPorId(Usuario usuario);
	
	public Usuario encontrarUsuarioPorNombre(Usuario usuario);
	
	public void registrarUsuario(Usuario usuario);
	
	public void modificarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Usuario usuario);
}