package beans.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import beans.dominio.Persona;

public class ClienteEntidadPersona {

	public static void main(String[] args) {
		Logger log = Logger.getLogger("PruebaClienteEntidadPersona");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// No se debe especificar el ID, ya que se genera en automático
		Persona persona1 = new Persona("Oscar", "Gomez", "Larios", "ogomez@mail.com.mx", "55780109");
		log.debug("Objeto a persistir: " + persona1);
		em.persist(persona1);
		tx.commit();
		log.debug("Objeto persistido: " + persona1);
		em.close();
	}
}