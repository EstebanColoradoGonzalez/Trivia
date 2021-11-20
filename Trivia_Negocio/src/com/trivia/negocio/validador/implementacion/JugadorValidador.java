package com.trivia.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.validador.Validador;
import com.trivia.negocio.validador.enumerador.TipoValidacion;
import com.trivia.negocio.validador.implementacion.jugador.ApellidosValidoJugadorRegla;
import com.trivia.negocio.validador.implementacion.jugador.ClaveValidoJugadorRegla;
import com.trivia.negocio.validador.implementacion.jugador.CodigoValidoJugadorRegla;
import com.trivia.negocio.validador.implementacion.jugador.CorreoValidoJugadorRegla;
import com.trivia.negocio.validador.implementacion.jugador.NombreValidoJugadorRegla;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;

public class JugadorValidador implements Validador<JugadorDominio>
{
	private EnumMap<TipoValidacion, List<Regla<JugadorDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<JugadorDominio> INSTANCIA = new JugadorValidador();
	
	private JugadorValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<JugadorDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(JugadorDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<JugadorDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<JugadorDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new TriviaNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<JugadorDominio>> obtenerReglasCreacion()
	{
		List<Regla<JugadorDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(NombreValidoJugadorRegla.obtenerInstancia());
		listadoReglas.add(ApellidosValidoJugadorRegla.obtenerInstancia());
		listadoReglas.add(CorreoValidoJugadorRegla.obtenerInstancia());
		listadoReglas.add(ClaveValidoJugadorRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<JugadorDominio>> obtenerReglasActualizacion()
	{
		List<Regla<JugadorDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoJugadorRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoJugadorRegla.obtenerInstancia());
		listadoReglas.add(ApellidosValidoJugadorRegla.obtenerInstancia());
		listadoReglas.add(CorreoValidoJugadorRegla.obtenerInstancia());
		listadoReglas.add(ClaveValidoJugadorRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<JugadorDominio>> obtenerReglasEliminacion()
	{
		List<Regla<JugadorDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoJugadorRegla.obtenerInstancia());

		return listadoReglas;
	}
}