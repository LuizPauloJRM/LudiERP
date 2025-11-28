package LudiERPhibernate;

import java.util.List;

import org.junit.Test;

import LudiERPhibernate.dao.DaoGeneric;
import model.TelefoneUser;
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

	// Metodo consulta
	@Test
	public void testeBuscar() {
		// instanciando o daoGeneric e pessoa
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuariopessoa = new Usuario();
		usuariopessoa.setId(2L);

		usuariopessoa = daoGeneric.pesquisar(usuariopessoa);

		System.out.println(usuariopessoa);
	}

	@Test
	public void testeUpdate() {
		// instanciando o daoGeneric e pessoa
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		Usuario usuariopessoa = new Usuario();
		usuariopessoa.setId(2L);

		usuariopessoa = daoGeneric.pesquisar(usuariopessoa);
		usuariopessoa.setIdade(18);
		usuariopessoa.setNome("Lucas");

		daoGeneric.updateMerge(usuariopessoa);

		System.out.println(usuariopessoa);
	}

	// instanciando o daoGeneric e pessoa
	// Teste delete , precisamos consultar antes de deletar
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

		for (Usuario usuariopessoa : list) {
			System.out.println(usuariopessoa);

		}

	}

	// Carregar todos objetos pessoas
	@Test
	public void testeQueryList() {
		// Sempre iniciar o daoGeneric
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
//		List<Usuario> list = daoGeneric.getEntityManager().createQuery(" from Usuario").getResultList();
		List<Usuario> list = daoGeneric.getEntityManager().createQuery(" from Usuario where nome =  'Roberto'")
				.getResultList();// Buscar onde nome seja especifico

		for (Usuario usuariopessoa : list) {
			System.out.println(usuariopessoa);
		}
	}

	// Ordenação , resultados máximos definidos
	// 4 pessoas ordenadas por nome com order by nome e set max result
	@Test
	public void testeQueryListMaxResult() {
		// Sempre iniciar o daoGeneric
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
//		List<Usuario> list = daoGeneric.getEntityManager().createQuery(" from Usuario").getResultList();
		List<Usuario> list = daoGeneric.getEntityManager().createQuery(" from Usuario order by nome").setMaxResults(6)
				.getResultList();// Busca ordenada por nome

		for (Usuario usuariopessoa : list) {
			System.out.println(usuariopessoa);
		}
	}

	// Método de lista de usuario setar um parametro condicionais
	@Test
	public void testeQueryListParameter() {
		// Dao
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();

		List<Usuario> list = daoGeneric.getEntityManager()
				.createQuery("from Usuario where nome = :nome or sobrenome = :sobrenome").setParameter("nome", "Bruna")
				.getResultList();
//				.setParameter("sobrenome","Paulo")

		for (Usuario usuario : list) {
			System.out.println(usuario);
		}
	}

	// Soma
	@Test
	public void TesteQuerySomaIdade() {
		DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
		// seleciona , soma todas as idades da tabela usuario retorna o result somente 1
		// singleresult
		Long somaIdade = (Long) daoGeneric.getEntityManager().createQuery("select sum(u.idade) from Usuario u ")
				.getSingleResult();
		System.out.println("Soma de todas as idades é " + somaIdade);
	}
	
	//Salvando telefone
	@Test
	public void testeGravaTelefone() {
		
		// 1. DAO para buscar o usuário (específico para Usuario)
		DaoGeneric<Usuario> daoUsuario = new DaoGeneric<Usuario>();
		
		// 2. DAO para salvar o telefone (específico para TelefoneUser)
		DaoGeneric<TelefoneUser> daoTelefone = new DaoGeneric<TelefoneUser>(); 
		
		// 3. Pesquisar o usuário (usando a assinatura correta do seu método pesquisar(E entidade))
		Usuario usuarioParaBuscar = new Usuario();
		usuarioParaBuscar.setId(1L); 
		Usuario usuario = daoUsuario.pesquisar(usuarioParaBuscar);
		
		// 4. Corrigir a inicialização da classe (capitalização correta)
		TelefoneUser telefoneUser = new TelefoneUser();
		telefoneUser.setTipo("casa");
		telefoneUser.setNumero("84756987");
		telefoneUser.setUsuario(usuario);
		
		// 5. Usar o DAO correto (daoTelefone) para salvar
		daoTelefone.salvar(telefoneUser);
		
//		System.out.println("Telefone salvo com sucesso para o usuário ID 3L.");
	}
	@Test
    public void testeCarregarTelefonesDoUsuario() {
        DaoGeneric<Usuario> daoUsuario = new DaoGeneric<Usuario>();
        
        // 1. Criar objeto temporário apenas com o ID para buscar
        Usuario usuarioParaBuscar = new Usuario();
        usuarioParaBuscar.setId(1L); // Substitua L pelo ID do usuário que você salvou telefones

        // 2. Pesquisar o usuário (isso carrega o objeto completo do banco)
        Usuario usuario = daoUsuario.pesquisar(usuarioParaBuscar);

        // 3. Acessar a lista de telefones diretamente do objeto Usuario
        // O Hibernate fará um SELECT na tabela TelefoneUser automaticamente nos bastidores
        for (TelefoneUser telefone : usuario.getTelefoneUsers()) {
            System.out.println("Telefone: " + telefone.getNumero() + " (" + telefone.getTipo() + ")");
            System.out.println("Do Usuário: " + telefone.getUsuario().getNome());
        }
    }


}
