package com.trivia.entidad;

import com.trivia.transversal.utilitario.UtilTexto;

public class RespuestaEntidad 
{
	private int codigo;
	private String descripcion;
	private boolean esCorrecta;
	private PreguntaEntidad pregunta;
	
	private RespuestaEntidad(int codigo, String descripcion, boolean esCorrecta, PreguntaEntidad pregunta) 
	{
		setCodigo(codigo);
		setDescripcion(descripcion);
		setEsCorrecta(esCorrecta);
		setPregunta(pregunta);
	}
	
	public static RespuestaEntidad crear(int codigo, String descripcion, boolean esCorrecta, PreguntaEntidad pregunta)
	{
		return new RespuestaEntidad(codigo, descripcion, esCorrecta, pregunta);
	}
	
	public static RespuestaEntidad crear()
	{
		return new RespuestaEntidad(0, UtilTexto.BLANCO, false, PreguntaEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public RespuestaEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public RespuestaEntidad setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public boolean isEsCorrecta() 
	{
		return esCorrecta;
	}

	public RespuestaEntidad setEsCorrecta(boolean esCorrecta) 
	{
		this.esCorrecta = esCorrecta;
		return this;
	}

	public PreguntaEntidad getPregunta() 
	{
		return pregunta;
	}

	public RespuestaEntidad setPregunta(PreguntaEntidad pregunta) 
	{
		this.pregunta = pregunta;
		return this;
	}
}