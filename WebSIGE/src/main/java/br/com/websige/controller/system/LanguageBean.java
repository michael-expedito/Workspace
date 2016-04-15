package br.com.websige.controller.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.inject.Named;

@Named
@SessionScoped
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String localeCode;

	private static List<String> countries;

	static {
		countries = new ArrayList<String>();
		countries.add("Português");
		countries.add("English");
		countries.add("Español"); 
	}

	public List<String>getCountriesInMap() {
		return countries;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public void countryLocaleCodeChanged() {

		if (localeCode.equals("Português")){
			UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
			Locale currentLocale = new Locale("pt", "BR");
			viewRoot.setLocale(currentLocale);
            Locale.setDefault(currentLocale);
		}
		if (localeCode.equals("English")){
			UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
			Locale currentLocale = Locale.US;
			viewRoot.setLocale(currentLocale);
            Locale.setDefault(currentLocale);
		}
		if (localeCode.equals("Español")){
			UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
			Locale currentLocale = new Locale("es", "ES");
			viewRoot.setLocale(currentLocale);
            Locale.setDefault(currentLocale);
		}
	}

}