package pl.slaycio.projectzebra2.UI;


//import javax.persistence.EntityManager;
import pl.slaycio.projectzebra2.datamodel.AccountOwner;
import pl.slaycio.projectzebra2.datamodel.User;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings({ "serial"})
public class adminTab extends VerticalLayout {

	
	 public Table userTable ;
	 final public Button saveBtn ;
	 
	 public adminTab() {
		this.setSizeFull();
	
					    
		final Label nlbl = new Label("ccc"); ;
		final JPAContainer<AccountOwner> owners = JPAContainerFactory.make(AccountOwner.class, "ProjectZEBRA2");
		final JPAContainer<User> entis = JPAContainerFactory.make(User.class, "ProjectZEBRA2");
				
		//final EntityManager em = JPAContainerFactory.createEntityManagerForPersistenceUnit("ProjectZEBRA2");
		
		entis.addNestedContainerProperty("accountOwner.name");
		entis.addNestedContainerProperty("accountOwner.id");
		
		userTable = new Table("The Persistent users", entis);
		userTable.setVisibleColumns((Object[]) new String[] {"id","user","accountOwner.name"});
		//userTable.setEditable(true);
		userTable.setSelectable(true);
		userTable.setImmediate(true);
		userTable.setNullSelectionAllowed(false);
		this.addComponent(userTable);
		
        
		userTable.addGeneratedColumn("newaccountOwner_name", new ColumnGenerator() {
		        	private static final long serialVersionUID = 1L;
					@Override
					public Object generateCell(final Table source, final Object itemId,	final Object columnId) {
						final ComboBox cmbx = new ComboBox();
						
															
						cmbx.setContainerDataSource(owners);
						cmbx.setItemCaptionMode(ItemCaptionMode.PROPERTY);
						cmbx.setItemCaptionPropertyId("name");
														
						cmbx.setValue(source.getItem(itemId).getItemProperty("accountOwner.id").getValue()); 
						cmbx.setImmediate(true);
						cmbx.setNullSelectionAllowed(false);
						
						cmbx.addFocusListener(new FocusListener(){

							@Override
							public void focus(FocusEvent event) {
								source.select(itemId);
																
							}
							
							
						});
						
						cmbx.addValueChangeListener(new ValueChangeListener(){

						
							@Override
							public void valueChange(ValueChangeEvent event) {
								
							
								
								
							}
						
						});
						
						
						return cmbx;
					}
		        	
		        	
		        });
      
		saveBtn = new Button("SAVVVA");
		
		saveBtn.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				
				//userTable.getItem(userTable.getValue()).getItemProperty("accountOwner").setValue(owners.getItem(142));	
				
				nlbl.setValue(              //"dduuu"); // .setValue("cuuuu"
				entis.getItem (userTable.getValue()).getItemProperty("accountOwner").toString()
				//entis.getItem(userTable.getValue()).toString()
				);
				
				
				
				User change = entis.getItem(userTable.getValue()).getEntity(); 
				
				nlbl.setValue(              //"dduuu"); // .setValue("cuuuu"
						entis.getItem(userTable.getValue()).getEntity().getAccountOwner().getName().toString()
						//userTable.getItem(userTable.getValue()).getItemProperty(id)
				//TODO trzeba sprawdziæ jak dynamicznie ustalic zmiany w kolumnie comboboxow i zapisac je do odpowiednich kolumn		
						//entis.getItem(userTable.getValue()).toString()
						);
				
				change.setAccountOwner(owners.getItem(145).getEntity()); 
			
				entis.addEntity(change);
				//em.persist(change);
				entis.commit();
				//userTable.commit();
				userTable.refreshRowCache();	
				
	   		   
					   		    
	   		    
				}
		}); 
		
		
		this.addComponent(saveBtn);
		saveBtn.setEnabled(true); 
		this.addComponent(nlbl);
		
   
        
	/*
		
		  form = new Form();
          form.setCaption("Invoice editor");
          FieldFactory jpaContainerFieldFactory = new FieldFactory();
          jpaContainerFieldFactory.setVisibleProperties(User.class,
          		"id","user","accountOwner.name");
         
         
          form.setFormFieldFactory(jpaContainerFieldFactory);
      	
          form.getFooter().setVisible(true);

          form.setEnabled(true);
  		
      	
          
          this.addComponent(form);
        
          
        /* Nie usuwaæ !!!!!!!  *//*
  		 userTable.addItemClickListener(new ItemClickListener(){
				@Override
				public void itemClick(ItemClickEvent event) {
				 // form.setItemDataSource(userTable.getItem(event.getItemId()));	
				}
          });
          
		
		
		  userTable.addValueChangeListener(new ValueChangeListener() {
	            @Override
	            public void valueChange(ValueChangeEvent event) {
	                  form.setItemDataSource(userTable.getItem(userTable.getValue()));
	      		}
	      });
	    
		*/
	    		
		
	}

}
