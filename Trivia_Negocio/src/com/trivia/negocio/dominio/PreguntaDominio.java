package com.trivia.negocio.dominio;

import java.util.ArrayList;
import java.util.List;
import com.trivia.transversal.utilitario.UtilTexto;

public class PreguntaDominio 
{
	private int codigo;
	private String descripcion;
	private CategoriaDominio categoria;
	private List<RespuestaDominio> respuestas;
	
	private PreguntaDominio(int codigo, String descripcion, CategoriaDominio categoria, List<RespuestaDominio> respuestas) 
	{
		setCodigo(codigo);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setRespuestas(respuestas);
	}
	
	public static PreguntaDominio crear(int codigo, String descripcion, CategoriaDominio categoria, List<RespuestaDominio> respuestas)
	{
		return new PreguntaDominio(codigo, descripcion, categoria, respuestas);
	}
	
	public static PreguntaDominio crear()
	{
		return new PreguntaDominio(0, UtilTexto.BLANCO, CategoriaDominio.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PreguntaDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public PreguntaDominio setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public CategoriaDominio getCategoria() 
	{
		return categoria;
	}

	public PreguntaDominio setCategoria(CategoriaDominio categoria) 
	{
		this.categoria = categoria;
		return this;
	}

	public List<RespuestaDominio> getRespuestas() 
	{
		return respuestas;
	}

	public PreguntaDominio setRespuestas(List<RespuestaDominio> respuestas) 
	{
		this.respuestas = respuestas;
		return this;
	}
}