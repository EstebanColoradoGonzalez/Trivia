package com.trivia.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import com.trivia.dto.RespuestaDTO;
import com.trivia.entidad.RespuestaEntidad;
import com.trivia.negocio.dominio.RespuestaDominio;
import com.trivia.negocio.ensamblador.RespuestaEnsamblador;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilObjeto;

public class RespuestaEnsambladorImpl implements RespuestaEnsamblador
{
	private static final RespuestaEnsamblador INSTANCIA = new RespuestaEnsambladorImpl();

	private RespuestaEnsambladorImpl()
	{
		
	}
	
	public static RespuestaEnsamblador obtenerRespuestaEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public RespuestaDominio ensamblarDominioDesdeEntidad(RespuestaEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Respuesta a partir de una entidad de un Respuesta que esta nulo");
		}
		
		return RespuestaDominio.crear(entidad.getCodigo(), entidad.getDescripcion(), entidad.isEsCorrecta(), PreguntaEnsambladorImpl.obtenerPreguntaEnsamblador().ensamblarDominioDesdeEntidad(entidad.getPregunta()));
	}

	@Override
	public List<RespuestaDominio> ensamblarDominiosDesdeEntidad(List<RespuestaEntidad> entidades) 
	{
		return entidades.stream().map(obtenerRespuestaEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public RespuestaEntidad ensamblarEntidadDesdeDominio(RespuestaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar una Entidad de Respuesta a partir de un dominio de un Respuesta que esta nulo");
		}
		
		return RespuestaEntidad.crear(dominio.getCodigo(), dominio.getDescripcion(), dominio.isEsCorrecta(), PreguntaEnsambladorImpl.obtenerPreguntaEnsamblador().ensamblarEntidadDesdeDominio(dominio.getPregunta()));
	}

	@Override
	public List<RespuestaEntidad> ensamblarEntidadesDesdeDominio(List<RespuestaDominio> dominios) 
	{
		return dominios.stream().map(obtenerRespuestaEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public RespuestaDominio ensamblarDominioDesdeDTO(RespuestaDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Respuesta a partir de un DTO de un Respuesta que esta nulo");
		}
		
		return RespuestaDominio.crear(dto.getCodigo(), dto.getDescripcion(), dto.isEsCorrecta(), PreguntaEnsambladorImpl.obtenerPreguntaEnsamblador().ensamblarDominioDesdeDTO(dto.getPregunta()));
	}

	@Override
	public List<RespuestaDominio> ensamblarDominiosDesdeDTO(List<RespuestaDTO> dtos) 
	{
		return dtos.stream().map(obtenerRespuestaEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public RespuestaDTO ensamblarDTODesdeDominio(RespuestaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un DTO de Respuesta a partir de un Dominio de un Respuesta que esta nulo");
		}
		
		return RespuestaDTO.crear(dominio.getCodigo(), dominio.getDescripcion(), dominio.isEsCorrecta(), PreguntaEnsambladorImpl.obtenerPreguntaEnsamblador().ensamblarDTODesdeDominio(dominio.getPregunta()));
	}

	@Override
	public List<RespuestaDTO> ensamblarDTOsDesdeDominio(List<RespuestaDominio> dominios) 
	{
		return dominios.stream().map(obtenerRespuestaEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}