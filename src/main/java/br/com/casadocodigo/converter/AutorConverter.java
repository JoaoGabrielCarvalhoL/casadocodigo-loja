package br.com.casadocodigo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.casadocodigo.models.Autor;

@FacesConverter("autorConverter")
public class AutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		
		Autor autor = new Autor(); 
		autor.setId(Integer.valueOf(value));
		return autor;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;			
		}
		Autor autor = (Autor) value;
		return autor.getId().toString();
	}

}
