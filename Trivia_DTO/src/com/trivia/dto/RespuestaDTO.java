package com.trivia.dto;

import com.trivia.transversal.utilitario.UtilTexto;

public class RespuestaDTO 
{
	private int codigo;
	private String descripcion;
	private boolean esCorrecta;
	private PreguntaDTO pregunta;
	
	private RespuestaDTO(int codigo, String descripcion, boolean esCorrecta, PreguntaDTO pregunta) 
	{
		setCodigo(codigo);
		setDescripcion(descripcion);
		setEsCorrecta(esCorrecta);
		setPregunta(pregunta);
	}
	
	public static RespuestaDTO crear(int codigo, String descripcion, boolean esCorrecta, PreguntaDTO pregunta)
	{
		return new RespuestaDTO(codigo, descripcion, esCorrecta, pregunta);
	}
	
	public static RespuestaDTO crear()
	{
		return new RespuestaDTO(0, UtilTexto.BLANCO, false, PreguntaDTO.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public RespuestaDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public RespuestaDTO setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public boolean isEsCorrecta() 
	{
		return esCorrecta;
	}

	public RespuestaDTO setEsCorrecta(boolean esCorrecta) 
	{
		this.esCorrecta = esCorrecta;
		return this;
	}

	public PreguntaDTO getPregunta() 
	{
		return pregunta;
	}

	public RespuestaDTO setPregunta(PreguntaDTO pregunta) 
	{
		this.pregunta = pregunta;
		return this;
	}
}