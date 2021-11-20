package com.trivia.negocio.validador.implementacion.trivia;

import com.trivia.negocio.dominio.TriviaDominio;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilNumero;

public class CodigoValidoTriviaRegla implements Regla<TriviaDominio> 
{
	private static final Regla<TriviaDominio> INSTANCIA = new CodigoValidoTriviaRegla();
	
	private CodigoValidoTriviaRegla()
	{
		super();
	}
	
	public static Regla<TriviaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(TriviaDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new TriviaNegocioExcepcion("El codigo de una Trivia no puede ser menor o igual que cero");
		}
	}
}