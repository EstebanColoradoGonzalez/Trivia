package com.trivia.transversal.excepcion;

public class TriviaExcepcion extends RuntimeException
{
	private static final long serialVersionUID = 6841996169026143892L;
	
	public TriviaExcepcion(String mensaje)
	{
		super(mensaje);
	}
}