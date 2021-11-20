package com.trivia.negocio.validador.implementacion.jugador;

import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilTexto;

public class ClaveValidoJugadorRegla implements Regla<JugadorDominio>
{
	private static final Regla<JugadorDominio> INSTANCIA = new ClaveValidoJugadorRegla();
	
	private ClaveValidoJugadorRegla()
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
		validarClaveVacio(dato.getClave());
		validarLongitudClaveValida(dato.getClave());
		validarFormatoClaveElectronico(dato.getClave());
		
	}
	
	private void validarClaveVacio(String clave)
	{
		if (UtilTexto.cadenaEstaVacia(clave))
		{
			throw new TriviaNegocioExcepcion("la Clave de un Jugador no puede estar vacio");
		}
	}
		
	private void validarLongitudClaveValida(String clave)
	{
		if(!UtilTexto.longitudEsValida(clave, 8, 100))
		{
			throw new TriviaNegocioExcepcion("la Clave de un Jugador debe tener minimo 8 caracteres y maximo 100 caracteres");
		}
	}
		
	private void validarFormatoClaveElectronico(String clave)
	{
		if(!UtilTexto.cadenaClave(clave))
		{
			throw new TriviaNegocioExcepcion("la Clave de un Jugador debe tener minimo 8 caracteres, un caracter en mayuscula, otro en minuscula y un numero");
		}
	}
}
