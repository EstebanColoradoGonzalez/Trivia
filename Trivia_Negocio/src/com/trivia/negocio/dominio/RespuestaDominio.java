package com.trivia.negocio.dominio;

import com.trivia.transversal.utilitario.UtilTexto;

public class RespuestaDominio 
{
	private int codigo;
	private String descripcion;
	private boolean esCorrecta;
	private PreguntaDominio pregunta;
	
	private RespuestaDominio(int codigo, String descripcion, boolean esCorrecta, PreguntaDominio pregunta) 
	{
		setCodigo(codigo);
		setDescripcion(descripcion);
		setEsCorrecta(esCorrecta);
		setPregunta(pregunta);
	}
	
	public static RespuestaDominio crear(int codigo, String descripcion, boolean esCorrecta, PreguntaDominio pregunta)
	{
		return new RespuestaDominio(codigo, descripcion, esCorrecta, pregunta);
	}
	
	public static RespuestaDominio crear()
	{
		return new RespuestaDominio(0, UtilTexto.BLANCO, false, PreguntaDominio.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public RespuestaDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public RespuestaDominio setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public boolean isEsCorrecta() 
	{
		return esCorrecta;
	}

	public RespuestaDominio setEsCorrecta(boolean esCorrecta) 
	{
		this.esCorrecta = esCorrecta;
		return this;
	}

	public PreguntaDominio getPregunta() 
	{
		return pregunta;
	}

	public RespuestaDominio setPregunta(PreguntaDominio pregunta) 
	{
		this.pregunta = pregunta;
		return this;
	}
}