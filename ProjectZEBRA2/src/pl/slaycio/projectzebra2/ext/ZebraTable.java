package pl.slaycio.projectzebra2.ext;

import java.util.HashMap;
import java.util.Map;
import com.vaadin.data.Container;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Table;


public class ZebraTable extends Table {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Map<String, ComboBox>> cMap = new  HashMap<String,Map<String, ComboBox>>();
	

	public ZebraTable() {
		
	}

	public ZebraTable(String caption) {
		super(caption);
		
	}

	public ZebraTable(String caption, Container dataSource) {
		super(caption, dataSource);

	}

	
	public Map<String, Map<String, ComboBox>> getcMap() {
		return cMap;
	}

	public void setcMap(Map<String, Map<String, ComboBox>> cMap) {
		this.cMap = cMap;
	}

	
	public void addNewComboEditedColumn(final String newColumnName, final Container sourceContainer, final String valueProperty, final String captionName){
		
		final Map<String, ComboBox> cmbMap = new HashMap<String, ComboBox>();
				
		this.addGeneratedColumn(newColumnName, new ColumnGenerator() {
        	private static final long serialVersionUID = 1L;
			@Override
			public Object generateCell(final Table source, final Object itemId,	final Object columnId) {
				ComboBox cmbx = new ComboBox();
													
				cmbx.setContainerDataSource(sourceContainer);
				cmbx.setItemCaptionMode(ItemCaptionMode.PROPERTY);
				cmbx.setItemCaptionPropertyId(captionName);
												
				cmbx.setValue(source.getItem(itemId).getItemProperty(valueProperty).getValue()); 
				cmbx.setImmediate(true);
				cmbx.setNullSelectionAllowed(false);
				
				cmbx.addFocusListener(new FocusListener(){
					
					private static final long serialVersionUID = 7082679338110889949L;

					@Override
					public void focus(FocusEvent event) {
						source.select(itemId);
														
					}
					
					
				});
				
				cmbx.addValueChangeListener(new ValueChangeListener(){

					private static final long serialVersionUID = -5420060578517511357L;

					
					@Override
					public void valueChange(
							com.vaadin.data.Property.ValueChangeEvent event) {
	
						System.out.println(source.getValue().toString());
						
						System.out.println(cmbMap.get(source.getValue().toString()).getValue().toString());
						
						System.out.println("se kliklem");	
						
										
						
					}
				
				});
				
			
			
				
				
				cmbMap.put(source.getItem(itemId).getItemProperty("id").getValue().toString(), cmbx);
				return cmbx;
			}
        	
        	
        });
		this.getcMap().put(newColumnName, cmbMap);
		
	}
	
}
