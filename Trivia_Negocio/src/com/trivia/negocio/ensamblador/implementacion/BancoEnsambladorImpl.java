package com.trivia.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import com.trivia.dto.BancoDTO;
import com.trivia.entidad.BancoEntidad;
import com.trivia.negocio.dominio.BancoDominio;
import com.trivia.negocio.ensamblador.BancoEnsamblador;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilObjeto;

public class BancoEnsambladorImpl implements BancoEnsamblador
{
	private static final BancoEnsamblador INSTANCIA = new BancoEnsambladorImpl();

	private BancoEnsambladorImpl()
	{
		
	}
	
	public static BancoEnsamblador obtenerBancoEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public BancoDominio ensamblarDominioDesdeEntidad(BancoEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Banco a partir de una entidad de un Banco que esta nulo");
		}
		
		return BancoDominio.crear(entidad.getCodigo(), PreguntaEnsambladorImpl.obtenerPreguntaEnsamblador().ensamblarDominiosDesdeEntidad(entidad.getPreguntas()));
	}

	@Override
	public List<BancoDominio> ensamblarDominiosDesdeEntidad(List<BancoEntidad> entidades) 
	{
		return entidades.stream().map(obtenerBancoEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public BancoEntidad ensamblarEntidadDesdeDominio(BancoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar una Entidad de Banco a partir de un dominio de un Banco que esta nulo");
		}
		
		return BancoEntidad.crear(dominio.getCodigo(), PreguntaEnsambladorImpl.obtenerPreguntaEnsamblador().ensamblarEntidadesDesdeDominio(dominio.getPreguntas()));
	}

	@Override
	public List<BancoEntidad> ensamblarEntidadesDesdeDominio(List<BancoDominio> dominios) 
	{
		return dominios.stream().map(obtenerBancoEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public BancoDominio ensamblarDominioDesdeDTO(BancoDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Banco a partir de un DTO de un Banco que esta nulo");
		}
		
		return BancoDominio.crear(dto.getCodigo(), PreguntaEnsambladorImpl.obtenerPreguntaEnsamblador().ensamblarDominiosDesdeDTO(dto.getPreguntas()));
	}

	@Override
	public List<BancoDominio> ensamblarDominiosDesdeDTO(List<BancoDTO> dtos) 
	{
		return dtos.stream().map(obtenerBancoEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public BancoDTO ensamblarDTODesdeDominio(BancoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un DTO de Banco a partir de un Dominio de un Banco que esta nulo");
		}
		
		return BancoDTO.crear(dominio.getCodigo(), PreguntaEnsambladorImpl.obtenerPreguntaEnsamblador().ensamblarDTOsDesdeDominio(dominio.getPreguntas()));
	}

	@Override
	public List<BancoDTO> ensamblarDTOsDesdeDominio(List<BancoDominio> dominios) 
	{
		return dominios.stream().map(obtenerBancoEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}
