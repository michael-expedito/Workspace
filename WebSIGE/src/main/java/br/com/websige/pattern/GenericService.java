package br.com.websige.pattern;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.websige.pattern.GenericRepository;
import br.com.websige.util.Transactional;
import br.com.websige.util.framework.MessageService;
import br.com.websige.util.framework.TypeMessageService;

public class GenericService<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected GenericRepository<T> repository;

	public List<MessageService> messages;

	public GenericService() {
		messages = new ArrayList<MessageService>();
	}

	@Transactional
	public void process(T entity) {
		// Limpando todas as mensagens da lista
		messages.clear();

		// Efetua as validações do serviço
		validateProcess(entity);

		// Efetua as validações do repositório
		repository.validateEntity(entity, messages);

		// Efetua as validações básicas da entidade
	    repository.validateSaveEntityBasic(entity, messages);

		// Se não foi encontrado nenhum erro FATAL ou ERRO nas validações acima
		// o service segue persistindo
		if (!hasFatalError()) {
			try {
				((GenericRepository<T>) this.repository).persist(entity);
				messages.add(new MessageService("INC0001", "Regisntro gravado com sucesso.", TypeMessageService.DEFAULT));	
			} catch (Exception e) {
				messages.add(new MessageService("INT000?",	"Erro não rastreado ao persistir a entidade", TypeMessageService.FATAL));
			}
		}
	}
	
	@Transactional
	public void revertProcess(T entity)
	{
		messages.clear();
		
		validateRevertProcess(entity);
		
		if (!hasFatalError()) {
			((GenericRepository<T>) this.repository).delete(entity);
			messages.add(new MessageService("EXC0001", "Registro removido com sucesso.", TypeMessageService.DEFAULT));
		}
	}

	protected void validateProcess(T entity) {
		// Este método tem por objetivo efetuar as validações exclusivas do
		// serviço antes de processar
	};

	protected void validateRevertProcess(T entity) {
		// Este método tem por objetivo efetuar as validações exclusivas do
		// serviço antes de excluir um processamento
	}

	public boolean hasFatalError() {
		boolean fatalError = false;
		for (MessageService messageService : messages) {
			if (messageService.getTypeMessage() == TypeMessageService.FATAL) {
				fatalError = true;
				break;
			} else
				fatalError = false;
		}
		return fatalError;
	}
}
