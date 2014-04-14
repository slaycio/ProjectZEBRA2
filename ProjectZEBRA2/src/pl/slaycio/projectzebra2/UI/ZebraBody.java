package pl.slaycio.projectzebra2.UI;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class ZebraBody extends Panel {

	public ZebraBody() {
	
		this.setSizeFull();
		//this.setWidth("100%");
		//this.setHeight("860px");		
		

		VerticalLayout bodyContent = new VerticalLayout();
		this.setContent(bodyContent);
		
			
				TabSheet mainTabs = new TabSheet();
				mainTabs.setSizeFull();
				bodyContent.addComponent(mainTabs);
				mainTabs.addTab(new VerticalLayout(),"___________MAIN MENU___________").setEnabled(false);
				

				// Create tabs
				VerticalLayout financialOverview = new VerticalLayout();
				financialOverview.setSizeFull();
				mainTabs.addTab(financialOverview, "Financial overview");	
				
				VerticalLayout transactions = new VerticalLayout();
				transactions.setSizeFull();
				mainTabs.addTab(transactions, "Accounts & Transactions");	
				
				VerticalLayout forecast = new VerticalLayout();
				forecast.setSizeFull();
				mainTabs.addTab(forecast, "CashFlow and Forecats");	
				
				adminTab adminTab = new adminTab();
				mainTabs.addTab(adminTab, "Administration");	
				
							
				final Label tts = new Label("jeszc ze nic sie nie sta³o");
				financialOverview.addComponent(tts);		
				
		Button button2 = new Button("nowy wpis");
		button2.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
								
				tts.setReadOnly(true);
				tts.setValue("to jestttt spartaaaa");
				
				//TODO trzeba bêdzie teraz wyprobowac zakladanie tych obiektow i wtedy GUI
				//FinancialInstitution nowaInstytucja = new FinancialInstitution("mBank", "", "", "mBank", "Bank", "mBank");
				//nowaInstytucja.saveUsingDAO();
				
				//Account account1 = new Account("eKonto4223", "Konto w mBanku", "Rachunek bie¿¹cy", "Pawel2", nowaInstytucja, "EKO");
				
				//System.out.println(account1.getFinInstitution());
				}
		});
		
		financialOverview.addComponent(button2);
		//layout.addComponent(button2);
		
		
		
		
		
		
	}

}
