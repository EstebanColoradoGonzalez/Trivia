package com.trivia.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import com.trivia.dto.TriviaDTO;
import com.trivia.entidad.TriviaEntidad;
import com.trivia.negocio.dominio.TriviaDominio;
import com.trivia.negocio.ensamblador.TriviaEnsamblador;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilObjeto;

public class TriviaEnsambladorImpl implements TriviaEnsamblador
{
	private static final TriviaEnsamblador INSTANCIA = new TriviaEnsambladorImpl();

	private TriviaEnsambladorImpl()
	{
		
	}
	
	public static TriviaEnsamblador obtenerTriviaEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public TriviaDominio ensamblarDominioDesdeEntidad(TriviaEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Usuario a partir de una entidad de un Usuario que esta nulo");
		}
		
		return TriviaDominio.crear(entidad.getCodigo(), entidad.getFecha(), BancoEnsambladorImpl.obtenerBancoEnsamblador().ensamblarDominioDesdeEntidad(entidad.getBanco()), JugadorEnsambladorImpl.obtenerJugadorEnsamblador().ensamblarDominioDesdeEntidad(entidad.getJugador()), RankingEnsambladorImpl.obtenerRankingEnsamblador().ensamblarDominioDesdeEntidad(entidad.getRanking()));
	}

	@Override
	public List<TriviaDominio> ensamblarDominiosDesdeEntidad(List<TriviaEntidad> entidades) 
	{
		return entidades.stream().map(obtenerTriviaEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public TriviaEntidad ensamblarEntidadDesdeDominio(TriviaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar una Entidad de Usuario a partir de un dominio de un Usuario que esta nulo");
		}
		
		return TriviaEntidad.crear(dominio.getCodigo(), dominio.getFecha(), BancoEnsambladorImpl.obtenerBancoEnsamblador().ensamblarEntidadDesdeDominio(dominio.getBanco()), JugadorEnsambladorImpl.obtenerJugadorEnsamblador().ensamblarEntidadDesdeDominio(dominio.getJugador()), RankingEnsambladorImpl.obtenerRankingEnsamblador().ensamblarEntidadDesdeDominio(dominio.getRanking()));
	}

	@Override
	public List<TriviaEntidad> ensamblarEntidadesDesdeDominio(List<TriviaDominio> dominios) 
	{
		return dominios.stream().map(obtenerTriviaEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public TriviaDominio ensamblarDominioDesdeDTO(TriviaDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Usuario a partir de un DTO de un Usuario que esta nulo");
		}
		
		return TriviaDominio.crear(dto.getCodigo(), dto.getFecha(), BancoEnsambladorImpl.obtenerBancoEnsamblador().ensamblarDominioDesdeDTO(dto.getBanco()), JugadorEnsambladorImpl.obtenerJugadorEnsamblador().ensamblarDominioDesdeDTO(dto.getJugador()), RankingEnsambladorImpl.obtenerRankingEnsamblador().ensamblarDominioDesdeDTO(dto.getRanking()));
	}

	@Override
	public List<TriviaDominio> ensamblarDominiosDesdeDTO(List<TriviaDTO> dtos) 
	{
		return dtos.stream().map(obtenerTriviaEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public TriviaDTO ensamblarDTODesdeDominio(TriviaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un DTO de Usuario a partir de un Dominio de un Usuario que esta nulo");
		}
		
		return TriviaDTO.crear(dominio.getCodigo(), dominio.getFecha(), BancoEnsambladorImpl.obtenerBancoEnsamblador().ensamblarDTODesdeDominio(dominio.getBanco()), JugadorEnsambladorImpl.obtenerJugadorEnsamblador().ensamblarDTODesdeDominio(dominio.getJugador()), RankingEnsambladorImpl.obtenerRankingEnsamblador().ensamblarDTODesdeDominio(dominio.getRanking()));
	}

	@Override
	public List<TriviaDTO> ensamblarDTOsDesdeDominio(List<TriviaDominio> dominios) 
	{
		return dominios.stream().map(obtenerTriviaEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}