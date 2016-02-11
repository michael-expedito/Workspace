package br.com.websige.util.framework;

public class MessageService {
	
	private String codeMessage;
	private String message;
	private TypeMessageService typeMessage;
	
	
	
	public MessageService(String codeMessage, String message, TypeMessageService typeMessage) {
		this.codeMessage = codeMessage;
		this.message = message;
		this.typeMessage = typeMessage;
	}
	public String getCodeMessage() {
		return codeMessage;
	}
	public void setCodeMessage(String codeMessage) {
		this.codeMessage = codeMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TypeMessageService getTypeMessage() {
		return typeMessage;
	}
	public void setTypeMessage(TypeMessageService typeMessage) {
		this.typeMessage = typeMessage;
	}
	
}
