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
	
	//Metodo consulta 
	@Test
	public void testeBuscar() {
		//instanciando o daoGeneric e pessoa 
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuariopessoa = new Usuario();
		usuariopessoa.setId(2L);
		
		usuariopessoa = daoGeneric.pesquisar(usuariopessoa);
		
		System.out.println(usuariopessoa);
	}
	
	@Test
	public void testeUpdate() {
		//instanciando o daoGeneric e pessoa 
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuariopessoa = new Usuario();
		usuariopessoa.setId(2L);
		
		usuariopessoa = daoGeneric.pesquisar(usuariopessoa);
		usuariopessoa.setIdade(18);
		usuariopessoa.setNome("Lucas");
		
		daoGeneric.updateMerge(usuariopessoa);
		
		System.out.println(usuariopessoa);
	}
	
	
}