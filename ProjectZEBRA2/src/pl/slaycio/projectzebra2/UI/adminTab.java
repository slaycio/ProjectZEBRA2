package pl.slaycio.projectzebra2.UI;


//import javax.persistence.EntityManager;
import pl.slaycio.projectzebra2.datamodel.AccountOwner;
import pl.slaycio.projectzebra2.datamodel.User;
import pl.slaycio.projectzebra2.ext.ZebraTable;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings({ "serial"})
public class adminTab extends VerticalLayout {

	
	
	
	
	 
	 public adminTab() {
		this.setSizeFull();
	
		 final ZebraTable userTable ;
		 final Button saveBtn ;
		 
		 //final Map<String, ComboBox> cmbMap = new HashMap<String, ComboBox>();
		 	 
		// final ArrayList<ComboBox> cmbList = new ArrayList<ComboBox>();
		 	
		
		
	//	final Label nlbl = new Label("ccc"); ;
		final JPAContainer<AccountOwner> owners = JPAContainerFactory.make(AccountOwner.class, "ProjectZEBRA2");
		final JPAContainer<User> entis = JPAContainerFactory.make(User.class, "ProjectZEBRA2");
				
		//final EntityManager em = JPAContainerFactory.createEntityManagerForPersistenceUnit("ProjectZEBRA2");
		
		entis.addNestedContainerProperty("accountOwner.name");
		entis.addNestedContainerProperty("accountOwner.id");
		
		userTable = new ZebraTable("The Persistent users", entis);
		userTable.setVisibleColumns((Object[]) new String[] {"id","user","accountOwner.name"});
		//userTable.setEditable(true);
		userTable.setSelectable(true);
		userTable.setImmediate(true);
		userTable.setNullSelectionAllowed(false);
		this.addComponent(userTable);
		
		/*  - moved to zebratable class
		
		userTable.addGeneratedColumn("newaccountOwner_name", new ColumnGenerator() {
		        	private static final long serialVersionUID = 1L;
					@Override
					public Object generateCell(final Table source, final Object itemId,	final Object columnId) {
						ComboBox cmbx = new ComboBox();
															
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
						
						
						cmbMap.put(source.getItem(itemId).getItemProperty("id").getValue().toString(), cmbx);
						return cmbx;
					}
		        	
		        	
		        });
		userTable.getcMap().put("newaccountOwner_name", cmbMap);
		
		*/
		
		userTable.addNewComboEditedColumn("newaccountOwner_name",owners, "accountOwner.id","name");
		
		saveBtn = new Button("SAVVVA");
		
		saveBtn.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				
				//userTable.getItem(userTable.getValue()).getItemProperty("accountOwner").setValue(owners.getItem(142));	
				
	//			nlbl.setValue(              //"dduuu"); // .setValue("cuuuu"
	//			entis.getItem (userTable.getValue()).getItemProperty("accountOwner").toString()
				//entis.getItem(userTable.getValue()).toString()
	//			);
				
				
				
			
				
			/*	nlbl.setValue(              //"dduuu"); // .setValue("cuuuu"
						entis.getItem(userTable.getValue()).getEntity().getAccountOwner().getName().toString()
						//userTable.getItem(userTable.getValue()).getItemProperty(id)
	
						//entis.getItem(userTable.getValue()).toString()
						);
				*/
				//userTable.getColumnGenerator("newaccountOwner_name").
			//	nlbl.setValue(    
				//userTable.getContainerProperty(userTable.getValue(), "newaccountOwner_name").getValue().toString()
						//cmbList.get(userTable.getValue()).getValue().toString()
				//		cmbMap.get(userTable.getValue()).getValue().toString()
						
				//		);
				
			//	System.out.println(userTable.getValue().toString() +"  -   "+cmbMap.get(userTable.getValue()).getValue().toString());		 
			
				
				// czeœc ze zmian¹ która dziala
				///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			    // TODO trzeba to teraz wrzucic w klase ZebraTable by zmiana w comboboxie zmieniala od razu wartosc persistowanej tabeli
				User change = entis.getItem(userTable.getValue()).getEntity(); 
				change.setAccountOwner(owners.getItem(userTable.getcMap().get("newaccountOwner_name").get(userTable.getValue().toString()).getValue()).getEntity()); 
				entis.addEntity(change);
				entis.commit();
				
				userTable.refreshRowCache();	
				
	   		   
					   		    
	   		    
				}
		}); 
		
		
		this.addComponent(saveBtn);
	//	saveBtn.setEnabled(true); 
	//	this.addComponent(nlbl);
		
   
        
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
