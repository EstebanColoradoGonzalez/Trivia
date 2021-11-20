package com.trivia.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import com.trivia.dto.PreguntaDTO;
import com.trivia.entidad.PreguntaEntidad;
import com.trivia.negocio.dominio.PreguntaDominio;
import com.trivia.negocio.ensamblador.PreguntaEnsamblador;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilObjeto;

public class PreguntaEnsambladorImpl implements PreguntaEnsamblador
{
	private static final PreguntaEnsamblador INSTANCIA = new PreguntaEnsambladorImpl();

	private PreguntaEnsambladorImpl()
	{
		
	}
	
	public static PreguntaEnsamblador obtenerPreguntaEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public PreguntaDominio ensamblarDominioDesdeEntidad(PreguntaEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Pregunta a partir de una entidad de un Pregunta que esta nulo");
		}
		
		return PreguntaDominio.crear(entidad.getCodigo(), entidad.getDescripcion(), CategoriaEnsambladorImpl.obtenerCategoriaEnsamblador().ensamblarDominioDesdeEntidad(entidad.getCategoria()), RespuestaEnsambladorImpl.obtenerRespuestaEnsamblador().ensamblarDominiosDesdeEntidad(entidad.getRespuestas()));
	}

	@Override
	public List<PreguntaDominio> ensamblarDominiosDesdeEntidad(List<PreguntaEntidad> entidades) 
	{
		return entidades.stream().map(obtenerPreguntaEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public PreguntaEntidad ensamblarEntidadDesdeDominio(PreguntaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar una Entidad de Pregunta a partir de un dominio de un Pregunta que esta nulo");
		}
		
		return PreguntaEntidad.crear(dominio.getCodigo(), dominio.getDescripcion(), CategoriaEnsambladorImpl.obtenerCategoriaEnsamblador().ensamblarEntidadDesdeDominio(dominio.getCategoria()), RespuestaEnsambladorImpl.obtenerRespuestaEnsamblador().ensamblarEntidadesDesdeDominio(dominio.getRespuestas()));
	}

	@Override
	public List<PreguntaEntidad> ensamblarEntidadesDesdeDominio(List<PreguntaDominio> dominios) 
	{
		return dominios.stream().map(obtenerPreguntaEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public PreguntaDominio ensamblarDominioDesdeDTO(PreguntaDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Pregunta a partir de un DTO de un Pregunta que esta nulo");
		}
		
		return PreguntaDominio.crear(dto.getCodigo(), dto.getDescripcion(), CategoriaEnsambladorImpl.obtenerCategoriaEnsamblador().ensamblarDominioDesdeDTO(dto.getCategoria()), RespuestaEnsambladorImpl.obtenerRespuestaEnsamblador().ensamblarDominiosDesdeDTO(dto.getRespuestas()));
	}

	@Override
	public List<PreguntaDominio> ensamblarDominiosDesdeDTO(List<PreguntaDTO> dtos) 
	{
		return dtos.stream().map(obtenerPreguntaEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public PreguntaDTO ensamblarDTODesdeDominio(PreguntaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un DTO de Pregunta a partir de un Dominio de un Pregunta que esta nulo");
		}
		
		return PreguntaDTO.crear(dominio.getCodigo(), dominio.getDescripcion(), CategoriaEnsambladorImpl.obtenerCategoriaEnsamblador().ensamblarDTODesdeDominio(dominio.getCategoria()), RespuestaEnsambladorImpl.obtenerRespuestaEnsamblador().ensamblarDTOsDesdeDominio(dominio.getRespuestas()));
	}

	@Override
	public List<PreguntaDTO> ensamblarDTOsDesdeDominio(List<PreguntaDominio> dominios) 
	{
		return dominios.stream().map(obtenerPreguntaEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}