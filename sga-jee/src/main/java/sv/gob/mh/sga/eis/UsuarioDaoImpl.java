package sv.gob.mh.sga.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sv.gob.mh.sga.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllUsuarios() {
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@Override
	public Usuario findUsuarioById(Usuario usuario) {
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	@Override
	public Usuario findUsuarioByUsername(Usuario usuario) {
		return em.find(Usuario.class, usuario.getUsername());
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		em.merge(usuario);
	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		em.merge(usuario);
		em.remove(usuario);
	}
}