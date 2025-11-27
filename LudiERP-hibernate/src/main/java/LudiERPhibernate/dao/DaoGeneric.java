package LudiERPhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import LudiERPhibernate.HibernateUtil;
import model.Usuario;

//Padrão para metodo de persistencia 
//salvar ,excluir ... 
public class DaoGeneric<E> {

	// instanciar o entity ter o EntityManager
	private EntityManager entityManager = HibernateUtil.getEntityManager();

	// Método de salvar , receber entidade geerica
	public void salvar(E entidade) {
		// Transação, iniciar a transação
		/**
		 * begin para iniciar a transação salvar persist entidade transação e commit
		 * para salvar no banco
		 */
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);// salvar
		transaction.commit();

	}

	// Atualizar ou salva uso do merge com retorno de um objeto
	// entityManager.merge(entidade);
	public E updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		// Salva e retorna , da o merge, commit la no banco e retorna salva la no banco
		// de dados
		return entidadeSalva;
	}

	// Consultar no banco "find"
	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;

	}

	// Criar delete
	// Criando um método por deletar
	// Criar o método e receber essa entidade
	public Usuario deletarPorId(E entidade) {
		// Identificar o id
		Object id = HibernateUtil.getPrimaryKey(entidade);

		// Criando a transação
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.createNativeQuery(
				"delete from " + entidade.getClass().getSimpleName().toLowerCase() + 
				" where id=" + id).executeUpdate();//Delete ,executa a atualização
		transaction.commit();//Grava as alterações 
		return null;
	}
	//Consultar todos , retornar List para consultar todos 
	public List<E> listar(Class<E> entidade){
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();
		
		return lista;
	}
	
	
	//Acesso global do entityManager
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	

}
