package com.br.ludierp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Entrega cria o novo EntityManager
// metodo para acessar
/**
 * EntityManagerFactory → cria o EntityManager  EntityManager → executa as
 * operações no banco
 * 
 */
public class JPAUtil {
	// Instanciar um atributo estatico , cria entity managers le o persistence
	private static EntityManagerFactory factory;
	// bloco estatico ,é executado uma vez assim que esta classe é carregada
	// se não existir cria o LudiERP nome da unidade de persistencia definida
	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("LudiERP");

		}

	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
