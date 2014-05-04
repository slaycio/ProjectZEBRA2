package pl.slaycio.projectzebra2.datamodel;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public final class DataModel {

	//System.out.println("RIL PO: " +valueProperty.substring(valueProperty.indexOf(".")+1));
	
	public final static JPAContainer<AccountOwner> accountOwners = JPAContainerFactory.make(AccountOwner.class, "ProjectZEBRA2");
	public final static JPAContainer<User> users = JPAContainerFactory.make(User.class, "ProjectZEBRA2");
	
	public static void initializeDataModel(){
		users.addNestedContainerProperty("accountOwner.name");
		users.addNestedContainerProperty("accountOwner.lastName");
		users.addNestedContainerProperty("accountOwner.description");
		users.addNestedContainerProperty("accountOwner.ownerType");
		users.addNestedContainerProperty("accountOwner.symbol");
		users.addNestedContainerProperty("accountOwner.createdBy");
		users.addNestedContainerProperty("accountOwner.creationDate");
		users.addNestedContainerProperty("accountOwner.id");
		
	}
	
	
}
