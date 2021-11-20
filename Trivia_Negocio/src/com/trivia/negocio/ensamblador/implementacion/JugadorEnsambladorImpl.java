package com.trivia.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import com.trivia.dto.JugadorDTO;
import com.trivia.entidad.JugadorEntidad;
import com.trivia.negocio.dominio.JugadorDominio;
import com.trivia.negocio.ensamblador.JugadorEnsamblador;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilObjeto;

public class JugadorEnsambladorImpl implements JugadorEnsamblador
{
	private static final JugadorEnsamblador INSTANCIA = new JugadorEnsambladorImpl();

	private JugadorEnsambladorImpl()
	{
		
	}
	
	public static JugadorEnsamblador obtenerJugadorEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public JugadorDominio ensamblarDominioDesdeEntidad(JugadorEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Jugador a partir de una entidad de un Jugador que esta nulo");
		}
		
		return JugadorDominio.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getApellidos(), entidad.getCorreo(), entidad.getClave());
	}

	@Override
	public List<JugadorDominio> ensamblarDominiosDesdeEntidad(List<JugadorEntidad> entidades) 
	{
		return entidades.stream().map(obtenerJugadorEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public JugadorEntidad ensamblarEntidadDesdeDominio(JugadorDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar una Entidad de Jugador a partir de un dominio de un Jugador que esta nulo");
		}
		
		return JugadorEntidad.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getCorreo(), dominio.getClave());
	}

	@Override
	public List<JugadorEntidad> ensamblarEntidadesDesdeDominio(List<JugadorDominio> dominios) 
	{
		return dominios.stream().map(obtenerJugadorEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public JugadorDominio ensamblarDominioDesdeDTO(JugadorDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Jugador a partir de un DTO de un Jugador que esta nulo");
		}
		
		return JugadorDominio.crear(dto.getCodigo(), dto.getNombre(), dto.getApellidos(), dto.getCorreo(), dto.getClave());
	}

	@Override
	public List<JugadorDominio> ensamblarDominiosDesdeDTO(List<JugadorDTO> dtos) 
	{
		return dtos.stream().map(obtenerJugadorEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public JugadorDTO ensamblarDTODesdeDominio(JugadorDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un DTO de Jugador a partir de un Dominio de un Jugador que esta nulo");
		}
		
		return JugadorDTO.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getCorreo(), dominio.getClave());
	}

	@Override
	public List<JugadorDTO> ensamblarDTOsDesdeDominio(List<JugadorDominio> dominios) 
	{
		return dominios.stream().map(obtenerJugadorEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}