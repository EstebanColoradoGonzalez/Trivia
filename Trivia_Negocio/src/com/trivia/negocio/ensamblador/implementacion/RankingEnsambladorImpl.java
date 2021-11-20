package com.trivia.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import com.trivia.dto.RankingDTO;
import com.trivia.entidad.RankingEntidad;
import com.trivia.negocio.dominio.RankingDominio;
import com.trivia.negocio.ensamblador.RankingEnsamblador;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilObjeto;

public class RankingEnsambladorImpl implements RankingEnsamblador
{
	private static final RankingEnsamblador INSTANCIA = new RankingEnsambladorImpl();

	private RankingEnsambladorImpl()
	{
		
	}
	
	public static RankingEnsamblador obtenerRankingEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public RankingDominio ensamblarDominioDesdeEntidad(RankingEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un dominio de Ranking a partir de una entidad de un Ranking que esta nulo");
		}
		
		return RankingDominio.crear(entidad.getCodigo(), TriviaEnsambladorImpl.obtenerTriviaEnsamblador().ensamblarDominiosDesdeEntidad(entidad.getTrivias()));
	}

	@Override
	public List<RankingDominio> ensamblarDominiosDesdeEntidad(List<RankingEntidad> entidades) 
	{
		return entidades.stream().map(obtenerRankingEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public RankingEntidad ensamblarEntidadDesdeDominio(RankingDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar una Entidad de Ranking a partir de un dominio de un Ranking que esta nulo");
		}
		
		return RankingEntidad.crear(dominio.getCodigo(), TriviaEnsambladorImpl.obtenerTriviaEnsamblador().ensamblarEntidadesDesdeDominio(dominio.getTrivias()));
	}

	@Override
	public List<RankingEntidad> ensamblarEntidadesDesdeDominio(List<RankingDominio> dominios) 
	{
		return dominios.stream().map(obtenerRankingEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public RankingDominio ensamblarDominioDesdeDTO(RankingDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Ranking a partir de un DTO de un Ranking que esta nulo");
		}
		
		return RankingDominio.crear(dto.getCodigo(), TriviaEnsambladorImpl.obtenerTriviaEnsamblador().ensamblarDominiosDesdeDTO(dto.getTrivias()));
	}

	@Override
	public List<RankingDominio> ensamblarDominiosDesdeDTO(List<RankingDTO> dtos) 
	{
		return dtos.stream().map(obtenerRankingEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public RankingDTO ensamblarDTODesdeDominio(RankingDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un DTO de Ranking a partir de un Dominio de un Ranking que esta nulo");
		}
		
		return RankingDTO.crear(dominio.getCodigo(), TriviaEnsambladorImpl.obtenerTriviaEnsamblador().ensamblarDTOsDesdeDominio(dominio.getTrivias()));
	}

	@Override
	public List<RankingDTO> ensamblarDTOsDesdeDominio(List<RankingDominio> dominios) 
	{
		return dominios.stream().map(obtenerRankingEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}