package com.trivia.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import com.trivia.negocio.dominio.TriviaDominio;
import com.trivia.negocio.validador.Validador;
import com.trivia.negocio.validador.enumerador.TipoValidacion;
import com.trivia.negocio.validador.implementacion.trivia.CodigoValidoTriviaRegla;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;

public class TriviaValidador implements Validador<TriviaDominio>
{
	private EnumMap<TipoValidacion, List<Regla<TriviaDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<TriviaDominio> INSTANCIA = new TriviaValidador();
	
	private TriviaValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<TriviaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(TriviaDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<TriviaDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<TriviaDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new TriviaNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<TriviaDominio>> obtenerReglasCreacion()
	{	
		return new ArrayList<>();
	}
		
	private List<Regla<TriviaDominio>> obtenerReglasActualizacion()
	{
		List<Regla<TriviaDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoTriviaRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<TriviaDominio>> obtenerReglasEliminacion()
	{
		List<Regla<TriviaDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoTriviaRegla.obtenerInstancia());

		return listadoReglas;
	}
}