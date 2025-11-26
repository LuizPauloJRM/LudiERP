package LudiERPhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Quando o projeto subir ou alteração no banco
//Essa classe e chamada e ela ler o persistence
	public class HibernateUtil {
		public static EntityManagerFactory factory = null;
		static {
			init();
		}
		
		private static void init() {
			try {
				if(factory == null) {
					factory = Persistence.createEntityManagerFactory("LudiERP-hibernate");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//Retornar aplicação 
		public static EntityManager getEntityManager(){
			return factory.createEntityManager();//Prove parte de persistencia 
		}
}
