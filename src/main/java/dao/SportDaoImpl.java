package dao;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Sport;
import util.JPAutil;


public class SportDaoImpl implements ISportDao{
	private EntityManager entityManager=JPAutil.getEntityManager("TP5_Sport");
	
	@Override
	public Sport save(Sport p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
		return p;
	}
	
	@Override
	public List<Sport> sportParMC(String mc) {
	    List<Sport> sports = entityManager.createQuery("SELECT s FROM SPORT s WHERE s.nomSport LIKE :mc")
	                                     .setParameter("mc", "%" + mc + "%")
	                                     .getResultList();
	    return sports;
	}
	@Override
	public Sport getSport(Long id) {
		return entityManager.find(Sport.class, id);
	
	}
	@Override
	public Sport updateSport(Sport p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
		return p;
	}

	@Override
	public void deleteSport(Long id) {
		Sport sp = entityManager.find(Sport.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(sp);
		entityManager.getTransaction().commit();
	}

}
