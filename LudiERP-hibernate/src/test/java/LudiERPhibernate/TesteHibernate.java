package LudiERPhibernate;

import org.junit.Test;

import LudiERPhibernate.dao.DaoGeneric;
import model.Usuario;

public class TesteHibernate {
	// Método
	@Test
	public void testeHibernateUtil() {
//		HibernateUtil.getEntityManager();
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		
		Usuario usuariopessoa = new Usuario();
		usuariopessoa.setIdade(26);
		usuariopessoa.setLogin("teste");
		usuariopessoa.setNome("Luiz");
		usuariopessoa.setSenha("123");
		usuariopessoa.setSobrenome("Medeiros");
		usuariopessoa.setEmail("luiz@email.com");	
	
		daoGeneric.salvar(usuariopessoa);
	}
}