package br.com.websige.util;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.websige.util.framework.MessageService;

public class FacesUtil {
	
	public static boolean isPostback(){
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public static boolean isNotPostback(){
		return !isPostback();
	}
	
	public static void addErrorMessage(String message){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	public static void addInfoMessage(String message){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	public static void addListMessageService(List<MessageService> listMessages)
	{
		for (MessageService messageService : listMessages) {
			FacesMessage message = new FacesMessage(messageService.getMessage() + " - ("+ messageService.getCodeMessage()+")");
			switch ( messageService.getTypeMessage()){
				case ERROR:
					message.setSeverity(FacesMessage.SEVERITY_ERROR);
					break;
				case FATAL:
					message.setSeverity(FacesMessage.SEVERITY_FATAL);
				case INFO:
					message.setSeverity(FacesMessage.SEVERITY_INFO);
				case WANING:
					message.setSeverity(FacesMessage.SEVERITY_WARN);
			default:
				break;
			}
			FacesContext.getCurrentInstance().addMessage(null,message);
		}
	}
}
