package sv.gob.mh.sga.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sv.gob.mh.sga.domain.Usuario;
import sv.gob.mh.sga.eis.UsuarioDao;

@Stateless
public class UsuarioServiceImpl implements UsuarioService, UsuarioServiceRemote {

	@EJB
	private UsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDao.findAllUsuarios();
	}

	@Override
	public Usuario encontrarUsuarioPorId(Usuario usuario) {
		return usuarioDao.findUsuarioById(usuario);
	}

	@Override
	public Usuario encontrarUsuarioPorNombre(Usuario usuario) {
		return usuarioDao.findUsuarioByUsername(usuario);
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		usuarioDao.insertUsuario(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		usuarioDao.updateUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		usuarioDao.deleteUsuario(usuario);
	}
}