package com.br.ludierp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.br.ludierp.util.JPAUtil;

public class DaoGeneric <E>{
	//método salvar 
	public void salvar (E entidade ) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		
		entityTransaction.commit();
		entityManager.close();
	}
}
