package com.br.ludierp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
//import javax.faces.bean.ViewScoped;
//import javax.faces.bean.SessionScoped;


//Mantem os dados ate que se finalize a sua conexão com servidor
//@ViewScoped

//Mantem os dados em outras seções do usuário


//Todos os usuário vao compartilhar esses dados
//@ApplicationScoped
@SessionScoped
@ManagedBean(name="pessoaBean")
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

 private String nome;
 
 public HtmlCommandButton commandButton;
 
 //Lista	
 private List<String> nomes = new ArrayList<String>();
 
 //Método 
 public String addNome() {
	 nomes.add(nome);
	 //Mais de 3 nomes desabilitar botão de comando 
	 if (nomes.size()> 3 ) {
		 commandButton.setDisabled(true);
		 return "login";
	 }
	 return ""; //Retorno null ou vazio mesma página
 }
 
 
 public void setCommandButton(HtmlCommandButton commandButton) {
	this.commandButton = commandButton;
}
 public HtmlCommandButton getCommandButton() {
	return commandButton;
}
 
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
