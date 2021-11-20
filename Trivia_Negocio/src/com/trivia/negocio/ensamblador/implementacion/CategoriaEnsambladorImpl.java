package com.trivia.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import com.trivia.dto.CategoriaDTO;
import com.trivia.entidad.CategoriaEntidad;
import com.trivia.negocio.dominio.CategoriaDominio;
import com.trivia.negocio.ensamblador.CategoriaEnsamblador;
import com.trivia.transversal.excepcion.TriviaNegocioExcepcion;
import com.trivia.transversal.utilitario.UtilObjeto;

public class CategoriaEnsambladorImpl implements CategoriaEnsamblador
{
	private static final CategoriaEnsamblador INSTANCIA = new CategoriaEnsambladorImpl();

	private CategoriaEnsambladorImpl()
	{
		
	}
	
	public static CategoriaEnsamblador obtenerCategoriaEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public CategoriaDominio ensamblarDominioDesdeEntidad(CategoriaEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Categoria a partir de una entidad de un Categoria que esta nulo");
		}
		
		return CategoriaDominio.crear(entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public List<CategoriaDominio> ensamblarDominiosDesdeEntidad(List<CategoriaEntidad> entidades) 
	{
		return entidades.stream().map(obtenerCategoriaEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public CategoriaEntidad ensamblarEntidadDesdeDominio(CategoriaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar una Entidad de Categoria a partir de un dominio de un Categoria que esta nulo");
		}
		
		return CategoriaEntidad.crear(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public List<CategoriaEntidad> ensamblarEntidadesDesdeDominio(List<CategoriaDominio> dominios) 
	{
		return dominios.stream().map(obtenerCategoriaEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public CategoriaDominio ensamblarDominioDesdeDTO(CategoriaDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un Dominio de Categoria a partir de un DTO de un Categoria que esta nulo");
		}
		
		return CategoriaDominio.crear(dto.getCodigo(), dto.getNombre());
	}

	@Override
	public List<CategoriaDominio> ensamblarDominiosDesdeDTO(List<CategoriaDTO> dtos) 
	{
		return dtos.stream().map(obtenerCategoriaEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public CategoriaDTO ensamblarDTODesdeDominio(CategoriaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new TriviaNegocioExcepcion("No es posible ensamblar un DTO de Categoria a partir de un Dominio de un Categoria que esta nulo");
		}
		
		return CategoriaDTO.crear(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public List<CategoriaDTO> ensamblarDTOsDesdeDominio(List<CategoriaDominio> dominios) 
	{
		return dominios.stream().map(obtenerCategoriaEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}
