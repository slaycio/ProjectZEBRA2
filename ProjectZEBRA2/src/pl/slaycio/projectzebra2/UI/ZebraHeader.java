package pl.slaycio.projectzebra2.UI;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;





@SuppressWarnings("serial")
public final class ZebraHeader extends Panel {
	

	public ZebraHeader()  {
		
		
		this.setWidth("100%");
		this.setHeight("40px");
				
		
		VerticalLayout headerContent = new VerticalLayout();
		this.setContent(headerContent);
		headerContent.setDefaultComponentAlignment(Alignment.TOP_CENTER);
		
		HorizontalLayout firstLine = new HorizontalLayout();
		HorizontalLayout secondLine = new HorizontalLayout();
		
		
		headerContent.addComponent(firstLine);
		headerContent.addComponent(secondLine);
		
		Label zebraTitle = new Label("Project ZEBRA - Personal Web Financial Manager");
		zebraTitle.setStyleName("zebraTitle");
		firstLine.addComponent(zebraTitle);
		
		
		Label currentUser = new Label("current user: "+"Jan X");
		secondLine.addComponent(currentUser);
		currentUser.setWidth((currentUser.getWidth()+40),Unit.PIXELS);
		
		Label currentRole = new Label("role: "+"admin");
		secondLine.addComponent(currentRole);
		//currentRole.setWidth((currentRole.getWidth()+40),Unit.PIXELS);
		
		
	}

	

}
