package com.trivia.dto;

import java.util.ArrayList;
import java.util.List;
import com.trivia.transversal.utilitario.UtilTexto;

public class PreguntaDTO 
{
	private int codigo;
	private String descripcion;
	private CategoriaDTO categoria;
	private List<RespuestaDTO> respuestas;
	
	private PreguntaDTO(int codigo, String descripcion, CategoriaDTO categoria, List<RespuestaDTO> respuestas) 
	{
		setCodigo(codigo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setRespuestas(respuestas);
	}
	
	public static PreguntaDTO crear(int codigo, String descripcion, CategoriaDTO categoria, List<RespuestaDTO> respuestas)
	{
		return new PreguntaDTO(codigo, descripcion, categoria, respuestas);
	}
	
	public static PreguntaDTO crear()
	{
		return new PreguntaDTO(0, UtilTexto.BLANCO, CategoriaDTO.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PreguntaDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public PreguntaDTO setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public CategoriaDTO getCategoria() 
	{
		return categoria;
	}

	public PreguntaDTO setCategoria(CategoriaDTO categoria) 
	{
		this.categoria = categoria;
		return this;
	}

	public List<RespuestaDTO> getRespuestas() 
	{
		return respuestas;
	}

	public PreguntaDTO setRespuestas(List<RespuestaDTO> respuestas) 
	{
		this.respuestas = respuestas;
		return this;
	}
}