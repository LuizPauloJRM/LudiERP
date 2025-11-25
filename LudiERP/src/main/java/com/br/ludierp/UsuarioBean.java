package com.br.ludierp;

import java.util.Date;

import javax.faces.bean.ManagedBean;

//Classe bean sempre com anotação para se tornar um controlador 

//Javax : ManagedBean 
@ManagedBean(name="usuarioBean")
public class UsuarioBean {
	//Receber dados da tela 
	private String nome;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	private Date dataNascimento;
	
	//Getters e Setters 
	//Atributos 
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setAtivo(boolean ativo) {
	}
	
}
