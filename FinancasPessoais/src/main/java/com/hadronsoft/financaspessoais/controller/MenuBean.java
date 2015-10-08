package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import java.util.HashMap;
import java.util.Map;

@Named
@SessionScoped
public class MenuBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public void viewDialog(String url,Boolean modal, Boolean draggable, Boolean resizable, Integer height, Integer width){
        Map<String,Object> options = new HashMap<String, Object>();
        
        options.put("modal", modal);
        options.put("draggable", draggable);
        options.put("resizable", resizable);
        options.put("contentHeight", height);
        options.put("contentWidth", width);
        
		RequestContext.getCurrentInstance().openDialog(url, options, null);
	}
}
