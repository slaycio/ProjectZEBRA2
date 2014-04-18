package pl.slaycio.projectzebra2.UI;


import pl.slaycio.projectzebra2.datamodel.User;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class adminTab  extends Panel {

	
	
	public adminTab() {
		this.setSizeFull();
		VerticalLayout adminContent = new VerticalLayout();
		this.setContent(adminContent);
		
		/*
		adminContent.addComponent(new Label("to jest admin taba o jjjjeeeee  "+ Account.columnNames.size() ));
		
				
		
		Table testT = new Table();
		
				
		for (int s = 0; s < Account.columnNames.size(); s++) {
			testT.addContainerProperty(Account.columnNames.get(s),String.class, null);		
					
				}
		
		testT.addItem(new Object[] {"dupp", "duppdesc", "fajne","Pawe³", "mBank", "mBank", "o tak","sedccc", "bank","fdfgfd"}, new Integer(1));
		//TODO Obiekty musz¹ siê zwracac jako containery by mozna je dowi¹zaæ ³adnie - do tego musz¹ reagowac na zmiany wartoœci i siekaæ od razu przez DAO do bazy
		// tutaj byla jeszcze druga linia wiec sprawdze commita
		adminContent.addComponent(testT);
		*/
		
		ComboBox cmb = new ComboBox();
		adminContent.addComponent(cmb);
		ComboBox cmb1 = new ComboBox();
        cmb1.addItem("pierwsza wartosc");	
		
        Table ctl = new Table();
		ctl.addContainerProperty("tsswrwerwerwerwes", ComboBox.class, null);
		
		ctl.addItem(cmb1);
		adminContent.addComponent(ctl);
		
				
		//factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    //EntityManager em = factory.createEntityManager();
		
	    //em.getTransaction().begin();
		//em.createQuery("DELETE FROM User p").executeUpdate();
		//em.persist(new TransactionEntity("Jeanne Calment", "ddd"));
		//em.persist(new TransactionEntity("Sarah Knauss", "eere"));
		//em.persist(new TransactionEntity("Lucy Hannah", "Sdsre"));
		//em.getTransaction().commit();
	    
		// Create a persistent person container
		JPAContainer<User> entis = JPAContainerFactory.make(User.class, "ProjectZEBRA2");

		//entis.addNestedContainerProperty("faking.nejm"); 
		
		
		//EntityManager em = JPAContainerFactory.createEntityManagerForPersistenceUnit("ProjectZEBRA2");
		
		
		//em.getTransaction().begin();
		
		Label wyniki = new Label();
		adminContent.addComponent(wyniki);
		//wyniki.setValue(em.toString());
		
		Label wyniki2 = new Label();
		adminContent.addComponent(wyniki2);
		wyniki2.setValue(entis.toString());
		
		Label wyniki3 = new Label();
		adminContent.addComponent(wyniki3);
		User fff = new User("dupa","cycce");
		//em.persist(fff);
		//entis.refresh();
		
		wyniki3.setValue("jrebel worksoor noti co s");
		
	//	wyniki3.setValue(fff.toString());
		
		
		//EntityItem<User> costam33 = entis.getItem(9);
		
		// You can add entities to the container as well
		entis.addEntity(fff);
		
		//EntityProvider<TransactionEntity> blee = entis.getEntityProvider();
		//blee.getAllEntityIdentifiers(entis, null, null).toString();

		//System.out.println("Size: " + costam33.toString());
		
		
				 
		// Bind it to a component
		//Table userTable = new Table("The Persistent users");
		Table userTable = new Table("The Persistent users", entis);
		//userTable.setVisibleColumns(new String[]{"id","user","password"});
		userTable.setEditable(true);
		adminContent.addComponent(userTable);
		
		//em.close();
		
		
	}

}
