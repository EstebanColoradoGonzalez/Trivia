package com.trivia.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import com.trivia.negocio.dominio.RankingDominio;
import com.trivia.negocio.validador.Validador;
import com.trivia.negocio.validador.enumerador.TipoValidacion;
import com.trivia.negocio.validador.implementacion.ranking.CodigoValidoRankingRegla;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;

public class RankingValidador implements Validador<RankingDominio>
{
	private EnumMap<TipoValidacion, List<Regla<RankingDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<RankingDominio> INSTANCIA = new RankingValidador();
	
	private RankingValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<RankingDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(RankingDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<RankingDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<RankingDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new TriviaNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<RankingDominio>> obtenerReglasCreacion()
	{	
		return new ArrayList<>();
	}
		
	private List<Regla<RankingDominio>> obtenerReglasActualizacion()
	{
		List<Regla<RankingDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoRankingRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<RankingDominio>> obtenerReglasEliminacion()
	{
		List<Regla<RankingDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoRankingRegla.obtenerInstancia());

		return listadoReglas;
	}
}