package com.trivia.negocio.validador.implementacion.jugador;

import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilNumero;

public class CodigoValidoJugadorRegla implements Regla<JugadorDominio> 
{
	private static final Regla<JugadorDominio> INSTANCIA = new CodigoValidoJugadorRegla();
	
	private CodigoValidoJugadorRegla()
	{
		super();
	}
	
	public static Regla<JugadorDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(JugadorDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new TriviaNegocioExcepcion("El codigo de un Jugador no puede ser menor o igual que cero");
		}
	}
}