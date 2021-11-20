package com.trivia.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import com.trivia.negocio.dominio.BancoDominio;
import com.trivia.negocio.validador.Validador;
import com.trivia.negocio.validador.enumerador.TipoValidacion;
import com.trivia.negocio.validador.implementacion.banco.CodigoValidoBancoRegla;
import com.trivia.negocio.validador.regla.Regla;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;

public class BancoValidador implements Validador<BancoDominio>
{
	private EnumMap<TipoValidacion, List<Regla<BancoDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<BancoDominio> INSTANCIA = new BancoValidador();
	
	private BancoValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<BancoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(BancoDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<BancoDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<BancoDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new TriviaNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<BancoDominio>> obtenerReglasCreacion()
	{	
		return new ArrayList<>();
	}
		
	private List<Regla<BancoDominio>> obtenerReglasActualizacion()
	{
		List<Regla<BancoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoBancoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<BancoDominio>> obtenerReglasEliminacion()
	{
		List<Regla<BancoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoBancoRegla.obtenerInstancia());

		return listadoReglas;
	}
}