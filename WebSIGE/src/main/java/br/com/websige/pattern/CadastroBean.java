package br.com.websige.pattern;

import java.util.List;

public class CadastroBean<T> {

	
	public boolean getRenderedSalvar()
	{
		return true;
	}
	public boolean getRenderedExcluir()
	{
		return true;
	}
	public boolean getRenderedConsultar()
	{
		return true;
	}
	public boolean getDisabledSalvar()
	{
		return false;
	}
	public boolean getDisabledExcluir()
	{
		return false;
	}
	public boolean getDisabledConsultar()
	{
		return false;
	}
	public void startCadastro() {
		// TODO Auto-generated method stub	
	}	
}
