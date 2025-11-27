package LudiERPhibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import LudiERPhibernate.HibernateUtil;

//Padrão para metodo de persistencia 
//salvar ,excluir ... 
public class DaoGeneric<E>{
	
	//instanciar o entity ter o EntityManager 
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	//Método de salvar , receber entidade geerica 
	public void salvar(E entidade) {
		//Transação, iniciar a transação
		/**
		 * begin para iniciar a transação 
		 * salvar persist entidade 
		 * transação e commit para salvar no banco 
		 */
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
		
	}

}
