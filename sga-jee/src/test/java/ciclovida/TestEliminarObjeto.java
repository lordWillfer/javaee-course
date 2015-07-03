package ciclovida;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sv.gob.mh.sga.domain.Persona;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEliminarObjeto {

	static EntityManager em = null;
	static EntityTransaction tx = null;
	static EntityManagerFactory emf = null;
	Logger log = Logger.getLogger("TestEliminarObjeto");

	@BeforeClass
	public static void init() throws Exception {
		EJBContainer.createEJBContainer();
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}

	@Before
	public void setup() {
		try {
			em = emf.createEntityManager();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testActualizarObjetoSesionLarga() {

		// Paso 1. Inicia transacci�n 1
		EntityTransaction tx1 = em.getTransaction();
		tx1.begin();

		// Paso 2. Ejecuta SQL de tipo select
		Persona persona1 = em.find(Persona.class, 23);

		// Paso 3. Termina transacci�n 1
		tx1.commit();

		// Objeto en estado detached
		log.debug("Objeto recuperado:" + persona1);

		// Paso 4. Incia transacci�n 2
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();

		// Paso 5. Ejecuta SQL (es un delete)
		em.remove(persona1);

		// Paso 6. Termina transacci�n 2
		// Al momento de hacer commit, 
		//se realiza el delete
		tx2.commit();

		// Objeto en estado detached ya modificado
		//Ya no es posible resincronizarlo en otra transacci�n
		//Solo est� en memoria, pero al terminar el m�todo se eliminar�
		log.debug("Objeto eliminado:" + persona1);
	}

	@After
	public void tearDown() throws Exception {
		if (em != null) {
			em.close();
		}
	}
}