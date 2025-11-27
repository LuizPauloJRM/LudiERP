package LudiERPhibernate;

import java.util.List;

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
		usuariopessoa.setNome("Roberto");
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
	
	//instanciando o daoGeneric e pessoa 
	//Teste delete , precisamos consultar antes de deletar 
	@Test
	public void deletarPorId() {
		
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuariopessoa = new Usuario();
		usuariopessoa.setId(2L);
		
		usuariopessoa = daoGeneric.deletarPorId(usuariopessoa);
		
		System.out.println(usuariopessoa);
	}
	
	@Test
	public void testeConsultar() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		
		List<Usuario> list = daoGeneric.listar(Usuario.class);
	
		for (Usuario usuariopessoa:list) {
			System.out.println(usuariopessoa);
			
		}
	
	}
	
	//Carregar todos objetos pessoas 
	@Test
	public void testeQueryList() {
		//Sempre iniciar o daoGeneric
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
//		List<Usuario> list = daoGeneric.getEntityManager().createQuery(" from Usuario").getResultList();
		List<Usuario> list = daoGeneric.getEntityManager().createQuery(" from Usuario where nome =  'Roberto'").getResultList();//Buscar onde nome seja especifico
	
		for (Usuario usuariopessoa : list) {
			System.out.println(usuariopessoa);
		}
	}
	
	//Ordenação  , resultados máximos definidos 
	// 4 pessoas ordenadas por nome	com order by nome e set max result
	@Test
	public void testeQueryListMaxResult() {
		//Sempre iniciar o daoGeneric
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
//		List<Usuario> list = daoGeneric.getEntityManager().createQuery(" from Usuario").getResultList();
		List<Usuario> list = daoGeneric.getEntityManager().createQuery(" from Usuario order by nome").setMaxResults(6).getResultList();//Busca ordenada por nome 
	
		for (Usuario usuariopessoa : list) {
			System.out.println(usuariopessoa);
		}
	}
}