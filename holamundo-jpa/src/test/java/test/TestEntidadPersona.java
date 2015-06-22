package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import beans.dominio.Persona;

public class TestEntidadPersona {

	static EntityManager em = null;
	static EntityTransaction tx = null;
	static EntityManagerFactory emf = null;
	Logger log = Logger.getLogger("TestEntidadPersona");

	@BeforeClass
	public static void init() throws Exception {
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}

	@Before
	public void setup() {
		try {
			em = emf.createEntityManager();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPersonaEntity() {
		log.debug("Iniciando Test Persona Entity con JPA");

		assertTrue(em != null);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// No debemos especificar el Id, este se generará automáticamente.
		Persona persona1 = new Persona("Angelica", "Lara", "Gomez", "alara@mail.com", "55669913");

		log.debug("Objeto a persistir: " + persona1);

		em.persist(persona1);
		tx.commit();

		log.debug("Objeto persistido: " + persona1);
		log.debug("Fin Test Persona Entity con JPA");
	}

	@After
	public void tearDown() throws Exception {
		if (em != null) {
			em.close();
			}
	}
}