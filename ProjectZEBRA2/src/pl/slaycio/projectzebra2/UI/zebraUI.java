package pl.slaycio.projectzebra2.UI;


import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

import com.vaadin.ui.Alignment;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("projectzebra2")
public class zebraUI extends UI {

	public static VerticalLayout mainLayout;	
	//public static GridLayout mainLayout;	
	//public static AbsoluteLayout mainLayout;
	public static ZebraHeader zebraHeaderInst;
	public static ZebraBody zebraBodyInst ;
	
	
	@WebServlet
	@VaadinServletConfiguration(productionMode = false, ui = zebraUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		
		this.setSizeFull();
		mainLayout = new VerticalLayout();
		mainLayout.setDefaultComponentAlignment(Alignment.TOP_LEFT);
				
		setContent(mainLayout);
		zebraHeaderInst = new ZebraHeader();
		zebraBodyInst = new ZebraBody();
		mainLayout.addComponent(zebraHeaderInst);
		mainLayout.addComponent(zebraBodyInst);
		
		
	}

	
	
}


