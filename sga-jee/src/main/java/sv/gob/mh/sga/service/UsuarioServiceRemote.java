package sv.gob.mh.sga.service;

import java.util.List;

import javax.ejb.Remote;

import sv.gob.mh.sga.domain.Usuario;

@Remote
public interface UsuarioServiceRemote {
	
	public List<Usuario> listarUsuarios();
	
	public Usuario encontrarUsuarioPorId(Usuario usuario);
	
	public Usuario encontrarUsuarioPorNombre(Usuario usuario);
	
	public void registrarUsuario(Usuario usuario);
	
	public void modificarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Usuario usuario);
}