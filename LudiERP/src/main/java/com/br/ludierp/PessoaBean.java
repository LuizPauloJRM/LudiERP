package com.br.ludierp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


//Mantem ate que se finalize a sua conexão com servidor
@ViewScoped
@ManagedBean(name="pessoaBean")
public class PessoaBean implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 private String nome;
 
 //Lista	
 private List<String> nomes = new ArrayList<String>();
 
 //Método 
 public String addNome() {
	 nomes.add(nome);
	 return "";
 }
 
 
 //Getters e Setters
 public String getNome() {
	return nome;
}
 public void setNome(String nome) {
	this.nome = nome;
}
 
 public List<String> getNomes() {
	return nomes;
}
 
 public void setNomes(List<String> nomes) {
	this.nomes = nomes;
}
 
}
