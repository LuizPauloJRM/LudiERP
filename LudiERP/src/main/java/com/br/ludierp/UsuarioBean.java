package com.br.ludierp;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

//Classe bean sempre com anotação para se tornar um controlador 

//Javax : ManagedBean 
@ManagedBean(name="usuarioBean")

//Anotando com Scope padrão : O bean vive apenas durante uma única requisição HTTP. É o escopo padrão.
@RequestScoped
public class UsuarioBean {
	//Receber dados da tela 
	private String nome;
	private String sobrenome;
	private String nomeCompleto;
	private String email;
	private String login;
	
	//Método
	public void mostrarNome(){
		nomeCompleto=nome+" "+sobrenome;
		return;
	}
	
	//Getters e Setters 
	//Atributos 
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	private String senha;
	private Date dataNascimento;
	
	
	
}
