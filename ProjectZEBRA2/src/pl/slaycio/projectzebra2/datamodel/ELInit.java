package pl.slaycio.projectzebra2.datamodel;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


 

public class ELInit {

	  private static final String PERSISTENCE_UNIT_NAME = "ProjectZEBRA2";
	  private static EntityManagerFactory factory;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // read the existing entries and write to console
	    Query q = em.createQuery("select t from FinancialInstitution t");
	    List<FinancialInstitution> todoList = q.getResultList();
	    for (FinancialInstitution todo : todoList) {
	      System.out.println(todo);
	    }
	    System.out.println("Size: " + todoList.size());

	   
	    em.getTransaction().begin();
	    FinancialInstitution todo = new FinancialInstitution("dfs","b","c");
	    todo.setSymbol("DUUPA");
	    todo.setDescription("This is a test");
	    em.persist(todo);
	    em.getTransaction().commit();

	    em.close();
	    
	    
	    
	    EntityManager em2 = factory.createEntityManager();
		
	    em2.getTransaction().begin();
		//em.createQuery("DELETE FROM User p").executeUpdate();
		em2.persist(new User("Jeanne Calment", "ddd"));
		em2.persist(new User("Sarah Knauss", "eere"));
		em2.persist(new User("Lucy Hannah", "Sdsre"));
		em2.getTransaction().commit();
	    
		
		
		em2.close();
		
				
		
	}

}
