package com.trivia.negocio.validador.implementacion.jugador;

import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilTexto;

public class NombreValidoJugadorRegla implements Regla<JugadorDominio>
{
	private static final Regla<JugadorDominio> INSTANCIA = new NombreValidoJugadorRegla();
	
	private NombreValidoJugadorRegla()
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
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new TriviaNegocioExcepcion("El nombre de un Jugador no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new TriviaNegocioExcepcion("El nombre de un Jugador debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new TriviaNegocioExcepcion("El nombre de un Jugador solo puede contener letras y espacios");
		}
	}
}
