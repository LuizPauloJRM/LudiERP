package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Entity para virar tabela no banco de dados 
//Vamos relacionar essa classe telefone ao Usuario
@Entity
public class TelefoneUser {
	
	//Chave primaria , estrategia automatica do banco 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//Obrigatorio informar tipo e numero 
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String numero;
	//Criar tabela com chave estrangeira ManyToOne
	//Indicar que é muitos para um usuario ManytoOne
	//Instanciar o objeto para dize quem se refere o telefone 
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Usuario usuario;

	
	
	
	//Getters e Setters 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	



	
	
}
