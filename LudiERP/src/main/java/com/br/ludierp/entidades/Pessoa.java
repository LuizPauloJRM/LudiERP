package com.br.ludierp.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//Transformar em tabela no banco de dados
@Entity
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// Dados pessoa , precisa ter um id no banco
	//Anotados com ID para separar os registros 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome; 
	private String sobrenome;
	private Integer idade;
	
	//Definição de tempo data 
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	//Construtor vazio  valores padrão para suas propriedades
	public Pessoa () {
		
	}
	
	//Getters e setters 
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
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * sobrescrevê-los juntos, pois hashCode() é usado
	 *  para determinar o "bucket" (local de armazenamento) 
	 *  de um objeto e equals() é usado para confirmar
	 *  se dois objetos nesse bucket são realmente iguais. 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
