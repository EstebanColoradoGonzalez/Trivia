package com.trivia.negocio.validador.implementacion.jugador;

import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilTexto;

public class ApellidosValidoJugadorRegla implements Regla<JugadorDominio>
{
	private static final Regla<JugadorDominio> INSTANCIA = new ApellidosValidoJugadorRegla();
	
	private ApellidosValidoJugadorRegla()
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
		validarApellidosVacio(dato.getApellidos());
		validarLongitudApellidosValida(dato.getApellidos());
		validarApellidosContengaLetrasYEspacios(dato.getApellidos());
	}
	
	private void validarApellidosVacio(String apellidos)
	{
		if (UtilTexto.cadenaEstaVacia(apellidos))
		{
			throw new TriviaNegocioExcepcion("Los Apellidos de un Jugador no puede estar vacio");
		}
	}
		
	private void validarLongitudApellidosValida(String apellidos)
	{
		if(!UtilTexto.longitudEsValida(apellidos, 1, 100))
		{
			throw new TriviaNegocioExcepcion("Los Apellidos de un Jugador debe tener minimo un caracter y maximo 100 caracteres");
		}
	}
		
	private void validarApellidosContengaLetrasYEspacios(String apellidos)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(apellidos))
		{
			throw new TriviaNegocioExcepcion("Los Apellidos de un Jugador solo puede contener letras y espacios");
		}
	}
}
