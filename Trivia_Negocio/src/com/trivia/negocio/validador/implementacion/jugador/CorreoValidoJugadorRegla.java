package com.trivia.negocio.validador.implementacion.jugador;

import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilTexto;

public class CorreoValidoJugadorRegla implements Regla<JugadorDominio>
{
	private static final Regla<JugadorDominio> INSTANCIA = new CorreoValidoJugadorRegla();
	
	private CorreoValidoJugadorRegla()
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
		validarCorreoVacio(dato.getCorreo());
		validarLongitudCorreoValida(dato.getCorreo());
		validarFormatoCorreoElectronico(dato.getCorreo());
	}
	
	private void validarCorreoVacio(String correo)
	{
		if (UtilTexto.cadenaEstaVacia(correo))
		{
			throw new TriviaNegocioExcepcion("El correo de un Jugador no puede estar vacio");
		}
	}
		
	private void validarLongitudCorreoValida(String correo)
	{
		if(!UtilTexto.longitudEsValida(correo, 1, 100))
		{
			throw new TriviaNegocioExcepcion("El correo de un Jugador debe tener minimo un caracter y maximo 100 caracteres");
		}
	}
		
	private void validarFormatoCorreoElectronico(String correo)
	{
		if(!UtilTexto.cadenaCorreoElectronico(correo))
		{
			throw new TriviaNegocioExcepcion("El correo de un Jugador debe tener el formato de Correo Electronico");
		}
	}
}
