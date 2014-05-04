package pl.slaycio.projectzebra2.ext;

import java.util.HashMap;
import java.util.Map;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.data.Container;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Table;

public class ZebraTable extends Table {

	private static final long serialVersionUID = 1L;

	private Map<String, Map<String, ComboBox>> comboEditorsMap = new HashMap<String, Map<String, ComboBox>>();

	public ZebraTable() {

	}

	public ZebraTable(String caption) {
		super(caption);

	}

	public ZebraTable(String caption, Container dataSource) {
		super(caption, dataSource);

	}

	public Map<String, Map<String, ComboBox>> getComboEditorsMap() {
		return comboEditorsMap;
	}

	public void setComboEditorsMap(
			Map<String, Map<String, ComboBox>> comboEditorsMap) {
		this.comboEditorsMap = comboEditorsMap;
	}

	public void addNewComboEditedColumn(final JPAContainer<?> sourceContainer,
			final String valueProperty, final String captionName) {

		final Map<String, ComboBox> cmbMap = new HashMap<String, ComboBox>();
		final String newColumnName = new String(valueProperty + ".cmbEdited");

		this.addGeneratedColumn(newColumnName, new ColumnGenerator() {
			private static final long serialVersionUID = 1L;

			@Override
			public Object generateCell(final Table source, final Object itemId,
					final Object columnId) {

				ComboBox tempComboEditor = new ComboBox();

				tempComboEditor.setContainerDataSource(sourceContainer);
				tempComboEditor.setItemCaptionMode(ItemCaptionMode.PROPERTY);
				tempComboEditor.setItemCaptionPropertyId(captionName);

				tempComboEditor.setValue(source.getItem(itemId)
						.getItemProperty(valueProperty).getValue());
				tempComboEditor.setImmediate(true);
				tempComboEditor.setNullSelectionAllowed(false);

				tempComboEditor.addFocusListener(new FocusListener() {

					private static final long serialVersionUID = 7082679338110889949L;

					@Override
					public void focus(FocusEvent event) {
						source.select(itemId);

					}

				});

				tempComboEditor
						.addValueChangeListener(new ValueChangeListener() {

							private static final long serialVersionUID = -5420060578517511357L;

							@SuppressWarnings("unchecked")
							@Override
							public void valueChange(
									com.vaadin.data.Property.ValueChangeEvent event) {

								source.getItem(itemId)
										.getItemProperty(
												valueProperty.substring(0,
														valueProperty
																.indexOf(".")))
										.setValue(
												sourceContainer
														.getItem(
																cmbMap.get(
																		source.getValue()
																				.toString())
																		.getValue())
														.getEntity());

								source.refreshRowCache();

							}

						});

				cmbMap.put(
						source.getItem(itemId)
								.getItemProperty(
										valueProperty.substring(valueProperty
												.indexOf(".") + 1)).getValue()
								.toString(), tempComboEditor);
				return tempComboEditor;
			}

		});
		this.getComboEditorsMap().put(newColumnName, cmbMap);

	}

}
