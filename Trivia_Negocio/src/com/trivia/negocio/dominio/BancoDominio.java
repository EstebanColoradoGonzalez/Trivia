package com.trivia.negocio.dominio;

import java.util.ArrayList;
import java.util.List;

public class BancoDominio 
{
	private int codigo;
	private List<PreguntaDominio> preguntas;
	
	private BancoDominio(int codigo, List<PreguntaDominio> preguntas) 
	{
		setCodigo(codigo);
		setPreguntas(preguntas);
	}
	
	public static BancoDominio crear(int codigo, List<PreguntaDominio> preguntas)
	{
		return new BancoDominio(codigo, preguntas);
	}
	
	public static BancoDominio crear()
	{
		return new BancoDominio(0, new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public BancoDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public List<PreguntaDominio> getPreguntas() 
	{
		return preguntas;
	}

	public BancoDominio setPreguntas(List<PreguntaDominio> preguntas) 
	{
		this.preguntas = preguntas;
		return this;
	}
}