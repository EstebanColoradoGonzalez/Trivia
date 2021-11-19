package com.trivia.entidad;

import java.util.ArrayList;
import java.util.List;
import com.trivia.transversal.utilitario.UtilTexto;

public class PreguntaEntidad 
{
	private int codigo;
	private String descripcion;
	private CategoriaEntidad categoria;
	private List<RespuestaEntidad> respuestas;
	
	private PreguntaEntidad(int codigo, String descripcion, CategoriaEntidad categoria, List<RespuestaEntidad> respuestas) 
	{
		setCodigo(codigo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setRespuestas(respuestas);
	}
	
	public static PreguntaEntidad crear(int codigo, String descripcion, CategoriaEntidad categoria, List<RespuestaEntidad> respuestas)
	{
		return new PreguntaEntidad(codigo, descripcion, categoria, respuestas);
	}
	
	public static PreguntaEntidad crear()
	{
		return new PreguntaEntidad(0, UtilTexto.BLANCO, CategoriaEntidad.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PreguntaEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public PreguntaEntidad setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public CategoriaEntidad getCategoria() 
	{
		return categoria;
	}

	public PreguntaEntidad setCategoria(CategoriaEntidad categoria) 
	{
		this.categoria = categoria;
		return this;
	}

	public List<RespuestaEntidad> getRespuestas() 
	{
		return respuestas;
	}

	public PreguntaEntidad setRespuestas(List<RespuestaEntidad> respuestas) 
	{
		this.respuestas = respuestas;
		return this;
	}
}