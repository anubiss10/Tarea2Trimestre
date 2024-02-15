	// ObjectDBServiceImpl.java
	package com.cesur.dam.bbdd.services;
	
	import com.cesur.dam.bbdd.entities.entitiesobjectdb.AseguradorasOB;
	import com.cesur.dam.bbdd.entities.entitiesobjectdb.ClientesOB;
	import com.cesur.dam.bbdd.entities.entitiesobjectdb.Apuntes;
	import com.cesur.dam.bbdd.entities.entitiesobjectdb.Poliza;
import com.cesur.dam.bbdd.entities.entitiesobjectdb.SiniestroOB;

import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.TypedQuery;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	
	import org.springframework.stereotype.Service;
	
	import java.util.List;
	
	@Service
	public class ObjectDBServiceImpl implements ObjectdbService {
	
	    @PersistenceContext
	    private EntityManager entityManager;
	
	    
	    public AseguradorasOB crearAseguradora(AseguradorasOB aseguradora) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:apuntes.odb");
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	
	        em.persist(aseguradora);
	
	        em.getTransaction().commit();
	        em.close();
	        emf.close();
	
	        return aseguradora;
	    }
	    public void crearCliente(ClientesOB cliente) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:apuntes.odb");
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	
	        em.persist(cliente);
	
	        em.getTransaction().commit();
	        em.close();
	        emf.close();
	    }
	    public List<Poliza> obtenerPolizasPorCliente(Long clienteId) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:apuntes.odb");
	        EntityManager em = emf.createEntityManager();
	        try {
	            TypedQuery<Poliza> query = em.createQuery(
	                "SELECT p FROM Poliza p WHERE p.cliente.id = :clienteId", Poliza.class)
	                .setParameter("clienteId", clienteId);
	            return query.getResultList();
	        } finally {
	            em.close();
	            emf.close();
	        }
	    }
	    public void crearDatosDeEjemplo() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:apuntes.odb");
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();

	        try {
	            // Crear clientes de ejemplo
	            ClientesOB cliente1 = new ClientesOB();
	            cliente1.setNombre("Juan Pérez");
	            em.persist(cliente1);

	            ClientesOB cliente2 = new ClientesOB();
	            cliente2.setNombre("María García");
	            em.persist(cliente2);

	            // Crear aseguradoras de ejemplo
	            AseguradorasOB aseguradora1 = new AseguradorasOB();
	            aseguradora1.setNombre("Seguros XYZ");
	            em.persist(aseguradora1);

	            AseguradorasOB aseguradora2 = new AseguradorasOB();
	            aseguradora2.setNombre("Seguros ABC");
	            em.persist(aseguradora2);
	            Poliza poliza1 = new Poliza();
	            poliza1.setTipo("Seguro de vida");
	            poliza1.setCliente(cliente1);
	            poliza1.setAseguradora(aseguradora1);
	            em.persist(poliza1);

	            Poliza poliza2 = new Poliza();
	            poliza2.setTipo("Seguro de automóvil");
	            poliza2.setCliente(cliente2);
	            poliza2.setAseguradora(aseguradora2);
	            em.persist(poliza2);

	            // Crear siniestros de ejemplo
	            SiniestroOB siniestro1 = new SiniestroOB();
	            siniestro1.setDescripcion("Accidente de tráfico");
	            siniestro1.setCliente(cliente1);
	            em.persist(siniestro1);

	            SiniestroOB siniestro2 = new SiniestroOB();
	            siniestro2.setDescripcion("Incendio en casa");
	            siniestro2.setCliente(cliente2);
	            em.persist(siniestro2);

	            // Commit de transacción
	            em.getTransaction().commit();
	        } catch (Exception ex) {
	            // Manejar excepciones
	            if (em.getTransaction().isActive()) {
	                em.getTransaction().rollback();
	            }
	            ex.printStackTrace();
	        } finally {
	            em.close();
	            emf.close();}
	        }
	        public List<SiniestroOB> obtenerSiniestrosPorCliente(Long clienteId) {
	            EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:apuntes.odb");
	            EntityManager em = emf.createEntityManager();
	            try {
	                TypedQuery<SiniestroOB> query = em.createQuery(
	                    "SELECT s FROM SiniestroOB s WHERE s.cliente.id = :clienteId", SiniestroOB.class)
	                    .setParameter("clienteId", clienteId);
	                return query.getResultList();
	            } finally {
	                em.close();
	                emf.close();
	            } }
	    
	}
