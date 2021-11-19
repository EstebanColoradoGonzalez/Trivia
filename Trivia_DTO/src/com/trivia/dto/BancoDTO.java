package com.trivia.dto;

import java.util.ArrayList;
import java.util.List;

public class BancoDTO 
{
	private int codigo;
	private List<PreguntaDTO> preguntas;
	
	private BancoDTO(int codigo, List<PreguntaDTO> preguntas) 
	{
		setCodigo(codigo);
		setPreguntas(preguntas);
	}
	
	public static BancoDTO crear(int codigo, List<PreguntaDTO> preguntas)
	{
		return new BancoDTO(codigo, preguntas);
	}
	
	public static BancoDTO crear()
	{
		return new BancoDTO(0, new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public BancoDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public List<PreguntaDTO> getPreguntas() 
	{
		return preguntas;
	}

	public BancoDTO setPreguntas(List<PreguntaDTO> preguntas) 
	{
		this.preguntas = preguntas;
		return this;
	}
}