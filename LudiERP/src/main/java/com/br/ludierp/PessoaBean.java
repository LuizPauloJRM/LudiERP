package com.br.ludierp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.ludierp.dao.DaoGeneric;
import com.br.ludierp.entidades.Pessoa;


//Mantem os dados ate que se finalize a sua conexão com servidor
//@ViewScoped

//Mantem os dados em outras seções do usuário


//Todos os usuário vao compartilhar esses dados
//@ApplicationScoped
@ViewScoped
@ManagedBean(name="pessoaBean")
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	
	//Método salvar 
	public String salvar() {
		daoGeneric.salvar(pessoa);
		return "";
	}
	
	//Getters  e Setters 
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}
	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
}
