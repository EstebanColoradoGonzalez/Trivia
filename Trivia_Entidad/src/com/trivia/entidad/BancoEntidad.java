package com.trivia.entidad;

import java.util.ArrayList;
import java.util.List;

public class BancoEntidad 
{
	private int codigo;
	private List<PreguntaEntidad> preguntas;
	
	private BancoEntidad(int codigo, List<PreguntaEntidad> preguntas) 
	{
		setCodigo(codigo);
		setPreguntas(preguntas);
	}
	
	public static BancoEntidad crear(int codigo, List<PreguntaEntidad> preguntas)
	{
		return new BancoEntidad(codigo, preguntas);
	}
	
	public static BancoEntidad crear()
	{
		return new BancoEntidad(0, new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public BancoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public List<PreguntaEntidad> getPreguntas() 
	{
		return preguntas;
	}

	public BancoEntidad setPreguntas(List<PreguntaEntidad> preguntas) 
	{
		this.preguntas = preguntas;
		return this;
	}
}